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
import java.util.List;

/**
 *
 * @author Bojana
 */
public class SOSacuvajFakturu extends AbstractSO {

    AbstractObjekat param;
    AbstractObjekat faktura;

    public SOSacuvajFakturu(AbstractObjekat param) {
        this.param = param;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        faktura = dbb.sacuvajObjekat(param);
        sacuvajStavke();
    }

    public AbstractObjekat getFaktura() {
        return faktura;
    }

    public AbstractObjekat getParam() {
        return param;
    }

    private void sacuvajStavke() throws ServerskiException {
        Faktura f = (Faktura) param;
        List<AbstractObjekat> stavke = f.getListaStavki();
        for (AbstractObjekat abstractObjekat : stavke) {
            StavkaFakture sf = (StavkaFakture) abstractObjekat;
            dbb.sacuvajObjekat(sf);
        }
    }

}
