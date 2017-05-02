package py.edu.facitec.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.model.Departamento;
import py.edu.facitec.model.Producto;

//Indicamos a Spring que se trata de una clase
//que manipulara datos 
@Repository
public class DepartamentoDAO extends DAOGenerico<Departamento> {

	@PersistenceContext
	private EntityManager manager;
	//Gestionar el estado y persistencia de
	//las entidades
	
	public DepartamentoDAO() {
		//Pasamos la clase con que va trabajar el DAOGenerico 
		//a travez de su constructor
		super(Departamento.class);
		// TODO Auto-generated constructor stub
	}


	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}
	
		
	

}
