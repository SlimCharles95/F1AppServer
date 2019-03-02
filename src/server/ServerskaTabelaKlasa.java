/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import domen.OpstiDomenskiObjekat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivan
 */
public class ServerskaTabelaKlasa implements OpstiDomenskiObjekat{
private String korisnik;
private int brojTrka;
private int brojUcesca;

    public ServerskaTabelaKlasa() {
    }

    public ServerskaTabelaKlasa(String korisnik, int brojTrka, int brojUcesca) {
        this.korisnik = korisnik;
        this.brojTrka = brojTrka;
        this.brojUcesca = brojUcesca;
    }

    public int getBrojUcesca() {
        return brojUcesca;
    }

    public void setBrojUcesca(int brojUcesca) {
        this.brojUcesca = brojUcesca;
    }

    public String getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(String korisnik) {
        this.korisnik = korisnik;
    }

    public int getBrojTrka() {
        return brojTrka;
    }

    public void setBrojTrka(int brojTrka) {
        this.brojTrka = brojTrka;
    }

    @Override
    public String vratiVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String postaviVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiImeKlase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiAtributeKlase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovPretrage() {
        return "group by n.KorisnickoIme";
    }

    @Override
    public String vratiUslovIzmene() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovBrisanja() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiTabeluPretrage() {
        return "Ucesce u right join Nalog n on u.NalogID=n.KorisnickoIme";
    }

    @Override
    public String vratiAtributePretrage() {
        return "n.KorisnickoIme,count(DISTINCT u.TrkaID),count(u.TrkaID)";
    }

    @Override
    public ArrayList<ServerskaTabelaKlasa> napuni(ResultSet rs) {
           ArrayList<ServerskaTabelaKlasa> stat = new ArrayList<>();
        try {
        while (rs.next()) {
            int brojTrka=0;
            int brojUcesca=0;
            String korisnik=rs.getString(1);
            brojTrka=rs.getInt(2);
            brojUcesca=rs.getInt(3);
            ServerskaTabelaKlasa stk=new ServerskaTabelaKlasa(korisnik, brojTrka, brojUcesca);
            stat.add(stk);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ServerskaTabelaKlasa.class.getName()).log(Level.SEVERE, null, ex);
    }
            return stat;

    }

}
