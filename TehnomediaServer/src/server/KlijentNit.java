/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;


import domen.AbstractObjekat;
import domen.Kompanija;
import domen.Drzava;
import domen.RukovodilacSektoraNabavke;
import domen.Faktura;
import exception.ServerskiException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Operacije;
import kontroler.Kontroler;
import transfer.KlijentTransfer;
import transfer.ServerTransfer;

/**
 *
 * @author Bojana
 */
public class KlijentNit extends Thread {

    private Socket socket;
    private List<KlijentNit> klijenti;
    ObjectInputStream in;
    ObjectOutputStream out;
    AbstractObjekat korisnik;

    public KlijentNit(Socket socket, List<KlijentNit> klijenti) {
        this.socket = socket;
        this.klijenti = klijenti;
    }

    @Override
    public void run() {
        System.out.println("Klijent nit pokrenuta.");
        try {
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
            while (true) {
                System.out.println("Cekam zahtev");
                KlijentTransfer kt = (KlijentTransfer) in.readUnshared();
                ServerTransfer st = new ServerTransfer();
                try{
                int operacija = kt.getOperacija();
                switch (operacija) {
                    case Operacije.LOGIN:
                            RukovodilacSektoraNabavke men = (RukovodilacSektoraNabavke) kt.getParametar();
                            korisnik = Kontroler.vratiInstancu().ulogujKorisnika(men);
                            st.setPodaci(korisnik);
                            break;
                    case Operacije.UCITAJ_DRZAVE:
                            List<AbstractObjekat> listaDrzava = Kontroler.vratiInstancu().vratiListuDrzava();
                            st.setPodaci(listaDrzava);
                            break;
                   case Operacije.SACUVAJ_KOMPANIJU:
                            Kompanija k = (Kompanija) kt.getParametar();
                            AbstractObjekat komp = Kontroler.vratiInstancu().kreirajKompaniju(k);
                            st.setPodaci(komp);
                            break;
                            
                    case Operacije.UCITAJ_KOMPANIJE:
                            List<AbstractObjekat> listaKompanija = Kontroler.vratiInstancu().vratiListuKompanija();
                            st.setPodaci(listaKompanija);
                            break;
                    case Operacije.PRETRAZI_KOMPANIJE:
                            Drzava drz = (Drzava) kt.getParametar();
                            List<AbstractObjekat> listaK = Kontroler.vratiInstancu().pretraziKompanije(drz);
                            st.setPodaci(listaK);
                            break;
                     case Operacije.OBRISI_KOMPANIJU:
                            Kompanija kompa = (Kompanija) kt.getParametar();
                            Kompanija kompa1 = (Kompanija) Kontroler.vratiInstancu().obrisiKompaniju(kompa);
                            st.setPodaci(kompa1);
                            break;
                     case Operacije.IZMENI_KOMPANIJU:
                            Kompanija kompan = (Kompanija) kt.getParametar();
                            AbstractObjekat kompan1 = Kontroler.vratiInstancu().izmeniKompaniju(kompan);
                            st.setPodaci(kompan1);
                            break;
                    case Operacije.UCITAJ_PROIZVODE:
                            List<AbstractObjekat> listaProizvoda = Kontroler.vratiInstancu().vratiListuProizvoda();
                            st.setPodaci(listaProizvoda);
                            break;
                     case Operacije.SACUVAJ_FAKTURU:
                            Faktura f = (Faktura) kt.getParametar();
                            AbstractObjekat f1 = Kontroler.vratiInstancu().sacuvajfakturu(f);
                            st.setPodaci(f1);
                            break;
                    case Operacije.UCITAJ_FAKTURE:
                            List<AbstractObjekat> listaFaktura = Kontroler.vratiInstancu().vratiListuFaktura();
                            st.setPodaci(listaFaktura);
                            break;
                    case Operacije.PRETRAZI_FAKTURE:
                            String datumFakture = (String) kt.getParametar();
                            List<AbstractObjekat> listaPronadjenihFaktura = Kontroler.vratiInstancu().pretraziFakture(datumFakture);
                            st.setPodaci(listaPronadjenihFaktura);
                            break;
                    case Operacije.OBRISI_FAKTURU:
                            Faktura zaBrisanje = (Faktura) kt.getParametar();
                            Faktura zaBrisanje1 = (Faktura) Kontroler.vratiInstancu().obrisiFakturu(zaBrisanje);
                            st.setPodaci(zaBrisanje1);
                            break;
                    case Operacije.IZMENI_FAKTURU:
                            Faktura fakturaZaIzmenu = (Faktura) kt.getParametar();
                            AbstractObjekat fakturaZaIzmenu1 = Kontroler.vratiInstancu().izmeniFakturu(fakturaZaIzmenu);
                            st.setPodaci(fakturaZaIzmenu1);
                            break;
                    case Operacije.IZLOGUJ_RUKOVODIOCA_SEKTORA_NABAVKE:
                            RukovodilacSektoraNabavke rsn = (RukovodilacSektoraNabavke) kt.getParametar();
                            Kontroler.vratiInstancu().izlogujRukovodiocaSektoraNabavke(rsn);
                            break;

                }
                st.setUspesnost(1);
                } catch (ServerskiException ex) {
                    st.setUspesnost(-1);
                    st.setException(ex);
                }
                out.writeUnshared(st);
            }
        } catch (SocketException ex) {
            try {
                System.out.println("Klijent se iskljucuje...");
                Kontroler.vratiInstancu().izlogujRukovodiocaSektoraNabavke(korisnik);
                in.close();
                out.close();
                socket.close();
                klijenti.remove(this);
            } catch (IOException ex1) {
                Logger.getLogger(KlijentNit.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (ServerskiException ex1) {
                Logger.getLogger(KlijentNit.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(KlijentNit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

     public AbstractObjekat getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(AbstractObjekat korisnik) {
        this.korisnik = korisnik;
    }



}
