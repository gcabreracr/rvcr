/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;



import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.VO.AgenciaVO;
import modelo.VO.ClienteVO;
import modelo.FiltrarTablas;
import modelo.VO.PdvVO;
import modelo.DAO.AgenciaDAOImpl;
import modelo.DAO.ClienteDAOImpl;
import modelo.DAO.PdvDAOImpl;
import modelo.Validar;
import modelo.Variables;

/**
 *
 * @author Gonzalo Cabrera 
 * 21 Agosto 2019
 * 
 */
public class BuscaCliente extends javax.swing.JDialog {
    private final String codCliente;
    Validar valida = new Validar();
    DefaultTableModel dtmClientes;
    FiltrarTablas filtraTabla;
    String valorRetorno;
 
 
    public BuscaCliente(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        valida.limitarCaracteres(txtCodAge, Variables.L_COD_AGE);
        valida.soloNumeros(txtCodAge);
        valida.soloNumeros(txtCodPdv);
        valida.limitarCaracteres(txtCodPdv, Variables.L_COD_PDV);
        jtClientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouse_evt) {
                if(mouse_evt.getClickCount()==2){
                    seleccionaCliente();
                }
            }
        });
        filtraTabla = new FiltrarTablas();

        codCliente = "";
        txtCodAge.setText(String.valueOf(Variables.mAGEUSU));
        lblNomAge.setText(Variables.mNOMAGEUSU);
        txtCodPdv.setText(String.valueOf(Variables.mPDVUSU));
        lblNomPdv.setText(Variables.mNOMPDVUSU);
        if(Variables.mTIPOUSU<4){
            this.txtCodAge.setEnabled(false);
            this.txtCodPdv.requestFocus();
        }
        if(Variables.mTIPOUSU==1){
            txtCodPdv.setEnabled(false);
            txtBuscar.requestFocus();
        }
        llenarTabla();
        
    }
    
    public String getCodCliente(){       
       
        return valorRetorno;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        txtCodAge = new javax.swing.JTextField();
        lblNomAge = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCodPdv = new javax.swing.JTextField();
        lblNomPdv = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtClientes = new javax.swing.JTable();
        btnSelecciona = new javax.swing.JButton();
        btnCancela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Busqueda Cliente Comercial (TODOS)");

        jLabel13.setText("Agencia");

        txtCodAge.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodAgeFocusGained(evt);
            }
        });
        txtCodAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodAgeActionPerformed(evt);
            }
        });
        txtCodAge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodAgeKeyTyped(evt);
            }
        });

        lblNomAge.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel14.setText("Ruta/ Pdv");

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

        lblNomPdv.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setText("Buscar");

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        jtClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nombre Comercial", "Direccion"
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
        jtClientes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtClientesMouseClicked(evt);
            }
        });
        jtClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtClientesKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtClientesKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jtClientes);
        if (jtClientes.getColumnModel().getColumnCount() > 0) {
            jtClientes.getColumnModel().getColumn(0).setResizable(false);
            jtClientes.getColumnModel().getColumn(0).setPreferredWidth(50);
            jtClientes.getColumnModel().getColumn(1).setResizable(false);
            jtClientes.getColumnModel().getColumn(1).setPreferredWidth(200);
            jtClientes.getColumnModel().getColumn(2).setResizable(false);
            jtClientes.getColumnModel().getColumn(2).setPreferredWidth(400);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodAge, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNomAge, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodPdv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNomPdv, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSelecciona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(55, 55, 55))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSelecciona)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCodAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13))
                    .addComponent(lblNomAge, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtCodPdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblNomPdv, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCancela))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodAgeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodAgeFocusGained
        // TODO add your handling code here:
        this.txtCodAge.selectAll();
    }//GEN-LAST:event_txtCodAgeFocusGained

    private void txtCodAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodAgeActionPerformed
        // TODO add your handling code here:
       
        try {
            consultarAgencia();
        } catch (SQLException ex) {
            Logger.getLogger(BuscaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtCodAgeActionPerformed

    private void txtCodAgeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodAgeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodAgeKeyTyped

    private void txtCodPdvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodPdvFocusGained
        // TODO add your handling code here:
        this.txtCodPdv.selectAll();
    }//GEN-LAST:event_txtCodPdvFocusGained

    private void txtCodPdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodPdvActionPerformed
  
        if(this.txtCodPdv.getText().length()==0){
            JOptionPane.showMessageDialog(rootPane, "Debe digitar un codigo de PDV/Ruta");
            this.txtCodPdv.requestFocus();
            return;
        }
        try {
            consultarPdv();
        } catch (SQLException ex) {
            Logger.getLogger(BuscaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtCodPdvActionPerformed

    private void btnCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelaActionPerformed
        
        valorRetorno="";
        dispose();
    }//GEN-LAST:event_btnCancelaActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed

    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
      
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
       
       filtraTabla.filtro(txtBuscar.getText(), jtClientes,1);
   
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void jtClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtClientesMouseClicked
       
            
        
    }//GEN-LAST:event_jtClientesMouseClicked

    private void btnSeleccionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionaActionPerformed
             
       seleccionaCliente();

    }//GEN-LAST:event_btnSeleccionaActionPerformed

    private void jtClientesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtClientesKeyTyped
       
        
        
    }//GEN-LAST:event_jtClientesKeyTyped

    private void jtClientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtClientesKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            seleccionaCliente();
        }
    }//GEN-LAST:event_jtClientesKeyPressed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancela;
    private javax.swing.JButton btnSelecciona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtClientes;
    private javax.swing.JLabel lblNomAge;
    private javax.swing.JLabel lblNomPdv;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodAge;
    private javax.swing.JTextField txtCodPdv;
    // End of variables declaration//GEN-END:variables

    private void consultarPdv() throws SQLException {
       PdvVO pdv = new PdvVO();
        pdv.setCodAgencia(Integer.valueOf(txtCodAge.getText()));
        pdv.setCodPdv(Integer.valueOf(txtCodPdv.getText()));

        if(PdvDAOImpl.consultar(pdv)){
            
            this.lblNomPdv.setText(pdv.getNomPdv());
            if(txtCodAge.getText().length()>0){
                llenarTabla();
            }
            txtBuscar.requestFocus();
        }else{
            JOptionPane.showMessageDialog(rootPane, "PDV/Ruta no existe");
            txtCodPdv.requestFocus();
        }  
        
        
    }
    
   

    private void consultarAgencia() throws SQLException {
        AgenciaVO agencia=new AgenciaVO();
        agencia.setCodagencia(Integer.valueOf(txtCodAge.getText()));
        
        if(AgenciaDAOImpl.consultar(agencia)){
            
            this.lblNomAge.setText(agencia.getNomagencia());
            if(txtCodPdv.getText().length()>0){
                llenarTabla();
            }
            
            this.txtCodPdv.requestFocus();
        }else{
            JOptionPane.showMessageDialog(null, "Agencia no existe");
            txtCodAge.requestFocus();
        }    
        
    }

    private void llenarTabla() throws SQLException {
   
     
        dtmClientes = new DefaultTableModel(){

            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
            
        };
       // jtClientes=new JTable();       
        dtmClientes.addColumn("Codigo");
        dtmClientes.addColumn("Nombre Comercial");
        dtmClientes.addColumn("Direccion");
        
        // LLenamos el array desde la base de datos
        int age = Integer.valueOf(txtCodAge.getText());
        int pdv = Integer.valueOf(txtCodPdv.getText());
        ArrayList<ClienteVO> listaClientes = ClienteDAOImpl.listarClientesTable(age, pdv);
       
        
        Object[] fila = new Object[3];
        for (int i = 0; i < listaClientes.size(); i++) {
            fila[0] = String.valueOf(listaClientes.get(i).getCod_cliente());
            fila[1] = listaClientes.get(i).getNom_cliente();
            String direccion = listaClientes.get(i).getProvincia() + ", " + listaClientes.get(i).getCanton() + ", " + listaClientes.get(i).getDistrito()
                    + ", " + listaClientes.get(i).getReferencia();
            fila[2] = direccion;
            dtmClientes.addRow(fila);
        }
        jtClientes.setModel(dtmClientes);

        jScrollPane1.setViewportView(jtClientes);       
        if (jtClientes.getColumnModel().getColumnCount() > 0) {
            jtClientes.getColumnModel().getColumn(0).setResizable(false);
            jtClientes.getColumnModel().getColumn(0).setPreferredWidth(50);
            jtClientes.getColumnModel().getColumn(1).setResizable(false);
            jtClientes.getColumnModel().getColumn(1).setPreferredWidth(200);
            jtClientes.getColumnModel().getColumn(2).setResizable(false);
            jtClientes.getColumnModel().getColumn(2).setPreferredWidth(400);
        }
        
    }

    private void seleccionaCliente() {

        if (jtClientes.getSelectedColumnCount() > 0) {

            int viewRow = jtClientes.getSelectedRow();
            if (viewRow < 0) {
                valorRetorno = (String) dtmClientes.getValueAt(viewRow, 0);
            } else {
                int modelRow = jtClientes.convertRowIndexToModel(viewRow);
                valorRetorno = (String) dtmClientes.getValueAt(modelRow, 0);
            }

            dispose();
        }
    }

    
}
