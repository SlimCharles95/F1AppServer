/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Vozac;

/**
 *
 * @author Ivan
 */
public class SOZapamtiVozaca extends OpstaSO{
   private Vozac vozac;
    public SOZapamtiVozaca(Vozac vozac) {
        super(vozac);
    }


    @Override
    protected void proveriPreduslov() throws Exception {
        
        vozac=(Vozac)objekat;
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        db.insert(vozac);
    }    
}
