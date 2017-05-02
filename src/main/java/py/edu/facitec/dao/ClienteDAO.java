package py.edu.facitec.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.model.Cliente;

@Repository //Indicamos a Spring que manejara datos
public class ClienteDAO extends DAOGenerico<Cliente> {

	@PersistenceContext //Contexto de Persistencia
	private EntityManager manager;
	//Metodo Constructor
	public ClienteDAO() {
		super(Cliente.class);
	}


	
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}
	
	
	
//public void save(Cliente cliente){
//	
//			//Insertar un dato
//	manager.persist(cliente);
//	
//}	
	
	
	
	

}
