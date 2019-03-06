package supremo.dao;

import java.util.List;

import supremo.model.Clientes;

public interface IClientesDao {

	public void insertCliente(Clientes clientes);

	public void updateCliente(Clientes clientes);

	public void deleteCliente(Clientes clientes);

	public Clientes findById(int id_cliente);

	public List<Clientes> getAll();
}
