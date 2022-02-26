package Change_Password;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Change_Password_Customer extends JFrame implements ActionListener, MouseListener, FocusListener {

//*********************************************************************************************************************
    /* Estructura del Frame. */
    int SaveIDFromCustomer_Interface = new Second_Class.Métodos().getID();
    String placeHolder1 = "Ingrese la Nueva Contraseña";
    JButton button1, button2;
    JLabel label1;
    JTextField textField1;

    public Change_Password_Customer() {
        this.setSize(330, 150);
        this.setLayout(null);
        this.setTitle("Actualizar Contraseña");
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
        ImageIcon img1 = new ImageIcon(getClass().getResource("/Multimedia/update_norm.png"));
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

    //Método que Ejecuta las Instrucciones Pertenecientes al Evento ActionListener.
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == button1) {
            if (textField1.getText().isEmpty() || !textField1.getForeground().equals(Color.BLACK)) {
                this.setVisible(false);
                new Second_Class.Métodos().Sonido("Error");
                JOptionPane.showMessageDialog(null, "Ingrese la Nueva Contraseña en el Campo de Texto.", "Error", JOptionPane.ERROR_MESSAGE);
                this.setVisible(true);
            } else {
                try {
                    int idCount = new Second_Class.Consultas().ObtainIDCountFromIDCustomer(SaveIDFromCustomer_Interface);
                    new Second_Class.ProcedimientosAlmacenados().ActualizarContraseña(String.valueOf(idCount), textField1.getText());
                    this.setVisible(false);
                    new Second_Class.Métodos().Sonido("Correcto");
                    ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/Right.png"));
                    JOptionPane.showMessageDialog(null, "Operación Exitosa.", "Mensaje", JOptionPane.INFORMATION_MESSAGE, img);
                    new Customer_Interface.Customer().setVisible(true);
                } catch (SQLException e) {
                    System.err.println("Error: " + e.getMessage());
                }
            }

        } else if (evt.getSource() == button2) {
            new Customer_Interface.Customer().setVisible(true);
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
        new Second_Class.Métodos().PlaceHolderActivo2(textField1, placeHolder1, textField1.getText().trim().length());
    }
}
