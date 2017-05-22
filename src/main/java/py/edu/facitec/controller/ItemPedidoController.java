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

import py.edu.facitec.dao.ItemPedidoDAO;
import py.edu.facitec.model.ItemPedido;

//Para construir un controlador que soporte la arquitectura REST
@RestController

@Transactional

@RequestMapping("/item_pedidos")//Este es utilizado para todos los metodos de la clase
public class ItemPedidoController {

	@Autowired
	private ItemPedidoDAO itemPedidoDAO;
	
	
	//Si queremos agregar una url utilizamos value="/guardar"
@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)	
												//Se convierte de Json a objeto java
										//Mediante la libreria Japckson
															
public ResponseEntity<ItemPedido>  registrar(@RequestBody ItemPedido itemPedido){
		
				System.out.println(itemPedido);
	
				itemPedidoDAO.guardar(itemPedido);

				
		return new ResponseEntity<ItemPedido>(itemPedido, HttpStatus.OK);
	}
	
@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<ItemPedido>> listado(){
	
	
	List<ItemPedido> itemPedidos=itemPedidoDAO.buscarTodos();
	
	
	System.out.println(itemPedidos);
	
					//Al indicar que va producir Json dentro del Request Mapping
	
	//Convierte el objeto java en JSON  a travéz del ResponseEntity
	return new ResponseEntity<List<ItemPedido>>(itemPedidos,HttpStatus.OK);
	
}	
                   //Parametro que recibe a travez de la url
@RequestMapping(value="/{id}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
									 //Convierte el parametro a un objeto java		
public ResponseEntity<ItemPedido> buscar(@PathVariable Integer id){
	
	
		ItemPedido itemPedido=itemPedidoDAO.buscar(id);
	
													//representa el estado 200
												//que indica que la petición se realizo con exito
	return new ResponseEntity<ItemPedido>(itemPedido,HttpStatus.OK);
}



@RequestMapping(value="/{id}", method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<ItemPedido> eliminar(@PathVariable Integer id){

	
	ItemPedido itemPedido=itemPedidoDAO.buscar(id);
	
	if(itemPedido==null){
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	itemPedidoDAO.eliminar(itemPedido);
	
	
	
	
	return new ResponseEntity<>(HttpStatus.OK);
}



	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
