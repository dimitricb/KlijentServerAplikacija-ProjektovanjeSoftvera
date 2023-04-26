/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import domen.Kompanija;
import domen.RukovodilacSektoraNabavke;
import domen.Faktura;
import domen.Proizvod;
import domen.StavkaFakture;
import exception.ServerskiException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bojana
 */
public class SOUcitajListuFaktura extends AbstractSO {

    private List<AbstractObjekat> listaFaktura;
    private List<AbstractObjekat> listaSvihFaktura;

    public SOUcitajListuFaktura() {
        listaFaktura = new ArrayList<>();
        listaSvihFaktura = new ArrayList<>();
    }

    public List<AbstractObjekat> getListaFaktura() {
        return listaFaktura;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        listaSvihFaktura = dbb.vratiSveObjekte(new Faktura());
        System.out.println(listaSvihFaktura.size());
        ucitajDetalje();
        for (AbstractObjekat abstractObjekat : listaSvihFaktura) {
            Faktura f = (Faktura) abstractObjekat;
            System.out.println(f);
            listaFaktura.add(f);
        }
    }

    private void ucitajDetalje() throws ServerskiException {

        for (AbstractObjekat fa : listaSvihFaktura) {
            Faktura f = (Faktura) fa;

            Kompanija k = (Kompanija) dbb.vratiObjekatPoKljucu(new Kompanija(), f.getKompanija().getKompanijaID());

            RukovodilacSektoraNabavke rukovodilac = (RukovodilacSektoraNabavke) dbb.vratiObjekatPoKljucu(new RukovodilacSektoraNabavke(), f.getRukovodilacSektoraNabavke().getRukovodilacID());

            f.setRukovodilacSektoraNabavke(rukovodilac);
            f.setKompanija(k);

            List<AbstractObjekat> listaStavki = dbb.ucitajStavkePoIDFakture(f.getFakturaID());
            f.setListaStavki(listaStavki);

        }
    }

}
