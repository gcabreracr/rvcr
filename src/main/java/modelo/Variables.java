package modelo;

import forms.AceptaXml;
import forms.AceptaXmlNC;
import forms.Agencias;
import forms.AnulaFactura;
import forms.Articulos;
import forms.CambiarPin;
import forms.CargaDiaria;
import forms.Clientes;
import forms.EmiteFactura;
import forms.EmiteNotaCredito;
import forms.EstadoLiq;
import forms.FacturaCompras;
import forms.Login;
import forms.Pdvs;
import forms.Precios;
import forms.ReenvioFactura;
import forms.ReimpresionFacturas;
import forms.Usuarios;

public class Variables {

    // IP
    //public static final String URL_SERVER = "http://seccab.com/sandbox/rvcr/";
    public static String URL_SERVER = "";
    //public static String IP_DB="jdbc:mysql://198.71.225.61:3306/";
    public static String IP_DB="";
    public static String DB_NAME="";
    

    // Variables estaticas para el control del usuario durante la ejecucion del programa
    public static String mCODUSU; // Codigo usuario
    public static String mNOMUSU; // Nombre usuario
    public static int mTIPOUSU; // Tipo usuario
    public static int mCATPDV; // Categoria PDV    
    public static int mAGEUSU; // Codigo agencia usuario
    public static String mNOMAGEUSU; // Nombre agencia usuario
    public static int mPDVUSU; //  Codigo PDV usuario
    public static String mNOMPDVUSU; // Nombre PDV usuario
    public static String mBODUSU; // Bodega PDV
    public static String mDBUSUARIO; // Base datos usuario

    // Variable para validacion de largos de campos JTextField
    public static final int L_COD_USU = 20; // CODIGO USUARIO
    public static final int L_PIN_USU = 10; // PIN USUARIO
    public static final int L_ID_TRIBUTA = 15; // ID TRIBUTA
    public static final int L_COD_AGE = 3; // CODIGO AGENCIA
    public static final int L_COD_PDV = 3; // CODIGO PDV
    public static final int L_NOM_CLI = 50; // NOMBRE CLIENTE
    public static final int L_NOM_TRIBUTA = 80; // NOMBRE TRIBUTA - FACTURA
    public static final int L_EMAIL = 50; // CORREO ELECTRONICO
    public static final int L_ID_FIS = 9; // ID PERSONA FISICA
    public static final int L_ID_JUR = 10; // ID PERSONA JURIDICA
    public static final int L_ID_DIMEX = 15; // ID DIMEX
    public static final int L_ID_NITE = 12; // ID NITE
    public static final int L_NOM_CONTACTO = 50; // NOMBRE CONTACTO
    public static final int L_NUM_TELNAC = 8; // NUMERO TELEFONICO NACIONAL
    public static final int L_MON_DESCTO = 2; // MONTO DESCUENTO
    public static final int L_PLAZO = 3; // PLAZO CREDITO
    public static final int L_COD_CLI = 6; // CODIGO CLIENTE
    public static final int L_COD_ITEC = 15; // CODIGO ITEC
    public static final int L_COD_ART = 6; // CODIGO ARTICULO
    public static final int L_NOM_LAR_ART = 50; // NOMBRE LARGO ARTICULO
    public static final int L_NOM_COR_ART = 30; // NOMBRE CORTO ARTICULO
    public static final int L_UNI_MED = 10; // UNIDAD MEDIDA
    public static final int L_ENC_ART = 15; // NOMBRE DEL ENCABEZADO
    public static final int L_COD_BARRA = 13; // CODIGO BARRAS

    // Control singleton de apertura de ventanas
    public static Login frmLogin = null;
    public static Agencias FRM_AGENCIAS = null;
    public static Clientes frmClientes = null;
    public static Pdvs frmPdvs = null;
    public static Usuarios frmUsuarios = null;
    public static CargaDiaria frmCarDia = null;
    public static EstadoLiq frmEstLiq = null;
    public static AnulaFactura frmAnuFac = null;
    public static EmiteFactura frmEmiFac = null;
    public static EmiteNotaCredito frmEmiNC = null;
    public static Articulos frmActPro = null;
    public static Precios frmActPre = null;
    public static CambiarPin frmCambiaPin = null;
    public static ReenvioFactura frmReenvioFac = null;
    public static ReimpresionFacturas frmReimprimeFac = null;
    public static AceptaXml frmAceptaXml = null;
    public static FacturaCompras frmFactCompra = null;
    public static AceptaXmlNC frmAceptaXmlNC = null;
}
