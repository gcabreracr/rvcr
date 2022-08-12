package forms;

import java.io.IOException;
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
import metodos.VerificaEmail;
import modelo.HttpClient;
import modelo.VO.ItemFacVO;
import modelo.Validar;
import modelo.Variables;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReenvioFactura extends javax.swing.JInternalFrame {

    DecimalFormat formatoDecimal = new DecimalFormat("###,###,##0.00");
    DecimalFormat formatoEntero = new DecimalFormat("###,###,##0");
    SimpleDateFormat sqlFecha = new SimpleDateFormat("yyyy-MM-dd");
    DefaultTableModel dtmArticulos;
    ItemFacVO itemFacVo;
    ArrayList<ItemFacVO> listaItemFac;
    Validar valida;
    BarraProgreso bp;
    double monGraFac, monExeFac, subTotFac, monDesctoFac, monIvaFac, monTotFac;
    double mTotSerGra, mTotSerExe, mTotMerGra, mTotMerExe, mTotIVADev, mTotOtrCar;

    public ReenvioFactura() {
        initComponents();

        valida = new Validar();
        bp = new BarraProgreso();

        valida.soloNumeros(txtNumFac);
        valida.limitarCaracteres(txtNumFac, 10);

        limpiarCampos();
        txtIdFactura.setEnabled(false);
        txtEmail.setEnabled(false);
        cbTipoId.setEnabled(false);
        btnReenvia.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtArticulos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNumFac = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblNomCliente = new javax.swing.JLabel();
        lblNomFactura = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblConseFE = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnReenvia = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jdcFecFactura = new com.toedter.calendar.JDateChooser();
        txtIdFactura = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cbTipoId = new javax.swing.JComboBox<String>();
        jLabel15 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMensaje = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        lblMonGravado = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblMonExento = new javax.swing.JLabel();
        lblSubTotal = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblMonDescto = new javax.swing.JLabel();
        lblMonIva = new javax.swing.JLabel();
        lblMonTotal = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaNotas = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setTitle("Reenvio Factura Hacienda");
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

        jtArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripcion", "Cantidad", "Precio", "Descto", "Monto"
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
        jtArticulos.setEnabled(false);
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
            jtArticulos.getColumnModel().getColumn(4).setPreferredWidth(10);
            jtArticulos.getColumnModel().getColumn(5).setResizable(false);
            jtArticulos.getColumnModel().getColumn(5).setPreferredWidth(25);
        }

        jLabel1.setText("Consecutivo Interno");

        txtNumFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumFacActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre Comercial");

        lblNomCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblNomFactura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel2.setText("Nombre Factura");

        jLabel4.setText("Numero ID");

        lblConseFE.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel9.setText("Consecutivo FE");

        btnReenvia.setText("Reenviar");
        btnReenvia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReenviaActionPerformed(evt);
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

        jLabel13.setText("Fecha: ");

        jdcFecFactura.setEnabled(false);

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

        jLabel14.setText("Tipo ID");

        cbTipoId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1-Fisica", "2-Juridica", "3-DIMEX", "4-NITE" }));

        jLabel15.setText("Email");

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

        jLabel5.setText("Mensaje Hacienda");

        txtMensaje.setColumns(20);
        txtMensaje.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        txtMensaje.setLineWrap(true);
        txtMensaje.setRows(5);
        txtMensaje.setWrapStyleWord(true);
        txtMensaje.setEnabled(false);
        jScrollPane3.setViewportView(txtMensaje);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblNomCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                                    .addComponent(lblNomFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtIdFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel14)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbTipoId, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblConseFE, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtNumFac, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(172, 172, 172)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jdcFecFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnReenvia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15)
                                .addComponent(jLabel4)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3)))))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdcFecFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(txtNumFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel9))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblConseFE, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(lblNomCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNomFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel14)
                            .addComponent(cbTipoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnReenvia, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        lblMonGravado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMonGravado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel8.setText("Gravado");

        lblMonExento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMonExento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblSubTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubTotal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel7.setText("Exento");

        jLabel6.setText("Sub-Total");

        lblMonDescto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMonDescto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblMonIva.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMonIva.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblMonTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMonTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMonTotal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel10.setText("Descuento");

        jLabel11.setText("Impuesto");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Total Factura");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMonGravado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMonExento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMonDescto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMonIva, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMonTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(lblMonGravado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel8))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblMonExento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMonDescto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMonIva, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMonTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(16, 16, 16))
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:

        limpiarCampos();
        btnReenvia.setEnabled(false);
        txtNumFac.requestFocus();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Variables.frmReenvioFac = null;
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtNumFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumFacActionPerformed

        try {
            consultaFactura();
        } catch (JSONException | IOException ex) {
            Logger.getLogger(ReenvioFactura.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al consultar la factura");

        }


    }//GEN-LAST:event_txtNumFacActionPerformed

    private void txtIdFacturaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFacturaFocusGained
        // TODO add your handling code here:
        txtIdFactura.selectAll();
    }//GEN-LAST:event_txtIdFacturaFocusGained

    private void txtIdFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdFacturaActionPerformed
        // TODO add your handling code here:
        txtEmail.requestFocus();
    }//GEN-LAST:event_txtIdFacturaActionPerformed

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        // TODO add your handling code here:
        txtEmail.selectAll();
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
        btnReenvia.requestFocus();
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnReenviaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReenviaActionPerformed

        if (txtEmail.getText().length() > 0) {
            if (!VerificaEmail.verificar(txtEmail.getText())) {
                JOptionPane.showMessageDialog(this, "Correo Electronico Incorrecto");
                txtEmail.requestFocus();
                return;
            }
        }

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

        try {
            reenviaFactura();
        } catch (JSONException ex) {
            Logger.getLogger(ReenvioFactura.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnReenviaActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        Variables.frmReenvioFac = null;
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnReenvia;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbTipoId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.calendar.JDateChooser jdcFecFactura;
    private javax.swing.JTable jtArticulos;
    private javax.swing.JTextArea jtaNotas;
    private javax.swing.JLabel lblConseFE;
    private javax.swing.JLabel lblMonDescto;
    private javax.swing.JLabel lblMonExento;
    private javax.swing.JLabel lblMonGravado;
    private javax.swing.JLabel lblMonIva;
    private javax.swing.JLabel lblMonTotal;
    private javax.swing.JLabel lblNomCliente;
    private javax.swing.JLabel lblNomFactura;
    private javax.swing.JLabel lblSubTotal;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIdFactura;
    private javax.swing.JTextArea txtMensaje;
    private javax.swing.JTextField txtNumFac;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        txtNumFac.setText("");
        lblNomCliente.setText("");
        lblNomFactura.setText("");
        lblConseFE.setText("");
        txtIdFactura.setText("");
        cbTipoId.setSelectedIndex(0);
        jdcFecFactura.setDate(null);
        txtMensaje.setText("");
        txtEmail.setText("");
        lblMonGravado.setText("0.00");
        lblMonExento.setText("0.00");
        lblSubTotal.setText("0.00");
        lblMonDescto.setText("0.00");
        lblMonIva.setText("0.00");
        lblMonTotal.setText("0.00");
        jtaNotas.setText("");
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

        jtArticulos.setEnabled(false);
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

    private void consultaFactura() throws JSONException, IOException {

        bp.abrirVentana("Consultando factura...");

        int numFactura = Integer.valueOf(txtNumFac.getText());
        String url = Variables.URL_SERVER + "ejecucionpdv/wsConsultaFactura_v2.php?num_factura=" + numFactura;
        //JSONObject respuesta = null;

        JSONObject respuesta = HttpClient.httpGET(url);

        bp.setVisible(false);

        if (respuesta.optInt("Consulta") == 0) {
            JOptionPane.showMessageDialog(this, "Documento NO existe");
            txtNumFac.requestFocus();
            return;
        }

        try {
            java.util.Date dFecha = sqlFecha.parse(respuesta.optString("fec_factura"));
            jdcFecFactura.setDate(dFecha);

        } catch (ParseException ex) {
            Logger.getLogger(Clientes.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        lblConseFE.setText(respuesta.optString("consecutivo_fe"));
        lblNomCliente.setText(respuesta.optString("nom_cliente"));
        lblNomFactura.setText(respuesta.optString("nom_factura"));
        txtIdFactura.setText(respuesta.optString("id_factura"));
        cbTipoId.setSelectedItem(respuesta.optString("tipo_id"));
        txtEmail.setText(respuesta.optString("email"));
        txtMensaje.setText(respuesta.optString("MensajeRespuesta"));
        monGraFac = respuesta.optDouble("mon_gravado");
        monExeFac = respuesta.optDouble("mon_exento");
        subTotFac = respuesta.optDouble("mon_subtotal");
        monIvaFac = respuesta.optDouble("mon_impto");
        monDesctoFac = respuesta.optDouble("mon_descto");
        monTotFac = subTotFac - monDesctoFac + monIvaFac;
        lblMonExento.setText(formatoDecimal.format(monExeFac));
        lblMonGravado.setText(formatoDecimal.format(monGraFac));
        lblSubTotal.setText(formatoDecimal.format(subTotFac));
        lblMonDescto.setText(formatoDecimal.format(monDesctoFac));
        lblMonIva.setText(formatoDecimal.format(monIvaFac));
        lblMonTotal.setText(formatoDecimal.format(monTotFac));
        jtaNotas.setText(respuesta.optString("notas"));
        JSONArray jsonItems = respuesta.getJSONArray("items");

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
            itemFacVo.setMon_impto(jsonItemFac.optInt("mon_impto"));
            itemFacVo.setMon_subtotal(jsonItemFac.optDouble("mon_subtotal"));
            itemFacVo.setCodCabys(jsonItemFac.optString("codigoCabys"));
            itemFacVo.setExento(jsonItemFac.optInt("exento"));
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

        if (respuesta.optInt("CodigoEstado") <= 4) {
            JOptionPane.showMessageDialog(this, "Estado de Factura NO permite el reenvio");
            limpiarCampos();
            txtNumFac.requestFocus();
            return;
        }
        if (Variables.mTIPOUSU == 1 && (respuesta.getInt("cod_agencia") != Variables.mAGEUSU && respuesta.getInt("cod_pdv") != Variables.mPDVUSU)) {
            JOptionPane.showMessageDialog(this, "Usuario NO autorizado para reenviar este documednto");
            limpiarCampos();
            txtNumFac.requestFocus();
            return;
        }
        if ((Variables.mTIPOUSU == 2 || Variables.mTIPOUSU == 3) && respuesta.getInt("cod_agencia") != Variables.mAGEUSU) {
            JOptionPane.showMessageDialog(this, "Usuario NO autorizado para reenviar este documednto");
            limpiarCampos();
            txtNumFac.requestFocus();
            return;
        }

        txtEmail.setEnabled(true);
        txtIdFactura.setEnabled(true);
        cbTipoId.setEnabled(true);
        btnReenvia.setEnabled(true);
        btnReenvia.requestFocus();

        bp.setVisible(false);

    }

    private void reenviaFactura() throws JSONException {

        bp.abrirVentana("Reenviando factura...");

        JSONObject jsonFactura = new JSONObject();

        jsonFactura.put("num_factura", Integer.valueOf(txtNumFac.getText()));
        jsonFactura.put("id_tributa", txtIdFactura.getText());
        jsonFactura.put("tipo_id", cbTipoId.getSelectedItem().toString());
        jsonFactura.put("email", txtEmail.getText());

        String url = Variables.URL_SERVER + "ejecucionpdv/wsReenvioFactura_v2.php";

        try {
            //JSONObject respuestaPost =
            HttpClient.httpPOST(url, jsonFactura);
        } catch (IOException ex) {
            Logger.getLogger(ReenvioFactura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(ReenvioFactura.class.getName()).log(Level.SEVERE, null, ex);
        }

        bp.setVisible(false);

        int numFactura = Integer.valueOf(txtNumFac.getText());
        url = Variables.URL_SERVER + "ejecucionpdv/wsApifecrReenvioFactura_v2.php?num_factura=" + numFactura;

        JSONObject respuesta = null;
        try {
            respuesta = HttpClient.httpGET(url);
        } catch (IOException ex) {
            Logger.getLogger(ReenvioFactura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(ReenvioFactura.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (respuesta.optInt("CodigoRespuesta") == 1) {
            JOptionPane.showMessageDialog(this, "Factura Reenviada\nNuevo Consecutivo: " + respuesta.optString("NumeroConsecutivo"));

        } else {
            JOptionPane.showMessageDialog(this, "Error al reenviar la factura el documento a Hacienda");

        }
        limpiarCampos();
        txtNumFac.requestFocus();

    }

}
