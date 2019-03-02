/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Nalog;

/**
 *
 * @author Ivan
 */
public class SOZapamtiNalog extends OpstaSO{
    private Nalog nalog;
    public SOZapamtiNalog(Object object) {
        super(object);
    }


    @Override
    protected void proveriPreduslov() throws Exception {
        
        nalog=(Nalog)objekat;
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        db.insert(nalog);
    }
}
