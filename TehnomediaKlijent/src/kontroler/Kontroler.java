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
import java.io.IOException;
import java.util.List;
import komunikacija.Komunikacija;
import konstante.Operacije;
import transfer.KlijentTransfer;
import transfer.ServerTransfer;

/**
 *
 * @author Bojana
 */
public class Kontroler {

    private static Kontroler instanca;

    private Kontroler() {
    }

    public static Kontroler vratiInstancu() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    private Object posaljiZahtev(int operacija, Object parametar) throws Exception {
        KlijentTransfer kt = new KlijentTransfer();
        kt.setOperacija(operacija);
        kt.setParametar(parametar);
        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerTransfer st = Komunikacija.vratiInstancu().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return st.getPodaci();
        } else {
            Exception ex = st.getException();
            throw ex;
        }
    }

    private Object posaljiZahtev(int operacija) throws Exception {
        return posaljiZahtev(operacija, null);
    }

    public AbstractObjekat ulogujKorisnika(String lozinka) throws Exception {
        RukovodilacSektoraNabavke r = new RukovodilacSektoraNabavke(null, null, null, lozinka, false);
        return (AbstractObjekat) posaljiZahtev(Operacije.LOGIN, r);
    }

    public List<AbstractObjekat> ucitajDrzave() throws Exception {
        return (List<AbstractObjekat>) posaljiZahtev(Operacije.UCITAJ_DRZAVE);
    }

    public AbstractObjekat sacuvajKompaniju(Kompanija k) throws Exception {
        return (AbstractObjekat) posaljiZahtev(Operacije.SACUVAJ_KOMPANIJU, k);
    }

    public List<AbstractObjekat> ucitajKompanije() throws Exception {
        return (List<AbstractObjekat>) posaljiZahtev(Operacije.UCITAJ_KOMPANIJE);
    }

    public List<AbstractObjekat> pretraziKompanije(Drzava drzava) throws Exception {
        return (List<AbstractObjekat>) posaljiZahtev(Operacije.PRETRAZI_KOMPANIJE, drzava);
    }

    public AbstractObjekat obrisiKompaniju(Kompanija izabranaKompanija) throws Exception {
        return (AbstractObjekat) posaljiZahtev(Operacije.OBRISI_KOMPANIJU, izabranaKompanija);
    }

    public AbstractObjekat izmeniKompaniju(Kompanija izabranaKompanija) throws Exception {
        return (AbstractObjekat) posaljiZahtev(Operacije.IZMENI_KOMPANIJU, izabranaKompanija);
    }

    public List<AbstractObjekat> ucitajProizvode() throws Exception {
        return (List<AbstractObjekat>) posaljiZahtev(Operacije.UCITAJ_PROIZVODE);
    }

    public AbstractObjekat sacuvajFakturu(Faktura f) throws IOException, ClassNotFoundException, Exception {
        return (AbstractObjekat) posaljiZahtev(Operacije.SACUVAJ_FAKTURU, f);
    }

    public List<AbstractObjekat> ucitajFakture() throws Exception {
        return (List<AbstractObjekat>) posaljiZahtev(Operacije.UCITAJ_FAKTURE);
    }

    public List<AbstractObjekat> pretraziFakture(String datum) throws IOException, Exception {
        return (List<AbstractObjekat>) posaljiZahtev(Operacije.PRETRAZI_FAKTURE, datum);
    }

    public AbstractObjekat obrisiFakturu(Faktura f) throws Exception {
        return (AbstractObjekat) posaljiZahtev(Operacije.OBRISI_FAKTURU, f);
    }

    public AbstractObjekat izmeniFakturu(Faktura f) throws IOException, ClassNotFoundException, Exception {
        return (AbstractObjekat) posaljiZahtev(Operacije.IZMENI_FAKTURU, f);
    }

    public AbstractObjekat izlogujRukovodiocaSektoraNabavke(RukovodilacSektoraNabavke rsn) throws Exception {
        return (AbstractObjekat) posaljiZahtev(Operacije.IZLOGUJ_RUKOVODIOCA_SEKTORA_NABAVKE, rsn);
    }

}
