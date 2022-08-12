package forms;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import metodos.Redondear;
import modelo.VO.ArticuloVO;
import modelo.VO.ClienteVO;
import modelo.HttpClient;
import modelo.VO.ItemFacVO;
import modelo.VO.PrecioVO;
import modelo.DAO.PrecioDAOImpl;
import modelo.Validar;
import modelo.Variables;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EmiteNotaCredito extends javax.swing.JInternalFrame {

    DefaultTableModel dtmArticulos;
    ArrayList<ItemFacVO> listaItemFacVo;
    ArticuloVO articuloVo;
    PrecioVO precioVo;
    JSONArray jsonItems;
    Validar valida;
    BarraProgreso bp;
    ClienteVO clienteVo;
    ArrayList<ItemFacVO> listaItemFac;
    ItemFacVO itemFacVo;
    SimpleDateFormat sqlFecha = new SimpleDateFormat("yyyy-MM-dd");

    String clave_fe, consecutivo_fe, mTipoId;
    String tipoDoc = "01";
    String tipoFac = "01";
    int mPorDesctoCli, mPlazoCre, mMontoCredito, mPorDesctoArt, mIvaArt, mPorDescto, iCantidad, mRedondeo;
    int lineaSelec, mCodCliente, mCodAgencia, mCodPdv;
    double mPrecio, mDesctoArt, mImptoArt, mSubTotalArt, mTotalArt, mSubTotalFac, mDesctoFac, mImptoFac, mTotalFac, mTotExento, mTotGravado;
    double aDesctoArt, aImptoArt, aSubTotalArt, aTotalArt;

    DecimalFormat formatoDecimal = new DecimalFormat("###,###,##0.00");
    DecimalFormat formatoEntero = new DecimalFormat("#####,##0");

    public EmiteNotaCredito() {
        initComponents();
        valida = new Validar();
        bp = new BarraProgreso();

        valida.limitarCaracteres(txtNumFactura, 10);
        valida.soloNumeros(txtNumFactura);
        valida.limitarCaracteres(txtDescto, Variables.L_MON_DESCTO);
        valida.soloNumeros(txtDescto);
        valida.soloNumeros(txtCantidad);
        valida.limitarCaracteres(txtCantidad, 12);
        mRedondeo = 0;
      
        inactivaCampos();
        limpiaCampos();
        panelDatosCliente.requestFocus();
        txtNumFactura.requestFocus();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgTipDoc = new javax.swing.ButtonGroup();
        btgTipFac = new javax.swing.ButtonGroup();
        btnEnviar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jtpFactura = new javax.swing.JTabbedPane();
        panelDatosCliente = new javax.swing.JPanel();
        lblNomCliente = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIdFactura = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNomFactura = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbTipoId = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        rbFacEle = new javax.swing.JRadioButton();
        rbTiqEle = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rbContado = new javax.swing.JRadioButton();
        rbCredito = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        txtPlazo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jdcFecFactura = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        txtNumFactura = new javax.swing.JTextField();
        panelDetallFactura = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtArticulos = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        txtCodArt = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtDescto = new javax.swing.JTextField();
        btnModificaArt = new javax.swing.JButton();
        btnEliminaArt = new javax.swing.JButton();
        txtCantidad = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblSubTotArt = new javax.swing.JLabel();
        lblIvaArt = new javax.swing.JLabel();
        lblDesctoArt = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblTotalArt = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        btnSeleccionaArt = new javax.swing.JButton();
        txtNomArt = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lblMonGravado = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblMonExento = new javax.swing.JLabel();
        lblSubTotalFac = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblDesctoFac = new javax.swing.JLabel();
        lblIvaFac = new javax.swing.JLabel();
        lblTotalFac = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaNotas = new javax.swing.JTextArea();

        setClosable(true);
        setTitle("Emite Nota de Credito");
        setEnabled(false);
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

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
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

        lblNomCliente.setText(" ");
        lblNomCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel4.setText("Fecha");

        jLabel3.setText("Cliente");

        txtIdFactura.setText(" ");
        txtIdFactura.setEnabled(false);
        txtIdFactura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIdFacturaFocusGained(evt);
            }
        });
        txtIdFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdFacturaActionPerformed(evt);
            }
        });

        jLabel5.setText("Nombre a facturar");

        txtNomFactura.setEnabled(false);
        txtNomFactura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomFacturaFocusGained(evt);
            }
        });
        txtNomFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomFacturaActionPerformed(evt);
            }
        });

        jLabel6.setText("ID");

        jLabel7.setText("Tipo ID");

        cbTipoId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1-Fisica", "2-Juridica", "3-DIMEX", "4-NITE" }));
        cbTipoId.setEnabled(false);

        jLabel8.setText("Email");

        txtEmail.setEnabled(false);
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

        btgTipDoc.add(rbFacEle);
        rbFacEle.setSelected(true);
        rbFacEle.setText("Factura Electronica");
        rbFacEle.setEnabled(false);
        rbFacEle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFacEleActionPerformed(evt);
            }
        });

        btgTipDoc.add(rbTiqEle);
        rbTiqEle.setText("Tiquete Electronico");
        rbTiqEle.setEnabled(false);
        rbTiqEle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTiqEleActionPerformed(evt);
            }
        });

        jLabel9.setText("Tipo Documento");

        jLabel10.setText("Tipo factura");

        btgTipFac.add(rbContado);
        rbContado.setSelected(true);
        rbContado.setText("Contado");
        rbContado.setEnabled(false);
        rbContado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbContadoActionPerformed(evt);
            }
        });

        btgTipFac.add(rbCredito);
        rbCredito.setText("Credito");
        rbCredito.setEnabled(false);
        rbCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCreditoActionPerformed(evt);
            }
        });

        jLabel11.setText("Plazo");

        txtPlazo.setEnabled(false);
        txtPlazo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPlazoFocusGained(evt);
            }
        });

        jLabel12.setText("dias");

        jdcFecFactura.setEnabled(false);
        jdcFecFactura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jdcFecFacturaFocusGained(evt);
            }
        });
        jdcFecFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jdcFecFacturaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jdcFecFacturaMousePressed(evt);
            }
        });

        jLabel1.setText("Cons. Interno");

        txtNumFactura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNumFacturaFocusGained(evt);
            }
        });
        txtNumFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumFacturaActionPerformed(evt);
            }
        });
        txtNumFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumFacturaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelDatosClienteLayout = new javax.swing.GroupLayout(panelDatosCliente);
        panelDatosCliente.setLayout(panelDatosClienteLayout);
        panelDatosClienteLayout.setHorizontalGroup(
            panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosClienteLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelDatosClienteLayout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtIdFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)
                            .addComponent(cbTipoId, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(261, 261, Short.MAX_VALUE))
                        .addGroup(panelDatosClienteLayout.createSequentialGroup()
                            .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelDatosClienteLayout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelDatosClienteLayout.createSequentialGroup()
                                            .addGap(225, 225, 225)
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jdcFecFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelDatosClienteLayout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(rbFacEle)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(rbTiqEle))))
                                .addGroup(panelDatosClienteLayout.createSequentialGroup()
                                    .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNomCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(160, 160, Short.MAX_VALUE)))
                    .addGroup(panelDatosClienteLayout.createSequentialGroup()
                        .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel5))
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosClienteLayout.createSequentialGroup()
                                .addComponent(rbContado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbCredito)
                                .addGap(82, 82, 82)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel12))
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(226, 226, Short.MAX_VALUE))))
        );
        panelDatosClienteLayout.setVerticalGroup(
            panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosClienteLayout.createSequentialGroup()
                .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosClienteLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jdcFecFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(6, 6, 6)
                .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblNomCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbTiqEle)
                        .addComponent(rbFacEle)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(cbTipoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtIdFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(txtNomFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbContado)
                    .addComponent(jLabel10)
                    .addComponent(rbCredito)
                    .addComponent(txtPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtpFactura.addTab("Datos del cliente", panelDatosCliente);

        panelDetallFactura.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtArticulos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jtArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripcion", "Cantidad", "Precio", "Descuento", "IVA", "Monto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtArticulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtArticulosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtArticulos);
        if (jtArticulos.getColumnModel().getColumnCount() > 0) {
            jtArticulos.getColumnModel().getColumn(0).setResizable(false);
            jtArticulos.getColumnModel().getColumn(0).setPreferredWidth(20);
            jtArticulos.getColumnModel().getColumn(1).setResizable(false);
            jtArticulos.getColumnModel().getColumn(1).setPreferredWidth(120);
            jtArticulos.getColumnModel().getColumn(2).setResizable(false);
            jtArticulos.getColumnModel().getColumn(2).setPreferredWidth(15);
            jtArticulos.getColumnModel().getColumn(3).setResizable(false);
            jtArticulos.getColumnModel().getColumn(3).setPreferredWidth(15);
            jtArticulos.getColumnModel().getColumn(4).setResizable(false);
            jtArticulos.getColumnModel().getColumn(4).setPreferredWidth(15);
            jtArticulos.getColumnModel().getColumn(5).setResizable(false);
            jtArticulos.getColumnModel().getColumn(5).setPreferredWidth(15);
            jtArticulos.getColumnModel().getColumn(6).setResizable(false);
            jtArticulos.getColumnModel().getColumn(6).setPreferredWidth(25);
        }

        jLabel19.setText("Codigo");

        txtCodArt.setText(" ");
        txtCodArt.setEnabled(false);
        txtCodArt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodArtFocusGained(evt);
            }
        });
        txtCodArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodArtActionPerformed(evt);
            }
        });
        txtCodArt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodArtKeyPressed(evt);
            }
        });

        jLabel20.setText("Cantidad");

        jLabel21.setText("Descuento");

        txtDescto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDescto.setText(" ");
        txtDescto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDesctoFocusGained(evt);
            }
        });
        txtDescto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDesctoActionPerformed(evt);
            }
        });

        btnModificaArt.setText("Modificar");
        btnModificaArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificaArtActionPerformed(evt);
            }
        });

        btnEliminaArt.setText("Eliminar");
        btnEliminaArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminaArtActionPerformed(evt);
            }
        });

        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCantidad.setText(" ");
        txtCantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCantidadFocusGained(evt);
            }
        });
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        jLabel22.setText("Precio");

        jLabel23.setText("%");

        lblSubTotArt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubTotArt.setText(" ");
        lblSubTotArt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblIvaArt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIvaArt.setText(" ");
        lblIvaArt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblDesctoArt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDesctoArt.setText(" ");
        lblDesctoArt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel24.setText("Sub-Total");

        lblTotalArt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalArt.setText(" ");
        lblTotalArt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel25.setText("Monto Descuento");

        jLabel26.setText("Monto IVA 13%");

        jLabel27.setText("Total ");

        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPrecio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecioFocusGained(evt);
            }
        });
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        btnSeleccionaArt.setText("Selecciona");
        btnSeleccionaArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionaArtActionPerformed(evt);
            }
        });

        txtNomArt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomArtFocusGained(evt);
            }
        });
        txtNomArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomArtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDetallFacturaLayout = new javax.swing.GroupLayout(panelDetallFactura);
        panelDetallFactura.setLayout(panelDetallFacturaLayout);
        panelDetallFacturaLayout.setHorizontalGroup(
            panelDetallFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetallFacturaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDetallFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelDetallFacturaLayout.createSequentialGroup()
                        .addGroup(panelDetallFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel22)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addGroup(panelDetallFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodArt, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelDetallFacturaLayout.createSequentialGroup()
                                .addComponent(txtDescto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel23))
                            .addComponent(txtPrecio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDetallFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDetallFacturaLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(panelDetallFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel27))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelDetallFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblTotalArt, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelDetallFacturaLayout.createSequentialGroup()
                                        .addComponent(lblDesctoArt, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addComponent(btnModificaArt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(panelDetallFacturaLayout.createSequentialGroup()
                                        .addComponent(lblSubTotArt, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addComponent(btnSeleccionaArt, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelDetallFacturaLayout.createSequentialGroup()
                                        .addComponent(lblIvaArt, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addComponent(btnEliminaArt, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(113, 113, 113))
                            .addComponent(txtNomArt))
                        .addGap(58, 58, 58))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        panelDetallFacturaLayout.setVerticalGroup(
            panelDetallFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetallFacturaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDetallFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtCodArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDetallFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(lblSubTotArt)
                    .addComponent(jLabel20)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionaArt))
                .addGap(6, 6, 6)
                .addGroup(panelDetallFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(lblDesctoArt)
                    .addComponent(jLabel22)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificaArt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDetallFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addGroup(panelDetallFacturaLayout.createSequentialGroup()
                        .addGroup(panelDetallFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(lblIvaArt)
                            .addComponent(btnEliminaArt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDetallFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel27)
                            .addComponent(lblTotalArt)))
                    .addGroup(panelDetallFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel23)
                        .addComponent(txtDescto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        jtpFactura.addTab("Detalle de la factura", panelDetallFactura);

        lblMonGravado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMonGravado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel13.setText("Gravado");

        lblMonExento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMonExento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblSubTotalFac.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubTotalFac.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel14.setText("Exento");

        jLabel15.setText("Sub-Total");

        lblDesctoFac.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDesctoFac.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblIvaFac.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIvaFac.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblTotalFac.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTotalFac.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalFac.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel16.setText("Descuento");

        jLabel17.setText("Impuesto");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Total Nota Credito");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMonGravado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSubTotalFac, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMonExento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel17)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIvaFac, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDesctoFac, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotalFac, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblMonGravado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMonExento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addComponent(lblSubTotalFac, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDesctoFac, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblIvaFac, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTotalFac, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtaNotas.setColumns(20);
        jtaNotas.setRows(5);
        jtaNotas.setBorder(javax.swing.BorderFactory.createTitledBorder("Notas"));
        jtaNotas.setEnabled(false);
        jScrollPane2.setViewportView(jtaNotas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtpFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir))
                    .addComponent(jtpFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificaArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificaArtActionPerformed

        modificaArticulo();
    }//GEN-LAST:event_btnModificaArtActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        inactivaCampos();
        limpiaCampos();
        lblNomCliente.setText("");
        txtNumFactura.requestFocus();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Variables.frmEmiNC = null;
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void rbTiqEleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTiqEleActionPerformed

    }//GEN-LAST:event_rbTiqEleActionPerformed

    private void jdcFecFacturaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jdcFecFacturaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jdcFecFacturaFocusGained

    private void txtIdFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdFacturaActionPerformed
        // TODO add your handling code here:
        txtNomFactura.requestFocus();
    }//GEN-LAST:event_txtIdFacturaActionPerformed

    private void txtIdFacturaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFacturaFocusGained
        // TODO add your handling code here:
        txtIdFactura.selectAll();
    }//GEN-LAST:event_txtIdFacturaFocusGained

    private void txtNomFacturaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomFacturaFocusGained
        // TODO add your handling code here:
        txtNomFactura.selectAll();
    }//GEN-LAST:event_txtNomFacturaFocusGained

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        // TODO add your handling code here:
        txtEmail.selectAll();
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtPlazoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPlazoFocusGained
        // TODO add your handling code here:
        txtPlazo.selectAll();
    }//GEN-LAST:event_txtPlazoFocusGained

    private void txtCodArtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodArtFocusGained
        // TODO add your handling code here:
        txtCodArt.selectAll();
    }//GEN-LAST:event_txtCodArtFocusGained

    private void txtDesctoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDesctoFocusGained
        // TODO add your handling code here:
        txtDescto.selectAll();
    }//GEN-LAST:event_txtDesctoFocusGained

    private void rbContadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbContadoActionPerformed

        txtPlazo.setEnabled(false);
        txtPlazo.setText("0");
        tipoFac = "01";
        txtCodArt.requestFocus();
    }//GEN-LAST:event_rbContadoActionPerformed

    private void rbCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCreditoActionPerformed
        // TODO add your handling code here:
        txtPlazo.setEnabled(true);
        tipoFac = "02";
        txtPlazo.requestFocus();
    }//GEN-LAST:event_rbCreditoActionPerformed

    private void txtNomFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomFacturaActionPerformed
        // TODO add your handling code here:
        txtEmail.requestFocus();
    }//GEN-LAST:event_txtNomFacturaActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
        txtCodArt.requestFocus();
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtCodArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodArtActionPerformed

    }//GEN-LAST:event_txtCodArtActionPerformed

    private void txtCantidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFocusGained
        // TODO add your handling code here:
        txtCantidad.selectAll();
    }//GEN-LAST:event_txtCantidadFocusGained

    private void jdcFecFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jdcFecFacturaMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jdcFecFacturaMouseClicked

    private void jdcFecFacturaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jdcFecFacturaMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jdcFecFacturaMousePressed

    private void txtCodArtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodArtKeyPressed

    }//GEN-LAST:event_txtCodArtKeyPressed

    private void rbFacEleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFacEleActionPerformed
        // TODO add your handling code here:
        txtNomFactura.setEnabled(true);
        txtIdFactura.setEnabled(true);
        txtEmail.setEnabled(true);
        txtPlazo.setEnabled(true);
        cbTipoId.setEnabled(true);
        rbContado.setEnabled(true);
        rbCredito.setEnabled(true);
        txtIdFactura.requestFocus();
        tipoDoc = "01";

    }//GEN-LAST:event_rbFacEleActionPerformed

    private void txtDesctoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDesctoActionPerformed
        // TODO add your handling code here:
        calculaMontos();
        btnModificaArt.requestFocus();

    }//GEN-LAST:event_txtDesctoActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed

        try {
            enviaNota();
        } catch (IOException ex) {
            Logger.getLogger(EmiteNotaCredito.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(EmiteNotaCredito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnEnviarActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:

        calculaMontos();
        txtPrecio.requestFocus();
        /*        if (articuloVo.getTipo_item() == 1) {
         txtDescto.requestFocus();
         } else {
         txtPrecio.requestFocus();
         }*/


    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnEliminaArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaArtActionPerformed
        // TODO add your handling code here:
        int filaSelec = jtArticulos.getSelectedRow();
        if (filaSelec != -1) {

            if (listaItemFac.get(filaSelec).getExento() == 1) {
                mTotExento -= listaItemFac.get(filaSelec).getMon_subtotal();
            } else {
                mTotGravado -= listaItemFac.get(filaSelec).getMon_subtotal();
            }
            mSubTotalFac -= listaItemFac.get(filaSelec).getMon_subtotal();
            mDesctoFac -= listaItemFac.get(filaSelec).getMon_descto();
            mImptoFac -= listaItemFac.get(filaSelec).getMon_impto();
            mTotalFac = mSubTotalFac - mDesctoFac + mImptoFac;
            lblMonExento.setText(formatoDecimal.format(mTotExento));
            lblMonGravado.setText(formatoDecimal.format(mTotGravado));
            lblSubTotalFac.setText(formatoDecimal.format(mSubTotalFac));
            lblDesctoFac.setText(formatoDecimal.format(mDesctoFac));
            lblIvaFac.setText(formatoDecimal.format(mImptoFac));
            lblTotalFac.setText(formatoDecimal.format(mTotalFac));
            txtCodArt.setText("");
            txtCantidad.setText("0");
            txtDescto.setText("0");
            txtPrecio.setText("");
            txtNomArt.setText("");
            lblSubTotArt.setText("0");
            lblDesctoArt.setText("0");
            lblIvaArt.setText("0");
            lblTotalArt.setText("0");
            txtCodArt.requestFocus();

            listaItemFac.remove(filaSelec);
            dtmArticulos.removeRow(filaSelec);

        } else {
            JOptionPane.showMessageDialog(this, "Selecciones una fila a eliminar");
        }


    }//GEN-LAST:event_btnEliminaArtActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        mPrecio = Double.valueOf(txtPrecio.getText().replace(",", ""));
        txtPrecio.setText(formatoDecimal.format(mPrecio));
        calculaMontos();
        btnModificaArt.requestFocus();

    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtPrecioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioFocusGained
        // TODO add your handling code here:
        txtPrecio.selectAll();
    }//GEN-LAST:event_txtPrecioFocusGained

    private void txtNumFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumFacturaActionPerformed
        if (txtNumFactura.getText().length() > 0) {
            try {
                consultaFactura(Integer.parseInt(txtNumFactura.getText()));
            } catch (JSONException ex) {
                Logger.getLogger(EmiteNotaCredito.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error en la conexion");
            }
        }

    }//GEN-LAST:event_txtNumFacturaActionPerformed

    private void txtNumFacturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumFacturaKeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                buscaFactura();
            } catch (SQLException ex) {
                Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(EmiteNotaCredito.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_txtNumFacturaKeyPressed

    private void btnSeleccionaArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionaArtActionPerformed
        // TODO add your handling code here:

        seleccionaArtTabla();
    }//GEN-LAST:event_btnSeleccionaArtActionPerformed

    private void txtNomArtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomArtFocusGained
        // TODO add your handling code here:
        txtNomArt.selectAll();

    }//GEN-LAST:event_txtNomArtFocusGained

    private void txtNomArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomArtActionPerformed
        // TODO add your handling code here:
        txtCantidad.requestFocus();
    }//GEN-LAST:event_txtNomArtActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing

        Variables.frmEmiNC = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void txtNumFacturaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumFacturaFocusGained
        this.txtNumFactura.selectAll();
    }//GEN-LAST:event_txtNumFacturaFocusGained

    private void jtArticulosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtArticulosMousePressed
      
        if (evt.getClickCount() == 2) {
            seleccionaArtTabla();
        }
    }//GEN-LAST:event_jtArticulosMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgTipDoc;
    private javax.swing.ButtonGroup btgTipFac;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminaArt;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnModificaArt;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSeleccionaArt;
    private javax.swing.JComboBox<String> cbTipoId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcFecFactura;
    private javax.swing.JTable jtArticulos;
    private javax.swing.JTextArea jtaNotas;
    private javax.swing.JTabbedPane jtpFactura;
    private javax.swing.JLabel lblDesctoArt;
    private javax.swing.JLabel lblDesctoFac;
    private javax.swing.JLabel lblIvaArt;
    private javax.swing.JLabel lblIvaFac;
    private javax.swing.JLabel lblMonExento;
    private javax.swing.JLabel lblMonGravado;
    private javax.swing.JLabel lblNomCliente;
    private javax.swing.JLabel lblSubTotArt;
    private javax.swing.JLabel lblSubTotalFac;
    private javax.swing.JLabel lblTotalArt;
    private javax.swing.JLabel lblTotalFac;
    private javax.swing.JPanel panelDatosCliente;
    private javax.swing.JPanel panelDetallFactura;
    private javax.swing.JRadioButton rbContado;
    private javax.swing.JRadioButton rbCredito;
    private javax.swing.JRadioButton rbFacEle;
    private javax.swing.JRadioButton rbTiqEle;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodArt;
    private javax.swing.JTextField txtDescto;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIdFactura;
    private javax.swing.JTextField txtNomArt;
    private javax.swing.JTextField txtNomFactura;
    private javax.swing.JTextField txtNumFactura;
    private javax.swing.JTextField txtPlazo;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

    private void inactivaCampos() {

        rbFacEle.setEnabled(false);
        rbTiqEle.setEnabled(false);
        rbContado.setEnabled(false);
        rbCredito.setEnabled(false);
        txtPlazo.setEnabled(false);
        txtNomFactura.setEnabled(false);
        txtIdFactura.setEnabled(false);
        cbTipoId.setEnabled(false);
        txtEmail.setEnabled(false);
        txtCodArt.setEnabled(false);
        txtNomArt.setEnabled(false);
        txtCantidad.setEnabled(false);
        txtDescto.setEnabled(false);
        txtPrecio.setEnabled(false);
        jtaNotas.setEnabled(false);
        jtArticulos.setEnabled(false);
        btnModificaArt.setEnabled(false);
        btnEliminaArt.setEnabled(false);
        btnEnviar.setEnabled(false);
        jtpFactura.setSelectedIndex(0);

    }

    private void limpiaCampos() {

        txtNomFactura.setText("");
        cbTipoId.setSelectedIndex(0);
        txtEmail.setText("");
        txtPlazo.setText("0");
        txtCodArt.setText("");
        txtNomArt.setText("");
        txtPrecio.setText("0");
        txtCantidad.setText("0");
        txtDescto.setText("0");
        txtIdFactura.setText("");
        mTotExento = 0;
        mTotGravado = 0;
        mSubTotalFac = 0;
        mDesctoFac = 0;
        mImptoFac = 0;
        mTotalFac = 0;

        lblSubTotArt.setText("0");
        lblDesctoArt.setText("0");
        lblIvaArt.setText("0");
        lblTotalArt.setText("0");
        lblMonExento.setText("0");
        lblMonGravado.setText("0");
        lblSubTotalFac.setText("0");
        lblDesctoFac.setText("0");
        lblIvaFac.setText("0");
        lblTotalFac.setText("0");
        listaItemFacVo = new ArrayList<>();

        dtmArticulos = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }

        };
        // jtArticulos=new JTable();       
        dtmArticulos.addColumn("Codigo");
        dtmArticulos.addColumn("Descripcion");
        dtmArticulos.addColumn("Cantidad");
        dtmArticulos.addColumn("Precio");
        dtmArticulos.addColumn("Descuento");
        dtmArticulos.addColumn("IVA");
        dtmArticulos.addColumn("Total");
        jtArticulos.setModel(dtmArticulos);

        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.RIGHT);

        jScrollPane1.setViewportView(jtArticulos);
        if (jtArticulos.getColumnModel().getColumnCount() > 0) {
            jtArticulos.getColumnModel().getColumn(0).setResizable(false);
            jtArticulos.getColumnModel().getColumn(0).setPreferredWidth(20);
            jtArticulos.getColumnModel().getColumn(0).setCellRenderer(dtcr);
            jtArticulos.getColumnModel().getColumn(1).setResizable(false);
            jtArticulos.getColumnModel().getColumn(1).setPreferredWidth(120);
            jtArticulos.getColumnModel().getColumn(2).setResizable(false);
            jtArticulos.getColumnModel().getColumn(2).setPreferredWidth(15);
            jtArticulos.getColumnModel().getColumn(2).setCellRenderer(dtcr);
            jtArticulos.getColumnModel().getColumn(3).setResizable(false);
            jtArticulos.getColumnModel().getColumn(3).setPreferredWidth(15);
            jtArticulos.getColumnModel().getColumn(3).setCellRenderer(dtcr);
            jtArticulos.getColumnModel().getColumn(4).setResizable(false);
            jtArticulos.getColumnModel().getColumn(4).setPreferredWidth(15);
            jtArticulos.getColumnModel().getColumn(4).setCellRenderer(dtcr);
            jtArticulos.getColumnModel().getColumn(5).setResizable(false);
            jtArticulos.getColumnModel().getColumn(5).setPreferredWidth(15);
            jtArticulos.getColumnModel().getColumn(5).setCellRenderer(dtcr);
            jtArticulos.getColumnModel().getColumn(6).setResizable(false);
            jtArticulos.getColumnModel().getColumn(6).setPreferredWidth(25);
            jtArticulos.getColumnModel().getColumn(6).setCellRenderer(dtcr);
        }

    }

    private void buscarCliente() throws SQLException {
        BuscaCliente buscarCliente = new BuscaCliente(null, true);
        buscarCliente.setLocationRelativeTo(null);
        buscarCliente.setVisible(true);
        String valorSelec = buscarCliente.getCodCliente();

    }

    private void activaCampos() {

        // rbFacEle.setEnabled(true);
        // rbTiqEle.setEnabled(true);
        // rbContado.setEnabled(true);
        // rbCredito.setEnabled(true);
        // txtPlazo.setEnabled(true);
        // txtNomFactura.setEnabled(true);
        // txtIdFactura.setEnabled(true);
        // cbTipoId.setEnabled(true);
        // txtEmail.setEnabled(true);
        txtCodArt.setEnabled(true);
        txtCantidad.setEnabled(true);
        txtDescto.setEnabled(true);
        // jtaNotas.setEnabled(true);
        jtArticulos.setEnabled(true);
        btnModificaArt.setEnabled(true);
        btnEliminaArt.setEnabled(true);
        btnEnviar.setEnabled(true);

    }

    public int getCatPdv() {
        return clienteVo.getCat_pdv();
    }

    private void consultaPrecioArt() throws SQLException {

        precioVo = new PrecioVO();
        precioVo.setCodigo_art(Integer.valueOf(txtCodArt.getText()));
        precioVo.setCat_pdv(clienteVo.getCat_pdv());
        if (PrecioDAOImpl.consultaPrecio(precioVo)) {

            mPrecio = precioVo.getPrecio_art();
            txtPrecio.setText(formatoDecimal.format(mPrecio));

            mPorDesctoArt = precioVo.getDescto_art();
            mRedondeo = precioVo.getRedondeo();
            if (mPorDesctoCli > mPorDesctoArt) {
                txtDescto.setText(String.valueOf(mPorDesctoCli));
            } else {
                txtDescto.setText(String.valueOf(mPorDesctoArt));
            }

            mIvaArt = precioVo.getImpto_art();
            calculaMontos();
            txtCantidad.requestFocus();

        } else {
            JOptionPane.showMessageDialog(this, "Artículo NO tiene precio definido en este PDV");
            txtCodArt.requestFocus();
        }

    }

    private void seleccionaArtTabla() {

        if (jtArticulos.getSelectedColumnCount() > 0) {
            lineaSelec = jtArticulos.getSelectedRow();

            txtCodArt.setText((String) dtmArticulos.getValueAt(lineaSelec, 0));
            txtNomArt.setText((String) dtmArticulos.getValueAt(lineaSelec, 1));
            String sCant = formatoEntero.format(listaItemFac.get(lineaSelec).getCantidad());
            txtCantidad.setText(sCant);
            mPrecio = listaItemFac.get(lineaSelec).getPrecio();
            String sPrecio = formatoDecimal.format(mPrecio);
            txtPrecio.setText(sPrecio);
            mPorDesctoArt = listaItemFac.get(lineaSelec).getPor_descto();
            txtDescto.setText(String.valueOf(mPorDesctoArt));
            mSubTotalArt = listaItemFac.get(lineaSelec).getMon_subtotal();
            aSubTotalArt = mSubTotalArt;
            String sMonto = formatoDecimal.format(mSubTotalArt);
            lblSubTotArt.setText(sMonto);
            mDesctoArt = listaItemFac.get(lineaSelec).getMon_descto();
            aDesctoArt = mDesctoArt;
            String sDescto = formatoDecimal.format(mDesctoArt);
            lblDesctoArt.setText(sDescto);
            mIvaArt = listaItemFac.get(lineaSelec).getPor_impto();
            mImptoArt = listaItemFac.get(lineaSelec).getMon_impto();
            aImptoArt = mImptoArt;
            String sIva = formatoDecimal.format(mImptoArt);
            lblIvaArt.setText(sIva);
            mTotalArt = mSubTotalArt - mDesctoArt + mImptoArt;
            sMonto = formatoDecimal.format(mTotalArt);
            lblTotalArt.setText(sMonto);

            txtCantidad.setEnabled(true);
            txtNomArt.setEnabled(true);
            txtPrecio.setEnabled(true);
            btnModificaArt.setEnabled(true);
            txtCantidad.requestFocus();

        } else {

        }

    }

    private void calculaMontos() {

        // Calcula montos
        try {
            iCantidad = Integer.valueOf(txtCantidad.getText().replace(",", ""));
            //mPrecio = Double.parseDouble(lblPrecio.getText());
            mPorDescto = Integer.parseInt(txtDescto.getText());
        } catch (Exception e) {
            iCantidad = 0;
            mPorDescto = 0;
            //mPrecio=0.0;
        }

        mSubTotalArt = Redondear.decimal((iCantidad * mPrecio), mRedondeo);
        mDesctoArt = Redondear.decimal((mSubTotalArt * mPorDescto / 100), mRedondeo);
        mImptoArt = Redondear.decimal(((mSubTotalArt - mDesctoArt) * mIvaArt / 100), mRedondeo);
        mTotalArt = mSubTotalArt - mDesctoArt + mImptoArt;

        // Muestra los datos en los textview
        lblSubTotArt.setText(formatoDecimal.format(mSubTotalArt));
        lblDesctoArt.setText(formatoDecimal.format(mDesctoArt));
        lblIvaArt.setText(formatoDecimal.format(mImptoArt));
        lblTotalArt.setText(formatoDecimal.format(mTotalArt));

    }

    private void agregaItem() {
        ItemFacVO item = new ItemFacVO();
        item.setCod_articulo(Integer.valueOf(txtCodArt.getText()));
        item.setNom_articulo(txtNomArt.getText());
        item.setCantidad(iCantidad);
        item.setPrecio(mPrecio);
        item.setPor_descto(Integer.valueOf(txtDescto.getText()));
        item.setMon_descto(mDesctoArt);
        item.setPor_impto(mIvaArt);
        item.setMon_impto(mImptoArt);
        item.setMon_subtotal(mSubTotalArt);
        item.setExento(precioVo.getExento());
        listaItemFacVo.add(item);

        Object[] fila = new Object[7];
        fila[0] = txtCodArt.getText();
        fila[1] = txtNomArt.getText();
        String sCant = formatoEntero.format(iCantidad);
        fila[2] = sCant;
        String sPrecio = formatoDecimal.format(mPrecio);
        fila[3] = sPrecio;
        String sDescto = formatoDecimal.format(mDesctoArt);
        fila[4] = sDescto;
        String sIva = formatoDecimal.format(mImptoArt);
        fila[5] = sIva;
        String sTotal = formatoDecimal.format(mTotalArt);
        fila[6] = sTotal;
        dtmArticulos.addRow(fila);

        if (precioVo.getExento() == 1) {
            mTotExento += mSubTotalArt;
        } else {
            mTotGravado += mSubTotalArt;
        }
        mSubTotalFac += mSubTotalArt;
        mDesctoFac += mDesctoArt;
        mImptoFac += mImptoArt;
        mTotalFac += mTotalArt;
        lblMonExento.setText(formatoDecimal.format(mTotExento));
        lblMonGravado.setText(formatoDecimal.format(mTotGravado));
        lblSubTotalFac.setText(formatoDecimal.format(mSubTotalFac));
        lblDesctoFac.setText(formatoDecimal.format(mDesctoFac));
        lblIvaFac.setText(formatoDecimal.format(mImptoFac));
        lblTotalFac.setText(formatoDecimal.format(mTotalFac));
        txtCodArt.setText("");
        txtCantidad.setText("0");
        txtDescto.setText("0");
        txtPrecio.setText("0");
        txtNomArt.setText("");
        lblSubTotArt.setText("0");
        lblDesctoArt.setText("0");
        lblIvaArt.setText("0");
        lblTotalArt.setText("0");
        txtCodArt.requestFocus();
    }

    private void buscaFactura() throws SQLException, JSONException {
        BuscaFactura buscarFactura = new BuscaFactura(null, true);
        buscarFactura.setLocationRelativeTo(null);
        buscarFactura.setVisible(true);
        int valorSelec = buscarFactura.getNumFactura();
        txtNumFactura.setText(String.valueOf(valorSelec));
        consultaFactura(valorSelec);

    }

    private void consultaFactura(int numFactura) throws JSONException {

        bp.abrirVentana("Consultando factura...");
        
        String url = Variables.URL_SERVER + "ejecucionpdv/wsConsultaFactura_v2.php?num_factura=" + numFactura;
        JSONObject respuesta = null;
        try {
            respuesta = HttpClient.httpGET(url);
            bp.setVisible(false);
            if (respuesta.optInt("Consulta") == 0) {
                JOptionPane.showMessageDialog(null, "Documento NO existe");
                txtNumFactura.requestFocus();
                return;
            }

            try {
                java.util.Date dFecha = sqlFecha.parse(respuesta.optString("fec_factura"));
                jdcFecFactura.setDate(dFecha);
            } catch (ParseException ex) {
                Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            mCodCliente = respuesta.optInt("cod_cliente");
            mCodAgencia = respuesta.optInt("cod_agencia");
            mCodPdv = respuesta.optInt("cod_pdv");
            mPlazoCre = respuesta.optInt("plazo");
            mTipoId = respuesta.optString("tipo_id");
            consecutivo_fe = respuesta.optString("consecutivo_fe");
            clave_fe = respuesta.optString("clave_fe");
            lblNomCliente.setText(respuesta.optString("nom_cliente"));
            txtNomFactura.setText(respuesta.optString("nom_factura"));
            txtIdFactura.setText(respuesta.optString("id_factura"));
            int iTipoId = Integer.valueOf(respuesta.optString("tipo_id").substring(0, 1)) - 1;
            cbTipoId.setSelectedIndex(iTipoId);
            txtEmail.setText(respuesta.optString("email"));
            mTotGravado = respuesta.optDouble("mon_gravado");
            mTotExento = respuesta.optDouble("mon_exento");

            // mSubTotalFac, mDesctoFac, mImptoFac, mTotalFac, mTotExento, mTotGravado
            mSubTotalFac = respuesta.optDouble("mon_subtotal");
            mImptoFac = respuesta.optDouble("mon_impto");
            mDesctoFac = respuesta.optDouble("mon_descto");
            mTotalFac = mSubTotalFac - mDesctoFac + mImptoFac;
            lblMonExento.setText(formatoDecimal.format(mTotExento));
            lblMonGravado.setText(formatoDecimal.format(mTotGravado));
            lblSubTotalFac.setText(formatoDecimal.format(mSubTotalFac));
            lblDesctoFac.setText(formatoDecimal.format(mDesctoFac));
            lblIvaFac.setText(formatoDecimal.format(mImptoFac));
            lblTotalFac.setText(formatoDecimal.format(mTotalFac));
            jtaNotas.setText(respuesta.optString("notas"));
            jsonItems = respuesta.getJSONArray("items");

            // Llena ArrayList de items
            JSONObject jsonItemFac;
            listaItemFac = new ArrayList();
            for (int i = 0; i < jsonItems.length(); i++) {
                itemFacVo = new ItemFacVO();
                jsonItemFac = jsonItems.optJSONObject(i);
                itemFacVo.setCod_articulo(jsonItemFac.optInt("codigo_art"));
                itemFacVo.setNom_articulo(jsonItemFac.optString("nom_cor_art"));
                itemFacVo.setCantidad(jsonItemFac.optInt("cantidad"));
                itemFacVo.setPrecio(jsonItemFac.optDouble("precio"));
                itemFacVo.setPor_descto(jsonItemFac.optInt("por_descto"));
                itemFacVo.setMon_descto(jsonItemFac.optDouble("mon_descto"));
                itemFacVo.setPor_impto(jsonItemFac.optInt("por_impto"));
                itemFacVo.setMon_impto(jsonItemFac.optDouble("mon_impto"));
                itemFacVo.setMon_subtotal(jsonItemFac.optDouble("mon_subtotal"));
                itemFacVo.setExento(jsonItemFac.optInt("exento"));
                itemFacVo.setCodCabys(jsonItemFac.getString("codigoCabys"));
                listaItemFac.add(itemFacVo);
            }

            // Actualiza jTable
            dtmArticulos = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;
                }

            };

            dtmArticulos.addColumn("Codigo");
            dtmArticulos.addColumn("Descripcion");
            dtmArticulos.addColumn("Cantidad");
            dtmArticulos.addColumn("Precio");
            dtmArticulos.addColumn("Descuento");
            dtmArticulos.addColumn("IVA");
            dtmArticulos.addColumn("Total");
            jtArticulos.setModel(dtmArticulos);

            Object[] fila = new Object[7];
            for (ItemFacVO itemFac : listaItemFac) {
                fila[0] = String.valueOf(itemFac.getCod_articulo());
                fila[1] = itemFac.getNom_articulo();
                String sCant = formatoEntero.format(itemFac.getCantidad());
                fila[2] = sCant;
                String sPrecio = formatoDecimal.format(itemFac.getPrecio());
                fila[3] = sPrecio;
                String sDescto = formatoDecimal.format(itemFac.getMon_descto());
                fila[4] = sDescto;
                String sIva = formatoDecimal.format(itemFac.getMon_impto());
                fila[5] = sIva;
                String sTotal = formatoDecimal.format(itemFac.getMon_subtotal() + itemFac.getMon_impto());
                fila[6] = sTotal;
                dtmArticulos.addRow(fila);

            }

            DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
            dtcr.setHorizontalAlignment(SwingConstants.RIGHT);

            jScrollPane1.setViewportView(jtArticulos);
            if (jtArticulos.getColumnModel().getColumnCount() > 0) {
                jtArticulos.getColumnModel().getColumn(0).setResizable(false);
                jtArticulos.getColumnModel().getColumn(0).setPreferredWidth(10);
                jtArticulos.getColumnModel().getColumn(0).setCellRenderer(dtcr);
                jtArticulos.getColumnModel().getColumn(1).setResizable(false);
                jtArticulos.getColumnModel().getColumn(1).setPreferredWidth(140);
                jtArticulos.getColumnModel().getColumn(2).setResizable(false);
                jtArticulos.getColumnModel().getColumn(2).setPreferredWidth(15);
                jtArticulos.getColumnModel().getColumn(2).setCellRenderer(dtcr);
                jtArticulos.getColumnModel().getColumn(3).setResizable(false);
                jtArticulos.getColumnModel().getColumn(3).setPreferredWidth(15);
                jtArticulos.getColumnModel().getColumn(3).setCellRenderer(dtcr);
                jtArticulos.getColumnModel().getColumn(4).setResizable(false);
                jtArticulos.getColumnModel().getColumn(4).setPreferredWidth(15);
                jtArticulos.getColumnModel().getColumn(4).setCellRenderer(dtcr);
                jtArticulos.getColumnModel().getColumn(5).setResizable(false);
                jtArticulos.getColumnModel().getColumn(5).setPreferredWidth(15);
                jtArticulos.getColumnModel().getColumn(5).setCellRenderer(dtcr);
                jtArticulos.getColumnModel().getColumn(6).setResizable(false);
                jtArticulos.getColumnModel().getColumn(6).setPreferredWidth(25);
                jtArticulos.getColumnModel().getColumn(6).setCellRenderer(dtcr);
            }

            jtArticulos.setEnabled(true);
            btnEliminaArt.setEnabled(true);
            btnEnviar.setEnabled(true);
            jtpFactura.setSelectedIndex(0);
            //jtArticulos.requestFocus();

        } catch (IOException ex) {
            Logger.getLogger(EmiteFactura.class.getName()).log(Level.SEVERE, null, ex);
            bp.setVisible(false);
        }
    }

    private void modificaArticulo() {

        mPrecio = Double.valueOf(txtPrecio.getText().replace(",", ""));
        iCantidad = Integer.valueOf(txtCantidad.getText().replace(",", ""));
        calculaMontos();

        listaItemFac.get(lineaSelec).setNom_articulo(txtNomArt.getText());
        dtmArticulos.setValueAt(txtNomArt.getText(), lineaSelec, 1);
        listaItemFac.get(lineaSelec).setCantidad(iCantidad);
        String sCant = formatoEntero.format(iCantidad);
        dtmArticulos.setValueAt(sCant, lineaSelec, 2);
        listaItemFac.get(lineaSelec).setPrecio(mPrecio);
        String sPrecio = formatoDecimal.format(mPrecio);
        dtmArticulos.setValueAt(sPrecio, lineaSelec, 3);
        listaItemFac.get(lineaSelec).setMon_subtotal(mSubTotalArt);
        String sSubtotal = formatoDecimal.format(mSubTotalArt);
        dtmArticulos.setValueAt(sSubtotal, lineaSelec, 6);
        listaItemFac.get(lineaSelec).setMon_descto(mDesctoArt);
        String sDescto = formatoDecimal.format(mDesctoArt);
        dtmArticulos.setValueAt(sDescto, lineaSelec, 4);
        listaItemFac.get(lineaSelec).setMon_impto(mImptoArt);
        String sImpto = formatoDecimal.format(mImptoArt);
        dtmArticulos.setValueAt(sImpto, lineaSelec, 5);

        mSubTotalFac = mSubTotalFac - aSubTotalArt + mSubTotalArt;
        mDesctoFac = mDesctoFac - aDesctoArt + mDesctoArt;
        mImptoFac = mImptoFac - aImptoArt + mImptoArt;
        mTotalFac = mSubTotalFac - mDesctoFac + mImptoFac;
        if (listaItemFac.get(lineaSelec).getExento() == 1) {
            mTotExento = mTotExento - aSubTotalArt + mSubTotalArt;
        } else {
            mTotGravado = mTotGravado - aSubTotalArt + mSubTotalArt;
        }
        String sMonto = formatoDecimal.format(mTotExento);
        lblMonExento.setText(sMonto);
        sMonto = formatoDecimal.format(mTotGravado);
        lblMonGravado.setText(sMonto);
        sMonto = formatoDecimal.format(mSubTotalFac);
        lblSubTotalFac.setText(sMonto);
        sMonto = formatoDecimal.format(mDesctoFac);
        lblDesctoFac.setText(sMonto);
        sMonto = formatoDecimal.format(mImptoFac);
        lblIvaFac.setText(sMonto);
        sMonto = formatoDecimal.format(mTotalFac);
        lblTotalFac.setText(sMonto);

        txtCodArt.setText("");
        txtCantidad.setText("0");
        txtDescto.setText("0");
        txtPrecio.setText("");
        txtNomArt.setText("");
        lblSubTotArt.setText("0");
        lblDesctoArt.setText("0");
        lblIvaArt.setText("0");
        lblTotalArt.setText("0");
        btnModificaArt.setEnabled(false);
        jtArticulos.requestFocus();

    }

    private void enviaNota() throws IOException, JSONException {

        bp.abrirVentana("Generando Nota de Credito...");

        JSONObject respuesta;

        JSONArray jsonArray = new JSONArray();
        for (ItemFacVO item : listaItemFac) {

            JSONObject jsonItemFac = new JSONObject();
            jsonItemFac.put("codigo_art", item.getCod_articulo());
            jsonItemFac.put("nombre_art", item.getNom_articulo());
            jsonItemFac.put("cantidad", item.getCantidad());
            jsonItemFac.put("precio", item.getPrecio());
            jsonItemFac.put("mon_subtotal", item.getMon_subtotal());
            jsonItemFac.put("por_descto", item.getPor_descto());
            jsonItemFac.put("mon_descto", item.getMon_descto());
            jsonItemFac.put("mon_impto", item.getMon_impto());
            jsonItemFac.put("por_impto", item.getPor_impto());
            jsonItemFac.put("tipoItem", item.getTipoItem());
            jsonItemFac.put("exento", item.getExento());
            jsonItemFac.put("codigoCabys", item.getCodCabys());
            jsonArray.put(jsonItemFac);
        }
        JSONObject jsonNota = new JSONObject();
        jsonNota.put("cod_agencia", mCodAgencia);
        jsonNota.put("cod_pdv", mCodPdv);
        jsonNota.put("cod_cliente", mCodCliente);
        jsonNota.put("tipo_nota", "03");
        jsonNota.put("plazo_fac", mPlazoCre);
        jsonNota.put("nom_tributa", txtNomFactura.getText());
        jsonNota.put("id_tributa", txtIdFactura.getText());
        jsonNota.put("email", txtEmail.getText());
        jsonNota.put("tipo_id", cbTipoId.getSelectedItem().toString());
        jsonNota.put("num_factura", Integer.valueOf(txtNumFactura.getText()));
        String obs_nota = "Doc. Ref: " + clave_fe;
        jsonNota.put("notas_fact", obs_nota);
        jsonNota.put("articulos", jsonArray);

        String url = Variables.URL_SERVER + "ejecucionpdv/wsAgregaNotaFactura_v2.php";

        respuesta = HttpClient.httpPOST(url, jsonNota);
        int numNota = respuesta.getInt("nota");

        bp.abrirVentana("Enviando Nota de Credito a Hacienda...");

        // Envia nota a la api Hacienda
        url = Variables.URL_SERVER + "ejecucionpdv/wsApifecrEnvioNotas.php?num_nota=" + numNota;
        respuesta = HttpClient.httpGET(url);

        bp.setVisible(false);

        JOptionPane.showMessageDialog(this, "Proceso terminado");
        limpiaCampos();
        btnEnviar.setEnabled(false);
        txtNumFactura.requestFocus();

    }
}
