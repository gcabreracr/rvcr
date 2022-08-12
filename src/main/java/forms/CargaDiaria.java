package forms;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.VO.AgenciaVO;
import modelo.VO.ArticuloVO;
import modelo.VO.VentaDiaVO;
import modelo.VO.PdvVO;
import modelo.DAO.AgenciaDAOImpl;
import modelo.DAO.ArticuloDAOImpl;
import modelo.DAO.PdvDAOImpl;
import modelo.DAO.VentaDiaDAOImpl;
import modelo.Validar;
import modelo.Variables;

public class CargaDiaria extends javax.swing.JInternalFrame {

    ArticuloVO articuloVo;
    VentaDiaVO ventaDiaVo;
    DefaultTableModel dtmCargaDiaria;
    Validar valida = new Validar();
    DefaultTableModel dtmClientes;
    DecimalFormat formatoEntero = new DecimalFormat("####,###");

    private int mCargaIni, mRecargas, mCodigoArt;

    public CargaDiaria()  {
        initComponents();

        Date fecha = new Date();
        jdcFechaLiq.setDate(fecha);
        if (Variables.mTIPOUSU > 2) {
            jdcFechaLiq.setEnabled(true);
        } else {
            jdcFechaLiq.setEnabled(false);
        }

        txtCodAgencia.setText(String.valueOf(Variables.mAGEUSU));
        lblNomAgencia.setText(Variables.mNOMAGEUSU);
        txtCodPdv.setText(String.valueOf(Variables.mPDVUSU));
        lblNomPdv.setText(Variables.mNOMPDVUSU);

        if (Variables.mTIPOUSU < 4) {
            this.txtCodAgencia.setEnabled(false);
            this.txtCodPdv.requestFocus();
        }
        if (Variables.mTIPOUSU == 1) {
            txtCodPdv.setEnabled(false);
            btnConsultaCarga.requestFocus();
        }
        jtCargaDiaria.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouse_evt) {
                if (mouse_evt.getClickCount() == 2) {
                    try {
                        seleccionaItem();
                    } catch (SQLException ex) {
                        Logger.getLogger(CargaDiaria.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        inactivaCampos();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSuperior = new javax.swing.JPanel();
        jpDatCarDia = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodAgencia = new javax.swing.JTextField();
        lblNomAgencia = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodPdv = new javax.swing.JTextField();
        lblNomPdv = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jdcFechaLiq = new com.toedter.calendar.JDateChooser();
        btnConsultaCarga = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnImprime = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jpArticulos = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtCodigoArt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCargaDiaria = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCargaIni = new javax.swing.JTextField();
        txtRecargas = new javax.swing.JTextField();
        btnCancela = new javax.swing.JButton();
        lblNomArt = new javax.swing.JLabel();
        btnActualiza = new javax.swing.JButton();

        setClosable(true);
        setTitle("Actualiza Carga Diaria");
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

        panelSuperior.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Agencia");

        txtCodAgencia.setText(" ");
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

        lblNomAgencia.setText(" ");
        lblNomAgencia.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel2.setText("Ruta / PDV");

        txtCodPdv.setText(" ");
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

        lblNomPdv.setText(" ");
        lblNomPdv.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel4.setText("Fecha");

        jdcFechaLiq.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jdcFechaLiqFocusGained(evt);
            }
        });

        btnConsultaCarga.setText("Consultar");
        btnConsultaCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaCargaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpDatCarDiaLayout = new javax.swing.GroupLayout(jpDatCarDia);
        jpDatCarDia.setLayout(jpDatCarDiaLayout);
        jpDatCarDiaLayout.setHorizontalGroup(
            jpDatCarDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatCarDiaLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jpDatCarDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDatCarDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDatCarDiaLayout.createSequentialGroup()
                        .addGroup(jpDatCarDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpDatCarDiaLayout.createSequentialGroup()
                                .addComponent(txtCodPdv, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNomPdv, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpDatCarDiaLayout.createSequentialGroup()
                                .addComponent(txtCodAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNomAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(jpDatCarDiaLayout.createSequentialGroup()
                        .addComponent(jdcFechaLiq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConsultaCarga)
                        .addGap(30, 30, 30))))
        );
        jpDatCarDiaLayout.setVerticalGroup(
            jpDatCarDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatCarDiaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDatCarDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomAgencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDatCarDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodPdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomPdv)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDatCarDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcFechaLiq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnConsultaCarga))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        btnImprime.setText("Imprimir");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnImprime, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnImprime, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jpDatCarDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpDatCarDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelSuperior, java.awt.BorderLayout.NORTH);

        jpArticulos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Articulos"), "Articulos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel5.setText("Codigo");

        txtCodigoArt.setText(" ");
        txtCodigoArt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodigoArtFocusGained(evt);
            }
        });
        txtCodigoArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoArtActionPerformed(evt);
            }
        });
        txtCodigoArt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoArtKeyPressed(evt);
            }
        });

        jtCargaDiaria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripcion", "Carga Inicial", "Recargas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCargaDiaria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtCargaDiariaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtCargaDiaria);
        if (jtCargaDiaria.getColumnModel().getColumnCount() > 0) {
            jtCargaDiaria.getColumnModel().getColumn(0).setResizable(false);
            jtCargaDiaria.getColumnModel().getColumn(0).setPreferredWidth(10);
            jtCargaDiaria.getColumnModel().getColumn(1).setResizable(false);
            jtCargaDiaria.getColumnModel().getColumn(1).setPreferredWidth(150);
            jtCargaDiaria.getColumnModel().getColumn(2).setResizable(false);
            jtCargaDiaria.getColumnModel().getColumn(2).setPreferredWidth(15);
            jtCargaDiaria.getColumnModel().getColumn(3).setResizable(false);
            jtCargaDiaria.getColumnModel().getColumn(3).setPreferredWidth(15);
        }

        jLabel6.setText("Carga Inicial");

        jLabel7.setText("Recargas");

        txtCargaIni.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCargaIni.setText(" ");
        txtCargaIni.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCargaIniFocusGained(evt);
            }
        });
        txtCargaIni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargaIniActionPerformed(evt);
            }
        });

        txtRecargas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtRecargas.setText(" ");
        txtRecargas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRecargasFocusGained(evt);
            }
        });
        txtRecargas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRecargasActionPerformed(evt);
            }
        });

        btnCancela.setText("Cancelar");
        btnCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelaActionPerformed(evt);
            }
        });

        lblNomArt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btnActualiza.setText("Guardar");
        btnActualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpArticulosLayout = new javax.swing.GroupLayout(jpArticulos);
        jpArticulos.setLayout(jpArticulosLayout);
        jpArticulosLayout.setHorizontalGroup(
            jpArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpArticulosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jpArticulosLayout.createSequentialGroup()
                        .addGroup(jpArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jpArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpArticulosLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(txtCodigoArt, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpArticulosLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtRecargas, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCargaIni, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomArt, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpArticulosLayout.createSequentialGroup()
                                .addComponent(btnActualiza, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancela, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 94, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpArticulosLayout.setVerticalGroup(
            jpArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpArticulosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpArticulosLayout.createSequentialGroup()
                        .addGroup(jpArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCodigoArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCargaIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtRecargas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpArticulosLayout.createSequentialGroup()
                        .addComponent(lblNomArt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jpArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActualiza)
                            .addComponent(btnCancela))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        getContentPane().add(jpArticulos, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelaActionPerformed
        // TODO add your handling code here:
        txtCodigoArt.setText("");
        lblNomArt.setText("");
        txtCargaIni.setText("");
        txtRecargas.setText("");
        txtCodigoArt.requestFocus();
    }//GEN-LAST:event_btnCancelaActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    }//GEN-LAST:event_formWindowActivated

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
            Logger.getLogger(BuscaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtCodPdvActionPerformed

    private void txtCodAgenciaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodAgenciaFocusGained
        
        txtCodAgencia.selectAll();
    }//GEN-LAST:event_txtCodAgenciaFocusGained

    private void txtCodPdvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodPdvFocusGained
        
        txtCodPdv.selectAll();
    }//GEN-LAST:event_txtCodPdvFocusGained

    private void txtCodigoArtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoArtFocusGained
        
        txtCodigoArt.selectAll();
    }//GEN-LAST:event_txtCodigoArtFocusGained

    private void txtCodAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodAgenciaActionPerformed
        

        try {
            consultarAgencia();
        } catch (SQLException ex) {
            Logger.getLogger(BuscaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtCodAgenciaActionPerformed

    private void jdcFechaLiqFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jdcFechaLiqFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_jdcFechaLiqFocusGained

    private void txtCargaIniFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCargaIniFocusGained
       
        txtCargaIni.selectAll();
    }//GEN-LAST:event_txtCargaIniFocusGained

    private void txtRecargasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRecargasFocusGained
        
        txtRecargas.selectAll();
    }//GEN-LAST:event_txtRecargasFocusGained

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        
        Variables.frmCarDia=null;
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtCodigoArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoArtActionPerformed
        // TODO add your handling code here:
        if (txtCodigoArt.getText().length() > 0) {
            try {
                consultarArticulo();
            } catch (SQLException ex) {
                Logger.getLogger(Precios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtCodigoArtActionPerformed

    private void txtCodigoArtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoArtKeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                buscarArticulo();
            } catch (SQLException ex) {
                Logger.getLogger(Precios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtCodigoArtKeyPressed

    private void txtCargaIniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCargaIniActionPerformed
        // TODO add your handling code here:
        mCargaIni = Integer.valueOf(txtCargaIni.getText().replace(",", ""));
        txtCargaIni.setText(formatoEntero.format(mCargaIni));
        txtRecargas.requestFocus();

    }//GEN-LAST:event_txtCargaIniActionPerformed

    private void txtRecargasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRecargasActionPerformed
        // TODO add your handling code here:
        mRecargas = Integer.valueOf(txtRecargas.getText().replace(",", ""));
        txtRecargas.setText(formatoEntero.format(mRecargas));
        btnActualiza.requestFocus();
    }//GEN-LAST:event_txtRecargasActionPerformed

    private void btnActualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizaActionPerformed
        try {

            actualizaCargaDia();
        } catch (SQLException ex) {
            Logger.getLogger(CargaDiaria.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnActualizaActionPerformed

    private void btnConsultaCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaCargaActionPerformed

        // TODO add your handling code here:

        if (txtCodAgencia.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una Agencia valida");
            txtCodAgencia.requestFocus();
            return;
        }
        if (txtCodPdv.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un PDV valido");
            txtCodPdv.requestFocus();
            return;
        }
        try {
            llenarTabla();
            activaCampos();
            txtCodigoArt.setText("");
            lblNomArt.setText("");
            txtCargaIni.setText("");
            txtRecargas.setText("");
            txtCodigoArt.requestFocus();
        } catch (SQLException ex) {
            Logger.getLogger(CargaDiaria.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnConsultaCargaActionPerformed

    private void jtCargaDiariaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCargaDiariaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                seleccionaItem();
            } catch (SQLException ex) {
                Logger.getLogger(CargaDiaria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jtCargaDiariaKeyPressed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        
        Variables.frmCarDia = null;
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualiza;
    private javax.swing.JButton btnCancela;
    private javax.swing.JButton btnConsultaCarga;
    private javax.swing.JButton btnImprime;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcFechaLiq;
    private javax.swing.JPanel jpArticulos;
    private javax.swing.JPanel jpDatCarDia;
    private javax.swing.JTable jtCargaDiaria;
    private javax.swing.JLabel lblNomAgencia;
    private javax.swing.JLabel lblNomArt;
    private javax.swing.JLabel lblNomPdv;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JTextField txtCargaIni;
    private javax.swing.JTextField txtCodAgencia;
    private javax.swing.JTextField txtCodPdv;
    private javax.swing.JTextField txtCodigoArt;
    private javax.swing.JTextField txtRecargas;
    // End of variables declaration//GEN-END:variables

    private void consultarAgencia() throws SQLException {

        AgenciaVO agencia = new AgenciaVO();
        agencia.setCodagencia(Integer.valueOf(txtCodAgencia.getText()));

        if (AgenciaDAOImpl.consultar(agencia)) {
            lblNomAgencia.setText(agencia.getNomagencia());
            txtCodPdv.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "Agencia no existe");
            txtCodAgencia.requestFocus();
        }

    }

    private void consultarPdv() throws SQLException {

        PdvVO pdv = new PdvVO();
        pdv.setCodAgencia(Integer.valueOf(txtCodAgencia.getText()));
        pdv.setCodPdv(Integer.valueOf(txtCodPdv.getText()));

        if (PdvDAOImpl.consultar(pdv)) {
            this.lblNomPdv.setText(pdv.getNomPdv());
            btnConsultaCarga.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "PDV/Ruta no existe");
            txtCodPdv.requestFocus();
        }
    }

    private void consultarArticulo() throws SQLException {

        if (txtCodigoArt.getText().length() == 13) {
            //Busca articulo por codigo de barras
            articuloVo = new ArticuloVO();
            articuloVo.setCod_barra(txtCodigoArt.getText());
            if (ArticuloDAOImpl.consultaArtxCodBarra(articuloVo)) {
                lblNomArt.setText(articuloVo.getNom_lar_art().trim() + "/" + articuloVo.getUni_med());
                mCodigoArt = articuloVo.getCodigo_art();
                consultaCargaArticulo();
                txtCargaIni.requestFocus();
            } else {
                JOptionPane.showMessageDialog(this, "Articulo NO existe");
                txtCodigoArt.requestFocus();
            }

        } else {
            //Busca articulo por codigo consecutivo
            articuloVo = new ArticuloVO();
            articuloVo.setCodigo_art(Integer.valueOf(txtCodigoArt.getText()));
            if (ArticuloDAOImpl.consultaArtxCodInt(articuloVo)) {
                lblNomArt.setText(articuloVo.getNom_lar_art().trim() + "/" + articuloVo.getUni_med());
                mCodigoArt = articuloVo.getCodigo_art();
                consultaCargaArticulo();
                txtCargaIni.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Articulo NO existe");
                txtCodigoArt.requestFocus();
            }
        }
    }

    private void buscarArticulo() throws SQLException {
        BuscaItem buscaArticulo = new BuscaItem(null, true);
        buscaArticulo.setLocationRelativeTo(null);
        buscaArticulo.setVisible(true);
        String valorSelec = buscaArticulo.getCodArticulo();
        txtCodigoArt.setText(valorSelec);
        txtCodigoArt.requestFocus();

        if (txtCodigoArt.getText().length() > 0) {
            try {
                consultarArticulo();
            } catch (SQLException ex) {
                Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void llenarTabla() throws SQLException {

        dtmCargaDiaria = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }

        };

        dtmCargaDiaria.addColumn("Codigo");
        dtmCargaDiaria.addColumn("Descripcion");
        dtmCargaDiaria.addColumn("Carga Inicial");
        dtmCargaDiaria.addColumn("Recargas");
        jtCargaDiaria.setModel(dtmCargaDiaria);

        int codAge = Integer.valueOf(txtCodAgencia.getText());
        int codPdv = Integer.valueOf(txtCodPdv.getText());
        java.sql.Date fecha = new java.sql.Date(jdcFechaLiq.getDate().getTime());

        ArrayList<VentaDiaVO> listaCargaDia = VentaDiaDAOImpl.listaCargaDia(codAge, codPdv, fecha.toString());

        Object[] fila = new Object[4];
        for (VentaDiaVO ventaDia : listaCargaDia) {
            fila[0] = ventaDia.getCodigo_art();
            fila[1] = ventaDia.getNom_lar_art();
            String sCargaDia = formatoEntero.format(ventaDia.getCarga_ini());
            fila[2] = sCargaDia;
            String sRecargas = formatoEntero.format(ventaDia.getRecargas());
            fila[3] = sRecargas;
            dtmCargaDiaria.addRow(fila);
        }

        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.RIGHT);

        jScrollPane1.setViewportView(jtCargaDiaria);
        if (jtCargaDiaria.getColumnModel().getColumnCount() > 0) {
            jtCargaDiaria.getColumnModel().getColumn(0).setResizable(false);
            jtCargaDiaria.getColumnModel().getColumn(0).setPreferredWidth(10);
            jtCargaDiaria.getColumnModel().getColumn(0).setCellRenderer(dtcr);
            jtCargaDiaria.getColumnModel().getColumn(1).setResizable(false);
            jtCargaDiaria.getColumnModel().getColumn(1).setPreferredWidth(120);
            jtCargaDiaria.getColumnModel().getColumn(2).setResizable(false);
            jtCargaDiaria.getColumnModel().getColumn(2).setPreferredWidth(15);
            jtCargaDiaria.getColumnModel().getColumn(2).setCellRenderer(dtcr);
            jtCargaDiaria.getColumnModel().getColumn(3).setResizable(false);
            jtCargaDiaria.getColumnModel().getColumn(3).setPreferredWidth(15);
            jtCargaDiaria.getColumnModel().getColumn(3).setCellRenderer(dtcr);

        }

    }

    private void inactivaCampos() {

        txtCodigoArt.setEnabled(false);
        txtCargaIni.setEnabled(false);
        txtRecargas.setEnabled(false);
        btnActualiza.setEnabled(false);
        btnCancela.setEnabled(false);
        jtCargaDiaria.setEnabled(false);
    }

    private void activaCampos() {

        txtCodigoArt.setEnabled(true);
        txtCargaIni.setEnabled(true);
        txtRecargas.setEnabled(true);
        btnActualiza.setEnabled(true);
        btnCancela.setEnabled(true);
        jtCargaDiaria.setEnabled(true);
    }

    private void consultaCargaArticulo() throws SQLException {

        ventaDiaVo = new VentaDiaVO();
        ventaDiaVo.setCodigo_art(Integer.valueOf(txtCodigoArt.getText()));
        ventaDiaVo.setCod_agencia(Integer.valueOf(txtCodAgencia.getText()));
        ventaDiaVo.setCod_pdv(Integer.valueOf(txtCodPdv.getText()));
        java.sql.Date fecha = new java.sql.Date(jdcFechaLiq.getDate().getTime());
        ventaDiaVo.setFecha_liq(fecha.toString());
        if (VentaDiaDAOImpl.consultaCargaArt(ventaDiaVo)) {
            mCargaIni = ventaDiaVo.getCarga_ini();
            mRecargas = ventaDiaVo.getRecargas();

        } else {
            mCargaIni = 0;
            ventaDiaVo.setCarga_ini(mCargaIni);
            mRecargas = 0;
            ventaDiaVo.setRecargas(mRecargas);
        }
        String sCargaDia = formatoEntero.format(mCargaIni);
        String sRecargas = formatoEntero.format(mRecargas);
        txtCargaIni.setText(sCargaDia);
        txtRecargas.setText(sRecargas);

    }

    private void actualizaCargaDia() throws SQLException {
        ventaDiaVo = new VentaDiaVO();
        ventaDiaVo.setCodigo_art(Integer.valueOf(txtCodigoArt.getText()));
        ventaDiaVo.setCod_agencia(Integer.valueOf(txtCodAgencia.getText()));
        ventaDiaVo.setCod_pdv(Integer.valueOf(txtCodPdv.getText()));
        java.sql.Date fecha = new java.sql.Date(jdcFechaLiq.getDate().getTime());
        ventaDiaVo.setFecha_liq(fecha.toString());

        if (VentaDiaDAOImpl.consultaCargaArt(ventaDiaVo)) {
            ventaDiaVo.setCarga_ini(Integer.valueOf(txtCargaIni.getText().replace(",", "")));
            ventaDiaVo.setRecargas(Integer.valueOf(txtRecargas.getText().replace(",", "")));
            VentaDiaDAOImpl.actualizar(ventaDiaVo);
        } else {
            ventaDiaVo.setCarga_ini(Integer.valueOf(txtCargaIni.getText().replace(",", "")));
            ventaDiaVo.setRecargas(Integer.valueOf(txtRecargas.getText().replace(",", "")));
            VentaDiaDAOImpl.incluyeCargaDia(ventaDiaVo);
        }
        llenarTabla();
        txtCodigoArt.setText("");
        lblNomArt.setText("");
        txtCargaIni.setText("");
        txtRecargas.setText("");
        txtCodigoArt.requestFocus();

    }

    private void seleccionaItem() throws SQLException {
        if (jtCargaDiaria.getSelectedColumnCount() > 0) {

            int viewRow = jtCargaDiaria.getSelectedRow();
            if (viewRow < 0) {
                txtCodigoArt.setText(String.valueOf(dtmCargaDiaria.getValueAt(viewRow, 0)));
            } else {
                int modelRow = jtCargaDiaria.convertRowIndexToModel(viewRow);
                txtCodigoArt.setText(String.valueOf(dtmCargaDiaria.getValueAt(modelRow, 0)));
            }
            consultarArticulo();
        }
    }
}
