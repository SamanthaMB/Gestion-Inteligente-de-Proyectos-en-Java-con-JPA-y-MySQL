package modelo.dao;

import java.util.List;

import modelo.entities.Empleado;

public interface EmpleadoDao extends ICrudGenerico<Empleado, Integer> {
	
	List<Empleado>empleadosByDepartamento(int idDepar);
	List<Empleado>empleadosByGenero(String sexo);
	List<Empleado>empleadosByApellidos(String subcadena);
	double salarioTotal();
	double salarioTotalDepar(int idDepar);
	List<Empleado>empleadosByIdPerfil(int idPerfil);

}
