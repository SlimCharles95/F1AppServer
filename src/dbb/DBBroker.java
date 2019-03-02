/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbb;

import domen.Nalog;
import domen.OpstiDomenskiObjekat;
import domen.Tim;
import domen.Trka;
import domen.Ucesce;
import domen.Vozac;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.SpringLayout;
import server.ServerskaTabelaKlasa;

/**
 *
 * @author Ivan
 */
public class DBBroker {
     private Connection connection;

    public void ucitajDriver() throws Exception {
        try {
            Class.forName(UcitavanjePodesavanja.getInstance().getProperty("driver"));
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new Exception("Neodgovarajuci driver!" + ex.getMessage());
        }
    }

    public void otvoriKonekciju() throws Exception {
        try {
            String url = UcitavanjePodesavanja.getInstance().getProperty("url");
            String user = UcitavanjePodesavanja.getInstance().getProperty("username");
            String password = UcitavanjePodesavanja.getInstance().getProperty("password");
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false); 
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Konekcija nije uspostavljena!" + ex.getMessage());
        }
    }

    public void zatvoriKonekciju() throws Exception {
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Konekcija nije zatvorena! " + ex.getMessage());
        }
    }

    public void commitTransakcije() throws Exception {
        try {
            connection.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Neuspesan commit transakcije! " + ex.getMessage());
        }
    }

    public void rollbackTransakcije() throws Exception {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Neuspesan rollback transakcije! " + ex.getMessage());
        }
    }

  
    public void insert(OpstiDomenskiObjekat odo) throws SQLException{
        String sql = "INSERT INTO "+odo.vratiImeKlase()+""+odo.vratiAtributeKlase()+" values"+odo.vratiVrednostiAtributa()+"";
        Statement s = connection.createStatement();
        s.executeUpdate(sql);
    }
    public void update(OpstiDomenskiObjekat odo) throws SQLException{
        String sql = "Update "+odo.vratiImeKlase()+" set "+odo.postaviVrednostiAtributa()+""+odo.vratiUslovIzmene()+"";
        Statement s = connection.createStatement();
        s.executeUpdate(sql);
    }
    public void delete(OpstiDomenskiObjekat odo) throws SQLException{
        String sql = "Delete from "+odo.vratiImeKlase()+" "+odo.vratiUslovBrisanja()+ "";
        Statement s = connection.createStatement();
        s.executeUpdate(sql);
    
    }
    public ArrayList<?> select(OpstiDomenskiObjekat odo) throws SQLException{
        String sql = "Select "+odo.vratiAtributePretrage()+" from "+odo.vratiTabeluPretrage()+" "+odo.vratiUslovPretrage()+ "";
        Statement s = connection.createStatement();
        ResultSet rs=s.executeQuery(sql); 
        ArrayList<?> rezultat=odo.napuni(rs);
        return rezultat;
    }
    }
    


