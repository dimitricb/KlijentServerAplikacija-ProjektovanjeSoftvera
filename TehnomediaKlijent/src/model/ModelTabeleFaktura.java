/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.AbstractObjekat;
import domen.Faktura;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bojana
 */
public class ModelTabeleFaktura extends AbstractTableModel {

    List<AbstractObjekat> lista = new ArrayList<>();
    String[] kolone = {"Datum", "Iznos za plaćanje", "Rukovodilac sektora nabavke", "Kompanija"};

    public ModelTabeleFaktura(List<AbstractObjekat> lista) {
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
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Faktura f = (Faktura) lista.get(rowIndex);
        switch (columnIndex) {

            case 0:
                return sdf.format(f.getDatum());
            case 1:
                return f.getIznosZaPlacanje();
            case 2:
                return f.getRukovodilacSektoraNabavke().toString();
            case 3:
                return f.getKompanija().toString();
            default:
                return "return!";
        }
    }

    public List<AbstractObjekat> getLista() {
        return lista;
    }

}
