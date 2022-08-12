package forms;

import interfaces.CabysDAO;
import interfaces.CatArticuloDAO;
import interfaces.MedidasDAO;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.VO.ArticuloVO;
import modelo.VO.CatArticuloVO;
import modelo.VO.MedidasVO;
import modelo.DAO.ArticuloDAOImpl;
import modelo.DAO.CabysDAOImpl;
import modelo.DAO.CatArticuloDAOImpl;
import modelo.DAO.MedidasDAOImpl;
import modelo.VO.CabysVO;
import modelo.Validar;
import modelo.Variables;

public class Articulos extends javax.swing.JInternalFrame {

    private boolean nuevo;
    private String codCabys;
    ArticuloVO articuloVO;
    private int codCategoria, codMedida;
    Validar valida;
    MedidasDAO medidasDAO;
    CatArticuloDAO catArticuloDAO;
    CabysVO cabysVO;
    CabysDAO cabysDAO;

    DefaultComboBoxModel<CatArticuloVO> categoprias;
    DefaultComboBoxModel<MedidasVO> medidas;

    public Articulos() {
        initComponents();

        catArticuloDAO = new CatArticuloDAOImpl();
        medidasDAO = new MedidasDAOImpl();
        cabysDAO = new CabysDAOImpl();
        valida = new Validar();
        valida.limitarCaracteres(txtCodArticulo, Variables.L_COD_ART);
        valida.soloNumeros(txtCodArticulo);
        valida.limitarCaracteres(txtNomLargo, Variables.L_NOM_LAR_ART);
        valida.limitarCaracteres(txtNomCorto, Variables.L_NOM_COR_ART);
        valida.limitarCaracteres(txtCodBarra, Variables.L_COD_BARRA);
        limpiaCampos();
        inactivaCampos();
        llenarComboMedidas();
        llenarComboCategorias();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgTipoItem = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodArticulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNomLargo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNomCorto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCodBarra = new javax.swing.JTextField();
        rbArticulo = new javax.swing.JRadioButton();
        rbServicio = new javax.swing.JRadioButton();
        lblAccionArticulo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCodCabys = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDesCabys = new javax.swing.JTextField();
        cbMedida = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbxEsActivo = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setClosable(true);
        setForeground(new java.awt.Color(255, 255, 255));
        setTitle("Actualiza Productos o Servicios");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Codigo interno");

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

        jLabel3.setText("Nombre Largo");

        txtNomLargo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomLargoFocusGained(evt);
            }
        });
        txtNomLargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomLargoActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre Corto");

        txtNomCorto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomCortoFocusGained(evt);
            }
        });
        txtNomCorto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomCortoActionPerformed(evt);
            }
        });

        jLabel4.setText("Unidad medida");

        jLabel10.setText("Codigo barras");

        txtCodBarra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodBarraFocusGained(evt);
            }
        });
        txtCodBarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodBarraActionPerformed(evt);
            }
        });

        bgTipoItem.add(rbArticulo);
        rbArticulo.setSelected(true);
        rbArticulo.setText("Producto");
        rbArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbArticuloActionPerformed(evt);
            }
        });

        bgTipoItem.add(rbServicio);
        rbServicio.setText("Servicio");
        rbServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbServicioActionPerformed(evt);
            }
        });

        lblAccionArticulo.setText(" ");

        jLabel7.setText("Código Cabys");

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

        jLabel8.setText("Descripción");

        txtDesCabys.setEnabled(false);
        txtDesCabys.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDesCabysFocusGained(evt);
            }
        });
        txtDesCabys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDesCabysActionPerformed(evt);
            }
        });

        cbMedida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una medida" }));
        cbMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMedidaActionPerformed(evt);
            }
        });

        jLabel9.setText("Categoria");

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una Categoria" }));

        jLabel11.setText("Tipo Item");

        cbxEsActivo.setSelected(true);
        cbxEsActivo.setText("Activo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodCabys, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbArticulo)
                                .addGap(18, 18, 18)
                                .addComponent(rbServicio)
                                .addGap(83, 83, 83)
                                .addComponent(cbxEsActivo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCodArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAccionArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNomLargo, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomCorto, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDesCabys, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAccionArticulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNomLargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomCorto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbArticulo)
                    .addComponent(rbServicio)
                    .addComponent(jLabel11)
                    .addComponent(cbxEsActivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCodCabys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDesCabys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(15, 15, 15))
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Variables.frmActPro = null;
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtCodArticuloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodArticuloKeyPressed
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                buscarArticulo();
            } catch (SQLException ex) {
                Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error de conexion con el servidor");
            }
        }
    }//GEN-LAST:event_txtCodArticuloKeyPressed

    private void txtCodArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodArticuloActionPerformed
        if (!txtCodArticulo.getText().isEmpty()) {
            try {
                
                consultaArticulo();
                
            } catch (SQLException ex) {
                Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error de conexion con el servidor");
            }
        } else {
            nuevo = true;

            lblAccionArticulo.setText("Nuevo Articulo");
            limpiaCampos();
            activaCampos();
            txtNomLargo.requestFocus();

        }
    }//GEN-LAST:event_txtCodArticuloActionPerformed

    private void txtCodArticuloFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodArticuloFocusGained
        txtCodArticulo.selectAll();
    }//GEN-LAST:event_txtCodArticuloFocusGained

    private void txtNomLargoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomLargoFocusGained
        txtNomLargo.selectAll();
    }//GEN-LAST:event_txtNomLargoFocusGained

    private void txtNomCortoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomCortoFocusGained
        txtNomCorto.selectAll();
    }//GEN-LAST:event_txtNomCortoFocusGained

    private void txtCodBarraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodBarraFocusGained
        txtCodBarra.selectAll();
    }//GEN-LAST:event_txtCodBarraFocusGained

    private void txtNomLargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomLargoActionPerformed
        txtNomCorto.requestFocus();
    }//GEN-LAST:event_txtNomLargoActionPerformed

    private void txtNomCortoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomCortoActionPerformed
        cbMedida.requestFocus();
    }//GEN-LAST:event_txtNomCortoActionPerformed

    private void txtCodBarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodBarraActionPerformed
        txtCodCabys.requestFocus();
    }//GEN-LAST:event_txtCodBarraActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        inactivaCampos();
        limpiaCampos();
        txtCodArticulo.setText("");
        txtCodArticulo.requestFocus();


    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (txtNomLargo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nombre del articulo requirido");
            txtNomLargo.requestFocus();
            return;
        }

        if (txtNomCorto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nombre del articulo requerido");
            txtNomCorto.requestFocus();
            return;
        }
        if (cbMedida.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una medida");
            cbMedida.requestFocus();
            return;
        }
        if (cbCategoria.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una categoría");
            cbCategoria.requestFocus();
            return;
        }

        if (txtCodCabys.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Codigo Cabys NO valido");
            txtCodCabys.requestFocus();
            return;
        }

        btnGuardar.setEnabled(false);

        // Carga valores al VO
        articuloVO = new ArticuloVO();
        articuloVO.setNom_lar_art(txtNomLargo.getText());
        articuloVO.setNom_cor_art(txtNomCorto.getText());
        codMedida = cbMedida.getSelectedIndex();
        articuloVO.setCodMedida(codMedida);
        articuloVO.setUni_med(cbMedida.getSelectedItem().toString());
        codCategoria = cbCategoria.getSelectedIndex();
        articuloVO.setCodCategoria(codCategoria);
        articuloVO.setCod_barra(txtCodBarra.getText());
        articuloVO.setEsActivo(cbxEsActivo.isSelected());
        articuloVO.setCodCabys(txtCodCabys.getText());
        if (rbArticulo.isSelected()) {
            articuloVO.setTipo_item(1);
        } else {
            articuloVO.setTipo_item(2);
        }

        if (nuevo) { // Incluye nuevo articulo
            int codNuevo;
            try {
                codNuevo = ArticuloDAOImpl.incluir(articuloVO);
            } catch (SQLException ex) {
                Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error de conexion con el servidor");
                return;
            }
            txtCodArticulo.setText(String.valueOf(codNuevo));
            JOptionPane.showMessageDialog(this, "Articulo Incluido");

        } else {
            articuloVO.setCodigo_art(Integer.valueOf(txtCodArticulo.getText()));
            try {
                ArticuloDAOImpl.actualizar(articuloVO);
            } catch (SQLException ex) {
                Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos");
                return;
            }
            JOptionPane.showMessageDialog(this, "Articulo Modificado");
        }
        limpiaCampos();
        inactivaCampos();
        txtCodArticulo.requestFocus();


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void rbServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbServicioActionPerformed

        btnGuardar.requestFocus();
    }//GEN-LAST:event_rbServicioActionPerformed

    private void rbArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbArticuloActionPerformed

        btnGuardar.requestFocus();
    }//GEN-LAST:event_rbArticuloActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing

        Variables.frmActPro = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void txtCodCabysFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodCabysFocusGained
        txtCodCabys.selectAll();
    }//GEN-LAST:event_txtCodCabysFocusGained

    private void txtCodCabysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodCabysActionPerformed

        if (!txtCodCabys.getText().isEmpty()) {
            try {
                consultaCabys(txtCodCabys.getText().trim());
            } catch (SQLException ex) {
                Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error de conexion con servidor");
            }
        }

    }//GEN-LAST:event_txtCodCabysActionPerformed

    private void txtDesCabysFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDesCabysFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDesCabysFocusGained

    private void txtDesCabysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDesCabysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDesCabysActionPerformed

    private void cbMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMedidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMedidaActionPerformed

    private void txtCodCabysKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodCabysKeyPressed
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                buscarCabys();
            } catch (SQLException ex) {
                Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error de conexion con servidor");
            }
        }
    }//GEN-LAST:event_txtCodCabysKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgTipoItem;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JComboBox<String> cbMedida;
    private javax.swing.JCheckBox cbxEsActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAccionArticulo;
    private javax.swing.JRadioButton rbArticulo;
    private javax.swing.JRadioButton rbServicio;
    private javax.swing.JTextField txtCodArticulo;
    private javax.swing.JTextField txtCodBarra;
    private javax.swing.JTextField txtCodCabys;
    private javax.swing.JTextField txtDesCabys;
    private javax.swing.JTextField txtNomCorto;
    private javax.swing.JTextField txtNomLargo;
    // End of variables declaration//GEN-END:variables

    private void consultaArticulo() throws SQLException {
        //cabysVO= new CabysVO();
        articuloVO = new ArticuloVO();
        articuloVO.setCodigo_art(Integer.valueOf(txtCodArticulo.getText()));
        if (ArticuloDAOImpl.consultaArtxCodInt(articuloVO)) {
            nuevo = false;
            lblAccionArticulo.setText("Modifica Articulo");
            txtNomLargo.setText(articuloVO.getNom_lar_art());
            txtNomCorto.setText(articuloVO.getNom_cor_art());
            codMedida = articuloVO.getCodMedida();
            codCategoria = articuloVO.getCodCategoria();
            codCabys = articuloVO.getCodCabys();
            cbMedida.setSelectedIndex(codMedida);
            cbCategoria.setSelectedIndex(codCategoria);
            cbxEsActivo.setSelected(articuloVO.getEsActivo());
            txtCodBarra.setText(articuloVO.getCod_barra());
            if (articuloVO.getTipo_item() == 1) {
                rbArticulo.setSelected(true);
            } else {
                rbServicio.setSelected(true);
            }
            cabysVO = cabysDAO.consultaCabys(codCabys);
            txtCodCabys.setText(codCabys);
            txtDesCabys.setText(cabysVO.getDescrpcion());

            activaCampos();
            txtNomLargo.requestFocus();
        } else {
            nuevo = true;
            JOptionPane.showMessageDialog(this, "Articulo NO Existe");
            txtNomLargo.requestFocus();
        }

    }

    private void limpiaCampos() {

        txtCodArticulo.setText("");
        txtNomLargo.setText("");
        txtNomCorto.setText("");
        cbMedida.setSelectedIndex(0);
        cbCategoria.setSelectedIndex(0);
        rbArticulo.setSelected(true);
        txtCodBarra.setText("");
        txtCodCabys.setText("");
        txtDesCabys.setText("");
        cbxEsActivo.setSelected(false);
        codCabys = "";

    }

    private void activaCampos() {

        btnGuardar.setEnabled(true);
        txtNomLargo.setEnabled(true);
        txtNomCorto.setEnabled(true);
        cbMedida.setEnabled(true);
        cbCategoria.setEnabled(true);
        txtCodBarra.setEnabled(true);
        rbArticulo.setEnabled(true);
        rbServicio.setEnabled(true);
        txtCodCabys.setEnabled(true);

        cbxEsActivo.setEnabled(true);
        btnGuardar.setEnabled(true);

    }

    private void inactivaCampos() {

        txtNomLargo.setEnabled(false);
        txtNomCorto.setEnabled(false);
        cbMedida.setEnabled(false);
        cbCategoria.setEnabled(false);
        rbArticulo.setEnabled(false);
        rbServicio.setEnabled(false);
        txtCodBarra.setEnabled(false);
        txtCodCabys.setEnabled(false);

        btnGuardar.setEnabled(false);
        cbxEsActivo.setEnabled(false);
    }

    private void buscarArticulo() throws SQLException {

        BuscaItem buscaArticulo = new BuscaItem(null, true);
        buscaArticulo.setLocationRelativeTo(null);
        buscaArticulo.setVisible(true);
        String valorSelec = buscaArticulo.getCodArticulo();
        txtCodArticulo.setText(valorSelec);
        txtCodArticulo.requestFocus();

        if (!txtCodArticulo.getText().isEmpty()) {
            try {
                consultaArticulo();
            } catch (SQLException ex) {
                Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void llenarComboMedidas() {

        try {
            cbMedida.setModel(new DefaultComboBoxModel(medidasDAO.llenaComboBox()));
        } catch (SQLException ex) {
            Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void llenarComboCategorias() {

        try {
            cbCategoria.setModel(new DefaultComboBoxModel(catArticuloDAO.llenaComboBox()));
        } catch (SQLException ex) {
            Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void buscarCabys() throws SQLException {
        BuscaCabys buscar = new BuscaCabys(null, true);
        String[] valorSelec = buscar.getCodigo();
        if (valorSelec == null) {
            txtCodCabys.setText("");
            txtDesCabys.setText("");
            txtCodCabys.requestFocus();

        } else {
            txtCodCabys.setText(valorSelec[0]);
            txtDesCabys.setText(valorSelec[1]);
            btnGuardar.requestFocus();
        }

    }

    private void consultaCabys(String codigo) throws SQLException {

        cabysVO = cabysDAO.consultaCabys(codigo);
        if (cabysVO == null) {
            JOptionPane.showMessageDialog(this, "Cabys NO existe");

            return;
        }
        //txtCodCabys.setText(cabysVO.getCodigo());
        txtDesCabys.setText(cabysVO.getDescrpcion());

    }

}
