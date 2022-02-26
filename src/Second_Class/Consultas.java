package Second_Class;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Consultas {

    static ResultSet rs;

//*********************************************************************************************************************     
    //Consulta que Devuelve el último valor de un registro autoincrementable de una Tabla.
    public int ident_CurrentQuery(String tabla) {
        int ultimoElemento = 0;
        ArrayList al = new ArrayList();
        try {
            rs = new Second_Class.ConexiónSQL().Consulta("select ident_Current ('" + tabla + "')");
            while (rs.next()) {
                al.add(rs.getString(1));
            }
            for (int i = 0; i < al.size(); i++) {
                ultimoElemento = Integer.parseInt(al.get(i).toString());
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return ultimoElemento;
    }

    //Consulta que Devuelve la Fecha Actual del Sistema.
    public String getDateQuery() {
        String fecha = "";
        ArrayList al = new ArrayList();
        try {
            rs = new Second_Class.ConexiónSQL().Consulta("select getDate()");
            while (rs.next()) {
                al.add(rs.getString(1));
            }
            for (int i = 0; i < al.size(); i++) {
                fecha = String.valueOf(al.get(i).toString());
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return fecha;
    }

//*********************************************************************************************************************     
    //Consulta que Muestra Todos los Datos Referentes a los Clientes y las Cuentas, (Modulos que lo Utiliza: Administrador).
    public void ShowCustomer_CountQuery(JTable table, DefaultTableModel dtm) {
        rs = new ConexiónSQL().Consulta("select cl.id_cliente, cl.nombre, cl.apellidos, cl.edad, cl.sexo, cu.email, cl.telefono, e.nombre, cu.contraseña from Cliente cl inner join Cuenta cu on cl.id_cuenta = cu.id_cuenta "
                + "inner join Estado e on cl.id_estado = e.id_estado");
        try {
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                v.add(rs.getString(8));
                v.add(rs.getString(9));
                dtm.addRow(v);
                table.setModel(dtm);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    //Consulta que Muestra Todos los Datos Referentes a las Reservaciones y los Clientes, (Modulos que lo Utiliza: Administrador).
    public void ShowReservation_CustomerQuery(JTable table, DefaultTableModel dtm) {
        rs = new ConexiónSQL().Consulta("select c.id_cliente, r.id_reservacion, r.noDias, r.fechaEnvio, r.fechaEntrada, r.fechaSalida, ct.cantidad from Cliente c inner join Reservacion r on c.id_reservacion = r.id_reservacion inner join CostoTotal ct on r.id_reservacion = ct.id_reservacion order by r.id_reservacion ASC");
        try {
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                dtm.addRow(v);
                table.setModel(dtm);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    //Consulta que Muestra Todos los Datos Referentes a los Empleados y los Puestos, (Modulos que lo Utiliza: Administrador).
    public void ShowEmploy_PostQuery(JTable table, DefaultTableModel dtm) {
        rs = new ConexiónSQL().Consulta("select e.id_empleado, e.nombre, e.apellidos, e.edad, e.sexo, e.antiguedad, p.nombre, p.sueldo from Empleado e inner join Puesto p on e.tipoPue = p.tipoPue");
        try {
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                v.add(rs.getString(8));
                dtm.addRow(v);
                table.setModel(dtm);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    //Consulta que Muestra Todos los Datos Referentes a las Quejas y Sugerencias y los Empleados, (Modulos que lo Utiliza: Administrador).
    public void ShowComplaint_EmployQuery(JList list, DefaultListModel dlm) {
        rs = new ConexiónSQL().Consulta("select qs.id_QueSug, c.nombre, c.apellidos, qs.descripcion, tqs.nombre, qs.fechaEnvio from Cliente c inner join QueSug_has_Cliente qsc on c.id_cliente = qsc.id_cliente "
                + "inner join QueSug qs on qsc.id_QueSug = qs.id_QueSug "
                + "inner join TipoQueSug tqs on qs.tipoQueSug = tqs.tipoQueSug");
        try {
            while (rs.next()) {
                dlm.addElement("ID de la Que/Sug: ".concat(rs.getString(1)));
                dlm.addElement("Nombre del Cliente: ".concat(rs.getString(2)).concat(" " + rs.getString(3)));
                dlm.addElement("Descripción: ".concat(rs.getString(4)));
                dlm.addElement("Tipo: ".concat(rs.getString(5)));
                dlm.addElement("Fecha de Realización: ".concat(rs.getString(6)));
                dlm.addElement(" ");
                list.setModel(dlm);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

//*********************************************************************************************************************     
    //Consulta que Contabiliza la Cantidad de Total de Registros dentro de las Tabla Cliente, (Modulos que lo Utiliza: Administrador).
    public boolean CountAllFromCustomerQuery() {
        boolean emptyTable = true;
        int contadorRegistros = 0;
        rs = new ConexiónSQL().Consulta("Select count(*) from Cliente");
        try {
            while (rs.next()) {
                contadorRegistros = rs.getInt(1);
            }

            if (contadorRegistros != 0) {
                emptyTable = false;
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return emptyTable;
    }

    //Consulta que Contabiliza la Cantidad de Total de Registros dentro de las Tabla Reservación, (Modulos que lo Utiliza: Administrador).
    public boolean CountAllFromReservationQuery() {
        boolean emptyTable = true;
        int contadorRegistros = 0;
        rs = new ConexiónSQL().Consulta("Select count(*) from Reservacion");
        try {
            while (rs.next()) {
                contadorRegistros = rs.getInt(1);
            }

            if (contadorRegistros != 0) {
                emptyTable = false;
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return emptyTable;
    }

    //Consulta que Determina si un Cliente a Reservado en el Hotel, (Modulos que lo Utiliza: Administrador).
    public boolean CountReservation_for_CustomerQuery(int IDCustomer) {
        boolean empty = true;
        int contadorRegistros = 0;
        rs = new ConexiónSQL().Consulta("select count(id_reservacion) from Cliente where id_cliente =" + IDCustomer);
        try {
            while (rs.next()) {
                contadorRegistros = rs.getInt(1);
            }

            if (contadorRegistros != 0) {
                empty = false;
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return empty;
    }

    //Consulta que Contabiliza la Cantidad de Total de Registros dentro de las Tabla Empleado, (Modulos que lo Utiliza: Administrador).
    public boolean CountAllFromEmployQuery() {
        boolean emptyTable = true;
        int contadorRegistros = 0;
        rs = new ConexiónSQL().Consulta("Select count(*) from Empleado");
        try {
            while (rs.next()) {
                contadorRegistros = rs.getInt(1);
            }

            if (contadorRegistros != 0) {
                emptyTable = false;
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return emptyTable;
    }

    //Consulta que Contabiliza la Cantidad de Total de Registros dentro de las Tabla QueSug, (Modulos que lo Utiliza: Administrador).
    public boolean CountAllFromQue_SugQuery() {
        boolean emptyTable = true;
        int contadorRegistros = 0;
        rs = new ConexiónSQL().Consulta("Select count(*) from QueSug");
        try {
            while (rs.next()) {
                contadorRegistros = rs.getInt(1);
            }

            if (contadorRegistros != 0) {
                emptyTable = false;
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return emptyTable;
    }

//*********************************************************************************************************************     
    //Consulta que Busca y Obtiene el ID de un Cliente en Base a su Email, una vez que se Valida la Existencia de su Email en la Base de Datos.   
    public int ObtainIDCustomer(JTextField textField) {
        int obtainIDCustomer = 0;
        try {
            rs = new Second_Class.ConexiónSQL().Consulta("select cl.id_cliente from Cliente cl inner join Cuenta cu on cl.id_cuenta = cu.id_cuenta where email = '" + textField.getText() + "'");
            while (rs.next()) {
                obtainIDCustomer = Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return obtainIDCustomer;
    }

    //Consulta que Busca y Obtiene el ID de la Cuenta de un Cliente en Base a su ID, una vez que se Valida la Existencia de su ID en la Base de Datos.   
    public int ObtainIDCountFromIDCustomer(int IDCustomer) {
        int obtainIDCount = 0;
        try {
            rs = new Second_Class.ConexiónSQL().Consulta("select cl.id_cuenta from Cliente cl inner join Cuenta cu on cl.id_cuenta = cu.id_cuenta where id_cliente = '" + String.valueOf(IDCustomer) + "'");
            while (rs.next()) {
                obtainIDCount = Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return obtainIDCount;
    }

    //Consulta que Busca y Obtiene el ID de la Cuenta Bancaria de un Cliente en Base a su ID, una vez que se Valida la Existencia de su ID en la Base de Datos.   
    public int ObtainIDCountBankFromIDCustomer(int IDCustomer) {
        int obtainIDCountBank = 0;
        try {
            rs = new Second_Class.ConexiónSQL().Consulta("select cb.id_cuentaBancaria from Cliente c inner join CuentaBancaria cb on c.id_cuentaBancaria = cb.id_cuentaBancaria where id_cliente =" + String.valueOf(IDCustomer));
            while (rs.next()) {
                obtainIDCountBank = Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return obtainIDCountBank;
    }

//*********************************************************************************************************************     
    //Consulta que Muestra el Nombre del Hotel, (Modulos que lo Utiliza: Interfaz de Inicio).    
    public String ShowMessageNameHotel() {
        String name = "";
        try {
            rs = new ConexiónSQL().Consulta("select nombre from Hotel where id_hotel = '1'");
            while (rs.next()) {
                name = rs.getString(1);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return name;
    }

    //Consulta que Muestra la Bienvenida con el Nombre de un Cliente una vez que se Introduce su ID, (Modulos que lo Utiliza: Cliente).    
    public String ShowMessageNameCustomer(int IDCustomer) {
        String message = "", name = "", sexo = "";
        try {
            rs = new ConexiónSQL().Consulta("select nombre, sexo from Cliente where id_cliente = '" + IDCustomer + "'");
            while (rs.next()) {
                name = rs.getString(1);
                sexo = rs.getString(2);
            }

            if (sexo.equals("F")) {
                message = "Bienvenida ".concat(name);

            } else {
                message = "Bienvenido ".concat(name);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return message;
    }

    //Consulta que Muestra el Nombre y Apellidos de un Empleado una vez que se Introduce su ID, (Modulos que lo Utiliza: Empleado).    
    public String ShowNameLast_NameEmploy(JTextField textField) {
        ArrayList al = new ArrayList();
        String name = "";
        try {
            rs = new ConexiónSQL().Consulta("select nombre, apellidos from Empleado where id_empleado = '" + textField.getText() + "'");
            while (rs.next()) {
                al.add(rs.getString(1));
                al.add(rs.getString(2));
            }
            for (int i = 0; i < al.size(); i++) {
                name += al.get(i).toString() + " ";
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return name;
    }

    //Consulta que Agrega los nombres de los estados a un JComboBox.
    public void ShowSates_fromEstadoQuery(JComboBox comboBox) {
        try {
            rs = new Second_Class.ConexiónSQL().Consulta("Select nombre from Estado");
            while (rs.next()) {
                comboBox.addItem(rs.getString(1));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    //Método que Retorna el ID una vez que se Inserta nombre del Estado.
    public String ShowID_NamefromEstadoQuery(String nombre) {
        ArrayList al = new ArrayList();
        String ID = "";
        try {
            rs = new Second_Class.ConexiónSQL().Consulta("Select id_estado from Estado where nombre = '" + nombre + "'");
            while (rs.next()) {
                al.add(rs.getString(1));
            }
            for (int i = 0; i < al.size(); i++) {
                ID += al.get(i).toString();
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return ID;
    }

    //Consulta que Retorna el Precio de la Habitación Individual.
    public int CostoHabInd() {
        int cantidad = 0;
        try {
            rs = new Second_Class.ConexiónSQL().Consulta("select costo from TipoHabitacion where tipoHab = 'I'");
            while (rs.next()) {
                cantidad = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return cantidad;
    }

    //Consulta que Retorna el Precio de la Habitación Compartida.
    public int CostoHabCom() {
        int cantidad = 0;
        try {
            rs = new Second_Class.ConexiónSQL().Consulta("select costo from TipoHabitacion where tipoHab = 'C'");
            while (rs.next()) {
                cantidad = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return cantidad;
    }

    //Consulta que Retorna la Cantidad de Dinero que Tenga un Determinado Cliente en su Cuenta Bancaria.
    public int Money_Customer(int IDCustomer) {
        int cantidad = 0;
        try {
            rs = new Second_Class.ConexiónSQL().Consulta("select cb.cantidad from Cliente c inner join CuentaBancaria cb on c.id_cuentaBancaria = cb.id_cuentaBancaria where c.id_cliente =" + IDCustomer);
            while (rs.next()) {
                cantidad = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return cantidad;
    }

    //Consulta que Valida que Existan Habitaciones Individuales Vacias, para que los Clientes puedan Reservarlas.
    public boolean HabDisIndividuales(int noHabInd) {
        boolean bandera = false;
        int noHabIndDisponibles = 0;
        try {
            rs = new Second_Class.ConexiónSQL().Consulta("select COUNT(id_habitacion) from Habitacion where tipoHab = 'I' and id_reservacion is null");
            while (rs.next()) {
                noHabIndDisponibles = rs.getInt(1);
            }

            if (noHabIndDisponibles > noHabInd) {
                return true;

            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return bandera;
    }

    //Consulta que Valida que Existan Habitaciones Compartidas Vacias, para que los Clientes puedan Reservarlas.
    public boolean HabDisCompartidas(int noHabCom) {
        boolean bandera = false;
        int noHabComDisponibles = 0;
        try {
            rs = new Second_Class.ConexiónSQL().Consulta("select COUNT(id_habitacion) from Habitacion where tipoHab = 'C' and id_reservacion is null");
            while (rs.next()) {
                noHabComDisponibles = rs.getInt(1);
            }

            if (noHabComDisponibles > noHabCom) {
                return true;

            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return bandera;
    }

    //Método que Se Encarga de Asignar el ID de la Reservación a las Habitaciones Disponibles Individuales en su Id de la Reservación foranea.
    public void ReservarHabitacionesIndividuales(int noHabInd) {
        ArrayList al = new ArrayList();
        try {
            rs = new Second_Class.ConexiónSQL().Consulta("select top(" + noHabInd + ")id_habitacion from Habitacion where tipoHab = 'I' and id_reservacion is null");
            while (rs.next()) {
                al.add(rs.getInt(1));
            }
            
            for(int i=0; i<al.size(); i++){
                rs = new Second_Class.ConexiónSQL().Consulta("update Habitacion set id_reservacion= " + new Second_Class.Consultas().ident_CurrentQuery("Reservacion") + " where id_habitacion= " + al.get(i));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    //Método que Se Encarga de Asignar el ID de la Reservación a las Habitaciones Disponibles Compartidas en su ID de la Reservación foranea.
    public void ReservarHabitacionesCompartidas(int noHabCom) {
        ArrayList al = new ArrayList();
        try {
            rs = new Second_Class.ConexiónSQL().Consulta("select top(" + noHabCom + ")id_habitacion from Habitacion where tipoHab = 'C' and id_reservacion is null");
            while (rs.next()) {
                al.add(rs.getInt(1));
            }
            
            for(int i=0; i<al.size(); i++){
                rs = new Second_Class.ConexiónSQL().Consulta("update Habitacion set id_reservacion= " + new Second_Class.Consultas().ident_CurrentQuery("Reservacion") + " where id_habitacion= " + al.get(i));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
