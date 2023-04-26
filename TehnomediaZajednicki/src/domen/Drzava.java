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
public class Drzava extends AbstractObjekat {

    private String drzavaID;
    private String nazivDrzave;

    public Drzava() {
    }

    public Drzava(String drzavaID) {
        this.drzavaID = drzavaID;
    }

    public Drzava(String drzavaID, String nazivDrzave) {
        this.drzavaID = drzavaID;
        this.nazivDrzave = nazivDrzave;
    }

    public String getNazivDrzave() {
        return nazivDrzave;
    }

    public void setNazivDrzave(String nazivDrzave) {
        this.nazivDrzave = nazivDrzave;
    }

    public String getDrzavaID() {
        return drzavaID;
    }

    public void setDrzavaID(String drzavaID) {
        this.drzavaID = drzavaID;
    }

    @Override
    public String toString() {
        return nazivDrzave;
    }

    @Override
    public String vratiImeTabele() {

        return "drzava";

    }

    @Override
    public String vratiParametre() {

        return String.format("'%s', '%s'", drzavaID, nazivDrzave);

    }

    @Override
    public String vratiPK() {

        return "drzavaID";
    }

    @Override
    public String vratiVrednostPK() {

        return drzavaID;
    }

    @Override
    public String vratiSlozenPK() {

        return null;
    }

    @Override
    public List<AbstractObjekat> RSuTabelu(ResultSet rs) {

        List<AbstractObjekat> drzave = new ArrayList<>();
        try {
            while (rs.next()) {
                int drzavaID = rs.getInt("drzavaID");
                String nazivDrzave = rs.getString("nazivDrzave");

                Drzava d = new Drzava(drzavaID + "", nazivDrzave);

                drzave.add(d);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Greska kod RSuTabelu za Drzava");
        }

        return drzave;

    }

    @Override
    public String vratiUpdate() {

        return String.format("drzavaID='%s', nazivDrzave='%s'", drzavaID, nazivDrzave);
    }

    @Override
    public void postaviVrednostPK(String pk) {

        this.drzavaID = pk;
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
        final Drzava other = (Drzava) obj;
        if (!Objects.equals(this.drzavaID, other.drzavaID)) {
            return false;
        }
        return true;
    }

}
