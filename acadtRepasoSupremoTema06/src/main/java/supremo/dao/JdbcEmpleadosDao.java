package supremo.dao;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import supremo.model.Empleados;

@Repository("JdbcEmpleadosDao")
public class JdbcEmpleadosDao implements IEmpleadosDao {

	private JdbcTemplate jdbcTemplate = new JdbcTemplate();

	@Autowired
	public void seyDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void insertEmpleado(Empleados empleados) {
		this.jdbcTemplate.update("INSERT INTO EMPLEADOS VALUES(?,?,?,?,?,?,?,?)",
				new Object[] { empleados.getEmp_no(), empleados.getApellido(), empleados.getOficio(),
						empleados.getDir(), empleados.getFecha_alt(), empleados.getSalario(), empleados.getComision(),
						empleados.getDept_no() });

	}

	public void updateEmpleado(Empleados empleados) {
		this.jdbcTemplate.update("UPDATE EMPLEADOS SET APELLIDO=?,SALARIO=?,DEPT_NO=? WHERE EMP_NO=?", new Object[] {
				empleados.getApellido(), empleados.getSalario(), empleados.getDept_no(), empleados.getEmp_no() });
	}

	public void deleteEmpleado(Empleados empleados) {
		this.jdbcTemplate.update("DELETE FROM EMPLEADOS WHERE EMP_NO=?", empleados.getEmp_no());

	}

	public Empleados findEmpleadoById(int emp_no) {
		return this.jdbcTemplate.queryForObject("SELECT * FROM EMPLEADOS WHERE EMP_NO=?", new EmpleadosMapper(),
				emp_no);
	}

	public List<Empleados> getAll() {
		return this.jdbcTemplate.query("SELECT * FROM EMPLEADOS", new EmpleadosMapper());
	}

	//este metodo habria sido mejor haberlo hecho en una Lista
	public Empleados getMAsAnios() {
		return this.jdbcTemplate.queryForObject("SELECT * FROM EMPLEADOS WHERE (EXTRACT(YEAR FROM SYSDATE())-EXTRACT(YEAR FROM FECHA_ALT)) >=2 LIMIT 1", new EmpleadosMapper());
	}

}
