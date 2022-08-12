package forms;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.DAO.UsuarioDAOImpl;
import modelo.VO.UsuarioVO;
import modelo.Validar;
import modelo.Variables;

public class CambiarPin extends javax.swing.JInternalFrame {

    private UsuarioVO usr;
    Validar valida = new Validar();

    public CambiarPin() {
        initComponents();
        valida.soloNumeros(txtPinActual);
        valida.limitarCaracteres(txtPinActual, Variables.L_PIN_USU);
        valida.soloNumeros(txtNuevoPin);
        valida.limitarCaracteres(txtNuevoPin, Variables.L_PIN_USU);
        valida.soloNumeros(txtConfirmaPin);
        valida.limitarCaracteres(txtConfirmaPin, Variables.L_PIN_USU);

        usr = new UsuarioVO();
        usr.setCodigoUsu(Variables.mCODUSU);

        txtCodigoUsu.setText(Variables.mCODUSU);
        txtNomUsu.setText(Variables.mNOMUSU);
        txtPinActual.requestFocus();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigoUsu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNomUsu = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPinActual = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        txtNuevoPin = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        txtConfirmaPin = new javax.swing.JPasswordField();
        btnCambiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cambiar Pin de Acceso");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Codigo Usuario");

        txtCodigoUsu.setEditable(false);

        jLabel2.setText("Nombre Usuario");

        txtNomUsu.setEditable(false);

        jLabel3.setText("PIN Actual");

        txtPinActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPinActualActionPerformed(evt);
            }
        });

        jLabel4.setText("Nuevo PIN");

        txtNuevoPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNuevoPinActionPerformed(evt);
            }
        });

        jLabel5.setText("Confirmar PIN");

        txtConfirmaPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfirmaPinActionPerformed(evt);
            }
        });

        btnCambiar.setText("Cambiar");
        btnCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtConfirmaPin, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNuevoPin, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPinActual, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCambiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigoUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCambiar))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPinActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtNuevoPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnSalir)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtConfirmaPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Variables.frmCambiaPin=null;
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtPinActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPinActualActionPerformed
        txtNuevoPin.requestFocus();
    }//GEN-LAST:event_txtPinActualActionPerformed

    private void txtNuevoPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNuevoPinActionPerformed
        txtConfirmaPin.requestFocus();
    }//GEN-LAST:event_txtNuevoPinActionPerformed

    private void txtConfirmaPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmaPinActionPerformed
        btnCambiar.requestFocus();
    }//GEN-LAST:event_txtConfirmaPinActionPerformed

    private void btnCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarActionPerformed

        String pinActual = new String(txtPinActual.getPassword());
        String nuevoPin = new String(txtNuevoPin.getPassword());
        String confirmaPin = new String(txtConfirmaPin.getPassword());

        if (!nuevoPin.equals(confirmaPin)) {
            JOptionPane.showMessageDialog(this, "Confirmacion de nuevo PIN no coincide");
            txtNuevoPin.requestFocus();
            return;
        }

        usr.setPassUsu(pinActual);

        try {
            if (UsuarioDAOImpl.login(usr)) {
                usr.setPassUsu(nuevoPin);
                UsuarioDAOImpl.actualizaPin(usr);
                JOptionPane.showMessageDialog(this, "Nuevo PIN Actualizado");
                dispose();

            } else {
                JOptionPane.showMessageDialog(this, "Pin Actual Incorrecto");
                txtPinActual.requestFocus();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CambiarPin.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnCambiarActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
       
        Variables.frmCambiaPin=null;
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCodigoUsu;
    private javax.swing.JPasswordField txtConfirmaPin;
    private javax.swing.JTextField txtNomUsu;
    private javax.swing.JPasswordField txtNuevoPin;
    private javax.swing.JPasswordField txtPinActual;
    // End of variables declaration//GEN-END:variables
}
