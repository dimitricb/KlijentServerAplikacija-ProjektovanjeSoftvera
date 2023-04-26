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
public class RukovodilacSektoraNabavke extends AbstractObjekat {

    private String rukovodilacID;
    private String ime;
    private String prezime;
    private String lozinka;
    private boolean ulogovan;

    public RukovodilacSektoraNabavke() {
    }

    public RukovodilacSektoraNabavke(String rukovodilacID, String ime, String prezime, String lozinka, boolean ulogovan) {
        this.rukovodilacID = rukovodilacID;
        this.ime = ime;
        this.prezime = prezime;
        this.lozinka = lozinka;
        this.ulogovan = ulogovan;
    }

    public RukovodilacSektoraNabavke(String rukovodilacID) {
        this.rukovodilacID = rukovodilacID;
    }

    public String getLozinka() {
        return lozinka;
    }

    public String getRukovodilacID() {
        return rukovodilacID;
    }

    public void setRukovodilacID(String rukovodilacID) {
        this.rukovodilacID = rukovodilacID;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public boolean isUlogovan() {
        return ulogovan;
    }

    public void setUlogovan(boolean ulogovan) {
        this.ulogovan = ulogovan;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
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
        final RukovodilacSektoraNabavke other = (RukovodilacSektoraNabavke) obj;
        if (!Objects.equals(this.lozinka, other.lozinka)) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiImeTabele() {

        return "rukovodilacsektoranabavke";
    }

    @Override
    public String vratiParametre() {

        return String.format("'%s', '%s', '%s','%s'", rukovodilacID, ime, prezime, lozinka);
    }

    @Override
    public String vratiPK() {

        return "rukovodilacID";
    }

    @Override
    public String vratiVrednostPK() {

        return rukovodilacID;
    }

    @Override
    public String vratiSlozenPK() {

        return null;
    }

    @Override
    public List<AbstractObjekat> RSuTabelu(ResultSet rs) {

        List<AbstractObjekat> rukovodioci = new ArrayList<>();
        try {
            while (rs.next()) {
                int rukovodilacID = rs.getInt("rukovodilacID");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");

                String lozinka = rs.getString("lozinka");

                RukovodilacSektoraNabavke rsn = new RukovodilacSektoraNabavke(rukovodilacID + "", ime, prezime, lozinka, false);

                rukovodioci.add(rsn);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Greska kod RSuTabelu za RukovodilacsektoraNabavke");
        }
        return rukovodioci;
    }

    @Override
    public String vratiUpdate() {

        return String.format("rukovodilacID='%s', ime='%s',prezime='%s',lozinka='%s'", rukovodilacID, ime, prezime, lozinka);

    }

    @Override
    public void postaviVrednostPK(String pk) {

        this.rukovodilacID = pk;
    }

}
