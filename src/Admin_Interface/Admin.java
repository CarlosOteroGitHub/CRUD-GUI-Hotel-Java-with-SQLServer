package Admin_Interface;

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
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Admin extends JFrame implements ActionListener, WindowListener, MouseListener {

//*********************************************************************************************************************
    /* Estructura del Frame. */
    Timer t1;
    JLabel label1, label2, label3;
    JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12;
    JRadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    ButtonGroup buttonGroup1;
    JMenuBar menuBar1;
    JMenu menu1;
    JMenuItem menuItem1, menuItem2;
    JList list1;
    DefaultListModel dlm1;
    JTable table1, table2, table3;
    DefaultTableModel dtm1, dtm2, dtm3;
    TableColumnModel tcm;
    JTabbedPane tabbedPane1;
    JSeparator separator1, separator2, separator3, separator4;
    JScrollPane scrollPane1, scrollPane2, scrollPane3, scrollPane4;
    JPanel panel1, panel2, panel3, panel4, panel5;

    public Admin() {
        //Caracteristicas del JFrame.
        this.setTitle("Administrador");
        this.setSize(765, 550);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);
        this.addWindowListener(this);

        //Caracteristicas del JMenuBar, JMenu y JMenuItem.
        menuBar1 = new JMenuBar();
        this.setJMenuBar(menuBar1);
        menuBar1.add(menu1 = new JMenu("Opciones"));
        menu1.add(menuItem1 = new JMenuItem("Cambiar Contraseña"));
        menu1.add(menuItem2 = new JMenuItem("Cerrar Sesión"));
        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);

        //Caracteristicas de los JPanel.
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(Color.WHITE);
        panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel2.setBackground(Color.WHITE);
        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel3.setBackground(Color.WHITE);
        panel4 = new JPanel();
        panel4.setLayout(null);
        panel4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel4.setBackground(Color.WHITE);
        panel5 = new JPanel();
        panel5.setLayout(null);
        panel5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel5.setBackground(Color.WHITE);

        //Caracteristicas de los JButton.
        panel1.add(button1 = new JButton());
        button1.setBounds(100, 15, 186, 37);
        button1.setBorderPainted(false);
        button1.setFocusPainted(false);
        button1.setContentAreaFilled(false);
        ImageIcon img1 = new ImageIcon(getClass().getResource("/Multimedia/Show Customers.png"));
        ImageIcon sizeImg1 = new ImageIcon(img1.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_DEFAULT));
        button1.setIcon(sizeImg1);
        button1.addActionListener(this);

        panel1.add(button2 = new JButton());
        button2.setBounds(475, 15, 186, 37);
        button2.setBorderPainted(false);
        button2.setFocusPainted(false);
        button2.setContentAreaFilled(false);
        ImageIcon img2 = new ImageIcon(getClass().getResource("/Multimedia/Update date 1.png"));
        ImageIcon sizeImg2 = new ImageIcon(img2.getImage().getScaledInstance(button2.getWidth(), button2.getHeight(), Image.SCALE_DEFAULT));
        button2.setIcon(sizeImg2);
        button2.addActionListener(this);

        panel2.add(button3 = new JButton());
        button3.setBounds(100, 15, 191, 37);
        button3.setBorderPainted(false);
        button3.setFocusPainted(false);
        button3.setContentAreaFilled(false);
        ImageIcon img3 = new ImageIcon(getClass().getResource("/Multimedia/Show Reservations.png"));
        ImageIcon sizeImg3 = new ImageIcon(img3.getImage().getScaledInstance(button3.getWidth(), button3.getHeight(), Image.SCALE_DEFAULT));
        button3.setIcon(sizeImg3);
        button3.addActionListener(this);

        panel2.add(button4 = new JButton());
        button4.setBounds(475, 15, 191, 37);
        button4.setBorderPainted(false);
        button4.setFocusPainted(false);
        button4.setContentAreaFilled(false);
        ImageIcon img4 = new ImageIcon(getClass().getResource("/Multimedia/Delete Reservation.png"));
        ImageIcon sizeImg4 = new ImageIcon(img4.getImage().getScaledInstance(button4.getWidth(), button4.getHeight(), Image.SCALE_DEFAULT));
        button4.setIcon(sizeImg4);
        button4.addActionListener(this);

        panel3.add(button5 = new JButton());
        button5.setBounds(18, 15, 158, 37);
        button5.setBorderPainted(false);
        button5.setFocusPainted(false);
        button5.setContentAreaFilled(false);
        ImageIcon img5 = new ImageIcon(getClass().getResource("/Multimedia/Show Employ.png"));
        ImageIcon sizeImg5 = new ImageIcon(img5.getImage().getScaledInstance(button5.getWidth(), button5.getHeight(), Image.SCALE_DEFAULT));
        button5.setIcon(sizeImg5);
        button5.addActionListener(this);

        panel3.add(button6 = new JButton());
        button6.setBounds(209, 15, 158, 37);
        button6.setBorderPainted(false);
        button6.setFocusPainted(false);
        button6.setContentAreaFilled(false);
        ImageIcon img6 = new ImageIcon(getClass().getResource("/Multimedia/Add Employ.png"));
        ImageIcon sizeImg6 = new ImageIcon(img6.getImage().getScaledInstance(button6.getWidth(), button6.getHeight(), Image.SCALE_DEFAULT));
        button6.setIcon(sizeImg6);
        button6.addActionListener(this);

        panel3.add(button7 = new JButton());
        button7.setBounds(400, 15, 158, 37);
        button7.setBorderPainted(false);
        button7.setFocusPainted(false);
        button7.setContentAreaFilled(false);
        ImageIcon img7 = new ImageIcon(getClass().getResource("/Multimedia/Update Date 2.png"));
        ImageIcon sizeImg7 = new ImageIcon(img7.getImage().getScaledInstance(button7.getWidth(), button7.getHeight(), Image.SCALE_DEFAULT));
        button7.setIcon(sizeImg7);
        button7.addActionListener(this);

        panel3.add(button8 = new JButton());
        button8.setBounds(591, 15, 158, 37);
        button8.setBorderPainted(false);
        button8.setFocusPainted(false);
        button8.setContentAreaFilled(false);
        ImageIcon img8 = new ImageIcon(getClass().getResource("/Multimedia/Delete Employ.png"));
        ImageIcon sizeImg8 = new ImageIcon(img8.getImage().getScaledInstance(button8.getWidth(), button8.getHeight(), Image.SCALE_DEFAULT));
        button8.setIcon(sizeImg8);
        button8.addActionListener(this);

        panel4.add(button9 = new JButton());
        button9.setBounds(95, 15, 185, 37);
        button9.setBorderPainted(false);
        button9.setFocusPainted(false);
        button9.setContentAreaFilled(false);
        ImageIcon img9 = new ImageIcon(getClass().getResource("/Multimedia/Show Que-Sug.png"));
        ImageIcon sizeImg9 = new ImageIcon(img9.getImage().getScaledInstance(button9.getWidth(), button9.getHeight(), Image.SCALE_DEFAULT));
        button9.setIcon(sizeImg9);
        button9.addActionListener(this);

        panel4.add(button10 = new JButton());
        button10.setBounds(470, 15, 185, 37);
        button10.setBorderPainted(false);
        button10.setFocusPainted(false);
        button10.setContentAreaFilled(false);
        ImageIcon img10 = new ImageIcon(getClass().getResource("/Multimedia/Delete Que-Sug.png"));
        ImageIcon sizeImg10 = new ImageIcon(img10.getImage().getScaledInstance(button10.getWidth(), button10.getHeight(), Image.SCALE_DEFAULT));
        button10.setIcon(sizeImg10);
        button10.addActionListener(this);

        panel5.add(button11 = new JButton());
        button11.setBounds(300, 95, 134, 134);
        button11.setBorderPainted(false);
        button11.setFocusPainted(false);
        button11.setContentAreaFilled(false);
        ImageIcon img11 = new ImageIcon(getClass().getResource("/Multimedia/Print_norm.png"));
        ImageIcon sizeImg11 = new ImageIcon(img11.getImage().getScaledInstance(button11.getWidth(), button11.getHeight(), Image.SCALE_DEFAULT));
        button11.setIcon(sizeImg11);
        button11.addMouseListener(this);
        button11.addActionListener(this);

        //Caracteristicas de los JRadioButton.
        panel5.add(radioButton1 = new JRadioButton("Clientes"));
        radioButton1.setFont(new java.awt.Font("Tahoma", 0, 12));
        radioButton1.setBounds(80, 45, 130, 35);

        panel5.add(radioButton2 = new JRadioButton("Reservaciones"));
        radioButton2.setFont(new java.awt.Font("Tahoma", 0, 12));
        radioButton2.setBounds(550, 45, 130, 35);

        panel5.add(radioButton3 = new JRadioButton("Empleados"));
        radioButton3.setFont(new java.awt.Font("Tahoma", 0, 12));
        radioButton3.setBounds(80, 273, 130, 35);

        panel5.add(radioButton4 = new JRadioButton("Quejas/Sugerencias"));
        radioButton4.setFont(new java.awt.Font("Tahoma", 0, 12));
        radioButton4.setBounds(550, 273, 130, 35);

        //Caracteristicas de los ButtonGroup.
        buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);
        buttonGroup1.add(radioButton3);
        buttonGroup1.add(radioButton4);

        //Caracteristicas de los JSeparator.
        panel1.add(separator1 = new JSeparator(SwingConstants.HORIZONTAL));
        separator1.setBounds(20, 60, 718, 10);

        panel2.add(separator2 = new JSeparator(SwingConstants.HORIZONTAL));
        separator2.setBounds(20, 60, 718, 10);

        panel3.add(separator3 = new JSeparator(SwingConstants.HORIZONTAL));
        separator3.setBounds(20, 60, 718, 10);

        panel4.add(separator4 = new JSeparator(SwingConstants.HORIZONTAL));
        separator4.setBounds(20, 60, 718, 10);

        //Caracteristicas de los JTable.
        panel1.add(table1 = new JTable());
        table1.setBounds(20, 80, 720, 250);
        dtm1 = (DefaultTableModel) table1.getModel();
        dtm1.addColumn("No Cliente");
        dtm1.addColumn("Nombre");
        dtm1.addColumn("Apellidos");
        dtm1.addColumn("Edad");
        dtm1.addColumn("Sexo");
        dtm1.addColumn("Email");
        dtm1.addColumn("Teléfono");
        dtm1.addColumn("Estado");
        dtm1.addColumn("Contraseña");
        tcm = table1.getColumnModel();
        tcm.getColumn(0).setPreferredWidth(80);
        tcm.getColumn(1).setPreferredWidth(70);
        tcm.getColumn(2).setPreferredWidth(100);
        tcm.getColumn(3).setPreferredWidth(40);
        tcm.getColumn(4).setPreferredWidth(65);
        tcm.getColumn(5).setPreferredWidth(140);
        tcm.getColumn(6).setPreferredWidth(85);
        tcm.getColumn(7).setPreferredWidth(85);
        tcm.getColumn(8).setPreferredWidth(85);

        panel2.add(table2 = new JTable());
        table2.setBounds(20, 80, 720, 250);
        dtm2 = (DefaultTableModel) table2.getModel();
        dtm2.addColumn("No Cliente");
        dtm2.addColumn("No Reservación");
        dtm2.addColumn("No Dias");
        dtm2.addColumn("Fecha Envio");
        dtm2.addColumn("Fecha Entrada");
        dtm2.addColumn("Fecha Salida");
        dtm2.addColumn("Costo Total");
        tcm = table2.getColumnModel();
        tcm.getColumn(0).setPreferredWidth(5);
        tcm.getColumn(1).setPreferredWidth(45);
        tcm.getColumn(2).setPreferredWidth(10);
        tcm.getColumn(3).setPreferredWidth(45);
        tcm.getColumn(4).setPreferredWidth(50);
        tcm.getColumn(5).setPreferredWidth(45);

        panel3.add(table3 = new JTable());
        table3.setBounds(20, 80, 720, 250);
        dtm3 = (DefaultTableModel) table3.getModel();
        dtm3.addColumn("No");
        dtm3.addColumn("Nombre");
        dtm3.addColumn("Apellidos");
        dtm3.addColumn("Edad");
        dtm3.addColumn("Sexo");
        dtm3.addColumn("Antiguedad");
        dtm3.addColumn("Puesto");
        dtm3.addColumn("Sueldo");
        tcm = table3.getColumnModel();
        tcm.getColumn(0).setPreferredWidth(2);
        tcm.getColumn(3).setPreferredWidth(25);
        tcm.getColumn(4).setPreferredWidth(25);
        tcm.getColumn(5).setPreferredWidth(50);
        tcm.getColumn(7).setPreferredWidth(70);

        //Caracteristicas de los JList.
        panel4.add(list1 = new JList());
        list1.setBounds(20, 80, 720, 250);
        dlm1 = new DefaultListModel();

        //Caracteristicas de los JScrollPane.
        panel1.add(scrollPane1 = new JScrollPane(table1));
        scrollPane1.setBounds(20, 80, 720, 250);

        panel2.add(scrollPane2 = new JScrollPane(table2));
        scrollPane2.setBounds(20, 80, 720, 250);

        panel3.add(scrollPane3 = new JScrollPane(table3));
        scrollPane3.setBounds(20, 80, 720, 250);

        panel4.add(scrollPane4 = new JScrollPane(list1));
        scrollPane4.setBounds(20, 80, 720, 250);

        //Caracteristicas de los JTabbedPane.
        add(tabbedPane1 = new JTabbedPane());
        tabbedPane1.setBounds(0, 120, 800, 400);
        tabbedPane1.addTab("Clientes", panel1);
        tabbedPane1.addTab("Reservaciones", panel2);
        tabbedPane1.addTab("Empleados", panel3);
        tabbedPane1.addTab("Quejas/Sugerencias", panel4);
        tabbedPane1.addTab("Impresión de Formatos", panel5);

        //Caracteristicas del JLabel.
        add(label1 = new JLabel());
        label1.setBounds(10, 2, 800, 30);
        label1.setFont(new java.awt.Font("Tahoma", 1, 18));
        label1.setForeground(Color.WHITE);

        add(label2 = new JLabel());
        label2.setBounds(0, 0, 770, 145);
        ImageIcon img13 = new ImageIcon(getClass().getResource("/Multimedia/Panel Administrador.png"));
        ImageIcon sizeImg13 = new ImageIcon(img13.getImage().getScaledInstance(label2.getWidth(), label2.getHeight(), Image.SCALE_DEFAULT));
        label2.setIcon(sizeImg13);

        panel5.add(label3 = new JLabel());
        label3.setBounds(220, 175, 875, 250);
        ImageIcon img14 = new ImageIcon(getClass().getResource("/Multimedia/Fondo 2.png"));
        ImageIcon sizeImg14 = new ImageIcon(img14.getImage().getScaledInstance(label3.getWidth(), label3.getHeight(), Image.SCALE_DEFAULT));
        label3.setIcon(sizeImg14);
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
                label1.setText("                     " + hora + "                                                   " + fecha);
            }
        });
        t1.start();
    }

    //Método que Ejecuta las Instrucciones Pertenecientes al Evento ActionListener.    
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == menuItem1) {
            this.setVisible(false);
            new Change_Password.Change_Password_Admin().setVisible(true);
        } else if (evt.getSource() == menuItem2) {
            this.setVisible(false);
            int opcion = JOptionPane.showConfirmDialog(null, "¿Estas Seguro de Salír de la Cuenta?");
            if (opcion == JOptionPane.YES_OPTION) {
                this.setVisible(false);
                new Start_Interface.Inicio().setVisible(true);
            } else {
                this.setVisible(true);
            }
        } else if (evt.getSource() == button1) {
            if (new Second_Class.Consultas().CountAllFromCustomerQuery() == true) {
                new Second_Class.Métodos().Sonido("Notify");
                JOptionPane.showMessageDialog(null, "No hay Registros Existentes.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                new Second_Class.Métodos().DeteleJTable(table1, dtm1);
                new Second_Class.Consultas().ShowCustomer_CountQuery(table1, dtm1);
            }
        } else if (evt.getSource() == button2) {
            if (new Second_Class.Consultas().CountAllFromCustomerQuery() == true) {
                new Second_Class.Métodos().Sonido("Notify");
                JOptionPane.showMessageDialog(null, "No hay Registros Existentes.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                new Registry_Customer.Modify_Customer().setVisible(true);
                this.setVisible(false);
            }
        } else if (evt.getSource() == button3) {
            if (new Second_Class.Consultas().CountAllFromReservationQuery() == true) {
                new Second_Class.Métodos().Sonido("Notify");
                JOptionPane.showMessageDialog(null, "No hay Registros Existentes.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                new Second_Class.Métodos().DeteleJTable(table2, dtm2);
                new Second_Class.Consultas().ShowReservation_CustomerQuery(table2, dtm2);
            }
        } else if (evt.getSource() == button4) {
            if (new Second_Class.Consultas().CountAllFromReservationQuery() == true) {
                new Second_Class.Métodos().Sonido("Notify");
                JOptionPane.showMessageDialog(null, "No hay Registros Existentes.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                new Reservation.Delete_Reservation().setVisible(true);
                this.setVisible(false);
            }
        } else if (evt.getSource() == button5) {
            if (new Second_Class.Consultas().CountAllFromEmployQuery() == true) {
                new Second_Class.Métodos().Sonido("Notify");
                JOptionPane.showMessageDialog(null, "No hay Registros Existentes.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                new Second_Class.Métodos().DeteleJTable(table3, dtm3);
                new Second_Class.Consultas().ShowEmploy_PostQuery(table3, dtm3);
            }
        } else if (evt.getSource() == button6) {
            if (new Second_Class.Consultas().CountAllFromEmployQuery() == true) {
                new Second_Class.Métodos().Sonido("Notify");
                JOptionPane.showMessageDialog(null, "No hay Registros Existentes.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                new Employ.Add_Employ().setVisible(true);
                this.setVisible(false);
            }
        } else if (evt.getSource() == button7) {
            if (new Second_Class.Consultas().CountAllFromEmployQuery() == true) {
                new Second_Class.Métodos().Sonido("Notify");
                JOptionPane.showMessageDialog(null, "No hay Registros Existentes.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                new Employ.Modify_Employ().setVisible(true);
                this.setVisible(false);
            }
        } else if (evt.getSource() == button8) {
            if (new Second_Class.Consultas().CountAllFromEmployQuery() == true) {
                new Second_Class.Métodos().Sonido("Notify");
                JOptionPane.showMessageDialog(null, "No hay Registros Existentes.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                new Employ.Delete_Employ().setVisible(true);
                this.setVisible(false);
            }
        } else if (evt.getSource() == button9) {
            if (new Second_Class.Consultas().CountAllFromQue_SugQuery() == true) {
                new Second_Class.Métodos().Sonido("Notify");
                JOptionPane.showMessageDialog(null, "No hay Registros Existentes.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                dlm1.removeAllElements();
                new Second_Class.Consultas().ShowComplaint_EmployQuery(list1, dlm1);
            }
        } else if (evt.getSource() == button10) {
            if (new Second_Class.Consultas().CountAllFromQue_SugQuery() == true) {
                new Second_Class.Métodos().Sonido("Notify");
                JOptionPane.showMessageDialog(null, "No hay Registros Existentes.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                new Complaint_Suggestion.Delete_Complaint_Suggestion().setVisible(true);
                this.setVisible(false);
            }
        } else if (evt.getSource() == button11) {
            if (!(radioButton1.isSelected() || radioButton2.isSelected() || radioButton3.isSelected() || radioButton4.isSelected())) {
                new Second_Class.Métodos().Sonido("Notify");
                JOptionPane.showMessageDialog(null, "Seleccione uno de los Formatos de Impresión", "Mensaje", JOptionPane.WARNING_MESSAGE);
            } else if (radioButton1.isSelected()) {
                if (new Second_Class.Consultas().CountAllFromCustomerQuery() == true) {
                    new Second_Class.Métodos().Sonido("Notify");
                    JOptionPane.showMessageDialog(null, "No hay Registros para Imprimir", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    try {
                        new Print.Print().ImprimirPDF("Cliente");
                    } catch (IOException e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                }
            } else if (radioButton2.isSelected()) {
                if (new Second_Class.Consultas().CountAllFromReservationQuery() == true) {
                    new Second_Class.Métodos().Sonido("Notify");
                    JOptionPane.showMessageDialog(null, "No hay Registros para Imprimir", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    try {
                        new Print.Print().ImprimirPDF("ReservacionAdmin");
                    } catch (IOException e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                }
            } else if (radioButton3.isSelected()) {
                if (new Second_Class.Consultas().CountAllFromEmployQuery() == true) {
                    new Second_Class.Métodos().Sonido("Notify");
                    JOptionPane.showMessageDialog(null, "No hay Registros para Imprimir", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    try {
                        new Print.Print().ImprimirPDF("Empleado");
                    } catch (IOException e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                }
            } else if (radioButton4.isSelected()) {
                if (new Second_Class.Consultas().CountAllFromQue_SugQuery() == true) {
                    new Second_Class.Métodos().Sonido("Notify");
                    JOptionPane.showMessageDialog(null, "No hay Registros para Imprimir", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    try {
                        new Print.Print().ImprimirPDF("QueSug");
                    } catch (IOException e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                }
            }
        }
    }

    //Método que Ejecuta las Instrucciones Pertenecientes al Evento WindowsListener.
    @Override
    public void windowOpened(WindowEvent evt) {
        new Second_Class.Métodos().Sonido("Count");
        DateTime();
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
        if (evt.getSource() == button11) {
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/Print_press.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button11.getWidth(), button11.getHeight(), Image.SCALE_DEFAULT));
            button11.setIcon(sizeImg);
        }
    }

    @Override
    public void mouseExited(MouseEvent evt) {
        if (evt.getSource() == button11) {
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/Print_norm.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button11.getWidth(), button11.getHeight(), Image.SCALE_DEFAULT));
            button11.setIcon(sizeImg);
        }
    }
}
