/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Ivan
 */
public class UcitavanjePodesavanja {
    private static UcitavanjePodesavanja instance;
    
    private Properties properties;
    FileInputStream fis;
    private UcitavanjePodesavanja() throws FileNotFoundException, IOException {
        ucitajProperties();
    }
    
    public static UcitavanjePodesavanja getInstance() throws IOException {
        if (instance == null) {
            instance = new UcitavanjePodesavanja();
        }
        return instance;
    }
    

    private void ucitajProperties() throws FileNotFoundException, IOException {
        fis = new FileInputStream("settings.properties");
        properties = new Properties();
        properties.load(fis);
    }

    public String getProperty(String kljuc) {
        return properties.getProperty(kljuc, "n/a");
    }
    public void setProperty(String kljuc,String vrednost) throws IOException{
    fis.close();
     FileOutputStream fos = new FileOutputStream("settings.properties");
    properties.setProperty(kljuc, vrednost);
    properties.store(fos, vrednost);
    fos.close();
    }
}
