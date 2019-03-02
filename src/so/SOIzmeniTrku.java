/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Trka;
import domen.Ucesce;
import java.util.ArrayList;

/**
 *
 * @author Ivan
 */
public class SOIzmeniTrku extends OpstaSO{
 //private Trka trka;
   private ArrayList<Ucesce> ucescaTrke;

    public SOIzmeniTrku( ArrayList<Ucesce> ucescaRezultati) {
super(ucescaRezultati);
    }

   
   

    @Override
    protected void proveriPreduslov() throws Exception {
//trka=(Trka)objekat;
ucescaTrke=(ArrayList<Ucesce>) objekat;
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        for (Ucesce ucesce : ucescaTrke) {
                    db.update(ucesce);
                             db.update(ucesce.getVozac());

        }

    }
    
}
