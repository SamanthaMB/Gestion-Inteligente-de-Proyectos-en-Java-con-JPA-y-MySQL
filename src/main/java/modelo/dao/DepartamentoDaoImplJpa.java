package modelo.dao;

import java.util.List;

import modelo.entities.Departamento;


public class DepartamentoDaoImplJpa extends AbsConexionJpa implements DepartamentoDao {
	

	@Override
	public Departamento findById(Integer idDepar) {
		return em.find(Departamento.class, idDepar);
		
	}

	@Override
	public int insert(Departamento departamento) {
		filas = 0;
		try {
			
		if (findById(departamento.getIdDepar()) != null) {
			filas = 0; // No lo hace porque ya existe un Departamento con ese ID
	                 
	    }else {
	    	tx.begin();
	    	em.persist(departamento);
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
	public int update(Departamento idDepar) {
		filas = 0;
		
	    try {
	    	
	    if(findById(idDepar.getIdDepar()) != null){
	    	tx.begin();
	    	em.merge(idDepar);
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
	public int deleteById(Integer idDepar) {
		filas = 0;
		Departamento departamento = findById(idDepar);
		
		try {
		
		if(departamento != null){
			tx.begin();
			em.remove(departamento);
			tx.commit();
			filas = 1; // Si lo elimina devuelve 1
			
		}else {
			filas = 0; // Si no lo hace devuelve 0, el ID proporcionado es null o no existe
			}
		
		}catch(Exception e) {
			System.err.println("Error al eliminar Departamento");
			filas = -1; // Si falla lo anterior devuelve -1
		}
		
		return filas;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> findAll() {
		jpql = "from Departamento d";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

}
