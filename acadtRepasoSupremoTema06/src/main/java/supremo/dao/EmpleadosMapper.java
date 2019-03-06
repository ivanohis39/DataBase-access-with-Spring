package supremo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mysql.jdbc.ResultSetMetaData;

import supremo.model.Empleados;

public class EmpleadosMapper implements RowMapper<Empleados>{

	public Empleados mapRow(ResultSet result, int rowNum) throws SQLException {
		Empleados empleado = new Empleados();
		
		empleado.setEmp_no(result.getInt("emp_no"));
		empleado.setApellido(result.getString("apellido"));
		empleado.setOficio(result.getString("oficio"));
		empleado.setDir(result.getInt("dir"));
		empleado.setFecha_alt(result.getDate("fecha_alt"));
		empleado.setSalario(result.getDouble("salario"));
		empleado.setComision(result.getDouble("comision"));
		if(ExisteColumna(result,"dept_no")) {
			empleado.setDept_no(result.getInt("dept_no"));

		}
		return empleado;
	}

	public boolean ExisteColumna(ResultSet result, String columnName) throws SQLException {
		ResultSetMetaData meta = (ResultSetMetaData) result.getMetaData();
		int columns = meta.getColumnCount();
		for (int i = 1; i <= columns; i++) {
			if(columnName.equalsIgnoreCase(meta.getColumnName(i))) {
				return true;
			}
		}
		return false;
	}

	
}
