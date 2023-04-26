/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import domen.Faktura;
import domen.StavkaFakture;
import exception.ServerskiException;

/**
 *
 * @author Bojana
 */
public class SOIzmeniFakturu extends AbstractSO {

    AbstractObjekat param;
    AbstractObjekat faktura;

    public SOIzmeniFakturu(Faktura param) {
        this.param = param;
    }

    public AbstractObjekat getFaktura() {
        return faktura;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        faktura = dbb.izmeniObjekat(param);
        Faktura f = (Faktura) faktura;
        for (AbstractObjekat ao : f.getListaStavki()) {
            StavkaFakture sf = (StavkaFakture) ao;
            if (sf.getStanje() != null && sf.getStanje().equals("obrisana")) {
                dbb.obrisiStavku(sf);
            } else {
                dbb.sacuvajIliAzurirajObjekat(sf);
            }
        }
    }

}
