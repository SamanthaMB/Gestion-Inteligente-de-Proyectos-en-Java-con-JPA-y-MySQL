package test.entities;

import modelo.entities.Empleado;

public class TestEmpleado {

	public static void main(String[] args) {
		
		Empleado empleado = new Empleado();
		empleado.setNombre("Alba");
		empleado.setApellidos("Moreno Montejano");
		empleado.setGenero("M");
		empleado.setSalario(25000.00);
		
		//Pruebas métodos propios
		
		//Salario mensual
		System.out.println( "El salario mensual es : " + empleado.salarioMensual(12));
		
		//Género
		System.out.println("El género de la empleada es : " + empleado.literalGenero());
		
		//Nombre Completo
		System.out.println("El nombre completo de la empleada es : " + empleado.nombreCompleto());

	}

}
