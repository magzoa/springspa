package py.edu.facitec.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.dao.GerenteDAO;
import py.edu.facitec.model.Gerente;

//Para construir un controlador que soporte la arquitectura REST
@RestController

@Transactional

@RequestMapping("/gerentes")//Este es utilizado para todos los metodos de la clase
public class GerenteController {

	@Autowired
	private GerenteDAO gerenteDAO;
	
	
	//Si queremos agregar una url utilizamos value="/guardar"
@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)	
												//Se convierte de Json a objeto java
										//Mediante la libreria Japckson
															
public ResponseEntity<Gerente>  registrar(@RequestBody Gerente gerente){
		
				System.out.println(gerente);
	
				gerenteDAO.guardar(gerente);

				
		return new ResponseEntity<Gerente>(gerente, HttpStatus.OK);
	}
	
@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<Gerente>> listado(){
	
	
	List<Gerente> gerentes=gerenteDAO.buscarTodos();
	
	
	System.out.println(gerentes);
	
					//Al indicar que va producir Json dentro del Request Mapping
	
	//Convierte el objeto java en JSON  a travéz del ResponseEntity
	return new ResponseEntity<List<Gerente>>(gerentes,HttpStatus.OK);
	
}	
                   //Parametro que recibe a travez de la url
@RequestMapping(value="/{id}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
									 //Convierte el parametro a un objeto java		
public ResponseEntity<Gerente> buscar(@PathVariable Integer id){
	
	
		Gerente gerente=gerenteDAO.buscar(id);
	
													//representa el estado 200
												//que indica que la petición se realizo con exito
	return new ResponseEntity<Gerente>(gerente,HttpStatus.OK);
}



@RequestMapping(value="/{id}", method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Gerente> eliminar(@PathVariable Integer id){

	
	Gerente gerente=gerenteDAO.buscar(id);
	
	if(gerente==null){
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	gerenteDAO.eliminar(gerente);
	
	
	
	
	return new ResponseEntity<>(HttpStatus.OK);
}



	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
