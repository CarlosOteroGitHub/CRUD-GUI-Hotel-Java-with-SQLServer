package Reservation;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Add_Reservation extends JFrame implements ActionListener, MouseListener {

//*********************************************************************************************************************
    /* Estructura del Frame. */
    ResultSet rs;
    String formato = "dd/MM/yyyy";
    int SaveIDFromCustomer_Interface = new Second_Class.Métodos().getID();
    Date date;
    JDateChooser dateChooser1, dateChooser2;
    SimpleDateFormat sdf = new SimpleDateFormat(formato);
    JButton button1, button2;
    JLabel label1, label2, label3, label4, label5, label6;
    JSeparator separator1, separator2;
    JMenuBar menuBar1;
    JMenu menu1;
    JMenuItem menuItem1, menuItem2;
    JComboBox comboBox1, comboBox2;

    public Add_Reservation() {
        //Caracteristicas del JFrame.
        this.setTitle("Reservar");
        this.setSize(470, 515);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);

        //Caracteristicas de los JDateChooser.
        add(dateChooser1 = new JDateChooser());
        dateChooser1.setBounds(145, 115, 300, 30);

        add(dateChooser2 = new JDateChooser());
        dateChooser2.setBounds(145, 175, 300, 30);

        //Caracteristicas del JMenuBar, JMenu y JMenuItem.
        menuBar1 = new JMenuBar();
        this.setJMenuBar(menuBar1);
        menuBar1.add(menu1 = new JMenu("Consultar Habitaciones"));
        menu1.add(menuItem1 = new JMenuItem("Individual"));
        menu1.add(menuItem2 = new JMenuItem("Compartida"));
        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);

        //Caracteristicas de los JButton.
        add(button1 = new JButton());
        button1.setBounds(70, 412, 103, 35);
        button1.setBorderPainted(false);
        button1.setFocusPainted(false);
        button1.setContentAreaFilled(false);
        ImageIcon img1 = new ImageIcon(getClass().getResource("/Multimedia/acep_norm.png"));
        ImageIcon sizeImg1 = new ImageIcon(img1.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_DEFAULT));
        button1.setIcon(sizeImg1);
        button1.addActionListener(this);
        button1.addMouseListener(this);

        add(button2 = new JButton());
        button2.setBounds(300, 412, 103, 35);
        button2.setBorderPainted(false);
        button2.setFocusPainted(false);
        button2.setContentAreaFilled(false);
        ImageIcon img2 = new ImageIcon(getClass().getResource("/Multimedia/canc_norm.png"));
        ImageIcon sizeImg2 = new ImageIcon(img2.getImage().getScaledInstance(button2.getWidth(), button2.getHeight(), Image.SCALE_DEFAULT));
        button2.setIcon(sizeImg2);
        button2.addActionListener(this);
        button2.addMouseListener(this);

        //Caracteristicas de los JLabel.
        add(label1 = new JLabel());
        label1.setBounds(165, 0, 143, 80);
        ImageIcon img3 = new ImageIcon(getClass().getResource("/Multimedia/Logotipo del Hotel (Chico).png"));
        ImageIcon sizeImg3 = new ImageIcon(img3.getImage().getScaledInstance(label1.getWidth(), label1.getHeight(), Image.SCALE_DEFAULT));
        label1.setIcon(sizeImg3);

        add(label2 = new JLabel("Fecha de Llegada:"));
        label2.setFont(new java.awt.Font("Tahoma", 0, 15));
        label2.setBounds(10, 92, 160, 80);

        add(label3 = new JLabel("Fecha de Salida:"));
        label3.setFont(new java.awt.Font("Tahoma", 0, 15));
        label3.setBounds(15, 152, 160, 80);

        add(label4 = new JLabel("Selecciona la Cantidad de Habitaciones a Reservar"));
        label4.setFont(new java.awt.Font("Tahoma", 1, 15));
        label4.setBounds(38, 222, 400, 80);

        add(label5 = new JLabel("Individual"));
        label5.setFont(new java.awt.Font("Tahoma", 0, 13));
        label5.setBounds(85, 272, 160, 80);

        add(label6 = new JLabel("Compartida"));
        label6.setFont(new java.awt.Font("Tahoma", 0, 13));
        label6.setBounds(305, 272, 160, 80);

        //Caracteristicas del ComboBox.
        add(comboBox1 = new JComboBox());
        comboBox1.setBounds(60, 332, 120, 30);
        comboBox1.addItem("0");
        comboBox1.addItem("1");
        comboBox1.addItem("2");
        comboBox1.addItem("3");
        comboBox1.addItem("4");

        add(comboBox2 = new JComboBox());
        comboBox2.setBounds(280, 332, 120, 30);
        comboBox2.addItem("0");
        comboBox2.addItem("1");
        comboBox2.addItem("2");
        comboBox2.addItem("3");
        comboBox2.addItem("4");

        //Caracteristicas de los JSeparator.
        add(separator1 = new JSeparator(SwingConstants.HORIZONTAL));
        separator1.setBounds(20, 90, 420, 10);

        add(separator2 = new JSeparator(SwingConstants.HORIZONTAL));
        separator2.setBounds(20, 390, 420, 10);
    }

    //Método que Ejecuta las Instrucciones Pertenecientes al Evento ActionListener.
    @Override
    public void actionPerformed(ActionEvent evt) {
        int noHabInd = comboBox1.getSelectedIndex();
        int noHabCom = comboBox2.getSelectedIndex();
        int cantidadDineroCliente = new Second_Class.Consultas().Money_Customer(SaveIDFromCustomer_Interface);
        if (evt.getSource() == menuItem1) {
            this.setVisible(false);
            new Second_Class.TipoHab("I").setVisible(true);
        } else if (evt.getSource() == menuItem2) {
            this.setVisible(false);
            new Second_Class.TipoHab("C").setVisible(true);
        } else if (evt.getSource() == button1) {
            if (dateChooser1.getDate() == null || dateChooser2.getDate() == null) {
                this.setVisible(false);
                new Second_Class.Métodos().Sonido("Notify");
                JOptionPane.showMessageDialog(null, "Algunos de los Campos Quedaron Vacios.", "Mensaje", JOptionPane.WARNING_MESSAGE);
                this.setVisible(true);
            } else {
                String fechaActual = new Second_Class.Métodos().Date1();
                String fechaLlegada = new Second_Class.Métodos().dateFormat(dateChooser1);
                String fechaSalida = new Second_Class.Métodos().dateFormat(dateChooser2);
                if (new Second_Class.Métodos().dateMin_Max(fechaActual, fechaLlegada) == 1) {
                    this.setVisible(false);
                    new Second_Class.Métodos().Sonido("Notify");
                    JOptionPane.showMessageDialog(null, "La Fecha Actual con la de Llegada no Son Congruentes.", "Mensaje", JOptionPane.WARNING_MESSAGE);
                    this.setVisible(true);
                } else if (new Second_Class.Métodos().dateMin_Max(fechaLlegada, fechaSalida) == 1) {
                    this.setVisible(false);
                    new Second_Class.Métodos().Sonido("Notify");
                    JOptionPane.showMessageDialog(null, "La Fecha de Entrada y Salida no Son Congruentes.", "Mensaje", JOptionPane.WARNING_MESSAGE);
                    this.setVisible(true);
                } else if (new Second_Class.Métodos().dateMin_Max(fechaLlegada, fechaSalida) == 0) {
                    this.setVisible(false);
                    new Second_Class.Métodos().Sonido("Notify");
                    JOptionPane.showMessageDialog(null, "Las Fechas no Deven ser Iguales.", "Mensaje", JOptionPane.WARNING_MESSAGE);
                    this.setVisible(true);
                } else if (noHabInd == 0 && noHabCom == 0) {
                    this.setVisible(false);
                    new Second_Class.Métodos().Sonido("Error");
                    JOptionPane.showMessageDialog(null, "No Selecciono Ninguna Habitación.", "Error de Captura", JOptionPane.ERROR_MESSAGE);
                    this.setVisible(true);
                } else if (noHabInd + noHabCom > 4) {
                    this.setVisible(false);
                    new Second_Class.Métodos().Sonido("Error");
                    JOptionPane.showMessageDialog(null, "No puede Reservar más de 4 Habitaciones.", "Error de Captura", JOptionPane.ERROR_MESSAGE);
                    this.setVisible(true);
                } else {
                    try {
                        int noDias = new Second_Class.Métodos().DaysDiference(dateChooser1, dateChooser2);
                        int costoTotal = new Second_Class.Métodos().CostoReservacion(noHabInd, noHabCom, noDias);
                        if (cantidadDineroCliente < costoTotal) {
                            this.setVisible(false);
                            new Second_Class.Métodos().Sonido("Notify");
                            JOptionPane.showMessageDialog(null, "El Efectivo que Tienes en tu Cuenta Bancaria no Alcanza" + "\n" + "para Pagar el Monto de la Reservación.", "Mensaje", JOptionPane.WARNING_MESSAGE);
                            this.setVisible(true);
                        } else if (new Second_Class.Consultas().HabDisIndividuales(noHabInd) == false) {
                            this.setVisible(false);
                            new Second_Class.Métodos().Sonido("Notify");
                            JOptionPane.showMessageDialog(null, "No hay Habitaciones Individuales Disponibles para Reservar.", "Mensaje", JOptionPane.WARNING_MESSAGE);
                            this.setVisible(true);
                        } else if (new Second_Class.Consultas().HabDisCompartidas(noHabCom) == false) {
                            this.setVisible(false);
                            new Second_Class.Métodos().Sonido("Notify");
                            JOptionPane.showMessageDialog(null, "No hay Habitaciones Compartidas Disponibles para Reservar.", "Mensaje", JOptionPane.WARNING_MESSAGE);
                            this.setVisible(true);
                        } else {
                            new Second_Class.ProcedimientosAlmacenados().AltaRerservacion(new Second_Class.Consultas().getDateQuery(), fechaLlegada, fechaSalida, String.valueOf(noDias));
                            rs = new Second_Class.ConexiónSQL().Consulta("update Cliente set id_reservacion =" + new Second_Class.Consultas().ident_CurrentQuery("Reservacion") + "where id_cliente =" + SaveIDFromCustomer_Interface);
                            new Second_Class.ProcedimientosAlmacenados().AltaCostoTotal(String.valueOf(costoTotal), String.valueOf(new Second_Class.Consultas().ident_CurrentQuery("Reservacion")));
                            int resultado = cantidadDineroCliente - costoTotal;
                            rs = new Second_Class.ConexiónSQL().Consulta("update CuentaBancaria set cantidad =" + resultado + " where id_cuentaBancaria =" + new Second_Class.Consultas().ObtainIDCountBankFromIDCustomer(SaveIDFromCustomer_Interface));
                            new Second_Class.Consultas().ReservarHabitacionesIndividuales(noHabInd);
                            new Second_Class.Consultas().ReservarHabitacionesCompartidas(noHabCom);
                            this.setVisible(false);
                            new Second_Class.SimulaciónTiempo().setVisible(true);
                        }
                    } catch (SQLException e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                }
            }
        } else if (evt.getSource() == button2) {
            this.setVisible(false);
            new Customer_Interface.Customer().setVisible(true);
        }
    }

    //Método que Ejecuta las Instrucciones Pertenecientes al Evento MouseListener.
    @Override
    public void mouseClicked(MouseEvent evt) {
    }

    @Override
    public void mousePressed(MouseEvent evt) {
    }

    @Override
    public void mouseReleased(MouseEvent evt) {
    }

    @Override
    public void mouseEntered(MouseEvent evt) {
        if (evt.getSource() == button1) {
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/acep_roll.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_DEFAULT));
            button1.setIcon(sizeImg);
        } else if (evt.getSource() == button2) {
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/canc_roll.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button2.getWidth(), button2.getHeight(), Image.SCALE_DEFAULT));
            button2.setIcon(sizeImg);
        }

    }

    //Método que Ejecuta las Instrucciones Pertenecientes al Evento WindowListener.
    @Override
    public void mouseExited(MouseEvent evt) {
        if (evt.getSource() == button1) {
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/acep_norm.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_DEFAULT));
            button1.setIcon(sizeImg);
        } else if (evt.getSource() == button2) {
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/canc_norm.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button2.getWidth(), button2.getHeight(), Image.SCALE_DEFAULT));
            button2.setIcon(sizeImg);
        }
    }
}
