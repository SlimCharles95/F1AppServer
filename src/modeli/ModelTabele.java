/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;


import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import server.ServerskaTabelaKlasa;

/**
 *
 * @author Ivan
 */
public class ModelTabele extends AbstractTableModel{
ArrayList<ServerskaTabelaKlasa> lista;
    public ModelTabele(ArrayList<ServerskaTabelaKlasa> lista) {
        this.lista=lista;
    }

    

    @Override
    public int getRowCount() {
return lista.size();
    }

    @Override
    public int getColumnCount() {
return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
ServerskaTabelaKlasa stk=lista.get(rowIndex);
switch(columnIndex){
    case 0: return stk.getKorisnik();
    case 1: return stk.getBrojUcesca();
    case 2: return stk.getBrojTrka();
    default: return "n/a";
}
    }

    @Override
    public String getColumnName(int column) {
switch(column){
    case 0: return "Korisnik";
    case 1: return "Unetih učešća";
    case 2: return "Kreiranih trka";
    default: return "n/a";
}
    }
    
    
    
}
