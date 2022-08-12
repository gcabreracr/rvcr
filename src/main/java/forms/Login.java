package forms;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Propiedades;
import modelo.DAO.UsuarioDAOImpl;
import modelo.DAO.UsuarioPriDAOImpl;
import modelo.VO.UsuarioVO;
import modelo.VO.UsuarioPriVO;
import modelo.Validar;
import modelo.Variables;

public class Login extends javax.swing.JDialog {

    private final VentanaPrincipal padre;
    private UsuarioVO usr;
    private UsuarioPriVO usrPri;
    Validar valida = new Validar();
    Propiedades prop;

    public Login(VentanaPrincipal padre, boolean modal) throws IOException {
        super(padre, modal);
        this.padre = (VentanaPrincipal) padre;

        initComponents();

        prop = new Propiedades();
        
        txtCodUsu.setText(prop.leerUsuario());
        
        if (!txtCodUsu.getText().isEmpty()) {
            txtPassUsu.requestFocus();
        }

        valida.limitarCaracteres(txtCodUsu, Variables.L_COD_USU);
        valida.soloNumeros(txtPassUsu);
        valida.limitarCaracteres(txtPassUsu, Variables.L_PIN_USU);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBotones = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        paneDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodUsu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPassUsu = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso de Usuario");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelBotones, java.awt.BorderLayout.EAST);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Usuario");

        txtCodUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodUsuActionPerformed(evt);
            }
        });
        txtCodUsu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodUsuKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodUsuKeyTyped(evt);
            }
        });

        jLabel2.setText("PIN");

        txtPassUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassUsuActionPerformed(evt);
            }
        });
        txtPassUsu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassUsuKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPassUsuKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout paneDatosLayout = new javax.swing.GroupLayout(paneDatos);
        paneDatos.setLayout(paneDatosLayout);
        paneDatosLayout.setHorizontalGroup(
            paneDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneDatosLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(paneDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paneDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassUsu, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(txtCodUsu))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        paneDatosLayout.setVerticalGroup(
            paneDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneDatosLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(paneDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtPassUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(paneDatos, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodUsuActionPerformed

    }//GEN-LAST:event_txtCodUsuActionPerformed

    private void txtCodUsuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodUsuKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            this.txtPassUsu.requestFocus();
        }

    }//GEN-LAST:event_txtCodUsuKeyPressed

    private void txtCodUsuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodUsuKeyTyped


    }//GEN-LAST:event_txtCodUsuKeyTyped

    private void txtPassUsuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassUsuKeyTyped
        // TODO add your handling code here:


    }//GEN-LAST:event_txtPassUsuKeyTyped

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        if (this.txtCodUsu.getText().length() > 0) {

            usr = new UsuarioVO();

            String passUsuario = new String(txtPassUsu.getPassword());

            usr.setCodigoUsu(txtCodUsu.getText());
            usr.setPassUsu(passUsuario);

            try {
                setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
                if (UsuarioDAOImpl.login(usr)) {
                    if (!usr.getStatusUsu()) {
                        JOptionPane.showMessageDialog(this, "Usuario inactivo");
                        this.txtCodUsu.requestFocus();
                        return;
                    }

                    modelo.Variables.mCODUSU = usr.getCodigoUsu();
                    modelo.Variables.mNOMUSU = usr.getNombreUsu();
                    modelo.Variables.mTIPOUSU = usr.getTipoUsu();
                    modelo.Variables.mAGEUSU = usr.getCodAgencia();
                    modelo.Variables.mPDVUSU = usr.getCodPDV();
                    modelo.Variables.mBODUSU = usr.getCodBodega();
                    modelo.Variables.mNOMAGEUSU = usr.getNomAgencia();
                    modelo.Variables.mNOMPDVUSU = usr.getNomPDV();
                    modelo.Variables.mCATPDV = usr.getCatPDV();
                    String titulo = "Facturación y Control PDVs ---- Usuario: " + Variables.mNOMUSU;
                    padre.setTitle(titulo);

                    usrPri = new UsuarioPriVO();
                    usrPri.setCodUsuario(Variables.mCODUSU);

                    // Actualiza el usuario en el archivo properties
                    prop.updateUsuario(txtCodUsu.getText());

                    if (UsuarioPriDAOImpl.consulta(usrPri)) {

                        padre.jmnActDatos.setEnabled(usrPri.isMnActDat());
                        padre.jmnRepCli.setEnabled(usrPri.isMnRepCli());
                        //   padre.jmnActTras.setEnabled(usrPri.isMnActTras());
                        padre.jmnActProd.setEnabled(usrPri.isMnActProd());
                        padre.jmnActPrecios.setEnabled(usrPri.isMnActPrec());
                        padre.jmnAgencias.setVisible(usrPri.isMnActAgencias());
                        padre.jmnPdvs.setVisible(usrPri.isMnActPdv());
                        padre.jmnEmiFac.setEnabled(usrPri.isMnEmiFac());
                        VentanaPrincipal.jmnAnuFac.setEnabled(usrPri.isMnAnuFac());
                        padre.jmnFE_AceRecFac.setEnabled(usrPri.isMnAceRecFac());
                        padre.jmnFE_ReeFacRec.setEnabled(usrPri.isMnReeFacRec());
                        padre.jmnFE_NC.setEnabled(usrPri.isMnEmiNC());
                        padre.jmnFE_ND.setVisible(usrPri.isMnEmiND());
                        padre.jmnFE_FacCom.setEnabled(usrPri.isMnFacCom());
                        padre.jmnRepFac.setVisible(usrPri.isMnRepFac());
                        //  padre.jmnRepNC.setEnabled(usrPri.isMnRepNC());
                        // padre.jmnRepND.setEnabled(usrPri.isMnRepND());
                        //  padre.jmnRepFacCom.setEnabled(usrPri.isMnRepFacCom());
                        padre.jmnLiqCarDia.setEnabled(usrPri.isMnLiqCarDia());
                        padre.jmnLiqConEst.setVisible(usrPri.isMnLiqConEst());
                        padre.jmnUsuarios.setEnabled(usrPri.isMnUsuarios());

                    } else {
                        padre.jmnActDatos.setEnabled(false);
                        padre.jmnRepCli.setVisible(false);
                        //  padre.jmnActTras.setEnabled(false);
                        padre.jmnActProd.setEnabled(false);
                        padre.jmnActPrecios.setEnabled(false);
                        padre.jmnAgencias.setVisible(false);
                        padre.jmnPdvs.setVisible(false);
                        padre.jmnUsuarios.setVisible(false);
                        padre.jmnEmiFac.setEnabled(false);
                        VentanaPrincipal.jmnAnuFac.setEnabled(false);
                        padre.jmnFE_AceRecFac.setEnabled(false);
                        padre.jmnFE_ReeFacRec.setEnabled(false);
                        padre.jmnFE_NC.setEnabled(false);
                        padre.jmnFE_ND.setVisible(false);
                        padre.jmnFE_FacCom.setEnabled(false);
                        padre.jmnRepFac.setVisible(false);
                        padre.jmnLiqCarDia.setEnabled(false);
                        padre.jmnLiqConEst.setVisible(false);

                    }

                    this.dispose();

                } else {
                    JOptionPane.showMessageDialog(this, "Usuario o Password Incorrectos");
                    this.txtCodUsu.requestFocus();
                }
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe digitar un Usuario");
            this.txtCodUsu.requestFocus();
        }

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing

    }//GEN-LAST:event_formInternalFrameClosing

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated

    }//GEN-LAST:event_formInternalFrameActivated

    private void txtPassUsuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassUsuKeyPressed
        // TODO add your handling code here:


    }//GEN-LAST:event_txtPassUsuKeyPressed

    private void txtPassUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassUsuActionPerformed
        btnAceptar.requestFocus();
    }//GEN-LAST:event_txtPassUsuActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (Variables.mCODUSU == null) {
            System.exit(0);
        } else {
            Variables.frmLogin = null;
        }


    }//GEN-LAST:event_formWindowClosing

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        if (Variables.mCODUSU == null) {
            System.exit(0);
        } else {
            Variables.frmLogin = null;
            dispose();
        }

    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel paneDatos;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JTextField txtCodUsu;
    private javax.swing.JPasswordField txtPassUsu;
    // End of variables declaration//GEN-END:variables
}
