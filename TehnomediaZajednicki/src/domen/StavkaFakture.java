/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Bojana
 */
public class StavkaFakture extends AbstractObjekat {

    private Faktura faktura;
    private int RB;
    private int kolicina;
    private double vrednost;
    private Proizvod proizvod;

    private String stanje;

    public StavkaFakture() {
    }

    public StavkaFakture(Faktura faktura,int RB, int kolicina, double vrednost, Proizvod proizvod) {
        this.RB = RB;
        this.faktura = faktura;
        this.kolicina = kolicina;
        this.vrednost = vrednost;
        this.proizvod = proizvod;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getVrednost() {
        return vrednost;
    }

    public void setVrednost(double vrednost) {
        this.vrednost = vrednost;
    }

    public Faktura getFaktura() {
        return faktura;
    }

    public void setFaktura(Faktura faktura) {
        this.faktura = faktura;
    }

    public int getRB() {
        return RB;
    }

    public void setRB(int RB) {
        this.RB = RB;
    }

    public String getStanje() {
        return stanje;
    }

    public void setStanje(String stanje) {
        this.stanje = stanje;
    }

    @Override
    public String vratiImeTabele() {

        return "stavkafakture";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s', '%s', '%s'", faktura.getFakturaID(),RB , kolicina, vrednost, proizvod.getProizvodID());
    }

    @Override
    public String vratiPK() {

        return null;
    }

    @Override
    public String vratiVrednostPK() {
        return null;
    }

    @Override
    public String vratiSlozenPK() {

        return String.format(" fakturaID='%s' AND RB='%s' ", faktura.getFakturaID(),RB);
    }

    @Override
    public List<AbstractObjekat> RSuTabelu(ResultSet rs) {

        List<AbstractObjekat> stavke = new ArrayList<>();
        try {
            while (rs.next()) {
                int RB = rs.getInt("RB");
                int fakturaID = rs.getInt("fakturaID");
                int kolicina = rs.getInt("kolicina");
                double vrednost = rs.getDouble("vrednost");
                int proizvodID = rs.getInt("proizvodID");

                StavkaFakture sf = new StavkaFakture( new Faktura(fakturaID + ""),RB, kolicina, vrednost, new Proizvod(proizvodID + ""));

                stavke.add(sf);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Greska kod RSuTabelu za StavkaFakture");
        }
        return stavke;
    }

    @Override
    public String vratiUpdate() {

        return String.format("fakturaID='%s', RB='%s', kolicina='%s', vrednost='%s', proizvodID='%s'", faktura.getFakturaID(),RB, kolicina, vrednost, proizvod.getProizvodID());
    }

    @Override
    public void postaviVrednostPK(String pk) {
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StavkaFakture other = (StavkaFakture) obj;
        if (this.RB != other.RB) {
            return false;
        }
        if (!Objects.equals(this.faktura, other.faktura)) {
            return false;
        }
        return true;
    }

}
