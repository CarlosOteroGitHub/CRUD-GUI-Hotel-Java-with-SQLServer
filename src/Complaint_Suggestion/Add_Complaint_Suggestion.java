package Complaint_Suggestion;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class Add_Complaint_Suggestion extends JFrame implements ActionListener, MouseListener, FocusListener {
//*********************************************************************************************************************

    /* Estructura del Frame. */
    int SaveIDFromCustomer_Interface = new Second_Class.Métodos().getID();
    String placeHolder1 = "Escribe tu Recomendación aqui . . .";
    JLabel label1, label2, label3;
    JTextArea textArea1;
    JRadioButton radioButton1, radioButton2;
    ButtonGroup buttonGroup1;
    JSeparator separator1;
    JButton button1, button2, button3, button4;
    JScrollPane scrollPane1;
    UndoManager um = new UndoManager();

    public Add_Complaint_Suggestion() {
        //Caracteristicas del JFrame.
        this.setTitle("Quejas & Sugerencias");
        this.setSize(600, 480);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);

        //Caracteristicas de los JButton.
        add(button1 = new JButton());
        button1.setBounds(14, 0, 26, 27);
        ImageIcon img1 = new ImageIcon(getClass().getResource("/Multimedia/Undo.png"));
        ImageIcon sizeImg1 = new ImageIcon(img1.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_DEFAULT));
        button1.setIcon(sizeImg1);
        button1.addActionListener(this);

        add(button2 = new JButton());
        button2.setBounds(53, 0, 23, 27);
        ImageIcon img2 = new ImageIcon(getClass().getResource("/Multimedia/Redo.png"));
        ImageIcon sizeImg2 = new ImageIcon(img2.getImage().getScaledInstance(button2.getWidth(), button2.getHeight(), Image.SCALE_DEFAULT));
        button2.setIcon(sizeImg2);
        button2.addActionListener(this);

        add(button3 = new JButton());
        button3.setBounds(100, 400, 103, 35);
        button3.setBorderPainted(false);
        button3.setFocusPainted(false);
        button3.setContentAreaFilled(false);
        ImageIcon img3 = new ImageIcon(getClass().getResource("/Multimedia/acep_norm.png"));
        ImageIcon sizeImg3 = new ImageIcon(img3.getImage().getScaledInstance(button3.getWidth(), button3.getHeight(), Image.SCALE_DEFAULT));
        button3.setIcon(sizeImg3);
        button3.addActionListener(this);
        button3.addMouseListener(this);

        add(button4 = new JButton());
        button4.setBounds(400, 400, 103, 35);
        button4.setBorderPainted(false);
        button4.setFocusPainted(false);
        button4.setContentAreaFilled(false);
        ImageIcon img4 = new ImageIcon(getClass().getResource("/Multimedia/canc_norm.png"));
        ImageIcon sizeImg4 = new ImageIcon(img4.getImage().getScaledInstance(button4.getWidth(), button4.getHeight(), Image.SCALE_DEFAULT));
        button4.setIcon(sizeImg4);
        button4.addActionListener(this);
        button4.addMouseListener(this);

        //Caracteristicas de los JLabel.
        add(label1 = new JLabel());
        label1.setBounds(1, 0, 598, 27);
        ImageIcon img5 = new ImageIcon(getClass().getResource("/Multimedia/Panel Undo - Redo.png"));
        ImageIcon sizeImg5 = new ImageIcon(img5.getImage().getScaledInstance(label1.getWidth(), label1.getHeight(), Image.SCALE_DEFAULT));
        label1.setIcon(sizeImg5);

        add(label2 = new JLabel());
        label2.setBounds(155, 33, 255, 80);
        ImageIcon img6 = new ImageIcon(getClass().getResource("/Multimedia/Nombre (Chico).png"));
        ImageIcon sizeImg6 = new ImageIcon(img6.getImage().getScaledInstance(label2.getWidth(), label2.getHeight(), Image.SCALE_DEFAULT));
        label2.setIcon(sizeImg6);

        add(label3 = new JLabel());
        label3.setBounds(424, 28, 143, 80);
        ImageIcon img7 = new ImageIcon(getClass().getResource("/Multimedia/Logotipo del Hotel (Chico).png"));
        ImageIcon sizeImg7 = new ImageIcon(img7.getImage().getScaledInstance(label3.getWidth(), label3.getHeight(), Image.SCALE_DEFAULT));
        label3.setIcon(sizeImg7);

        //Caracteristicas de los JRadioButton.
        add(radioButton1 = new JRadioButton("Sugerencia"));
        radioButton1.setFont(new java.awt.Font("Tahoma", 0, 12));
        radioButton1.setBounds(35, 33, 103, 35);

        add(radioButton2 = new JRadioButton("Queja"));
        radioButton2.setFont(new java.awt.Font("Tahoma", 0, 12));
        radioButton2.setBounds(35, 73, 103, 35);

        //Caracteristicas de los ButtonGroup.
        buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);

        //Caracteristicas de los JSeparator.
        add(separator1 = new JSeparator(SwingConstants.HORIZONTAL));
        separator1.setBounds(18, 120, 555, 10);

        //Caracteristicas de los JTextArea.
        add(textArea1 = new JTextArea());
        textArea1.setWrapStyleWord(true);
        textArea1.setLineWrap(true);
        textArea1.setFont(new java.awt.Font("Tahoma", 0, 12));
        textArea1.setBounds(15, 145, 565, 235);
        textArea1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textArea1.addFocusListener(this);
        textArea1.addMouseListener(this);
        //Sentencia que Inicializa el Mensaje PlaceHolder Dentro del TextArea.
        new Second_Class.Métodos().PlaceHolderActivo1(textArea1, placeHolder1, 0);
        //Método que Direcciona los Controladores Undo y Redo al "textArea1".
        textArea1.getDocument().addUndoableEditListener(new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent evt) {
                um.addEdit(evt.getEdit());
            }
        });

        //Caracteristicas de los JScrollPane.
        add(scrollPane1 = new JScrollPane(textArea1));
        scrollPane1.setBounds(15, 145, 565, 235);
    }

//*********************************************************************************************************************
    /* Clases y Metodos de este Frame. */
    //Método que Ejecuta las Instrucciones Pertenecientes al Evento ActionListener.   
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == button1) {
            if (um.canUndo()) {
                um.undo();
            }
        } else if (evt.getSource() == button2) {
            if (um.canRedo()) {
                um.redo();
            }
        } else if (evt.getSource() == button3) {
            if (!(radioButton1.isSelected() || radioButton2.isSelected())) {
                this.setVisible(false);
                new Second_Class.Métodos().Sonido("Error");
                JOptionPane.showMessageDialog(null, "Deves Seleccionar entre una Queja o Sugerencia.", "Error", JOptionPane.ERROR_MESSAGE);
                this.setVisible(true);
            } else if (textArea1.getText().isEmpty() || !textArea1.getForeground().equals(Color.BLACK)) {
                this.setVisible(false);
                new Second_Class.Métodos().Sonido("Error");
                JOptionPane.showMessageDialog(null, "Deves Escribir un Mensaje antes del Envio.", "Error", JOptionPane.ERROR_MESSAGE);
                this.setVisible(true);
            } else if (radioButton1.isSelected() == true) {
                try {
                    new Second_Class.ProcedimientosAlmacenados().AltaQueSug(textArea1.getText(), new Second_Class.Consultas().getDateQuery(), "S");
                    new Second_Class.ProcedimientosAlmacenados().AltaQueSug_has_Cliente(String.valueOf(SaveIDFromCustomer_Interface), Integer.toString(new Second_Class.Consultas().ident_CurrentQuery("QueSug")));
                    ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/Right.png"));
                    new Second_Class.Métodos().Sonido("Correcto");
                    JOptionPane.showMessageDialog(null, "¡Listo! Muchas Gracias por la Recomendación.", "Mensaje Registrado", JOptionPane.INFORMATION_MESSAGE, img);
                    this.setVisible(false);
                    new Customer_Interface.Customer().setVisible(true);
                } catch (SQLException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else if (radioButton2.isSelected() == true) {
                try {
                    new Second_Class.ProcedimientosAlmacenados().AltaQueSug(textArea1.getText(), new Second_Class.Consultas().getDateQuery(), "Q");
                    new Second_Class.ProcedimientosAlmacenados().AltaQueSug_has_Cliente(String.valueOf(SaveIDFromCustomer_Interface), Integer.toString(new Second_Class.Consultas().ident_CurrentQuery("QueSug")));
                    ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/Right.png"));
                    new Second_Class.Métodos().Sonido("Correcto");
                    JOptionPane.showMessageDialog(null, "¡Listo! Muchas Gracias por el Comentario.", "Mensaje Registrado", JOptionPane.INFORMATION_MESSAGE, img);
                    this.setVisible(false);
                    new Customer_Interface.Customer().setVisible(true);
                } catch (SQLException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        } else if (evt.getSource() == button4) {
            this.setVisible(false);
            new Customer_Interface.Customer().setVisible(true);
        }
    }

    //Método que Ejecuta las Instrucciones Pertenecientes al Evento MouseListener. 
    @Override
    public void mouseClicked(MouseEvent evt) {
        new Second_Class.Métodos().PlaceHolderInactivo1(textArea1, placeHolder1);
    }

    @Override
    public void mousePressed(MouseEvent evt) {
    }

    @Override
    public void mouseReleased(MouseEvent evt) {
    }

    @Override
    public void mouseEntered(MouseEvent evt) {
        if (evt.getSource() == button3) {
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/acep_roll.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button3.getWidth(), button3.getHeight(), Image.SCALE_DEFAULT));
            button3.setIcon(sizeImg);
        } else if (evt.getSource() == button4) {
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/canc_roll.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button4.getWidth(), button4.getHeight(), Image.SCALE_DEFAULT));
            button4.setIcon(sizeImg);
        }
    }

    @Override
    public void mouseExited(MouseEvent evt) {
        if (evt.getSource() == button3) {
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/acep_norm.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button3.getWidth(), button3.getHeight(), Image.SCALE_DEFAULT));
            button3.setIcon(sizeImg);
        } else if (evt.getSource() == button4) {
            ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/canc_norm.png"));
            ImageIcon sizeImg = new ImageIcon(img.getImage().getScaledInstance(button4.getWidth(), button4.getHeight(), Image.SCALE_DEFAULT));
            button4.setIcon(sizeImg);
        }
    }

    //Método que Ejecuta las Instrucciones Pertenecientes al Evento FocusListener. 
    @Override
    public void focusGained(FocusEvent evt) {
    }

    @Override
    public void focusLost(FocusEvent evt) {
        new Second_Class.Métodos().PlaceHolderActivo1(textArea1, placeHolder1, textArea1.getText().trim().length());
    }
}
