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

import py.edu.facitec.dao.PedidoDAO;
import py.edu.facitec.model.Pedido;

//Para construir un controlador que soporte la arquitectura REST
@RestController

@Transactional

@RequestMapping("/pedidos")//Este es utilizado para todos los metodos de la clase
public class PedidoController {

	@Autowired
	private PedidoDAO pedidoDAO;
	
	
	//Si queremos agregar una url utilizamos value="/guardar"
@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)	
												//Se convierte de Json a objeto java
										//Mediante la libreria Japckson
															
public ResponseEntity<Pedido>  registrar(@RequestBody Pedido pedido){
		
				System.out.println(pedido);
	
				pedidoDAO.guardar(pedido);

				
		return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
	}
	
@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<Pedido>> listado(){
	
	
	List<Pedido> pedidos=pedidoDAO.buscarTodos();
	
	
	System.out.println(pedidos);
	
					//Al indicar que va producir Json dentro del Request Mapping
	
	//Convierte el objeto java en JSON  a travéz del ResponseEntity
	return new ResponseEntity<List<Pedido>>(pedidos,HttpStatus.OK);
	
}	
                   //Parametro que recibe a travez de la url
@RequestMapping(value="/{id}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
									 //Convierte el parametro a un objeto java		
public ResponseEntity<Pedido> buscar(@PathVariable Integer id){
	
	
		Pedido pedido=pedidoDAO.buscar(id);
	
													//representa el estado 200
												//que indica que la petición se realizo con exito
	return new ResponseEntity<Pedido>(pedido,HttpStatus.OK);
}



@RequestMapping(value="/{id}", method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Pedido> eliminar(@PathVariable Integer id){

	
	Pedido pedido=pedidoDAO.buscar(id);
	
	if(pedido==null){
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	pedidoDAO.eliminar(pedido);
	
	
	
	
	return new ResponseEntity<>(HttpStatus.OK);
}



	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
