package Persistencia;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Modelo.Venta;



public class jdbcVentas {
    private Connection dbConn;

    private void setupBaseDeDatos() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/parcialoo-malacarne?useSSL=false";
        String user = "app";
        String password = "app";
        this.dbConn = DriverManager.getConnection(url, user, password);
    }

    public void createVenta(Venta venta){

        try {
            PreparedStatement st = dbConn.prepareStatement(
                    "insert into ventas(fecha, monto, litros) values(?,?,?)");
            st.setTimestamp(1, Timestamp.valueOf(venta.getFecha()));
            st.setDouble(2, venta.obtenerCosto() );
            st.setDouble(3, venta.getLitros() );
            st.executeUpdate();
            st.close();
        } catch (SQLException e){
            throw new RuntimeException("No se pudo cargar la venta correctamente");
        }
    }

    public List<Venta> findAll(){

        List<Venta> ventas= new ArrayList<Venta>();
        this.dbConn= dbConn;

        try {

            PreparedStatement st = dbConn.prepareStatement("Select * FROM usuarios");
            ResultSet result = st.executeQuery();
            while (result.next()) {

                ventas.add(new Venta (result.getTimestamp("fecha").toString(), result.getDouble("costo"), result.getDouble("litros")));
            }
            st.close();
            st.close();

        } catch (SQLException e) {
            throw new RuntimeException("Error", e);

        }
        return ventas;
    }
}
