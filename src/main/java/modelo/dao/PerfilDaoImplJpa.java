package modelo.dao;

import java.util.List;

import modelo.entities.Perfil;

public class PerfilDaoImplJpa extends AbsConexionJpa implements  PerfilDao{
	
	
	/* Implementar métodos */
	@Override
	public Perfil findById(Integer idPerfil) {
		return em.find(Perfil.class, idPerfil);
	}
	

	@Override
	public int insert(Perfil perfil) {
	
		filas = 0;
		try {
			
		if (findById(perfil.getIdPerfil()) != null) {
			filas = 0; // No lo hace porque ya existe un perfil con ese ID
	                 
	    }else {
	    	tx.begin();
	    	em.persist(perfil);
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
	public int update(Perfil idPerfil) {
		filas = 0;
		
	    try {
	    	
	    if(findById(idPerfil.getIdPerfil()) != null){
	    	tx.begin();
	    	em.merge(idPerfil);
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
	public int deleteById(Integer idPerfil) {
		filas = 0;
		Perfil perfil = findById(idPerfil);
		
		try {
		
		if(perfil != null){
			tx.begin();
			em.remove(perfil);
			tx.commit();
			filas = 1; // Si lo elimina devuelve 1
			
		}else {
			filas = 0; // Si no lo hace devuelve 0, el ID proporcionado es null o no existe
			}
		
		}catch(Exception e) {
			System.err.println("Error al eliminar Perfil");
			filas = -1; // Si falla lo anterior devuelve -1
		}
		
		return filas;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Perfil> findAll() {
		jpql = "from Perfil p";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

}
