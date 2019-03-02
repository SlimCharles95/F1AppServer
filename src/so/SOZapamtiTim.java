/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Tim;

/**
 *
 * @author Ivan
 */
public class SOZapamtiTim extends OpstaSO {
  private Tim tim;
    public SOZapamtiTim(Object object) {
        super(object);
    }


    @Override
    protected void proveriPreduslov() throws Exception {
        
        tim=(Tim)objekat;
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        db.insert(tim);
    }   
}
