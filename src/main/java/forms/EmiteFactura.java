package forms;

import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import metodos.Redondear;
import metodos.VerificaEmail;
import modelo.VO.AgenciaVO;
import modelo.VO.ArticuloVO;
import modelo.VO.ClienteVO;
import modelo.HttpClient;
import modelo.VO.ItemFacVO;
import modelo.VO.PdvVO;
import modelo.VO.PrecioVO;
import modelo.DAO.ArticuloDAOImpl;
import modelo.DAO.ClienteDAOImpl;
import modelo.DAO.PdvDAOImpl;
import modelo.DAO.PrecioDAOImpl;
import modelo.Validar;
import modelo.Variables;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EmiteFactura extends javax.swing.JInternalFrame {

    DefaultTableModel dtmArticulos;
    ArrayList<ItemFacVO> listaItemFacVo;
    ArticuloVO articuloVo;
    PrecioVO precioVo;
    Validar valida;
    BarraProgreso bp;

    ItemFacVO itemFacVo;
    ArrayList<ItemFacVO> listaItemFac;
    ClienteVO clienteVo;
    private String tipoDoc = "01";
    private String tipoFac = "01";
    private int mCodCliente, mCodAgencia, mCodPdv;
    private String mEmail, consecutivo_fe, clave_fe, fecha_fe, hora_fe, mTipoId, mNotas;
    private double monGraFac, monExeFac, subTotFac, monDesctoFac, monIvaFac, monTotFac;
    private double mTotSerGra, mTotSerExe, mTotMerGra, mTotMerExe, mTotIVADev, mTotOtrCar;
    private int mPorDesctoCli, mPlazoCre, mMontoCredito, mPorDesctoArt, mIvaArt, mPorDescto, iCantidad, mRedondeo;
    private double mPrecio, mDesctoArt, mImptoArt, mSubTotalArt, mTotalArt, mSubTotalFac, mDesctoFac, mImptoFac, mTotalFac, mTotExento, mTotGravado;

    DecimalFormat formatoDecimal = new DecimalFormat("###,###,##0.00");
    DecimalFormat formatoEntero = new DecimalFormat("#####,##0");
    SimpleDateFormat formatoYMD = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sqlFecha = new SimpleDateFormat("yyyy-MM-dd");

    public EmiteFactura() {
        initComponents();
        articuloVo = new ArticuloVO();
        precioVo = new PrecioVO();
        itemFacVo = new ItemFacVO();
        valida = new Validar();
        bp = new BarraProgreso();

        valida.limitarCaracteres(txtCodCliente, Variables.L_COD_CLI);
        valida.soloNumeros(txtCodCliente);
        valida.soloNumeros(txtIdFactura);
        valida.limitarCaracteres(txtIdFactura, Variables.L_ID_TRIBUTA);
        valida.soloNumeros(txtCodArt);
        valida.limitarCaracteres(txtCodArt, 13);
        valida.limitarCaracteres(txtDescto, Variables.L_MON_DESCTO);
        valida.soloNumeros(txtDescto);
        valida.soloNumeros(txtCantidad);
        valida.limitarCaracteres(txtCantidad, 12);
        valida.soloNumeros(txtNumFactura);
        valida.limitarCaracteres(txtNumFactura, 12);

        jtArticulos.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouse_evt) {
                if (mouse_evt.getClickCount() == 2) {
                    //seleccionaArtTabla(); //Revisar 
                }
            }
        });

        inactivaCampos();
        limpiaCampos();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgTipDoc = new javax.swing.ButtonGroup();
        btgTipFac = new javax.swing.ButtonGroup();
        lblNumConse = new javax.swing.JLabel();
        txtNumFactura = new javax.swing.JTextField();
        lblConseFE = new javax.swing.JLabel();
        lblClaveFE = new javax.swing.JLabel();
        jpBotones = new javax.swing.JPanel();
        btnEnviar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnAnular = new javax.swing.JButton();
        jpTotalesFac = new javax.swing.JPanel();
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
        jtpDatosFac = new javax.swing.JTabbedPane();
        jtpDatosGenerales = new javax.swing.JPanel();
        lblFecha = new javax.swing.JLabel();
        jdcFecFactura = new com.toedter.calendar.JDateChooser();
        txtCodCliente = new javax.swing.JTextField();
        lblCliente = new javax.swing.JLabel();
        lblNomCliente = new javax.swing.JLabel();
        txtIdFactura = new javax.swing.JTextField();
        lblIdFactura = new javax.swing.JLabel();
        blNomFactura = new javax.swing.JLabel();
        txtNomFactura = new javax.swing.JTextField();
        lblTipoId = new javax.swing.JLabel();
        cbTipoId = new javax.swing.JComboBox<>();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jtpCondiciones = new javax.swing.JPanel();
        lblTipoDoc = new javax.swing.JLabel();
        rbFacEle = new javax.swing.JRadioButton();
        rbTiqEle = new javax.swing.JRadioButton();
        lblTipoFactura = new javax.swing.JLabel();
        rbContado = new javax.swing.JRadioButton();
        rbCredito = new javax.swing.JRadioButton();
        lblPlazo = new javax.swing.JLabel();
        txtPlazo = new javax.swing.JTextField();
        lblDias = new javax.swing.JLabel();
        jpItems = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtArticulos = new javax.swing.JTable();
        lblCodArt = new javax.swing.JLabel();
        txtCodArt = new javax.swing.JTextField();
        lblNomArt = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lblPrecio = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        lblDescto = new javax.swing.JLabel();
        txtDescto = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        lblSubTotArt = new javax.swing.JLabel();
        lblDesctoArt = new javax.swing.JLabel();
        lblIvaArt = new javax.swing.JLabel();
        lblTotalArt = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        btnAgregaArt = new javax.swing.JButton();
        btnEliminaArt = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Emision de facturas");
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

        lblNumConse.setText("Numero conseccutivo");

        txtNumFactura.setToolTipText("ENTER O TAB para nueva factura");
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

        lblConseFE.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblClaveFE.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jpBotones.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
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

        btnAnular.setText("Anular");
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpBotonesLayout = new javax.swing.GroupLayout(jpBotones);
        jpBotones.setLayout(jpBotonesLayout);
        jpBotonesLayout.setHorizontalGroup(
            jpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBotonesLayout.createSequentialGroup()
                        .addGroup(jpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnAnular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpBotonesLayout.setVerticalGroup(
            jpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnImprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAnular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addGap(17, 17, 17))
        );

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
        jLabel18.setText("Total Factura");

        javax.swing.GroupLayout jpTotalesFacLayout = new javax.swing.GroupLayout(jpTotalesFac);
        jpTotalesFac.setLayout(jpTotalesFacLayout);
        jpTotalesFacLayout.setHorizontalGroup(
            jpTotalesFacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTotalesFacLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jpTotalesFacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTotalesFacLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMonGravado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTotalesFacLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSubTotalFac, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTotalesFacLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMonExento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTotalesFacLayout.createSequentialGroup()
                        .addGroup(jpTotalesFacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addGroup(jpTotalesFacLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel17)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpTotalesFacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIvaFac, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDesctoFac, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTotalesFacLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotalFac, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpTotalesFacLayout.setVerticalGroup(
            jpTotalesFacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTotalesFacLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpTotalesFacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpTotalesFacLayout.createSequentialGroup()
                        .addGroup(jpTotalesFacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpTotalesFacLayout.createSequentialGroup()
                                .addGroup(jpTotalesFacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblMonGravado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMonExento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpTotalesFacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addComponent(lblSubTotalFac, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDesctoFac, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpTotalesFacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblIvaFac, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpTotalesFacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTotalFac, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtaNotas.setColumns(20);
        jtaNotas.setRows(5);
        jtaNotas.setBorder(javax.swing.BorderFactory.createTitledBorder("Notas"));
        jScrollPane2.setViewportView(jtaNotas);

        jtpDatosFac.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jtpDatosFac.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtpDatosFacFocusGained(evt);
            }
        });

        lblFecha.setText("Fecha");

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

        txtCodCliente.setText(" ");
        txtCodCliente.setToolTipText("CRTL + ENTER para busqueda");
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
        });

        lblCliente.setText("Cliente");

        lblNomCliente.setText(" ");
        lblNomCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        txtIdFactura.setText(" ");
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

        lblIdFactura.setText("ID");

        blNomFactura.setText("Nombre a facturar");

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

        lblTipoId.setText("Tipo ID");

        cbTipoId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1-Fisica", "2-Juridica", "3-DIMEX", "4-NITE" }));

        lblEmail.setText("Email");

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

        javax.swing.GroupLayout jtpDatosGeneralesLayout = new javax.swing.GroupLayout(jtpDatosGenerales);
        jtpDatosGenerales.setLayout(jtpDatosGeneralesLayout);
        jtpDatosGeneralesLayout.setHorizontalGroup(
            jtpDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jtpDatosGeneralesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jtpDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jtpDatosGeneralesLayout.createSequentialGroup()
                        .addGroup(jtpDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jtpDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblIdFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jtpDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jtpDatosGeneralesLayout.createSequentialGroup()
                                .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNomCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jdcFecFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jtpDatosGeneralesLayout.createSequentialGroup()
                                .addComponent(txtIdFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(lblTipoId)
                                .addGap(18, 18, 18)
                                .addComponent(cbTipoId, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jtpDatosGeneralesLayout.createSequentialGroup()
                        .addGroup(jtpDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(blNomFactura)
                            .addComponent(lblEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jtpDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jtpDatosGeneralesLayout.setVerticalGroup(
            jtpDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jtpDatosGeneralesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jtpDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcFecFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFecha, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(4, 4, 4)
                .addGroup(jtpDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCliente)
                    .addComponent(lblNomCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jtpDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdFactura)
                    .addComponent(lblTipoId)
                    .addComponent(cbTipoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jtpDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(blNomFactura)
                    .addComponent(txtNomFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jtpDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(128, Short.MAX_VALUE))
        );

        jtpDatosFac.addTab("Datos generales", jtpDatosGenerales);

        lblTipoDoc.setText("Tipo Documento");

        btgTipDoc.add(rbFacEle);
        rbFacEle.setSelected(true);
        rbFacEle.setText("Factura Electronica");
        rbFacEle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFacEleActionPerformed(evt);
            }
        });

        btgTipDoc.add(rbTiqEle);
        rbTiqEle.setText("Tiquete Electronico");
        rbTiqEle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTiqEleActionPerformed(evt);
            }
        });

        lblTipoFactura.setText("Tipo factura");

        btgTipFac.add(rbContado);
        rbContado.setSelected(true);
        rbContado.setText("Contado");
        rbContado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbContadoActionPerformed(evt);
            }
        });

        btgTipFac.add(rbCredito);
        rbCredito.setText("Credito");
        rbCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCreditoActionPerformed(evt);
            }
        });

        lblPlazo.setText("Plazo");

        txtPlazo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPlazoFocusGained(evt);
            }
        });

        lblDias.setText("dias");

        javax.swing.GroupLayout jtpCondicionesLayout = new javax.swing.GroupLayout(jtpCondiciones);
        jtpCondiciones.setLayout(jtpCondicionesLayout);
        jtpCondicionesLayout.setHorizontalGroup(
            jtpCondicionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jtpCondicionesLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jtpCondicionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipoDoc)
                    .addComponent(lblTipoFactura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jtpCondicionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jtpCondicionesLayout.createSequentialGroup()
                        .addGroup(jtpCondicionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbContado)
                            .addComponent(rbCredito))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPlazo))
                    .addComponent(rbFacEle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jtpCondicionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbTiqEle)
                    .addGroup(jtpCondicionesLayout.createSequentialGroup()
                        .addComponent(txtPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDias)))
                .addContainerGap(292, Short.MAX_VALUE))
        );
        jtpCondicionesLayout.setVerticalGroup(
            jtpCondicionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jtpCondicionesLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jtpCondicionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoDoc)
                    .addComponent(rbFacEle)
                    .addComponent(rbTiqEle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jtpCondicionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoFactura)
                    .addComponent(rbContado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jtpCondicionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbCredito)
                    .addComponent(lblPlazo)
                    .addComponent(txtPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDias))
                .addContainerGap(175, Short.MAX_VALUE))
        );

        jtpDatosFac.addTab("Condiciones", jtpCondiciones);

        jpItems.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        lblCodArt.setText("Codigo");

        txtCodArt.setText(" ");
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

        lblNomArt.setText(" ");
        lblNomArt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblCantidad.setText("Cantidad");

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

        lblPrecio.setText("Precio");

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

        lblDescto.setText("Descuento");

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

        jLabel23.setText("%");

        lblSubTotArt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubTotArt.setText(" ");
        lblSubTotArt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblDesctoArt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDesctoArt.setText(" ");
        lblDesctoArt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblIvaArt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIvaArt.setText(" ");
        lblIvaArt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblTotalArt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalArt.setText(" ");
        lblTotalArt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel24.setText("Sub-Total");

        jLabel26.setText("Monto IVA ");

        jLabel27.setText("Total ");

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

        javax.swing.GroupLayout jpItemsLayout = new javax.swing.GroupLayout(jpItems);
        jpItems.setLayout(jpItemsLayout);
        jpItemsLayout.setHorizontalGroup(
            jpItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpItemsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpItemsLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpItemsLayout.createSequentialGroup()
                        .addGroup(jpItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCodArt)
                            .addComponent(lblCantidad))
                        .addGap(23, 23, 23)
                        .addGroup(jpItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpItemsLayout.createSequentialGroup()
                                .addComponent(txtCodArt, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
                            .addGroup(jpItemsLayout.createSequentialGroup()
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jpItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpItemsLayout.createSequentialGroup()
                                .addGroup(jpItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jpItemsLayout.createSequentialGroup()
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(lblSubTotArt, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpItemsLayout.createSequentialGroup()
                                        .addGroup(jpItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jpItemsLayout.createSequentialGroup()
                                                .addComponent(lblDescto)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtDescto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel23))
                                            .addComponent(jLabel26)
                                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jpItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblIvaArt, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblTotalArt, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblDesctoArt, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(jpItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAgregaArt, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEliminaArt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblNomArt, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jpItemsLayout.setVerticalGroup(
            jpItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpItemsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCodArt)
                    .addGroup(jpItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCodArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNomArt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpItemsLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(btnEliminaArt))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpItemsLayout.createSequentialGroup()
                        .addGroup(jpItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCantidad)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrecio)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)
                            .addComponent(lblSubTotArt)
                            .addComponent(btnAgregaArt))
                        .addGroup(jpItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblDescto)
                                .addComponent(txtDescto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpItemsLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDesctoArt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblIvaArt)
                                    .addComponent(jLabel26))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotalArt)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtpDatosFac.addTab("Detallle", jpItems);

        jLabel9.setText("Consecutivo FE");

        jLabel10.setText("Clave FE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNumConse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblConseFE, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblClaveFE, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jpTotalesFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtpDatosFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jpBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblNumConse)
                                .addComponent(txtNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(7, 7, 7)
                                    .addComponent(jLabel9))
                                .addComponent(lblClaveFE, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(lblConseFE, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtpDatosFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jpBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpTotalesFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        txtNumFactura.getAccessibleContext().setAccessibleName("");
        txtNumFactura.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        inactivaCampos();
        limpiaCampos();
        jtpDatosFac.setSelectedIndex(0);
        txtNumFactura.setEnabled(true);
        txtNumFactura.requestFocus();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Variables.frmEmiFac = null;
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtCodClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodClienteKeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                buscarCliente();
            } catch (SQLException ex) {
                Logger.getLogger(EmiteFactura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtCodClienteKeyPressed

    private void txtCodClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodClienteActionPerformed

        if (txtCodCliente.getText().trim().length() > 0) {
            try {
                // Consulta cliente a modificar
                consultarCliente();
            } catch (SQLException ex) {
                Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtCodClienteActionPerformed

    private void rbTiqEleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTiqEleActionPerformed

        txtNomFactura.setText("Cliente contado");
        txtIdFactura.setText("999999999");
        txtEmail.setText("");
        cbTipoId.setSelectedIndex(0);
        rbContado.setSelected(true);
        txtPlazo.setText("0");
        txtNomFactura.setEnabled(false);
        txtIdFactura.setEnabled(false);
        txtEmail.setEnabled(false);
        txtPlazo.setEnabled(false);
        cbTipoId.setEnabled(false);
        rbContado.setEnabled(false);
        rbCredito.setEnabled(false);
        tipoDoc = "04";

        txtCodArt.requestFocus();


    }//GEN-LAST:event_rbTiqEleActionPerformed

    private void jdcFecFacturaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jdcFecFacturaFocusGained

    }//GEN-LAST:event_jdcFecFacturaFocusGained

    private void txtCodClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodClienteFocusGained
        txtCodCliente.selectAll();
    }//GEN-LAST:event_txtCodClienteFocusGained

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

    private void rbContadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbContadoActionPerformed

        txtPlazo.setEnabled(false);
        txtPlazo.setText("0");
        tipoFac = "01";
        //txtCodArt.requestFocus();
    }//GEN-LAST:event_rbContadoActionPerformed

    private void rbCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCreditoActionPerformed

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

    private void jdcFecFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jdcFecFacturaMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jdcFecFacturaMouseClicked

    private void jdcFecFacturaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jdcFecFacturaMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jdcFecFacturaMousePressed

    private void rbFacEleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFacEleActionPerformed

        txtNomFactura.setEnabled(true);
        txtNomFactura.setText(clienteVo.getNom_tributa());
        txtIdFactura.setEnabled(true);
        txtIdFactura.setText(clienteVo.getId_tributa());
        txtEmail.setEnabled(true);
        txtEmail.setText(clienteVo.getEmail_cliente());
        txtPlazo.setEnabled(true);
        cbTipoId.setEnabled(true);
        cbTipoId.setSelectedItem(clienteVo.getTipo_id());
        rbContado.setEnabled(true);
        rbCredito.setEnabled(true);
        txtIdFactura.requestFocus();
        tipoDoc = "01";

    }//GEN-LAST:event_rbFacEleActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        // TODO add your handling code here:
        if (mTotalFac == 0) {
            JOptionPane.showMessageDialog(this, "No se permite registrar una factura en CERO");
            txtCodArt.requestFocus();
            return;
        }
        if (txtEmail.getText().length() > 0) {
            if (!VerificaEmail.verificar(txtEmail.getText())) {
                JOptionPane.showMessageDialog(this, "Correo Electronico Incorrecto");
                txtEmail.requestFocus();
                return;
            }
        }

        if (tipoDoc.equals("01")) {
            if (txtNomFactura.getText().length() > 0) {
                if (txtIdFactura.getText().length() == 0) {
                    JOptionPane.showMessageDialog(this, "Debe introducir un numero de ID");
                    txtIdFactura.requestFocus();
                    return;
                } else {
                    switch (cbTipoId.getSelectedIndex()) {
                        case 0:
                            if (txtIdFactura.getText().length() != 9) {
                                JOptionPane.showMessageDialog(this, "ID incorrecto");
                                txtIdFactura.requestFocus();
                                return;
                            }
                            break;
                        case 1:
                            if (txtIdFactura.getText().length() != 10) {
                                JOptionPane.showMessageDialog(this, "ID incorrecto");
                                txtIdFactura.requestFocus();
                                return;
                            }
                            break;
                        case 2:
                            if (txtIdFactura.getText().length() < 11 || txtIdFactura.getText().length() > 12) {
                                JOptionPane.showMessageDialog(this, "ID incorrecto");
                                txtIdFactura.requestFocus();
                                return;
                            }
                            break;
                        case 3:
                            if (txtIdFactura.getText().length() != 10) {
                                JOptionPane.showMessageDialog(this, "ID incorrecto");
                                txtIdFactura.requestFocus();
                                return;
                            }
                            break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe digitat un nombre a facturar");
                txtNomFactura.requestFocus();
                return;
            }
        }

        btnEnviar.setEnabled(false);

        try {
            enviarFactura();
        } catch (IOException | JSONException ex) {
            Logger.getLogger(EmiteFactura.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnEnviarActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing

        Variables.frmEmiFac = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnEliminaArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaArtActionPerformed
        // TODO add your handling code here:
        int filaSelec = jtArticulos.getSelectedRow();
        if (filaSelec != -1) {

            if (listaItemFacVo.get(filaSelec).getExento() == 1) {
                mTotExento -= listaItemFacVo.get(filaSelec).getMon_subtotal();
            } else {
                mTotGravado -= listaItemFacVo.get(filaSelec).getMon_subtotal();
            }
            mSubTotalFac -= listaItemFacVo.get(filaSelec).getMon_subtotal();
            mDesctoFac -= listaItemFacVo.get(filaSelec).getMon_descto();
            mImptoFac -= listaItemFacVo.get(filaSelec).getMon_impto();
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
            lblNomArt.setText("");
            lblSubTotArt.setText("0");
            lblDesctoArt.setText("0");
            lblIvaArt.setText("0");
            lblTotalArt.setText("0");
            txtCodArt.requestFocus();

            listaItemFacVo.remove(filaSelec);
            dtmArticulos.removeRow(filaSelec);

        } else {
            JOptionPane.showMessageDialog(this, "Selecciones una fila a eliminar");
        }
    }//GEN-LAST:event_btnEliminaArtActionPerformed

    private void btnAgregaArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregaArtActionPerformed
        // TODO add your handling code here:
        agregaItem();
    }//GEN-LAST:event_btnAgregaArtActionPerformed

    private void txtDesctoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDesctoActionPerformed
        // TODO add your handling code here:
        calculaMontos();
        btnAgregaArt.requestFocus();
    }//GEN-LAST:event_txtDesctoActionPerformed

    private void txtDesctoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDesctoFocusGained
        // TODO add your handling code here:
        txtDescto.selectAll();
    }//GEN-LAST:event_txtDesctoFocusGained

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        mPrecio = Double.valueOf(txtPrecio.getText());
        txtPrecio.setText(formatoDecimal.format(mPrecio));
        calculaMontos();
        btnAgregaArt.requestFocus();
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtPrecioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioFocusGained
        // TODO add your handling code here:
        txtPrecio.selectAll();
    }//GEN-LAST:event_txtPrecioFocusGained

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:

        calculaMontos();
        if (articuloVo.getTipo_item() == 1) {
            txtDescto.requestFocus();
        } else {
            txtPrecio.requestFocus();
        }
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtCantidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFocusGained
        // TODO add your handling code here:
        txtCantidad.selectAll();
    }//GEN-LAST:event_txtCantidadFocusGained

    private void txtCodArtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodArtKeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                buscarArticulo();
            } catch (SQLException ex) {
                Logger.getLogger(Precios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtCodArtKeyPressed

    private void txtCodArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodArtActionPerformed
        // TODO add your handling code here:
        if (txtCodArt.getText().length() > 0) {
            try {
                consultarArticulo();
            } catch (SQLException ex) {
                Logger.getLogger(Precios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtCodArtActionPerformed

    private void txtCodArtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodArtFocusGained
        // TODO add your handling code here:
        txtCodArt.selectAll();
    }//GEN-LAST:event_txtCodArtFocusGained

    private void txtNumFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumFacturaActionPerformed

        if (txtNumFactura.getText().trim().length() > 0) {
            try {
                consultaFactura();
            } catch (JSONException ex) {
                Logger.getLogger(EmiteFactura.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //activaCampos();
            jtpDatosFac.setSelectedIndex(0);
            if (Variables.mTIPOUSU > 2) {
                jdcFecFactura.setEnabled(true);
            } else {
                jdcFecFactura.setEnabled(false);
            }
            txtCodCliente.setEnabled(true);
            txtCodCliente.requestFocus();
        }

    }//GEN-LAST:event_txtNumFacturaActionPerformed

    private void txtNumFacturaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumFacturaFocusGained
        txtNumFactura.selectAll();
    }//GEN-LAST:event_txtNumFacturaFocusGained

    private void jtpDatosFacFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtpDatosFacFocusGained
        txtCodArt.requestFocus();
    }//GEN-LAST:event_jtpDatosFacFocusGained

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed

        try {
            imprimeFactura(Integer.valueOf(txtNumFactura.getText()));
        } catch (JSONException ex) {
            Logger.getLogger(EmiteFactura.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed

        int seleccion = JOptionPane.showOptionDialog(
                this,
                "Desea anular la factura ?",
                "Confirmacion de anulación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, // null para icono por defecto.
                new Object[]{"Si", "No"},
                "No");

        if (seleccion != 0) {// Opcion diferente a SI
            return;
        }

        if (mTotalFac == 0) {

            JOptionPane.showMessageDialog(this, "Factura YA fue anulada");
            //limpiaCampos();
            //btnAnular.setEnabled(false);
            txtNumFactura.requestFocus();
            return;
        }

        if (Variables.mTIPOUSU == 1 && (mCodAgencia != Variables.mAGEUSU || mCodPdv != Variables.mPDVUSU)) {
            JOptionPane.showMessageDialog(this, "Usuario NO autorizado para anular esta factura");
            //limpiaCampos();
            //btnAnular.setEnabled(false);
            txtNumFactura.requestFocus();
            return;
        }
        if (Variables.mTIPOUSU <= 3 && mCodAgencia != Variables.mAGEUSU) {
            JOptionPane.showMessageDialog(this, "Usuario NO autorizado para anular esta factura");
            //limpiaCampos();
            //btnAnular.setEnabled(false);
            txtNumFactura.requestFocus();
            return;
        }

        try {
            anulaFactura();
        } catch (IOException ex) {
            Logger.getLogger(EmiteFactura.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error en la conexión con la base de datos");
        } catch (JSONException ex) {
            Logger.getLogger(EmiteFactura.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnAnularActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel blNomFactura;
    private javax.swing.ButtonGroup btgTipDoc;
    private javax.swing.ButtonGroup btgTipFac;
    private javax.swing.JButton btnAgregaArt;
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminaArt;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbTipoId;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcFecFactura;
    private javax.swing.JPanel jpBotones;
    private javax.swing.JPanel jpItems;
    private javax.swing.JPanel jpTotalesFac;
    private javax.swing.JTable jtArticulos;
    private javax.swing.JTextArea jtaNotas;
    private javax.swing.JPanel jtpCondiciones;
    private javax.swing.JTabbedPane jtpDatosFac;
    private javax.swing.JPanel jtpDatosGenerales;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblClaveFE;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCodArt;
    private javax.swing.JLabel lblConseFE;
    private javax.swing.JLabel lblDescto;
    private javax.swing.JLabel lblDesctoArt;
    private javax.swing.JLabel lblDesctoFac;
    private javax.swing.JLabel lblDias;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblIdFactura;
    private javax.swing.JLabel lblIvaArt;
    private javax.swing.JLabel lblIvaFac;
    private javax.swing.JLabel lblMonExento;
    private javax.swing.JLabel lblMonGravado;
    private javax.swing.JLabel lblNomArt;
    private javax.swing.JLabel lblNomCliente;
    private javax.swing.JLabel lblNumConse;
    private javax.swing.JLabel lblPlazo;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblSubTotArt;
    private javax.swing.JLabel lblSubTotalFac;
    private javax.swing.JLabel lblTipoDoc;
    private javax.swing.JLabel lblTipoFactura;
    private javax.swing.JLabel lblTipoId;
    private javax.swing.JLabel lblTotalArt;
    private javax.swing.JLabel lblTotalFac;
    private javax.swing.JRadioButton rbContado;
    private javax.swing.JRadioButton rbCredito;
    private javax.swing.JRadioButton rbFacEle;
    private javax.swing.JRadioButton rbTiqEle;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodArt;
    private javax.swing.JTextField txtCodCliente;
    private javax.swing.JTextField txtDescto;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIdFactura;
    private javax.swing.JTextField txtNomFactura;
    private javax.swing.JTextField txtNumFactura;
    private javax.swing.JTextField txtPlazo;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

    private void inactivaCampos() {

        jdcFecFactura.setEnabled(false);
        txtCodCliente.setEnabled(false);
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
        txtPrecio.setEnabled(false);
        txtCantidad.setEnabled(false);
        txtDescto.setEnabled(false);
        jtaNotas.setEnabled(false);
        jtArticulos.setEnabled(false);
        btnAgregaArt.setEnabled(false);
        btnEliminaArt.setEnabled(false);
        btnEnviar.setEnabled(false);
        btnImprimir.setEnabled(false);
        btnAnular.setEnabled(false);

    }

    private void limpiaCampos() {

        Date fecha = new Date();
        jdcFecFactura.setDate(fecha);
        txtCodCliente.setText("");
        lblNomCliente.setText("");
        txtNomFactura.setText("");
        txtIdFactura.setText("");
        cbTipoId.setSelectedIndex(0);
        txtEmail.setText("");
        txtPlazo.setText("0");
        txtCodArt.setText("");
        lblNomArt.setText("");
        txtPrecio.setText("0");
        txtCantidad.setText("0");
        txtDescto.setText("0");
        jtaNotas.setText("");
        btnImprimir.setText("Imprimir");
        rbFacEle.setSelected(true);
        rbContado.setSelected(true);

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
        lblConseFE.setText("");
        lblClaveFE.setText("");
        listaItemFacVo = new ArrayList<>();

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
        BuscaClienteActivo buscarCliente = new BuscaClienteActivo(null, true);
        buscarCliente.setLocationRelativeTo(null);
        buscarCliente.setVisible(true);
        String valorSelec = buscarCliente.getCodCliente();
        txtCodCliente.setText(valorSelec);
        txtCodCliente.requestFocus();

        if (txtCodCliente.getText().length() > 0) {
            try {
                consultarCliente();
            } catch (SQLException ex) {
                Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void consultarCliente() throws SQLException {

        AgenciaVO agenciaVo = new AgenciaVO();
        PdvVO pdvVO = new PdvVO();

        clienteVo = new ClienteVO();
        clienteVo.setCod_cliente(Integer.valueOf(txtCodCliente.getText()));
        if (ClienteDAOImpl.consultar(clienteVo)) {

            if (clienteVo.isStatus_cli()) {
                lblNomCliente.setText(clienteVo.getNom_cliente());
                txtNomFactura.setText(clienteVo.getNom_tributa());
                txtIdFactura.setText(clienteVo.getId_tributa());
                int iTipoId = Integer.valueOf(clienteVo.getTipo_id().substring(0, 1)) - 1;
                //cbTipoId.setSelectedIndex(iTipoId);
                cbTipoId.setSelectedItem(clienteVo.getTipo_id());
                txtEmail.setText(clienteVo.getEmail_cliente());
                mPorDesctoCli = clienteVo.getPor_descto();
                mPlazoCre = clienteVo.getPlazo_credito();
                mMontoCredito = clienteVo.getMon_credito();
                rbFacEle.setSelected(true);
                rbContado.setSelected(true);
                agenciaVo.setCodagencia(clienteVo.getCod_agencia());
                pdvVO.setCodAgencia(clienteVo.getCod_agencia());
                pdvVO.setCodPdv(clienteVo.getCod_ruta());
                if (PdvDAOImpl.consultar(pdvVO)) {
                    clienteVo.setCat_pdv(pdvVO.getCatPdv());
                }

                activaCampos();
                txtIdFactura.requestFocus();
            } else {
                JOptionPane.showMessageDialog(this, "Cliente Inactivo");
            }

        } else {

            JOptionPane.showMessageDialog(this.rootPane, "Cliente NO existe");
            //inactivaCampos();
            //txtCodCliente.setText("");
            txtCodCliente.requestFocus();
        }
    }

    private void activaCampos() {

        jdcFecFactura.setEnabled(true);
        //txtCodCliente.setEnabled(true);
        rbFacEle.setEnabled(true);
        rbTiqEle.setEnabled(true);
        rbContado.setEnabled(true);
        rbCredito.setEnabled(true);
        txtPlazo.setEnabled(true);
        txtNomFactura.setEnabled(true);
        txtIdFactura.setEnabled(true);
        cbTipoId.setEnabled(true);
        txtEmail.setEnabled(true);
        txtCodArt.setEnabled(true);
        txtCantidad.setEnabled(true);
        txtDescto.setEnabled(true);
        jtaNotas.setEnabled(true);
        jtArticulos.setEnabled(true);
        btnAgregaArt.setEnabled(true);
        btnEliminaArt.setEnabled(true);
        btnEnviar.setEnabled(true);

    }

    private void consultarArticulo() throws SQLException {
        if (txtCodArt.getText().length() == 13) {
            //Busca articulo por codigo de barras

            articuloVo = new ArticuloVO();
            articuloVo.setCod_barra(txtCodArt.getText());
            if (ArticuloDAOImpl.consultaArtxCodBarra(articuloVo)) {
                lblNomArt.setText(articuloVo.getNom_lar_art());
                this.txtCodArt.setText(String.valueOf(articuloVo.getCodigo_art()));

                //consultaPrecioArt();
            } else {
                JOptionPane.showMessageDialog(null, "Codigo NO existe");
                txtCodArt.requestFocus();
            }

        } else {
            //Busca articulo por codigo consecutivo
            articuloVo = new ArticuloVO();
            articuloVo.setCodigo_art(Integer.valueOf(txtCodArt.getText()));
            if (ArticuloDAOImpl.consultaArtxCodInt(articuloVo)) {
                lblNomArt.setText(articuloVo.getNom_lar_art());

                /*if (articuloVo.getCodCabys() == null) {
                    JOptionPane.showMessageDialog(this, "Debe actualizarse el codigo Cobys del Item");
                    return;
                }*/
                //consultaPrecioArt();
            } else {
                JOptionPane.showMessageDialog(null, "Articulo NO existe");
                txtCodArt.requestFocus();
            }
        }

        if (articuloVo.getCodCabys() == null) {
            JOptionPane.showMessageDialog(this, "Item NO se puede facturar.\n Requiere actualizarse el Codigo Cabys");
            return;
        }

        consultaPrecioArt();

        if (articuloVo.getTipo_item() == 1) {
            txtPrecio.setEnabled(false);
        } else {
            txtPrecio.setEnabled(true);
        }
    }

    private void buscarArticulo() throws SQLException {

        BuscaItemxPdv buscaArticulo = new BuscaItemxPdv(null, true, clienteVo.getCat_pdv());
        buscaArticulo.setLocationRelativeTo(null);
        buscaArticulo.setVisible(true);
        String valorSelec = buscaArticulo.getCodArticulo();
        txtCodArt.setText(valorSelec);
        txtCodArt.requestFocus();

        if (txtCodArt.getText().length() > 0) {
            try {
                consultarArticulo();
            } catch (SQLException ex) {
                Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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

    private void calculaMontos() {

        // Calcula montos
        try {
            iCantidad = Integer.valueOf(txtCantidad.getText());
            //mPrecio = Double.parseDouble(lblPrecio.getText());
            mPorDescto = Integer.parseInt(txtDescto.getText());
        } catch (Exception e) {
            iCantidad = 0;
            mPorDescto = 0;
            //mPrecio=0.0;
        }

        if (mPorDesctoArt > 0) {
            if (mPorDesctoCli > mPorDesctoArt) {
                if (mPorDescto > mPorDesctoCli) {
                    JOptionPane.showMessageDialog(this, "No se permite un descuento mayor al autorizado para el cliente");
                    //Toast.makeText(this, "NO se permite un descuento mayor al autorizado para el cliente", Toast.LENGTH_SHORT).show();
                    mPorDescto = mPorDesctoCli;
                    txtDescto.setText(String.valueOf(mPorDesctoCli));
                }

            } else {
                if (mPorDescto > mPorDesctoArt) {
                    JOptionPane.showMessageDialog(this, "No se permite un descuento mayor al autorizado para el articulo");
                    //Toast.makeText(this, "NO se permite un descuento mayor al auotirzado para el artículo", Toast.LENGTH_SHORT).show();
                    mPorDescto = mPorDesctoArt;
                    txtDescto.setText(String.valueOf(mPorDesctoArt));
                }
            }
        } else {
            if (mPorDescto > 0) {
                JOptionPane.showMessageDialog(this, "El articulo NO permite descuento");
                //Toast.makeText(this, "El articulo NO permite descuentos", Toast.LENGTH_SHORT).show();
                mPorDescto = 0;
                txtDescto.setText(String.valueOf(0));
            }

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
        item.setNom_articulo(lblNomArt.getText());
        item.setCantidad(iCantidad);
        item.setPrecio(mPrecio);
        item.setPor_descto(Integer.valueOf(txtDescto.getText()));
        item.setMon_descto(mDesctoArt);
        item.setPor_impto(mIvaArt);
        item.setMon_impto(mImptoArt);
        item.setMon_subtotal(mSubTotalArt);
        item.setExento(precioVo.getExento());
        item.setCodCabys(articuloVo.getCodCabys());
        listaItemFacVo.add(item);

        Object[] fila = new Object[7];
        fila[0] = txtCodArt.getText();
        fila[1] = lblNomArt.getText();
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
        lblNomArt.setText("");
        lblSubTotArt.setText("0");
        lblDesctoArt.setText("0");
        lblIvaArt.setText("0");
        lblTotalArt.setText("0");
        txtCodArt.requestFocus();
    }

    private void enviarFactura() throws IOException, JSONException {

        String url;
        JSONObject respuesta;

        bp.abrirVentana("Generando factura...");

        clienteVo.setNom_tributa(txtNomFactura.getText());
        clienteVo.setId_tributa(txtIdFactura.getText());
        clienteVo.setEmail_cliente(txtEmail.getText());
        clienteVo.setTipo_id(cbTipoId.getSelectedItem().toString());

        JSONArray jsonArray = new JSONArray();
        for (ItemFacVO item : listaItemFacVo) {

            JSONObject jsonItemFac = new JSONObject();

            jsonItemFac.put("codigo_art", item.getCod_articulo());
            jsonItemFac.put("cantidad", item.getCantidad());
            jsonItemFac.put("precio", item.getPrecio());
            jsonItemFac.put("mon_subtotal", item.getMon_subtotal());
            jsonItemFac.put("por_descto", item.getPor_descto());
            jsonItemFac.put("mon_descto", item.getMon_descto());
            jsonItemFac.put("mon_impto", item.getMon_impto());
            jsonItemFac.put("por_impto", item.getPor_impto());
            jsonItemFac.put("exento", item.getExento());
            jsonItemFac.put("codigoCabys", item.getCodCabys());
            jsonArray.put(jsonItemFac);
        }

        JSONObject jsonFactura = new JSONObject();
        jsonFactura.put("fec_factura", formatoYMD.format(this.jdcFecFactura.getDate()));
        jsonFactura.put("cod_agencia", clienteVo.getCod_agencia());
        jsonFactura.put("cod_pdv", clienteVo.getCod_ruta());
        jsonFactura.put("cod_vendedor", Variables.mCODUSU);
        jsonFactura.put("cod_cliente", clienteVo.getCod_cliente());
        jsonFactura.put("tipo_doc", tipoDoc);
        jsonFactura.put("tipo_fac", tipoFac);
        jsonFactura.put("plazo_fac", mPlazoCre);
        jsonFactura.put("nom_tributa", clienteVo.getNom_tributa());
        jsonFactura.put("id_tributa", clienteVo.getId_tributa());
        jsonFactura.put("tipo_id", clienteVo.getTipo_id());
        jsonFactura.put("email", clienteVo.getEmail_cliente());
        jsonFactura.put("notas_fact", jtaNotas.getText());
        jsonFactura.put("sharekolbi", clienteVo.getShareKolbi());
        jsonFactura.put("sharemovistar", clienteVo.getShareMovistar());
        jsonFactura.put("latitud_bit", 0);
        jsonFactura.put("longitud_bit", 0);
        jsonFactura.put("articulos", jsonArray);

        url = Variables.URL_SERVER + "ejecucionpdv/wsAgregaFacturaJson_v2.php";

        respuesta = HttpClient.httpPOST(url, jsonFactura);
        int numFactura = respuesta.getInt("factura");
        consecutivo_fe = respuesta.optString("numeroConsecutivo");
        clave_fe = respuesta.optString("clave");
        lblClaveFE.setText(clave_fe);
        lblConseFE.setText(consecutivo_fe);

        bp.abrirVentana("Enviando factura a Hacienda...");
        url = Variables.URL_SERVER + "ejecucionpdv/wsApifecrEnvioDocumento.php?num_factura=" + numFactura;
        respuesta = HttpClient.httpGET(url);
        bp.setVisible(false);

        txtNumFactura.setText(String.valueOf(numFactura));
        JOptionPane.showMessageDialog(this, "Factura registrada");

        /*if (respuesta.getInt("CodigoRespuesta") == 1) {
            lblClaveFE.setText(respuesta.getString("Clave"));
            lblConseFE.setText(respuesta.getString("NumeroConsecutivo"));
            consecutivo_fe=respuesta.getString("NumeroConsecutivo");
            clave_fe=respuesta.getString("Clave");
        }*/
        inactivaCampos();

        btnImprimir.setEnabled(true);
        btnImprimir.requestFocus();

    }

    private void imprimeFactura(int numFactura) throws JSONException {
        /*
        //bp.abrirVentana("Imprimiendo...");
        String url = Variables.URL_SERVER + "ejecucionpdv/wsConsultaFactura_v2.php?num_factura=" + numFactura;
        JSONObject respuesta = null;

        try {
            respuesta = HttpClient.httpGET(url);
            clave_fe = respuesta.optString("clave_fe");
            consecutivo_fe = respuesta.optString("consecutivo_fe");

        } catch (IOException ex) {
            Logger.getLogger(EmiteFactura.class.getName()).log(Level.SEVERE, null, ex);
            // bp.setVisible(false);
            return;
        }

        // bp.setVisible(false);

         */
        Map parametros = new HashMap();
        if (tipoDoc.equals("01")) {
            parametros.put("nom_documento", "FACTURA ELECTRONICA");
        } else {
            parametros.put("nom_documento", "TIQUETE ELECTRONICO");
        }

        parametros.put("consecutivo_fe", consecutivo_fe);
        parametros.put("fecha_factura", jdcFecFactura.getDate());
        parametros.put("nombre_cliente", txtNomFactura.getText());
        parametros.put("id_cliente", txtIdFactura.getText());
        if (tipoFac.equals("01")) {
            parametros.put("tipo_factura", "CONTADO");
        } else {
            parametros.put("tipo_factura", "CREDITO");
        }
        parametros.put("plazo", String.valueOf(mPlazoCre));
        parametros.put("nom_vendedor", Variables.mNOMUSU);
        parametros.put("tot_exento", formatoDecimal.format(mTotExento));
        parametros.put("tot_gravado", formatoDecimal.format(mTotGravado));
        parametros.put("subtotal_fac", formatoDecimal.format(mSubTotalFac));
        parametros.put("descto_fac", formatoDecimal.format(mDesctoFac));
        parametros.put("impto_fac", formatoDecimal.format(mImptoFac));
        parametros.put("monto_fac", formatoDecimal.format(mTotalFac));
        parametros.put("notas", jtaNotas.getText());
        parametros.put("clave_numerica", clave_fe);

        JasperReport factura;

        try {
            setCursor(new Cursor(Cursor.WAIT_CURSOR));
            factura = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/factura.jasper"));

            JasperPrint jp = JasperFillManager.fillReport(factura, parametros, new JRBeanCollectionDataSource(listaItemFacVo));
            
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            
            
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setTitle("EMISION DE FACTURAS");
            jv.setVisible(true);

        } catch (JRException ex) {

            //JOptionPane.showMessageDialog(this, "Error en la generacion del reporte\n"+ex.getMessage());
            Logger.getLogger(EmiteFactura.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void consultaFactura() throws JSONException {

        bp.abrirVentana("Consultando factura...");

        int numFactura = Integer.valueOf(txtNumFactura.getText());
        String url = Variables.URL_SERVER + "ejecucionpdv/wsConsultaFactura_v2.php?num_factura=" + numFactura;
        JSONObject respuesta = null;

        try {

            respuesta = HttpClient.httpGET(url);

            bp.setVisible(false);
            if (respuesta.optInt("Consulta") == 0) {
                JOptionPane.showMessageDialog(this, "Documento NO existe");
                txtNumFactura.requestFocus();
                return;
            }

        } catch (IOException | JSONException ex) {
            Logger.getLogger(AnulaFactura.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error de conexion, revise e intente de nuevo");
            return;
        }

        bp.setVisible(false);

        try {
            java.util.Date dFecha = sqlFecha.parse(respuesta.optString("fec_factura"));
            jdcFecFactura.setDate(dFecha);
        } catch (ParseException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }

        mCodCliente = respuesta.optInt("cod_cliente");
        txtCodCliente.setText(String.valueOf(mCodCliente));
        mCodAgencia = respuesta.optInt("cod_agencia");
        mCodPdv = respuesta.optInt("cod_pdv");
        mPlazoCre = respuesta.optInt("plazo");
        mTipoId = respuesta.optString("tipo_id");
        clave_fe = respuesta.optString("clave_fe");
        lblClaveFE.setText(clave_fe);
        fecha_fe = respuesta.optString("fec_factura");
        hora_fe = respuesta.optString("hora_factura");
        lblConseFE.setText(respuesta.optString("consecutivo_fe"));
        consecutivo_fe = respuesta.optString("consecutivo_fe");
        lblNomCliente.setText(respuesta.optString("nom_cliente"));
        txtNomFactura.setText(respuesta.optString("nom_factura"));
        txtIdFactura.setText(respuesta.optString("id_factura"));
        cbTipoId.setSelectedIndex(Integer.parseInt(mTipoId.substring(0, 1)) - 1);
        mEmail = respuesta.optString("email");
        txtEmail.setText(mEmail);
        tipoFac = respuesta.optString("tipo_fac");
        tipoDoc = respuesta.optString("tipo_doc");
        if ("01".equals(tipoFac)) {
            rbContado.setSelected(true);
        } else {
            rbCredito.setSelected(true);
        }
        if ("01".equals(tipoDoc)) {
            rbFacEle.setSelected(true);
        } else {
            rbTiqEle.setSelected(true);
        }
        txtPlazo.setText(String.valueOf(mPlazoCre));
        mTotGravado = respuesta.optDouble("mon_gravado");
        mTotExento = respuesta.optDouble("mon_exento");
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
        JSONArray jsonItems = respuesta.getJSONArray("items");

        // Llena ArrayList de items
        JSONObject jsonItemFac;
        listaItemFacVo = new ArrayList();
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
            itemFacVo.setMon_impto(jsonItemFac.optInt("mon_impto"));
            itemFacVo.setMon_subtotal(jsonItemFac.optDouble("mon_subtotal"));
            itemFacVo.setExento(jsonItemFac.optInt("exento"));
            itemFacVo.setCodCabys(jsonItemFac.optString("codigoCabys"));
            listaItemFacVo.add(itemFacVo);
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
        for (ItemFacVO itemFac : listaItemFacVo) {
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
            String sTotal = formatoDecimal.format(itemFac.getMon_subtotal());
            fila[6] = sTotal;
            dtmArticulos.addRow(fila);
        }

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

        btnImprimir.setText("Reimprimir");
        if (VentanaPrincipal.jmnAnuFac.isEnabled()) {
            btnAnular.setEnabled(true);
        } else {
            btnAnular.setEnabled(false);
        }

        if (Variables.mTIPOUSU == 1 && (mCodAgencia != Variables.mAGEUSU || mCodPdv != Variables.mPDVUSU)) {
            JOptionPane.showMessageDialog(this, "Usuario NO autorizado para accesar esta factura");
            limpiaCampos();
            btnImprimir.setEnabled(false);
            //btnAnular.setEnabled(false);
            txtNumFactura.requestFocus();
            return;
        } else {
            btnImprimir.setText("Reimprimir");
            btnImprimir.setEnabled(true);
            //btnAnular.setEnabled(true);
            btnImprimir.requestFocus();

        }
        if (Variables.mTIPOUSU <= 3 && mCodAgencia != Variables.mAGEUSU) {
            JOptionPane.showMessageDialog(this, "Usuario NO autorizado para accesar esta factura");
            limpiaCampos();
            btnImprimir.setEnabled(false);
            //btnAnular.setEnabled(false);
            txtNumFactura.requestFocus();
        } else {
            btnImprimir.setText("Reimprimir");
            btnImprimir.setEnabled(true);
            btnImprimir.requestFocus();
        }

    }

    private void anulaFactura() throws IOException, JSONException {

        bp.abrirVentana("Generando Nota de Credito...");

        JSONObject respuesta;

        JSONArray jsonArray = new JSONArray();
        for (ItemFacVO item : listaItemFacVo) {

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
        jsonNota.put("email", mEmail);
        jsonNota.put("tipo_id", mTipoId);
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
        bp.abrirVentana("Anulando factura...");

        url = Variables.URL_SERVER + "ejecucionpdv/wsAnulaFactura_v2.php?num_factura=" + Integer.valueOf(txtNumFactura.getText());

        respuesta = HttpClient.httpGET(url);

        bp.setVisible(false);

        JOptionPane.showMessageDialog(this, respuesta.opt("Mensaje"));
        limpiaCampos();
        inactivaCampos();
        txtNumFactura.requestFocus();
    }
}
