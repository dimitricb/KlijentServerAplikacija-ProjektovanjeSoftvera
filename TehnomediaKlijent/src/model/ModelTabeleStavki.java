/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.AbstractObjekat;
import domen.Faktura;
import domen.Proizvod;
import domen.StavkaFakture;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bojana
 */
public class ModelTabeleStavki extends AbstractTableModel{

    List<AbstractObjekat> lista = new ArrayList<>();
     List<AbstractObjekat> originalnaLista = new ArrayList<>();
    JTextField txtIznos;

    String[] kolone = {"RB","Naziv", "Cena", "Kolicina","Iznos"};
    
   
    public ModelTabeleStavki(List<AbstractObjekat> lista) {
        this.lista = lista;
       
    }

    public ModelTabeleStavki() {
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
        StavkaFakture sf = (StavkaFakture) lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sf.getRB();
            case 1:
                return sf.getProizvod().getNazivProizvoda();
            case 2:
                return sf.getProizvod().getCena();
            case 3:
                return sf.getKolicina();
            case 4:
                return sf.getVrednost();
            default:
                return "return!";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        StavkaFakture stavka = (StavkaFakture) lista.get(rowIndex);
        String kol = (String) aValue;
        try {
            int kolicina = Integer.parseInt(kol);
            stavka.setKolicina(kolicina);
            stavka.setVrednost(stavka.getProizvod().getCena() * kolicina);
            postaviIznos();
            fireTableDataChanged();
        } catch (NumberFormatException nfe) {
            return;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 3) {
            return true;
        }
        return false;
    }
    
    
    public void dodajStavku(Proizvod proizvod, Faktura f) {
        StavkaFakture stavka = daLiPostoji(proizvod);
        if (stavka != null) {
            int kolicina = stavka.getKolicina() + 1;
            double iznos = proizvod.getCena() * kolicina;
            stavka.setKolicina(kolicina);
            stavka.setVrednost(iznos);
            
        } else {
            stavka = new StavkaFakture(f,lista.size() + 1, 1, proizvod.getCena(), proizvod);
            lista.add(stavka);
        }
        postaviIznos();
        fireTableDataChanged();
    }

    public List<AbstractObjekat> getLista() {
        return lista;
    }

    
    private void postaviIznos() {
        double iznosN = 0.0;
        for (AbstractObjekat abstractObjekat : lista) {
            StavkaFakture stavka = (StavkaFakture) abstractObjekat;
            iznosN += stavka.getVrednost();
        }
        this.txtIznos.setText(iznosN + "");
    }

    private StavkaFakture daLiPostoji(Proizvod p) {
        for (AbstractObjekat abstractObjekat : lista) {
            StavkaFakture sn = (StavkaFakture) abstractObjekat;
            if (sn.getProizvod().equals(p)) {
                return sn;
            }
        }
        return null;
    }

    public void izbaciStavku(int red) {

        lista.remove(red);
        postaviIznos();
    }

    public void postaviRB() {

          int rb = 1;
        for (AbstractObjekat abstractObjekat : lista) {
            StavkaFakture sf = (StavkaFakture) abstractObjekat;
            sf.setRB(rb);
            rb++;
        }
        fireTableDataChanged();
        
    
    }
     public void setTxtIznos(JTextField txtIznos) {
        this.txtIznos = txtIznos;
    }

     
    public void setLista(List<AbstractObjekat> lista) {
        this.lista = lista;
    }

     public void popuniOriginalnuListu(List<AbstractObjekat> lista) {
        for (AbstractObjekat abstractObjekat : lista) {
            StavkaFakture sf = (StavkaFakture) abstractObjekat;
            originalnaLista.add(abstractObjekat);
        }
    }

    public List<AbstractObjekat> getOriginalnaLista() {
        return originalnaLista;
    }
}
