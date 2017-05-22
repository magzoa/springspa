package py.edu.facitec.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.model.ItemPedido;
import py.edu.facitec.model.Producto;

//Indicamos a Spring que se trata de una clase
//que manipulara datos 
@Repository
public class ItemPedidoDAO extends DAOGenerico<ItemPedido> {
	
	//Gestionar el estado y persistencia de
	//las entidades
	
	public ItemPedidoDAO() {
		//Pasamos la clase con que va trabajar el DAOGenerico 
		//a travez de su constructor
		super(ItemPedido.class);
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	private EntityManager manager;

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}
	
		
	

}
