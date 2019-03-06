package supremo.model;

import java.sql.Date;

public class Ventas {

	private int id_venta;
	private Date fecha_venta;
	private int id_cliente;
	private int id_producto;
	private int cantidad;

	public Ventas() {
		super();
	}

	public Ventas(int id_venta) {
		super();
		this.id_venta = id_venta;
	}

	public Ventas(int id_venta, int cantidad) {
		super();
		this.id_venta = id_venta;
		this.cantidad = cantidad;
	}

	public Ventas(int id_venta, Date fecha_venta, int id_cliente, int id_producto, int cantidad) {
		super();
		this.id_venta = id_venta;
		this.fecha_venta = fecha_venta;
		this.id_cliente = id_cliente;
		this.id_producto = id_producto;
		this.cantidad = cantidad;
	}

	public int getId_venta() {
		return id_venta;
	}

	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}

	public Date getFecha_venta() {
		return fecha_venta;
	}

	public void setFecha_venta(Date fecha_venta) {
		this.fecha_venta = fecha_venta;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Ventas [id_venta=" + id_venta + ", fecha_venta=" + fecha_venta + ", id_cliente=" + id_cliente
				+ ", id_producto=" + id_producto + ", cantidad=" + cantidad + "]";
	}

}
