package Second_Class;

import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class SimulaciónTiempo extends JFrame implements WindowListener {

//*********************************************************************************************************************
    /* Estructura del Frame. */
    Timer t1;
    JLabel label1;
    JProgressBar progressBar1;

    public SimulaciónTiempo() {
        //Caracteristicas del JFrame. 
        this.setSize(507, 213);
        this.setLayout(null);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.black);
        AWTUtilities.setWindowOpaque(this, false);
        this.addWindowListener(this);

        //Caracteristicas del JProgressBar.
        add(progressBar1 = new JProgressBar());
        progressBar1.setBounds(46, 100, 420, 25);

        //Caracteristicas de los JLabel.
        add(label1 = new JLabel());
        label1.setBounds(0, 0, 507, 213);
        ImageIcon img1 = new ImageIcon(getClass().getResource("/Multimedia/Panel Simulador.png"));
        ImageIcon sizeImg1 = new ImageIcon(img1.getImage().getScaledInstance(label1.getWidth(), label1.getHeight(), Image.SCALE_DEFAULT));
        label1.setIcon(sizeImg1);
    }

//*********************************************************************************************************************
    /* Clases y Metodos de este Frame. */
    //Instancia de la Clase ActionListener, la cual Controla el Progreso de Llenado de la Barra.
    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            int contador = progressBar1.getValue();
            if (contador < 100) {
                contador++;
                progressBar1.setValue(contador);
                progressBar1.setStringPainted(true);
                progressBar1.setForeground(Color.black);
            } else {
                t1.stop();
                setVisible(false);
                new Second_Class.Métodos().Sonido("Correcto");
                ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/Right.png"));
                JOptionPane.showMessageDialog(null, "Tu Reservación ha Quedado Registrada.", "¡Excelente!", JOptionPane.INFORMATION_MESSAGE, img);
                new Customer_Interface.Customer().setVisible(true);
            }
        }
    };

    //Método que Ejecuta las Instrucciones Pertenecientes a la Evento ActionListener.
    @Override
    public void windowOpened(WindowEvent evt) {
        t1 = new Timer(30, al);
        t1.start();
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
