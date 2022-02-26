package Second_Class;

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

public class MisDatos extends JFrame implements ActionListener, MouseListener {
//---------------------------------------------------------------------------------------------------------------------

    /* Estructura del JFrame. */
    int SaveIDFromCustomer_Interface = new Second_Class.Métodos().getID();
    JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12, label13, label14, label15;
    JButton button1;

    public MisDatos() {
        //Caracteristicas de este JFrame.
        this.setTitle("Mis Datos");
        this.setLayout(null);
        this.setSize(380, 720);
        this.setResizable(false);
        this.setUndecorated(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);

        //Caracteristicas de los JButton.
        add(button1 = new JButton());
        button1.setBounds(233, 640, 103, 35);
        button1.setBorderPainted(false);
        button1.setFocusPainted(false);
        button1.setContentAreaFilled(false);
        ImageIcon img2 = new ImageIcon(getClass().getResource("/Multimedia/acep_norm.png"));
        ImageIcon sizeImg2 = new ImageIcon(img2.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_DEFAULT));
        button1.setIcon(sizeImg2);
        button1.addActionListener(this);
        button1.addMouseListener(this);

        //Caracteristicas de los JLabel.
        add(label1 = new JLabel());
        label1.setFont(new java.awt.Font("Tahoma", 0, 16));
        label1.setBounds(56, 54, 300, 30);

        add(label2 = new JLabel());
        label2.setFont(new java.awt.Font("Tahoma", 0, 16));
        label2.setBounds(177, 144, 300, 30);

        add(label3 = new JLabel());
        label3.setFont(new java.awt.Font("Tahoma", 0, 16));
        label3.setBounds(144, 234, 300, 30);

        add(label4 = new JLabel());
        label4.setFont(new java.awt.Font("Tahoma", 0, 16));
        label4.setBounds(56, 324, 300, 30);

        add(label5 = new JLabel());
        label5.setFont(new java.awt.Font("Tahoma", 0, 16));
        label5.setBounds(130, 414, 300, 30);

        add(label6 = new JLabel());
        label6.setFont(new java.awt.Font("Tahoma", 0, 16));
        label6.setBounds(106, 504, 300, 30);
        
        add(label7 = new JLabel());
        label7.setFont(new java.awt.Font("Tahoma", 0, 16));
        label7.setBounds(126, 594, 300, 30);

        add(label8 = new JLabel());
        label8.setBounds(35, 15, 305, 78);
        ImageIcon img3 = new ImageIcon(getClass().getResource("/Multimedia/nombre.png"));
        ImageIcon sizeImg3 = new ImageIcon(img3.getImage().getScaledInstance(label8.getWidth(), label8.getHeight(), Image.SCALE_DEFAULT));
        label8.setIcon(sizeImg3);

        add(label9 = new JLabel());
        label9.setBounds(35, 105, 305, 78);
        ImageIcon img4 = new ImageIcon(getClass().getResource("/Multimedia/edad.png"));
        ImageIcon sizeImg4 = new ImageIcon(img4.getImage().getScaledInstance(label9.getWidth(), label9.getHeight(), Image.SCALE_DEFAULT));
        label9.setIcon(sizeImg4);

        add(label10 = new JLabel());
        label10.setBounds(35, 195, 305, 78);
        ImageIcon img5 = new ImageIcon(getClass().getResource("/Multimedia/sexo.png"));
        ImageIcon sizeImg5 = new ImageIcon(img5.getImage().getScaledInstance(label10.getWidth(), label10.getHeight(), Image.SCALE_DEFAULT));
        label10.setIcon(sizeImg5);

        add(label11 = new JLabel());
        label11.setBounds(35, 285, 305, 78);
        ImageIcon img6 = new ImageIcon(getClass().getResource("/Multimedia/email.png"));
        ImageIcon sizeImg6 = new ImageIcon(img6.getImage().getScaledInstance(label11.getWidth(), label11.getHeight(), Image.SCALE_DEFAULT));
        label11.setIcon(sizeImg6);

        add(label12 = new JLabel());
        label12.setBounds(35, 375, 305, 78);
        ImageIcon img7 = new ImageIcon(getClass().getResource("/Multimedia/teléfono.png"));
        ImageIcon sizeImg7 = new ImageIcon(img7.getImage().getScaledInstance(label12.getWidth(), label12.getHeight(), Image.SCALE_DEFAULT));
        label12.setIcon(sizeImg7);

        add(label13 = new JLabel());
        label13.setBounds(35, 465, 305, 78);
        ImageIcon img8 = new ImageIcon(getClass().getResource("/Multimedia/estado.png"));
        ImageIcon sizeImg8 = new ImageIcon(img8.getImage().getScaledInstance(label13.getWidth(), label13.getHeight(), Image.SCALE_DEFAULT));
        label13.setIcon(sizeImg8);
        
        add(label14 = new JLabel());
        label14.setBounds(35, 555, 305, 78);
        ImageIcon img9 = new ImageIcon(getClass().getResource("/Multimedia/cuentaBancaria.png"));
        ImageIcon sizeImg9 = new ImageIcon(img9.getImage().getScaledInstance(label14.getWidth(), label14.getHeight(), Image.SCALE_DEFAULT));
        label14.setIcon(sizeImg9);

        add(label15 = new JLabel());
        label15.setBounds(0, 585, 92, 148);
        ImageIcon img10 = new ImageIcon(getClass().getResource("/Multimedia/Fondo 3.png"));
        ImageIcon sizeImg10 = new ImageIcon(img10.getImage().getScaledInstance(label15.getWidth(), label15.getHeight(), Image.SCALE_DEFAULT));
        label15.setIcon(sizeImg10);

        //Sentencia de Código que Muestra los Datos Anexos al ID del cliente y a su Cuenta, para ser Modificados en la Base de Datos.
        try {
            ResultSet rs = new Second_Class.ConexiónSQL().Consulta("Select cl.id_cliente, cl.nombre, cl.apellidos, cl.edad, cl.sexo, cu.email, cl.telefono, e.nombre, cb.numeroTarjeta from Cliente cl inner join Cuenta cu on cl.id_cuenta = cu.id_cuenta inner join Estado e on cl.id_estado = e.id_estado inner join CuentaBancaria cb on cl.id_cuentaBancaria = cb.id_cuentaBancaria where cl.id_cuenta = '" + new Second_Class.Consultas().ObtainIDCountFromIDCustomer(SaveIDFromCustomer_Interface) + "'");
            while (rs.next()) {
                if (SaveIDFromCustomer_Interface == Integer.parseInt(rs.getString(1))) {
                    label1.setText(rs.getString(2) + " " + rs.getString(3));
                    label2.setText(rs.getString(4));
                    label3.setText(new Second_Class.Métodos().ChangeS_to_Sexo(rs.getString(5)));
                    label4.setText(rs.getString(6));
                    label5.setText(rs.getString(7));
                    label6.setText(rs.getString(8));
                    label7.setText(rs.getString(9));
                    break;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

//---------------------------------------------------------------------------------------------------------------------
    /* Clases y Metodos de este JFrame. */
    //Método que Ejecuta las Instrucciones Pertenecientes al Evento ActionListener.
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == button1) {
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
        }
    }

    @Override
    public void mouseExited(MouseEvent evt) {
        if (evt.getSource() == button1) {
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/acep_norm.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_DEFAULT));
            button1.setIcon(sizeImg);
        }
    }
}
