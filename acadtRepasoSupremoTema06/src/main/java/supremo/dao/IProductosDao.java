package supremo.dao;

import java.util.List;

import supremo.model.Productos;

public interface IProductosDao {

	public void insertProducto(Productos productos);

	public void updateProducto(Productos productos);

	public void deleteProducto(Productos productos);

	public Productos findById(int id_producto);

	public List<Productos> getAll();
	
	public Productos getMasVendido();
}
