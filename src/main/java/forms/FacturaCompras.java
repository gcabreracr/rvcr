package forms;

import interfaces.CabysDAO;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import metodos.Redondear;
import metodos.VerificaEmail;
import modelo.DAO.CabysDAOImpl;
import modelo.VO.ArticuloVO;
import modelo.HttpClient;
import modelo.VO.ItemCompraVO;
import modelo.VO.PrecioVO;
import modelo.VO.ProveedorVO;
import modelo.DAO.ProveedorDAOImpl;
import modelo.VO.CabysVO;
import modelo.Validar;
import modelo.Variables;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FacturaCompras extends javax.swing.JInternalFrame {

    DefaultTableModel dtmItems;
    ArrayList<ItemCompraVO> listaItemCompra;
    ArticuloVO articuloVo;
    PrecioVO precioVo;
    Validar valida;
    BarraProgreso bp;
    ProveedorVO proveedorVo;
    CabysVO cabysVO;
    CabysDAO cabysDAO;

    String clave_fe, consecutivo_fe;
    String tipoDoc = "01";
    String tipoFac = "01";
    boolean nuevoProv;
    int mPorDesctoCli, mPlazoCre, mMontoCredito, mPorDesctoArt, mIvaArt, mPorDescto, iCantidad, mRedondeo, mExento, mTipoItem, numFactura;
    double mPrecio, mDesctoItem, mImptoItem, mSubTotalItem, mTotalItem, mSubTotalFac, mDesctoFac, mImptoFac, mTotalFac, mTotExento, mTotGravado;

    DecimalFormat formatoDecimal = new DecimalFormat("###,###,##0.00");
    DecimalFormat formatoEntero = new DecimalFormat("#####,##0");

    public FacturaCompras() {
        initComponents();
        bp = new BarraProgreso();
        valida = new Validar();

        cabysVO = new CabysVO();
        cabysDAO = new CabysDAOImpl();
        listaItemCompra = new ArrayList();
        valida.soloNumeros(txtIdProv);
        valida.limitarCaracteres(txtIdProv, Variables.L_ID_TRIBUTA);
        valida.soloNumeros(txtTelefono);
        valida.limitarCaracteres(txtTelefono, 8);
        valida.limitarCaracteres(txtNomProv, 80);
        valida.limitarCaracteres(txtNomComercial, 80);
        valida.limitarCaracteres(txtEmail, 120);
        valida.limitarCaracteres(txtNomItem, 80);
        valida.limitarCaracteres(txtDesctoItem, 15);
        valida.soloNumeros(txtDesctoItem);
        valida.soloNumeros(txtCantidad);
        valida.limitarCaracteres(txtCantidad, 12);

        jtItems.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouse_evt) {
                if (mouse_evt.getClickCount() == 2) {
                    seleccionaArtTabla();
                }
            }
        });

        inactivaCampos();
        limpiaCampos();
        jtpFactCompra.setSelectedIndex(0);
        txtIdProv.requestFocus();

    }

    private void seleccionaArtTabla() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgTipoItem = new javax.swing.ButtonGroup();
        panelBotones = new javax.swing.JPanel();
        btnEnviar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        panelTotales = new javax.swing.JPanel();
        lblDesctoFac = new javax.swing.JLabel();
        lblIvaFac = new javax.swing.JLabel();
        lblTotalFac = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblMonGravado = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblMonExento = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblSubTotalFac = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jtaNotas = new javax.swing.JTextArea();
        jtpFactCompra = new javax.swing.JTabbedPane();
        datosProveedor = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtIdProv = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNomProv = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbTipoId = new javax.swing.JComboBox<>();
        txtNomComercial = new javax.swing.JTextField();
        btnActualizaProv = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblNuevoProv = new javax.swing.JLabel();
        panelItems = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtItems = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        txtNomItem = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtDesctoItem = new javax.swing.JTextField();
        btnAgregaArt = new javax.swing.JButton();
        btnEliminaArt = new javax.swing.JButton();
        txtCantidad = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblTotalArt = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtPrecioItem = new javax.swing.JTextField();
        rbProductos = new javax.swing.JRadioButton();
        rbServicios = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        txtSubTotItem = new javax.swing.JTextField();
        txtImptoItem = new javax.swing.JTextField();
        cbExento = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        txtCodCabys = new javax.swing.JTextField();
        lblDesCabys = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Registra facturas de compra");
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

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        lblDesctoFac.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDesctoFac.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblIvaFac.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIvaFac.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblTotalFac.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTotalFac.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalFac.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel13.setText("Gravado");

        lblMonGravado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMonGravado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel14.setText("Exento");

        lblMonExento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMonExento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel15.setText("Sub-Total");

        lblSubTotalFac.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubTotalFac.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel16.setText("Descuento");

        jLabel17.setText("Impuesto");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Total Factura");

        javax.swing.GroupLayout panelTotalesLayout = new javax.swing.GroupLayout(panelTotales);
        panelTotales.setLayout(panelTotalesLayout);
        panelTotalesLayout.setHorizontalGroup(
            panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTotalesLayout.createSequentialGroup()
                .addGroup(panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTotalesLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(lblTotalFac, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTotalesLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTotalesLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblIvaFac, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTotalesLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblDesctoFac, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTotalesLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblMonGravado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTotalesLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblSubTotalFac, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelTotalesLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTotalesLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblMonExento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        panelTotalesLayout.setVerticalGroup(
            panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTotalesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(lblMonGravado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMonExento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSubTotalFac, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDesctoFac, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIvaFac, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTotalFac, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtaNotas.setColumns(20);
        jtaNotas.setRows(5);
        jtaNotas.setBorder(javax.swing.BorderFactory.createTitledBorder("Notas"));

        datosProveedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Nombre Comercial");

        txtIdProv.setText(" ");
        txtIdProv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIdProvFocusGained(evt);
            }
        });
        txtIdProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProvActionPerformed(evt);
            }
        });

        jLabel5.setText("Nombre tributario");

        txtNomProv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomProvFocusGained(evt);
            }
        });
        txtNomProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomProvActionPerformed(evt);
            }
        });

        jLabel6.setText("Identificacion");

        jLabel7.setText("Tipo ID");

        cbTipoId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1-Fisica", "2-Juridica", "3-DIMEX", "4-NITE" }));

        txtNomComercial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomComercialFocusGained(evt);
            }
        });
        txtNomComercial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomComercialActionPerformed(evt);
            }
        });

        btnActualizaProv.setText("Actualiza proveedor");
        btnActualizaProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizaProvActionPerformed(evt);
            }
        });

        jLabel4.setText("Email");

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

        txtTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelefonoFocusGained(evt);
            }
        });
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        jLabel8.setText("Telefono");

        jLabel2.setText("* Todos lo campos son obligatorios");

        lblNuevoProv.setText(" ");

        javax.swing.GroupLayout datosProveedorLayout = new javax.swing.GroupLayout(datosProveedor);
        datosProveedor.setLayout(datosProveedorLayout);
        datosProveedorLayout.setHorizontalGroup(
            datosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosProveedorLayout.createSequentialGroup()
                .addGroup(datosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosProveedorLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6))
                    .addGroup(datosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(datosProveedorLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnActualizaProv))
                        .addGroup(datosProveedorLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(datosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel5)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel8))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(datosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNomComercial, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNomProv, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbTipoId, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(datosProveedorLayout.createSequentialGroup()
                                    .addComponent(txtIdProv, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblNuevoProv, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        datosProveedorLayout.setVerticalGroup(
            datosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(lblNuevoProv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbTipoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosProveedorLayout.createSequentialGroup()
                        .addComponent(txtNomComercial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(datosProveedorLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(datosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(datosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnActualizaProv))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jtpFactCompra.addTab("Datos Proveedor", datosProveedor);

        panelItems.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtItems.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jtItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Descripcion", "Cantidad", "Precio", "Descuento", "IVA", "Monto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtItems);
        if (jtItems.getColumnModel().getColumnCount() > 0) {
            jtItems.getColumnModel().getColumn(0).setResizable(false);
            jtItems.getColumnModel().getColumn(0).setPreferredWidth(120);
            jtItems.getColumnModel().getColumn(1).setResizable(false);
            jtItems.getColumnModel().getColumn(1).setPreferredWidth(15);
            jtItems.getColumnModel().getColumn(2).setResizable(false);
            jtItems.getColumnModel().getColumn(2).setPreferredWidth(15);
            jtItems.getColumnModel().getColumn(3).setResizable(false);
            jtItems.getColumnModel().getColumn(3).setPreferredWidth(15);
            jtItems.getColumnModel().getColumn(4).setResizable(false);
            jtItems.getColumnModel().getColumn(4).setPreferredWidth(15);
            jtItems.getColumnModel().getColumn(5).setResizable(false);
            jtItems.getColumnModel().getColumn(5).setPreferredWidth(25);
        }

        jLabel19.setText("Descripcion");

        txtNomItem.setText(" ");
        txtNomItem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomItemFocusGained(evt);
            }
        });
        txtNomItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomItemActionPerformed(evt);
            }
        });
        txtNomItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomItemKeyPressed(evt);
            }
        });

        jLabel20.setText("Cantidad");

        txtDesctoItem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDesctoItem.setText(" ");
        txtDesctoItem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDesctoItemFocusGained(evt);
            }
        });
        txtDesctoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDesctoItemActionPerformed(evt);
            }
        });

        btnAgregaArt.setText("Agregar");
        btnAgregaArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregaArtActionPerformed(evt);
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

        jLabel24.setText("Sub-Total");

        lblTotalArt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalArt.setText(" ");
        lblTotalArt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel25.setText("Descuento");

        jLabel26.setText("IVA 13%");

        jLabel27.setText("Total ");

        txtPrecioItem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPrecioItem.setEnabled(false);
        txtPrecioItem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecioItemFocusGained(evt);
            }
        });
        txtPrecioItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioItemActionPerformed(evt);
            }
        });

        btgTipoItem.add(rbProductos);
        rbProductos.setSelected(true);
        rbProductos.setText("Productos");
        rbProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbProductosActionPerformed(evt);
            }
        });

        btgTipoItem.add(rbServicios);
        rbServicios.setText("Servicios");
        rbServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbServiciosActionPerformed(evt);
            }
        });

        jLabel1.setText("Tipo");

        txtSubTotItem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSubTotItem.setText(" ");
        txtSubTotItem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSubTotItemFocusGained(evt);
            }
        });
        txtSubTotItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubTotItemActionPerformed(evt);
            }
        });

        txtImptoItem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtImptoItem.setText(" ");
        txtImptoItem.setEnabled(false);
        txtImptoItem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtImptoItemFocusGained(evt);
            }
        });
        txtImptoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImptoItemActionPerformed(evt);
            }
        });

        cbExento.setText("Exento");
        cbExento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbExentoActionPerformed(evt);
            }
        });

        jLabel9.setText("Codigo Cabys");

        txtCodCabys.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodCabysFocusGained(evt);
            }
        });
        txtCodCabys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodCabysActionPerformed(evt);
            }
        });
        txtCodCabys.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodCabysKeyPressed(evt);
            }
        });

        lblDesCabys.setText(" ");

        javax.swing.GroupLayout panelItemsLayout = new javax.swing.GroupLayout(panelItems);
        panelItems.setLayout(panelItemsLayout);
        panelItemsLayout.setHorizontalGroup(
            panelItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelItemsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelItemsLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(panelItemsLayout.createSequentialGroup()
                        .addGroup(panelItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addGroup(panelItemsLayout.createSequentialGroup()
                                .addGroup(panelItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelItemsLayout.createSequentialGroup()
                                        .addGroup(panelItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelItemsLayout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addGroup(panelItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel20)
                                                    .addComponent(jLabel22))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(panelItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(panelItemsLayout.createSequentialGroup()
                                                        .addComponent(cbExento)
                                                        .addGap(18, 18, 18)
                                                        .addGroup(panelItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel26)
                                                            .addComponent(jLabel27))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(panelItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(lblTotalArt, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtImptoItem, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(panelItemsLayout.createSequentialGroup()
                                                        .addGroup(panelItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtPrecioItem, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(67, 67, 67)
                                                        .addGroup(panelItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addGroup(panelItemsLayout.createSequentialGroup()
                                                                .addComponent(jLabel25)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(txtDesctoItem, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(panelItemsLayout.createSequentialGroup()
                                                                .addComponent(jLabel24)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(txtSubTotItem, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                            .addGroup(panelItemsLayout.createSequentialGroup()
                                                .addGap(137, 137, 137)
                                                .addComponent(rbServicios)))
                                        .addGap(122, 122, 122))
                                    .addGroup(panelItemsLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(panelItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNomItem, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panelItemsLayout.createSequentialGroup()
                                                .addComponent(txtCodCabys, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblDesCabys, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelItemsLayout.createSequentialGroup()
                                                .addComponent(rbProductos)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(panelItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(btnEliminaArt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btnAgregaArt, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(19, 19, 19)))))))
                        .addGap(0, 22, Short.MAX_VALUE))))
        );
        panelItemsLayout.setVerticalGroup(
            panelItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelItemsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCodCabys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDesCabys, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGroup(panelItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelItemsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbServicios)
                            .addComponent(jLabel1)
                            .addComponent(rbProductos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDesctoItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(txtPrecioItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)))
                    .addGroup(panelItemsLayout.createSequentialGroup()
                        .addGroup(panelItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelItemsLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(panelItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSubTotItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24)))
                            .addGroup(panelItemsLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAgregaArt)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminaArt)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtImptoItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbExento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(lblTotalArt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jtpFactCompra.addTab("Detalle ", panelItems);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jtaNotas)
                        .addGap(18, 18, 18)
                        .addComponent(panelTotales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtpFactCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtpFactCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelTotales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtaNotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //inactivaCampos();
        limpiaCampos();
        jtpFactCompra.setSelectedIndex(0);
        txtIdProv.requestFocus();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed

        Variables.frmFactCompra = null;
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed

        // Validaciones
        if (mTotalFac == 0) {
            JOptionPane.showMessageDialog(this, "No se permite registrar una factura en CERO");
            txtNomItem.requestFocus();
            return;
        }

        if (txtIdProv.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Debe introducir un numero de ID");
            txtIdProv.requestFocus();
            return;
        } else {
            switch (cbTipoId.getSelectedIndex()) {
                case 0:
                    if (txtIdProv.getText().length() != 9) {
                        JOptionPane.showMessageDialog(this, "ID incorrecto");
                        txtIdProv.requestFocus();
                        return;
                    }
                    break;
                case 1:
                    if (txtIdProv.getText().length() != 10) {
                        JOptionPane.showMessageDialog(this, "ID incorrecto");
                        txtIdProv.requestFocus();
                        return;
                    }
                    break;
                case 2:
                    if (txtIdProv.getText().length() < 11 || txtIdProv.getText().length() > 12) {
                        JOptionPane.showMessageDialog(this, "ID incorrecto");
                        txtIdProv.requestFocus();
                        return;
                    }
                    break;
                case 3:
                    if (txtIdProv.getText().length() != 10) {
                        JOptionPane.showMessageDialog(this, "ID incorrecto");
                        txtIdProv.requestFocus();
                        return;
                    }
                    break;
            }
        }

        if (txtNomProv.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Campo del Nombre de Proveedor es obligatorio");
            txtNomProv.requestFocus();
            return;
        }
        if (txtNomComercial.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Campo del Nombre Comercial del Proveedor es obligatorio");
            txtNomComercial.requestFocus();
            return;
        }
        if (txtTelefono.getText().length() != 8) {
            JOptionPane.showMessageDialog(this, "Número teléfono incorrecto");
            txtTelefono.requestFocus();
            return;
        }
        if (txtEmail.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Campo del Correo Electronico es obligatorio");
            txtEmail.requestFocus();
            return;
        } else {
            if (!VerificaEmail.verificar(txtEmail.getText())) {
                JOptionPane.showMessageDialog(this, "Correo Electronico Incorrecto");
                txtEmail.requestFocus();
                return;
            }
        }

        // btnEnviar.setEnabled(false);
        try {
            enviarFactura();
        } catch (IOException | JSONException ex) {
            Logger.getLogger(FacturaCompras.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al enviar la factura");
        }


    }//GEN-LAST:event_btnEnviarActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing

        Variables.frmFactCompra = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void txtCodCabysKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodCabysKeyPressed
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                buscarCabys();
            } catch (SQLException ex) {
                Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtCodCabysKeyPressed

    private void txtCodCabysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodCabysActionPerformed

        if (txtCodCabys.getText() != null) {
            try {
                consultaCabys(txtCodCabys.getText().trim());
            } catch (SQLException ex) {
                Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error de conexion con el servidor");
            }
        } else {
        }
    }//GEN-LAST:event_txtCodCabysActionPerformed

    private void txtCodCabysFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodCabysFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodCabysFocusGained

    private void cbExentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbExentoActionPerformed
        if (cbExento.isSelected()) {
            mIvaArt = 0;
            mExento = 1;
        } else {
            mIvaArt = 13;
            mExento = 0;
        }
        calculaMontos();

    }//GEN-LAST:event_cbExentoActionPerformed

    private void txtImptoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImptoItemActionPerformed
        mImptoItem = Double.valueOf(txtImptoItem.getText());
        txtImptoItem.setText(formatoDecimal.format(mImptoItem));
        calculaMontos();
        btnAgregaArt.requestFocus();
    }//GEN-LAST:event_txtImptoItemActionPerformed

    private void txtImptoItemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtImptoItemFocusGained
        txtImptoItem.selectAll();
    }//GEN-LAST:event_txtImptoItemFocusGained

    private void txtSubTotItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubTotItemActionPerformed

        mSubTotalItem = Double.valueOf(txtSubTotItem.getText());
        txtSubTotItem.setText(formatoDecimal.format(mSubTotalItem));
        calculaMontos();
        txtDesctoItem.requestFocus();
    }//GEN-LAST:event_txtSubTotItemActionPerformed

    private void txtSubTotItemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSubTotItemFocusGained
        txtSubTotItem.selectAll();
    }//GEN-LAST:event_txtSubTotItemFocusGained

    private void rbServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbServiciosActionPerformed
        txtCantidad.requestFocus();
        mTipoItem = 2;
    }//GEN-LAST:event_rbServiciosActionPerformed

    private void rbProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbProductosActionPerformed
        txtCantidad.requestFocus();
        mTipoItem = 1;
    }//GEN-LAST:event_rbProductosActionPerformed

    private void txtPrecioItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioItemActionPerformed

    }//GEN-LAST:event_txtPrecioItemActionPerformed

    private void txtPrecioItemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioItemFocusGained
        // TODO add your handling code here:
        txtPrecioItem.selectAll();
    }//GEN-LAST:event_txtPrecioItemFocusGained

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed

        txtSubTotItem.requestFocus();

        calculaMontos();
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtCantidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFocusGained
        // TODO add your handling code here:
        txtCantidad.selectAll();
    }//GEN-LAST:event_txtCantidadFocusGained

    private void btnEliminaArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaArtActionPerformed
        // TODO add your handling code here:
        int filaSelec = jtItems.getSelectedRow();
        if (filaSelec != -1) {

            if (listaItemCompra.get(filaSelec).getExento() == 1) {
                mTotExento -= listaItemCompra.get(filaSelec).getSubTotItem();
            } else {
                mTotGravado -= listaItemCompra.get(filaSelec).getSubTotItem();
            }
            mSubTotalFac -= listaItemCompra.get(filaSelec).getSubTotItem();
            mDesctoFac -= listaItemCompra.get(filaSelec).getTotDesctoItem();
            mImptoFac -= listaItemCompra.get(filaSelec).getTotImptoItem();
            mTotalFac = mSubTotalFac - mDesctoFac + mImptoFac;
            lblMonExento.setText(formatoDecimal.format(mTotExento));
            lblMonGravado.setText(formatoDecimal.format(mTotGravado));
            lblSubTotalFac.setText(formatoDecimal.format(mSubTotalFac));
            lblDesctoFac.setText(formatoDecimal.format(mDesctoFac));
            lblIvaFac.setText(formatoDecimal.format(mImptoFac));
            lblTotalFac.setText(formatoDecimal.format(mTotalFac));
            txtNomItem.setText("");
            txtCantidad.setText("0");
            txtDesctoItem.setText("0");
            txtPrecioItem.setText("");
            txtSubTotItem.setText("0");
            txtImptoItem.setText("0");
            lblTotalArt.setText("0");
            txtCodCabys.setText("");
            lblDesCabys.setText("");
            txtCodCabys.requestFocus();

            listaItemCompra.remove(filaSelec);
            dtmItems.removeRow(filaSelec);

        } else {
            JOptionPane.showMessageDialog(this, "Selecciones una fila a eliminar");
        }

    }//GEN-LAST:event_btnEliminaArtActionPerformed

    private void btnAgregaArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregaArtActionPerformed

        if (mTotalItem == 0) {
            JOptionPane.showMessageDialog(this, "No se puede incluir un item en CERO");
            txtNomItem.requestFocus();
            return;
        }
        if (txtNomItem.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Descripcion Item incorrecto");
            txtNomItem.requestFocus();
            return;
        }
        if(txtCodCabys.getText().length()== 0){
            JOptionPane.showMessageDialog(this, "Codigo Cabys Requerido");
            txtCodCabys.requestFocus();
            return;
        }

        agregaItem();
    }//GEN-LAST:event_btnAgregaArtActionPerformed

    private void txtDesctoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDesctoItemActionPerformed

        mDesctoItem = Double.valueOf(txtDesctoItem.getText());
        txtDesctoItem.setText(formatoDecimal.format(mDesctoItem));
        calculaMontos();
        btnAgregaArt.requestFocus();
    }//GEN-LAST:event_txtDesctoItemActionPerformed

    private void txtDesctoItemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDesctoItemFocusGained
        // TODO add your handling code here:
        txtDesctoItem.selectAll();
    }//GEN-LAST:event_txtDesctoItemFocusGained

    private void txtNomItemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomItemKeyPressed

    }//GEN-LAST:event_txtNomItemKeyPressed

    private void txtNomItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomItemActionPerformed
        txtCantidad.requestFocus();
    }//GEN-LAST:event_txtNomItemActionPerformed

    private void txtNomItemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomItemFocusGained

        txtNomItem.selectAll();
    }//GEN-LAST:event_txtNomItemFocusGained

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        txtNomItem.requestFocus();
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtTelefonoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusGained
        txtEmail.selectAll();
    }//GEN-LAST:event_txtTelefonoFocusGained

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        txtTelefono.requestFocus();
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        txtEmail.selectAll();
    }//GEN-LAST:event_txtEmailFocusGained

    private void btnActualizaProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizaProvActionPerformed

        switch (cbTipoId.getSelectedIndex()) {
            case 0:
                if (txtIdProv.getText().length() != 9) {
                    JOptionPane.showMessageDialog(this, "ID incorrecto");
                    txtIdProv.requestFocus();
                    return;
                }
                break;
            case 1:
                if (txtIdProv.getText().length() != 10) {
                    JOptionPane.showMessageDialog(this, "ID incorrecto");
                    txtIdProv.requestFocus();
                    return;
                }
                break;
            case 2:
                if (txtIdProv.getText().length() < 11 || txtIdProv.getText().length() > 12) {
                    JOptionPane.showMessageDialog(this, "ID incorrecto");
                    txtIdProv.requestFocus();
                    return;
                }
                break;
            case 3:
                if (txtIdProv.getText().length() != 10) {
                    JOptionPane.showMessageDialog(this, "ID incorrecto");
                    txtIdProv.requestFocus();
                    return;
                }
                break;
        }
        if (txtNomProv.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Campo del Nombre de Proveedor es obligatorio");
            txtNomProv.requestFocus();
            return;
        }
        if (txtNomComercial.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Campo del Nombre Comercial del Proveedor es obligatorio");
            txtNomComercial.requestFocus();
            return;
        }
        if (txtTelefono.getText().length() != 8) {
            JOptionPane.showMessageDialog(this, "Número teléfono incorrecto");
            txtTelefono.requestFocus();
            return;
        }
        if (txtEmail.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Campo del Correo Electronico es obligatorio");
            txtEmail.requestFocus();
            return;
        } else {
            if (!VerificaEmail.verificar(txtEmail.getText())) {
                JOptionPane.showMessageDialog(this, "Correo Electronico Incorrecto");
                txtEmail.requestFocus();
                return;
            }
        }

        actualizaProveedor();
        txtNomItem.requestFocus();
    }//GEN-LAST:event_btnActualizaProvActionPerformed

    private void txtNomComercialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomComercialActionPerformed
        txtEmail.requestFocus();
    }//GEN-LAST:event_txtNomComercialActionPerformed

    private void txtNomComercialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomComercialFocusGained
        txtNomComercial.selectAll();
    }//GEN-LAST:event_txtNomComercialFocusGained

    private void txtNomProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomProvActionPerformed
        txtNomComercial.requestFocus();
    }//GEN-LAST:event_txtNomProvActionPerformed

    private void txtNomProvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomProvFocusGained
        // TODO add your handling code here:
        txtNomProv.selectAll();
    }//GEN-LAST:event_txtNomProvFocusGained

    private void txtIdProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProvActionPerformed

        if (txtIdProv.getText().length() >= 9) {
            try {
                consultaProveedor();
            } catch (SQLException ex) {
                Logger.getLogger(FacturaCompras.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error en la conexion");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Digite un ID valido");
        }

    }//GEN-LAST:event_txtIdProvActionPerformed

    private void txtIdProvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdProvFocusGained
        // TODO add your handling code here:
        txtIdProv.selectAll();
    }//GEN-LAST:event_txtIdProvFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgTipoItem;
    private javax.swing.JButton btnActualizaProv;
    private javax.swing.JButton btnAgregaArt;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminaArt;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox cbExento;
    private javax.swing.JComboBox<String> cbTipoId;
    private javax.swing.JPanel datosProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtItems;
    private javax.swing.JTextArea jtaNotas;
    private javax.swing.JTabbedPane jtpFactCompra;
    private javax.swing.JLabel lblDesCabys;
    private javax.swing.JLabel lblDesctoFac;
    private javax.swing.JLabel lblIvaFac;
    private javax.swing.JLabel lblMonExento;
    private javax.swing.JLabel lblMonGravado;
    private javax.swing.JLabel lblNuevoProv;
    private javax.swing.JLabel lblSubTotalFac;
    private javax.swing.JLabel lblTotalArt;
    private javax.swing.JLabel lblTotalFac;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelItems;
    private javax.swing.JPanel panelTotales;
    private javax.swing.JRadioButton rbProductos;
    private javax.swing.JRadioButton rbServicios;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodCabys;
    private javax.swing.JTextField txtDesctoItem;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIdProv;
    private javax.swing.JTextField txtImptoItem;
    private javax.swing.JTextField txtNomComercial;
    private javax.swing.JTextField txtNomItem;
    private javax.swing.JTextField txtNomProv;
    private javax.swing.JTextField txtPrecioItem;
    private javax.swing.JTextField txtSubTotItem;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    private void inactivaCampos() {

        txtNomProv.setEnabled(false);
        cbTipoId.setEnabled(false);
        txtNomProv.setEnabled(false);
        txtNomComercial.setEnabled(false);
        txtEmail.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtCodCabys.setEnabled(false);
        txtNomItem.setEnabled(false);
        txtCantidad.setEnabled(false);
        txtDesctoItem.setEnabled(false);
        jtaNotas.setEnabled(false);
        jtItems.setEnabled(false);
        btnAgregaArt.setEnabled(false);
        btnEliminaArt.setEnabled(false);
        btnEnviar.setEnabled(false);
        btnActualizaProv.setEnabled(false);

    }

    private void limpiaCampos() {
        lblNuevoProv.setText("");
        txtNomProv.setText("");
        cbTipoId.setSelectedIndex(0);
        txtIdProv.setText("");
        txtNomComercial.setText("");
        txtEmail.setText("");
        txtTelefono.setText("");
        jtaNotas.setText("");
        txtCodCabys.setText("");
        lblDesCabys.setText("");
        txtNomItem.setText("");
        txtPrecioItem.setText("0");
        txtCantidad.setText("0");
        txtDesctoItem.setText("0");
        txtImptoItem.setText("0");
        txtSubTotItem.setText("0");
        cbExento.setSelected(false);
        mExento = 0;
        mIvaArt = 13;

        mTotExento = 0;
        mTotGravado = 0;
        mSubTotalFac = 0;
        mDesctoFac = 0;
        mImptoFac = 0;
        mTotalFac = 0;

        lblTotalArt.setText("0");
        lblMonExento.setText("0");
        lblMonGravado.setText("0");
        lblSubTotalFac.setText("0");
        lblDesctoFac.setText("0");
        lblIvaFac.setText("0");
        lblTotalFac.setText("0");

        dtmItems = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }

        };

        dtmItems.addColumn("Descripcion");
        dtmItems.addColumn("Cantidad");
        dtmItems.addColumn("Precio");
        dtmItems.addColumn("Descuento");
        dtmItems.addColumn("IVA");
        dtmItems.addColumn("Total");
        jtItems.setModel(dtmItems);

        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.RIGHT);

        jScrollPane1.setViewportView(jtItems);
        if (jtItems.getColumnModel().getColumnCount() > 0) {
            jtItems.getColumnModel().getColumn(0).setResizable(false);
            jtItems.getColumnModel().getColumn(0).setPreferredWidth(120);
            jtItems.getColumnModel().getColumn(1).setResizable(false);
            jtItems.getColumnModel().getColumn(1).setPreferredWidth(10);
            jtItems.getColumnModel().getColumn(1).setCellRenderer(dtcr);
            jtItems.getColumnModel().getColumn(2).setResizable(false);
            jtItems.getColumnModel().getColumn(2).setPreferredWidth(15);
            jtItems.getColumnModel().getColumn(2).setCellRenderer(dtcr);
            jtItems.getColumnModel().getColumn(3).setResizable(false);
            jtItems.getColumnModel().getColumn(3).setPreferredWidth(15);
            jtItems.getColumnModel().getColumn(3).setCellRenderer(dtcr);
            jtItems.getColumnModel().getColumn(4).setResizable(false);
            jtItems.getColumnModel().getColumn(4).setPreferredWidth(15);
            jtItems.getColumnModel().getColumn(4).setCellRenderer(dtcr);
            jtItems.getColumnModel().getColumn(5).setResizable(false);
            jtItems.getColumnModel().getColumn(5).setPreferredWidth(25);
            jtItems.getColumnModel().getColumn(5).setCellRenderer(dtcr);
        }

    }

    private void activaCampos() {

        txtNomProv.setEnabled(true);
        txtNomProv.setEnabled(true);
        txtNomComercial.setEnabled(true);
        txtEmail.setEnabled(true);
        txtTelefono.setEnabled(true);
        cbTipoId.setEnabled(true);
        txtCodCabys.setEnabled(true);
        txtNomItem.setEnabled(true);
        txtCantidad.setEnabled(true);
        txtDesctoItem.setEnabled(true);
        jtaNotas.setEnabled(true);
        jtItems.setEnabled(true);
        btnAgregaArt.setEnabled(true);
        btnEliminaArt.setEnabled(true);
        btnEnviar.setEnabled(true);
        btnActualizaProv.setEnabled(true);

    }

    private void calculaMontos() {

        if (cbExento.isSelected()) {
            mIvaArt = 0;
        } else {
            mIvaArt = 13;
        }

        iCantidad = Integer.valueOf(txtCantidad.getText().replace(",", ""));
        mSubTotalItem = Double.valueOf(txtSubTotItem.getText().replace(",", ""));
        mDesctoItem = Double.valueOf(txtDesctoItem.getText().replace(",", ""));
        mImptoItem = Redondear.decimal(((mSubTotalItem - mDesctoItem) * mIvaArt / 100), 2);
        txtImptoItem.setText(formatoDecimal.format(mImptoItem));
        mPrecio = mSubTotalItem / iCantidad;
        txtPrecioItem.setText(formatoDecimal.format(mPrecio));
        mTotalItem = mSubTotalItem - mDesctoItem + mImptoItem;

        lblTotalArt.setText(formatoDecimal.format(mTotalItem));

    }

    private void agregaItem() {

        if (rbProductos.isSelected()) {
            mTipoItem = 1;
        } else if (rbServicios.isSelected()) {
            mTipoItem = 2;
        }

        ItemCompraVO item = new ItemCompraVO();
        item.setNomItem(txtNomItem.getText());
        item.setCantidad(iCantidad);
        item.setPrecioItem(mPrecio);
        item.setTotDesctoItem(mDesctoItem);
        item.setPorImptoItem(mIvaArt);
        item.setTotImptoItem(mImptoItem);
        item.setSubTotItem(mSubTotalItem);
        item.setTipoItem(mTipoItem);
        item.setExento(mExento);
        item.setCodigoCabys(txtCodCabys.getText());
        listaItemCompra.add(item);

        Object[] fila = new Object[7];
        fila[0] = txtNomItem.getText();
        String sCant = formatoEntero.format(iCantidad);
        fila[1] = sCant;
        String sPrecio = formatoDecimal.format(mPrecio);
        fila[2] = sPrecio;
        String sDescto = formatoDecimal.format(mDesctoItem);
        fila[3] = sDescto;
        String sIva = formatoDecimal.format(mImptoItem);
        fila[4] = sIva;
        String sTotal = formatoDecimal.format(mTotalItem);
        fila[5] = sTotal;
        dtmItems.addRow(fila);

        if (item.getExento() == 1) {
            mTotExento += mSubTotalItem;
        } else {
            mTotGravado += mSubTotalItem;
        }
        mSubTotalFac += mSubTotalItem;
        mDesctoFac += mDesctoItem;
        mImptoFac += mImptoItem;
        mTotalFac += mTotalItem;
        lblMonExento.setText(formatoDecimal.format(mTotExento));
        lblMonGravado.setText(formatoDecimal.format(mTotGravado));
        lblSubTotalFac.setText(formatoDecimal.format(mSubTotalFac));
        lblDesctoFac.setText(formatoDecimal.format(mDesctoFac));
        lblIvaFac.setText(formatoDecimal.format(mImptoFac));
        lblTotalFac.setText(formatoDecimal.format(mTotalFac));
        cbExento.setSelected(false);
        mExento = 0;
        txtNomItem.setText("");
        txtCantidad.setText("0");
        txtDesctoItem.setText("0");
        txtPrecioItem.setText("0");
        txtSubTotItem.setText("0");
        txtImptoItem.setText("0");
        lblTotalArt.setText("0");
        txtCodCabys.setText("");
        lblDesCabys.setText("");
        txtCodCabys.requestFocus();

        mSubTotalItem = 0;
        mDesctoItem = 0;
        mImptoItem = 0;
        mTotalItem = 0;
    }

    private void enviarFactura() throws IOException, JSONException {

        String url;
        JSONObject respuesta;

        bp.abrirVentana("Generando factura...");

        proveedorVo.setNomComProv(txtNomComercial.getText());
        proveedorVo.setNomProv(txtNomProv.getText());
        proveedorVo.setIdProv(txtIdProv.getText());
        proveedorVo.setTipoIdProv(cbTipoId.getSelectedItem().toString());
        proveedorVo.setEmailProv(txtEmail.getText());
        proveedorVo.setTeleProv(txtTelefono.getText());

        JSONArray jsonArray = new JSONArray();
        for (ItemCompraVO item : listaItemCompra) {

            JSONObject jsonItemFac = new JSONObject();
            jsonItemFac.put("nomItem", item.getNomItem());
            jsonItemFac.put("cantidad", item.getCantidad());
            jsonItemFac.put("precio", item.getPrecioItem());
            jsonItemFac.put("mon_subtotal", item.getSubTotItem());
            jsonItemFac.put("mon_descto", item.getTotDesctoItem());
            jsonItemFac.put("por_impto", item.getPorImptoItem());
            jsonItemFac.put("mon_impto", item.getTotImptoItem());
            jsonItemFac.put("tipoItem", item.getTipoItem());
            jsonItemFac.put("exento", item.getExento());
            jsonItemFac.put("codigoCabys", item.getCodigoCabys());
            jsonArray.put(jsonItemFac);
        }

        JSONObject jsonFactura = new JSONObject();
        jsonFactura.put("cod_agencia", Variables.mAGEUSU);
        jsonFactura.put("cod_pdv", Variables.mPDVUSU);
        jsonFactura.put("nomComercial", proveedorVo.getNomComProv());
        jsonFactura.put("tipo_doc", "08");
        jsonFactura.put("nom_tributa", proveedorVo.getNomProv());
        jsonFactura.put("id_tributa", proveedorVo.getIdProv());
        jsonFactura.put("tipo_id", proveedorVo.getTipoIdProv());
        jsonFactura.put("email", proveedorVo.getEmailProv());
        jsonFactura.put("telefono", proveedorVo.getTeleProv());
        jsonFactura.put("notas_fact", jtaNotas.getText());
        jsonFactura.put("items", jsonArray);

        url = Variables.URL_SERVER + "ejecucionpdv/wsAgregaFacturaCompra_v2.php";
        respuesta = HttpClient.httpPOST(url, jsonFactura);
        numFactura = respuesta.optInt("factura");

        bp.abrirVentana("Enviando factura a Hacienda...");

        url = Variables.URL_SERVER + "ejecucionpdv/wsApifecrEnvioFactCompra_v2.php?num_factura=" + numFactura;

        JSONObject respEnvio = HttpClient.httpGET(url);

        bp.setVisible(false);

        JOptionPane.showMessageDialog(this, "Factura registrada\nNúmero Consecutivo: " + respEnvio.optString("NumeroConsecutivo"));
        inactivaCampos();
        limpiaCampos();
        jtpFactCompra.setSelectedIndex(0);
        txtIdProv.requestFocus();


    }

   

    private void consultaProveedor() throws SQLException {

        proveedorVo = new ProveedorVO();
        proveedorVo.setIdProv(txtIdProv.getText());
        if (ProveedorDAOImpl.consulta(proveedorVo)) {
            cbTipoId.setSelectedItem(proveedorVo.getIdProv());
            txtNomProv.setText(proveedorVo.getNomProv());
            txtNomComercial.setText(proveedorVo.getNomComProv());
            txtEmail.setText(proveedorVo.getEmailProv());
            txtTelefono.setText(proveedorVo.getTeleProv());
            activaCampos();
            txtNomProv.requestFocus();
            nuevoProv = false;
            lblNuevoProv.setText("Proveedor existente");
        } else {
            cbTipoId.setSelectedIndex(0);
            txtNomProv.setText("");
            txtNomComercial.setText("");
            txtEmail.setText("");
            txtTelefono.setText("");

            switch (txtIdProv.getText().length()) {
                case 9:
                    cbTipoId.setSelectedIndex(0);
                    break;
                case 10:
                    cbTipoId.setSelectedIndex(1);
                    break;
                case 11:
                    cbTipoId.setSelectedIndex(2);
                    break;
                case 12:
                    cbTipoId.setSelectedIndex(3);
                    break;
            }

            activaCampos();
            txtNomProv.requestFocus();
            nuevoProv = true;
            lblNuevoProv.setText("Nuevo Proveedor");
        }

    }

    private void actualizaProveedor() {

        proveedorVo.setNomProv(txtNomProv.getText());
        proveedorVo.setTipoIdProv(cbTipoId.getSelectedItem().toString());
        proveedorVo.setNomComProv(txtNomComercial.getText());
        proveedorVo.setEmailProv(txtEmail.getText());
        proveedorVo.setTeleProv(txtTelefono.getText());

        if (nuevoProv) {
            ProveedorDAOImpl.incluir(proveedorVo);
        } else {
            ProveedorDAOImpl.actualizar(proveedorVo);
        }
        JOptionPane.showMessageDialog(this, "Proveedor actualizado");
    }

    private void consultaCabys(String codigo) throws SQLException {

        cabysVO = cabysDAO.consultaCabys(codigo);
        if (cabysVO == null) {
            JOptionPane.showMessageDialog(this, "Cabys NO existe");

            return;
        }
        lblDesCabys.setText(cabysVO.getDescrpcion());
        txtNomItem.setText(cabysVO.getDescrpcion());
        txtNomItem.requestFocus();

    }

    private void buscarCabys() throws SQLException {
        BuscaCabys buscar = new BuscaCabys(null, true);
        String[] valorSelec = buscar.getCodigo();
        if (valorSelec == null) {
            txtCodCabys.setText("");
            lblDesCabys.setText("");
            txtCodCabys.requestFocus();

        } else {
            txtCodCabys.setText(valorSelec[0]);
            lblDesCabys.setText(valorSelec[1]);
            txtNomItem.setText(valorSelec[1]);
            txtNomItem.requestFocus();
        }

    }

}
