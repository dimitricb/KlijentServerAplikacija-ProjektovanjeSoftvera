/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.AbstractObjekat;
import domen.Kompanija;
import domen.Drzava;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import model.ModelTabeleKompanija;

/**
 *
 * @author Bojana
 */
public class PretragaIzmenaKompanijaFrm extends javax.swing.JFrame {

    JFrame glavna;
    ModelTabeleKompanija mtd;

    public PretragaIzmenaKompanijaFrm() {
        initComponents();
    }

    public PretragaIzmenaKompanijaFrm(GlavnaFrm glavna) {
        initComponents();
        setLocationRelativeTo(null);
        this.setTitle("Pretraga kompanija");
        this.glavna = glavna;
        srediFormu();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmbDrzava = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaKompanija = new javax.swing.JTable();
        btnUnesi = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Država : ");

        cmbDrzava.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tabelaKompanija.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaKompanija);

        btnUnesi.setText("Unesi kompaniju");
        btnUnesi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnesiActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni kompaniju");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obriši kompaniju");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(cmbDrzava, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(btnUnesi, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbDrzava, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUnesi, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUnesiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnesiActionPerformed
        UnosKompanijeFrm kompanijaFrm = new UnosKompanijeFrm(this);
        kompanijaFrm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnUnesiActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        int index = tabelaKompanija.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(rootPane, "Izaberite kompaniju koju želite da izmenite!", "Greška", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Kompanija izabrana = (Kompanija) mtd.getLista().get(index);
            UnosKompanijeFrm kompanijaF = new UnosKompanijeFrm(this, izabrana);
            kompanijaF.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        int index = tabelaKompanija.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(rootPane, "Izaberite kompaniju koju želite da obrišete!", "Greška", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                Kompanija izabranaKompanija = (Kompanija) mtd.getLista().get(index);
                int odluka = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da želite da obrišete izabranu kompaniju " + izabranaKompanija.toString() + "?", "", JOptionPane.WARNING_MESSAGE);
                if (odluka == 0) {
                    Kompanija k = (Kompanija) Kontroler.vratiInstancu().obrisiKompaniju(izabranaKompanija);
                    JOptionPane.showMessageDialog(rootPane, "Obrisali ste podatke o kompaniji " + k.toString(), "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                    srediTabelu();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Došlo je do greške prilikom brisanja kompanije!", "Greška", JOptionPane.ERROR_MESSAGE);

            }
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

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
            java.util.logging.Logger.getLogger(PretragaIzmenaKompanijaFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PretragaIzmenaKompanijaFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PretragaIzmenaKompanijaFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PretragaIzmenaKompanijaFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PretragaIzmenaKompanijaFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnUnesi;
    private javax.swing.JComboBox cmbDrzava;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaKompanija;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
        popuniCMBDrzave();
        srediTabelu();
    }

    private void popuniCMBDrzave() {
        try {
            List<AbstractObjekat> listaDrzava = new ArrayList<>();
            listaDrzava.addAll(Kontroler.vratiInstancu().ucitajDrzave());
            Drzava sveDrzave = new Drzava();
            sveDrzave.setNazivDrzave("Učitaj sve");
            cmbDrzava.setModel(new DefaultComboBoxModel(listaDrzava.toArray()));
            cmbDrzava.addItem(sveDrzave);
            cmbDrzava.setSelectedItem(null);
            cmbDrzava.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    try {

                        Drzava odabranaDrzava = (Drzava) cmbDrzava.getSelectedItem();
                        if (odabranaDrzava.getNazivDrzave().equals("Ucitaj sve")) {
                            srediTabelu();
                            return;
                        }
                        List<AbstractObjekat> lista = Kontroler.vratiInstancu().pretraziKompanije(odabranaDrzava);

                        if (!lista.isEmpty()) {
                            JOptionPane.showMessageDialog(rootPane, "Sistem je nasao kompaniju/e po zadatoj vrednosti!", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Kompanije koje odgovaraju zadatoj vrednosti ne postoje!", "Greška", JOptionPane.ERROR_MESSAGE);
                        }

                        mtd.setLista(lista);
                        mtd.fireTableDataChanged();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(rootPane, "Došlo je do greške!", "Greška", JOptionPane.ERROR_MESSAGE);

                        Logger.getLogger(PretragaIzmenaKompanijaFrm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        } catch (Exception ex) {
            Logger.getLogger(PretragaIzmenaKompanijaFrm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void srediTabelu() {

        try {
            List<AbstractObjekat> listaKompanija = Kontroler.vratiInstancu().ucitajKompanije();
            mtd = new ModelTabeleKompanija(listaKompanija);
            tabelaKompanija.setModel(mtd);

        } catch (Exception ex) {
            Logger.getLogger(PretragaIzmenaKompanijaFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}