package supremo.dao;

import java.util.List;

import supremo.model.Ventas;

public interface IVentasDao {

	public void insertVenta(Ventas ventas);

	public void updateVenta(Ventas ventas);

	public void deleteVenta(Ventas ventas);

	public Ventas findById(int id_venta);

	public List<Ventas> getAll();
}
