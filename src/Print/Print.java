package Print;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Print {

    // Estructura de la Clase.
    static ResultSet rs;
    File f = new File("");
    FileOutputStream fos;
    JFileChooser jfc;

    //Método que Imprime los Registros Almacenados Dentro de una Tabla de la Base de Datos en un Archivo PDF.
    public void ImprimirPDF(String nombreTabla) throws IOException {
        jfc = new JFileChooser();
        jfc.setDialogTitle("Sistema de Archivos");
        try {
            if (nombreTabla.equals("Cliente")) {
                rs = new Second_Class.ConexiónSQL().Consulta("select cl.id_cliente, cl.nombre, cl.apellidos, cl.edad, cl.sexo, cu.email, cl.telefono, e.nombre from Cliente cl inner join Cuenta cu on cl.id_cuenta = cu.id_cuenta inner join Estado e on cl.id_estado = e.id_estado");
                if (jfc.showDialog(null, "Guardar Archivo") == JFileChooser.APPROVE_OPTION) {
                    f = jfc.getSelectedFile();
                    if (!f.getName().endsWith(".pdf")) {
                        new Second_Class.Métodos().Sonido("Notify");
                        JOptionPane.showMessageDialog(null, "Agrege la Extensión .pdf al Nombre del Archivo.", "Mensaje", JOptionPane.WARNING_MESSAGE);
                    } else {
                        fos = new FileOutputStream(f);
                        Document document = new Document();
                        PdfWriter.getInstance(document, fos);
                        document.open();
                        PdfPTable tabla = new PdfPTable(8);
                        tabla.setWidthPercentage(110f);
                        Paragraph paragraph1 = new Paragraph("Lista de Clientes del Hotel\n\n", FontFactory.getFont("Tahoma", 16, Font.BOLDITALIC, BaseColor.RED));
                        paragraph1.setAlignment(Paragraph.TITLE);
                        document.add(paragraph1);
                        Paragraph paragraph2 = new Paragraph("Impreso el: " + new Second_Class.Métodos().Date2() + "\n\n", FontFactory.getFont("Tahoma", 12, Font.BOLDITALIC, BaseColor.BLACK));
                        paragraph2.setAlignment(Paragraph.ALIGN_RIGHT);
                        document.add(paragraph2);
                        document.add(new Paragraph(""));
                        float[] anchoColumnas = {1.80f, 5.45f, 6.40f, 2.50f, 2.50f, 5.95f, 5.00f, 4.70f};
                        tabla.setWidths(anchoColumnas);
                        tabla.addCell(new Paragraph("ID", FontFactory.getFont("Tahoma", 13, Font.BOLD, BaseColor.BLACK)));
                        tabla.addCell(new Paragraph("Nombre", FontFactory.getFont("Tahoma", 13, Font.BOLD, BaseColor.BLACK)));
                        tabla.addCell(new Paragraph("Apellidos", FontFactory.getFont("Tahoma", 13, Font.BOLD, BaseColor.BLACK)));
                        tabla.addCell(new Paragraph("Edad", FontFactory.getFont("Tahoma", 13, Font.BOLD, BaseColor.BLACK)));
                        tabla.addCell(new Paragraph("Sexo", FontFactory.getFont("Tahoma", 13, Font.BOLD, BaseColor.BLACK)));
                        tabla.addCell(new Paragraph("Email", FontFactory.getFont("Tahoma", 13, Font.BOLD, BaseColor.BLACK)));
                        tabla.addCell(new Paragraph("Teléfono", FontFactory.getFont("Tahoma", 13, Font.BOLD, BaseColor.BLACK)));
                        tabla.addCell(new Paragraph("Estado", FontFactory.getFont("Tahoma", 13, Font.BOLD, BaseColor.BLACK)));

                        while (rs.next()) {
                            tabla.addCell(new Paragraph(rs.getString(1), FontFactory.getFont("Tahoma", 11)));
                            tabla.addCell(new Paragraph(rs.getString(2), FontFactory.getFont("Tahoma", 11)));
                            tabla.addCell(new Paragraph(rs.getString(3), FontFactory.getFont("Tahoma", 11)));
                            tabla.addCell(new Paragraph(rs.getString(4), FontFactory.getFont("Tahoma", 11)));
                            tabla.addCell(new Paragraph(rs.getString(5), FontFactory.getFont("Tahoma", 11)));
                            tabla.addCell(new Paragraph(rs.getString(6), FontFactory.getFont("Tahoma", 11)));
                            tabla.addCell(new Paragraph(rs.getString(7), FontFactory.getFont("Tahoma", 11)));
                            tabla.addCell(new Paragraph(rs.getString(8), FontFactory.getFont("Tahoma", 11)));
                        }
                        document.add(tabla);
                        document.setMargins(0, 0, 0, 0);
                        document.close();
                        fos.close();
                        new Second_Class.Métodos().Sonido("Correcto");
                        ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/Right.png"));
                        JOptionPane.showMessageDialog(null, "El Archivo se ha Guardado Exitosamente en la Siguiente Ruta:\n" + f.getPath(), "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE, img);
                    }
                }
            } else if (nombreTabla.equals("ReservacionAdmin")) {
                rs = new Second_Class.ConexiónSQL().Consulta("select c.id_cliente, r.id_reservacion, r.noDias, r.fechaEnvio, r.fechaEntrada, r.fechaSalida, ct.cantidad from Cliente c inner join Reservacion r on c.id_reservacion = r.id_reservacion inner join CostoTotal ct on r.id_reservacion = ct.id_reservacion");
                if (jfc.showDialog(null, "Guardar Archivo") == JFileChooser.APPROVE_OPTION) {
                    f = jfc.getSelectedFile();
                    if (!f.getName().endsWith(".pdf")) {
                        new Second_Class.Métodos().Sonido("Notify");
                        JOptionPane.showMessageDialog(null, "Agrege la Extensión .pdf al Nombre del Archivo.", "Mensaje", JOptionPane.WARNING_MESSAGE);
                    } else {
                        fos = new FileOutputStream(f);
                        Document document = new Document();
                        PdfWriter.getInstance(document, fos);
                        document.open();
                        PdfPTable tabla = new PdfPTable(7);
                        tabla.setWidthPercentage(110f);
                        Paragraph paragraph1 = new Paragraph("Lista de Reservaciones del Hotel\n\n", FontFactory.getFont("Tahoma", 16, Font.BOLDITALIC, BaseColor.RED));
                        paragraph1.setAlignment(Paragraph.TITLE);
                        document.add(paragraph1);
                        Paragraph paragraph2 = new Paragraph("Impreso el: " + new Second_Class.Métodos().Date2() + "\n\n", FontFactory.getFont("Tahoma", 12, Font.BOLDITALIC, BaseColor.BLACK));
                        paragraph2.setAlignment(Paragraph.ALIGN_RIGHT);
                        document.add(paragraph2);
                        document.add(new Paragraph(""));
                        float[] anchoColumnas = {3.80f, 5.55f, 3.00f, 4.90f, 5.55f, 5.20f, 4.50f};
                        tabla.setWidths(anchoColumnas);
                        tabla.addCell(new Paragraph("No Cliente", FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.BLACK)));
                        tabla.addCell(new Paragraph("No Reservación", FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.BLACK)));
                        tabla.addCell(new Paragraph("No Dias", FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.BLACK)));
                        tabla.addCell(new Paragraph("Fecha Envio", FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.BLACK)));
                        tabla.addCell(new Paragraph("Fecha Entrada", FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.BLACK)));
                        tabla.addCell(new Paragraph("Fecha Salida", FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.BLACK)));
                        tabla.addCell(new Paragraph("Costo Total", FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.BLACK)));

                        while (rs.next()) {
                            tabla.addCell(new Paragraph(rs.getString(1), FontFactory.getFont("Tahoma", 11)));
                            tabla.addCell(new Paragraph(rs.getString(2), FontFactory.getFont("Tahoma", 11)));
                            tabla.addCell(new Paragraph(rs.getString(3), FontFactory.getFont("Tahoma", 11)));
                            tabla.addCell(new Paragraph(rs.getString(4), FontFactory.getFont("Tahoma", 11)));
                            tabla.addCell(new Paragraph(rs.getString(5), FontFactory.getFont("Tahoma", 11)));
                            tabla.addCell(new Paragraph(rs.getString(6), FontFactory.getFont("Tahoma", 11)));
                            tabla.addCell(new Paragraph(rs.getString(7), FontFactory.getFont("Tahoma", 11)));
                        }
                        document.add(tabla);
                        document.setMargins(0, 0, 0, 0);
                        document.close();
                        fos.close();
                        new Second_Class.Métodos().Sonido("Correcto");
                        ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/Right.png"));
                        JOptionPane.showMessageDialog(null, "El Archivo se ha Guardado Exitosamente en la Siguiente Ruta:\n" + f.getPath(), "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE, img);
                    }
                }
            } else if (nombreTabla.equals("Empleado")) {
                rs = new Second_Class.ConexiónSQL().Consulta("select e.id_empleado, e.nombre, e.apellidos, e.edad, e.sexo, e.antiguedad, p.nombre, p.sueldo from Empleado e inner join Puesto p on e.tipoPue = p.tipoPue");
                if (jfc.showDialog(null, "Guardar Archivo") == JFileChooser.APPROVE_OPTION) {
                    f = jfc.getSelectedFile();
                    if (!f.getName().endsWith(".pdf")) {
                        new Second_Class.Métodos().Sonido("Notify");
                        JOptionPane.showMessageDialog(null, "Agrege la Extensión .pdf al Nombre del Archivo.", "Mensaje", JOptionPane.WARNING_MESSAGE);
                    } else {
                        fos = new FileOutputStream(f);
                        Document document = new Document();
                        PdfWriter.getInstance(document, fos);
                        document.open();
                        PdfPTable tabla = new PdfPTable(8);
                        tabla.setWidthPercentage(110f);
                        Paragraph paragraph1 = new Paragraph("Lista de Empleados del Hotel\n\n", FontFactory.getFont("Tahoma", 16, Font.BOLDITALIC, BaseColor.RED));
                        paragraph1.setAlignment(Paragraph.TITLE);
                        document.add(paragraph1);
                        Paragraph paragraph2 = new Paragraph("Impreso el: " + new Second_Class.Métodos().Date2() + "\n\n", FontFactory.getFont("Tahoma", 12, Font.BOLDITALIC, BaseColor.BLACK));
                        paragraph2.setAlignment(Paragraph.ALIGN_RIGHT);
                        document.add(paragraph2);
                        document.add(new Paragraph(""));
                        float[] anchoColumnas = {2.15f, 5.90f, 6.40f, 2.50f, 2.50f, 5.00f, 5.20f, 4.50f};
                        tabla.setWidths(anchoColumnas);
                        tabla.addCell(new Paragraph("ID", FontFactory.getFont("Tahoma", 13, Font.BOLD, BaseColor.BLACK)));
                        tabla.addCell(new Paragraph("Nombre", FontFactory.getFont("Tahoma", 13, Font.BOLD, BaseColor.BLACK)));
                        tabla.addCell(new Paragraph("Apellidos", FontFactory.getFont("Tahoma", 13, Font.BOLD, BaseColor.BLACK)));
                        tabla.addCell(new Paragraph("Edad", FontFactory.getFont("Tahoma", 13, Font.BOLD, BaseColor.BLACK)));
                        tabla.addCell(new Paragraph("Sexo", FontFactory.getFont("Tahoma", 13, Font.BOLD, BaseColor.BLACK)));
                        tabla.addCell(new Paragraph("Antiguedad", FontFactory.getFont("Tahoma", 13, Font.BOLD, BaseColor.BLACK)));
                        tabla.addCell(new Paragraph("Puesto", FontFactory.getFont("Tahoma", 13, Font.BOLD, BaseColor.BLACK)));
                        tabla.addCell(new Paragraph("Sueldo", FontFactory.getFont("Tahoma", 13, Font.BOLD, BaseColor.BLACK)));

                        while (rs.next()) {
                            tabla.addCell(new Paragraph(rs.getString(1), FontFactory.getFont("Tahoma", 11)));
                            tabla.addCell(new Paragraph(rs.getString(2), FontFactory.getFont("Tahoma", 11)));
                            tabla.addCell(new Paragraph(rs.getString(3), FontFactory.getFont("Tahoma", 11)));
                            tabla.addCell(new Paragraph(rs.getString(4), FontFactory.getFont("Tahoma", 11)));
                            tabla.addCell(new Paragraph(rs.getString(5), FontFactory.getFont("Tahoma", 11)));
                            tabla.addCell(new Paragraph(rs.getString(6), FontFactory.getFont("Tahoma", 11)));
                            tabla.addCell(new Paragraph(rs.getString(7), FontFactory.getFont("Tahoma", 11)));
                            tabla.addCell(new Paragraph(rs.getString(8), FontFactory.getFont("Tahoma", 11)));
                        }
                        document.add(tabla);
                        document.setMargins(0, 0, 0, 0);
                        document.close();
                        fos.close();
                        new Second_Class.Métodos().Sonido("Correcto");
                        ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/Right.png"));
                        JOptionPane.showMessageDialog(null, "El Archivo se ha Guardado Exitosamente en la Siguiente Ruta:\n" + f.getPath(), "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE, img);
                    }
                }
            } else if (nombreTabla.equals("QueSug")) {
                rs = new Second_Class.ConexiónSQL().Consulta("select qs.id_QueSug, c.nombre, c.apellidos, qs.descripcion, tqs.nombre, qs.fechaEnvio from Cliente c inner join QueSug_has_Cliente qsc on c.id_cliente = qsc.id_cliente "
                        + "inner join QueSug qs on qsc.id_QueSug = qs.id_QueSug "
                        + "inner join TipoQueSug tqs on qs.tipoQueSug = tqs.tipoQueSug");
                if (jfc.showDialog(null, "Guardar Archivo") == JFileChooser.APPROVE_OPTION) {
                    f = jfc.getSelectedFile();
                    if (!f.getName().endsWith(".pdf")) {
                        new Second_Class.Métodos().Sonido("Notify");
                        JOptionPane.showMessageDialog(null, "Agrege la Extensión .pdf al Nombre del Archivo.", "Mensaje", JOptionPane.WARNING_MESSAGE);
                    } else {
                        fos = new FileOutputStream(f);
                        Document document = new Document();
                        PdfWriter.getInstance(document, fos);
                        document.open();
                        Paragraph paragraph1 = new Paragraph("Lista de Quejas/Sugerencias del Hotel\n\n", FontFactory.getFont("Tahoma", 16, Font.BOLDITALIC, BaseColor.RED));
                        paragraph1.setAlignment(Paragraph.TITLE);
                        document.add(paragraph1);
                        Paragraph paragraph2 = new Paragraph("Impreso el: " + new Second_Class.Métodos().Date2() + "\n\n", FontFactory.getFont("Tahoma", 12, Font.BOLDITALIC, BaseColor.BLACK));
                        paragraph2.setAlignment(Paragraph.ALIGN_RIGHT);
                        document.add(paragraph2);
                        document.add(new Paragraph(""));

                        Paragraph paragraphNo = new Paragraph("");
                        Paragraph paragraphNombre = new Paragraph("");
                        Paragraph paragraphDescripcion = new Paragraph("");
                        Paragraph paragraphTipo = new Paragraph("");
                        Paragraph paragraphDate = new Paragraph("");

                        while (rs.next()) {
                            paragraphNo = new Paragraph("No: " + rs.getString(1) + "\n");
                            paragraphNombre = new Paragraph("Nombre del Cliente: " + rs.getString(2) + " " + rs.getString(3) + "\n");
                            paragraphDescripcion = new Paragraph("Descripción: " + rs.getString(4) + "\n");
                            paragraphTipo = new Paragraph("Tipo: " + rs.getString(5) + "\n");
                            paragraphDate = new Paragraph("fecha de Realización: " + rs.getString(6) + "\n\n\n");

                            document.add(paragraphNo);
                            document.add(paragraphNombre);
                            document.add(paragraphDescripcion);
                            document.add(paragraphTipo);
                            document.add(paragraphDate);
                        }

                        document.setMargins(0, 0, 0, 0);
                        document.close();
                        fos.close();
                        new Second_Class.Métodos().Sonido("Correcto");
                        ImageIcon img = new ImageIcon(getClass().getResource("/Multimedia/Right.png"));
                        JOptionPane.showMessageDialog(null, "El Archivo se ha Guardado Exitosamente en la Siguiente Ruta:\n" + f.getPath(), "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE, img);
                    }
                }
            } else if (nombreTabla.equals("ReservacionCustomer")) {
                int SaveIDFromCustomer_Interface = new Second_Class.Métodos().getID();
                rs = new Second_Class.ConexiónSQL().Consulta("select c.nombre, c.apellidos, r.fechaEnvio, r.noDias, r.fechaEntrada, r.fechaSalida, ct.cantidad, cb.numeroTarjeta, cb.cantidad, eb.nombre, h.id_reservacion from Cliente c inner join Reservacion r on c.id_reservacion = c.id_reservacion inner join CostoTotal ct on r.id_reservacion = ct.id_reservacion inner join CuentaBancaria cb on c.id_cuentaBancaria = cb.id_cuentaBancaria inner join Habitacion h on r.id_reservacion = h.id_reservacion inner join EmpresaBancaria eb on cb.id_empresaBancaria = eb.id_empresaBancaria where id_cliente =" + SaveIDFromCustomer_Interface);
                if (jfc.showDialog(null, "Guardar Archivo") == JFileChooser.APPROVE_OPTION) {
                    f = jfc.getSelectedFile();
                    if (!f.getName().endsWith(".pdf")) {
                        new Second_Class.Métodos().Sonido("Notify");
                        JOptionPane.showMessageDialog(null, "Agrege la Extensión .pdf al Nombre del Archivo.", "Mensaje", JOptionPane.WARNING_MESSAGE);
                    } else {
                        fos = new FileOutputStream(f);
                        Document document = new Document();
                        PdfWriter.getInstance(document, fos);
                        document.open();
                        Image img = Image.getInstance("E:\\Proyecto Final\\Documentacion del Proyecto\\4. Diseño de la Aplicación\\Logotipo del Hotel (Chico).png");
                        img.setAlignment(Image.ALIGN_LEFT);
                        document.add(img);
                        PdfPTable tabla = new PdfPTable(8);
                        tabla.setWidthPercentage(110f);
                        Paragraph paragraph1 = new Paragraph("Mi Reservación\n\n", FontFactory.getFont("Tahoma", 20, Font.BOLDITALIC, BaseColor.RED));
                        paragraph1.setAlignment(Paragraph.TITLE);
                        document.add(paragraph1);
                        Paragraph paragraph2 = new Paragraph("Impreso el: " + new Second_Class.Métodos().Date2() + "\n\n", FontFactory.getFont("Tahoma", 12, Font.BOLDITALIC, BaseColor.BLACK));
                        paragraph2.setAlignment(Paragraph.ALIGN_RIGHT);
                        document.add(paragraph2);
                        document.add(new Paragraph(""));

                        Paragraph paragraphNombre = new Paragraph("");
                        Paragraph paragraphDateEnvio = new Paragraph("");
                        Paragraph paragraphDias = new Paragraph("");
                        Paragraph paragraphDateArrive = new Paragraph("");
                        Paragraph paragraphDateOut = new Paragraph("");
                        Paragraph paragraphCosto = new Paragraph("");
                        Paragraph paragraphNumeroTarjeta = new Paragraph("");
                        Paragraph paragraphCantidadDinero = new Paragraph("");
                        Paragraph paragraphEmpresaBancaria = new Paragraph("");
                        Paragraph paragraphHabReservadas = new Paragraph("");

                        while (rs.next()) {
                            paragraphNombre = new Paragraph("Mi nombre: " + rs.getString(1) + " " + rs.getString(2) + "\n\n");
                            paragraphDateEnvio = new Paragraph("Fecha de Reservación: " + rs.getString(3) + "\n\n");
                            paragraphDias = new Paragraph("Dias de Estancia: " + rs.getString(4) + "\n\n");
                            paragraphDateArrive = new Paragraph("Fecha de Llegada: " + rs.getString(5) + "\n\n");
                            paragraphDateOut = new Paragraph("Fecha de Salida: " + rs.getString(6) + "\n\n");
                            paragraphCosto = new Paragraph("Costo Total: $" + rs.getString(7) + "\n\n");
                            paragraphNumeroTarjeta = new Paragraph("Mi Número de Tarjeta: " + rs.getString(8) + "\n\n");
                            paragraphCantidadDinero = new Paragraph("Mi Efectivo: $" + rs.getString(9) + "\n\n");
                            paragraphEmpresaBancaria = new Paragraph("Empresa Bancaria: " + rs.getString(10) + "\n\n");
                            paragraphHabReservadas = new Paragraph("No Habitaciones Reservadas: " + rs.getString(11) + " ");
                        }

                        document.add(paragraphNombre);
                        document.add(paragraphDateEnvio);
                        document.add(paragraphDias);
                        document.add(paragraphDateArrive);
                        document.add(paragraphDateOut);
                        document.add(paragraphCosto);
                        document.add(paragraphNumeroTarjeta);
                        document.add(paragraphCantidadDinero);
                        document.add(paragraphEmpresaBancaria);
                        document.add(paragraphHabReservadas);

                        Paragraph paragraphFinal1 = new Paragraph("\n\n\nGracias por Reservar con Nosotros. \n\n", FontFactory.getFont("Tahoma", 16, Font.BOLDITALIC, BaseColor.BLACK));
                        Paragraph paragraphFinal2 = new Paragraph("Estamos a tus Ordenes. \n\n", FontFactory.getFont("Tahoma", 16, Font.BOLDITALIC, BaseColor.BLACK));
                        paragraphFinal1.setAlignment(Paragraph.ALIGN_CENTER);
                        paragraphFinal2.setAlignment(Paragraph.ALIGN_CENTER);

                        img.setAbsolutePosition(143f, 80f);
                        document.add(paragraphFinal1);
                        document.add(paragraphFinal2);
                        document.setMargins(0, 0, 0, 0);
                        document.close();
                        fos.close();
                        new Second_Class.Métodos().Sonido("Correcto");
                        ImageIcon img1 = new ImageIcon(getClass().getResource("/Multimedia/Right.png"));
                        JOptionPane.showMessageDialog(null, "El Archivo se ha Guardado Exitosamente en la Siguiente Ruta:\n" + f.getPath(), "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE, img1);
                    }
                }
            }
        } catch (FileNotFoundException | DocumentException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
