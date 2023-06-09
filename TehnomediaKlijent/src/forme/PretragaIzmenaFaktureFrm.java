/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.AbstractObjekat;
import domen.RukovodilacSektoraNabavke;
import domen.Faktura;
import exception.ValidacijaException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import model.ModelTabeleFaktura;

/**
 *
 * @author Bojana
 */
public class PretragaIzmenaFaktureFrm extends javax.swing.JFrame {

    JFrame glavna;
    ModelTabeleFaktura mtf;
    RukovodilacSektoraNabavke ulogovaniRukovodilac;

    public PretragaIzmenaFaktureFrm() {
        initComponents();
    }

    PretragaIzmenaFaktureFrm(JFrame glavna, RukovodilacSektoraNabavke ulogovaniRukovodilac) {
        initComponents();
        this.glavna = glavna;
        this.ulogovaniRukovodilac = ulogovaniRukovodilac;
        srediTabelu();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFaktura = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtDatum = new javax.swing.JTextField();
        btnPretrazi = new javax.swing.JButton();
        btnDodaj = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnOdustani = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabelaFaktura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaFaktura);

        jLabel1.setText("Datum fakture:");

        txtDatum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatumActionPerformed(evt);
            }
        });

        btnPretrazi.setText("Pretraži");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

        btnDodaj.setText("Dodaj novu fakturu");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni fakturu");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obriši fakturu");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnOdustani.setText("Odustani");
        btnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustaniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnDodaj)
                .addGap(67, 67, 67)
                .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPretrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPretrazi)
                    .addComponent(btnOdustani))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDodaj, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btnIzmeni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnObrisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed

        try {
            String datum = txtDatum.getText().trim();
            if (datum.isEmpty()) {
                List<AbstractObjekat> listaFaktura = Kontroler.vratiInstancu().ucitajFakture();
                mtf = new ModelTabeleFaktura(listaFaktura);
                tabelaFaktura.setModel(mtf);
                JOptionPane.showMessageDialog(this, "Unesite vrednost za pretragu", "Greška", JOptionPane.INFORMATION_MESSAGE);
            } else {
                validirajDatum(datum);
                List<AbstractObjekat> listaFaktura = Kontroler.vratiInstancu().pretraziFakture(datum);
                mtf = new ModelTabeleFaktura(listaFaktura);
                tabelaFaktura.setModel(mtf);
                if (!mtf.getLista().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Sistem je nasao fakturu/e po zadatoj vrednosti!", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Sistem nije nasao fakturu/e po zadatoj vrednosti!", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (ValidacijaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void txtDatumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDatumActionPerformed

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        dispose();
    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        UnosFaktureFrm uff = new UnosFaktureFrm(this, ulogovaniRukovodilac);
        this.setVisible(false);
        uff.setVisible(true);
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        int red = tabelaFaktura.getSelectedRow();
        if (red != -1) {
            Faktura f = (Faktura) mtf.getLista().get(red);
            
            int odluka = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da želite da obrišete fakturu " + f.toString() + "?", "", JOptionPane.WARNING_MESSAGE);
            if (odluka == 0) {
                try {
                    Faktura obrisana = (Faktura) Kontroler.vratiInstancu().obrisiFakturu(f);
                    JOptionPane.showMessageDialog(this, "Uspešno ste obrisali fakturu " + obrisana.toString() + ".", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
                    srediTabelu();
                } catch (Exception ex) {
                   JOptionPane.showMessageDialog(this, "Došlo je do greške prilikom brisanja fakture!", "Greška", JOptionPane.ERROR_MESSAGE);

                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Izaberite fakturu koju želite da obrišete!", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        int red = tabelaFaktura.getSelectedRow();
        if (red != -1) {
            Faktura f = (Faktura) mtf.getLista().get(red);
            UnosFaktureFrm uff = new UnosFaktureFrm(this, ulogovaniRukovodilac, f);
            this.setVisible(false);
            uff.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Izaberite fakturu koju želite da izmenite!", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

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
            java.util.logging.Logger.getLogger(PretragaIzmenaFaktureFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PretragaIzmenaFaktureFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PretragaIzmenaFaktureFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PretragaIzmenaFaktureFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PretragaIzmenaFaktureFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaFaktura;
    private javax.swing.JTextField txtDatum;
    // End of variables declaration//GEN-END:variables

    private void srediTabelu() {

        try {
            List<AbstractObjekat> listaFaktura = Kontroler.vratiInstancu().ucitajFakture();
            mtf = new ModelTabeleFaktura(listaFaktura);
            tabelaFaktura.setModel(mtf);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Došlo je do greške kod učitavanja faktura", "Greška", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(PretragaIzmenaKompanijaFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void validirajDatum(String datum) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date dat = null;
        try {
            dat = sdf.parse(datum);
        } catch (ParseException ex) {
            throw new ValidacijaException("Unesite datum u formatu dd.MM.yyyy");
        }

    }

}
