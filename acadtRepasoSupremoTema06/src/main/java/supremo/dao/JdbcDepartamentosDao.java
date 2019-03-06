package supremo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import supremo.model.Departamentos;

@Repository("JdbcDepartamentosDao")
public class JdbcDepartamentosDao implements IDepartamentosDao {

	private JdbcTemplate jdbcTemplate = new JdbcTemplate();

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void insertDepartamento(Departamentos departamentos) {
		this.jdbcTemplate.update("INSERT INTO DEPARTAMENTOS VALUES(?,?,?)",
				new Object[] { departamentos.getDept_no(), departamentos.getDnombre(), departamentos.getLoc() });

	}

	public void updateDepartamento(Departamentos departamentos) {
		this.jdbcTemplate.update("UPDATE DEPARTAMENTOS SET DNOMBRE=?, LOC=? WHERE DEPT_NO=?",
				new Object[] { departamentos.getDnombre(), departamentos.getLoc(), departamentos.getDept_no() });

	}

	public void deleteDepartamento(Departamentos departamentos) {
		this.jdbcTemplate.update("DELETE FROM DEPARTAMENTOS WHERE DEPT_NO=?", departamentos.getDept_no());
	}

	public Departamentos findById(int dept_no) {
		return this.jdbcTemplate.queryForObject("SELECT * FROM DEPARTAMENTOS WHERE DEPT_NO=?", new DepartamentoMapper(),
				dept_no);
	}

	public List<Departamentos> getAll() {
		return this.jdbcTemplate.query("SELECT * FROM DEPARTAMENTOS", new DepartamentoMapper());

	}

	public Departamentos getMasEmpleados() {
		return this.jdbcTemplate.queryForObject(
				"SELECT DEPARTAMENTOS.* FROM DEPARTAMENTOS INNER JOIN EMPLEADOS ON DEPARTAMENTOS.dept_no=EMPLEADOS.dept_no GROUP BY DEPARTAMENTOS.dept_no ORDER BY  COUNT(EMPLEADOS.dept_no) DESC LIMIT 1",
				new DepartamentoMapper());
	}

}
