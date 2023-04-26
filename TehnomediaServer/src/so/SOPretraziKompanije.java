/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import domen.Kompanija;
import domen.Drzava;
import exception.ServerskiException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bojana
 */
public class SOPretraziKompanije extends AbstractSO {

    List<AbstractObjekat> lista = new ArrayList<>();
    Drzava drzava;

    public SOPretraziKompanije(Drzava drzava) {
        this.drzava = drzava;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        List<AbstractObjekat> kompanije = dbb.ucitajKompanije(new Kompanija());
        if (drzava.getDrzavaID().equals("-1")) {
            lista.addAll(kompanije);
        } else {
            for (AbstractObjekat ao : kompanije) {
                Kompanija k = (Kompanija) ao;
                if (k.getDrzava().equals(drzava)) {
                    lista.add(k);
                }
            }
        }
    }

    public List<AbstractObjekat> getLista() {
        return lista;
    }
}
