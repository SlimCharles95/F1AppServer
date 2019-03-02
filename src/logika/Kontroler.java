/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import dbb.DBBroker;
import domen.IzvestajIncidenta;
import domen.Nalog;
import domen.OpstiDomenskiObjekat;
import domen.Tim;
import domen.Trka;
import domen.Ucesce;
import domen.Vozac;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.ServerskaTabelaKlasa;
import so.SOIzmeniTrku;
import so.SOObrisiTrku;
import so.SOPrijaviKorisnika;
import so.SOVratiIzvestajeIncidenata;
import so.SOVratiTimove;
import so.SOVratiTrke;
import so.SOVratiUcesca;
import so.SOVratiVozace;
import so.SOZapamtiIzvestajIncidenta;
import so.SOZapamtiNalog;
import so.SOZapamtiTim;
import so.SOZapamtiTrku;
import so.SOZapamtiVozaca;
import transfer.TransferObjekatOdgovor;

/**
 *
 * @author Ivan
 */
public class Kontroler {
    private static Kontroler instance;  
    private DBBroker db;
    ArrayList<Socket> listaKlijenata;
    
    private Kontroler() {
        db=new DBBroker();
        listaKlijenata=new ArrayList<>();
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public ArrayList<Socket> getListaKlijenata() {
        return listaKlijenata;
    }

    public Nalog prijaviKorisnika(Nalog nalog)  {
         SOPrijaviKorisnika so=new SOPrijaviKorisnika(nalog);
        try {
            so.opsteIzvrsenjeSO();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
             return null;
        }
         return so.getUlogovani();
    }

    public TransferObjekatOdgovor zapamtiNalog(Nalog noviNalog) {
       TransferObjekatOdgovor too=new TransferObjekatOdgovor();
        try {
            SOZapamtiNalog so=new SOZapamtiNalog(noviNalog);
            so.opsteIzvrsenjeSO();
            too.setRezultat(true);
        } catch (Exception ex) {
            too.setRezultat(false);
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return too;

    }

    public TransferObjekatOdgovor zapamtiTim(Tim tim) {
  TransferObjekatOdgovor too=new TransferObjekatOdgovor();
        try {
            SOZapamtiTim so=new SOZapamtiTim(tim);
            so.opsteIzvrsenjeSO();
            too.setRezultat(true);
        } catch (Exception ex) {
            too.setRezultat(false);
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return too;
    }

    public ArrayList<Tim> vratiTimove() {
       SOVratiTimove so=new SOVratiTimove();
        try {
            so.opsteIzvrsenjeSO();
        } catch (Exception ex) {
            return null;
        }
        return so.getListaTimova();
    }

    public TransferObjekatOdgovor zapamtiVozaca(Vozac vozac) {
 TransferObjekatOdgovor too=new TransferObjekatOdgovor();
        try {
            SOZapamtiVozaca so=new SOZapamtiVozaca(vozac);
            so.opsteIzvrsenjeSO();
            too.setRezultat(true);
        } catch (Exception ex) {
            too.setRezultat(false);
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return too;
    }

    public ArrayList<Vozac> vratiVozace() {
SOVratiVozace so=new SOVratiVozace();
        try {
            so.opsteIzvrsenjeSO();
        } catch (Exception ex) {
            return null;
        }
        return so.getListaVozaca();
    }

    public ArrayList<Trka> vratiTrke() {
SOVratiTrke so=new SOVratiTrke();
        try {
            so.opsteIzvrsenjeSO();
        } catch (Exception ex) {
            return null;
        }
        return so.getListaTrka();
    }

    public ArrayList<Ucesce> vratiUcesca(Trka t) {
SOVratiUcesca so=new SOVratiUcesca(t);
        try {
            so.opsteIzvrsenjeSO();
        } catch (Exception ex) {
            return null;
        }
        return so.getListaUcesca();
    }

    public TransferObjekatOdgovor obrisiTrku(Trka trkaObrisi, ArrayList<Ucesce> ucescaTrke) {
TransferObjekatOdgovor too=new TransferObjekatOdgovor();
        try {
            SOObrisiTrku so=new SOObrisiTrku(trkaObrisi,ucescaTrke);
            so.opsteIzvrsenjeSO();
            too.setRezultat(true);
        } catch (Exception ex) {
            too.setRezultat(false);
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return too;
    }

    public ArrayList<ServerskaTabelaKlasa> vratiStatistiku() {
        ArrayList<ServerskaTabelaKlasa> lista=new ArrayList<>();
                ArrayList<OpstiDomenskiObjekat> rezultat=new ArrayList<>();
        try {
            db.ucitajDriver();
            db.otvoriKonekciju();
            lista= (ArrayList<ServerskaTabelaKlasa>) db.select(new ServerskaTabelaKlasa());
          /* for (OpstiDomenskiObjekat opstiDomenskiObjekat : rezultat) {
         lista.add((ServerskaTabelaKlasa) opstiDomenskiObjekat);   
        }*/
            db.zatvoriKonekciju();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return lista;
    }

    public TransferObjekatOdgovor zapamtiTrku(Trka trka, ArrayList<Ucesce> ucescaTrke) {
TransferObjekatOdgovor too=new TransferObjekatOdgovor();
        try {
            SOZapamtiTrku so=new SOZapamtiTrku(trka,ucescaTrke);
            so.opsteIzvrsenjeSO();
            too.setRezultat(true);
        } catch (Exception ex) {
            too.setRezultat(false);
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return too;
    }

    public TransferObjekatOdgovor izmeniTrku( ArrayList<Ucesce> ucescaRezultati) {
TransferObjekatOdgovor too=new TransferObjekatOdgovor();
        try {
            SOIzmeniTrku so=new SOIzmeniTrku(ucescaRezultati);
            so.opsteIzvrsenjeSO();
            too.setRezultat(true);
        } catch (Exception ex) {
            too.setRezultat(false);
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return too;
    }

    public TransferObjekatOdgovor zapamtiIzvestajIncidenta(IzvestajIncidenta ii) {
    TransferObjekatOdgovor too=new TransferObjekatOdgovor();
        try {
            SOZapamtiIzvestajIncidenta so=new SOZapamtiIzvestajIncidenta(ii);
            so.opsteIzvrsenjeSO();
            too.setRezultat(true);
        } catch (Exception ex) {
            too.setRezultat(false);
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return too;
    }

    public ArrayList<IzvestajIncidenta> vratiIzvestaje(Trka t) {
  SOVratiIzvestajeIncidenata so=new SOVratiIzvestajeIncidenata(t);
        try {
            so.opsteIzvrsenjeSO();
        } catch (Exception ex) {
            return null;
        }
        return so.getListaIzvestajaIncidenata();
    }
    
}
