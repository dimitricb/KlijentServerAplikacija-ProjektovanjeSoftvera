/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Bojana
 */
public class Faktura extends AbstractObjekat {

    private String fakturaID;
    private Date datum;
    private double iznosZaPlacanje;
    private List<AbstractObjekat> listaStavki;
    private RukovodilacSektoraNabavke rukovodilacSektoraNabavke;
    private Kompanija kompanija;

    public Faktura() {
    }

    public Faktura(String fakturaID, Date datum, double iznosZaPlacanje, RukovodilacSektoraNabavke rukovodilacSektoraNabavke, Kompanija kompanija) {
        this.fakturaID = fakturaID;
        this.datum = datum;
        this.iznosZaPlacanje = iznosZaPlacanje;
        this.listaStavki = new ArrayList<>();
        this.rukovodilacSektoraNabavke = rukovodilacSektoraNabavke;
        this.kompanija = kompanija;
    }

    public Faktura(String fakturaID) {
        this.fakturaID = fakturaID;
    }

    public Kompanija getKompanija() {
        return kompanija;
    }

    public void setKompanija(Kompanija kompanija) {
        this.kompanija = kompanija;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getIznosZaPlacanje() {
        return iznosZaPlacanje;
    }

    public void setIznosZaPlacanje(double iznosZaPlacanje) {
        this.iznosZaPlacanje = iznosZaPlacanje;
    }

    public List<AbstractObjekat> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(List<AbstractObjekat> listaStavki) {
        this.listaStavki = listaStavki;
    }

    public RukovodilacSektoraNabavke getRukovodilacSektoraNabavke() {
        return rukovodilacSektoraNabavke;
    }

    public void setRukovodilacSektoraNabavke(RukovodilacSektoraNabavke rukovodilacSektoraNabavke) {
        this.rukovodilacSektoraNabavke = rukovodilacSektoraNabavke;
    }

    @Override
    public String vratiImeTabele() {

        return "faktura";
    }

    @Override
    public String vratiParametre() {

        java.sql.Date datumFak = new java.sql.Date(datum.getTime());
        return String.format("'%s', '%s', '%s', '%s', '%s'", fakturaID, datumFak, iznosZaPlacanje,rukovodilacSektoraNabavke.getRukovodilacID(),kompanija.getKompanijaID());
    }

    @Override
    public String vratiPK() {

        return "fakturaID";
    }

    @Override
    public String vratiVrednostPK() {

        return fakturaID;
    }

    @Override
    public String vratiSlozenPK() {
        return null;
    }

    @Override
    public List<AbstractObjekat> RSuTabelu(ResultSet rs) {

        List<AbstractObjekat> fakture = new ArrayList<>();
        try {
            while (rs.next()) {
                int fakturaID = rs.getInt("fakturaID");
                Date datum = rs.getDate("datum");
                double iznosZaPlacanje = rs.getDouble("iznosZaPlacanje");
                int kompanijaID = rs.getInt("kompanijaID");
                int rukovodilacID = rs.getInt("rukovodilacID");

                Faktura f = new Faktura(fakturaID+"", datum, iznosZaPlacanje, new RukovodilacSektoraNabavke(rukovodilacID + ""), new Kompanija(kompanijaID + ""));

                fakture.add(f);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Greska kod RSuTabelu za Faktura");
        }
        return fakture;
    }

    @Override
    public String vratiUpdate() {

        java.sql.Date datumSQL = new java.sql.Date(datum.getTime());
        return String.format("fakturaID='%s', datum='%s', iznosZaPlacanje='%s', rukovodilacID='%s',kompanijaID='%s'", fakturaID, datumSQL, iznosZaPlacanje, rukovodilacSektoraNabavke.getRukovodilacID(), kompanija.getKompanijaID());

    }

    @Override
    public String toString() {
        return "FakturaID: " + fakturaID + "\nDatum: " + datum + "\nIznosZaPlacanje:" + iznosZaPlacanje;
    }

    @Override
    public void postaviVrednostPK(String pk) {

        this.fakturaID = pk;
    }

    public String getFakturaID() {
        return fakturaID;
    }

    public void setFakturaID(String fakturaID) {
        this.fakturaID = fakturaID;
    }

}
