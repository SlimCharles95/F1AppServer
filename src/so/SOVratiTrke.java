/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import domen.Tim;
import domen.Trka;
import domen.Ucesce;
import java.util.ArrayList;

/**
 *
 * @author Ivan
 */
public class SOVratiTrke extends OpstaSO{
private ArrayList<Trka> listaTrka;
private ArrayList<OpstiDomenskiObjekat> rezultat;

    @Override
    protected void proveriPreduslov() throws Exception {
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
       listaTrka = (ArrayList<Trka>) db.select(new Trka());
     /*   for (OpstiDomenskiObjekat opstiDomenskiObjekat : rezultat) {
         listaTrka.add((Trka) opstiDomenskiObjekat);   
        }*/
    }

    public ArrayList<Trka> getListaTrka() {
return listaTrka;
    }

    
}
