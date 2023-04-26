/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.AbstractObjekat;
import domen.Kompanija;
import domen.Drzava;
import exception.ValidacijaException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import kontroler.Kontroler;

/**
 *
 * @author Bojana
 */
public class UnosKompanijeFrm extends javax.swing.JFrame {

    JFrame glavnaForma;
    Kompanija kompanija;
    String status;

    /**
     * Creates new form UnosDobavljacaFrm
     */
    public UnosKompanijeFrm() {
        initComponents();
    }

    public UnosKompanijeFrm(JFrame glavna) {
        initComponents();
        setLocationRelativeTo(null);
        this.setTitle("Unos kompanija");
        popuniCBDrzava();
        this.glavnaForma = glavna;
        kompanija = new Kompanija("0", "", "", "", "", "", "", null);
        txtKompanijaID.setEnabled(false);
        this.status = "unos";
    }

    public UnosKompanijeFrm(PretragaIzmenaKompanijaFrm pretraga, Kompanija izabrani) {
        initComponents();
        this.setTitle("Izmena kompanija");
        popuniCBDrzava();
        this.glavnaForma = pretraga;
        txtKompanijaID.setEnabled(false);
        this.kompanija = izabrani;
        popuniPolja();
        this.status = "izmena";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNazivKompanije = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTekuciRacun = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtGrad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbDrzava = new javax.swing.JComboBox();
        btnSacuvaj = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtKompanijaID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtBanka = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPib = new javax.swing.JTextField();
        txtMaticni = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Naziv kompanije:");

        jLabel2.setText("Tekući račun:");

        jLabel3.setText("Grad:");

        jLabel4.setText("Država:");

        cmbDrzava.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSacuvaj.setText("Sačuvaj kompaniju");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        jLabel5.setText("KompanijaID");

        jLabel6.setText("Banka:");

        jLabel7.setText("Matični broj:");

        jLabel8.setText("PIB:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(39, 39, 39))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNazivKompanije)
                            .addComponent(txtTekuciRacun)
                            .addComponent(txtGrad)
                            .addComponent(cmbDrzava, 0, 278, Short.MAX_VALUE)
                            .addComponent(txtKompanijaID)
                            .addComponent(txtBanka)
                            .addComponent(txtPib)
                            .addComponent(txtMaticni)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtKompanijaID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNazivKompanije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMaticni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTekuciRacun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBanka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbDrzava, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        try {
            String naziv = txtNazivKompanije.getText().trim();
            String pib = txtPib.getText().trim();
            String maticni = txtMaticni.getText().trim();
            String grad = txtGrad.getText().trim();
            String tekuciRacun = txtTekuciRacun.getText().trim();
            String banka = txtBanka.getText().trim();
            Drzava drzava = (Drzava) cmbDrzava.getSelectedItem();
            validirajIPostaviVrednosti(naziv, pib, maticni, grad, tekuciRacun, banka, drzava);
            Kompanija k;
            if (status.equals("unos")) {
                k = (Kompanija) Kontroler.vratiInstancu().sacuvajKompaniju(kompanija);
                JOptionPane.showMessageDialog(this, "Uspešno ste uneli kompaniju:\nID: " + k.getKompanijaID() + "\nNaziv: " + k.getNazivKompanije() + "\nPIB: " + k.getPIB() + "\nDrzava : " + k.getDrzava().getNazivDrzave(), "Uspesno", JOptionPane.INFORMATION_MESSAGE);

            } else {
                k = (Kompanija) Kontroler.vratiInstancu().izmeniKompaniju(kompanija);
                JOptionPane.showMessageDialog(this, "Uspešno ste izmenili kompaniju:\nID: " + k.getKompanijaID() + "\nNaziv: " + k.getNazivKompanije() + "\nPIB: " + k.getPIB() + "\nDrzava : " + k.getDrzava().getNazivDrzave(), "Uspesno", JOptionPane.INFORMATION_MESSAGE);

            }

            glavnaForma.setVisible(true);
            dispose();
        } catch (ValidacijaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(UnosKompanijeFrm.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnSacuvajActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UnosKompanijeFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UnosKompanijeFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UnosKompanijeFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UnosKompanijeFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UnosKompanijeFrm().setVisible(true);
            }
        });
    }

    private void popuniCBDrzava() {

        try {

            List<AbstractObjekat> listaDrzava = Kontroler.vratiInstancu().ucitajDrzave();
            cmbDrzava.setModel(new DefaultComboBoxModel(listaDrzava.toArray()));
            cmbDrzava.setSelectedItem(null);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cmbDrzava;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtBanka;
    private javax.swing.JTextField txtGrad;
    private javax.swing.JTextField txtKompanijaID;
    private javax.swing.JTextField txtMaticni;
    private javax.swing.JTextField txtNazivKompanije;
    private javax.swing.JTextField txtPib;
    private javax.swing.JTextField txtTekuciRacun;
    // End of variables declaration//GEN-END:variables

    private void validirajIPostaviVrednosti(String naziv, String pib, String maticni, String grad, String tekuci, String banka, Drzava drzava) throws Exception {
        if (naziv.isEmpty() || pib.isEmpty() || maticni.isEmpty() || grad.isEmpty() || tekuci.isEmpty() || banka.isEmpty() || drzava == null) {
            throw new ValidacijaException("Sistem ne moze da zapamti podatke o kompaniji!");
        }
        
        
        kompanija.setNazivKompanije(naziv);
        kompanija.setPIB(pib);
        kompanija.setMaticniBroj(maticni);
        kompanija.setTekuciRacun(tekuci);
        kompanija.setBanka(banka);
        kompanija.setGrad(grad);
        kompanija.setDrzava(drzava);
    }

    private void popuniPolja() {

        txtBanka.setText(kompanija.getBanka());
        txtGrad.setText(kompanija.getGrad());
        txtKompanijaID.setText(kompanija.getKompanijaID());
        txtMaticni.setText(kompanija.getMaticniBroj());
        txtTekuciRacun.setText(kompanija.getTekuciRacun());
        txtNazivKompanije.setText(kompanija.getNazivKompanije());
        txtPib.setText(kompanija.getPIB());
        cmbDrzava.setSelectedItem(kompanija.getDrzava());
    }

}