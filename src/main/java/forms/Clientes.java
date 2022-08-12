/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import interfaces.DistGeoDAO;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import metodos.ValidaCampos;
import metodos.VerificaEmail;
import modelo.VO.AgenciaVO;
import modelo.VO.ClienteVO;
import modelo.VO.PdvVO;
import modelo.DAO.DistGeoDAOImpl;
import modelo.DAO.AgenciaDAOImpl;
import modelo.DAO.ClienteDAOImpl;
import modelo.DAO.PdvDAOImpl;
import modelo.Validar;
import modelo.Variables;
import static modelo.Variables.L_ID_TRIBUTA;
import static modelo.Variables.L_COD_AGE;
import static modelo.Variables.L_COD_ITEC;
import static modelo.Variables.L_COD_PDV;
import static modelo.Variables.L_EMAIL;
import static modelo.Variables.L_MON_DESCTO;
import static modelo.Variables.L_NOM_CLI;
import static modelo.Variables.L_NOM_CONTACTO;
import static modelo.Variables.L_NOM_TRIBUTA;
import static modelo.Variables.L_NUM_TELNAC;
import static modelo.Variables.L_PLAZO;
import org.json.JSONException;
import org.json.JSONObject;

public class Clientes extends javax.swing.JInternalFrame {

    Validar valida = new Validar();
    ClienteVO clienteVo;
    DistGeoDAO distGeoDAO;

    private boolean nuevo;

    SimpleDateFormat sqlFecha = new SimpleDateFormat("yyyy-MM-dd");
    DecimalFormat formatoDecimal = new DecimalFormat("###,###,##0.00");
    DecimalFormat formatoInt3 = new DecimalFormat("###");
    DecimalFormat formatoInt2 = new DecimalFormat("##");
    DecimalFormat formatoGeo = new DecimalFormat("##0.000000");
    int mDesctoCli, mCreditoCli, mPlazoCredito;
    //double mLatidutd, mLongitud;

    public Clientes() {
        initComponents();

        distGeoDAO = new DistGeoDAOImpl();

        valida.limitarCaracteres(txtNomCliente, L_NOM_CLI);
        valida.limitarCaracteres(txtNomTributa, L_NOM_TRIBUTA);
        valida.soloNumeros(txtIdTributa);
        valida.limitarCaracteres(txtIdTributa, L_ID_TRIBUTA);
        valida.limitarCaracteres(txtEmail, L_EMAIL);
        valida.soloNumeros(txtCodPdv);
        valida.limitarCaracteres(txtCodPdv, L_COD_PDV);
        valida.soloNumeros(txtCodAge);
        valida.limitarCaracteres(txtCodAge, L_COD_AGE);
        valida.soloNumeros(txtTelNegocio);
        valida.limitarCaracteres(txtTelNegocio, L_NUM_TELNAC);
        valida.soloNumeros(txtTelContacto);
        valida.limitarCaracteres(txtTelContacto, L_NUM_TELNAC);
        valida.soloLetras(txtNomContacto);
        valida.limitarCaracteres(txtNomContacto, L_NOM_CONTACTO);
        valida.soloNumeros(txtCodItec);
        valida.limitarCaracteres(txtCodItec, L_COD_ITEC);
        valida.soloNumeros(txtDesctoCli);
        valida.limitarCaracteres(txtDesctoCli, L_MON_DESCTO);
        valida.soloNumeros(txtCreditoCli);
        valida.soloNumeros(txtPlazoCre);
        valida.limitarCaracteres(txtPlazoCre, L_PLAZO);

        limpiaCampos();
        inactivaCampos();
        txtCodCliente.requestFocus();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSuperior = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtCodCliente = new javax.swing.JTextField();
        lblMensajeAccion = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jtpCliente = new javax.swing.JTabbedPane();
        jpDatosGen = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNomCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNomTributa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIdTributa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTelNegocio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTelContacto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNomContacto = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        ckActivo = new javax.swing.JCheckBox();
        cbTipoId = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        txtCodItec = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jdcFecApertura = new com.toedter.calendar.JDateChooser();
        jpUbicacion = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        ckVisLun = new javax.swing.JCheckBox();
        ckVisMar = new javax.swing.JCheckBox();
        ckVisMie = new javax.swing.JCheckBox();
        ckVisJue = new javax.swing.JCheckBox();
        ckVisVie = new javax.swing.JCheckBox();
        ckVisSab = new javax.swing.JCheckBox();
        ckVisDom = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        txtProvincia = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCanton = new javax.swing.JTextField();
        txtDistrito = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtReferencia = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtCodAge = new javax.swing.JTextField();
        lblNomAge = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCodPdv = new javax.swing.JTextField();
        lblNomPdv = new javax.swing.JLabel();
        cbxProvincias = new javax.swing.JComboBox<>();
        cbxDistritos = new javax.swing.JComboBox<>();
        cbxCantones = new javax.swing.JComboBox<>();
        btnBuscaDir = new javax.swing.JButton();
        jpCreDescto = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtDesctoCli = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtCreditoCli = new javax.swing.JTextField();
        txtPlazoCre = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Actualiza clientes");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rv_logo.jpg"))); // NOI18N
        setName("actualizaClientes"); // NOI18N
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

        jLabel20.setLabelFor(txtCodCliente);
        jLabel20.setText("Código Interno");

        txtCodCliente.setToolTipText("CTRL + ENTER  buscar clientes");
        txtCodCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodClienteFocusGained(evt);
            }
        });
        txtCodCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodClienteActionPerformed(evt);
            }
        });
        txtCodCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodClienteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodClienteKeyTyped(evt);
            }
        });

        btnGuardar.setText("Actualizar");
        btnGuardar.setNextFocusableComponent(btnCancelar);
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

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMensajeAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblMensajeAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGuardar)
                        .addComponent(btnCancelar)
                        .addComponent(btnSalir)))
                .addGap(8, 8, 8))
        );

        getContentPane().add(panelSuperior, java.awt.BorderLayout.NORTH);

        jLabel2.setText("Nombre Comercial");

        txtNomCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomClienteFocusGained(evt);
            }
        });
        txtNomCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomClienteActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre Tributario");

        txtNomTributa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomTributaFocusGained(evt);
            }
        });
        txtNomTributa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomTributaActionPerformed(evt);
            }
        });

        jLabel4.setText("Id. Tributario");

        txtIdTributa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIdTributaFocusGained(evt);
            }
        });
        txtIdTributa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdTributaActionPerformed(evt);
            }
        });
        txtIdTributa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdTributaKeyTyped(evt);
            }
        });

        jLabel5.setText("Email");

        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
        });
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel6.setText("Telefono negocio");

        txtTelNegocio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelNegocioFocusGained(evt);
            }
        });
        txtTelNegocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelNegocioActionPerformed(evt);
            }
        });

        jLabel7.setText("Telefono contacto");

        txtTelContacto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelContactoFocusGained(evt);
            }
        });
        txtTelContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelContactoActionPerformed(evt);
            }
        });

        jLabel8.setText("Nombre contacto");

        txtNomContacto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomContactoFocusGained(evt);
            }
        });
        txtNomContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomContactoActionPerformed(evt);
            }
        });

        jLabel16.setText("Estado actual");

        ckActivo.setText("Activo");

        cbTipoId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1-Fisica", "2-Juridica", "3-DIMEX", "4-NITE" }));

        jLabel21.setText("Codigo ITEC");

        txtCodItec.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodItecFocusGained(evt);
            }
        });

        jLabel1.setText("Fecha Apertura");

        javax.swing.GroupLayout jpDatosGenLayout = new javax.swing.GroupLayout(jpDatosGen);
        jpDatosGen.setLayout(jpDatosGenLayout);
        jpDatosGenLayout.setHorizontalGroup(
            jpDatosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosGenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDatosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDatosGenLayout.createSequentialGroup()
                        .addGroup(jpDatosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpDatosGenLayout.createSequentialGroup()
                        .addGroup(jpDatosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpDatosGenLayout.createSequentialGroup()
                                .addGroup(jpDatosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(jpDatosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jpDatosGenLayout.createSequentialGroup()
                                        .addComponent(txtIdTributa, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbTipoId, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtNomCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                                    .addComponent(txtNomTributa)))
                            .addGroup(jpDatosGenLayout.createSequentialGroup()
                                .addGroup(jpDatosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addGap(24, 24, 24)
                                .addGroup(jpDatosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNomContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpDatosGenLayout.createSequentialGroup()
                                        .addComponent(txtTelNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(43, 43, 43)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTelContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtCodItec, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpDatosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jpDatosGenLayout.createSequentialGroup()
                                            .addComponent(ckActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel1)
                                            .addGap(18, 18, 18)
                                            .addComponent(jdcFecApertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(37, 37, 37))
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 254, Short.MAX_VALUE))))
        );
        jpDatosGenLayout.setVerticalGroup(
            jpDatosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosGenLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jpDatosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(jpDatosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDatosGenLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpDatosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomTributa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpDatosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdTributa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTipoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpDatosGenLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDatosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDatosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNomContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDatosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtTelContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDatosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpDatosGenLayout.createSequentialGroup()
                        .addGroup(jpDatosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtCodItec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpDatosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addGroup(jpDatosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ckActivo)
                                .addComponent(jLabel1))))
                    .addComponent(jdcFecApertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jtpCliente.addTab("Datos Generales", jpDatosGen);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Días Visita"));

        ckVisLun.setText("Lunes");

        ckVisMar.setText("Martes");

        ckVisMie.setText("Miercoles");

        ckVisJue.setText("Jueves");

        ckVisVie.setText("Viernes");

        ckVisSab.setText("Sabado");

        ckVisDom.setText("Domingo");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckVisLun)
                    .addComponent(ckVisMar)
                    .addComponent(ckVisMie)
                    .addComponent(ckVisJue)
                    .addComponent(ckVisVie)
                    .addComponent(ckVisSab)
                    .addComponent(ckVisDom))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ckVisLun)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ckVisMar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ckVisMie)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ckVisJue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ckVisVie)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ckVisSab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ckVisDom)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setText("Provincia");

        txtProvincia.setEnabled(false);
        txtProvincia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProvinciaFocusGained(evt);
            }
        });

        jLabel10.setText("Canton");

        txtCanton.setEnabled(false);

        txtDistrito.setEnabled(false);

        jLabel11.setText("Distrito");

        jLabel12.setText("Refererencia");

        jLabel13.setText("Agencia");

        txtCodAge.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodAgeFocusGained(evt);
            }
        });
        txtCodAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodAgeActionPerformed(evt);
            }
        });
        txtCodAge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodAgeKeyTyped(evt);
            }
        });

        lblNomAge.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel14.setText("Ruta/ Pdv");

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

        lblNomPdv.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        cbxProvincias.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxProvinciasItemStateChanged(evt);
            }
        });
        cbxProvincias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProvinciasActionPerformed(evt);
            }
        });

        cbxDistritos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxDistritosItemStateChanged(evt);
            }
        });

        cbxCantones.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCantonesItemStateChanged(evt);
            }
        });

        btnBuscaDir.setText("Buscar");
        btnBuscaDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaDirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpUbicacionLayout = new javax.swing.GroupLayout(jpUbicacion);
        jpUbicacion.setLayout(jpUbicacionLayout);
        jpUbicacionLayout.setHorizontalGroup(
            jpUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUbicacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12)
                    .addGroup(jpUbicacionLayout.createSequentialGroup()
                        .addGroup(jpUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpUbicacionLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(106, 106, 106)
                                .addComponent(jLabel10))
                            .addGroup(jpUbicacionLayout.createSequentialGroup()
                                .addGroup(jpUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtProvincia)
                                    .addComponent(cbxProvincias, 0, 149, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCanton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxCantones, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11)
                            .addComponent(cbxDistritos, 0, 163, Short.MAX_VALUE)
                            .addComponent(txtDistrito))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscaDir))
                    .addGroup(jpUbicacionLayout.createSequentialGroup()
                        .addGroup(jpUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                        .addGroup(jpUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpUbicacionLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodPdv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpUbicacionLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(txtCodAge, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(jpUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomPdv, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNomAge, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtReferencia))
                .addGap(18, 88, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        jpUbicacionLayout.setVerticalGroup(
            jpUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUbicacionLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jpUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpUbicacionLayout.createSequentialGroup()
                        .addGroup(jpUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(txtCodAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblNomAge, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(txtCodPdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblNomPdv, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCanton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbxDistritos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBuscaDir))
                            .addGroup(jpUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbxProvincias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbxCantones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jtpCliente.addTab("Ubicacion y visita", jpUbicacion);

        jLabel19.setText("Descuento Maximo ");

        txtDesctoCli.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDesctoCliFocusGained(evt);
            }
        });
        txtDesctoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDesctoCliActionPerformed(evt);
            }
        });

        jLabel24.setText("Credito autorizadio");

        jLabel25.setText("Plazo");

        txtCreditoCli.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCreditoCli.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCreditoCliFocusGained(evt);
            }
        });
        txtCreditoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCreditoCliActionPerformed(evt);
            }
        });

        txtPlazoCre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPlazoCreFocusGained(evt);
            }
        });

        jLabel26.setText("dias");

        jLabel15.setText("%");

        javax.swing.GroupLayout jpCreDesctoLayout = new javax.swing.GroupLayout(jpCreDescto);
        jpCreDescto.setLayout(jpCreDesctoLayout);
        jpCreDesctoLayout.setHorizontalGroup(
            jpCreDesctoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCreDesctoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jpCreDesctoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCreDesctoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCreDesctoLayout.createSequentialGroup()
                        .addComponent(txtDesctoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCreDesctoLayout.createSequentialGroup()
                        .addComponent(txtCreditoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPlazoCre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26)))
                .addContainerGap(480, Short.MAX_VALUE))
        );
        jpCreDesctoLayout.setVerticalGroup(
            jpCreDesctoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCreDesctoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCreDesctoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtDesctoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(4, 4, 4)
                .addGroup(jpCreDesctoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtCreditoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(txtPlazoCre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addContainerGap(234, Short.MAX_VALUE))
        );

        txtDesctoCli.getAccessibleContext().setAccessibleParent(txtDesctoCli);

        jtpCliente.addTab("Credito y Descuento", jpCreDescto);

        getContentPane().add(jtpCliente, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Variables.frmClientes = null;
    }//GEN-LAST:event_formWindowClosing

    private void txtTelContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelContactoActionPerformed
        // TODO add your handling code here:
        txtCodItec.requestFocus();
    }//GEN-LAST:event_txtTelContactoActionPerformed

    private void txtTelNegocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelNegocioActionPerformed
        // TODO add your handling code here:
        txtTelContacto.requestFocus();
    }//GEN-LAST:event_txtTelNegocioActionPerformed

    private void txtCodClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodClienteActionPerformed

        if (txtCodCliente.getText().length() > 0) {

            try {
                // Consulta cliente a modificar
                consultarCliente();
            } catch (SQLException ex) {
                Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error de conexion con el servidor");
            }

        } else {

            // Nuevo Cliente
            nuevo = true;
            limpiaCampos();
            activaCampos();
            this.lblMensajeAccion.setText("Nuevo cliente");
            this.jdcFecApertura.setCalendar(new java.util.GregorianCalendar());
            this.txtCodAge.setText(String.valueOf(Variables.mAGEUSU));
            this.lblNomAge.setText(Variables.mNOMAGEUSU);
            this.txtCodPdv.setText(String.valueOf(Variables.mPDVUSU));
            this.lblNomPdv.setText(Variables.mNOMPDVUSU);
            this.jtpCliente.setSelectedIndex(0);
            try {
                llenarComboProvincias();
            } catch (SQLException ex) {
                Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtNomCliente.requestFocus();

        }


    }//GEN-LAST:event_txtCodClienteActionPerformed

    private void txtCodClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodClienteKeyTyped

        if (!ValidaCampos.soloNumeros(evt.getKeyChar())) {
            evt.consume();
            return;
        }

        if (this.txtCodCliente.getText().length() >= Variables.L_COD_CLI) {
            evt.consume();
        }


    }//GEN-LAST:event_txtCodClienteKeyTyped

    private void txtNomClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomClienteActionPerformed
        // TODO add your handling code here:

        this.txtNomTributa.requestFocus();
    }//GEN-LAST:event_txtNomClienteActionPerformed

    private void txtNomTributaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomTributaActionPerformed
        // TODO add your handling code here:
        this.txtIdTributa.requestFocus();
    }//GEN-LAST:event_txtNomTributaActionPerformed

    private void txtIdTributaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdTributaActionPerformed
        // TODO add your handling code here:
        this.txtEmail.requestFocus();
    }//GEN-LAST:event_txtIdTributaActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
        this.txtNomContacto.requestFocus();
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtIdTributaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdTributaKeyTyped

        // TODO add your handling code here:

    }//GEN-LAST:event_txtIdTributaKeyTyped

    private void txtCodAgeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodAgeKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtCodAgeKeyTyped

    private void txtCodClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodClienteFocusGained
        // TODO add your handling code here:
        txtCodCliente.selectAll();
        this.lblMensajeAccion.setText("");
        // inactivaCampos();

    }//GEN-LAST:event_txtCodClienteFocusGained

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:

        txtCodCliente.setText("");
        limpiaCampos();
        inactivaCampos();
        txtCodCliente.requestFocus();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNomClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomClienteFocusGained
        // TODO add your handling code here:
        txtNomCliente.selectAll();
    }//GEN-LAST:event_txtNomClienteFocusGained

    private void txtNomTributaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomTributaFocusGained
        // TODO add your handling code here:
        txtNomTributa.selectAll();
    }//GEN-LAST:event_txtNomTributaFocusGained

    private void txtIdTributaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdTributaFocusGained
        // TODO add your handling code here:
        txtIdTributa.selectAll();
    }//GEN-LAST:event_txtIdTributaFocusGained

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        // TODO add your handling code here:
        txtEmail.selectAll();
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtNomContactoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomContactoFocusGained
        // TODO add your handling code here:
        txtNomContacto.selectAll();
    }//GEN-LAST:event_txtNomContactoFocusGained

    private void txtTelNegocioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelNegocioFocusGained
        // TODO add your handling code here:
        txtTelNegocio.selectAll();
    }//GEN-LAST:event_txtTelNegocioFocusGained

    private void txtTelContactoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelContactoFocusGained
        // TODO add your handling code here:
        txtTelContacto.selectAll();
    }//GEN-LAST:event_txtTelContactoFocusGained

    private void txtNomContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomContactoActionPerformed
        // TODO add your handling code here:
        txtTelNegocio.requestFocus();
    }//GEN-LAST:event_txtNomContactoActionPerformed

    private void txtDesctoCliFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDesctoCliFocusGained
        // TODO add your handling code here:
        txtDesctoCli.selectAll();
    }//GEN-LAST:event_txtDesctoCliFocusGained

    private void txtCodItecFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodItecFocusGained
        // TODO add your handling code here:
        txtCodItec.selectAll();
    }//GEN-LAST:event_txtCodItecFocusGained

    private void txtCodAgeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodAgeFocusGained
        // TODO add your handling code here:
        this.txtCodAge.selectAll();
    }//GEN-LAST:event_txtCodAgeFocusGained

    private void txtCodPdvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodPdvFocusGained
        // TODO add your handling code here:
        this.txtCodPdv.selectAll();
    }//GEN-LAST:event_txtCodPdvFocusGained

    private void txtProvinciaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProvinciaFocusGained
        // TODO add your handling code here:
        txtProvincia.selectAll();
    }//GEN-LAST:event_txtProvinciaFocusGained

    private void txtDesctoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDesctoCliActionPerformed
        // TODO add your handling code here:
        mDesctoCli = Integer.valueOf(txtDesctoCli.getText());
        //txtDesctoCli.setText(formatoInt2.format(mDesctoCli));
        txtCreditoCli.requestFocus();
    }//GEN-LAST:event_txtDesctoCliActionPerformed

    private void txtCreditoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCreditoCliActionPerformed
        // TODO add your handling code here:
        if (Double.valueOf(txtCreditoCli.getText()) > 0) {
            txtPlazoCre.requestFocus();
        }
        mCreditoCli = Integer.valueOf(txtCreditoCli.getText());
        Double tempValor = Double.valueOf(txtCreditoCli.getText());
        txtCreditoCli.setText(formatoDecimal.format(tempValor));
    }//GEN-LAST:event_txtCreditoCliActionPerformed

    private void txtCreditoCliFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCreditoCliFocusGained
        // TODO add your handling code here:
        txtCreditoCli.selectAll();
    }//GEN-LAST:event_txtCreditoCliFocusGained

    private void txtPlazoCreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPlazoCreFocusGained
        // TODO add your handling code here:
        txtPlazoCre.selectAll();
    }//GEN-LAST:event_txtPlazoCreFocusGained

    private void txtCodClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodClienteKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtCodClienteKeyReleased

    private void txtCodAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodAgeActionPerformed
        // TODO add your handling code here:
        if (this.txtCodAge.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Debe digitar un codigo de Agencia");
            this.txtCodAge.requestFocus();
            return;
        }

        try {
            consultarAgencia();
        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtCodAgeActionPerformed

    private void txtCodPdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodPdvActionPerformed
        // TODO add your handling code here:
        if (this.txtCodPdv.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Debe digitar un codigo de PDV/Ruta");
            this.txtCodPdv.requestFocus();
            return;
        }
        try {
            consultarPdv();
        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtCodPdvActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        // Valida campos de texto
        if (this.txtNomCliente.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Debe digitar un nombre comercial");
            this.jtpCliente.setSelectedIndex(0);
            txtNomCliente.requestFocus();
            return;
        }

        if (cbxProvincias.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una Provincia");
            this.jtpCliente.setSelectedIndex(1);
            cbxProvincias.requestFocus();
            return;
        }
        if (cbxCantones.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Cantón");
            this.jtpCliente.setSelectedIndex(1);
            cbxCantones.requestFocus();
            return;
        }
        if (cbxDistritos.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Distrito");
            this.jtpCliente.setSelectedIndex(1);
            cbxDistritos.requestFocus();
            return;
        }

        if (this.txtReferencia.getText().length() == 0) {
            JOptionPane.showMessageDialog(this.rootPane, "Debe digitar una direccion");
            this.jtpCliente.setSelectedIndex(1);
            txtReferencia.requestFocus();
            return;
        }
        if (txtEmail.getText().length() > 0) {
            if (!VerificaEmail.verificar(txtEmail.getText())) {
                JOptionPane.showMessageDialog(this, "Correo Electronico Incorrecto");
                txtEmail.requestFocus();
                return;
            }
        }

        if (txtNomTributa.getText().length() > 0) {
            if (txtIdTributa.getText().length() == 0) {
                JOptionPane.showMessageDialog(this.rootPane, "Debe introducir un numero de ID");
                txtIdTributa.requestFocus();
                return;
            } else {
                switch (cbTipoId.getSelectedIndex()) {
                    case 0:
                        if (txtIdTributa.getText().length() != 9) {
                            JOptionPane.showMessageDialog(this.rootPane, "Largo de ID incorrecto");
                            txtIdTributa.requestFocus();
                            return;
                        }
                        break;
                    case 1:
                        if (txtIdTributa.getText().length() != 10) {
                            JOptionPane.showMessageDialog(this.rootPane, "Largo de ID incorrecto");
                            txtIdTributa.requestFocus();
                            return;
                        }
                        break;
                    case 2:
                        if (txtIdTributa.getText().length() < 11 || txtIdTributa.getText().length() > 12) {
                            JOptionPane.showMessageDialog(this.rootPane, "Largo de ID incorrecto");
                            txtIdTributa.requestFocus();
                            return;
                        }
                        break;
                    case 3:
                        if (txtIdTributa.getText().length() != 10) {
                            JOptionPane.showMessageDialog(this.rootPane, "Largo de ID incorrecto");
                            txtIdTributa.requestFocus();
                            return;
                        }
                        break;
                }
            }
        } else {
            txtIdTributa.setText("");
            txtEmail.setText("");
            cbTipoId.setSelectedIndex(0);
        }

        btnGuardar.setEnabled(false);

        if (nuevo) {
            clienteVo = new ClienteVO();
        }

        clienteVo.setNom_cliente(txtNomCliente.getText());
        clienteVo.setNom_tributa(txtNomTributa.getText());
        clienteVo.setNom_cliente(txtNomCliente.getText());
        clienteVo.setId_tributa(txtIdTributa.getText());
        clienteVo.setTipo_id(cbTipoId.getSelectedItem().toString());
        clienteVo.setEmail_cliente(txtEmail.getText());
        clienteVo.setNom_contacto(txtNomContacto.getText());
        clienteVo.setTel_negocio(txtTelNegocio.getText());
        clienteVo.setTel_contacto(txtTelContacto.getText());
        clienteVo.setCodigo_itec(txtCodItec.getText());
        clienteVo.setStatus_cli(ckActivo.isSelected());
        clienteVo.setCod_agencia(Integer.valueOf(txtCodAge.getText()));
        clienteVo.setCod_ruta(Integer.valueOf(txtCodPdv.getText()));
        clienteVo.setIdProvincia(cbxProvincias.getSelectedIndex());
        clienteVo.setProvincia(cbxProvincias.getSelectedItem().toString());
        clienteVo.setIdCanton(cbxCantones.getSelectedIndex());
        clienteVo.setCanton(cbxCantones.getSelectedItem().toString());
        clienteVo.setIdDistrito(cbxDistritos.getSelectedIndex());
        clienteVo.setDistrito(cbxDistritos.getSelectedItem().toString());
        clienteVo.setReferencia(txtReferencia.getText());
        clienteVo.setVis_lun(ckVisLun.isSelected());
        clienteVo.setVis_mar(ckVisMar.isSelected());
        clienteVo.setVis_mie(ckVisMie.isSelected());
        clienteVo.setVis_jue(ckVisJue.isSelected());
        clienteVo.setVis_vie(ckVisVie.isSelected());
        clienteVo.setVis_sab(ckVisSab.isSelected());
        clienteVo.setVis_dom(ckVisDom.isSelected());
        clienteVo.setPlazo_credito(mPlazoCredito);
        clienteVo.setPor_descto(Integer.valueOf(txtDesctoCli.getText()));
        clienteVo.setMon_credito(mCreditoCli);

        SimpleDateFormat formatoYMD = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fecIngreso = jdcFecApertura.getDate();
        clienteVo.setFecapertura(formatoYMD.format(fecIngreso));
        java.util.Date fecCamSta = new java.util.Date();
        clienteVo.setFeccamsta(formatoYMD.format(fecCamSta));

        if (nuevo) {

            try {
                setCursor(new Cursor(Cursor.WAIT_CURSOR));
                incluirCliente();
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            } catch (SQLException ex) {
                Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error de conexion con el servidor");
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        } else {
            try {
                setCursor(new Cursor(Cursor.WAIT_CURSOR));
                modificarCliente();
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            } catch (SQLException ex) {
                Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error de conexion con el servidor");
            }
        }


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtCodClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodClienteKeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                buscarCliente();
                if (txtCodCliente.getText().length() > 0) {
                    consultarCliente();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error de conexion con el servidor");
                //limpiaCampos();
                //inactivaCampos();
                //txtCodCliente.requestFocus();
            }
        }

    }//GEN-LAST:event_txtCodClienteKeyPressed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:

        Variables.frmClientes = null;
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing

        Variables.frmClientes = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void cbxProvinciasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxProvinciasItemStateChanged
        try {
            cbxCantones.removeAllItems();
            llenarComboCantones(cbxProvincias.getSelectedIndex());
            //txtProvincia.setText(cbxProvincias.getSelectedItem().toString());
            cbxCantones.requestFocus();
        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error de conexion con el servidor");
        }

    }//GEN-LAST:event_cbxProvinciasItemStateChanged

    private void cbxDistritosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxDistritosItemStateChanged
        //txtDistrito.setText(cbxDistritos.getSelectedItem().toString());

    }//GEN-LAST:event_cbxDistritosItemStateChanged

    private void cbxCantonesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCantonesItemStateChanged
        try {
            //txtCanton.setText(cbxCantones.getSelectedItem().toString());
            cbxDistritos.removeAllItems();
            llenarComboDistritos(cbxProvincias.getSelectedIndex(), cbxCantones.getSelectedIndex());
            cbxCantones.requestFocus();
        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error de conexion con el servidor");
        }
    }//GEN-LAST:event_cbxCantonesItemStateChanged

    private void cbxProvinciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProvinciasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxProvinciasActionPerformed

    private void btnBuscaDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaDirActionPerformed
        try {
            BuscaDireccion buscarDireccion = new BuscaDireccion(null, true);
            buscarDireccion.setLocationRelativeTo(null);
            buscarDireccion.setVisible(true);
            JSONObject valorSelec = buscarDireccion.getDireccion();

            if (valorSelec != null) {
                //llenarComboProvincias();
                cbxProvincias.setSelectedIndex(valorSelec.getInt("idProvincia"));
                llenarComboCantones(valorSelec.getInt("idProvincia"));
                cbxCantones.setSelectedIndex(valorSelec.getInt("idCanton"));
                llenarComboDistritos(valorSelec.getInt("idProvincia"), valorSelec.getInt("idCanton"));
                cbxDistritos.setSelectedIndex(valorSelec.getInt("idDistrito"));
            }
            cbxProvincias.requestFocus();

        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnBuscaDirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscaDir;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbTipoId;
    private javax.swing.JComboBox<String> cbxCantones;
    private javax.swing.JComboBox<String> cbxDistritos;
    private javax.swing.JComboBox<String> cbxProvincias;
    private javax.swing.JCheckBox ckActivo;
    private javax.swing.JCheckBox ckVisDom;
    private javax.swing.JCheckBox ckVisJue;
    private javax.swing.JCheckBox ckVisLun;
    private javax.swing.JCheckBox ckVisMar;
    private javax.swing.JCheckBox ckVisMie;
    private javax.swing.JCheckBox ckVisSab;
    private javax.swing.JCheckBox ckVisVie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private com.toedter.calendar.JDateChooser jdcFecApertura;
    private javax.swing.JPanel jpCreDescto;
    private javax.swing.JPanel jpDatosGen;
    private javax.swing.JPanel jpUbicacion;
    private javax.swing.JTabbedPane jtpCliente;
    private javax.swing.JLabel lblMensajeAccion;
    private javax.swing.JLabel lblNomAge;
    private javax.swing.JLabel lblNomPdv;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JTextField txtCanton;
    private javax.swing.JTextField txtCodAge;
    private javax.swing.JTextField txtCodCliente;
    private javax.swing.JTextField txtCodItec;
    private javax.swing.JTextField txtCodPdv;
    private javax.swing.JTextField txtCreditoCli;
    private javax.swing.JTextField txtDesctoCli;
    private javax.swing.JTextField txtDistrito;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIdTributa;
    private javax.swing.JTextField txtNomCliente;
    private javax.swing.JTextField txtNomContacto;
    private javax.swing.JTextField txtNomTributa;
    private javax.swing.JTextField txtPlazoCre;
    private javax.swing.JTextField txtProvincia;
    private javax.swing.JTextField txtReferencia;
    private javax.swing.JTextField txtTelContacto;
    private javax.swing.JTextField txtTelNegocio;
    // End of variables declaration//GEN-END:variables

    private void inactivaCampos() {
        //   jtpCliente.setEnabled(false);
        txtNomCliente.setEnabled(false);
        txtNomTributa.setEnabled(false);
        txtIdTributa.setEnabled(false);
        cbTipoId.setEnabled(false);
        txtEmail.setEnabled(false);
        txtNomContacto.setEnabled(false);
        txtTelNegocio.setEnabled(false);
        txtNomContacto.setEnabled(false);
        txtTelContacto.setEnabled(false);
        txtCodItec.setEnabled(false);
        ckActivo.setEnabled(false);
        jdcFecApertura.setEnabled(false);
        txtCodAge.setEnabled(false);
        txtCodPdv.setEnabled(false);
        txtProvincia.setEnabled(false);
        cbxProvincias.setEnabled(false);
        txtCanton.setEnabled(false);
        cbxCantones.setEnabled(false);
        txtDistrito.setEnabled(false);
        cbxDistritos.setEnabled(false);
        txtReferencia.setEnabled(false);
        ckVisLun.setEnabled(false);
        ckVisMar.setEnabled(false);
        ckVisMie.setEnabled(false);
        ckVisJue.setEnabled(false);
        ckVisVie.setEnabled(false);
        ckVisSab.setEnabled(false);
        ckVisDom.setEnabled(false);
        txtDesctoCli.setEnabled(false);
        txtCreditoCli.setEnabled(false);
        txtPlazoCre.setEnabled(false);
        btnGuardar.setEnabled(false);

    }

    private void activaCampos() {
        jtpCliente.setEnabled(true);
        txtNomCliente.setEnabled(true);
        txtNomTributa.setEnabled(true);
        txtIdTributa.setEnabled(true);
        cbTipoId.setEnabled(true);
        txtEmail.setEnabled(true);
        txtNomContacto.setEnabled(true);
        txtTelNegocio.setEnabled(true);
        txtTelContacto.setEnabled(true);
        txtCodItec.setEnabled(true);
        btnGuardar.setEnabled(true);

        if (Variables.mTIPOUSU >= 3) {
            ckActivo.setEnabled(true);
        } else {
            ckActivo.setEnabled(false);
        }

        if (Variables.mTIPOUSU == 4) {
            txtCodAge.setEnabled(true);
        } else {
            txtCodAge.setEnabled(false);
        }
        if (Variables.mTIPOUSU >= 2) {
            txtCodPdv.setEnabled(true);
        } else {
            txtCodPdv.setEnabled(false);
        }

        //txtProvincia.setEnabled(true);
        cbxProvincias.setEnabled(true);
        //txtCanton.setEnabled(true);
        cbxCantones.setEnabled(true);
        //txtDistrito.setEnabled(true);
        cbxDistritos.setEnabled(true);
        if (nuevo) {
            jdcFecApertura.setEnabled(true);
        } else {
            jdcFecApertura.setEnabled(false);
        }

        txtReferencia.setEnabled(true);
        if (Variables.mTIPOUSU >= 2) {
            ckVisLun.setEnabled(true);
            ckVisMar.setEnabled(true);
            ckVisMie.setEnabled(true);
            ckVisJue.setEnabled(true);
            ckVisVie.setEnabled(true);
            ckVisSab.setEnabled(true);
            ckVisDom.setEnabled(true);
        } else {
            ckVisLun.setEnabled(false);
            ckVisMar.setEnabled(false);
            ckVisMie.setEnabled(false);
            ckVisJue.setEnabled(false);
            ckVisVie.setEnabled(false);
            ckVisSab.setEnabled(false);
            ckVisDom.setEnabled(false);
        }
        if (Variables.mTIPOUSU > 2) {
            txtDesctoCli.setEnabled(true);
            txtCreditoCli.setEnabled(true);
            txtPlazoCre.setEnabled(true);
        } else {
            txtDesctoCli.setEnabled(false);
            txtCreditoCli.setEnabled(false);
            txtPlazoCre.setEnabled(false);
        }

    }

    private void limpiaCampos() {

        txtNomCliente.setText("");
        txtNomTributa.setText("");
        txtIdTributa.setText("");
        cbTipoId.setSelectedIndex(0);
        txtEmail.setText("");
        txtNomContacto.setText("");
        txtTelNegocio.setText("");
        txtTelContacto.setText("");
        txtCodItec.setText("");
        ckActivo.setSelected(true);
        txtCodAge.setText("");
        lblNomAge.setText("");
        txtCodPdv.setText("");
        lblNomPdv.setText("");
        txtReferencia.setText("");
        txtProvincia.setText("");
        //cbxProvincias.removeAllItems();
        //cbxCantones.removeAllItems();
        //cbxDistritos.removeAllItems();
        txtCanton.setText("");
        txtDistrito.setText("");
        ckVisLun.setSelected(false);
        ckVisMar.setSelected(false);
        ckVisMie.setSelected(false);
        ckVisJue.setSelected(false);
        ckVisVie.setSelected(false);
        ckVisSab.setSelected(false);
        ckVisDom.setSelected(false);
        txtDesctoCli.setText(formatoInt2.format(0));
        mDesctoCli = 0;
        txtCreditoCli.setText(formatoDecimal.format(0.00));
        mCreditoCli = 0;
        txtPlazoCre.setText(formatoInt2.format(0));
        mPlazoCredito = 0;

    }

    private void consultarCliente() throws SQLException {

        setCursor(new Cursor(Cursor.WAIT_CURSOR));

        AgenciaVO agenciaVo = new AgenciaVO();
        PdvVO pdvVO = new PdvVO();

        clienteVo = new ClienteVO();
        clienteVo.setCod_cliente(Integer.valueOf(txtCodCliente.getText()));
        if (ClienteDAOImpl.consultar(clienteVo)) {

            jtpCliente.setSelectedIndex(0);

            nuevo = false;
            lblMensajeAccion.setText("Modifica cliente");
            txtNomCliente.setText(clienteVo.getNom_cliente());
            txtNomTributa.setText(clienteVo.getNom_tributa());
            txtIdTributa.setText(clienteVo.getId_tributa());
            int iTipoId = Integer.valueOf(clienteVo.getTipo_id().substring(0, 1)) - 1;
            cbTipoId.setSelectedIndex(iTipoId);
            txtEmail.setText(clienteVo.getEmail_cliente());
            txtNomContacto.setText(clienteVo.getNom_contacto());
            txtTelNegocio.setText(clienteVo.getTel_negocio());
            txtTelContacto.setText(clienteVo.getTel_contacto());
            txtCodItec.setText(clienteVo.getCodigo_itec());
            ckActivo.setSelected(clienteVo.isStatus_cli());
            txtCodAge.setText(String.valueOf(clienteVo.getCod_agencia()));
            txtCodPdv.setText(String.valueOf(clienteVo.getCod_ruta()));
            txtProvincia.setText(clienteVo.getProvincia());
            txtCanton.setText(clienteVo.getCanton());
            txtDistrito.setText(clienteVo.getDistrito());
            txtReferencia.setText(clienteVo.getReferencia());
            ckVisLun.setSelected(clienteVo.isVis_lun());
            ckVisMar.setSelected(clienteVo.isVis_mar());
            ckVisMie.setSelected(clienteVo.isVis_mie());
            ckVisJue.setSelected(clienteVo.isVis_jue());
            ckVisVie.setSelected(clienteVo.isVis_vie());
            ckVisSab.setSelected(clienteVo.isVis_sab());
            ckVisDom.setSelected(clienteVo.isVis_dom());
            txtDesctoCli.setText(formatoInt2.format(clienteVo.getPor_descto()));
            mDesctoCli = clienteVo.getPor_descto();
            txtPlazoCre.setText(formatoInt2.format(clienteVo.getPlazo_credito()));
            mPlazoCredito = clienteVo.getPlazo_credito();
            txtCreditoCli.setText(formatoDecimal.format(clienteVo.getMon_credito()));
            mCreditoCli = clienteVo.getMon_credito();
            agenciaVo.setCodagencia(clienteVo.getCod_agencia());
            pdvVO.setCodAgencia(clienteVo.getCod_agencia());
            pdvVO.setCodPdv(clienteVo.getCod_ruta());

            if (AgenciaDAOImpl.consultar(agenciaVo)) {
                this.lblNomAge.setText(agenciaVo.getNomagencia());
            }
            if (PdvDAOImpl.consultar(pdvVO)) {
                this.lblNomPdv.setText(pdvVO.getNomPdv());
            }

            try {
                java.util.Date dFecha = sqlFecha.parse(clienteVo.getFecapertura());
                jdcFecApertura.setDate(dFecha);
            } catch (ParseException ex) {
                Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (Variables.mTIPOUSU < 4 && clienteVo.getCod_agencia() != Variables.mAGEUSU) {
                inactivaCampos();
                jtpCliente.setSelectedIndex(1);
                JOptionPane.showMessageDialog(rootPane, "Usuario NO autorizado para modificar clientes de esta Agencia");

                limpiaCampos();
                txtCodCliente.requestFocus();
                return;
            }
            if (Variables.mTIPOUSU == 1 && clienteVo.getCod_ruta() != Variables.mPDVUSU) {

                inactivaCampos();
                jtpCliente.setSelectedIndex(1);
                JOptionPane.showMessageDialog(rootPane, "Usuario NO autorizado para modificar clientes de este Punto de Ventas");

                limpiaCampos();
                txtCodCliente.requestFocus();
                return;
            }

            llenarComboProvincias();
            cbxProvincias.setSelectedIndex(clienteVo.getIdProvincia());

            if (clienteVo.getIdProvincia() > 0) {
                llenarComboCantones(clienteVo.getIdProvincia());
                cbxCantones.setSelectedIndex(clienteVo.getIdCanton());
            }

            llenarComboDistritos(clienteVo.getIdProvincia(), clienteVo.getIdCanton());
            cbxDistritos.setSelectedIndex(clienteVo.getIdDistrito());

            activaCampos();
            txtNomCliente.requestFocus();

        } else {
            jtpCliente.setSelectedIndex(0);

            JOptionPane.showMessageDialog(this, "Cliente NO existe");
            limpiaCampos();
            inactivaCampos();
            txtCodCliente.setText("");
            txtCodCliente.requestFocus();

        }
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

    }

    private void consultarAgencia() throws SQLException {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));

        AgenciaVO agencia = new AgenciaVO();
        agencia.setCodagencia(Integer.valueOf(txtCodAge.getText()));

        if (AgenciaDAOImpl.consultar(agencia)) {

            this.lblNomAge.setText(agencia.getNomagencia());
            this.txtCodPdv.requestFocus();

        } else {
            JOptionPane.showMessageDialog(null, "Agencia no existe");
            txtCodAge.requestFocus();
        }
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

    }

    private void consultarPdv() throws SQLException {

        setCursor(new Cursor(Cursor.WAIT_CURSOR));

        PdvVO pdv = new PdvVO();
        pdv.setCodAgencia(Integer.valueOf(txtCodAge.getText()));
        pdv.setCodPdv(Integer.valueOf(txtCodPdv.getText()));

        if (PdvDAOImpl.consultar(pdv)) {

            this.lblNomPdv.setText(pdv.getNomPdv());
            //this.txtCodBodega.requestFocus();
        } else {
            JOptionPane.showMessageDialog(rootPane, "PDV/Ruta no existe");
            txtCodPdv.requestFocus();
        }
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

    }

    private void incluirCliente() throws SQLException {

        int codigo_cliente = ClienteDAOImpl.incluir(clienteVo);       

        txtCodCliente.setText(String.valueOf(codigo_cliente));
        jtpCliente.setSelectedIndex(0);
        JOptionPane.showMessageDialog(this, "Cliente Incluido");
        txtCodCliente.setText("");
        limpiaCampos();
        inactivaCampos();
        txtCodCliente.requestFocus();

    }

    private void modificarCliente() throws SQLException {

        clienteVo.setCod_cliente(Integer.valueOf(txtCodCliente.getText()));
      
        ClienteDAOImpl.actualiza(clienteVo);

        jtpCliente.setSelectedIndex(0);
        JOptionPane.showMessageDialog(this, "Cliente Actualizado");
        txtCodCliente.setText("");
        limpiaCampos();
        inactivaCampos();
        txtCodCliente.requestFocus();

    }

    private void buscarCliente() throws SQLException {

        BuscaCliente buscarCliente = new BuscaCliente(null, true);
        buscarCliente.setLocationRelativeTo(null);
        buscarCliente.setVisible(true);
        String valorSelec = buscarCliente.getCodCliente();
        txtCodCliente.setText(valorSelec);
        txtCodCliente.requestFocus();

    }

    private void llenarComboProvincias() throws SQLException {

        cbxProvincias.setModel(new DefaultComboBoxModel(distGeoDAO.llenaComboProvincias()));

    }

    private void llenarComboCantones(int idProvincia) throws SQLException {

        cbxCantones.setModel(new DefaultComboBoxModel(distGeoDAO.llenaComboCantones(idProvincia)));

    }

    private void llenarComboDistritos(int idProvincia, int idCanton) throws SQLException {

        cbxDistritos.setModel(new DefaultComboBoxModel(distGeoDAO.llenaComboDistritos(idProvincia, idCanton)));
    }

}// Fin de clase clientes
