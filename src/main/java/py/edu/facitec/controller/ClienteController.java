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

import py.edu.facitec.dao.ClienteDAO;
import py.edu.facitec.model.Cliente;

//Para construir un controlador que soporte la arquitectura REST
@RestController

@Transactional

@RequestMapping("/clientes")//Este es utilizado para todos los metodos de la clase
public class ClienteController {

	@Autowired
	private ClienteDAO clienteDAO;
	
	
	//Si queremos agregar una url utilizamos value="/guardar"
@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)	
												//Se convierte de Json a objeto java
										//Mediante la libreria Japckson
															
public ResponseEntity<Cliente>  registrar(@RequestBody Cliente cliente){
		
				System.out.println(cliente);
	
				clienteDAO.guardar(cliente);

				
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<Cliente>> listado(){
	
	
	List<Cliente> clientes=clienteDAO.buscarTodos();
	
	
	System.out.println(clientes);
	
					//Al indicar que va producir Json dentro del Request Mapping
	
	//Convierte el objeto java en JSON  a travéz del ResponseEntity
	return new ResponseEntity<List<Cliente>>(clientes,HttpStatus.OK);
	
}	
                   //Parametro que recibe a travez de la url
@RequestMapping(value="/{id}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
									 //Convierte el parametro a un objeto java		
public ResponseEntity<Cliente> buscar(@PathVariable Integer id){
	
	
		Cliente cliente=clienteDAO.buscar(id);
	
													//representa el estado 200
												//que indica que la petición se realizo con exito
	return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
}



@RequestMapping(value="/{id}", method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Cliente> eliminar(@PathVariable Integer id){

	
	Cliente cliente=clienteDAO.buscar(id);
	
	if(cliente==null){
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	clienteDAO.eliminar(cliente);
	
	
	
	
	return new ResponseEntity<>(HttpStatus.OK);
}



	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
