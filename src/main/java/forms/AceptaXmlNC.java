
package forms;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import metodos.ConvertirJsonArray;
import modelo.HttpClient;
import modelo.VO.ItemFacVO;
import modelo.DAO.DocRecibidoDAOImpl;
import modelo.Variables;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.json.XML;

public class AceptaXmlNC extends javax.swing.JInternalFrame {

    DefaultTableModel dtmItems;
    JSONObject jsonXml;
    JSONArray jaItems;
    ArrayList<ItemFacVO> listaItems;
    BarraProgreso bp;

    DecimalFormat formatoDecimal = new DecimalFormat("###,###,##0.00");
    DecimalFormat formatoEntero = new DecimalFormat("###,###,##0");

    String clave_fe, fechaEmision, idEmisor, detalleMensaje, codActividad, condicImpto, idReceptor, tipoIdReceptor, tipoIdEmisor, emailEmisor;
    int mensaje;
    double monTotImpto, monImptoAcre, monGastoAcre, totalFact;
    JSONObject respuesta;

    public AceptaXmlNC() {
        initComponents();
        bp=new BarraProgreso();
        

        limpiaCampos();
        btnBuscar.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblFechaDoc = new javax.swing.JLabel();
        lblIdEmisor = new javax.swing.JLabel();
        lblNomEmisor = new javax.swing.JLabel();
        lblClaveDoc = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtItems = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblArchivo = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblNomReceptor = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblIdReceptor = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblTotalImpto = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbCondicion = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtMonImptoAcre = new javax.swing.JTextField();
        txtMonGastoApli = new javax.swing.JTextField();
        txtCodActividad = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        lblTotalFactura = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblSubTotFac = new javax.swing.JLabel();
        lblMoneda = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cbTipoMensaje = new javax.swing.JComboBox();
        txtDetalle = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setClosable(true);
        setTitle("Aceptación / Rechazo Notas de Credito");
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

        jLabel3.setText("Fecha");

        jLabel1.setText("Nombre Emisor");

        jLabel2.setText("ID Emisor");

        jLabel4.setText("Clave FE");

        lblFechaDoc.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblFechaDoc.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lblIdEmisor.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblIdEmisor.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lblNomEmisor.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblNomEmisor.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lblClaveDoc.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblClaveDoc.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jtItems.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jtItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Descripcion", "Cantidad", "Sub-Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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
            jtItems.getColumnModel().getColumn(0).setPreferredWidth(250);
            jtItems.getColumnModel().getColumn(1).setResizable(false);
            jtItems.getColumnModel().getColumn(1).setPreferredWidth(10);
            jtItems.getColumnModel().getColumn(2).setResizable(false);
            jtItems.getColumnModel().getColumn(2).setPreferredWidth(25);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 179, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFechaDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNomEmisor, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblClaveDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdEmisor, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3)
                            .addComponent(lblFechaDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1))
                    .addComponent(lblNomEmisor, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblIdEmisor, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblClaveDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jLabel5.setText("Ubicacion XML");

        lblArchivo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblArchivo.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        btnBuscar.setText("Buscar");
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel6.setText("Nombre Receptor");

        lblNomReceptor.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblNomReceptor.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel7.setText("ID Receptor");

        lblIdReceptor.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblIdReceptor.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel8.setText("Actividad Economica");

        jLabel9.setText("Monto Impuesto");

        lblTotalImpto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalImpto.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblTotalImpto.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        lblTotalImpto.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel10.setText("Condicion Impuesto");

        cbCondicion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01-Credito IVA", "02-Credito Parcial IVA", "03-Bienes Capital", "04-Gasto Corriente", "05-Proporcionalidad" }));
        cbCondicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCondicionActionPerformed(evt);
            }
        });

        jLabel11.setText("Monto Impuesto Acreditar");

        jLabel12.setText("Monto Total Gasto Aplicable");

        txtMonImptoAcre.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMonImptoAcre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMonImptoAcreFocusGained(evt);
            }
        });
        txtMonImptoAcre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMonImptoAcreActionPerformed(evt);
            }
        });

        txtMonGastoApli.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMonGastoApli.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMonGastoApliFocusGained(evt);
            }
        });
        txtMonGastoApli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMonGastoApliActionPerformed(evt);
            }
        });

        txtCodActividad.setText("642005");
        txtCodActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodActividadActionPerformed(evt);
            }
        });

        jLabel13.setText("Total");

        lblTotalFactura.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalFactura.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblTotalFactura.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        lblTotalFactura.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel15.setText("Sub-Total");

        lblSubTotFac.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubTotFac.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblSubTotFac.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        lblSubTotFac.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lblMoneda.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblMoneda.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        lblMoneda.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel14.setText("Moneda");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNomReceptor, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addComponent(jLabel9)
                            .addComponent(jLabel13))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblIdReceptor, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTotalFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTotalImpto, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSubTotFac, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(87, 87, 87)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbCondicion, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMonGastoApli, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMonImptoAcre, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblIdReceptor, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomReceptor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtCodActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(cbCondicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(lblMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSubTotFac, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtMonImptoAcre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMonGastoApli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(19, 19, 19))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTotalImpto, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTotalFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addContainerGap())))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mensaje de respuesta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        cbTipoMensaje.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1-Aceptado", "2-Aceptacion Parcial", "3-Rechazado" }));
        cbTipoMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoMensajeActionPerformed(evt);
            }
        });

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbTipoMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDetalle)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTipoMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviar)
                    .addComponent(btnSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnBuscar))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        
        Variables.frmAceptaXmlNC=null;
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarArchivo();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cbTipoMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoMensajeActionPerformed
        if (cbTipoMensaje.getSelectedIndex() == 2) {
            txtDetalle.requestFocus();
        } else {
            btnEnviar.requestFocus();
        }


    }//GEN-LAST:event_cbTipoMensajeActionPerformed

    private void txtMonImptoAcreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMonImptoAcreFocusGained
        // TODO add your handling code here:
        txtMonImptoAcre.selectAll();
    }//GEN-LAST:event_txtMonImptoAcreFocusGained

    private void txtMonGastoApliFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMonGastoApliFocusGained
        // TODO add your handling code here:
        txtMonGastoApli.selectAll();
    }//GEN-LAST:event_txtMonGastoApliFocusGained

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed

       
        try {
            enviarMensaje();
        } catch (IOException ex) {
            Logger.getLogger(AceptaXmlNC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(AceptaXmlNC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void cbCondicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCondicionActionPerformed

        switch (cbCondicion.getSelectedIndex()) {
            case 0:
                txtMonImptoAcre.setText(formatoDecimal.format(monTotImpto));
                txtMonGastoApli.setText(formatoDecimal.format(0));
                txtDetalle.requestFocus();
                break;
            case 1:
                txtMonImptoAcre.setText(formatoDecimal.format(monTotImpto));
                txtMonGastoApli.setText(formatoDecimal.format(0));
                txtMonImptoAcre.requestFocus();
                break;
            case 2:
                txtMonImptoAcre.setText(formatoDecimal.format(0));
                txtMonGastoApli.setText(formatoDecimal.format(0));
                txtDetalle.requestFocus();
                break;
            case 3:
                txtMonImptoAcre.setText(formatoDecimal.format(0));
                txtMonGastoApli.setText(formatoDecimal.format(monTotImpto));
                txtMonGastoApli.requestFocus();
                break;
            case 4:
                txtMonImptoAcre.setText(formatoDecimal.format(0));
                txtMonGastoApli.setText(formatoDecimal.format(0));
                txtDetalle.requestFocus();
                break;
        }


    }//GEN-LAST:event_cbCondicionActionPerformed

    private void txtMonImptoAcreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMonImptoAcreActionPerformed

        monImptoAcre = Double.valueOf(txtMonImptoAcre.getText());
        txtMonImptoAcre.setText(formatoDecimal.format(monImptoAcre));
        txtDetalle.requestFocus();
    }//GEN-LAST:event_txtMonImptoAcreActionPerformed

    private void txtMonGastoApliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMonGastoApliActionPerformed
        monGastoAcre = Double.valueOf(txtMonGastoApli.getText());
        txtMonGastoApli.setText(formatoDecimal.format(monGastoAcre));
        txtDetalle.requestFocus();
    }//GEN-LAST:event_txtMonGastoApliActionPerformed

    private void txtCodActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodActividadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodActividadActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        Variables.frmAceptaXmlNC = null;
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cbCondicion;
    private javax.swing.JComboBox cbTipoMensaje;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtItems;
    private javax.swing.JLabel lblArchivo;
    private javax.swing.JLabel lblClaveDoc;
    private javax.swing.JLabel lblFechaDoc;
    private javax.swing.JLabel lblIdEmisor;
    private javax.swing.JLabel lblIdReceptor;
    private javax.swing.JLabel lblMoneda;
    private javax.swing.JLabel lblNomEmisor;
    private javax.swing.JLabel lblNomReceptor;
    private javax.swing.JLabel lblSubTotFac;
    private javax.swing.JLabel lblTotalFactura;
    private javax.swing.JLabel lblTotalImpto;
    private javax.swing.JTextField txtCodActividad;
    private javax.swing.JTextField txtDetalle;
    private javax.swing.JTextField txtMonGastoApli;
    private javax.swing.JTextField txtMonImptoAcre;
    // End of variables declaration//GEN-END:variables

    private void limpiaCampos() {
        lblArchivo.setText("");
        lblFechaDoc.setText("");
        lblNomEmisor.setText("");
        lblIdEmisor.setText("");
        lblClaveDoc.setText("");
        lblNomReceptor.setText("");
        lblIdReceptor.setText("");
        cbCondicion.setSelectedIndex(0);
        lblTotalFactura.setText("0.00");
        lblTotalImpto.setText("0.00");
        txtMonImptoAcre.setText("0.00");
        txtMonGastoApli.setText("0.00");
        txtDetalle.setText("");
        cbTipoMensaje.setSelectedIndex(0);

        dtmItems = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }

        };

        dtmItems.addColumn("Descripcion");
        dtmItems.addColumn("Cantidad");
        dtmItems.addColumn("Precio");
        dtmItems.addColumn("Monto");
        jtItems.setModel(dtmItems);

        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.RIGHT);

        jScrollPane1.setViewportView(jtItems);
        if (jtItems.getColumnModel().getColumnCount() > 0) {
            jtItems.getColumnModel().getColumn(0).setResizable(false);
            jtItems.getColumnModel().getColumn(0).setPreferredWidth(250);
            jtItems.getColumnModel().getColumn(1).setResizable(false);
            jtItems.getColumnModel().getColumn(1).setPreferredWidth(10);
            jtItems.getColumnModel().getColumn(1).setCellRenderer(dtcr);
            jtItems.getColumnModel().getColumn(2).setResizable(false);
            jtItems.getColumnModel().getColumn(2).setPreferredWidth(15);
            jtItems.getColumnModel().getColumn(2).setCellRenderer(dtcr);
            jtItems.getColumnModel().getColumn(3).setResizable(false);
            jtItems.getColumnModel().getColumn(3).setPreferredWidth(25);
            jtItems.getColumnModel().getColumn(3).setCellRenderer(dtcr);

        }

    }

    private void buscarArchivo() {

        JFileChooser files = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos XML", "xml");
        files.setFileFilter(filtro);
        files.showOpenDialog(this);

        File archivoxml = files.getSelectedFile();
        lblArchivo.setText(archivoxml.getPath());
        String xmlstr = null;
        try {
            //xmlstr= leeArchivo(archivoxml.getAbsolutePath());
            xmlstr = leeArchivo(archivoxml.getPath());
        } catch (IOException ex) {
            Logger.getLogger(AceptaXmlNC.class.getName()).log(Level.SEVERE, null, ex);
        }
        jsonXml = new JSONObject();
        jaItems = new JSONArray();
        listaItems = new ArrayList();
        try {
            jsonXml = XML.toJSONObject(xmlstr).optJSONObject("NotaCreditoElectronica");
            //jsonXml = XML.toJSONObject(xmlstr);
            lblFechaDoc.setText(jsonXml.optString("FechaEmision"));
            lblNomEmisor.setText(jsonXml.optJSONObject("Emisor").optString("Nombre"));
            emailEmisor = jsonXml.optJSONObject("Emisor").optString("CorreoElectronico");
            lblIdEmisor.setText(jsonXml.optJSONObject("Emisor").optJSONObject("Identificacion").optString("Numero"));
            tipoIdEmisor = jsonXml.optJSONObject("Emisor").optJSONObject("Identificacion").optString("Tipo");
            idReceptor = jsonXml.optJSONObject("Receptor").optJSONObject("Identificacion").optString("Numero");
            tipoIdReceptor = jsonXml.optJSONObject("Receptor").optJSONObject("Identificacion").optString("Tipo");
            lblIdReceptor.setText(jsonXml.optJSONObject("Receptor").optJSONObject("Identificacion").optString("Numero"));
            lblClaveDoc.setText(jsonXml.optString("Clave"));
            lblNomReceptor.setText(jsonXml.optJSONObject("Receptor").optString("Nombre"));
            monTotImpto = jsonXml.optJSONObject("ResumenFactura").optDouble("TotalImpuesto",0);
            lblTotalImpto.setText(formatoDecimal.format(monTotImpto));
            Double subTotFac = jsonXml.optJSONObject("ResumenFactura").optDouble("TotalVentaNeta");
            lblSubTotFac.setText(formatoDecimal.format(subTotFac));            
            totalFact = jsonXml.optJSONObject("ResumenFactura").optDouble("TotalComprobante");
            lblTotalFactura.setText(formatoDecimal.format(totalFact));
            if(jsonXml.optJSONObject("ResumenFactura").optJSONObject("CodigoTipoMoneda")!=null){
                lblMoneda.setText(jsonXml.optJSONObject("ResumenFactura").optJSONObject("CodigoTipoMoneda").optString("CodigoMoneda", "CRC"));     
            }else{
                lblMoneda.setText("CRC");
            }
            
            JSONObject detalle= ConvertirJsonArray.wrapFieldInArray(jsonXml.getJSONObject("DetalleServicio"),"LineaDetalle");
            jaItems = detalle.optJSONArray("LineaDetalle");
            
            //JSONArray lineasDetalle= new JSONArray().put(new JSONObject(detalle.toString()));
            
            //jaItems = detalle.optJSONArray("LineaDetalle");
           

            //JOptionPane.showMessageDialog(this, jaItems.toString(4));
            llenarTabla();
            try {
                if (DocRecibidoDAOImpl.consultaClave(lblClaveDoc.getText())) {
                    JOptionPane.showMessageDialog(this, "Archivo YA fue recibido");
                    limpiaCampos();
                    btnBuscar.requestFocus();

                } else {
                    txtMonImptoAcre.setText(formatoDecimal.format(monTotImpto));
                    txtMonGastoApli.setText(formatoDecimal.format(0));
                    cbCondicion.requestFocus();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AceptaXmlNC.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (JSONException e) {
            JOptionPane.showMessageDialog(this, "Error con archivo XML " + e.toString());
            limpiaCampos();
            btnBuscar.requestFocus();
        }

    }

    public static String leeArchivo(String file) throws IOException {
        
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(file), StandardCharsets.UTF_8)) {

            String line = null;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        return content.toString();
    }

    private void enviarMensaje() throws IOException, JSONException {

        bp.abrirVentana("Enviando mensaje a Hacienda...");
       

        monImptoAcre = Double.valueOf(txtMonImptoAcre.getText().replace(",", ""));
        monGastoAcre = Double.valueOf(txtMonGastoApli.getText().replace(",", ""));

        JSONObject jsonMensaje = new JSONObject();
        jsonMensaje.put("cod_agencia", Variables.mAGEUSU);
        jsonMensaje.put("cod_pdv", Variables.mPDVUSU);
        jsonMensaje.put("clave_fe", lblClaveDoc.getText());
        jsonMensaje.put("nomEmisor", lblNomEmisor.getText());
        jsonMensaje.put("emailEmisor", emailEmisor);
        jsonMensaje.put("idEmisor", lblIdEmisor.getText());
        jsonMensaje.put("tipoIdEmisor", tipoIdEmisor);
        jsonMensaje.put("fechaEmision", lblFechaDoc.getText());
        jsonMensaje.put("mensaje", cbTipoMensaje.getSelectedItem().toString());
        jsonMensaje.put("detalleMensaje", txtDetalle.getText());
        jsonMensaje.put("monTotImpto", monTotImpto);
        jsonMensaje.put("codActividad", txtCodActividad.getText());
        jsonMensaje.put("condiImpto", cbCondicion.getSelectedItem().toString());
        jsonMensaje.put("monImptoAcre", monImptoAcre);
        jsonMensaje.put("monGastoAcre", monGastoAcre);
        jsonMensaje.put("totFact", totalFact);
        jsonMensaje.put("idReceptor", idReceptor);
        jsonMensaje.put("moneda", lblMoneda.getText());

        String url = Variables.URL_SERVER + "ejecucionpdv/wsApifecrEnvioMensaje.php";

        respuesta = HttpClient.httpPOST(url, jsonMensaje);

        bp.setVisible(false);

        JOptionPane.showMessageDialog(this, "Mensaje Enviado\nNumero Consecutivo: " + respuesta.optString("NumeroConsecutivo"));

        limpiaCampos();
        btnBuscar.requestFocus();

    }

    private void llenarTabla() throws JSONException {

     

        dtmItems = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }

        };

        dtmItems.addColumn("Descripcion");
        dtmItems.addColumn("Cantidad");
        dtmItems.addColumn("Sub-Total");
        jtItems.setModel(dtmItems);

        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.RIGHT);

        jScrollPane1.setViewportView(jtItems);
        if (jtItems.getColumnModel().getColumnCount() > 0) {
            jtItems.getColumnModel().getColumn(0).setResizable(false);
            jtItems.getColumnModel().getColumn(0).setPreferredWidth(250);
            jtItems.getColumnModel().getColumn(1).setResizable(false);
            jtItems.getColumnModel().getColumn(1).setPreferredWidth(20);
            jtItems.getColumnModel().getColumn(1).setCellRenderer(dtcr);           
            jtItems.getColumnModel().getColumn(2).setResizable(false);
            jtItems.getColumnModel().getColumn(2).setPreferredWidth(25);
            jtItems.getColumnModel().getColumn(2).setCellRenderer(dtcr);

        }
        
        JSONObject jobjArray;
        Object[] fila = new Object[3];
        for (int i = 0; i < jaItems.length(); i++) {
            
           jobjArray=jaItems.getJSONObject(i);
            
            fila[0] = jobjArray.optString("Detalle");
            //fila[0] = item.getNom_articulo();
            //item.setCantidad(jobjArray.optInt("Cantidad"));
            String sCan = formatoEntero.format(jobjArray.optInt("Cantidad"));
            fila[1] = sCan;
            //item.setPrecio(jobjArray.optDouble("Precio"));
            //String sPrecio = formatoDecimal.format(jobjArray.optDouble("PrecioUnitario"));
            //fila[2] = sPrecio;
            //item.setMon_subtotal(jobjArray.optDouble("MontoTotal"));
            String sMonto = formatoDecimal.format(jobjArray.optDouble("SubTotal"));
            fila[2] = sMonto;
            dtmItems.addRow(fila);
            //listaItems.add(item);
        }

    }
}
