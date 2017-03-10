package py.edu.facitec.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.model.Cliente;

@Repository //Indicamos a Spring que manejara datos
public class ClienteDAO {
	
	@PersistenceContext //Contexto de Persistencia
	private EntityManager manager;
	
public void save(Cliente cliente){
	
			//Insertar un dato
	manager.persist(cliente);
	
}	
	
	
	
	

}
