package test.dao;

import java.time.LocalDate;
import java.util.List;

import modelo.dao.DepartamentoDao;
import modelo.dao.DepartamentoDaoImplJpa;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplJpa;
import modelo.dao.PerfilDao;
import modelo.dao.PerfilDaoImplJpa;
import modelo.entities.Empleado;

public class TestEmpleados {
	
	private static EmpleadoDao edao;
	private static DepartamentoDao depdao;
	private static PerfilDao pdao;
	
	static {
		
		edao = new EmpleadoDaoImplJpa();
		depdao = new DepartamentoDaoImplJpa();
		pdao = new PerfilDaoImplJpa();
	}

	public static void main(String[] args) {
		insert();
		buscarUno();
		update();
		delete();
		buscarTodos();
		byDepartamento();
		byGenero();
		byApellido();
		salarioTotal();
		salarioTotalDep();
		byIdPerfil();
		
	}
	
	private static void insert() {
		System.out.println("\nInsertar un nuevo Empleado\n");
		
		Empleado emp = new Empleado(121, "Mohedano Barrena", "smb@unir.com", LocalDate.of(2021, 3, 10), 
				LocalDate.of(1989, 9, 12), "M", "Samantha", "Smb123", 30000.00, depdao.findById(20), 
				pdao.findById(1)); //Nuevo Empleado
		System.out.println("Empleado Insertado, se espera un 1 : " + edao.insert(emp));
		
		Empleado emp2 = new Empleado(100, "Moreno Moreno", "moreno@unir.com", LocalDate.of(2020, 2, 16), 
				LocalDate.of(1985, 6, 24), "H", "Luis", "Luis123", 30000.00, depdao.findById(30), 
				pdao.findById(2)); //Empleado con ID que ya existe
		System.out.println("Empleado NO Insertado, se espera un 0 : " + edao.insert(emp2));
        
        /*Comprobamos que se ha insertado el nuevo empleado*/
        buscarTodos();	
	}
	
	private static void buscarUno() {
		System.out.println("\nBuscar un Empleado\n");
		Empleado emp = edao.findById(115);
		if (emp != null) {
			System.out.println("El Empleado con ese Id es: " + emp + "\n");
		}else {
			System.out.println("No existe un Empleado con ese Id\n");
		}	
	}
	
	private static void update() {
		System.out.println("\nActualizar Empleado\n");
		Empleado emp = edao.findById(121);
		if (emp != null) {
			/* Modificamos el email del empleado */
			emp.setEmail("smb@ejemplo.es");
			System.out.println("Modificado espero 1 : " + edao.update(emp) + "\n");
		}
		else
			System.out.println("Este Empleado NO existe\n");
		
		/*Comprobamos que se ha modificado el email del empleado*/
        buscarTodos();
		}
	
	private static void delete() {
		System.out.println("\nEliminar Empleado\n");
		switch(edao.deleteById(121)){
		
		case 1: 
			
			System.out.println("Empleado Eliminado\n");
			break;
			
		case 0: 
			
			System.out.println("Empleado NO Existe\n");
			break;
		
		default:
			System.out.println("NO puedes eliminar este Empleado porque está presente en Proyectos con empleados\n");
		}
		
		/*Comprobamos que se ha eliminado el departamento*/
        buscarTodos();
	}
	
	
	private static void buscarTodos() {
		System.out.println("\nListado de todos los Empleados\n");
		List<Empleado> lista = edao.findAll();
		for(Empleado ele: lista) {
			System.out.println(ele);
		}
	}

	private static void byDepartamento() {
		System.out.println("\nListado de los Empleados por Departamento\n");
		List<Empleado> lista = edao.empleadosByDepartamento(10);
		for(Empleado ele: lista) {
			System.out.println(ele);
		}
	}
	
	private static void byGenero() {
		System.out.println("\nListado de los Empleados por Género\n");
		List<Empleado> lista = edao.empleadosByGenero("M");
		for(Empleado ele: lista) {
			System.out.println(ele);
		}
	}
	
	private static void byApellido() {
		System.out.println("\nListado de Empleados por apellido\n");
		List<Empleado> lista = edao.empleadosByApellidos("Oliva");
		for(Empleado ele: lista) {
			System.out.println(ele);
		}
	}
	
	private static void salarioTotal() {
		System.out.println("\nSalario total de todos los empleados : " 
				            + edao.salarioTotal()
				            + "\n");
		
		}
	

	private static void salarioTotalDep() {
		System.out.println("\nSalario total de los empleados del departamento es : " 
			            + edao.salarioTotalDepar(10)
			            + "\n");
	
	}
	
	private static void byIdPerfil() {
		System.out.println("\nListado de empleados por IdPerfil\n");
		List<Empleado> lista = edao.empleadosByIdPerfil(4);
		for(Empleado ele: lista) {
			System.out.println(ele);
		}
	}

}

