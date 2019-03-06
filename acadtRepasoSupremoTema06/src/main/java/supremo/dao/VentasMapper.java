package supremo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import supremo.model.Ventas;

public class VentasMapper implements RowMapper<Ventas> {

	public Ventas mapRow(ResultSet result, int rowNum) throws SQLException {
		Ventas ventas = new Ventas();
		ventas.setId_venta(result.getInt("id_venta"));
		ventas.setFecha_venta(result.getDate("fecha_venta"));
		ventas.setId_cliente(result.getInt("id_cliente"));
		ventas.setId_producto(result.getInt("id_producto"));
		ventas.setCantidad(result.getInt("cantidad"));
		return ventas;
	}

}
