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
public class Kompanija extends AbstractObjekat {

    private String kompanijaID;
    private String nazivKompanije;
    private String PIB;
    private String maticniBroj;
    private String tekuciRacun;
    private String banka;
    private String grad;
    private Drzava drzava;

    public Kompanija() {
    }

    public Kompanija(String kompanijaID) {
        this.kompanijaID = kompanijaID;
    }

    public Kompanija(String kompanijaID, String nazivKompanije, String PIB, String maticniBroj, String tekuciRacun, String banka, String grad, Drzava drzava) {
        this.kompanijaID = kompanijaID;
        this.nazivKompanije = nazivKompanije;
        this.PIB = PIB;
        this.maticniBroj = maticniBroj;
        this.tekuciRacun = tekuciRacun;
        this.banka = banka;
        this.grad = grad;
        this.drzava = drzava;
    }

    public Drzava getDrzava() {
        return drzava;
    }

    public void setDrzava(Drzava drzava) {
        this.drzava = drzava;
    }

    public String getKompanijaID() {
        return kompanijaID;
    }

    public void setKompanijaID(String kompanijaID) {
        this.kompanijaID = kompanijaID;
    }

    public String getNazivKompanije() {
        return nazivKompanije;
    }

    public void setNazivKompanije(String nazivKompanije) {
        this.nazivKompanije = nazivKompanije;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getTekuciRacun() {
        return tekuciRacun;
    }

    public void setTekuciRacun(String tekuciRacun) {
        this.tekuciRacun = tekuciRacun;
    }

    @Override
    public String toString() {
        return nazivKompanije;
    }

    @Override
    public String vratiImeTabele() {

        return "kompanija";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s', '%s', '%s','%s', '%s', '%s'", kompanijaID, nazivKompanije, PIB, maticniBroj, tekuciRacun, banka, grad, drzava.getDrzavaID());
    }

    @Override
    public String vratiPK() {
        return "kompanijaID";
    }

    @Override
    public String vratiVrednostPK() {

        return kompanijaID;
    }

    @Override
    public String vratiSlozenPK() {

        return null;
    }

    @Override
    public List<AbstractObjekat> RSuTabelu(ResultSet rs) {

        List<AbstractObjekat> kompanije = new ArrayList<>();

        try {
            while (rs.next()) {
                int kompanijaID = rs.getInt("kompanijaID");
                String nazivKompanije = rs.getString("nazivKompanije");
                String PIB = rs.getString("PIB");
                String maticniBroj = rs.getString("maticniBroj");
                String tekuciRacun = rs.getString("tekuciRacun");
                String banka = rs.getString("banka");
                String grad = rs.getString("grad");
                int drzavaID = rs.getInt("drzavaID");

                Kompanija k = new Kompanija(kompanijaID + "", nazivKompanije, PIB, maticniBroj, tekuciRacun, banka, grad, new Drzava(drzavaID + ""));
                kompanije.add(k);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Greska kod RSuTabelu za Kompanija");
        }
        return kompanije;
    }

    @Override
    public String vratiUpdate() {
        return String.format("kompanijaID='%s', nazivKompanije='%s',PIB='%s',maticniBroj='%s', tekuciRacun='%s',banka='%s', grad='%s',drzavaID='%s'", kompanijaID, nazivKompanije, PIB, maticniBroj, tekuciRacun, banka, grad, drzava.getDrzavaID());
    }

    @Override
    public void postaviVrednostPK(String pk) {
        this.kompanijaID = pk;
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
        final Kompanija other = (Kompanija) obj;
        if (!Objects.equals(this.kompanijaID, other.kompanijaID)) {
            return false;
        }
        return true;
    }

    public String getPIB() {
        return PIB;
    }

    public void setPIB(String PIB) {
        this.PIB = PIB;
    }

    public String getMaticniBroj() {
        return maticniBroj;
    }

    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }

    public String getBanka() {
        return banka;
    }

    public void setBanka(String banka) {
        this.banka = banka;
    }

}
