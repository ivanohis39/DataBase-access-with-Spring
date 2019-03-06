package supremo.model;

public class Productos {
	private int id_producto;
	private String descripcion;
	private int stock_actual;
	private int stock_minimo;
	private int precio;

	public Productos() {
		super();
	}

	public Productos(int id_producto) {
		super();
		this.id_producto = id_producto;
	}

	public Productos(int id_producto, int stock_actual, int precio) {
		super();
		this.id_producto = id_producto;
		this.stock_actual = stock_actual;
		this.precio = precio;
	}

	public Productos(int id_producto, String descripcion, int stock_actual, int stock_minimo, int precio) {
		super();
		this.id_producto = id_producto;
		this.descripcion = descripcion;
		this.stock_actual = stock_actual;
		this.stock_minimo = stock_minimo;
		this.precio = precio;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStock_actual() {
		return stock_actual;
	}

	public void setStock_actual(int stock_actual) {
		this.stock_actual = stock_actual;
	}

	public int getStock_minimo() {
		return stock_minimo;
	}

	public void setStock_minimo(int stock_minimo) {
		this.stock_minimo = stock_minimo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Productos [id_producto=" + id_producto + ", descripcion=" + descripcion + ", stock_actual="
				+ stock_actual + ", stock_minimo=" + stock_minimo + ", precio=" + precio + "]";
	}

}
