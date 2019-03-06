package supremo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import supremo.model.Departamentos;

public class DepartamentoMapper implements RowMapper<Departamentos> {

	public Departamentos mapRow(ResultSet result, int rowNum) throws SQLException {
		Departamentos departamentos = new Departamentos();
		departamentos.setDept_no(result.getInt("dept_no"));
		departamentos.setDnombre(result.getString("dnombre"));
		departamentos.setLoc(result.getString("loc"));
		return departamentos;
	}

}
