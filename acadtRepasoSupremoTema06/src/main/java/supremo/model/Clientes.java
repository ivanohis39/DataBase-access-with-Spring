package supremo.model;

public class Clientes {

	private int id_cliente;
	private String nombre;
	private String direccion;
	private String poblacion;
	private String telefono;
	private String nif;

	public Clientes() {
		super();
	}

	public Clientes(int id_cliente) {
		super();
		this.id_cliente = id_cliente;
	}

	public Clientes(int id_cliente, String nombre, String direccion) {
		super();
		this.id_cliente = id_cliente;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public Clientes(int id_cliente, String nombre, String direccion, String poblacion, String telefono, String nif) {
		super();
		this.id_cliente = id_cliente;
		this.nombre = nombre;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.telefono = telefono;
		this.nif = nif;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	@Override
	public String toString() {
		return "Clientes [id_cliente=" + id_cliente + ", nombre=" + nombre + ", direccion=" + direccion + ", poblacion="
				+ poblacion + ", telefono=" + telefono + ", nif=" + nif + "]";
	}

}
