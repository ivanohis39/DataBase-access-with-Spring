package supremo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import supremo.model.Productos;

@Repository("JdbcProductosDao")
public class JdbcProductosDao implements IProductosDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public void insertProducto(Productos productos) {
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(productos);
		this.namedParameterJdbcTemplate.update(
				"INSERT INTO PRODUCTOS VALUES(:id_producto,:descripcion,:stock_actual,:stock_minimo,:precio)",
				parameterSource);

	}

	public void updateProducto(Productos productos) {
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(productos);
		this.namedParameterJdbcTemplate.update(
				"UPDATE PRODUCTOS SET STOCK_ACTUAL=:stock_actual,PRECIO=:precio WHERE ID_PRODUCTO=:id_producto",
				parameterSource);
	}

	public void deleteProducto(Productos productos) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id_producto",
				productos.getId_producto());
		this.namedParameterJdbcTemplate.update("DELETE FROM PRODUCTOS WHERE ID_PRODUCTO=:id_producto", parameterSource);

	}

	public Productos findById(int id_producto) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id_producto", id_producto);
		return this.namedParameterJdbcTemplate.queryForObject("SELECT * FROM PRODUCTOS WHERE ID_PRODUCTO=:id_producto",
				parameterSource, new ProductosMapper());
	}

	public List<Productos> getAll() {
		return this.namedParameterJdbcTemplate.query("SELECT * FROM PRODUCTOS", new ProductosMapper());
	}

	public Productos getMasVendido() {
		return this.namedParameterJdbcTemplate.queryForObject(
				"SELECT PRODUCTOS.*, VENTAS.* FROM PRODUCTOS INNER JOIN VENTAS"
				+ " ON PRODUCTOS.id_producto = VENTAS.id_producto"
				+ " GROUP BY PRODUCTOS.id_producto"
				+ " ORDER BY COUNT(VENTAS.cantidad) DESC LIMIT 1",
				new MapSqlParameterSource(), new ProductosMapper());
	}

}
