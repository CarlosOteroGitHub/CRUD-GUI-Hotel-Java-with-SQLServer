package Login;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login extends JFrame implements ActionListener, MouseListener {

//*********************************************************************************************************************
    /* Estructura del Frame. */
    int contadorRegistrosCliente = 0, contadorRegistrosAdministrador = 0;
    JLabel label1, label2, label3, label4;
    JTextField textField1;
    JPasswordField password1;
    JButton button1, button2;
    JSeparator separator1;

    public Login() {
        //Caracteristicas del JFrame.
        this.setSize(450, 370);
        this.setLayout(null);
        this.setTitle("Iniciar Sesión");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(false);
        this.getContentPane().setBackground(Color.white);

        //Caracteristicas de los JLabel.
        add(label1 = new JLabel());
        label1.setBounds(88, 8, 255, 80);
        ImageIcon img1 = new ImageIcon(getClass().getResource("/Multimedia/Nombre (Chico).png"));
        ImageIcon sizeImg1 = new ImageIcon(img1.getImage().getScaledInstance(label1.getWidth(), label1.getHeight(), Image.SCALE_DEFAULT));
        label1.setIcon(sizeImg1);

        add(label3 = new JLabel("Email*"));
        label3.setFont(new java.awt.Font("Tahoma", 0, 13));
        label3.setBounds(193, 110, 130, 30);

        add(label4 = new JLabel("Contraseña*"));
        label4.setFont(new java.awt.Font("Syalfen", 0, 13));
        label4.setBounds(180, 190, 130, 30);

        //Caracteristicas de los JTextField.
        add(textField1 = new JTextField());
        textField1.setFont(new java.awt.Font("Tahoma", 0, 14));
        textField1.setBounds(90, 140, 250, 30);
        textField1.addActionListener(this);

        //Caracteristicas de los JPasswordField.
        add(password1 = new JPasswordField());
        password1.setFont(new java.awt.Font("Tahoma", 0, 14));
        password1.setBounds(90, 220, 250, 30);
        password1.addActionListener(this);

        //Caracteristicas de los JButton.
        add(button1 = new JButton());
        button1.setBounds(50, 280, 103, 35);
        button1.setBorderPainted(false);
        button1.setFocusPainted(false);
        button1.setContentAreaFilled(false);
        ImageIcon img3 = new ImageIcon(getClass().getResource("/Multimedia/acep_norm.png"));
        ImageIcon sizeImg3 = new ImageIcon(img3.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_DEFAULT));
        button1.setIcon(sizeImg3);
        button1.addActionListener(this);
        button1.addMouseListener(this);

        add(button2 = new JButton());
        button2.setBounds(260, 280, 103, 35);
        button2.setBorderPainted(false);
        button2.setFocusPainted(false);
        button2.setContentAreaFilled(false);
        ImageIcon img4 = new ImageIcon(getClass().getResource("/Multimedia/canc_norm.png"));
        ImageIcon sizeImg4 = new ImageIcon(img4.getImage().getScaledInstance(button2.getWidth(), button2.getHeight(), Image.SCALE_DEFAULT));
        button2.setIcon(sizeImg4);
        button2.addActionListener(this);
        button2.addMouseListener(this);

        //Caracteristicas de los JSeparator.
        add(separator1 = new JSeparator(SwingConstants.HORIZONTAL));
        separator1.setBounds(15, 90, 410, 10);
    }

//*********************************************************************************************************************
    /* Clases y Metodos de este Frame. */
    //Método que Valida la Entrada al Modulo del Administrador.
    public void Login() {
        String usuario = textField1.getText(), contraseña = password1.getText();
        if (usuario.isEmpty() || contraseña.isEmpty()) {
            this.setVisible(false);
            new Second_Class.Métodos().Sonido("Notify");
            JOptionPane.showMessageDialog(null, "Algunos de los Campos de Texto estan Vacios.", "Mensaje", JOptionPane.WARNING_MESSAGE);
            this.setVisible(true);
        } else {
            ResultSet rsAdministrador = new Second_Class.ConexiónSQL().Consulta("Select count(email), count(contraseña), count(tipoCuenta) from Cuenta where email='" + textField1.getText() + "' and contraseña='" + password1.getText() + "' and tipoCuenta='A'");
            ResultSet rsCliente = new Second_Class.ConexiónSQL().Consulta("Select count(email), count(contraseña), count(tipoCuenta) from Cuenta where email='" + textField1.getText() + "' and contraseña='" + password1.getText() + "' and tipoCuenta='C'");
            try {
                while (rsAdministrador.next() && rsCliente.next()) {
                    contadorRegistrosAdministrador = rsAdministrador.getInt(1);
                    contadorRegistrosCliente = rsCliente.getInt(1);
                }
            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }
            if (contadorRegistrosAdministrador == 1) {
                this.setVisible(false);
                new Admin_Interface.Admin().setVisible(true);
            } else if (contadorRegistrosCliente == 1) {
                new Second_Class.Métodos().setID(new Second_Class.Consultas().ObtainIDCustomer(textField1));
                this.setVisible(false);
                new Customer_Interface.Customer().setVisible(true);
            } else {
                this.setVisible(false);
                new Second_Class.Métodos().Sonido("Error");
                JOptionPane.showMessageDialog(null, "Datos Incorrectos.", "Mensaje", JOptionPane.ERROR_MESSAGE);
                this.setVisible(true);
            }
        }
    }

//Método que Ejecuta las Instrucciones Pertenecientes al Evento ActionListener.
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == button1 || evt.getSource() == textField1 || evt.getSource() == password1) {
            Login();
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
}
