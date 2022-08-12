package forms;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.VO.AgenciaVO;
import modelo.VO.PdvVO;
import modelo.DAO.AgenciaDAOImpl;
import modelo.DAO.PdvDAOImpl;
import modelo.DAO.UsuarioDAOImpl;
import modelo.DAO.UsuarioPriDAOImpl;
import modelo.VO.UsuarioVO;
import modelo.VO.UsuarioPriVO;
import modelo.Variables;

import static modelo.Variables.L_COD_USU;

public class Usuarios extends javax.swing.JInternalFrame {

    private UsuarioVO usr;
    private UsuarioPriVO usrPri;

    private PdvVO pdv;
    private AgenciaVO agencia;
    private boolean nuevo;

    public Usuarios() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodUsu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNomUsu = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbTipUsu = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodAgencia = new javax.swing.JTextField();
        txtCodPdv = new javax.swing.JTextField();
        lblNomAgencia = new javax.swing.JLabel();
        lblNomPdv = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCodBodega = new javax.swing.JTextField();
        cbActivo = new javax.swing.JCheckBox();
        btnOtrosPDV = new javax.swing.JButton();
        lblNuevo = new javax.swing.JLabel();
        panelBotones = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        panelPrivilegios = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        ckActDat = new javax.swing.JCheckBox();
        ckActAgencias = new javax.swing.JCheckBox();
        ckActPdv = new javax.swing.JCheckBox();
        ckRepCli = new javax.swing.JCheckBox();
        ckUsuarios = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        ckEmiFac = new javax.swing.JCheckBox();
        ckAnuFac = new javax.swing.JCheckBox();
        ckAceFac = new javax.swing.JCheckBox();
        ckReeFacRec = new javax.swing.JCheckBox();
        ckEmiNC = new javax.swing.JCheckBox();
        ckEmiFacCom = new javax.swing.JCheckBox();
        ckRepFact = new javax.swing.JCheckBox();
        ckEmiND = new javax.swing.JCheckBox();
        ckCarDia = new javax.swing.JCheckBox();
        ckConLiq = new javax.swing.JCheckBox();
        ckActProd = new javax.swing.JCheckBox();
        ckActPrecios = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Actualiza Usuarios");
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

        panelDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel1.setText("Codigo");

        txtCodUsu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodUsuFocusGained(evt);
            }
        });
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

        jLabel2.setText("Nombre");

        txtNomUsu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomUsuFocusGained(evt);
            }
        });
        txtNomUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomUsuActionPerformed(evt);
            }
        });

        jLabel3.setText("Tipo Usuario");

        cbTipUsu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Normal", "Supervisor", "Administrador", "Super Adm" }));
        cbTipUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipUsuActionPerformed(evt);
            }
        });

        jLabel4.setText("Agencia");

        jLabel5.setText("Punto ventas");

        txtCodAgencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodAgenciaFocusGained(evt);
            }
        });
        txtCodAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodAgenciaActionPerformed(evt);
            }
        });

        txtCodPdv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodPdvFocusGained(evt);
            }
        });
        txtCodPdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodPdvActionPerformed(evt);
            }
        });

        lblNomAgencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblNomPdv.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel6.setText("Código Bodega");

        txtCodBodega.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodBodegaFocusGained(evt);
            }
        });
        txtCodBodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodBodegaActionPerformed(evt);
            }
        });

        cbActivo.setText("Activo");

        btnOtrosPDV.setText("Otros PDVs");

        lblNuevo.setText(" ");

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(txtCodAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNomAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(btnOtrosPDV))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(txtCodPdv, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNomPdv, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCodBodega, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbActivo))
                        .addContainerGap(16, Short.MAX_VALUE))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(txtCodUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNomUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTipUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbTipUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNomAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtCodAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCodPdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addComponent(lblNomPdv, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtCodBodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbActivo))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(btnOtrosPDV)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar)
                .addGap(3, 3, 3)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelPrivilegios.setBorder(javax.swing.BorderFactory.createTitledBorder("Privilegios Acceso"));

        ckActDat.setText("Actualiza Clientes");

        ckActAgencias.setText("Actualiza Agencias");

        ckActPdv.setText("Actualiza PDV/Rutas");

        ckRepCli.setText("Reporte Clientes");

        ckUsuarios.setText("Actualiza Usuarios");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckActDat)
                    .addComponent(ckRepCli))
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckUsuarios)
                    .addComponent(ckActAgencias)
                    .addComponent(ckActPdv))
                .addGap(0, 289, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckActDat)
                    .addComponent(ckActAgencias))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckActPdv)
                    .addComponent(ckRepCli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ckUsuarios)
                .addContainerGap(149, Short.MAX_VALUE))
        );

        panelPrivilegios.addTab("Mantenimiento", jPanel2);

        ckEmiFac.setText("Emisión Facturas");

        ckAnuFac.setText("Anulación Facturas");

        ckAceFac.setText("Aceptar/Rechazar FE");

        ckReeFacRec.setText("Reenviar Facturas Rechazadas");

        ckEmiNC.setText("Notas de Credito");

        ckEmiFacCom.setText("Facturas de Compra");

        ckRepFact.setText("Reportes FE");

        ckEmiND.setText("Nota de Debito");

        ckCarDia.setText("Carga Diaria Liquidacion");

        ckConLiq.setText("Consulta Liquidacion Diaria");

        ckActProd.setText("Actualiza Productos");

        ckActPrecios.setText("Actualiza Precios");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckEmiFac)
                    .addComponent(ckAnuFac)
                    .addComponent(ckActPrecios)
                    .addComponent(ckActProd))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ckRepFact)
                            .addComponent(ckEmiFacCom))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ckEmiND)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ckReeFacRec)
                                    .addComponent(ckAceFac)
                                    .addComponent(ckEmiNC))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ckConLiq)
                                    .addComponent(ckCarDia))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ckEmiFac)
                            .addComponent(ckCarDia)
                            .addComponent(ckAceFac))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ckReeFacRec, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ckAnuFac)
                                .addComponent(ckConLiq)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ckEmiNC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ckEmiND))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(ckActProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ckActPrecios)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ckEmiFacCom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ckRepFact)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        panelPrivilegios.addTab("Facturacion y Liquidacion", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPrivilegios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelPrivilegios, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodUsuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodUsuFocusGained
        this.txtCodUsu.selectAll();
        //inactivaCampos();
    }//GEN-LAST:event_txtCodUsuFocusGained

    private void txtCodUsuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodUsuKeyPressed

    }//GEN-LAST:event_txtCodUsuKeyPressed

    private void txtCodUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodUsuActionPerformed
        // TODO add your handling code here:
        if (this.txtCodUsu.getText().length() > 0) {
            usr = new UsuarioVO();
            usrPri = new UsuarioPriVO();
            usr.setCodigoUsu(txtCodUsu.getText());

            try {
                if (UsuarioDAOImpl.consultar(usr)) {
                    nuevo = false;

                    activaCampos();
                    this.lblNuevo.setText("Modifica Usuario");
                    this.txtNomUsu.setText(usr.getNombreUsu());
                    this.txtCodAgencia.setText(String.valueOf(usr.getCodAgencia()));
                    this.lblNomAgencia.setText(usr.getNomAgencia());
                    this.txtCodPdv.setText(String.valueOf(usr.getCodPDV()));
                    this.lblNomPdv.setText(usr.getNomPDV());
                    this.txtCodBodega.setText(usr.getCodBodega());
                    this.cbActivo.setSelected(usr.getStatusUsu());
                    this.cbTipUsu.setSelectedIndex(usr.getTipoUsu());
                    this.txtNomUsu.requestFocus();

                    consultaPrivilegios();

                } else {
                    
                    
                    
                    nuevo = true;
                    limpiarCampos();
                    activaCampos();
                    this.lblNuevo.setText("Usuario nuevo");
                    this.txtNomUsu.requestFocus();
                    this.cbActivo.setSelected(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_txtCodUsuActionPerformed

    private void txtCodUsuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodUsuKeyTyped
        // TODO add your handling code here:
        if (this.txtCodUsu.getText().length() >= L_COD_USU) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodUsuKeyTyped

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
        inactivaCampos();
        this.txtCodUsu.setText("");
        this.txtCodUsu.requestFocus();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNomUsuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomUsuFocusGained
        this.txtNomUsu.selectAll();
    }//GEN-LAST:event_txtNomUsuFocusGained

    private void txtCodAgenciaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodAgenciaFocusGained
        // TODO add your handling code here:
        this.txtCodAgencia.selectAll();
    }//GEN-LAST:event_txtCodAgenciaFocusGained

    private void txtCodPdvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodPdvFocusGained
        // TODO add your handling code here:
        this.txtCodPdv.selectAll();
    }//GEN-LAST:event_txtCodPdvFocusGained

    private void txtCodBodegaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodBodegaFocusGained
        // TODO add your handling code here:
        this.txtCodBodega.selectAll();
    }//GEN-LAST:event_txtCodBodegaFocusGained

    private void txtNomUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomUsuActionPerformed
        // TODO add your handling code here:
        this.txtCodAgencia.requestFocus();
    }//GEN-LAST:event_txtNomUsuActionPerformed

    private void txtCodAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodAgenciaActionPerformed
        // TODO add your handling code here:
        if (this.txtCodAgencia.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Debe digitar un codigo de Agencia");
            this.txtCodAgencia.requestFocus();
            return;
        }

        agencia = new AgenciaVO();
        agencia.setCodagencia(Integer.valueOf(txtCodAgencia.getText()));

        try {
            if (AgenciaDAOImpl.consultar(agencia)) {

                this.lblNomAgencia.setText(agencia.getNomagencia());
                this.txtCodPdv.requestFocus();
            } else {
                JOptionPane.showMessageDialog(this, "Agencia no existe");
                txtCodAgencia.requestFocus();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_txtCodAgenciaActionPerformed

    private void txtCodPdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodPdvActionPerformed
        // TODO add your handling code here:
        if (this.txtCodPdv.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Debe digitar un codigo de PDV/Ruta");
            this.txtCodPdv.requestFocus();
            return;
        }

        pdv = new PdvVO();
        pdv.setCodAgencia(Integer.valueOf(txtCodAgencia.getText()));
        pdv.setCodPdv(Integer.valueOf(txtCodPdv.getText()));

        try {
            if (PdvDAOImpl.consultar(pdv)) {

                this.lblNomPdv.setText(pdv.getNomPdv());
                this.txtCodBodega.requestFocus();
            } else {
                JOptionPane.showMessageDialog(this, "PDV/Ruta no existe");
                txtCodPdv.requestFocus();
            }
            // usr.setCodigoUsu(txtCodUsu.getText());
            // usr.setNombreUsu(txtNomUsu.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_txtCodPdvActionPerformed

    private void txtCodBodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodBodegaActionPerformed
        // TODO add your handling code here:
        this.cbTipUsu.requestFocus();
    }//GEN-LAST:event_txtCodBodegaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:

        if (this.txtNomUsu.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "El nombre del usuario NO puede estar en blanco");
            this.txtNomUsu.requestFocus();
            return;
        }
        if (this.txtCodAgencia.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una Agencia");
            this.txtCodAgencia.requestFocus();
            return;
        }
        if (this.txtCodPdv.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Punto de Ventas");
            this.txtCodAgencia.requestFocus();
            return;
        }

        usr.setCodigoUsu(this.txtCodUsu.getText());
        // usr.setCodigoUsu(txtCodUsu.getText());
        usr.setNombreUsu(txtNomUsu.getText());
        usr.setTipoUsu(cbTipUsu.getSelectedIndex());
        usr.setCodAgencia(Integer.valueOf(txtCodAgencia.getText()));
        usr.setCodPDV(Integer.valueOf(txtCodPdv.getText()));
        usr.setCodBodega(txtCodBodega.getText());

        if (cbActivo.isSelected()) {
            usr.setStatusUsu(true);
        } else {
            usr.setStatusUsu(false);
        }

        if (nuevo) {
            usr.setPassUsu("1234567");
        }

        if (nuevo) {
            UsuarioDAOImpl.incluir(usr);
            actualizaPrivilegios(true);

            JOptionPane.showMessageDialog(this, "Usuario Incluido");
            limpiarCampos();
            inactivaCampos();
            txtCodUsu.setText("");
            txtCodUsu.requestFocus();

        } else {
            UsuarioDAOImpl.actualizar(usr);
            actualizaPrivilegios(false);

            JOptionPane.showMessageDialog(this, "Usuario Modificado");
            limpiarCampos();
            inactivaCampos();
            txtCodUsu.setText("");
            txtCodUsu.requestFocus();
        }


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        
        Variables.frmUsuarios = null;
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void cbTipUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipUsuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipUsuActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing

        Variables.frmUsuarios = null;

    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnOtrosPDV;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox cbActivo;
    private javax.swing.JComboBox<String> cbTipUsu;
    private javax.swing.JCheckBox ckAceFac;
    private javax.swing.JCheckBox ckActAgencias;
    private javax.swing.JCheckBox ckActDat;
    private javax.swing.JCheckBox ckActPdv;
    private javax.swing.JCheckBox ckActPrecios;
    private javax.swing.JCheckBox ckActProd;
    private javax.swing.JCheckBox ckAnuFac;
    private javax.swing.JCheckBox ckCarDia;
    private javax.swing.JCheckBox ckConLiq;
    private javax.swing.JCheckBox ckEmiFac;
    private javax.swing.JCheckBox ckEmiFacCom;
    private javax.swing.JCheckBox ckEmiNC;
    private javax.swing.JCheckBox ckEmiND;
    private javax.swing.JCheckBox ckReeFacRec;
    private javax.swing.JCheckBox ckRepCli;
    private javax.swing.JCheckBox ckRepFact;
    private javax.swing.JCheckBox ckUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblNomAgencia;
    private javax.swing.JLabel lblNomPdv;
    private javax.swing.JLabel lblNuevo;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JTabbedPane panelPrivilegios;
    private javax.swing.JTextField txtCodAgencia;
    private javax.swing.JTextField txtCodBodega;
    private javax.swing.JTextField txtCodPdv;
    private javax.swing.JTextField txtCodUsu;
    private javax.swing.JTextField txtNomUsu;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {

        this.txtNomUsu.setText("");
        this.txtCodBodega.setText("");
        this.txtCodAgencia.setText("");
        this.txtCodPdv.setText("");
        this.lblNomAgencia.setText("");
        this.lblNomPdv.setText("");

        this.cbActivo.setSelected(false);
        this.ckAceFac.setEnabled(false);
        this.ckActAgencias.setSelected(false);
        this.ckActDat.setSelected(false);
        this.ckRepCli.setSelected(false);
        this.ckActPdv.setSelected(false);
        this.ckActPrecios.setSelected(false);
        this.ckActProd.setSelected(false);
        this.ckAnuFac.setSelected(false);
        this.ckCarDia.setSelected(false);
        this.ckConLiq.setSelected(false);
        this.ckEmiFac.setSelected(false);
        this.ckEmiFacCom.setSelected(false);
        this.ckEmiNC.setSelected(false);
        this.ckEmiND.setSelected(false);
        this.ckReeFacRec.setSelected(false);
        this.ckRepFact.setSelected(false);
        this.ckUsuarios.setSelected(false);
        this.cbTipUsu.setSelectedIndex(0);

    }

    private void inactivaCampos() {
        this.panelPrivilegios.setEnabled(false);
        this.txtCodAgencia.setEnabled(false);
        this.txtCodPdv.setEnabled(false);
        this.txtNomUsu.setEnabled(false);
        this.cbActivo.setEnabled(false);
        this.txtCodBodega.setEnabled(false);
        this.cbTipUsu.setEnabled(false);
        this.ckAceFac.setEnabled(false);
        this.ckActAgencias.setEnabled(false);
        this.ckActDat.setEnabled(false);
        this.ckRepCli.setEnabled(false);
        this.ckActPdv.setEnabled(false);
        this.ckActPrecios.setEnabled(false);
        this.ckActProd.setEnabled(false);
        this.btnOtrosPDV.setEnabled(false);
        this.ckUsuarios.setEnabled(false);
        this.ckAnuFac.setEnabled(false);
        this.ckCarDia.setEnabled(false);
        this.ckConLiq.setEnabled(false);
        this.ckEmiFac.setEnabled(false);
        this.ckEmiFacCom.setEnabled(false);
        this.ckEmiNC.setEnabled(false);
        this.ckEmiND.setEnabled(false);
        this.ckReeFacRec.setEnabled(false);
        this.ckRepFact.setEnabled(false);

    }

    private void activaCampos() {
        this.panelPrivilegios.setEnabled(true);
        this.txtCodAgencia.setEnabled(true);
        this.txtCodPdv.setEnabled(true);
        this.txtNomUsu.setEnabled(true);
        this.cbActivo.setEnabled(true);
        this.txtCodBodega.setEnabled(true);
        this.cbTipUsu.setEnabled(true);
        this.btnOtrosPDV.setEnabled(true);
        this.ckAceFac.setEnabled(true);
        this.ckActAgencias.setEnabled(true);
        this.ckActDat.setEnabled(true);
        this.ckRepCli.setEnabled(true);
        this.ckActPdv.setEnabled(true);
        this.ckActPrecios.setEnabled(true);
        this.ckActProd.setEnabled(true);
        this.ckUsuarios.setEnabled(true);
        this.ckAnuFac.setEnabled(true);
        this.ckCarDia.setEnabled(true);
        this.ckConLiq.setEnabled(true);
        this.ckEmiFac.setEnabled(true);
        this.ckEmiFacCom.setEnabled(true);
        this.ckEmiNC.setEnabled(true);
        this.ckEmiND.setEnabled(true);
        this.ckReeFacRec.setEnabled(true);
        this.ckRepFact.setEnabled(true);
    }

    private void consultaPrivilegios() throws SQLException {

        
        usrPri.setCodUsuario(usr.getCodigoUsu());

        if (UsuarioPriDAOImpl.consulta(usrPri)) {
            ckActDat.setSelected(usrPri.isMnActDat());
            ckRepCli.setSelected(usrPri.isMnRepCli());
            ckUsuarios.setSelected(usrPri.isMnUsuarios());
            ckActProd.setSelected(usrPri.isMnActProd());
            ckActPrecios.setSelected(usrPri.isMnActPrec());
            ckActAgencias.setSelected(usrPri.isMnActAgencias());
            ckActPdv.setSelected(usrPri.isMnActPdv());
            ckEmiFac.setSelected(usrPri.isMnEmiFac());
            ckAnuFac.setSelected(usrPri.isMnAnuFac());
            ckAceFac.setSelected(usrPri.isMnAceRecFac());
            ckReeFacRec.setSelected(usrPri.isMnReeFacRec());
            ckEmiNC.setSelected(usrPri.isMnEmiNC());
            ckEmiND.setSelected(usrPri.isMnEmiND());
            ckEmiFacCom.setSelected(usrPri.isMnFacCom());
            ckRepFact.setSelected(usrPri.isMnRepFac());
            ckCarDia.setSelected(usrPri.isMnLiqCarDia());
            ckConLiq.setSelected(usrPri.isMnLiqConEst());

        } else {
            ckActDat.setSelected(false);
            ckRepCli.setSelected(false);
            ckUsuarios.setSelected(false);
            ckActProd.setSelected(false);
            ckActPrecios.setSelected(false);
            ckActAgencias.setSelected(false);
            ckActPdv.setSelected(false);
            ckEmiFac.setSelected(false);
            ckAnuFac.setSelected(false);
            ckAceFac.setSelected(false);
            ckReeFacRec.setSelected(false);
            ckEmiNC.setSelected(false);
            ckEmiND.setSelected(false);
            ckEmiFacCom.setSelected(false);
            ckRepFact.setSelected(false);
            ckCarDia.setSelected(false);
            ckConLiq.setSelected(false);

        }

    }

    private void actualizaPrivilegios(boolean nuevo) {

        usrPri = new UsuarioPriVO();
        usrPri.setCodUsuario(txtCodUsu.getText());
        if (ckActDat.isSelected()) {
            usrPri.setMnActDat(true);
        } else {
            usrPri.setMnActDat(false);
        }
        if (ckRepCli.isSelected()) {
            usrPri.setMnRepCli(true);
        } else {
            usrPri.setMnRepCli(false);
        }
        if (ckUsuarios.isSelected()) {
            usrPri.setMnUsuarios(true);
        } else {
            usrPri.setMnUsuarios(false);
        }
        if (ckActProd.isSelected()) {
            usrPri.setMnActProd(true);
        } else {
            usrPri.setMnActProd(false);
        }
        if (ckActPrecios.isSelected()) {
            usrPri.setMnActPrec(true);
        } else {
            usrPri.setMnActPrec(false);
        }
        if (ckActAgencias.isSelected()) {
            usrPri.setMnActAgencias(true);
        } else {
            usrPri.setMnActAgencias(false);
        }
        if (ckActPdv.isSelected()) {
            usrPri.setMnActPdv(true);
        } else {
            usrPri.setMnActPdv(false);
        }
        if (ckEmiFac.isSelected()) {
            usrPri.setMnEmiFac(true);
        } else {
            usrPri.setMnEmiFac(false);
        }
        if (ckAnuFac.isSelected()) {
            usrPri.setMnAnuFac(true);
        } else {
            usrPri.setMnAnuFac(false);
        }
        if (ckAceFac.isSelected()) {
            usrPri.setMnAceRecFac(true);
        } else {
            usrPri.setMnAceRecFac(false);
        }
        if (ckReeFacRec.isSelected()) {
            usrPri.setMnReeFacRec(true);
        } else {
            usrPri.setMnReeFacRec(false);
        }
        if (ckEmiNC.isSelected()) {
            usrPri.setMnEmiNC(true);
        } else {
            usrPri.setMnEmiNC(false);
        }
        if (ckEmiND.isSelected()) {
            usrPri.setMnEmiND(true);
        } else {
            usrPri.setMnEmiND(false);
        }
        if (ckEmiFacCom.isSelected()) {
            usrPri.setMnFacCom(true);
        } else {
            usrPri.setMnFacCom(false);
        }
        if (ckRepFact.isSelected()) {
            usrPri.setMnRepFac(true);
        } else {
            usrPri.setMnRepFac(false);
        }
        if (ckCarDia.isSelected()) {
            usrPri.setMnLiqCarDia(true);
        } else {
            usrPri.setMnLiqCarDia(false);
        }
        if (ckConLiq.isSelected()) {
            usrPri.setMnLiqConEst(true);
        } else {
            usrPri.setMnLiqConEst(false);
        }

        if (nuevo) {
            UsuarioPriDAOImpl.incluir(usrPri);
        } else {
            UsuarioPriDAOImpl.modificar(usrPri);
        }
    }

}
