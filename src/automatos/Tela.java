/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatos;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class Tela extends javax.swing.JFrame {

    /**
     * Creates new form tela
     */
    public Tela() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        editExpressao = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        editSaida = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        editExpressao.setColumns(20);
        editExpressao.setRows(5);
        jScrollPane1.setViewportView(editExpressao);

        editSaida.setEditable(false);
        editSaida.setColumns(20);
        editSaida.setRows(5);
        jScrollPane2.setViewportView(editSaida);

        jButton1.setText("Analisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Limpar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        editExpressao.setText("");
        editSaida.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Automato automato = inicializarAutomato();
        
        
        String texto = editExpressao.getText();
        String[] textoQuebrado = texto.split("");
        for (String string : textoQuebrado) {
            automato.Andar(string);            
        }
        
        editSaida.setText(automato.getResultado());
        
    }//GEN-LAST:event_jButton1ActionPerformed

    public Automato inicializarAutomato(){
        ArrayList<String> simbolos = new ArrayList<>();
        simbolos.add("a");
        simbolos.add("b");
        simbolos.add("c");
        simbolos.add("d");
        simbolos.add("e");
        ArrayList<String> operadores = new ArrayList<>();
        operadores.add("+");
        operadores.add("-");
        operadores.add("*");
        operadores.add("/");
        Estado q4 = new Estado(false, "a,c,+,-,*,/");
        Estado q5 = new Estado(false, "b,+,-,*,/");
        Estado q0 = new Estado(true, "a,c,d,e,+,-,*,/");
        Estado q7 = new Estado(false, "b,+,-,*,/");
        Estado q3 = new Estado(true, "e,+,-,*,/");
        Estado q1 = new Estado(true, "c,d,e,+,-,*,/");
        Estado q8 = new Estado(false, "d,+,-,*,/");
        Estado q2 = new Estado(true, "d,e,+,-,*,/");
        Estado q6 = new Estado(false, "c,+,-,*,/");
        Estado q9 = new Estado(true, "");
        q4.addProximoEstado(q5, "a");
        q4.addProximoEstado(q1, "c");
        q4.addProximoEstado(q9, "+");
        q4.addProximoEstado(q9, "-");
        q4.addProximoEstado(q9, "*");
        q4.addProximoEstado(q9, "/");
        q5.addProximoEstado(q0, "b");
        q5.addProximoEstado(q9, "+");
        q5.addProximoEstado(q9, "-");
        q5.addProximoEstado(q9, "*");
        q5.addProximoEstado(q9, "/");
        q0.addProximoEstado(q7, "a");
        q0.addProximoEstado(q6, "c");
        q0.addProximoEstado(q8, "d");
        q0.addProximoEstado(q3, "e");
        q0.addProximoEstado(q9, "+");
        q0.addProximoEstado(q9, "-");
        q0.addProximoEstado(q9, "*");
        q0.addProximoEstado(q9, "/");
        q7.addProximoEstado(q4, "b");
        q7.addProximoEstado(q9, "+");
        q7.addProximoEstado(q9, "-");
        q7.addProximoEstado(q9, "*");
        q7.addProximoEstado(q9, "/");
        q3.addProximoEstado(q3, "e");
        q3.addProximoEstado(q9, "+");
        q3.addProximoEstado(q9, "-");
        q3.addProximoEstado(q9, "*");
        q3.addProximoEstado(q9, "/");
        q1.addProximoEstado(q6, "c");
        q1.addProximoEstado(q8, "d");
        q1.addProximoEstado(q3, "e");
        q1.addProximoEstado(q9, "+");
        q1.addProximoEstado(q9, "-");
        q1.addProximoEstado(q9, "*");
        q1.addProximoEstado(q9, "/");
        q8.addProximoEstado(q2, "d");
        q8.addProximoEstado(q9, "+");
        q8.addProximoEstado(q9, "-");
        q8.addProximoEstado(q9, "*");
        q8.addProximoEstado(q9, "/");
        q2.addProximoEstado(q8, "d");
        q2.addProximoEstado(q3, "e");
        q2.addProximoEstado(q9, "+");
        q2.addProximoEstado(q9, "-");
        q2.addProximoEstado(q9, "*");
        q2.addProximoEstado(q9, "/");
        q6.addProximoEstado(q1, "c");
        q6.addProximoEstado(q9, "+");
        q6.addProximoEstado(q9, "-");
        q6.addProximoEstado(q9, "*");
        q6.addProximoEstado(q9, "/");
        ArrayList<Estado> estados = new ArrayList<>();
        estados.add(q4);
        estados.add(q5);
        estados.add(q0);
        estados.add(q7);
        estados.add(q3);
        estados.add(q1);
        estados.add(q8);
        estados.add(q2);
        estados.add(q6);
        estados.add(q9);
        Automato automato = new Automato(simbolos, operadores, estados, q4);
        
        return automato;
    }
    
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
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea editExpressao;
    private javax.swing.JTextArea editSaida;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
