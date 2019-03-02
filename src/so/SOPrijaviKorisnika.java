/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Nalog;
import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;

/**
 *
 * @author Ivan
 */
public class SOPrijaviKorisnika extends OpstaSO {
private Nalog nalog;
private Nalog ulogovani=null;
private ArrayList<Nalog> lista;
    public SOPrijaviKorisnika(Object object) {
        super(object);
    }

    @Override
    protected void proveriPreduslov() throws Exception {
nalog=(Nalog) objekat;

    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
lista=(ArrayList<Nalog>) db.select(nalog);
if(!lista.isEmpty())ulogovani=(Nalog) lista.get(0);
    }

    public Nalog getNalog() {
        return nalog;
    }

    public Nalog getUlogovani() {
        return ulogovani;
    }
    
}
