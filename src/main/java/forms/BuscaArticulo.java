package forms;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.VO.ArticuloVO;
import modelo.FiltrarTablas;
import modelo.DAO.ArticuloDAOImpl;

public class BuscaArticulo extends javax.swing.JDialog {

    public String valorRetorno;
    DefaultTableModel dtmArticulos;
    FiltrarTablas filtraTabla;

    public BuscaArticulo(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        
      

        filtraTabla = new FiltrarTablas();

        llenarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtArticulos = new javax.swing.JTable();
        btnSelecciona = new javax.swing.JButton();
        btnCancela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Busqueda de articulos");
        setResizable(false);

        jLabel1.setText("Buscar");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jtArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
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
            jtArticulos.getColumnModel().getColumn(0).setPreferredWidth(50);
            jtArticulos.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        btnSelecciona.setText("Seleccionar");
        btnSelecciona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionaActionPerformed(evt);
            }
        });

        btnCancela.setText("Cancelar");
        btnCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 85, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSelecciona)
                    .addComponent(btnCancela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btnSelecciona)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancela)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelaActionPerformed
        valorRetorno = "";
        dispose();
    }//GEN-LAST:event_btnCancelaActionPerformed

    private void btnSeleccionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionaActionPerformed

        seleccionaArticulo();
    }//GEN-LAST:event_btnSeleccionaActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased

        filtraTabla.filtro(txtBuscar.getText(), jtArticulos, 1);
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void jtArticulosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtArticulosMousePressed

        if (evt.getClickCount() == 2) {
            seleccionaArticulo();
        }
    }//GEN-LAST:event_jtArticulosMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancela;
    private javax.swing.JButton btnSelecciona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtArticulos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    public String getCodArticulo() {
        return valorRetorno;
    }

    private void llenarTabla() throws SQLException {
        dtmArticulos = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }

        };
        // jtArticulos=new JTable();       
        dtmArticulos.addColumn("Codigo");
        dtmArticulos.addColumn("Descripcion");
        jtArticulos.setModel(dtmArticulos);

        ArrayList<ArticuloVO> listaArticulos = ArticuloDAOImpl.listarArticuloTable();

        Object[] fila = new Object[2];
        for (ArticuloVO listaArticulo : listaArticulos) {
            fila[0] = String.valueOf(listaArticulo.getCodigo_art());
            fila[1] = listaArticulo.getNom_lar_art();
            dtmArticulos.addRow(fila);
        }

        jScrollPane1.setViewportView(jtArticulos);
        if (jtArticulos.getColumnModel().getColumnCount() > 0) {
            jtArticulos.getColumnModel().getColumn(0).setResizable(false);
            jtArticulos.getColumnModel().getColumn(0).setPreferredWidth(50);
            jtArticulos.getColumnModel().getColumn(1).setResizable(false);
            jtArticulos.getColumnModel().getColumn(1).setPreferredWidth(300);
        }
    }

    private void seleccionaArticulo() {

        if (jtArticulos.getSelectedColumnCount() > 0) {
            int viewRow = jtArticulos.getSelectedRow();
            if (viewRow < 0) {
                valorRetorno = (String) dtmArticulos.getValueAt(viewRow, 0);
            } else {
                int modelRow = jtArticulos.convertRowIndexToModel(viewRow);
                valorRetorno = (String) dtmArticulos.getValueAt(modelRow, 0);
            }
            dispose();
        }

    }
}
