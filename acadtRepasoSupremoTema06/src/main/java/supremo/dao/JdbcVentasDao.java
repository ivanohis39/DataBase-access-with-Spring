package supremo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import supremo.model.Ventas;

@Repository("JdbcVentasDao")
public class JdbcVentasDao implements IVentasDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public void insertVenta(Ventas ventas) {
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(ventas);
		this.namedParameterJdbcTemplate.update(
				"INSERT INTO VENTAS VALUES(:id_venta,:fecha_venta,:id_cliente,:id_producto,:cantidad)",
				parameterSource);

	}

	public void updateVenta(Ventas ventas) {
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(ventas);
		this.namedParameterJdbcTemplate.update("UPDATE VENTAS SET CANTIDAD=:cantidad WHERE ID_VENTA=:id_venta",
				parameterSource);
	}

	public void deleteVenta(Ventas ventas) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id_venta", ventas.getId_venta());
		this.namedParameterJdbcTemplate.update("DELETE FROM VENTAS WHERE ID_VENTA=:id_venta", parameterSource);

	}

	public Ventas findById(int id_venta) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id_venta", id_venta);
		return this.namedParameterJdbcTemplate.queryForObject("SELECT * FROM VENTAS WHERE ID_VENTA=:id_venta",
				parameterSource, new VentasMapper());
	}

	public List<Ventas> getAll() {
		return this.namedParameterJdbcTemplate.query("SELECT * FROM VENTAS", new VentasMapper());
	}

}
