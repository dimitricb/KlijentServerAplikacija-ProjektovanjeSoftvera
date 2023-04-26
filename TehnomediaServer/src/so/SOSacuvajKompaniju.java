/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import exception.ServerskiException;

/**
 *
 * @author Bojana
 */
public class SOSacuvajKompaniju extends AbstractSO{

    private AbstractObjekat param;
    private AbstractObjekat kompanija;
    
    public SOSacuvajKompaniju(AbstractObjekat param){
        this.param=param;
    }
    
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        kompanija = dbb.sacuvajObjekat(param);
    }
    public AbstractObjekat getParam() {
        return param;
    }
    public void setParam(AbstractObjekat param) {
        this.param = param;
    }

    public AbstractObjekat getKompanija() {
        return kompanija;
    }
    

    
    
}
