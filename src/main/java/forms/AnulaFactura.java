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
import modelo.HttpClient;
import modelo.VO.ItemFacVO;
import modelo.Validar;
import modelo.Variables;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AnulaFactura extends javax.swing.JInternalFrame {

    DecimalFormat formatoDecimal = new DecimalFormat("###,###,##0.00");
    DecimalFormat formatoEntero = new DecimalFormat("###,###,##0");
    SimpleDateFormat sqlFecha = new SimpleDateFormat("yyyy-MM-dd");
    DefaultTableModel dtmArticulos;
    ItemFacVO itemFacVo;
    ArrayList<ItemFacVO> listaItemFac;
    Validar valida;
    BarraProgreso bp;
    int mCodCliente, mCodAgencia, mCodPdv, mPlazoCre;
    String mEmail, consecutivo_fe, clave_fe, fecha_fe, hora_fe, mTipoId;
    double monGraFac, monExeFac, subTotFac, monDesctoFac, monIvaFac, monTotFac;
    double mTotSerGra, mTotSerExe, mTotMerGra, mTotMerExe, mTotIVADev, mTotOtrCar;

    public AnulaFactura() {
        initComponents();

        valida = new Validar();
        bp = new BarraProgreso();

        valida.soloNumeros(txtNumFac);
        valida.limitarCaracteres(txtNumFac, 10);

        limpiarCampos();
        btnAnular.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNumFac = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblNomCliente = new javax.swing.JLabel();
        lblNomFactura = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblIdFactura = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblConseFE = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnAnular = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jdcFecFactura = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtArticulos = new javax.swing.JTable();
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
        setMaximizable(true);
        setTitle("Anulacion de Facturas");
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

        jLabel1.setText("Consecutivo Interno");

        txtNumFac.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNumFacFocusGained(evt);
            }
        });
        txtNumFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumFacActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre Comercial");

        lblNomCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblNomFactura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel2.setText("Nombre Factura");

        lblIdFactura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel4.setText("Numero ID");

        lblConseFE.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel9.setText("Consecutivo FE");

        btnAnular.setText("Anular");
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblIdFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNomCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                            .addComponent(lblNomFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnular, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblIdFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

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
        btnAnular.setEnabled(false);
        txtNumFac.requestFocus();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed

        Variables.frmAnuFac = null;
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtNumFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumFacActionPerformed

        try {
            consultaFactura();
        } catch (JSONException ex) {
            Logger.getLogger(AnulaFactura.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_txtNumFacActionPerformed

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

        try {
            anulaFactura();
        } catch (IOException | JSONException ex) {
            Logger.getLogger(AnulaFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAnularActionPerformed

    private void txtNumFacFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumFacFocusGained
        // TODO add your handling code here:
        txtNumFac.selectAll();
    }//GEN-LAST:event_txtNumFacFocusGained

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing

        Variables.frmAnuFac = null;
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcFecFactura;
    private javax.swing.JTable jtArticulos;
    private javax.swing.JTextArea jtaNotas;
    private javax.swing.JLabel lblConseFE;
    private javax.swing.JLabel lblIdFactura;
    private javax.swing.JLabel lblMonDescto;
    private javax.swing.JLabel lblMonExento;
    private javax.swing.JLabel lblMonGravado;
    private javax.swing.JLabel lblMonIva;
    private javax.swing.JLabel lblMonTotal;
    private javax.swing.JLabel lblNomCliente;
    private javax.swing.JLabel lblNomFactura;
    private javax.swing.JLabel lblSubTotal;
    private javax.swing.JTextField txtNumFac;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {

        lblNomCliente.setText("");
        lblConseFE.setText("");
        lblNomFactura.setText("");
        lblIdFactura.setText("");
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

    private void consultaFactura() throws JSONException {

        bp.abrirVentana("Consultando factura...");
        //bp.setVisible(true);

        int numFactura = Integer.valueOf(txtNumFac.getText());
        String url = Variables.URL_SERVER + "ejecucionpdv/wsConsultaFactura_v2.php?num_factura=" + numFactura;
        JSONObject respuesta = null;

        try {
            respuesta = HttpClient.httpGET(url);

        } catch (IOException ex) {
            Logger.getLogger(AnulaFactura.class.getName()).log(Level.SEVERE, null, ex);

        } catch (JSONException ex) {
            Logger.getLogger(AnulaFactura.class.getName()).log(Level.SEVERE, null, ex);
        }

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
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }

        mCodCliente = respuesta.optInt("cod_cliente");
        mCodAgencia = respuesta.optInt("cod_agencia");
        mCodPdv = respuesta.optInt("cod_pdv");
        mPlazoCre = respuesta.optInt("plazo");
        mTipoId = respuesta.optString("tipo_id");
        clave_fe = respuesta.optString("clave_fe");
        fecha_fe = respuesta.optString("fec_factura");
        hora_fe = respuesta.optString("hora_factura");
        lblConseFE.setText(respuesta.optString("consecutivo_fe"));
        lblNomCliente.setText(respuesta.optString("nom_cliente"));
        lblNomFactura.setText(respuesta.optString("nom_factura"));
        lblIdFactura.setText(respuesta.optString("id_factura"));
        mEmail = respuesta.optString("email");
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
            itemFacVo.setExento(jsonItemFac.optInt("exento"));
            itemFacVo.setCodCabys(jsonItemFac.optString("codigoCabys"));
            listaItemFac.add(itemFacVo);
        }

        Object[][] objeto = new Object[listaItemFac.size()][7];
        for (int i = 0; i < listaItemFac.size(); i++) {

            for (int j = 0; j < 7; j++) {

                switch (j) {
                    case 0:
                        objeto[i][j] = listaItemFac.get(i).getCod_articulo();
                        break;
                    case 1:
                        objeto[i][j] = listaItemFac.get(i).getNom_articulo();
                        break;
                    case 2:
                        objeto[i][j] = formatoEntero.format(listaItemFac.get(i).getCantidad());
                        break;
                    case 3:
                        objeto[i][j] = formatoDecimal.format(listaItemFac.get(i).getPrecio());
                        break;
                    case 4:
                        objeto[i][j] = formatoDecimal.format(listaItemFac.get(i).getMon_descto());
                        break;
                    case 5:
                        objeto[i][j] = formatoDecimal.format(listaItemFac.get(i).getMon_impto());
                        break;
                    case 6:
                        objeto[i][j] = formatoDecimal.format(listaItemFac.get(i).getMon_subtotal());
                        break;
                }
            }
        }

        String[] nombreColumnas = {"Codigo", "Descripción", "Cantidad", "Precio", "Descuento", "Impuesto", "Sub-Total"};
        dtmArticulos = new DefaultTableModel(objeto, nombreColumnas);
        jtArticulos.setModel(dtmArticulos);

        DefaultTableCellRenderer derecho = new DefaultTableCellRenderer();
        derecho.setHorizontalAlignment(SwingConstants.RIGHT);
        DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
        centro.setHorizontalAlignment(SwingConstants.CENTER);

        jScrollPane1.setViewportView(jtArticulos);
        if (jtArticulos.getColumnModel().getColumnCount() > 0) {
            jtArticulos.getColumnModel().getColumn(0).setResizable(false);
            jtArticulos.getColumnModel().getColumn(0).setPreferredWidth(20);
            jtArticulos.getColumnModel().getColumn(0).setCellRenderer(centro);
            jtArticulos.getColumnModel().getColumn(1).setResizable(false);
            jtArticulos.getColumnModel().getColumn(1).setPreferredWidth(120);
            jtArticulos.getColumnModel().getColumn(2).setResizable(false);
            jtArticulos.getColumnModel().getColumn(2).setPreferredWidth(15);
            jtArticulos.getColumnModel().getColumn(2).setCellRenderer(derecho);
            jtArticulos.getColumnModel().getColumn(3).setResizable(false);
            jtArticulos.getColumnModel().getColumn(3).setPreferredWidth(15);
            jtArticulos.getColumnModel().getColumn(3).setCellRenderer(derecho);
            jtArticulos.getColumnModel().getColumn(4).setResizable(false);
            jtArticulos.getColumnModel().getColumn(4).setPreferredWidth(15);
            jtArticulos.getColumnModel().getColumn(4).setCellRenderer(derecho);
            jtArticulos.getColumnModel().getColumn(5).setResizable(false);
            jtArticulos.getColumnModel().getColumn(5).setPreferredWidth(15);
            jtArticulos.getColumnModel().getColumn(5).setCellRenderer(derecho);
            jtArticulos.getColumnModel().getColumn(6).setResizable(false);
            jtArticulos.getColumnModel().getColumn(6).setPreferredWidth(25);
            jtArticulos.getColumnModel().getColumn(6).setCellRenderer(derecho);
        }

        if (monTotFac == 0) {

            JOptionPane.showMessageDialog(this, "Factura YA fue anulada");
            limpiarCampos();
            btnAnular.setEnabled(false);
            txtNumFac.requestFocus();
            return;
        }

        if (Variables.mTIPOUSU == 1 && (respuesta.optInt("cod_agencia") != Variables.mAGEUSU || respuesta.optInt("cod_pdv") != Variables.mPDVUSU)) {
            JOptionPane.showMessageDialog(this, "Usuario NO autorizado para anular esta factura");
            limpiarCampos();
            btnAnular.setEnabled(false);
            txtNumFac.requestFocus();
            return;
        }
        if (Variables.mTIPOUSU <= 3 && respuesta.optInt("cod_agencia") != Variables.mAGEUSU) {
            JOptionPane.showMessageDialog(this, "Usuario NO autorizado para anular esta factura");
            limpiarCampos();
            btnAnular.setEnabled(false);
            txtNumFac.requestFocus();
            return;
        }

        btnAnular.setEnabled(true);
        btnAnular.requestFocus();

    }

    private void anulaFactura() throws IOException, JSONException {

        bp.abrirVentana("Generando Nota de Crédito...");

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
        jsonNota.put("nom_tributa", lblNomFactura.getText());
        jsonNota.put("id_tributa", lblIdFactura.getText());
        jsonNota.put("email", mEmail);
        jsonNota.put("tipo_id", mTipoId);
        jsonNota.put("num_factura", Integer.valueOf(txtNumFac.getText()));
        String obs_nota = "Doc. Ref: " + clave_fe;
        jsonNota.put("notas_fact", obs_nota);
        jsonNota.put("articulos", jsonArray);

        String url = Variables.URL_SERVER + "ejecucionpdv/wsAgregaNotaFactura_v2.php";

        respuesta = HttpClient.httpPOST(url, jsonNota);
        int numNota = respuesta.getInt("nota");

        bp.abrirVentana("Enviando Nota de Crédito a Hacienda...");

        // Envia nota a la api Hacienda
        url = Variables.URL_SERVER + "ejecucionpdv/wsApifecrEnvioNotas.php?num_nota=" + numNota;

        respuesta = HttpClient.httpGET(url);

        bp.abrirVentana("Anulando factura...");

        url = Variables.URL_SERVER + "ejecucionpdv/wsAnulaFactura_v2.php?num_factura=" + Integer.valueOf(txtNumFac.getText());

        respuesta = HttpClient.httpGET(url);

        bp.setVisible(false);

        JOptionPane.showMessageDialog(this, respuesta.opt("Mensaje"));
        limpiarCampos();
        btnAnular.setEnabled(false);
        txtNumFac.requestFocus();

    }
}
