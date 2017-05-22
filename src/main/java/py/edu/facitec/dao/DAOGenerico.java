package py.edu.facitec.dao;

import java.util.List;

import javax.persistence.EntityManager;


			      //Clase Generica
public abstract class DAOGenerico<T> {
		//paquete java.lang	
	private Class<T> entityClass;
	
	
public DAOGenerico(Class<T> entityClass) {
	this.entityClass=entityClass;	
}
				//Administrador de Entidad
protected abstract EntityManager getEntityManager();

	
public void insertar(T entity){
				//Crea el Insert para la entidad pasada
				//Utilizar la libreria Reflexion de java
	getEntityManager().persist(entity);

}	
	
public void actualizar(T entity){
			//Crea el Update
	getEntityManager().merge(entity);
}

public void eliminar(T entity){
	
	System.out.println("La entidad"+entity);//Faltaba cambiar entityClass por entity
getEntityManager().remove(getEntityManager().contains(entity)?
		entity:getEntityManager().merge(entity)
		
		
		
		);
System.out.println("La segunda "+entity);
}

public T buscar(Object id){

return getEntityManager().find(entityClass, id);	
	
}

public List<T> buscarTodos(){
														
return getEntityManager().createQuery("from "+entityClass.getSimpleName(), entityClass).getResultList();	
	
	
}

public void guardar(T entity){
	
			//Obtener el id de una entidad pasada
Object id=getEntityManager().getEntityManagerFactory().
getPersistenceUnitUtil().getIdentifier(entity);	

			
			if(id==null){
				
				insertar(entity);
				
			}else{
			
			if(buscar(entity)==null){
				insertar(entity);
			}else{
				actualizar(entity);
			}

			}
	
}




	
	
	
	

}
