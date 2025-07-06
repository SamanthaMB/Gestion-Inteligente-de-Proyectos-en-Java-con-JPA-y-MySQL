package test.dao;

import java.util.List;

import modelo.dao.DepartamentoDao;
import modelo.dao.DepartamentoDaoImplJpa;
import modelo.entities.Departamento;


public class TestDepartamentos {
	
	private static DepartamentoDao depdao;
	
	static {
		
		depdao = new DepartamentoDaoImplJpa();
	}

	public static void main(String[] args) {
		
		insert();
		buscarUno();
		update();
		delete();
		buscarTodos();

	}
	
	private static void insert() {
		System.out.println("\nInsertar un nuevo Departamento\n");
		
		Departamento dep = new Departamento(50, "Madrid", "Ventas"); //Nuevo Departamento
		System.out.println("Departamento Insertado, se espera un 1 : " + depdao.insert(dep));
		Departamento dep2 = new Departamento(40, "Madrid", "Ventas"); //Departamento con ID que ya existe
		System.out.println("Departamento NO Insertado, se espera un 0 : " + depdao.insert(dep2));
        
        /*Comprobamos que se ha insertado el nuevo departamento*/
        buscarTodos();	
	}
	
	private static void buscarUno() {
		System.out.println("\nBuscar un Departamento\n");
		Departamento dep = depdao.findById(20);
		if (dep != null) {
			System.out.println("El Departamento con ese Id es: " + dep + "\n");
		}else {
			System.out.println("No existe un Departamento con ese Id\n");
		}	
	}
	
	private static void update() {
		System.out.println("\nActualizar Departamento\n");
		Departamento dep = depdao.findById(50);
		if (dep != null) {
			/* Modificamos el nombre del departamento */
			dep.setNombre("Comercial");
			System.out.println("Modificado espero 1 : " + depdao.update(dep) + "\n");
		}
		else
			System.out.println("Este Departamento NO existe\n");
		
		/*Comprobamos que se ha modificado el departamento*/
        buscarTodos();
		}
	
	private static void delete() {
		System.out.println("\nEliminar Departamento\n");
		switch(depdao.deleteById(50)){
		
		case 1: 
			
			System.out.println("Departamento Eliminado\n");
			break;
			
		case 0: 
			
			System.out.println("Departamento NO Existe\n");
			break;
		
		default:
			System.out.println("NO puedes eliminar este Departamento porque hay empleados con este Dep\n");
		}
		
		/*Comprobamos que se ha eliminado el departamento*/
        buscarTodos();
	}
	
	
	private static void buscarTodos() {
		System.out.println("\nListado de todos los Departamentos\n");
		List<Departamento> lista = depdao.findAll();
		for(Departamento ele: lista) {
			System.out.println(ele);
		}
	}

}
