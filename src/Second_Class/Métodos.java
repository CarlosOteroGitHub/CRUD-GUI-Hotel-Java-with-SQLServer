package Second_Class;

import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Métodos {

//*********************************************************************************************************************     
    //Método que Valida que no Existan Numeros Enteros.
    public boolean SinNumeros(String cadena) {
        boolean sinNumeros = false;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) >= 48 && cadena.charAt(i) <= 57) {
                sinNumeros = true;
            }
        }
        return sinNumeros;
    }

    //Método que Valida que solo Existan Numeros Enteros.
    public boolean SoloNumeros(String cadena) {
        try {
            Long.parseLong(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //Método que Valida que solo Existan Letras Minusculas y Mayusculas.
    public boolean SoloLetras(String cadena) {
        boolean soloLetras = true;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) >= 33 && cadena.charAt(i) <= 64 || cadena.charAt(i) >= 91 && cadena.charAt(i) <= 96 || cadena.charAt(i) >= 123 && cadena.charAt(i) <= 255) {
                soloLetras = false;
            }
        }
        return soloLetras;
    }

    //Método que Valida que no Existan Numeros Enteros y Letras Mayusculas.
    public boolean SoloLetrasMayusculas_Numeros(String cadena) {
        boolean soloLetras_Numeros = true;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) >= 33 && cadena.charAt(i) <= 47 || cadena.charAt(i) >= 58 && cadena.charAt(i) <= 64 || cadena.charAt(i) >= 91 && cadena.charAt(i) <= 255) {
                soloLetras_Numeros = false;
            }
        }
        return soloLetras_Numeros;
    }

//*********************************************************************************************************************         
    //Método que Retorna un Número Aleatorio entre 1 y 6, para ingresar el Número de la Empresa Bancaria a la que Corresponde la Tarjeta del Cliente.    
    public int NumeroAleatorio() {
        int num1 = 2, num2 = 7;
        int noElementos = (int) Math.floor(Math.random() * (num1 - (num2 + 1)) + (num2));
        return noElementos;
    }

//*********************************************************************************************************************         
    //Método que Ejecuta Sonido.
    Clip audio;

    public void Sonido(String nombre) {
        String ruta = "/Multimedia/";
        try {
            audio = AudioSystem.getClip();
            audio.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(ruta + nombre + ".wav")));
            audio.start();
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

//*********************************************************************************************************************         
    //Método que Carga una Imagen en un JLabel.
    public void Img(String nombreImg, JLabel label) {
        ImageIcon img1 = new ImageIcon(getClass().getResource(nombreImg));
        ImageIcon sizeImg1 = new ImageIcon(img1.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(sizeImg1);
    }

//*********************************************************************************************************************         
    //Método que Muestra el Mensaje PlaceHolder dentro de un JTextArea.
    public void PlaceHolderActivo1(JTextArea textArea, String mensaje, int longitud) {
        if (longitud == 0) {
            textArea.setText(mensaje);
            textArea.setForeground(java.awt.Color.decode("#818181"));
        }
    }

    //Método que Inabilita el Mensaje PlaceHolder en el JTextArea, una vez que se Clikea el Campo de Texto.
    public void PlaceHolderInactivo1(JTextArea textArea, String mensaje) {
        if (textArea.getText().equals(mensaje)) {
            textArea.setText(" ");
            textArea.setText("");
            textArea.setForeground(java.awt.Color.decode("#000000"));
        }
    }

    //Método que Muestra el Mensaje PlaceHolder dentro de un JTextField.
    public void PlaceHolderActivo2(JTextField textField, String mensaje, int longitud) {
        if (longitud == 0) {
            textField.setText(mensaje);
            textField.setForeground(java.awt.Color.decode("#818181"));
        }
    }

    //Método que Inabilita el Mensaje PlaceHolder en el JTextField, una vez que se Clikea el Campo de Texto.
    public void PlaceHolderInactivo2(JTextField textField, String mensaje) {
        if (textField.getText().equals(mensaje)) {
            textField.setText(" ");
            textField.setText("");
            textField.setForeground(java.awt.Color.decode("#000000"));
        }
    }

//*********************************************************************************************************************         
    //Método que Intercambia los Valores de Sexo para ser Insertados en la Tabla.
    public String ChangeSexo_to_S(JComboBox comboBox) {
        String cveSexo = "";
        int opcion = comboBox.getSelectedIndex();
        switch (opcion) {
            case 0:
                cveSexo = "M";
                break;
            case 1:
                cveSexo = "F";
                break;
        }
        return cveSexo;
    }

    //Método que Intercambia los Valores de Puesto para ser Insertados en la Tabla.
    public String ChangePuesto_to_P(JComboBox comboBox) {
        int opcion = comboBox.getSelectedIndex();
        String cvePuesto = "";
        switch (opcion) {
            case 0:
                cvePuesto = "G";
                break;
            case 1:
                cvePuesto = "F";
                break;
            case 2:
                cvePuesto = "I";
                break;
            case 3:
                cvePuesto = "S";
                break;
            case 4:
                cvePuesto = "M";
                break;
            case 5:
                cvePuesto = "C";
                break;
            case 6:
                cvePuesto = "E";
                break;
        }
        return cvePuesto;
    }

    //Método que Intercambia los Valores de Sexo a partir su identificador, a su descriptivo.
    public String ChangeS_to_Sexo(String sexo) {
        String opcion = "";
        if (sexo.equals("M")) {
            opcion = "Masculino";
        } else {
            opcion = "Femenino";
        }
        return opcion;
    }

//*********************************************************************************************************************         
    //Métodos que Guardan el ID para ser Almacenado y Transeferido entre Clases, de tal Manera que se Puedan Realizar Funciones con Este en la Base de Datos.
    public static int ID = 0;

    public static void setID(int ID) {
        Métodos.ID = ID;
    }

    public static int getID() {
        return ID;
    }

//*********************************************************************************************************************         
    //Método que Elimina Todos los Registros Dentro de un JTable.    
    public void DeteleJTable(JTable table, DefaultTableModel dtm) {
        int eliminarFilas = table.getRowCount();
        if (eliminarFilas > 0) {
            for (int i = eliminarFilas - 1; i >= 0; i--) {
                dtm.removeRow(i);
            }
        }
    }

//*********************************************************************************************************************         
    //Método que Retorna la Fecha Actual del Sistema sin Nombre de Mes.
    public String Date1() {
        GregorianCalendar tiempo = new GregorianCalendar();
        String fecha = String.valueOf(tiempo.get(Calendar.DAY_OF_MONTH) + "/" + tiempo.get(Calendar.MONTH) + "/" + String.valueOf(tiempo.get(Calendar.YEAR)));
        return fecha;
    }

    //Método que Retorna la Fecha Actual del Sistema, con Nombre de Mes.
    public String Date2() {
        String mesLetra[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        GregorianCalendar tiempo = new GregorianCalendar();
        String fecha = String.valueOf(tiempo.get(Calendar.DAY_OF_MONTH) + " / " + mesLetra[tiempo.get(Calendar.MONTH)] + " / " + String.valueOf(tiempo.get(Calendar.YEAR)) + ".");
        return fecha;
    }

    //Método que Estipula el Formato de Fecha para el uso de JDateChooser, una vez que sea Enviado Hacia la Base de Datos.
    public String dateFormat(JDateChooser dateChooser) {
        String fecha = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateChooser.getDate();
        fecha = sdf.format(date);
        return fecha;
    }

    //Método que Recibe las Fechas de Llegada y Salida de la Interfaz Reservación, para ser Comparadas y Estipular si la Fecha de Llegada es Menor que la Fecha de Salida.
    public int dateMin_Max(String dateLlegada, String dateSalida) {
        int resultado = 0;
        Date d1 = new Date(dateLlegada);
        Date d2 = new Date(dateSalida);

        switch (d1.compareTo(d2)) {
            case -1:
                resultado = -1;
                break;
            case 0:
                resultado = 0;
                break;
            case 1:
                resultado = 1;
                break;
        }
        return resultado;
    }

    //Método que Retorna los Dias de Diferencia Entre dos Fechas.
    public int DaysDiference(JDateChooser dateChooseLlegada, JDateChooser dateChooserSalida) {
        int diaLlegada = dateChooseLlegada.getCalendar().get(Calendar.DAY_OF_MONTH), diaSalida = dateChooserSalida.getCalendar().get(Calendar.DAY_OF_MONTH);
        int mesLlegada = dateChooseLlegada.getCalendar().get(Calendar.MONTH) + 1, mesSalida = dateChooserSalida.getCalendar().get(Calendar.MONTH) + 1;
        int añoLlegada = dateChooseLlegada.getCalendar().get(Calendar.YEAR), añoSalida = dateChooserSalida.getCalendar().get(Calendar.YEAR);
        int totalDias = 0;
        totalDias = diaSalida - diaLlegada + 30 * (mesSalida - mesLlegada) + 365 * (añoSalida - añoLlegada);
        return totalDias;
    }

//*********************************************************************************************************************         
    //Método que Retorna la Cantidad Exacta de Dinero que Devera Pagar el Cliente, segun las Habitaciones que Reserve, junto con sus Dias de Estancia.
    public int CostoReservacion(int noHabInd, int noHabCom, int noDias) {
        int precioHabInd = new Second_Class.Consultas().CostoHabInd();
        int precioHabCom = new Second_Class.Consultas().CostoHabCom();
        int costoResultante = 0;

        for (int i = 0; i < noHabInd; i++) {
            costoResultante += precioHabInd;
        }

        for (int i = 0; i < noHabCom; i++) {
            costoResultante += precioHabCom;
        }
        
        costoResultante *= noDias;
        
        return costoResultante;
    }
}
