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
import exception.ServerskiException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bojana
 */
public class SOPretraziFakture extends AbstractSO {

    private String datum;
    private List<AbstractObjekat> listaNadjenih;

    public SOPretraziFakture(String datum) {
        this.datum = datum;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        List<AbstractObjekat> izBaze = dbb.vratiSveObjekte(new Faktura());
      
        listaNadjenih = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        
        
        for (AbstractObjekat abstractObjekat : izBaze) {
            Faktura f = (Faktura) abstractObjekat;

            String datumizBaze = sdf.format(f.getDatum().getTime());
            if (datumizBaze.equals(datum)) {
                
                Kompanija k = (Kompanija) dbb.vratiObjekatPoKljucu(new Kompanija(), f.getKompanija().getKompanijaID());
                
                RukovodilacSektoraNabavke rsn = (RukovodilacSektoraNabavke) dbb.vratiObjekatPoKljucu(new RukovodilacSektoraNabavke(), f.getRukovodilacSektoraNabavke().getRukovodilacID());

                f.setKompanija(k);
                f.setRukovodilacSektoraNabavke(rsn);
              

                List<AbstractObjekat> listaStavki = dbb.ucitajStavkePoIDFakture(f.getFakturaID());
                f.setListaStavki(listaStavki);

                listaNadjenih.add(f);
            }
        }
    }

    public List<AbstractObjekat> getListaNadjenih() {
        return listaNadjenih;
    }

}
