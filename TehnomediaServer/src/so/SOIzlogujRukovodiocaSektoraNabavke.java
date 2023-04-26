/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import domen.RukovodilacSektoraNabavke;
import exception.ServerskiException;
import kontroler.Kontroler;

/**
 *
 * @author Bojana
 */
public class SOIzlogujRukovodiocaSektoraNabavke extends AbstractSO {

    private AbstractObjekat rsn;

    public SOIzlogujRukovodiocaSektoraNabavke(AbstractObjekat rsn) {
        this.rsn = rsn;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        int indeks = Kontroler.vratiInstancu().getListaKorisnika().indexOf(rsn);
        if (indeks != -1) {
            ((RukovodilacSektoraNabavke) Kontroler.vratiInstancu().getListaKorisnika().get(indeks)).setUlogovan(false);
        }
    }

    public AbstractObjekat getRsn() {
        return rsn;
    }

    public void setRsn(AbstractObjekat rsn) {
        this.rsn = rsn;
    }

    

    

}
