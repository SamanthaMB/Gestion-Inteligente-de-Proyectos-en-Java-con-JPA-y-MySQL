package modelo.dao;

import java.util.List;

import modelo.entities.Empleado;

public class EmpleadoDaoImplJpa extends AbsConexionJpa implements EmpleadoDao{

	@Override
	public Empleado findById(Integer idEmpl) {
		return em.find(Empleado.class, idEmpl);
	}

	@Override
	public int insert(Empleado empleado) {
		filas = 0;
		
		try {
			
			if (findById(empleado.getIdEmpl())!= null) {
				filas = 0; // No lo hace porque ya existe un Empleado con ese ID
		                 
		    }else {
		    	tx.begin();
		    	em.persist(empleado);
		    	tx.commit();
		    	filas = 1;  // Cuando lo inserta devuelve 1
		      }
			
			}catch(Exception e) {
				e.printStackTrace();
				filas = -1;  // Si falla lo anterior devuelve -1
			}
			
			return filas;
		}

	@Override
	public int update(Empleado idEmpl) {
		filas = 0;
		
	    try {
	    	
	    if(findById(idEmpl.getIdEmpl()) != null){
	    	tx.begin();
	    	em.merge(idEmpl);
	    	tx.commit();
	    	filas = 1; // Si lo modifica devuelve 1
	    	
	    }else {
	    	filas = 0;// Si no lo hace devuelve 0, el ID proporcionado es null o no existe
	      }
	    	
	    } catch (Exception e) {
	        e.printStackTrace();
	        filas = -1; // Si falla lo anterior devuelve -1
	    }
	    
	    return filas;
	    
	}

	@Override
	public int deleteById(Integer idEmpl) {
		filas = 0;
		Empleado empleado = findById(idEmpl);
		
		try {
		
		if(empleado != null){
			tx.begin();
			em.remove(empleado);
			tx.commit();
			filas = 1; // Si lo elimina devuelve 1
			
		}else {
			filas = 0; // Si no lo hace devuelve 0, el ID proporcionado es null o no existe
			}
		
		}catch(Exception e) {
			System.err.println("Error al eliminar Empleado");
			filas = -1; // Si falla lo anterior devuelve -1
		}
		
		return filas;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> findAll() {
		jpql = "from Empleado e";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosByDepartamento(int idDepar) {
		jpql = "from Empleado e where e.departamento.idDepar = :dep";
		query = em.createQuery(jpql);
		query.setParameter("dep", idDepar); 
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosByGenero(String sexo) {
		jpql = "from Empleado e where e.genero = :gen";
		query = em.createQuery(jpql);
		query.setParameter("gen", sexo); 
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosByApellidos(String subcadena) {
		jpql = "from Empleado e where e.apellidos = :sub";
		query = em.createQuery(jpql);
		query.setParameter("sub", subcadena); 
		return query.getResultList();
	}

	@Override
	public double salarioTotal() {
		jpql = "select sum(e.salario) from Empleado e";
		query = em.createQuery(jpql);
		return (Double)query.getSingleResult();
	}

	@Override
	public double salarioTotalDepar(int idDepar) {
		jpql = "select sum(e.salario) from Empleado e where e.departamento.idDepar = :dep";
		query = em.createQuery(jpql);
		query.setParameter("dep", idDepar); 
		return (Double)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosByIdPerfil(int idPerfil) {
		jpql = "from Empleado e where e.perfil.idPerfil = :per";
		query = em.createQuery(jpql);
		query.setParameter("per", idPerfil); 
		return query.getResultList();
	}

}
