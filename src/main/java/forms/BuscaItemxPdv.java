package forms;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import metodos.Redondear;
import modelo.FiltrarTablas;
import modelo.VO.ItemListaVO;
import modelo.DAO.PrecioDAOImpl;

public class BuscaItemxPdv extends javax.swing.JDialog {

    DecimalFormat decimalFormat = new DecimalFormat("####,##0.00");
    public String valorRetorno;
    DefaultTableModel dtmArticulos;
    FiltrarTablas filtraTabla;
    int mCatPdv;

    public BuscaItemxPdv(java.awt.Frame parent, boolean modal, int catPdv) throws SQLException {
        super(parent, modal);
        initComponents();
        mCatPdv = catPdv;
        jtArticulos.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouse_evt) {
                if (mouse_evt.getClickCount() == 2) {
                    seleccionaArticulo();
                }
            }
        });

        filtraTabla = new FiltrarTablas();

        llenarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        setTitle("Busqueda Items x PDV");

        jLabel1.setText("Buscar");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jtArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(jtArticulos);
        if (jtArticulos.getColumnModel().getColumnCount() > 0) {
            jtArticulos.getColumnModel().getColumn(0).setResizable(false);
            jtArticulos.getColumnModel().getColumn(0).setPreferredWidth(20);
            jtArticulos.getColumnModel().getColumn(1).setResizable(false);
            jtArticulos.getColumnModel().getColumn(1).setPreferredWidth(200);
            jtArticulos.getColumnModel().getColumn(2).setResizable(false);
            jtArticulos.getColumnModel().getColumn(2).setPreferredWidth(50);
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
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancela, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelecciona))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnSelecciona)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancela))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
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
        dtmArticulos.addColumn("Precio");
        jtArticulos.setModel(dtmArticulos);

        ArrayList<ItemListaVO> listaArticulos = PrecioDAOImpl.listaArticuloPDV(mCatPdv);

        Object[] fila = new Object[3];
        for (ItemListaVO itemPrecio : listaArticulos) {
            fila[0] = String.valueOf(itemPrecio.getCodigo_art());
            fila[1] = itemPrecio.getNombre_art();
            double iSubTotal = itemPrecio.getPrecio_art();
            double iImpto = iSubTotal * itemPrecio.getImpto_art() / 100;
            int mRedondeo = itemPrecio.getRedondeo();
            double precio = Redondear.decimal((iSubTotal + iImpto), mRedondeo);
            String sPrecio = decimalFormat.format(precio);
            fila[2] = sPrecio;
            dtmArticulos.addRow(fila);
        }

        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.RIGHT);
        jScrollPane1.setViewportView(jtArticulos);
        if (jtArticulos.getColumnModel().getColumnCount() > 0) {
            jtArticulos.getColumnModel().getColumn(0).setResizable(false);
            jtArticulos.getColumnModel().getColumn(0).setPreferredWidth(20);
            jtArticulos.getColumnModel().getColumn(1).setResizable(false);
            jtArticulos.getColumnModel().getColumn(1).setPreferredWidth(200);
            jtArticulos.getColumnModel().getColumn(2).setResizable(false);
            jtArticulos.getColumnModel().getColumn(2).setPreferredWidth(50);
            jtArticulos.getColumnModel().getColumn(2).setCellRenderer(dtcr);
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
