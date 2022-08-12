
package forms;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import modelo.Variables;
import static modelo.Variables.frmAceptaXml;
import static modelo.Variables.frmAceptaXmlNC;
import static modelo.Variables.frmActPre;
import static modelo.Variables.frmActPro;
import static modelo.Variables.frmAnuFac;
import static modelo.Variables.frmCambiaPin;
import static modelo.Variables.frmCarDia;
import static modelo.Variables.frmClientes;
import static modelo.Variables.frmEmiFac;
import static modelo.Variables.frmEmiNC;
import static modelo.Variables.frmEstLiq;
import static modelo.Variables.frmFactCompra;
import static modelo.Variables.frmPdvs;
import static modelo.Variables.frmReenvioFac;
import static modelo.Variables.frmReimprimeFac;
import static modelo.Variables.frmUsuarios;
import static modelo.Variables.FRM_AGENCIAS;
import static modelo.Variables.frmLogin;

public class VentanaPrincipal extends javax.swing.JFrame {

    public VentanaPrincipal() throws IOException {
        initComponents();

         setVisible(true);
         setExtendedState(MAXIMIZED_BOTH);

        if (Variables.mCODUSU == null) {
            frmLogin = new Login(this, true);
            frmLogin.setLocationRelativeTo(null);
            frmLogin.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInferior = new javax.swing.JPanel();
        lbCopyRigth = new javax.swing.JLabel();
        ImageIcon icon=new ImageIcon(getClass().getResource("/img/rv_logo.jpg"));
        Image image= icon.getImage();
        escritorio = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }

        };
        jmbPrincipal = new javax.swing.JMenuBar();
        jmnArchivo = new javax.swing.JMenu();
        jmnClientes = new javax.swing.JMenu();
        jmnActDatos = new javax.swing.JMenuItem();
        jmnRepCli = new javax.swing.JMenuItem();
        jmnArticulos = new javax.swing.JMenu();
        jmnActProd = new javax.swing.JMenuItem();
        jmnActPrecios = new javax.swing.JMenuItem();
        jmnAgencias = new javax.swing.JMenuItem();
        jmnPdvs = new javax.swing.JMenuItem();
        jmnUsuarios = new javax.swing.JMenuItem();
        jmiSalir = new javax.swing.JMenuItem();
        jmnFacturacion = new javax.swing.JMenu();
        jmnEmiFac = new javax.swing.JMenuItem();
        jmnAnuFac = new javax.swing.JMenuItem();
        jmnReimprimeFacturas = new javax.swing.JMenuItem();
        jmnFE = new javax.swing.JMenu();
        jmnFE_AceRecFac = new javax.swing.JMenu();
        jmn_AceRecFac = new javax.swing.JMenuItem();
        jme_AceRecNC = new javax.swing.JMenuItem();
        jmnFE_ReeFacRec = new javax.swing.JMenuItem();
        jmnFE_NC = new javax.swing.JMenuItem();
        jmnFE_ND = new javax.swing.JMenuItem();
        jmnFE_FacCom = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmnRepFac = new javax.swing.JMenu();
        jmnRepFacEmi = new javax.swing.JMenuItem();
        jmnRepNC = new javax.swing.JMenuItem();
        jmnRepND = new javax.swing.JMenuItem();
        jmnRepFacCom = new javax.swing.JMenuItem();
        jmnLiquidacion = new javax.swing.JMenu();
        jmnLiqCarDia = new javax.swing.JMenuItem();
        jmnLiqConEst = new javax.swing.JMenuItem();
        jmnSistema = new javax.swing.JMenu();
        jmnCambiaUsu = new javax.swing.JMenuItem();
        jmnCambiaPin = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Facturacion y Ejecucion PDV's");
        setExtendedState(6);
        setIconImage(getIconImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });

        panelInferior.setBackground(new java.awt.Color(0, 102, 102));
        panelInferior.setPreferredSize(new java.awt.Dimension(897, 25));

        lbCopyRigth.setBackground(new java.awt.Color(0, 153, 153));
        lbCopyRigth.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbCopyRigth.setForeground(new java.awt.Color(255, 255, 255));
        lbCopyRigth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCopyRigth.setText("Derechos Reservados 2020 - Gonzalo Cabrera");
        panelInferior.add(lbCopyRigth);

        getContentPane().add(panelInferior, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 917, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 651, Short.MAX_VALUE)
        );

        getContentPane().add(escritorio, java.awt.BorderLayout.CENTER);

        jmbPrincipal.setEnabled(false);

        jmnArchivo.setText("Archivo");

        jmnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Usuarios.png"))); // NOI18N
        jmnClientes.setText("Clientes");

        jmnActDatos.setText("Actualizacion datos");
        jmnActDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnActDatosActionPerformed(evt);
            }
        });
        jmnClientes.add(jmnActDatos);

        jmnRepCli.setText("Reporte de clientes");
        jmnClientes.add(jmnRepCli);

        jmnArchivo.add(jmnClientes);

        jmnArticulos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Items.png"))); // NOI18N
        jmnArticulos.setText("Items");

        jmnActProd.setText("Actualiza Items");
        jmnActProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnActProdActionPerformed(evt);
            }
        });
        jmnArticulos.add(jmnActProd);

        jmnActPrecios.setText("Actualiza Precios");
        jmnActPrecios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnActPreciosActionPerformed(evt);
            }
        });
        jmnArticulos.add(jmnActPrecios);

        jmnArchivo.add(jmnArticulos);

        jmnAgencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Locales.png"))); // NOI18N
        jmnAgencias.setText("Agencias");
        jmnAgencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnAgenciasActionPerformed(evt);
            }
        });
        jmnArchivo.add(jmnAgencias);

        jmnPdvs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/PDV.png"))); // NOI18N
        jmnPdvs.setText("PDV");
        jmnPdvs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnPdvsActionPerformed(evt);
            }
        });
        jmnArchivo.add(jmnPdvs);

        jmnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Usuarios.png"))); // NOI18N
        jmnUsuarios.setText("Usuarios");
        jmnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnUsuariosActionPerformed(evt);
            }
        });
        jmnArchivo.add(jmnUsuarios);

        jmiSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Salir.png"))); // NOI18N
        jmiSalir.setText("Salir");
        jmiSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSalirActionPerformed(evt);
            }
        });
        jmnArchivo.add(jmiSalir);

        jmbPrincipal.add(jmnArchivo);

        jmnFacturacion.setText("Facturacion");

        jmnEmiFac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Documento.png"))); // NOI18N
        jmnEmiFac.setText("Emision facturas");
        jmnEmiFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnEmiFacActionPerformed(evt);
            }
        });
        jmnFacturacion.add(jmnEmiFac);

        jmnAnuFac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cancelar.png"))); // NOI18N
        jmnAnuFac.setText("Anula facturas");
        jmnAnuFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnAnuFacActionPerformed(evt);
            }
        });
        jmnFacturacion.add(jmnAnuFac);

        jmnReimprimeFacturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Documento.png"))); // NOI18N
        jmnReimprimeFacturas.setText("Re-Impresion Facturas");
        jmnReimprimeFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnReimprimeFacturasActionPerformed(evt);
            }
        });
        jmnFacturacion.add(jmnReimprimeFacturas);

        jmnFE.setText("Facturacion Electronica");

        jmnFE_AceRecFac.setText("Aceptacion/Rechazo Documentos");

        jmn_AceRecFac.setText("Aceptacion/Rechazo Facturas");
        jmn_AceRecFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmn_AceRecFacActionPerformed(evt);
            }
        });
        jmnFE_AceRecFac.add(jmn_AceRecFac);

        jme_AceRecNC.setText("Aceptacion/Rechazo NC");
        jme_AceRecNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jme_AceRecNCActionPerformed(evt);
            }
        });
        jmnFE_AceRecFac.add(jme_AceRecNC);

        jmnFE.add(jmnFE_AceRecFac);

        jmnFE_ReeFacRec.setText("Reenvio facturas rechazadas");
        jmnFE_ReeFacRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnFE_ReeFacRecActionPerformed(evt);
            }
        });
        jmnFE.add(jmnFE_ReeFacRec);

        jmnFE_NC.setText("Emision Notas de Credito");
        jmnFE_NC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnFE_NCActionPerformed(evt);
            }
        });
        jmnFE.add(jmnFE_NC);

        jmnFE_ND.setText("Emision Notas de Debito");
        jmnFE.add(jmnFE_ND);

        jmnFE_FacCom.setText("Emison Facturas de Compras");
        jmnFE_FacCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnFE_FacComActionPerformed(evt);
            }
        });
        jmnFE.add(jmnFE_FacCom);

        jmnFacturacion.add(jmnFE);
        jmnFacturacion.add(jSeparator1);

        jmnRepFac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Reportes.png"))); // NOI18N
        jmnRepFac.setText("Reportes");

        jmnRepFacEmi.setText("Facturas emitidas");
        jmnRepFac.add(jmnRepFacEmi);

        jmnRepNC.setText("Notas de Credito");
        jmnRepFac.add(jmnRepNC);

        jmnRepND.setText("Notas de Debito");
        jmnRepFac.add(jmnRepND);

        jmnRepFacCom.setText("Facturas de Compra");
        jmnRepFac.add(jmnRepFacCom);

        jmnFacturacion.add(jmnRepFac);

        jmbPrincipal.add(jmnFacturacion);

        jmnLiquidacion.setBackground(new java.awt.Color(0, 153, 153));
        jmnLiquidacion.setText("Liquidacion");

        jmnLiqCarDia.setText("Actualiza Carga Diaria");
        jmnLiqCarDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnLiqCarDiaActionPerformed(evt);
            }
        });
        jmnLiquidacion.add(jmnLiqCarDia);

        jmnLiqConEst.setText("Estado Liquidacion");
        jmnLiqConEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnLiqConEstActionPerformed(evt);
            }
        });
        jmnLiquidacion.add(jmnLiqConEst);

        jmbPrincipal.add(jmnLiquidacion);

        jmnSistema.setText("Sistema");
        jmnSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnSistemaActionPerformed(evt);
            }
        });

        jmnCambiaUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cambiausuario.png"))); // NOI18N
        jmnCambiaUsu.setText("Cambiar Usuario");
        jmnCambiaUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnCambiaUsuActionPerformed(evt);
            }
        });
        jmnSistema.add(jmnCambiaUsu);

        jmnCambiaPin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Contraseña.png"))); // NOI18N
        jmnCambiaPin.setText("Cambiar PIN");
        jmnCambiaPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnCambiaPinActionPerformed(evt);
            }
        });
        jmnSistema.add(jmnCambiaPin);

        jmbPrincipal.add(jmnSistema);

        setJMenuBar(jmbPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jmnAgenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnAgenciasActionPerformed

        if (FRM_AGENCIAS == null) {
            FRM_AGENCIAS = new Agencias();
            Dimension ds = this.escritorio.getSize();
            Dimension fs = FRM_AGENCIAS.getSize();
            FRM_AGENCIAS.setLocation((ds.width - fs.width) / 2, (ds.height - fs.height) / 2);
            //this.escritorio.add(FRM_AGENCIAS);
            escritorio.add(FRM_AGENCIAS, CENTER_ALIGNMENT);
            FRM_AGENCIAS.show();
        } else {
            FRM_AGENCIAS.toFront();
            FRM_AGENCIAS.restoreSubcomponentFocus();
        }
    }//GEN-LAST:event_jmnAgenciasActionPerformed

    private void jmnSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnSistemaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmnSistemaActionPerformed

    private void jmnCambiaUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnCambiaUsuActionPerformed

        try {
            frmLogin = new Login(this, true);
        } catch (IOException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        frmLogin.setLocationRelativeTo(null);
        frmLogin.setVisible(true);
        //frmLogin.toFront();
    }//GEN-LAST:event_jmnCambiaUsuActionPerformed

    private void jmnPdvsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnPdvsActionPerformed

        if (frmPdvs == null) {
            frmPdvs = new Pdvs();
            Dimension ds = this.escritorio.getSize();
            Dimension fs = frmPdvs.getSize();
            frmPdvs.setLocation((ds.width - fs.width) / 2, (ds.height - fs.height) / 2);
            this.escritorio.add(frmPdvs);
            frmPdvs.show();
        } else {
            frmPdvs.toFront();
            frmPdvs.restoreSubcomponentFocus();
        }

    }//GEN-LAST:event_jmnPdvsActionPerformed

    private void jmnFE_ReeFacRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnFE_ReeFacRecActionPerformed

        if (frmReenvioFac == null) {

            frmReenvioFac = new ReenvioFactura();
            Dimension ds = this.escritorio.getSize();
            Dimension fs = frmReenvioFac.getSize();
            frmReenvioFac.setLocation((ds.width - fs.width) / 2, (ds.height - fs.height) / 2);
            this.escritorio.add(frmReenvioFac);
            frmReenvioFac.show();
        } else {
            frmReenvioFac.toFront();
            frmReenvioFac.restoreSubcomponentFocus();
        }

    }//GEN-LAST:event_jmnFE_ReeFacRecActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated


    }//GEN-LAST:event_formWindowActivated

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated


    }//GEN-LAST:event_formWindowDeactivated

    private void jmnActDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnActDatosActionPerformed

        if (frmClientes == null) {
            frmClientes = new Clientes();
            Dimension ds = this.escritorio.getSize();
            Dimension fs = frmClientes.getSize();
            frmClientes.setLocation((ds.width - fs.width) / 2, (ds.height - fs.height) / 2);
            this.escritorio.add(frmClientes);
            frmClientes.show();
        } else {
            frmClientes.toFront();
            frmClientes.restoreSubcomponentFocus();
        }


    }//GEN-LAST:event_jmnActDatosActionPerformed

    private void jmnLiqCarDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnLiqCarDiaActionPerformed

        if (frmCarDia == null) {
            frmCarDia = new CargaDiaria();
            Dimension ds = this.escritorio.getSize();
            Dimension fs = frmCarDia.getSize();
            frmCarDia.setLocation((ds.width - fs.width) / 2, (ds.height - fs.height) / 2);
            escritorio.add(frmCarDia);
            frmCarDia.show();

        } else {
            frmCarDia.toFront();
            frmCarDia.restoreSubcomponentFocus();
        }

    }//GEN-LAST:event_jmnLiqCarDiaActionPerformed

    private void jmnAnuFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnAnuFacActionPerformed

        if (frmAnuFac == null) {
            frmAnuFac = new AnulaFactura();
            Dimension ds = this.escritorio.getSize();
            Dimension fs = frmAnuFac.getSize();
            frmAnuFac.setLocation((ds.width - fs.width) / 2, (ds.height - fs.height) / 2);
            this.escritorio.add(frmAnuFac);
            frmAnuFac.show();
        } else {

            frmAnuFac.toFront();
            frmAnuFac.restoreSubcomponentFocus();
        }
    }//GEN-LAST:event_jmnAnuFacActionPerformed

    private void jmnLiqConEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnLiqConEstActionPerformed

        if (frmEstLiq == null) {
            frmEstLiq = new EstadoLiq();
            Dimension ds = this.escritorio.getSize();
            Dimension fs = frmEstLiq.getSize();
            frmEstLiq.setLocation((ds.width - fs.width) / 2, (ds.height - fs.height) / 2);
            this.escritorio.add(frmEstLiq);
            frmEstLiq.show();
        } else {
            frmEstLiq.toFront();
            frmEstLiq.restoreSubcomponentFocus();
        }


    }//GEN-LAST:event_jmnLiqConEstActionPerformed

    private void jmnEmiFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnEmiFacActionPerformed

        if (frmEmiFac == null) {
            frmEmiFac = new EmiteFactura();
            Dimension ds = this.escritorio.getSize();
            Dimension fs = frmEmiFac.getSize();
            frmEmiFac.setLocation((ds.width - fs.width) / 2, (ds.height - fs.height) / 2);
            this.escritorio.add(frmEmiFac);
            frmEmiFac.show();
        } else {

            frmEmiFac.toFront();
            frmEmiFac.restoreSubcomponentFocus();
        }

    }//GEN-LAST:event_jmnEmiFacActionPerformed

    private void jmnActProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnActProdActionPerformed

        if (frmActPro == null) {
            frmActPro = new Articulos();
            Dimension ds = this.escritorio.getSize();
            Dimension fs = frmActPro.getSize();
            frmActPro.setLocation((ds.width - fs.width) / 2, (ds.height - fs.height) / 2);
            this.escritorio.add(frmActPro);
            frmActPro.show();
        } else {
            frmActPro.toFront();
            frmActPro.restoreSubcomponentFocus();
        }
    }//GEN-LAST:event_jmnActProdActionPerformed

    private void jmnActPreciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnActPreciosActionPerformed

        if (frmActPre == null) {
            frmActPre = new Precios();
            Dimension ds = this.escritorio.getSize();
            Dimension fs = frmActPre.getSize();
            frmActPre.setLocation((ds.width - fs.width) / 2, (ds.height - fs.height) / 2);
            this.escritorio.add(frmActPre);
            frmActPre.show();
        } else {
            frmActPre.toFront();
            frmActPre.restoreSubcomponentFocus();

        }
    }//GEN-LAST:event_jmnActPreciosActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void jmnCambiaPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnCambiaPinActionPerformed

        if (frmCambiaPin == null) {
            frmCambiaPin = new CambiarPin();
            Dimension ds = this.escritorio.getSize();
            Dimension fs = frmCambiaPin.getSize();
            frmCambiaPin.setLocation((ds.width - fs.width) / 2, (ds.height - fs.height) / 2);
            this.escritorio.add(frmCambiaPin);
            frmCambiaPin.show();
        } else {
            frmCambiaPin.toFront();
            frmCambiaPin.restoreSubcomponentFocus();
        }
    }//GEN-LAST:event_jmnCambiaPinActionPerformed

    private void jmnReimprimeFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnReimprimeFacturasActionPerformed

        if (frmReimprimeFac == null) {
            frmReimprimeFac = new ReimpresionFacturas();
            Dimension ds = this.escritorio.getSize();
            Dimension fs = frmReimprimeFac.getSize();
            frmReimprimeFac.setLocation((ds.width - fs.width) / 2, (ds.height - fs.height) / 2);
            this.escritorio.add(frmReimprimeFac);
            frmReimprimeFac.show();
        } else {
            frmReimprimeFac.toFront();
            frmReimprimeFac.restoreSubcomponentFocus();
        }
    }//GEN-LAST:event_jmnReimprimeFacturasActionPerformed

    private void jmnFE_NCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnFE_NCActionPerformed

        if (frmEmiNC == null) {
            frmEmiNC = new EmiteNotaCredito();
            Dimension ds = this.escritorio.getSize();
            Dimension fs = frmEmiNC.getSize();
            frmEmiNC.setLocation((ds.width - fs.width) / 2, (ds.height - fs.height) / 2);
            this.escritorio.add(frmEmiNC);
            frmEmiNC.show();
        } else {
            frmEmiNC.toFront();
            frmEmiNC.restoreSubcomponentFocus();
        }


    }//GEN-LAST:event_jmnFE_NCActionPerformed

    private void jmnFE_FacComActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnFE_FacComActionPerformed

        if (frmFactCompra == null) {
            frmFactCompra = new FacturaCompras();
            Dimension ds = this.escritorio.getSize();
            Dimension fs = frmFactCompra.getSize();
            frmFactCompra.setLocation((ds.width - fs.width) / 2, (ds.height - fs.height) / 2);
            this.escritorio.add(frmFactCompra);
            frmFactCompra.show();
        } else {
            frmFactCompra.toFront();
            frmFactCompra.restoreSubcomponentFocus();
        }
    }//GEN-LAST:event_jmnFE_FacComActionPerformed

    private void jmn_AceRecFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmn_AceRecFacActionPerformed

        if (frmAceptaXml == null) {
            frmAceptaXml = new AceptaXml();
            Dimension ds = this.escritorio.getSize();
            Dimension fs = frmAceptaXml.getSize();
            frmAceptaXml.setLocation((ds.width - fs.width) / 2, (ds.height - fs.height) / 2);
            this.escritorio.add(frmAceptaXml);
            frmAceptaXml.show();
        } else {
            frmAceptaXml.toFront();
            frmAceptaXml.restoreSubcomponentFocus();
        }
    }//GEN-LAST:event_jmn_AceRecFacActionPerformed

    private void jme_AceRecNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jme_AceRecNCActionPerformed

        if (frmAceptaXmlNC == null) {
            frmAceptaXmlNC = new AceptaXmlNC();
            Dimension ds = this.escritorio.getSize();
            Dimension fs = frmAceptaXmlNC.getSize();
            frmAceptaXmlNC.setLocation((ds.width - fs.width) / 2, (ds.height - fs.height) / 2);
            this.escritorio.add(frmAceptaXmlNC);
            frmAceptaXmlNC.show();
        } else {
            frmAceptaXmlNC.toFront();
            frmAceptaXmlNC.restoreSubcomponentFocus();
        }
    }//GEN-LAST:event_jme_AceRecNCActionPerformed

    private void jmnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnUsuariosActionPerformed

        if (frmUsuarios == null) {
            frmUsuarios = new Usuarios();
            Dimension ds = this.escritorio.getSize();
            Dimension fs = frmUsuarios.getSize();
            frmUsuarios.setLocation((ds.width - fs.width) / 2, (ds.height - fs.height) / 2);
            this.escritorio.add(frmUsuarios);
            frmUsuarios.show();
        } else {
            frmUsuarios.toFront();
            frmUsuarios.restoreSubcomponentFocus();
        }
    }//GEN-LAST:event_jmnUsuariosActionPerformed

    private void jmiSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jmiSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane escritorio;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    public javax.swing.JMenuBar jmbPrincipal;
    public javax.swing.JMenuItem jme_AceRecNC;
    private javax.swing.JMenuItem jmiSalir;
    public javax.swing.JMenuItem jmnActDatos;
    public javax.swing.JMenuItem jmnActPrecios;
    public javax.swing.JMenuItem jmnActProd;
    public javax.swing.JMenuItem jmnAgencias;
    public static javax.swing.JMenuItem jmnAnuFac;
    public javax.swing.JMenu jmnArchivo;
    private javax.swing.JMenu jmnArticulos;
    private javax.swing.JMenuItem jmnCambiaPin;
    private javax.swing.JMenuItem jmnCambiaUsu;
    private javax.swing.JMenu jmnClientes;
    public javax.swing.JMenuItem jmnEmiFac;
    public javax.swing.JMenu jmnFE;
    public javax.swing.JMenu jmnFE_AceRecFac;
    public javax.swing.JMenuItem jmnFE_FacCom;
    public javax.swing.JMenuItem jmnFE_NC;
    public javax.swing.JMenuItem jmnFE_ND;
    public javax.swing.JMenuItem jmnFE_ReeFacRec;
    public javax.swing.JMenu jmnFacturacion;
    public javax.swing.JMenuItem jmnLiqCarDia;
    public javax.swing.JMenuItem jmnLiqConEst;
    public javax.swing.JMenu jmnLiquidacion;
    public javax.swing.JMenuItem jmnPdvs;
    public javax.swing.JMenuItem jmnReimprimeFacturas;
    public javax.swing.JMenuItem jmnRepCli;
    public javax.swing.JMenu jmnRepFac;
    public javax.swing.JMenuItem jmnRepFacCom;
    public javax.swing.JMenuItem jmnRepFacEmi;
    public javax.swing.JMenuItem jmnRepNC;
    public javax.swing.JMenuItem jmnRepND;
    public javax.swing.JMenu jmnSistema;
    public javax.swing.JMenuItem jmnUsuarios;
    public javax.swing.JMenuItem jmn_AceRecFac;
    private javax.swing.JLabel lbCopyRigth;
    private javax.swing.JPanel panelInferior;
    // End of variables declaration//GEN-END:variables

}
