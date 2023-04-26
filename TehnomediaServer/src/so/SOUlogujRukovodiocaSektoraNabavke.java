/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import domen.RukovodilacSektoraNabavke;
import exception.ServerskiException;
import java.util.List;
import kontroler.Kontroler;

/**
 *
 * @author Bojana
 */
public class SOUlogujRukovodiocaSektoraNabavke extends AbstractSO {

    private AbstractObjekat unetiParametri;
    private AbstractObjekat ulogovanKorisnik;

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        List<AbstractObjekat> listaRukovodilaca = dbb.vratiSveObjekte(new RukovodilacSektoraNabavke());
        RukovodilacSektoraNabavke unetiRukovodilac = (RukovodilacSektoraNabavke) unetiParametri;
        for (AbstractObjekat abstractObjekat : listaRukovodilaca) {
            RukovodilacSektoraNabavke rukovodilacIzBaze = (RukovodilacSektoraNabavke) abstractObjekat;
            if (rukovodilacIzBaze.equals(unetiRukovodilac)) {
                ulogovanKorisnik = rukovodilacIzBaze;
                int indeks = Kontroler.vratiInstancu().getListaKorisnika().indexOf(rukovodilacIzBaze);
                RukovodilacSektoraNabavke izListe = (RukovodilacSektoraNabavke) Kontroler.vratiInstancu().getListaKorisnika().get(indeks);
                if (izListe.isUlogovan()) {
                    throw new ServerskiException("Rukovodilac sektora nabavke je vec ulogovan!");
                } else {
                    izListe.setUlogovan(true);
                }
                System.out.println("Postavio rukovodioca sektora nabavke da je ulogovan.");
                return;
            }
        }

        throw new ServerskiException("Nije pronadjen rukovodilac sektora nabavke!");
    }

    public AbstractObjekat getUnetiParametri() {
        return unetiParametri;
    }

    public void setUnetiParametri(AbstractObjekat unetiParametri) {
        this.unetiParametri = unetiParametri;
    }

    public AbstractObjekat getUlogovanKorisnik() {
        return ulogovanKorisnik;
    }

    public void setUlogovanKorisnik(AbstractObjekat ulogovanKorisnik) {
        this.ulogovanKorisnik = ulogovanKorisnik;
    }

}
