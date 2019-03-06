package supremo.dao;

import java.util.List;

import supremo.model.Departamentos;

public interface IDepartamentosDao {

	public void insertDepartamento(Departamentos departamentos);

	public void updateDepartamento(Departamentos departamentos);

	public void deleteDepartamento(Departamentos departamentos);

	public Departamentos findById(int dept_no);

	public List<Departamentos> getAll();
	
	public Departamentos getMasEmpleados();
}
