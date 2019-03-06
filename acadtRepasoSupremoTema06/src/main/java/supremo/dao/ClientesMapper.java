package supremo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import supremo.model.Clientes;

public class ClientesMapper implements RowMapper<Clientes> {

	public Clientes mapRow(ResultSet result, int rowNum) throws SQLException {
		Clientes clientes = new Clientes();
		clientes.setId_cliente(result.getInt("id_cliente"));
		clientes.setNombre(result.getString("nombre"));
		clientes.setDireccion(result.getString("direccion"));
		clientes.setPoblacion(result.getString("poblacion"));
		clientes.setTelefono(result.getString("telefono"));
		clientes.setNif(result.getString("nif"));
		return clientes;
	}

}
