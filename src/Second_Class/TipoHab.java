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
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class TipoHab extends JFrame implements ActionListener, MouseListener {

//*********************************************************************************************************************
    /* Estructura del Frame. */
    JLabel label1, label2, label3, label4, label5, label6, label7, label8;
    JButton button1;
    JPanel panel1;
    JSeparator separator1, separator2, separator3, separator4, separator5, separator6;

    public TipoHab(String tipoHab) {
        //Caracteristicas del JFrame.
        this.setSize(400, 510);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(false);
        this.getContentPane().setBackground(Color.white);

        //Caracteristicas de los JPanel.
//        add(panel1 = new JPanel());
//        panel1.setLayout(null);
//        panel1.setBounds(6, 6, 381, 200);
//        panel1.add(label1 = new JLabel());
        //Caracteristicas de los JButton.
        add(button1 = new JButton());
        button1.setBounds(140, 437, 103, 35);
        button1.setBorderPainted(false);
        button1.setFocusPainted(false);
        button1.setContentAreaFilled(false);
        ImageIcon img1 = new ImageIcon(getClass().getResource("/Multimedia/acep_norm.png"));
        ImageIcon sizeImg1 = new ImageIcon(img1.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_DEFAULT));
        button1.setIcon(sizeImg1);
        button1.addActionListener(this);
        button1.addMouseListener(this);

        //Caracteristicas de los JLabel.
        add(label1 = new JLabel("Nombre"));
        label1.setFont(new java.awt.Font("Tahoma", 1, 15));
        label1.setBounds(30, 200, 100, 80);

        add(label2 = new JLabel());
        label2.setFont(new java.awt.Font("Tahoma", 0, 15));
        label2.setBounds(130, 200, 150, 80);

        add(label3 = new JLabel("Cupo"));
        label3.setFont(new java.awt.Font("Tahoma", 1, 15));
        label3.setBounds(41, 239, 100, 80);

        add(label4 = new JLabel());
        label4.setFont(new java.awt.Font("Tahoma", 0, 15));
        label4.setBounds(130, 239, 150, 80);

        add(label5 = new JLabel("Costo"));
        label5.setFont(new java.awt.Font("Tahoma", 1, 15));
        label5.setBounds(39, 279, 100, 80);

        add(label6 = new JLabel());
        label6.setFont(new java.awt.Font("Tahoma", 0, 15));
        label6.setBounds(130, 279, 150, 80);

        add(label7 = new JLabel("Descripción"));
        label7.setFont(new java.awt.Font("Tahoma", 1, 15));
        label7.setBounds(15, 341, 100, 80);

        add(label8 = new JLabel());
        label8.setFont(new java.awt.Font("Tahoma", 0, 15));
        label8.setBounds(130, 321, 300, 80);

        //Caracteristicas de los JSeparator.
        add(separator1 = new JSeparator(SwingConstants.HORIZONTAL));
        separator1.setBounds(10, 218, 374, 10);

        add(separator2 = new JSeparator(SwingConstants.VERTICAL));
        separator2.setBounds(115, 220, 10, 200);

        add(separator3 = new JSeparator(SwingConstants.HORIZONTAL));
        separator3.setBounds(10, 258, 374, 10);

        add(separator4 = new JSeparator(SwingConstants.HORIZONTAL));
        separator4.setBounds(10, 298, 374, 10);

        add(separator5 = new JSeparator(SwingConstants.HORIZONTAL));
        separator5.setBounds(10, 338, 374, 10);

        add(separator6 = new JSeparator(SwingConstants.HORIZONTAL));
        separator6.setBounds(10, 418, 374, 10);

        //Sentencia de Codigo que Carga los Datos de una Determinada Habitación.
        if (tipoHab.equals("I")) {
            this.setTitle("Habitación Individual");
            add(panel1 = new JPanel());
            panel1.setLayout(null);
            panel1.setBounds(6, 6, 381, 200);
            panel1.add(label1 = new JLabel());
            label1.setBounds(0, 0, 381, 200);
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/Hab Sim.jpg"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(label1.getWidth(), label1.getHeight(), Image.SCALE_DEFAULT));
            label1.setIcon(sizeImg);
            try {
                ResultSet rs = new Second_Class.ConexiónSQL().Consulta("select nombre, cupo, costo, descripcion from TipoHabitacion where tipoHab = 'I'");
                while (rs.next()) {
                    label2.setText("Habitación ".concat(rs.getString(1)));
                    label4.setText(rs.getString(2).concat(" Persona"));
                    label6.setText("$ ".concat(rs.getString(3)));
                    label8.setText(rs.getString(4));
                }
            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }
        } else {
            this.setTitle("Habitación Compartida");
            add(panel1 = new JPanel());
            panel1.setLayout(null);
            panel1.setBounds(6, 6, 381, 200);
            panel1.add(label1 = new JLabel());
            label1.setBounds(0, 0, 381, 200);
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/Hab Mat.jpg"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(label1.getWidth(), label1.getHeight(), Image.SCALE_DEFAULT));
            label1.setIcon(sizeImg);
            try {
                ResultSet rs = new Second_Class.ConexiónSQL().Consulta("select nombre, cupo, costo, descripcion from TipoHabitacion where tipoHab = 'C'");
                while (rs.next()) {
                    label2.setText("Habitación ".concat(rs.getString(1)));
                    label4.setText(rs.getString(2).concat(" Personas"));
                    label6.setText("$ ".concat(rs.getString(3)));
                    label8.setText(rs.getString(4));
                }
            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

//*********************************************************************************************************************
    /* Clases y Metodos de este Frame. */
    //Método que Ejecuta las Instrucciones Pertenecientes al Evento ActionListener.   
    @Override
    public void actionPerformed(ActionEvent evt
    ) {
        if (evt.getSource() == button1) {
            this.setVisible(false);
            new Reservation.Add_Reservation().setVisible(true);
        }
    }

    //Método que Ejecuta las Instrucciones Pertenecientes al Evento MouseListener.   
    @Override
    public void mouseClicked(MouseEvent evt
    ) {
    }

    @Override
    public void mousePressed(MouseEvent evt
    ) {
    }

    @Override
    public void mouseReleased(MouseEvent evt
    ) {
    }

    @Override
    public void mouseEntered(MouseEvent evt
    ) {
        if (evt.getSource() == button1) {
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/acep_roll.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_DEFAULT));
            button1.setIcon(sizeImg);
        }
    }

    @Override
    public void mouseExited(MouseEvent evt
    ) {
        if (evt.getSource() == button1) {
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/acep_norm.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_DEFAULT));
            button1.setIcon(sizeImg);
        }
    }
}