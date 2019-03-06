package supremo.dao;

import java.util.List;

import supremo.model.Empleados;

public interface IEmpleadosDao {

	public void insertEmpleado(Empleados empleados);

	public void updateEmpleado(Empleados empleados);

	public void deleteEmpleado(Empleados empleados);

	public Empleados findEmpleadoById(int emp_no);

	public List<Empleados> getAll();
	
	public Empleados getMAsAnios();
}
