package supremo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import supremo.model.Clientes;

@Repository("JdbcClientesDao")
public class JdbcClientesDao implements IClientesDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public void insertCliente(Clientes clientes) {
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(clientes);
		this.namedParameterJdbcTemplate.update(
				"INSERT INTO CLIENTES VALUES(:id_cliente,:nombre,:direccion,:poblacion,:telefono,:nif)",
				parameterSource);
	}

	public void updateCliente(Clientes clientes) {
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(clientes);
		this.namedParameterJdbcTemplate.update(
				"UPDATE CLIENTES SET NOMBRE=:nombre,DIRECCION=:direccion WHERE ID_CLIENTE=:id_cliente",
				parameterSource);
	}

	public void deleteCliente(Clientes clientes) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id_cliente",
				clientes.getId_cliente());
		this.namedParameterJdbcTemplate.update("DELETE FROM CLIENTES WHERE ID_CLIENTE=:id_cliente", parameterSource);
	}

	public Clientes findById(int id_cliente) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id_cliente", id_cliente);
		return this.namedParameterJdbcTemplate.queryForObject("SELECT * FROM CLIENTES WHERE ID_CLIENTE=:id_cliente",
				parameterSource, new ClientesMapper());
	}

	public List<Clientes> getAll() {
		return this.namedParameterJdbcTemplate.query("SELECT * FROM CLIENTES", new ClientesMapper());
	}

}
