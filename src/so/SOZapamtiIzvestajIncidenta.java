/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.IzvestajIncidenta;

/**
 *
 * @author Ivan
 */
public class SOZapamtiIzvestajIncidenta extends OpstaSO{
private IzvestajIncidenta izvestajIncidnta;

    public SOZapamtiIzvestajIncidenta(IzvestajIncidenta ii) {
super(ii);
    }
    


    @Override
    protected void proveriPreduslov() throws Exception {
        
        izvestajIncidnta=(IzvestajIncidenta) objekat;
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        db.insert(izvestajIncidnta);
    }   
   
    
}
