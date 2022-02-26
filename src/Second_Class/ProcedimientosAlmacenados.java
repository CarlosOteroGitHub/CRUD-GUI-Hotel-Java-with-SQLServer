package Second_Class;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class ProcedimientosAlmacenados {

    //Procedimiento Almacenado Encargado de Insertar Registros a la Entidades 'Cuenta'
    public void AltaCuenta(String a, String b, String c) throws SQLException {
        CallableStatement cs = ConexiónSQL.getConnection().prepareCall("{call AltaCuenta(?,?,?)}");
        cs.setString(1, a);
        cs.setString(2, b);
        cs.setString(3, c);
        cs.execute();
    }
    
    //Procedimiento Almacenado Encargado de Insertar Registros a la Entidades 'Cuenta'
    public void AltaCuentaBancaria(String a, String b, String c) throws SQLException {
        CallableStatement cs = ConexiónSQL.getConnection().prepareCall("{call AltaCuentaBancaria(?,?,?)}");
        cs.setString(1, a);
        cs.setString(2, b);
        cs.setString(3, c);
        cs.execute();
    }
    
    //Procedimiento Almacenado Encargado de Insertar Registros a la Entidades 'Cliente'
    public void AltaCliente(String a, String b, String c, String d, String e, String f, String g, String h, String i) throws SQLException {
        CallableStatement cs = ConexiónSQL.getConnection().prepareCall("{call AltaCliente(?,?,?,?,?,?,?,?,?)}");
        cs.setString(1, a);
        cs.setString(2, b);
        cs.setString(3, c);
        cs.setString(4, d);
        cs.setString(5, e);
        cs.setString(6, f);
        cs.setString(7, g);
        cs.setString(8, h);
        cs.setString(9, i);
        cs.execute();
    }
    
    //Procedimiento Almacenado Encargado de Actualizar Registros a la Entidad 'Cuenta'
    public void ActualizarCuenta(String a, String b, String c) throws SQLException {
        CallableStatement cs = ConexiónSQL.getConnection().prepareCall("{call ActualizarCuenta(?,?,?)}");
        cs.setString(1, a);
        cs.setString(2, b);
        cs.setString(3, c);
        cs.execute();
    }
    
    //Procedimiento Almacenado Encargado de Actualizar Registros a la Entidad 'CuentaBancaria'
    public void ActualizarCuentaBancaria(String a, String b, String c, String d) throws SQLException {
        CallableStatement cs = ConexiónSQL.getConnection().prepareCall("{call ActualizarCuentaBancaria(?,?,?,?)}");
        cs.setString(1, a);
        cs.setString(2, b);
        cs.setString(3, c);
        cs.setString(4, d);
        cs.execute();
    }
    
    //Procedimiento Almacenado Encargado de Actualizar Registros a la Entidad 'Cliente'
    public void ActualizarCliente(String a, String b, String c, String d, String e, String f, String g) throws SQLException {
        CallableStatement cs = ConexiónSQL.getConnection().prepareCall("{call ActualizarCliente(?,?,?,?,?,?,?)}");
        cs.setString(1, a);
        cs.setString(2, b);
        cs.setString(3, c);
        cs.setString(4, d);
        cs.setString(5, e);
        cs.setString(6, f);
        cs.setString(7, g);
        cs.execute();
    }

    //Procedimiento Almacenado Encargado de Actualizar la Contraseña del Administrador o el Cliente, en la Entidad 'Cuenta'
    public void ActualizarContraseña(String a, String b) throws SQLException {
        CallableStatement cs = ConexiónSQL.getConnection().prepareCall("{call ActualizarContraseña(?,?)}");
        cs.setString(1, a);
        cs.setString(2, b);
        cs.execute();
    }
    
    //Procedimiento Almacenado Encargado de Agregar un Registro a la entidad 'Reservacion'
    public void AltaRerservacion(String a, String b, String c, String d) throws SQLException {
        CallableStatement cs = ConexiónSQL.getConnection().prepareCall("{call AltaReservation(?,?,?,?)}");
        cs.setString(1, a);
        cs.setString(2, b);
        cs.setString(3, c);
        cs.setString(4, d);
        cs.execute();
    }
    
    //Procedimiento Almacenado Encargado de Agregar un Registro a la entidad 'CostoTotal'
    public void AltaCostoTotal(String a, String b) throws SQLException {
        CallableStatement cs = ConexiónSQL.getConnection().prepareCall("{call AltaCostoTotal(?,?)}");
        cs.setString(1, a);
        cs.setString(2, b);
        cs.execute();
    }
    
    //Procedimiento Almacenado Encargado de Eliminar un Registro a la entidad 'CostoTotal', Asociado a la Reservacion.
    public void BajaCostoTotal(int a) throws SQLException {
        CallableStatement cs = ConexiónSQL.getConnection().prepareCall("{call BajaCostoTotal_Reservation(?)}");
        cs.setInt(1, a);
        cs.execute();
    }
    
    //Procedimiento Almacenado Encargado de Eliminar un Registro a la entidad 'Reservacion'
    public void BajaRerservacion(int a) throws SQLException {
        CallableStatement cs = ConexiónSQL.getConnection().prepareCall("{call BajaReservation(?)}");
        cs.setInt(1, a);
        cs.execute();
    }
    
    //Procedimiento Almacenado Encargado de Insertar Registros a la Entidad 'QueSug'
    public void AltaQueSug(String a, String b, String c) throws SQLException {
        CallableStatement cs = ConexiónSQL.getConnection().prepareCall("{call AltaQueSug(?,?,?)}");
        cs.setString(1, a);
        cs.setString(2, b);
        cs.setString(3, c);
        cs.execute();
    }
    
    //Procedimiento Almacenado Encargado de Insertar Registros a la Entidad 'QueSug_has_Cliente'
    public void AltaQueSug_has_Cliente(String a, String b) throws SQLException {
        CallableStatement cs = ConexiónSQL.getConnection().prepareCall("{call AltaQueSug_has_CLiente(?,?)}");
        cs.setString(1, a);
        cs.setString(2, b);
        cs.execute();
    }
    
    //Procedimiento Almacenado Encargado de Eliminar Registros a la Entidad 'QueSug'
    public void BajaQueSug(int a) throws SQLException {
        CallableStatement cs = ConexiónSQL.getConnection().prepareCall("{call BajaQueSug(?)}");
        cs.setInt(1, a);
        cs.execute();
    }
    
    //Procedimiento Almacenado Encargado de Eliminar Registros a la Entidad 'QueSug_has_Cliente'
    public void BajaQueSug_has_Cliente(int a) throws SQLException {
        CallableStatement cs = ConexiónSQL.getConnection().prepareCall("{call BajaQueSug_has_CLiente(?)}");
        cs.setInt(1, a);
        cs.execute();
    }

    //Procedimiento Almacenado Encargado de Insertar Registros a la Entidad 'Empleado'
    public void AltaEmpleado(String a, String b, String c, String d, String e, String f, String g) throws SQLException {
        CallableStatement cs = ConexiónSQL.getConnection().prepareCall("{call AltaEmpleado(?,?,?,?,?,?,?)}");
        cs.setString(1, a);
        cs.setString(2, b);
        cs.setString(3, c);
        cs.setString(4, d);
        cs.setString(5, e);
        cs.setString(6, f);
        cs.setString(7, g);
        cs.execute();
    }

    //Procedimiento Almacenado Encargado de Eliminar Registros a la Entidad 'Empleado'
    public void BajaEmpleado(int a) throws SQLException {
        CallableStatement cs = ConexiónSQL.getConnection().prepareCall("{call BajaEmpleado(?)}");
        cs.setInt(1, a);
        cs.execute();
    }

    //Procedimiento Almacenado Encargado de Actualizar Registros a la Entidad 'Empleado'
    public void ActualizarEmpleado(String a, String b, String c, String d, String e, String f, String g) throws SQLException {
        CallableStatement cs = ConexiónSQL.getConnection().prepareCall("{call ActualizarEmpleado(?,?,?,?,?,?,?)}");
        cs.setString(1, a);
        cs.setString(2, b);
        cs.setString(3, c);
        cs.setString(4, d);
        cs.setString(5, e);
        cs.setString(6, f);
        cs.setString(7, g);
        cs.execute();
    }
}