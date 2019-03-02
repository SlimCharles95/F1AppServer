/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import domen.Tim;
import java.util.ArrayList;

/**
 *
 * @author Ivan
 */
public class SOVratiTimove extends OpstaSO{
private ArrayList<Tim> listaTimova;
private ArrayList<OpstiDomenskiObjekat> rezultat;

    @Override
    protected void proveriPreduslov() throws Exception {
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        listaTimova = (ArrayList<Tim>) db.select(new Tim());
       /* for (OpstiDomenskiObjekat opstiDomenskiObjekat : rezultat) {
            Tim t=(Tim) opstiDomenskiObjekat;
            listaTimova.add((Tim) opstiDomenskiObjekat); 

        }*/
    }

    public ArrayList<Tim> getListaTimova() {
        return listaTimova;
    }
    
    
}
