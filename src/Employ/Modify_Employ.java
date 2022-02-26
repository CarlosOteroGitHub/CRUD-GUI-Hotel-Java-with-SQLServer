package Employ;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Modify_Employ extends JFrame implements ActionListener, MouseListener, FocusListener {

//*********************************************************************************************************************
    /* Estructura del Frame. */
    int contadorRegistrosIDEmploy = 0;
    String placeHolder1 = "Ingrese el ID del Empleado";
    JButton button1, button2;
    JLabel label1;
    JTextField textField1;

    public Modify_Employ() {
        //Caracteristicas del JFrame.
        this.setSize(330, 150);
        this.setLayout(null);
        this.setTitle("Actualizar Empleado");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(false);
        this.getContentPane().setBackground(Color.white);

        //Caracteristicas de los JTextField.
        add(textField1 = new JTextField());
        textField1.setFont(new java.awt.Font("Tahoma", 0, 14));
        textField1.setBounds(45, 20, 230, 30);
        textField1.addActionListener(this);
        textField1.addFocusListener(this);
        textField1.addMouseListener(this);

        //Caracteristicas de los JButton.
        add(button1 = new JButton());
        button1.setBounds(26, 70, 103, 35);
        button1.setBorderPainted(false);
        button1.setFocusPainted(false);
        button1.setContentAreaFilled(false);
        ImageIcon img1 = new ImageIcon(getClass().getResource("/Multimedia/acep_norm.png"));
        ImageIcon sizeImg1 = new ImageIcon(img1.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_DEFAULT));
        button1.setIcon(sizeImg1);
        button1.addActionListener(this);
        button1.addMouseListener(this);

        add(button2 = new JButton());
        button2.setBounds(196, 70, 103, 35);
        button2.setBorderPainted(false);
        button2.setFocusPainted(false);
        button2.setContentAreaFilled(false);
        ImageIcon img2 = new ImageIcon(getClass().getResource("/Multimedia/canc_norm.png"));
        ImageIcon sizeImg2 = new ImageIcon(img2.getImage().getScaledInstance(button2.getWidth(), button2.getHeight(), Image.SCALE_DEFAULT));
        button2.setIcon(sizeImg2);
        button2.addActionListener(this);
        button2.addMouseListener(this);

        //Sentencia que Inicializa el Mensaje PlaceHolder Dentro del JTextField.
        new Second_Class.Métodos().PlaceHolderActivo2(textField1, placeHolder1, 0);
    }

//*********************************************************************************************************************
    /* Clases y Metodos de este Frame. */
    //Método que Ejecuta las Instrucciones Pertenecientes al Evento ActionListener.
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == button1) {
            if (textField1.getText().isEmpty() || !textField1.getForeground().equals(Color.BLACK)) {
                this.setVisible(false);
                new Second_Class.Métodos().Sonido("Error");
                JOptionPane.showMessageDialog(null, "Ingrese el ID del Empleado en el Campo de Texto.", "Error", JOptionPane.ERROR_MESSAGE);
                this.setVisible(true);
            } else if (new Second_Class.Métodos().SoloNumeros(textField1.getText()) == false) {
                this.setVisible(false);
                new Second_Class.Métodos().Sonido("Error");
                JOptionPane.showMessageDialog(null, "Solo se Admiten Digitos Númericos.", "Error de Captura", JOptionPane.ERROR_MESSAGE);
                this.setVisible(true);
                textField1.setText("");
                new Second_Class.Métodos().PlaceHolderActivo2(textField1, placeHolder1, 0);
            } else {
                ResultSet rsIDEmploy = new Second_Class.ConexiónSQL().Consulta("Select count(id_empleado) from Empleado where id_empleado='" + textField1.getText() + "'");
                try {
                    while (rsIDEmploy.next()) {
                        contadorRegistrosIDEmploy = rsIDEmploy.getInt(1);
                    }

                    if (contadorRegistrosIDEmploy == 1) {
                        new Second_Class.Métodos().setID(Integer.parseInt(textField1.getText()));
                        this.setVisible(false);
                        new Employ.Modify_Employ_Interface().setVisible(true);
                    } else {
                        this.setVisible(false);
                        new Second_Class.Métodos().Sonido("Error");
                        JOptionPane.showMessageDialog(null, "ID no Encontrado.", "Mensaje", JOptionPane.ERROR_MESSAGE);
                        this.setVisible(true);
                        textField1.setText("");
                        new Second_Class.Métodos().PlaceHolderActivo2(textField1, placeHolder1, 0);
                    }
                } catch (SQLException e) {
                    System.err.println("Error: " + e.getMessage());
                }

            }
        } else if (evt.getSource() == button2) {
            new Admin_Interface.Admin().setVisible(true);
            this.setVisible(false);
        }
    }

    //Método que Ejecuta las Instrucciones Pertenecientes al Evento MouseListener.
    @Override
    public void mouseClicked(MouseEvent evt) {
        new Second_Class.Métodos().PlaceHolderInactivo2(textField1, placeHolder1);
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

    //Método que Ejecuta las Instrucciones Pertenecientes al Evento FocusListener. 
    @Override
    public void focusGained(FocusEvent evt) {
    }

    @Override
    public void focusLost(FocusEvent evt) {
        new Second_Class.Métodos().PlaceHolderActivo2(textField1, placeHolder1, textField1.getText().trim().length());
    }
}

class Modify_Employ_Interface extends JFrame implements ActionListener, MouseListener, FocusListener {

//*********************************************************************************************************************
    /* Estructura del Frame. */
    int SaveIDFromModify_Employ = new Second_Class.Métodos().getID();
    String placeHolder1 = "Formato de Fecha: DD/MM/AAAA";
    JButton button1, button2;
    JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9;
    JTextField textField1, textField2, textField3, textField4;
    JComboBox comboBox1, comboBox2;

    public Modify_Employ_Interface() {
        //Caracteristicas del JFrame.
        this.setSize(470, 500);
        this.setLayout(null);
        this.setTitle("Actualizar Empleado");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(false);
        this.getContentPane().setBackground(Color.white);

        //Caracteristicas de los JTextField.
        add(textField1 = new JTextField());
        textField1.setFont(new java.awt.Font("Tahoma", 0, 14));
        textField1.setBounds(120, 35, 310, 30);
        textField1.addActionListener(this);

        add(textField2 = new JTextField());
        textField2.setFont(new java.awt.Font("Tahoma", 0, 14));
        textField2.setBounds(120, 95, 310, 30);
        textField2.addActionListener(this);

        add(textField3 = new JTextField());
        textField3.setFont(new java.awt.Font("Tahoma", 0, 14));
        textField3.setBounds(120, 155, 310, 30);
        textField3.addActionListener(this);

        add(textField4 = new JTextField());
        textField4.setFont(new java.awt.Font("Tahoma", 0, 14));
        textField4.setBounds(120, 275, 310, 30);
        textField4.addActionListener(this);
        textField4.addFocusListener(this);
        textField4.addMouseListener(this);

        //Caracteristicas de los JButton.
        add(button1 = new JButton());
        button1.setBounds(70, 410, 103, 35);
        button1.setBorderPainted(false);
        button1.setFocusPainted(false);
        button1.setContentAreaFilled(false);
        ImageIcon img1 = new ImageIcon(getClass().getResource("/Multimedia/update_norm.png"));
        ImageIcon sizeImg1 = new ImageIcon(img1.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_DEFAULT));
        button1.setIcon(sizeImg1);
        button1.addActionListener(this);
        button1.addMouseListener(this);

        add(button2 = new JButton());
        button2.setBounds(300, 410, 103, 35);
        button2.setBorderPainted(false);
        button2.setFocusPainted(false);
        button2.setContentAreaFilled(false);
        ImageIcon img2 = new ImageIcon(getClass().getResource("/Multimedia/canc_norm.png"));
        ImageIcon sizeImg2 = new ImageIcon(img2.getImage().getScaledInstance(button2.getWidth(), button2.getHeight(), Image.SCALE_DEFAULT));
        button2.setIcon(sizeImg2);
        button2.addActionListener(this);
        button2.addMouseListener(this);

        //Caracteristicas del ComboBox.
        add(comboBox1 = new JComboBox());
        comboBox1.setBounds(120, 215, 310, 30);
        comboBox1.addItem("Masculino");
        comboBox1.addItem("Femenino");

        add(comboBox2 = new JComboBox());
        comboBox2.setBounds(120, 335, 310, 30);
        comboBox2.addItem("Gerencia");
        comboBox2.addItem("Finanzas");
        comboBox2.addItem("Informática");
        comboBox2.addItem("Seguridad");
        comboBox2.addItem("Mantenimiento");
        comboBox2.addItem("Cocina");
        comboBox2.addItem("Estacionamiento");

        //Caracteristicas de los JLabel.
        add(label1 = new JLabel("Nombre:"));
        label1.setFont(new java.awt.Font("Tahoma", 0, 15));
        label1.setBounds(30, 10, 160, 80);

        add(label2 = new JLabel("Apellidos:"));
        label2.setFont(new java.awt.Font("Tahoma", 0, 15));
        label2.setBounds(30, 70, 160, 80);

        add(label3 = new JLabel("Edad:"));
        label3.setFont(new java.awt.Font("Tahoma", 0, 15));
        label3.setBounds(40, 130, 160, 80);

        add(label4 = new JLabel("Sexo:"));
        label4.setFont(new java.awt.Font("Tahoma", 0, 15));
        label4.setBounds(40, 190, 160, 80);

        add(label5 = new JLabel("Antiguedad:"));
        label5.setFont(new java.awt.Font("Tahoma", 0, 15));
        label5.setBounds(23, 250, 160, 80);

        add(label6 = new JLabel("Cargo:"));
        label6.setFont(new java.awt.Font("Tahoma", 0, 15));
        label6.setBounds(40, 310, 160, 80);

        //Sentencia que Inicializa el Mensaje PlaceHolder Dentro del JTextField.
        new Second_Class.Métodos().PlaceHolderActivo2(textField4, placeHolder1, 0);

        //Sentencia de Código que Muestra los Datos Anexos al ID del cliente, para ser Modificados en la Base de Datos.
        try {
            ResultSet rs = new Second_Class.ConexiónSQL().Consulta("Select id_empleado, nombre, apellidos, edad, sexo, tipoPue from Empleado");
            while (rs.next()) {
                if (SaveIDFromModify_Employ == Integer.parseInt(rs.getString(1))) {
                    textField1.setText(rs.getString(2));
                    textField2.setText(rs.getString(3));
                    textField3.setText(rs.getString(4));
                    if (rs.getString(5).equals("M")) {
                        comboBox1.setSelectedIndex(0);
                    } else {
                        comboBox1.setSelectedIndex(1);
                    }

                    if (rs.getString(6).equals("G")) {
                        comboBox2.setSelectedIndex(0);
                    } else if (rs.getString(6).equals("F")) {
                        comboBox2.setSelectedIndex(1);
                    } else if (rs.getString(6).equals("I")) {
                        comboBox2.setSelectedIndex(2);
                    } else if (rs.getString(6).equals("S")) {
                        comboBox2.setSelectedIndex(3);
                    } else if (rs.getString(6).equals("M")) {
                        comboBox2.setSelectedIndex(4);
                    } else if (rs.getString(6).equals("C")) {
                        comboBox2.setSelectedIndex(5);
                    } else if (rs.getString(6).equals("E")) {
                        comboBox2.setSelectedIndex(6);
                    }
                    break;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

//*********************************************************************************************************************
    /* Clases y Metodos de este Frame. */
    //Método que Ejecuta las Instrucciones Pertenecientes al Evento ActionListener.
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == button1) {
            if (textField1.getText().isEmpty() || textField2.getText().isEmpty() || textField3.getText().isEmpty() || textField4.getText().isEmpty() || !(textField4.getForeground().equals(Color.BLACK))) {
                this.setVisible(false);
                new Second_Class.Métodos().Sonido("Notify");
                JOptionPane.showMessageDialog(null, "Algunos de los Campos de Texto Quedaron Vacios.", "Mensaje", JOptionPane.WARNING_MESSAGE);
                this.setVisible(true);
            } else if (new Second_Class.Métodos().SoloLetras(textField1.getText()) == false || new Second_Class.Métodos().SoloLetras(textField2.getText()) == false) {
                this.setVisible(false);
                new Second_Class.Métodos().Sonido("Error");
                JOptionPane.showMessageDialog(null, "Algunos de los Valores no Corresponden con el Campo Solicitado.", "Error de Captura", JOptionPane.ERROR_MESSAGE);
                this.setVisible(true);
            } else if (new Second_Class.Métodos().SoloNumeros(textField3.getText()) == false) {
                this.setVisible(false);
                new Second_Class.Métodos().Sonido("Error");
                JOptionPane.showMessageDialog(null, "Algunos de los Valores no Corresponden con el Campo Solicitado.", "Error de Captura", JOptionPane.ERROR_MESSAGE);
                this.setVisible(true);
            } else if (Integer.parseInt(textField3.getText()) <= 18 || Integer.parseInt(textField3.getText()) >= 110) {
                this.setVisible(false);
                new Second_Class.Métodos().Sonido("Notify");
                JOptionPane.showMessageDialog(null, "Edad Fuera de Rango, Por Favor Ingrese de Nuevo su Edad.", "Mensaje", JOptionPane.WARNING_MESSAGE);
                this.setVisible(true);
            } else {
                try {
                    new Second_Class.ProcedimientosAlmacenados().ActualizarEmpleado(String.valueOf(SaveIDFromModify_Employ), textField1.getText(), textField2.getText(), textField3.getText(), new Second_Class.Métodos().ChangeSexo_to_S(comboBox1), textField4.getText(), new Second_Class.Métodos().ChangePuesto_to_P(comboBox2));
                    new Second_Class.Métodos().Sonido("Correcto");
                    ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/Right.png"));
                    JOptionPane.showMessageDialog(null, "Operación Exitosa.", "Mensaje", JOptionPane.INFORMATION_MESSAGE, img);
                    this.setVisible(false);
                    new Admin_Interface.Admin().setVisible(true);
                } catch (SQLException e) {
                    System.err.println("Error: " + e.getMessage());
                }
            }
        } else if (evt.getSource() == button2) {
            new Admin_Interface.Admin().setVisible(true);
            this.setVisible(false);
        }
    }

    //Método que Ejecuta las Instrucciones Pertenecientes al Evento MouseListener.
    @Override
    public void mouseClicked(MouseEvent evt) {
        new Second_Class.Métodos().PlaceHolderInactivo2(textField4, placeHolder1);
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
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/update_press.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_DEFAULT));
            button1.setIcon(sizeImg);
        } else if (evt.getSource() == button2) {
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/canc_roll.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button2.getWidth(), button2.getHeight(), Image.SCALE_DEFAULT));
            button2.setIcon(sizeImg);
        }
    }

    @Override
    public void mouseExited(MouseEvent evt) {
        if (evt.getSource() == button1) {
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/update_norm.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_DEFAULT));
            button1.setIcon(sizeImg);
        } else if (evt.getSource() == button2) {
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/canc_norm.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button2.getWidth(), button2.getHeight(), Image.SCALE_DEFAULT));
            button2.setIcon(sizeImg);
        }
    }

    //Método que Ejecuta las Instrucciones Pertenecientes al Evento FocusListener. 
    @Override
    public void focusGained(FocusEvent evt) {
    }

    @Override
    public void focusLost(FocusEvent evt) {
        new Second_Class.Métodos().PlaceHolderActivo2(textField4, placeHolder1, textField4.getText().trim().length());
    }
}
