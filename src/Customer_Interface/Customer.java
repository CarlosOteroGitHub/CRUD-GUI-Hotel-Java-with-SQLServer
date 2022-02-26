package Customer_Interface;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Customer extends JFrame implements ActionListener, WindowListener, MouseListener {

//*********************************************************************************************************************
    /* Estructura del Frame. */
    int SaveIDFromLogin = new Second_Class.Métodos().getID();
    Timer t1;
    JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10;
    JMenuBar menuBar1;
    JMenu menu1, menu2;
    JMenuItem menuItem1, menuItem2, menuItem3, menuItem4;
    JButton button1, button2, button3;
    JPanel panel1, panel2;

    public Customer() {
        //Caracteristicas del JFrame.
        this.setTitle("Cliente");
        this.setSize(770, 500);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);
        this.addWindowListener(this);

        //Caracteristicas del JMenuBar, JMenu y JMenuItem.
        menuBar1 = new JMenuBar();
        this.setJMenuBar(menuBar1);
        menuBar1.add(menu1 = new JMenu("Opciones"));
        menuBar1.add(menu2 = new JMenu("Imprimir"));
        menu1.add(menuItem1 = new JMenuItem("Cambiar Contraseña"));
        menu1.add(menuItem2 = new JMenuItem("Cambiar mi Número de Cuenta Bancaria"));
        menu1.add(menuItem3 = new JMenuItem("Cerrar Sesión"));
        menu2.add(menuItem4 = new JMenuItem("Datos de mi Reservación"));
        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);
        menuItem3.addActionListener(this);
        menuItem4.addActionListener(this);

        //Caracteristicas del JLabel.
        add(label1 = new JLabel());
        label1.setBounds(10, 2, 800, 30);
        label1.setFont(new java.awt.Font("Tahoma", 1, 18));
        label1.setForeground(Color.WHITE);

        add(label2 = new JLabel(new Second_Class.Consultas().ShowMessageNameCustomer(SaveIDFromLogin)));
        label2.setBounds(265, 2, 800, 30);
        label2.setFont(new java.awt.Font("Tahoma", 3, 20));
        label2.setForeground(Color.WHITE);

        add(label3 = new JLabel());
        label3.setBounds(598, 2, 800, 30);
        label3.setFont(new java.awt.Font("Tahoma", 1, 18));
        label3.setForeground(Color.WHITE);

        add(label4 = new JLabel());
        label4.setBounds(0, 0, 770, 132);
        ImageIcon img1 = new ImageIcon(getClass().getResource("/Multimedia/Panel Cliente.png"));
        ImageIcon sizeImg1 = new ImageIcon(img1.getImage().getScaledInstance(label4.getWidth(), label4.getHeight(), Image.SCALE_DEFAULT));
        label4.setIcon(sizeImg1);

        add(label5 = new JLabel());
        label5.setBounds(315, 144, 143, 80);
        ImageIcon img2 = new ImageIcon(getClass().getResource("/Multimedia/Logotipo del Hotel (Chico).png"));
        ImageIcon sizeImg2 = new ImageIcon(img2.getImage().getScaledInstance(label5.getWidth(), label5.getHeight(), Image.SCALE_DEFAULT));
        label5.setIcon(sizeImg2);

        //Caracteristicas de los JPanel.
        add(panel1 = new JPanel());
        panel1.setLayout(null);
        panel1.setBounds(0, 140, 308, 90);
        panel1.add(label6 = new JLabel());
        label6.setBounds(0, 0, 154, 90);
        ImageIcon img3 = new ImageIcon(getClass().getResource("/Multimedia/Instalaciones del Hotel 14.jpg"));
        ImageIcon sizeImg3 = new ImageIcon(img3.getImage().getScaledInstance(label6.getWidth(), label6.getHeight(), Image.SCALE_DEFAULT));
        label6.setIcon(sizeImg3);
        panel1.add(label7 = new JLabel());
        label7.setBounds(154, 0, 154, 90);
        ImageIcon img4 = new ImageIcon(getClass().getResource("/Multimedia/Instalaciones del Hotel 12.jpg"));
        ImageIcon sizeImg4 = new ImageIcon(img4.getImage().getScaledInstance(label7.getWidth(), label7.getHeight(), Image.SCALE_DEFAULT));
        label7.setIcon(sizeImg4);

        add(panel2 = new JPanel());
        panel2.setLayout(null);
        panel2.setBounds(462, 140, 308, 90);
        panel2.add(label8 = new JLabel());
        label8.setBounds(0, 0, 154, 90);
        ImageIcon img5 = new ImageIcon(getClass().getResource("/Multimedia/Instalaciones del Hotel 9.jpg"));
        ImageIcon sizeImg5 = new ImageIcon(img5.getImage().getScaledInstance(label8.getWidth(), label8.getHeight(), Image.SCALE_DEFAULT));
        label8.setIcon(sizeImg5);
        panel2.add(label9 = new JLabel());
        label9.setBounds(154, 0, 154, 90);
        ImageIcon img6 = new ImageIcon(getClass().getResource("/Multimedia/Instalaciones del Hotel 13.jpg"));
        ImageIcon sizeImg6 = new ImageIcon(img6.getImage().getScaledInstance(label9.getWidth(), label9.getHeight(), Image.SCALE_DEFAULT));
        label9.setIcon(sizeImg6);

        //Caracteristicas del JButton.
        add(button1 = new JButton());
        button1.setBounds(22, 253, 233, 176);
        button1.setBorderPainted(false);
        button1.setFocusPainted(false);
        button1.setContentAreaFilled(false);
        ImageIcon img7 = new ImageIcon(getClass().getResource("/Multimedia/reservar_norm.png"));
        ImageIcon sizeImg7 = new ImageIcon(img7.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_DEFAULT));
        button1.setIcon(sizeImg7);
        button1.addActionListener(this);
        button1.addMouseListener(this);

        add(button2 = new JButton());
        button2.setBounds(265, 253, 233, 176);
        button2.setBorderPainted(false);
        button2.setFocusPainted(false);
        button2.setContentAreaFilled(false);
        ImageIcon img8 = new ImageIcon(getClass().getResource("/Multimedia/misdatos_norm.png"));
        ImageIcon sizeImg8 = new ImageIcon(img8.getImage().getScaledInstance(button2.getWidth(), button2.getHeight(), Image.SCALE_DEFAULT));
        button2.setIcon(sizeImg8);
        button2.addActionListener(this);
        button2.addMouseListener(this);

        add(button3 = new JButton());
        button3.setBounds(508, 253, 233, 176);
        button3.setBorderPainted(false);
        button3.setFocusPainted(false);
        button3.setContentAreaFilled(false);
        ImageIcon img9 = new ImageIcon(getClass().getResource("/Multimedia/QueSug_norm.png"));
        ImageIcon sizeImg9 = new ImageIcon(img9.getImage().getScaledInstance(button3.getWidth(), button3.getHeight(), Image.SCALE_DEFAULT));
        button3.setIcon(sizeImg9);
        button3.addActionListener(this);
        button3.addMouseListener(this);
    }

//*********************************************************************************************************************
    /* Clases y Metodos de este Frame. */
    //Método que Inicializa la Concurrencia Relacionada con la Hora Local y la Fecha.
    public void DateTime() {
        t1 = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String am_pmLetra[] = {"AM", "PM"};
                String mesLetra[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
                GregorianCalendar tiempo = new GregorianCalendar();
                String hora = String.valueOf(tiempo.get(Calendar.HOUR)) + " : " + String.valueOf(tiempo.get(Calendar.MINUTE) + " : " + String.valueOf(tiempo.get(Calendar.SECOND) + " " + am_pmLetra[tiempo.get(Calendar.AM_PM)]) + ". ");
                String fecha = String.valueOf(tiempo.get(Calendar.DAY_OF_MONTH) + " / " + mesLetra[tiempo.get(Calendar.MONTH)] + " / " + String.valueOf(tiempo.get(Calendar.YEAR)) + ".");
                label1.setText(hora);
                label3.setText(fecha);
            }
        });
        t1.start();
    }

    //Método que hace Referencia al Cambio de Imagenes del Negocio Dentro de la Instancia del Thread.
    int seg = 0;
    Thread hilo1 = new Thread() {
        @Override
        public void run() {
            try {
                while (true) {
                    if (seg == 29) {
                        seg = 0;
                    }
                    seg++;
                    switch (seg) {
                        case 3:
                            new Second_Class.Métodos().Img("/Multimedia/Instalaciones del Hotel 7.jpg", label8);
                            break;
                        case 5:
                            new Second_Class.Métodos().Img("/Multimedia/Instalaciones del Hotel 10.jpg", label6);
                            break;
                        case 7:
                            new Second_Class.Métodos().Img("/Multimedia/Instalaciones del Hotel 6.jpg", label9);
                            break;
                        case 9:
                            new Second_Class.Métodos().Img("/Multimedia/Instalaciones del Hotel 11.jpg", label7);
                            break;
                        case 11:
                            new Second_Class.Métodos().Img("/Multimedia/Instalaciones del Hotel 12.jpg", label8);
                            break;
                        case 13:
                            new Second_Class.Métodos().Img("/Multimedia/Instalaciones del Hotel 8.jpg", label6);
                            break;
                        case 15:
                            new Second_Class.Métodos().Img("/Multimedia/Instalaciones del Hotel 9.jpg", label9);
                            break;
                        case 17:
                            new Second_Class.Métodos().Img("/Multimedia/Instalaciones del Hotel 14.jpg", label8);
                            break;
                        case 19:
                            new Second_Class.Métodos().Img("/Multimedia/Instalaciones del Hotel 6.jpg", label7);
                            break;
                        case 21:
                            new Second_Class.Métodos().Img("/Multimedia/Instalaciones del Hotel 11.jpg", label9);
                            break;
                        case 23:
                            new Second_Class.Métodos().Img("/Multimedia/Instalaciones del Hotel 13.jpg", label6);
                            break;
                        case 25:
                            new Second_Class.Métodos().Img("/Multimedia/Instalaciones del Hotel 12.jpg", label8);
                            break;
                        case 27:
                            new Second_Class.Métodos().Img("/Multimedia/Instalaciones del Hotel 9.jpg", label9);
                            break;
                        case 29:
                            new Second_Class.Métodos().Img("/Multimedia/Instalaciones del Hotel 8.jpg", label7);
                            break;
                    }
                    hilo1.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    };

    //Método que Ejecuta las Instrucciones Pertenecientes al Evento ActionListener.    
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == menuItem1) {
            new Second_Class.Métodos().setID(SaveIDFromLogin);
            this.setVisible(false);
            new Change_Password.Change_Password_Customer().setVisible(true);
        } else if (evt.getSource() == menuItem2) {
            new Second_Class.Métodos().setID(SaveIDFromLogin);
            this.setVisible(false);
            new Change_CountBank.Change_CountBank_Customer().setVisible(true);
        } else if (evt.getSource() == menuItem3) {
            this.setVisible(false);
            int opcion = JOptionPane.showConfirmDialog(null, "¿Estas Seguro de Salír de la Cuenta?");
            if (opcion == JOptionPane.YES_OPTION) {
                this.setVisible(false);
                new Start_Interface.Inicio().setVisible(true);
            } else {
                this.setVisible(true);
            }
        } else if (evt.getSource() == menuItem4) {
            boolean bandera = new Second_Class.Consultas().CountReservation_for_CustomerQuery(SaveIDFromLogin);
            if (bandera == true) {
                new Second_Class.Métodos().Sonido("Notify");
                JOptionPane.showMessageDialog(null, "Tienes que Reservar con el Hotel, par Hacer Uso de Este Modulo.", "Mensaje Informatívo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                try {
                    new Second_Class.Métodos().setID(SaveIDFromLogin);
                    new Print.Print().ImprimirPDF("ReservacionCustomer");
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        } else if (evt.getSource() == button1) {
            int cantidadDineroCliente = new Second_Class.Consultas().Money_Customer(SaveIDFromLogin);
            boolean bandera = new Second_Class.Consultas().CountReservation_for_CustomerQuery(SaveIDFromLogin);
            if (bandera == false) {
                new Second_Class.Métodos().Sonido("Notify");
                JOptionPane.showMessageDialog(null, "Ya has Reservado Anteriormente, Espera a que Termine tu Reservación Actual.", "Mensaje Informatívo", JOptionPane.INFORMATION_MESSAGE);
            } else if (cantidadDineroCliente == 0) {
                this.setVisible(false);
                new Second_Class.Métodos().Sonido("Notify");
                JOptionPane.showMessageDialog(null, "No Tienes Efectivo en tu Número de Cuenta Bancaria.", "Mensaje", JOptionPane.WARNING_MESSAGE);
                this.setVisible(true);
            } else {
                new Second_Class.Métodos().setID(SaveIDFromLogin);
                this.setVisible(false);
                new Reservation.Add_Reservation().setVisible(true);
            }
        } else if (evt.getSource() == button2) {
            new Second_Class.Métodos().setID(SaveIDFromLogin);
            this.setVisible(false);
            new Second_Class.MisDatos().setVisible(true);
        } else if (evt.getSource() == button3) {
            boolean bandera = new Second_Class.Consultas().CountReservation_for_CustomerQuery(SaveIDFromLogin);
            if (bandera == true) {
                new Second_Class.Métodos().Sonido("Notify");
                JOptionPane.showMessageDialog(null, "Tienes que Reservar con el Hotel, par Hacer Uso de Este Modulo.", "Mensaje Informatívo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                new Second_Class.Métodos().setID(SaveIDFromLogin);
                this.setVisible(false);
                new Complaint_Suggestion.Add_Complaint_Suggestion().setVisible(true);
            }
        }
    }

    //Método que Ejecuta las Instrucciones Pertenecientes al Evento WindowsListener.
    @Override
    public void windowOpened(WindowEvent evt) {
        new Second_Class.Métodos().Sonido("Count");
        DateTime();
        hilo1.start();
    }

    @Override
    public void windowClosing(WindowEvent evt) {
    }

    @Override
    public void windowClosed(WindowEvent evt) {
    }

    @Override
    public void windowIconified(WindowEvent evt) {
    }

    @Override
    public void windowDeiconified(WindowEvent evt) {
    }

    @Override
    public void windowActivated(WindowEvent evt) {
    }

    @Override
    public void windowDeactivated(WindowEvent evt) {
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
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/reservar_press.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_DEFAULT));
            button1.setIcon(sizeImg);
        } else if (evt.getSource() == button2) {
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/misdatos_press.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button2.getWidth(), button2.getHeight(), Image.SCALE_DEFAULT));
            button2.setIcon(sizeImg);
        } else if (evt.getSource() == button3) {
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/QueSug_press.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button3.getWidth(), button3.getHeight(), Image.SCALE_DEFAULT));
            button3.setIcon(sizeImg);
        }
    }

    @Override
    public void mouseExited(MouseEvent evt) {
        if (evt.getSource() == button1) {
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/reservar_norm.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_DEFAULT));
            button1.setIcon(sizeImg);
        } else if (evt.getSource() == button2) {
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/misdatos_norm.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button2.getWidth(), button2.getHeight(), Image.SCALE_DEFAULT));
            button2.setIcon(sizeImg);
        } else if (evt.getSource() == button3) {
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/QueSug_norm.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button3.getWidth(), button3.getHeight(), Image.SCALE_DEFAULT));
            button3.setIcon(sizeImg);
        }
    }
}
