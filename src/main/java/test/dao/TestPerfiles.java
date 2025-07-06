package test.dao;

import java.util.List;

import modelo.dao.PerfilDao;
import modelo.dao.PerfilDaoImplJpa;
import modelo.entities.Perfil;

public class TestPerfiles {
	
	private static PerfilDao pdao;
	
	static {
		
		pdao= new PerfilDaoImplJpa();
	}

	public static void main(String[] args) {
		
		insert();
		buscarUno();
		update();
		delete();
		buscarTodos();

	}

	private static void insert() {
		System.out.println("\nInsertar un nuevo Perfil\n");
		
		Perfil perfil = new Perfil(5, "Revenue Manager", 150.000); //Nuevo Perfil
		System.out.println("Perfil Insertado, se espera un 1 : " + pdao.insert(perfil));
		Perfil perfil2 = new Perfil(4, "Revenue Manager", 180.000); //Perfil con ID que ya existe
		System.out.println("Perfil No Insertado, se espera un 0 : " + pdao.insert(perfil2));
        
        /*Comprobamos que se ha insertado el nuevo perfil*/
        buscarTodos();
		
	}
	
	private static void buscarUno() {
		System.out.println("\nBuscar un Perfil\n");
		Perfil perfil = pdao.findById(3);
		if (perfil != null) {
			System.out.println("El perfil con ese Id es: " + perfil + "\n");
		}else {
			System.out.println("No existe un perfil con ese Id\n");
		}
		
	}
	
	private static void update() {
		System.out.println("\nActualizar Perfil\n");
		Perfil perfil = pdao.findById(5);
		if (perfil != null) {
			/* Modificamos sólo el nombre del perfil */
			perfil.setNombre("Data Analyst");
			System.out.println("Modificado espero 1 : " + pdao.update(perfil) + "\n");
		}
		else
			System.out.println("Este perfil NO existe\n");
		
		/*Comprobamos que se ha modificado el perfil*/
        buscarTodos();
		}
		
	
	
	/*private static void deleteId() {
		
		int filas = 0;
		filas =  pdao.deleteById(5);
		if (filas == 1) {
			System.out.println("Perfil eliminado\n");
		}else 
			System.out.println("Este Perfil no existe\n");
	}*/
	
	private static void delete() {
		System.out.println("\nEliminar Perfil\n");
		switch(pdao.deleteById(5)){
		
		case 1: 
			
			System.out.println("Perfil Eliminado\n");
			break;
			
		case 0: 
			
			System.out.println("Perfil NO Existe\n");
			break;
		
		default:
			System.out.println("NO puedes eliminar este perfil porque hay empleados con este perfil\n");
		}
		
		/*Comprobamos que se ha eliminado el perfil*/
        buscarTodos();
	}
	
	
	private static void buscarTodos() {
		System.out.println("\nListado de todos los perfiles\n");
		List<Perfil> lista = pdao.findAll();
		for(Perfil ele: lista) {
			System.out.println(ele);
		}
	}
	
}
