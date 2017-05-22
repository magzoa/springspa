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

import py.edu.facitec.dao.DepartamentoDAO;
import py.edu.facitec.model.Departamento;

//Para construir un controlador que soporte la arquitectura REST
@RestController

@Transactional

@RequestMapping("/departamentos")//Este es utilizado para todos los metodos de la clase
public class DepartamentoController {

	@Autowired
	private DepartamentoDAO departamentoDAO;
	
	
	//Si queremos agregar una url utilizamos value="/guardar"
@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)	
												//Se convierte de Json a objeto java
										//Mediante la libreria Japckson
															
public ResponseEntity<Departamento>  registrar(@RequestBody Departamento departamento){
		
				System.out.println(departamento);
	
				departamentoDAO.guardar(departamento);

				
		return new ResponseEntity<Departamento>(departamento, HttpStatus.OK);
	}
	
@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<Departamento>> listado(){
	
	
	List<Departamento> departamentos=departamentoDAO.buscarTodos();
	
	
	System.out.println(departamentos);
	
					//Al indicar que va producir Json dentro del Request Mapping
	
	//Convierte el objeto java en JSON  a travéz del ResponseEntity
	return new ResponseEntity<List<Departamento>>(departamentos,HttpStatus.OK);
	
}	
                   //Parametro que recibe a travez de la url
@RequestMapping(value="/{id}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
									 //Convierte el parametro a un objeto java		
public ResponseEntity<Departamento> buscar(@PathVariable Integer id){
	
	
		Departamento departamento=departamentoDAO.buscar(id);
	
													//representa el estado 200
												//que indica que la petición se realizo con exito
	return new ResponseEntity<Departamento>(departamento,HttpStatus.OK);
}



@RequestMapping(value="/{id}", method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Departamento> eliminar(@PathVariable Integer id){

	
	Departamento departamento=departamentoDAO.buscar(id);
	
	if(departamento==null){
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	departamentoDAO.eliminar(departamento);
	
	
	
	
	return new ResponseEntity<>(HttpStatus.OK);
}



	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
