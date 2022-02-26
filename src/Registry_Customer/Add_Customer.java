package Registry_Customer;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

public class Add_Customer extends JFrame implements ActionListener, MouseListener, KeyListener {

//*********************************************************************************************************************
    /* Estructura del Frame. */
    int contadorRegistros = 0;
    JButton button1, button2;
    JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11;
    JTextField textField1, textField2, textField3, textField4, textField5, textField6, textField7;
    JComboBox comboBox1, comboBox2;

    public Add_Customer() {
        this.setSize(470, 665);
        this.setLayout(null);
        this.setTitle("Registro");
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
        textField3.addKeyListener(this);
        textField3.addActionListener(this);

        add(textField4 = new JTextField());
        textField4.setFont(new java.awt.Font("Tahoma", 0, 14));
        textField4.setBounds(120, 275, 310, 30);
        textField4.addActionListener(this);

        add(textField5 = new JTextField());
        textField5.setFont(new java.awt.Font("Tahoma", 0, 14));
        textField5.setBounds(120, 335, 310, 30);
        textField5.addActionListener(this);

        add(textField6 = new JTextField());
        textField6.setFont(new java.awt.Font("Tahoma", 0, 14));
        textField6.setBounds(120, 455, 310, 30);
        textField6.addActionListener(this);

        add(textField7 = new JTextField());
        textField7.setFont(new java.awt.Font("Tahoma", 0, 14));
        textField7.setBounds(120, 515, 310, 30);
        textField7.addActionListener(this);

        //Caracteristicas de los JButton.
        add(button1 = new JButton());
        button1.setBounds(70, 575, 103, 35);
        button1.setBorderPainted(false);
        button1.setFocusPainted(false);
        button1.setContentAreaFilled(false);
        ImageIcon img1 = new ImageIcon(getClass().getResource("/Multimedia/acep_norm.png"));
        ImageIcon sizeImg1 = new ImageIcon(img1.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_DEFAULT));
        button1.setIcon(sizeImg1);
        button1.addActionListener(this);
        button1.addMouseListener(this);

        add(button2 = new JButton());
        button2.setBounds(300, 575, 103, 35);
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
        comboBox2.setBounds(120, 395, 310, 30);
        new Second_Class.Consultas().ShowSates_fromEstadoQuery(comboBox2);

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

        add(label5 = new JLabel("Email:"));
        label5.setFont(new java.awt.Font("Tahoma", 0, 15));
        label5.setBounds(40, 250, 160, 80);

        add(label6 = new JLabel("Teléfono:"));
        label6.setFont(new java.awt.Font("Tahoma", 0, 15));
        label6.setBounds(30, 310, 160, 80);

        add(label7 = new JLabel("Estado:"));
        label7.setFont(new java.awt.Font("Tahoma", 0, 15));
        label7.setBounds(35, 370, 160, 80);

        add(label8 = new JLabel("Contraseña:"));
        label8.setFont(new java.awt.Font("Tahoma", 0, 15));
        label8.setBounds(25, 430, 160, 80);

        add(label9 = new JLabel("Cuenta"));
        label9.setFont(new java.awt.Font("Tahoma", 0, 15));
        label9.setBounds(38, 480, 160, 80);

        add(label10 = new JLabel("Bancaria:"));
        label10.setFont(new java.awt.Font("Tahoma", 0, 15));
        label10.setBounds(34, 500, 160, 80);

        add(label11 = new JLabel());
        label11.setFont(new java.awt.Font("Tahoma", 0, 15));
        label11.setBounds(267, 224, 207, 419);
        ImageIcon img3 = new ImageIcon(getClass().getResource("/Multimedia/Fondo 1.png"));
        ImageIcon sizeImg3 = new ImageIcon(img3.getImage().getScaledInstance(label11.getWidth(), label11.getHeight(), Image.SCALE_DEFAULT));
        label11.setIcon(sizeImg3);
    }

//*********************************************************************************************************************
    /* Clases y Metodos de este Frame. */
    //Método que Ejecuta las Instrucciones Pertenecientes al Evento ActionListener.
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == button1) {
            if (textField1.getText().isEmpty() || textField2.getText().isEmpty() || textField3.getText().isEmpty() || textField4.getText().isEmpty() || textField5.getText().isEmpty() || textField6.getText().isEmpty() || textField7.getText().isEmpty()) {
                this.setVisible(false);
                new Second_Class.Métodos().Sonido("Notify");
                JOptionPane.showMessageDialog(null, "Algunos de los Campos de Texto Quedaron Vacios.", "Mensaje", JOptionPane.WARNING_MESSAGE);
                this.setVisible(true);
            } else if (new Second_Class.Métodos().SoloLetras(textField1.getText()) == false || new Second_Class.Métodos().SoloLetras(textField2.getText()) == false) {
                this.setVisible(false);
                new Second_Class.Métodos().Sonido("Error");
                JOptionPane.showMessageDialog(null, "Algunos de los Valores no Corresponden con el Campo Solicitado.", "Error de Captura", JOptionPane.ERROR_MESSAGE);
                this.setVisible(true);
            } else if (new Second_Class.Métodos().SoloNumeros(textField3.getText()) == false || new Second_Class.Métodos().SoloNumeros(textField5.getText()) == false) {
                this.setVisible(false);
                new Second_Class.Métodos().Sonido("Error");
                JOptionPane.showMessageDialog(null, "Algunos de los Valores no Corresponden con el Campo Solicitado.", "Error de Captura", JOptionPane.ERROR_MESSAGE);
                this.setVisible(true);
            } else if (Integer.parseInt(textField3.getText()) <= 18 || Integer.parseInt(textField3.getText()) >= 110) {
                this.setVisible(false);
                new Second_Class.Métodos().Sonido("Notify");
                JOptionPane.showMessageDialog(null, "Edad Fuera de Rango, Por Favor Ingrese de Nuevo su Edad.", "Mensaje", JOptionPane.WARNING_MESSAGE);
                this.setVisible(true);
            } else if (!(textField4.getText().contains("@gmail.com") || textField4.getText().contains("@hotmail.com") || textField4.getText().contains("@yahoo.com") || textField4.getText().contains("@itcelaya.edu.mx"))) {
                this.setVisible(false);
                new Second_Class.Métodos().Sonido("Error");
                JOptionPane.showMessageDialog(null, "Correo Electronico no Valido Intente con Otro.", "Error", JOptionPane.ERROR_MESSAGE);
                this.setVisible(true);
            } else if (textField5.getText().length() != 10) {
                this.setVisible(false);
                new Second_Class.Métodos().Sonido("Notify");
                JOptionPane.showMessageDialog(null, "Los Números Telefonicos Deven ser de 10 Digitos.", "Mensaje", JOptionPane.WARNING_MESSAGE);
                this.setVisible(true);
            } else if (textField7.getText().length() != 10) {
                this.setVisible(false);
                new Second_Class.Métodos().Sonido("Notify");
                JOptionPane.showMessageDialog(null, "Los Números de Cuenta Bancaria Deven ser de 10 Digitos.", "Mensaje", JOptionPane.WARNING_MESSAGE);
                this.setVisible(true);
            } else if (new Second_Class.Métodos().SoloLetrasMayusculas_Numeros(textField7.getText()) == false) {
                this.setVisible(false);
                new Second_Class.Métodos().Sonido("Error");
                JOptionPane.showMessageDialog(null, "Número de Cuenta Bancaria no Existente, Ingresela de Nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                this.setVisible(true);
            } else {
                try {
                    ResultSet rs = new Second_Class.ConexiónSQL().Consulta("Select count(email) from Cuenta where email='" + textField4.getText() + "'");
                    try {
                        while (rs.next()) {
                            contadorRegistros = rs.getInt(1);
                        }
                    } catch (SQLException e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                    if (contadorRegistros >= 1) {
                        this.setVisible(false);
                        new Second_Class.Métodos().Sonido("Notify");
                        JOptionPane.showMessageDialog(null, "El Email que Ingreso ya esta Registrado, Intente con Otro.", "Mensaje", JOptionPane.WARNING_MESSAGE);
                        this.setVisible(true);
                    } else {
                        new Second_Class.ProcedimientosAlmacenados().AltaCuenta(textField4.getText(), textField6.getText(), "C");
                        new Second_Class.ProcedimientosAlmacenados().AltaCuentaBancaria(textField7.getText(), "2500", String.valueOf(new Second_Class.Métodos().NumeroAleatorio()));
                        new Second_Class.ProcedimientosAlmacenados().AltaCliente(textField1.getText(), textField2.getText(), textField3.getText(), new Second_Class.Métodos().ChangeSexo_to_S(comboBox1), textField5.getText(), Integer.toString(new Second_Class.Consultas().ident_CurrentQuery("Cuenta")), new Second_Class.Consultas().ShowID_NamefromEstadoQuery(comboBox2.getSelectedItem().toString()), null, Integer.toString(new Second_Class.Consultas().ident_CurrentQuery("CuentaBancaria")));
                        new Second_Class.Métodos().Sonido("Correcto");
                        ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/Right.png"));
                        JOptionPane.showMessageDialog(null, "Captura Exitosa.", "Mensaje", JOptionPane.INFORMATION_MESSAGE, img);
                        this.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Ya Puedes Ingresar a Tu Cuenta, Proporcionando tu Email y Contraseña.", "Ingresa a tu Cuenta de Usuario", JOptionPane.INFORMATION_MESSAGE);
                        new Start_Interface.Inicio().setVisible(true);
                    }
                } catch (SQLException e) {
                    System.err.println("Error: " + e.getMessage());
                }
            }
        } else if (evt.getSource() == button2) {
            new Start_Interface.Inicio().setVisible(true);
            this.setVisible(false);
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

    //Método que Ejecuta las Instrucciones Pertenecientes al EventokeyListener.
    @Override
    public void keyTyped(KeyEvent evt) {
        if (textField3.getText().length() == 3) {
            evt.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent evt) {
    }

    @Override
    public void keyReleased(KeyEvent evt) {
    }
}
