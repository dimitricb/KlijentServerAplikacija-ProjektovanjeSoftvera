/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.AbstractObjekat;
import domen.Kompanija;
import domen.Drzava;
import domen.RukovodilacSektoraNabavke;
import domen.Faktura;
import exception.ServerskiException;
import java.util.List;
import so.SOIzlogujRukovodiocaSektoraNabavke;
import so.SOIzmeniKompaniju;
import so.SOIzmeniFakturu;
import so.SOObrisiKompaniju;
import so.SOObrisiFakturu;
import so.SOPretraziKompanije;
import so.SOPretraziFakture;
import so.SOSacuvajKompaniju;
import so.SOSacuvajFakturu;
import so.SOUcitajKompanije;
import so.SOUcitajDrzave;
import so.SOUcitajListuKorisnika;
import so.SOUcitajListuFaktura;
import so.SOUcitajProizvode;
import so.SOUlogujRukovodiocaSektoraNabavke;

/**
 *
 * @author Bojana
 */
public class Kontroler {

    private static Kontroler instanca;
    private List<AbstractObjekat> listaKorisnika;

    private Kontroler() {
    }

    public static Kontroler vratiInstancu() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public List<AbstractObjekat> getListaKorisnika() throws ServerskiException {
        if (listaKorisnika == null) {
            listaKorisnika = vratiListuKorisnika();
        }
        return listaKorisnika;
    }

    private List<AbstractObjekat> vratiListuKorisnika() throws ServerskiException {
        SOUcitajListuKorisnika souk = new SOUcitajListuKorisnika();
        souk.izvrsiOperaciju();
        return souk.getLista();

    }

    public AbstractObjekat ulogujKorisnika(RukovodilacSektoraNabavke rsn) throws ServerskiException {
        SOUlogujRukovodiocaSektoraNabavke sorsn = new SOUlogujRukovodiocaSektoraNabavke();
        sorsn.setUnetiParametri(rsn);
        sorsn.izvrsiOperaciju();
        return sorsn.getUlogovanKorisnik();
    }

    public List<AbstractObjekat> vratiListuDrzava() throws ServerskiException {
        SOUcitajDrzave soud = new SOUcitajDrzave();
        soud.izvrsiOperaciju();
        return soud.getLista();
    }

    public AbstractObjekat kreirajKompaniju(Kompanija k) throws ServerskiException {
        SOSacuvajKompaniju so = new SOSacuvajKompaniju(k);
        so.izvrsiOperaciju();
        return so.getKompanija();
    }

    public List<AbstractObjekat> vratiListuKompanija() throws ServerskiException {
        SOUcitajKompanije souk = new SOUcitajKompanije();
        souk.izvrsiOperaciju();
        return souk.getLista();
    }

    public List<AbstractObjekat> pretraziKompanije(Drzava drz) throws ServerskiException {
        SOPretraziKompanije sopk = new SOPretraziKompanije(drz);
        sopk.izvrsiOperaciju();
        return sopk.getLista();
    }

    public AbstractObjekat izmeniKompaniju(Kompanija k) throws ServerskiException {
        SOIzmeniKompaniju so = new SOIzmeniKompaniju(k);
        so.izvrsiOperaciju();
        return so.getKompanija();
    }

    public AbstractObjekat obrisiKompaniju(Kompanija k) throws ServerskiException {
        SOObrisiKompaniju sook = new SOObrisiKompaniju(k);
        sook.izvrsiOperaciju();
        return sook.getObrisan();
    }

    public List<AbstractObjekat> vratiListuProizvoda() throws ServerskiException {
        SOUcitajProizvode soup = new SOUcitajProizvode();
        soup.izvrsiOperaciju();
        return soup.getLista();
    }

    public AbstractObjekat sacuvajfakturu(Faktura f) throws ServerskiException {
        SOSacuvajFakturu sosf = new SOSacuvajFakturu(f);
        sosf.izvrsiOperaciju();
        return sosf.getFaktura();
    }

    public List<AbstractObjekat> vratiListuFaktura() throws ServerskiException {
        SOUcitajListuFaktura soulf = new SOUcitajListuFaktura();
        soulf.izvrsiOperaciju();
        return soulf.getListaFaktura();
    }

    public List<AbstractObjekat> pretraziFakture(String datum) throws ServerskiException {
        SOPretraziFakture sopf = new SOPretraziFakture(datum);
        sopf.izvrsiOperaciju();
        return sopf.getListaNadjenih();
    }

    public AbstractObjekat obrisiFakturu(Faktura f) throws ServerskiException {
        SOObrisiFakturu soof = new SOObrisiFakturu(f);
        soof.izvrsiOperaciju();
        return soof.getObrisan();
    }

    public AbstractObjekat izmeniFakturu(Faktura fakturaZaIzmenu) throws ServerskiException {

        SOIzmeniFakturu soif = new SOIzmeniFakturu(fakturaZaIzmenu);
        soif.izvrsiOperaciju();
        return soif.getFaktura();
    }

    public void izlogujRukovodiocaSektoraNabavke(AbstractObjekat rsn) throws ServerskiException {
        SOIzlogujRukovodiocaSektoraNabavke soirsn = new SOIzlogujRukovodiocaSektoraNabavke(rsn);
        soirsn.izvrsiOperaciju();
    }
}
