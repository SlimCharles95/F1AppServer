/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import domen.Tim;
import domen.Vozac;
import java.util.ArrayList;

/**
 *
 * @author Ivan
 */
public class SOVratiVozace extends OpstaSO{
    private ArrayList<Vozac> listaVozaca;
private ArrayList<OpstiDomenskiObjekat> rezultat;
    @Override
    protected void proveriPreduslov() throws Exception {
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
         
        listaVozaca = (ArrayList<Vozac>) db.select(new Vozac());
      /*  for (OpstiDomenskiObjekat opstiDomenskiObjekat : rezultat) {
         listaVozaca.add((Vozac) opstiDomenskiObjekat);   
        }*/
    }

    public ArrayList<Vozac> getListaVozaca() {
        return listaVozaca;
    }
    
}
