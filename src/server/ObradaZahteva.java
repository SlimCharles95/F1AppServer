/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;


import domen.IzvestajIncidenta;
import domen.Nalog;
import domen.Tim;
import domen.Trka;
import domen.Ucesce;
import domen.Vozac;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import logika.Kontroler;
import transfer.Operacije;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;


/**
 *
 * @author Ivan
 */
public class ObradaZahteva extends Thread{
    Socket s;

    public ObradaZahteva(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        while (true) {            
            TransferObjekatZahtev toz = primiZahtev();
            TransferObjekatOdgovor too = new TransferObjekatOdgovor();
            
                switch(toz.getOperacija()){
                    case Operacije.LOGIN:
                        Nalog nalog=(Nalog) toz.getParametar();
                        Nalog ulogovani=Kontroler.getInstance().prijaviKorisnika(nalog);
                        too.setRezultat(ulogovani);
                        break;
                    case Operacije.ZAPAMTI_NALOG:
                        Nalog noviNalog=(Nalog) toz.getParametar();
                        too=Kontroler.getInstance().zapamtiNalog(noviNalog);
                        break;
                    case Operacije.ZAPAMTI_TIM:
                        Tim tim=(Tim) toz.getParametar();
                        too=Kontroler.getInstance().zapamtiTim(tim);
                        break;
                    case Operacije.VRATI_TIMOVE:
                        ArrayList<Tim> timovi=Kontroler.getInstance().vratiTimove();
                        too.setRezultat(timovi);
                        break;
                     case Operacije.ZAPAMTI_VOZACA:
                        Vozac vozac=(Vozac) toz.getParametar();
                        too=Kontroler.getInstance().zapamtiVozaca(vozac);
                        break;
                    case Operacije.VRATI_VOZACE:
                        ArrayList<Vozac> vozaci=Kontroler.getInstance().vratiVozace();
                        too.setRezultat(vozaci);
                        break;
                     case Operacije.VRATI_TRKE:
                        ArrayList<Trka> trke=Kontroler.getInstance().vratiTrke();
                        too.setRezultat(trke);
                        break;
                     case Operacije.VRATI_UCESCA:
                        Trka t=(Trka) toz.getParametar();
                        ArrayList<Ucesce> ucesca=Kontroler.getInstance().vratiUcesca(t);
                        too.setRezultat(ucesca);
                        break;
                     case Operacije.OBRISI_TRKU:
                        Trka trkaObrisi=(Trka) toz.getParametar();
                         ArrayList<Ucesce> ucescaBrisanje=(ArrayList<Ucesce>) toz.getParametar2();
                        too=Kontroler.getInstance().obrisiTrku(trkaObrisi,ucescaBrisanje);
                        break;
                    case Operacije.ZAPAMTI_TRKU:
                        Trka trka=(Trka) toz.getParametar();
                        ArrayList<Ucesce> ucescaTrke=(ArrayList<Ucesce>) toz.getParametar2();
                        too=Kontroler.getInstance().zapamtiTrku(trka,ucescaTrke);
                        break;
                    case Operacije.IZMENI_TRKU:
                        //Trka trkaIzmena=(Trka) toz.getParametar();
                        ArrayList<Ucesce> ucescaRezultati=(ArrayList<Ucesce>) toz.getParametar2();
                        too=Kontroler.getInstance().izmeniTrku(ucescaRezultati);
                        break;
                    case Operacije.ZAPAMTI_IZVESTAJ:
                        IzvestajIncidenta ii =(IzvestajIncidenta) toz.getParametar();
                        too=Kontroler.getInstance().zapamtiIzvestajIncidenta(ii);
                        break;
                    case Operacije.VRATI_IZVESTAJE:
                        Trka tIzvestaj=(Trka) toz.getParametar();
                        ArrayList<IzvestajIncidenta> izvestaji=Kontroler.getInstance().vratiIzvestaje(tIzvestaj);
                        too.setRezultat(izvestaji);
                        break;
                }
                
                
     
            posaljiOdgovor(too);
        }
    }
    private TransferObjekatZahtev primiZahtev() {
        TransferObjekatZahtev toz = new TransferObjekatZahtev();
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            toz = (TransferObjekatZahtev) ois.readObject();
        } catch (IOException ex) {
            Kontroler.getInstance().getListaKlijenata().remove(s);
            Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            
            Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return toz;
    }

    private void posaljiOdgovor(TransferObjekatOdgovor too) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(too);
        } catch (IOException ex) {
            Kontroler.getInstance().getListaKlijenata().remove(s);
            Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
