package Start_Interface;

import Second_Class.ConexiónSQL;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;

public class Inicio extends JFrame implements ActionListener, MouseListener, WindowListener {

//*********************************************************************************************************************
    /* Estructura del Frame. */
    Timer t1;
    JPanel panel1;
    JButton button1, button2, button3, button4;
    JLabel label1, label2, label3, label4;

    public Inicio() {
        //Caracteristicas del JFrame.
        this.setTitle("Hotel ".concat(new Second_Class.Consultas().ShowMessageNameHotel()));
        this.setSize(997, 700);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.addWindowListener(this);
        this.getContentPane().setBackground(Color.white);

        //Caracteristicas de los JButton.
        add(button1 = new JButton());
        button1.setBounds(294, 18, 157, 66);
        button1.setBorderPainted(false);
        button1.setFocusPainted(false);
        button1.setContentAreaFilled(false);
        ImageIcon img1 = new ImageIcon(getClass().getResource("/Multimedia/Registro_norm.png"));
        ImageIcon sizeImg1 = new ImageIcon(img1.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_DEFAULT));
        button1.setIcon(sizeImg1);
        button1.addActionListener(this);
        button1.addMouseListener(this);

        add(button2 = new JButton());
        button2.setBounds(470, 18, 157, 66);
        button2.setBorderPainted(false);
        button2.setFocusPainted(false);
        button2.setContentAreaFilled(false);
        ImageIcon img2 = new ImageIcon(getClass().getResource("/Multimedia/Login_norm.png"));
        ImageIcon sizeImg2 = new ImageIcon(img2.getImage().getScaledInstance(button2.getWidth(), button2.getHeight(), Image.SCALE_DEFAULT));
        button2.setIcon(sizeImg2);
        button2.addActionListener(this);
        button2.addMouseListener(this);

        add(button3 = new JButton());
        button3.setBounds(646, 18, 157, 66);
        button3.setBorderPainted(false);
        button3.setFocusPainted(false);
        button3.setContentAreaFilled(false);
        ImageIcon img3 = new ImageIcon(getClass().getResource("/Multimedia/Nosotros_norm.png"));
        ImageIcon sizeImg3 = new ImageIcon(img3.getImage().getScaledInstance(button3.getWidth(), button3.getHeight(), Image.SCALE_DEFAULT));
        button3.setIcon(sizeImg3);
        button3.addActionListener(this);
        button3.addMouseListener(this);

        add(button4 = new JButton());
        button4.setBounds(822, 18, 157, 66);
        button4.setBorderPainted(false);
        button4.setFocusPainted(false);
        button4.setContentAreaFilled(false);
        ImageIcon img4 = new ImageIcon(getClass().getResource("/Multimedia/Salír_norm.png"));
        ImageIcon sizeImg4 = new ImageIcon(img4.getImage().getScaledInstance(button4.getWidth(), button4.getHeight(), Image.SCALE_DEFAULT));
        button4.setIcon(sizeImg4);
        button4.addActionListener(this);
        button4.addMouseListener(this);

        //Caracteristicas de los JLabel.
        add(label1 = new JLabel());
        label1.setBounds(0, 30, 255, 80);
        ImageIcon img5 = new ImageIcon(getClass().getResource("/Multimedia/Nombre (Chico).png"));
        ImageIcon sizeImg5 = new ImageIcon(img5.getImage().getScaledInstance(label1.getWidth(), label1.getHeight(), Image.SCALE_DEFAULT));
        label1.setIcon(sizeImg5);

        add(label2 = new JLabel("Bienvenido al Hotel ".concat(new Second_Class.Consultas().ShowMessageNameHotel()).concat(".                                                                ")));
        label2.setFont(new java.awt.Font("Tahoma", 1, 20));
        label2.setBounds(300, 85, 800, 80);

        add(label3 = new JLabel());
        label3.setBounds(257, 0, 734, 147);
        ImageIcon img6 = new ImageIcon(getClass().getResource("/Multimedia/Panel Superior.png"));
        ImageIcon sizeImg6 = new ImageIcon(img6.getImage().getScaledInstance(label3.getWidth(), label3.getHeight(), Image.SCALE_DEFAULT));
        label3.setIcon(sizeImg6);

        //Caracteristicas de los JPanel.
        add(panel1 = new JPanel());
        panel1.setLayout(null);
        panel1.setBounds(0, 147, 990, 523);
        panel1.add(label4 = new JLabel());
        label4.setSize(990, 523);
        ImageIcon img7 = new ImageIcon(getClass().getResource("/Multimedia/Instalaciones del Hotel 1.jpg"));
        ImageIcon sizeImg7 = new ImageIcon(img7.getImage().getScaledInstance(label4.getWidth(), label4.getHeight(), Image.SCALE_DEFAULT));
        label4.setIcon(sizeImg7);
    }

//*********************************************************************************************************************
    /* Clases y Metodos de este Frame. */
    //Método del Evento ActionListener, que hace Referencia al Texto en Movimiento Dentro de la Instacia del Timer.
    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            String texto = label2.getText().substring(1) + label2.getText().substring(0, 1);
            label2.setText(texto);
        }
    };

    //Clase Correspondiente al Diseño de la Función Nosotros Dentro de esta Interfaz.
    class Nosotros extends JPanel implements ActionListener {
//---------------------------------------------------------------------------------------------------------------------

        /* Estructura del JPanel. */
        JLabel label1;
        JButton button1;
        JScrollPane scrollPane1;

        public Nosotros() {
            //Caracteristicas de este JPanel.
            this.setLayout(null);
            this.setSize(990, 523);

            //Caracteristicas de los JLabel.
            add(label1 = new JLabel());
            label1.setSize(978, 1400);
            new Second_Class.Métodos().Img("/Multimedia/Nosotros.png", label1);

            //Caracteristicas de los JButton.
            add(button1 = new JButton());
            button1.setBounds(910, 35, 44, 46);
            button1.setBorderPainted(false);
            button1.setFocusPainted(false);
            button1.setContentAreaFilled(false);
            ImageIcon img2 = new ImageIcon(getClass().getResource("/Multimedia/Salír_1.png"));
            ImageIcon sizeImg2 = new ImageIcon(img2.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_DEFAULT));
            button1.setIcon(sizeImg2);
            button1.addActionListener(this);

            //Caracteristicas de los JScrollPane.
            add(scrollPane1 = new JScrollPane(label1));
            scrollPane1.setSize(990, 523);
        }

//---------------------------------------------------------------------------------------------------------------------
        /* Clases y Metodos de este JPanel. */
        //Método que Ejecuta las Instrucciones Pertenecientes al Evento ActionListener.
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == button1) {
                panel1.removeAll();
                panel1.repaint();
                panel1.add(label4 = new JLabel());
                label4.setSize(990, 523);
                new Second_Class.Métodos().Img("/Multimedia/Instalaciones del Hotel 1.jpg", label4);
            }
        }
    }

    //Método que hace Referencia al Cambio de Imagenes del Negocio Dentro de la Instancia del Thread.
    int seg = 0;
    Thread hilo1 = new Thread() {
        @Override
        public void run() {
            try {
                while (true) {
                    if (seg == 26) {
                        seg = 0;
                    }
                    seg++;
                    switch (seg) {
                        case 1:
                            new Second_Class.Métodos().Img("/Multimedia/Instalaciones del Hotel 1.jpg", label4);
                            break;
                        case 6:
                            new Second_Class.Métodos().Img("/Multimedia/Instalaciones del Hotel 2.jpg", label4);
                            break;
                        case 11:
                            new Second_Class.Métodos().Img("/Multimedia/Instalaciones del Hotel 3.jpg", label4);
                            break;
                        case 16:
                            new Second_Class.Métodos().Img("/Multimedia/Instalaciones del Hotel 4.jpg", label4);
                            break;
                        case 21:
                            new Second_Class.Métodos().Img("/Multimedia/Instalaciones del Hotel 5.jpg", label4);
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
        if (evt.getSource() == button1) {
            new Registry_Customer.Add_Customer().setVisible(true);
            this.setVisible(false);
        } else if (evt.getSource() == button2) {
            new Login.Login().setVisible(true);
            this.setVisible(false);
        } else if (evt.getSource() == button3) {
            panel1.removeAll();
            panel1.repaint();
            panel1.add(new Nosotros());
        } else if (evt.getSource() == button4) {
            try {
                ConexiónSQL.getConnection().close();
                System.exit(0);
            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }
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
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/Registro_press.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_DEFAULT));
            button1.setIcon(sizeImg);
        } else if (evt.getSource() == button2) {
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/Login_press.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button2.getWidth(), button2.getHeight(), Image.SCALE_DEFAULT));
            button2.setIcon(sizeImg);
        } else if (evt.getSource() == button3) {
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/Nosotros_press.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button3.getWidth(), button3.getHeight(), Image.SCALE_DEFAULT));
            button3.setIcon(sizeImg);
        } else if (evt.getSource() == button4) {
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/Salír_press.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button4.getWidth(), button4.getHeight(), Image.SCALE_DEFAULT));
            button4.setIcon(sizeImg);
        }
    }

    //Método que Ejecuta las Instrucciones Pertenecientes al Evento WindowListener.
    @Override
    public void mouseExited(MouseEvent evt) {
        if (evt.getSource() == button1) {
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/Registro_norm.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_DEFAULT));
            button1.setIcon(sizeImg);
        } else if (evt.getSource() == button2) {
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/Login_norm.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button2.getWidth(), button2.getHeight(), Image.SCALE_DEFAULT));
            button2.setIcon(sizeImg);
        } else if (evt.getSource() == button3) {
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/Nosotros_norm.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button3.getWidth(), button3.getHeight(), Image.SCALE_DEFAULT));
            button3.setIcon(sizeImg);
        } else if (evt.getSource() == button4) {
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/Salír_norm.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button4.getWidth(), button4.getHeight(), Image.SCALE_DEFAULT));
            button4.setIcon(sizeImg);
        }
    }

    @Override
    public void windowOpened(WindowEvent evt) {
        t1 = new Timer(100, al);
        t1.start();
        hilo1.start();
        ConexiónSQL.getConnection();
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
}

//====================================================================================================================
class MainClass {

    public static void main(String[] args) throws Exception {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
        //</editor-fold>
        new Start_Interface.Inicio().setVisible(true);
    }
}
