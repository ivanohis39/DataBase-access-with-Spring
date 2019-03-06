package supremo.view;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import supremo.dao.JdbcClientesDao;
import supremo.dao.JdbcDepartamentosDao;
import supremo.dao.JdbcEmpleadosDao;
import supremo.dao.JdbcProductosDao;
import supremo.dao.JdbcVentasDao;
import supremo.model.Clientes;
import supremo.model.Departamentos;
import supremo.model.Empleados;
import supremo.model.Productos;
import supremo.model.Ventas;

public class Principal {

	public static int setInteger(String cadena) {
		System.out.println(cadena);
		return new Scanner(System.in).nextInt();
	}

	public static double setDouble(String cadena) {
		System.out.println(cadena);
		return new Scanner(System.in).nextDouble();
	}

	public static String setString(String cadena) {
		System.out.println(cadena);
		return new Scanner(System.in).nextLine();
	}

	public static Date setDate() {
		System.out.println();
		Date date = Date.valueOf(LocalDate.now());
		return date;
	}

	/**
	 * APARTADO DEL CODIGO DONDE SE TRABAJAN LOS EMPLEADOS
	 */
	public static void insertEmpleado(JdbcEmpleadosDao jdbcEmpleados) {
		System.out.println("\t\t***---*** DAR DE ALTA EMPLEADOS ***---***");
		Empleados empleados = new Empleados(setInteger("Nº de empleado:"), setString("Apellido:"), setString("Oficio:"),
				setInteger("Director:"), setDate(), setInteger("Salario:"), setInteger("Comision"),
				setInteger("Nº departamento:"));

		jdbcEmpleados.insertEmpleado(empleados);

		System.out.println("\nEmpleado dado de alta con exito.\n");
	}

	public static void modificarEmpleado(JdbcEmpleadosDao jdbcEmpleados) {
		System.out.println("\t\t***---*** MODIFICAR EMPLEADOS ***---***");
		Empleados empleados = new Empleados(setInteger("Nº de empleado a modificar:"), setString("Apellido:"),
				setInteger("Salario:"), setInteger("Nº departamento:"));

		jdbcEmpleados.updateEmpleado(empleados);

		System.out.println("\nEmpleado modificado con exito.\n");
	}

	public static void eliminarEmpleado(JdbcEmpleadosDao jdbcEmpleados) {
		System.out.println("\t\t***---*** ELIMINAR EMPLEADOS ***---***");
		Empleados empleados = new Empleados(setInteger("Nº de empleado a eliminar:"));

		jdbcEmpleados.deleteEmpleado(empleados);

		System.out.println("\nEmpleado eliminado con exito.\n");
	}

	public static void showEmpleadoById(JdbcEmpleadosDao jdbcEmpleados) {
		System.out.println("\t\t***---*** MOSTRAR EMPLEADO BY ID ***---***");

		Empleados empleados = new Empleados(setInteger("Nº de empleado:"));
		empleados = jdbcEmpleados.findEmpleadoById(empleados.getEmp_no());

		System.out.println(empleados);
		System.out.println("\n\n");
	}

	public static void listadoEmpleados(JdbcEmpleadosDao jdbcEmpleados) {
		System.out.println("\t\t***---*** MOSTRAR LISTADO DE EMPLEADOS ***---***");

		List<Empleados> listaEmpleados = jdbcEmpleados.getAll();

		for (int i = 0; i < listaEmpleados.size(); i++) {
			System.out.println(listaEmpleados.get(i));
		}

		System.out.println("\nNo hay mas empleados en la BD.\n");
	}

	public static void showEmpleadoMasAnio(JdbcEmpleadosDao jdbcEmpleados) {
		System.out.println("\t\t***---*** MOSTRAR EMPLEADO CON MAS ANIOS EN LA EMPRESA ***---***");

		System.out.println(jdbcEmpleados.getMAsAnios());
		System.out.println("\n\n");
	}

	public static void menuEmpleados() {
		System.out.println("\t\t***---*** MENU EMPLEADOS***---***");
		System.out.println("Pulsa 1 para dar de alta a un empleado.");
		System.out.println("Pulsa 2 para modificar datos de un empleado.");
		System.out.println("Pulsa 3 para dar de baja a un empleado.");
		System.out.println("Pulsa 4 para mostrar el empleado que quieras.");
		System.out.println("Pulsa 5 para mostrar todos lo empleados.");
		System.out.println("Pulsa 6 para mostrar el empleado con mas anios en la empresa.");
		System.out.println("Pulsa 7 para salir al menu principal.\n\n");
	}

	public static void mostrarMenuEmpleados(JdbcEmpleadosDao jdbcEmpleados) {
		int opcion;

		do {
			menuEmpleados();
			opcion = setInteger("Selecciona la opcion que desees:");
			System.out.println();
			switch (opcion) {
			case 1: {
				insertEmpleado(jdbcEmpleados);
				break;
			}
			case 2: {
				modificarEmpleado(jdbcEmpleados);
				break;
			}
			case 3: {
				eliminarEmpleado(jdbcEmpleados);
				break;
			}
			case 4: {
				showEmpleadoById(jdbcEmpleados);
				break;
			}
			case 5: {
				listadoEmpleados(jdbcEmpleados);
				break;
			}
			case 6: {
				showEmpleadoMasAnio(jdbcEmpleados);
				break;
			}
			case 7: {
				System.out.println("Te has salido del menu de empleados.");
				break;
			}
			default: {
				System.out.println("Opcion erronea. Intentalo de nuevo.\n\n");
				break;
			}
			}
		} while (opcion != 7);
	}

	/**
	 * APARTADO DEL CODIGO DONDE SE TRABAJAN LOS DEPARTAMENTOS
	 */
	public static void insertDepartamento(JdbcDepartamentosDao jdbcDepartamentos) {
		System.out.println("\t\t***---*** ALTA DEPARTAMENTO ***---***");
		Departamentos departamentos = new Departamentos(setInteger("Nº departamento:"), setString("Nombre:"),
				setString("Localidad:"));
		jdbcDepartamentos.insertDepartamento(departamentos);
		System.out.println("\nDepartamento dado de alta con exito.\n");
	}

	public static void modificarDepartamento(JdbcDepartamentosDao jdbcDepartamentos) {
		System.out.println("\t\t***---*** MODIFICAR DEPARTAMENTO ***---***");
		Departamentos departamentos = new Departamentos(setInteger("Nº departamento:"), setString("Nombre:"),
				setString("Localidad:"));
		jdbcDepartamentos.updateDepartamento(departamentos);
		System.out.println("\nDepartamento modificado con exito.\n");
	}

	public static void elimanarDepartamento(JdbcDepartamentosDao jdbcDepartamentos) {
		System.out.println("\t\t***---*** ELIMINAR DEPARTAMENTO ***---***");
		Departamentos departamentos = new Departamentos(setInteger("Nº del departamento que deseas eliminar:"));
		jdbcDepartamentos.deleteDepartamento(departamentos);
		System.out.println("\nDepartamento eliminado con exito.\n");
	}

	public static void showDepartamentoById(JdbcDepartamentosDao jdbcDepartamentos) {
		System.out.println("\t\t***---*** MOSTRAR DEPARTAMENTO BY ID ***---***");
		Departamentos departamentos = new Departamentos(setInteger("Nº del departamento:"));
		departamentos = jdbcDepartamentos.findById(departamentos.getDept_no());
		System.out.println(departamentos);
		System.out.println("\n\n");
	}

	public static void listadoDepartamentoById(JdbcDepartamentosDao jdbcDepartamentos) {
		System.out.println("\t\t***---*** MOSTRAR DEPARTAMENTOS ***---***");
		List<Departamentos> listDepartamento = jdbcDepartamentos.getAll();

		for (int i = 0; i < listDepartamento.size(); i++) {
			System.out.println(listDepartamento.get(i));
		}
		System.out.println("\nNo hay mas departamento en la BD.\n");
	}

	public static void showDepartamentoMasEmpleados(JdbcDepartamentosDao jdbcDepartamentos) {
		System.out.println("\t\t***---*** MOSTRAR DEPARTAMENTO CON MAS EMPLEADOS ***---***");
		System.out.println(jdbcDepartamentos.getMasEmpleados());
		System.out.println("\n\n");

	}

	public static void menuDepartamentos() {
		System.out.println("\t\t***---*** MENU DEPARTAMENTOS ***---***");
		System.out.println("Pulsa 1 para dar de alta un departamento.");
		System.out.println("Pulsa 2 para modificar un departamento.");
		System.out.println("Pulsa 3 para dar de baja un departamento.");
		System.out.println("Pulsa 4 para mostrar un departamento deseado.");
		System.out.println("Pulsa 5 para mostrar todos los departamentos.");
		System.out.println("Pulsa 6 para mostrar el departamento con mas empleados.");
		System.out.println("Pulsa 7 para salir al menu principal.\n\n");

	}

	public static void mostrarMenuDepartamentos(JdbcDepartamentosDao jdbcDepartamentos) {
		int opcion;

		do {
			menuDepartamentos();
			opcion = setInteger("Selecciona la opcion que desees:");
			System.out.println();
			switch (opcion) {
			case 1: {
				insertDepartamento(jdbcDepartamentos);
				break;
			}
			case 2: {
				modificarDepartamento(jdbcDepartamentos);
				break;
			}
			case 3: {
				elimanarDepartamento(jdbcDepartamentos);
				break;
			}
			case 4: {
				showDepartamentoById(jdbcDepartamentos);
				break;
			}
			case 5: {
				listadoDepartamentoById(jdbcDepartamentos);
				break;
			}
			case 6: {
				showDepartamentoMasEmpleados(jdbcDepartamentos);
				break;
			}
			case 7: {
				System.out.println("Te has salido del menu de departamentos.");
				break;
			}
			default: {
				System.out.println("Opcion erronea. Intentalo de nuevo.\n\n");
				break;
			}
			}
		} while (opcion != 7);
	}

	/**
	 * APARTADO DEL CODIGO DONDE SE TRABAJAN LOS PRODUCTOS
	 */

	public static void insertarProducto(JdbcProductosDao jdbcProductos) {

		System.out.println("\t\t***---*** ALTA DE UN PRODUCTO ***---***");
		Productos productos = new Productos(setInteger("ID del producto:"), setString("Descripcion:"),
				setInteger("Stock actual:"), setInteger("Stock minimo:"), setInteger("Precio:"));
		jdbcProductos.insertProducto(productos);
		System.out.println("\nProducto dado de alta con exito.\n");
	}

	public static void modificarProducto(JdbcProductosDao jdbcProductos) {

		System.out.println("\t\t***---*** MODIFICAR UN PRODUCTO ***---***");
		Productos productos = new Productos(setInteger("ID del producto:"), setInteger("Stock actual:"),
				setInteger("Precio:"));
		jdbcProductos.updateProducto(productos);
		System.out.println("\nProducto modificado con exito.\n");
	}

	public static void eliminarProducto(JdbcProductosDao jdbcProductos) {

		System.out.println("\t\t***---*** DAR DE BAJA UN PRODUCTO ***---***");
		Productos productos = new Productos(setInteger("ID del producto a eliminar:"));
		jdbcProductos.deleteProducto(productos);
		System.out.println("\nProducto eliminado con exito.\n");
	}

	public static void showProductoById(JdbcProductosDao jdbcProductos) {

		System.out.println("\t\t***---*** ELIGE UN PRODUCTO ***---***");
		Productos productos = new Productos(setInteger("ID del producto:"));
		productos = jdbcProductos.findById(productos.getId_producto());
		System.out.println(productos);
		System.out.println("\n\n");
	}

	public static void listadoProductos(JdbcProductosDao jdbcProductos) {

		System.out.println("\t\t***---*** LISTADO DE PRODUCTOS ***---***");
		List<Productos> listadoProductos = jdbcProductos.getAll();
		for (int i = 0; i < listadoProductos.size(); i++) {
			System.out.println(listadoProductos.get(i));
		}

		System.out.println("\nNo hay mas productos en nuestra BD.\n");
	}

	public static void showProductoMasVendido(JdbcProductosDao jdbcProductos) {

		System.out.println("\t\t***---*** PRODUCTO MAS VENDIDO ***---***");
		// Productos productos = new Productos(setInteger("ID del producto:"));
		// productos = jdbcProductos.findById(productos.getId_producto());
		System.out.println(jdbcProductos.getMasVendido());
		System.out.println("\n\n");
	}

	public static void menuProductos() {
		System.out.println("\t\t***---*** MENU PRODUCTOS ***---***");
		System.out.println("Pulsa 1 para dar de alta un producto.");
		System.out.println("Pulsa 2 para modificar un producto.");
		System.out.println("Pulsa 3 para dar de baja un producto.");
		System.out.println("Pulsa 4 para mostrar un producto deseado.");
		System.out.println("Pulsa 5 para mostrar todos los productos.");
		System.out.println("Pulsa 6 para mostrar el producto mas vendido.");
		System.out.println("Pulsa 7 para salir al menu principal.\n\n");

	}

	public static void mostrarMenuProductos(JdbcProductosDao jdbcProductos) {
		int opcion;

		do {
			menuProductos();
			opcion = setInteger("Selecciona la opcion que desees:");
			System.out.println();
			switch (opcion) {
			case 1: {
				insertarProducto(jdbcProductos);
				break;
			}
			case 2: {
				modificarProducto(jdbcProductos);
				break;
			}
			case 3: {
				eliminarProducto(jdbcProductos);
				break;
			}
			case 4: {
				showProductoById(jdbcProductos);
				break;
			}
			case 5: {
				listadoProductos(jdbcProductos);
				break;
			}
			case 6: {
				showProductoMasVendido(jdbcProductos);
				break;
			}
			case 7: {
				System.out.println("Te has salido del menu de productos.");
				break;
			}
			default: {
				System.out.println("Opcion erronea. Intentalo de nuevo.\n\n");
				break;
			}
			}
		} while (opcion != 7);
	}

	/**
	 * APARTADO DEL CODIGO DONDE SE TRABAJAN LOS CLIENTES
	 */

	public static void insertClientes(JdbcClientesDao jdbcClientes) {
		System.out.println("\t\t***---*** ALTA DE CLIENTES ***---***");
		Clientes clientes = new Clientes(setInteger("Id del cliente:"), setString("Nombre:"), setString("Direccion:"),
				setString("Poblacion:"), setString("Telefono:"), setString("NIF:"));
		jdbcClientes.insertCliente(clientes);
		System.out.println("\nCliente dado de alta con exito.\n");
	}

	public static void modificarClientes(JdbcClientesDao jdbcClientes) {
		System.out.println("\t\t***---*** MODIFICACION DE CLIENTES ***---***");
		Clientes clientes = new Clientes(setInteger("Id del cliente:"), setString("Nombre:"), setString("Direccion:"));
		jdbcClientes.updateCliente(clientes);
		System.out.println("\nCliente modificado con exito.\n");
	}

	public static void eliminarClientes(JdbcClientesDao jdbcClientes) {
		System.out.println("\t\t***---*** BAJA DE CLIENTES ***---***");
		Clientes clientes = new Clientes(setInteger("Id del cliente a eliminar:"));
		jdbcClientes.deleteCliente(clientes);
		System.out.println("\nCliente eliminado con exito.\n");
	}

	public static void showClientesById(JdbcClientesDao jdbcClientes) {
		System.out.println("\t\t***---*** MOSTRAR CLIENTE BY ID ***---***");
		Clientes clientes = new Clientes(setInteger("Id del cliente:"));
		clientes = jdbcClientes.findById(clientes.getId_cliente());
		System.out.println(clientes);
		System.out.println("\n\n");
	}

	public static void listadoClientes(JdbcClientesDao jdbcClientes) {
		System.out.println("\t\t***---*** LISTADO DE CLIENTES ***---***");
		List<Clientes> listadoClientes = jdbcClientes.getAll();
		for (int i = 0; i < listadoClientes.size(); i++) {
			System.out.println(listadoClientes.get(i));
		}
		System.out.println("\nNo hay mas clientes en nuestra BD.\n");
	}

	public static void menuClientes() {
		System.out.println("\t\t***---*** MENU CLIENTES ***---***");
		System.out.println("Pulsa 1 para dar de alta un cliente.");
		System.out.println("Pulsa 2 para modificar un cliente.");
		System.out.println("Pulsa 3 para dar de baja un cliente.");
		System.out.println("Pulsa 4 para mostrar un producto cliente.");
		System.out.println("Pulsa 5 para mostrar todos los cliente.");
		System.out.println("Pulsa 6 para salir al menu principal.\n\n");

	}

	public static void mostrarMenuClientes(JdbcClientesDao jdbcClientes) {
		int opcion;

		do {
			menuClientes();
			opcion = setInteger("Selecciona la opcion que desees:");
			System.out.println();
			switch (opcion) {
			case 1: {
				insertClientes(jdbcClientes);
				break;
			}
			case 2: {
				modificarClientes(jdbcClientes);
				break;
			}
			case 3: {
				eliminarClientes(jdbcClientes);
				break;
			}
			case 4: {
				showClientesById(jdbcClientes);
				break;
			}
			case 5: {
				listadoClientes(jdbcClientes);
				break;
			}
			case 6: {
				System.out.println("Te has salido del menu de clientes.");
				break;
			}
			default: {
				System.out.println("Opcion erronea. Intentalo de nuevo.\n\n");
				break;
			}
			}
		} while (opcion != 6);
	}

	/**
	 * APARTADO DEL CODIGO DONDE SE TRABAJAN LAS VENTAS
	 */

	public static void insertarVenta(JdbcVentasDao jdbcVentas) {
		System.out.println("\t\t***---*** ALTA VENTA ***---***");
		Ventas ventas = new Ventas(setInteger("Id de la venta:"), setDate(), setInteger("Id del cliente:"),
				setInteger("Id del producto:"), setInteger("Cantidad vendidad:"));

		jdbcVentas.insertVenta(ventas);
		System.out.println("\nVenta dada de alta con exito.\n");
	}

	public static void modificarVenta(JdbcVentasDao jdbcVentas) {
		System.out.println("\t\t***---*** MODIFICACION DE VENTA ***---***");
		Ventas ventas = new Ventas(setInteger("Id de la venta:"), setInteger("Cantidad vendidad:"));

		jdbcVentas.updateVenta(ventas);
		System.out.println("\nVenta modificada con exito.\n");
	}

	public static void eliminarVenta(JdbcVentasDao jdbcVentas) {
		System.out.println("\t\t***---*** BAJA VENTA ***---***");
		Ventas ventas = new Ventas(setInteger("Id de la venta a eliminar:"));

		jdbcVentas.deleteVenta(ventas);
		System.out.println("\nVenta eliminada con exito.\n");
	}

	public static void showVentasById(JdbcVentasDao jdbcVentas) {
		System.out.println("\t\t***---*** MOSTRAR VENTA BY ID ***---***");
		Ventas ventas = new Ventas(setInteger("Id de la venta:"));
		ventas = jdbcVentas.findById(ventas.getId_venta());
		System.out.println(ventas);
	}

	public static void listadoVentas(JdbcVentasDao jdbcVentas) {
		System.out.println("\t\t***---*** LISTADO DE LAS VENTAS ***---***");
		List<Ventas> listadoVentas = jdbcVentas.getAll();
		for (int i = 0; i < listadoVentas.size(); i++) {
			System.out.println(listadoVentas.get(i));
		}
		System.out.println("\nNo hay mas ventas en la BD.\n");
	}

	public static void menuVentas() {
		System.out.println("\t\t***---*** MENU VENTAS ***---***");
		System.out.println("Pulsa 1 para dar de alta una venta.");
		System.out.println("Pulsa 2 para modificar una venta.");
		System.out.println("Pulsa 3 para dar de baja una venta.");
		System.out.println("Pulsa 4 para mostrar una venta en concreto.");
		System.out.println("Pulsa 5 para mostrar todas las venta.");
		System.out.println("Pulsa 6 para salir al menu principal.\n\n");

	}

	public static void mostrarMenuVentas(JdbcVentasDao jdbcVentas) {
		int opcion;

		do {
			menuVentas();
			opcion = setInteger("Selecciona la opcion que desees:");
			System.out.println();
			switch (opcion) {
			case 1: {
				insertarVenta(jdbcVentas);
				break;
			}
			case 2: {
				modificarVenta(jdbcVentas);
				break;
			}
			case 3: {
				eliminarVenta(jdbcVentas);
				break;
			}
			case 4: {
				showVentasById(jdbcVentas);
				break;
			}
			case 5: {
				listadoVentas(jdbcVentas);
				break;
			}
			case 6: {
				System.out.println("Te has salido del menu de ventas.\n\n");
				break;
			}
			default: {
				System.out.println("Opcion erronea. Intentalo de nuevo.\n\n");
				break;
			}
			}
		} while (opcion != 6);
	}

	/**
	 * APARTADO DEL CODIGO DONDE SE TRABAJA EL CONJUNTO GLOBAL
	 */
	public static void menuPrincipal() {
		System.out.println("\t\t***---*** MENU PRINCIPAL ***---***");
		System.out.println("Pulsa 1 para entrar en el menu de empleados.");
		System.out.println("Pulsa 2 para entrar en el menu de departamentos.");
		System.out.println("Pulsa 3 para entrar en el menu de productos.");
		System.out.println("Pulsa 4 para entrar en el menu de clientes.");
		System.out.println("Pulsa 5 para entrar en el menu de ventas.");
		System.out.println("Pulsa 6 para salir del programa.\n\n");

	}

	public static void mostrarMenuPrincipal() {
		int opcion;

		ApplicationContext context = new ClassPathXmlApplicationContext("contexto-bean.xml");

		JdbcEmpleadosDao jdbcEmpleados = (JdbcEmpleadosDao) context.getBean("JdbcEmpleadosDao");
		JdbcDepartamentosDao jdbcDepartamentos = (JdbcDepartamentosDao) context.getBean("JdbcDepartamentosDao");
		JdbcProductosDao jdbcProductos = (JdbcProductosDao) context.getBean("JdbcProductosDao");
		JdbcClientesDao jdbcClientes = (JdbcClientesDao) context.getBean("JdbcClientesDao");
		JdbcVentasDao jdbcVentas = (JdbcVentasDao) context.getBean("JdbcVentasDao");

		do {
			menuPrincipal();
			opcion = setInteger("Selecciona la opcion que desees:");
			System.out.println();
			switch (opcion) {
			case 1: {
				mostrarMenuEmpleados(jdbcEmpleados);
				break;
			}
			case 2: {
				mostrarMenuDepartamentos(jdbcDepartamentos);
				break;
			}
			case 3: {
				mostrarMenuProductos(jdbcProductos);
				break;
			}
			case 4: {
				mostrarMenuClientes(jdbcClientes);
				break;
			}
			case 5: {
				mostrarMenuVentas(jdbcVentas);
				break;
			}
			case 6: {
				System.out.println("Te has salido del programa. Hasta pronto.");
				break;
			}
			default: {
				System.out.println("Opcion erronea. Intentalo de nuevo.\n\n");
				break;
			}
			}
		} while (opcion != 6);
	}

	public static void main(String[] args) {
		mostrarMenuPrincipal();

	}

}
