package supremo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import supremo.model.Productos;

public class ProductosMapper implements RowMapper<Productos> {

	public Productos mapRow(ResultSet result, int rowNum) throws SQLException {

		Productos productos = new Productos();
		productos.setId_producto(result.getInt("id_producto"));
		productos.setDescripcion(result.getString("descripcion"));
		productos.setStock_actual(result.getInt("stock_actual"));
		productos.setStock_minimo(result.getInt("stock_minimo"));
		productos.setPrecio(result.getInt("precio"));
		return productos;
	}

}
