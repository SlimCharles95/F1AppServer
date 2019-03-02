/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.IzvestajIncidenta;
import domen.Trka;
import domen.Ucesce;
import java.util.ArrayList;

/**
 *
 * @author Ivan
 */
public class SOVratiIzvestajeIncidenata extends OpstaSO{
Trka t;
private ArrayList<IzvestajIncidenta> listaUkupno;
private ArrayList<IzvestajIncidenta> listaOdgovarajuci=new ArrayList<>();
    public SOVratiIzvestajeIncidenata(Trka t) {
super(t);
    }

 
    @Override
    protected void proveriPreduslov() throws Exception {
    t = (Trka)objekat;
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        listaUkupno = (ArrayList<IzvestajIncidenta>) db.select(new IzvestajIncidenta());
        for (IzvestajIncidenta izvestaj : listaUkupno) {
            if(izvestaj.getTrkaID()==t.getTrkaID())
                listaOdgovarajuci.add(izvestaj);   
        }
     
    }

   

    public ArrayList<IzvestajIncidenta> getListaIzvestajaIncidenata() {
return listaOdgovarajuci;
    }
    
   
}
