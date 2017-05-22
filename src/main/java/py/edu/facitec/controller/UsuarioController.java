package py.edu.facitec.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.dao.UsuarioDAO;
import py.edu.facitec.model.Usuario;

//Para construir un controlador que soporte la arquitectura REST
@RestController

@Transactional

@RequestMapping("/usuarios")//Este es utilizado para todos los metodos de la clase
public class UsuarioController {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	
	//Si queremos agregar una url utilizamos value="/guardar"
@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)	
												//Se convierte de Json a objeto java
										//Mediante la libreria Japckson
															
public ResponseEntity<Usuario>  registrar(@RequestBody Usuario usuario){
		
				System.out.println(usuario);
	
				usuarioDAO.guardar(usuario);

				
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<Usuario>> listado(){
	
	
	List<Usuario> usuarios=usuarioDAO.buscarTodos();
	
	
	System.out.println(usuarios);
	
					//Al indicar que va producir Json dentro del Request Mapping
	
	//Convierte el objeto java en JSON  a travéz del ResponseEntity
	return new ResponseEntity<List<Usuario>>(usuarios,HttpStatus.OK);
	
}	
                   //Parametro que recibe a travez de la url
@RequestMapping(value="/{id}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
									 //Convierte el parametro a un objeto java		
public ResponseEntity<Usuario> buscar(@PathVariable Integer id){
	
	
		Usuario usuario=usuarioDAO.buscar(id);
	
													//representa el estado 200
												//que indica que la petición se realizo con exito
	return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
}



@RequestMapping(value="/{id}", method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Usuario> eliminar(@PathVariable Integer id){

	
	Usuario usuario=usuarioDAO.buscar(id);
	
	if(usuario==null){
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	usuarioDAO.eliminar(usuario);
	
	
	
	
	return new ResponseEntity<>(HttpStatus.OK);
}



	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
