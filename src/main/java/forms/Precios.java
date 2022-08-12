package forms;

import interfaces.TarifasDAO;
import metodos.Redondear;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.VO.ArticuloVO;
import modelo.VO.CatPdvVO;
import modelo.VO.PrecioVO;
import modelo.DAO.ArticuloDAOImpl;
import modelo.DAO.CatPdvDAOImpl;
import modelo.DAO.PrecioDAOImpl;
import modelo.DAO.TarifasDAOImpl;
import modelo.VO.TarifasVO;
import modelo.Validar;
import modelo.Variables;

public class Precios extends javax.swing.JInternalFrame {

    ArticuloVO articuloVo;
    PrecioVO precioVO;
    TarifasDAO tarifasDAO;
    Vector<TarifasVO> listaComboTarifas;
    DefaultComboBoxModel tarifasComboModel;

    Validar valida = new Validar();
    private int mDescto, mIva, mRedondeo;
    private double mPrecio;
    private boolean nuevo;
    DecimalFormat decimalFormat = new DecimalFormat("####,##0.00");

    public Precios() {
        initComponents();

        tarifasDAO = new TarifasDAOImpl();
        listaComboTarifas = new Vector();

        valida.limitarCaracteres(txtCodArticulo, 13);
        valida.limitarCaracteres(txtCatPdv, 2);
        valida.soloNumeros(txtCatPdv);
        //   valida.soloNumeros(txtPrecio);
        valida.limitarCaracteres(txtPrecio, 15);
        valida.limitarCaracteres(txtDescto, 2);
        valida.soloNumeros(txtDescto);

        valida.soloNumeros(txtRedondeo);
        valida.limitarCaracteres(txtRedondeo, 1);

        inactivaCampos();
        limpiaCampos();
        llenarComboTarifas();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodArticulo = new javax.swing.JTextField();
        txtCatPdv = new javax.swing.JTextField();
        lblNomArticulo = new javax.swing.JLabel();
        lblNomCatPdv = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        lblUniMed = new javax.swing.JLabel();
        lblMonDescto = new javax.swing.JLabel();
        txtDescto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblMonIva = new javax.swing.JLabel();
        cbExento = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        lblMonTotal = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtRedondeo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cbTarifaIVA = new javax.swing.JComboBox<>();

        setClosable(true);
        setTitle("Actualiza precios");
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

        btnGuardar.setText("Actualizar");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Codigo");

        jLabel3.setText("Categoria PDV");

        jLabel5.setText("Precio");

        txtCodArticulo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodArticuloFocusGained(evt);
            }
        });
        txtCodArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodArticuloActionPerformed(evt);
            }
        });
        txtCodArticulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodArticuloKeyPressed(evt);
            }
        });

        txtCatPdv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCatPdvFocusGained(evt);
            }
        });
        txtCatPdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCatPdvActionPerformed(evt);
            }
        });

        lblNomArticulo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblNomCatPdv.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

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

        lblUniMed.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblMonDescto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMonDescto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

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

        jLabel8.setText("%");

        jLabel7.setText("Descuento");

        jLabel9.setText("IVA");

        lblMonIva.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMonIva.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        cbExento.setText("Exento");
        cbExento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbExentoActionPerformed(evt);
            }
        });

        jLabel11.setText("Precio Total");

        lblMonTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMonTotal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel6.setText("Redondeo");

        txtRedondeo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRedondeoActionPerformed(evt);
            }
        });

        jLabel12.setText("Decimales");

        cbTarifaIVA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione tarifa" }));
        cbTarifaIVA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTarifaIVAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCodArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNomArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCatPdv, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)
                                .addComponent(lblNomCatPdv, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtRedondeo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)
                                                .addComponent(jLabel12))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(cbTarifaIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(24, 24, 24)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(lblMonIva, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(cbExento))
                                                    .addComponent(lblMonTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblMonDescto, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblUniMed, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtDescto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel8))
                                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtCodArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblNomArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtCatPdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblNomCatPdv, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(lblUniMed, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMonDescto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtDescto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMonIva, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel9)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblMonTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)))
                            .addComponent(cbTarifaIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtRedondeo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addComponent(cbExento))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)
                        .addGap(23, 23, 23)
                        .addComponent(btnSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbExentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbExentoActionPerformed
        if (cbExento.isSelected()) {
            mIva = 0;
            cbTarifaIVA.setSelectedIndex(1);

        }
        cbTarifaIVA.requestFocus();
        calculaMontos();
    }//GEN-LAST:event_cbExentoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed

        Variables.frmActPre = null;
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtCodArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodArticuloActionPerformed

        if (txtCodArticulo.getText().length() > 0) {
            try {
                consultarArticulo();
            } catch (SQLException ex) {
                Logger.getLogger(Precios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_txtCodArticuloActionPerformed

    private void txtCodArticuloFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodArticuloFocusGained
        txtCodArticulo.selectAll();
    }//GEN-LAST:event_txtCodArticuloFocusGained

    private void txtCatPdvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCatPdvFocusGained
        txtCatPdv.selectAll();
    }//GEN-LAST:event_txtCatPdvFocusGained

    private void txtPrecioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioFocusGained
        txtPrecio.selectAll();
    }//GEN-LAST:event_txtPrecioFocusGained

    private void txtDesctoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDesctoFocusGained
        txtDescto.selectAll();
    }//GEN-LAST:event_txtDesctoFocusGained

    private void txtCodArticuloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodArticuloKeyPressed
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                buscarArticulo();
            } catch (SQLException ex) {
                Logger.getLogger(Precios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtCodArticuloKeyPressed

    private void txtCatPdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCatPdvActionPerformed

        CatPdvVO catPdvVO = new CatPdvVO();
        catPdvVO.setCat_pdv(Integer.valueOf(txtCatPdv.getText()));
        try {
            if (CatPdvDAOImpl.consultar(catPdvVO)) {
                lblNomCatPdv.setText(catPdvVO.getNom_cat_pdv());
                consultaPrecio();
                activaCampos();
                txtPrecio.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Categporia NO existe");
                txtCatPdv.requestFocus();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Precios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_txtCatPdvActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed

        calculaMontos();
        txtDescto.requestFocus();
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtDesctoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDesctoActionPerformed
        calculaMontos();
        if (!cbExento.isSelected()) {
            cbTarifaIVA.requestFocus();
        } else {
            btnGuardar.requestFocus();
        }

    }//GEN-LAST:event_txtDesctoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        limpiaCampos();
        inactivaCampos();
        txtCodArticulo.requestFocus();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        
        // Crear validaciones de campos
        if ( cbTarifaIVA.getSelectedIndex()<=0) {
            JOptionPane.showMessageDialog(this, "Seleccione una tarifa del IVA");
            cbTarifaIVA.requestFocus();
            return;
        }

        if (txtPrecio.getText().length() > 0) {
            mPrecio = Double.valueOf(txtPrecio.getText());
        } else {
            mPrecio = 0;
        }
        if (txtDescto.getText().length() > 0) {
            mDescto = Integer.valueOf(txtDescto.getText());
        } else {
            mDescto = 0;
        }

        int fila = cbTarifaIVA.getSelectedIndex(); 
        mIva = (int) listaComboTarifas.get(fila).getPorTarifa();

        //Cargar valores de campos
        precioVO = new PrecioVO();
        precioVO.setCodigo_art(Integer.valueOf(txtCodArticulo.getText()));
        precioVO.setCat_pdv(Integer.valueOf(txtCatPdv.getText()));
        precioVO.setPrecio_art(mPrecio);
        precioVO.setDescto_art(mDescto);
        precioVO.setCodTarifa(listaComboTarifas.get(fila).getCodTarifa());
        precioVO.setDesTarifa(listaComboTarifas.get(fila).getDesTarifa());
        precioVO.setImpto_art(mIva);
        precioVO.setRedondeo(mRedondeo);

        if (cbExento.isSelected()) {
            precioVO.setExento(1);
        } else {
            precioVO.setExento(0);
        }

        if (nuevo) {// Nuevo precio

            PrecioDAOImpl.incluir(precioVO);

        } else { // Modifica el precio

            PrecioDAOImpl.actualizar(precioVO);

        }
        JOptionPane.showMessageDialog(this, "Precio Actualizado");
        limpiaCampos();
        inactivaCampos();
        txtCodArticulo.requestFocus();


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtRedondeoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRedondeoActionPerformed

        mRedondeo = Integer.valueOf(txtRedondeo.getText());
        calculaMontos();
        txtPrecio.requestFocus();


    }//GEN-LAST:event_txtRedondeoActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing

        Variables.frmActPre = null;

    }//GEN-LAST:event_formInternalFrameClosing

    private void cbTarifaIVAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTarifaIVAActionPerformed

        if (cbTarifaIVA.getSelectedIndex() > 0) {
            if (cbTarifaIVA.getSelectedIndex() == 1) {
                cbExento.setSelected(true);

            } else {
                cbExento.setSelected(false);
            }
            int fila = cbTarifaIVA.getSelectedIndex();
            mIva = (int) listaComboTarifas.get(fila).getPorTarifa();
            precioVO.setImpto_art(mIva);
        }

        calculaMontos();


    }//GEN-LAST:event_cbTarifaIVAActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox cbExento;
    private javax.swing.JComboBox<String> cbTarifaIVA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblMonDescto;
    private javax.swing.JLabel lblMonIva;
    private javax.swing.JLabel lblMonTotal;
    private javax.swing.JLabel lblNomArticulo;
    private javax.swing.JLabel lblNomCatPdv;
    private javax.swing.JLabel lblUniMed;
    private javax.swing.JTextField txtCatPdv;
    private javax.swing.JTextField txtCodArticulo;
    private javax.swing.JTextField txtDescto;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtRedondeo;
    // End of variables declaration//GEN-END:variables

    private void consultarArticulo() throws SQLException {

        if (txtCodArticulo.getText().length() == 13) {
            //Busca articulo por codigo de barras
            articuloVo = new ArticuloVO();
            articuloVo.setCod_barra(txtCodArticulo.getText());
            if (ArticuloDAOImpl.consultaArtxCodBarra(articuloVo)) {
                lblNomArticulo.setText(articuloVo.getNom_lar_art());
                lblUniMed.setText("/" + articuloVo.getUni_med());
                txtCatPdv.setEnabled(true);
                txtCatPdv.requestFocus();
            } else {
                JOptionPane.showMessageDialog(this, "Articulo NO existe");
                txtCodArticulo.requestFocus();
            }

        } else {
            //Busca articulo por codigo consecutivo
            articuloVo = new ArticuloVO();
            articuloVo.setCodigo_art(Integer.valueOf(txtCodArticulo.getText()));
            if (ArticuloDAOImpl.consultaArtxCodInt(articuloVo)) {
                lblNomArticulo.setText(articuloVo.getNom_lar_art());
                lblUniMed.setText("/" + articuloVo.getUni_med());
                txtCatPdv.setEnabled(true);
                txtCatPdv.requestFocus();
            } else {
                JOptionPane.showMessageDialog(this, "Articulo NO existe");
                txtCodArticulo.requestFocus();
            }
        }

    }

    private void activaCampos() {
        btnGuardar.setEnabled(true);
        txtPrecio.setEnabled(true);
        txtDescto.setEnabled(true);
        cbTarifaIVA.setEnabled(true);
        txtRedondeo.setEnabled(true);
        cbExento.setEnabled(true);
    }

    private void inactivaCampos() {
        btnGuardar.setEnabled(false);
        txtCatPdv.setEnabled(false);
        txtPrecio.setEnabled(false);
        txtDescto.setEnabled(false);
        cbTarifaIVA.setEnabled(false);
        txtRedondeo.setEnabled(false);
        cbExento.setEnabled(false);
    }

    private void buscarArticulo() throws SQLException {

        BuscaItem buscaArticulo = new BuscaItem(null, true);
        buscaArticulo.setLocationRelativeTo(null);
        buscaArticulo.setVisible(true);
        String valorSelec = buscaArticulo.getCodArticulo();
        txtCodArticulo.setText(valorSelec);
        txtCodArticulo.requestFocus();

        if (txtCodArticulo.getText().length() > 0) {
            try {
                consultarArticulo();
            } catch (SQLException ex) {
                Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void consultaPrecio() throws SQLException {

        precioVO = new PrecioVO();
        precioVO.setCodigo_art(Integer.valueOf(txtCodArticulo.getText()));
        precioVO.setCat_pdv(Integer.valueOf(txtCatPdv.getText()));
        if (PrecioDAOImpl.consultaPrecio(precioVO)) {
            nuevo = false;
            mPrecio = precioVO.getPrecio_art();
            txtPrecio.setText(String.valueOf(mPrecio));
            mDescto = precioVO.getDescto_art();
            txtDescto.setText(String.valueOf(mDescto));
            mIva = precioVO.getImpto_art();

            cbTarifaIVA.setSelectedIndex(precioVO.getCodTarifa());
            
           
            mRedondeo = precioVO.getRedondeo();
            txtRedondeo.setText(String.valueOf(mRedondeo));
            if (precioVO.getExento() == 1) {
                cbExento.setSelected(true);

            } else {
                cbExento.setSelected(false);
            }
            txtPrecio.requestFocus();
        } else {
            nuevo = true;
            mPrecio = 0.00;
            txtPrecio.setText(String.valueOf(mPrecio));
            mDescto = 0;
            txtDescto.setText(String.valueOf(mDescto));
            mIva = 0;
            cbTarifaIVA.setSelectedIndex(0);
            mRedondeo = 2;
            txtRedondeo.setText(String.valueOf(mRedondeo));
            cbExento.setSelected(false);

        }
        calculaMontos();
        txtPrecio.requestFocus();

    }

    private void calculaMontos() {
        // Calcula montos
        int iDescto, iImpto;
        double iPrecio, iMonDescto, iMonImpto, iMonTotal, iSubTotal;

        if (txtPrecio.getText().length() > 0) {
            iPrecio = Double.valueOf(txtPrecio.getText());
        } else {
            iPrecio = 0.00;
        }
        if (txtDescto.getText().length() > 0) {
            iDescto = Integer.valueOf(txtDescto.getText());
        } else {
            iDescto = 0;
        }

        iImpto = mIva;

        iSubTotal = Redondear.decimal((iPrecio), mRedondeo);
        iMonDescto = Redondear.decimal((iPrecio * iDescto / 100), mRedondeo);
        iMonImpto = Redondear.decimal(((iSubTotal - iMonDescto) * iImpto / 100), mRedondeo);
        iMonTotal = Redondear.decimal((iSubTotal - iMonDescto + iMonImpto), mRedondeo);
        lblMonDescto.setText(decimalFormat.format(iMonDescto));
        lblMonIva.setText(decimalFormat.format(iMonImpto));
        lblMonTotal.setText(decimalFormat.format(iMonTotal));

    }

    private void limpiaCampos() {

        DecimalFormat formato = new DecimalFormat("####,##0.00");

        txtCodArticulo.setText("");
        txtCatPdv.setText("");
        txtPrecio.setText(formato.format(0.00));
        txtDescto.setText("0");
        cbTarifaIVA.setSelectedIndex(0);
        txtRedondeo.setText("2");
        lblNomArticulo.setText("");
        lblNomCatPdv.setText("");
        lblUniMed.setText("");
        lblMonDescto.setText(formato.format(0.00));
        lblMonIva.setText(formato.format(0.00));
        lblMonTotal.setText(formato.format(0.00));

    }

    private void llenarComboTarifas() {

        try {
            listaComboTarifas = tarifasDAO.llenaComboBox();
            tarifasComboModel = new DefaultComboBoxModel(listaComboTarifas);
            cbTarifaIVA.setModel(tarifasComboModel);
        } catch (SQLException ex) {
            Logger.getLogger(Precios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
