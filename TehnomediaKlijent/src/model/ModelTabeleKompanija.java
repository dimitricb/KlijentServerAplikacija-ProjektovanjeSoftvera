/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.AbstractObjekat;
import domen.Kompanija;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bojana
 */
public class ModelTabeleKompanija extends AbstractTableModel {

    List<AbstractObjekat> lista = new ArrayList<>();
    String[] kolone = {"Naziv kompanije", "PIB", "Maticni broj", "Tekuci racun", "Banka"," Grad","Drzava"};
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public ModelTabeleKompanija() {
    }

    public ModelTabeleKompanija(List<AbstractObjekat> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kompanija k = (Kompanija) lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getNazivKompanije();
            case 1:
                return k.getPIB();
            case 2:
                return k.getMaticniBroj();
            case 3:
                return k.getTekuciRacun();
            case 4:
                return k.getBanka();
            case 5:
                return k.getGrad();
            case 6:
                return k.getDrzava();
                
            default:
                return "return!";
        }

    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<AbstractObjekat> getLista() {
        return lista;
    }

    public void setLista(List<AbstractObjekat> lista) {
        this.lista = lista;
    }

}
