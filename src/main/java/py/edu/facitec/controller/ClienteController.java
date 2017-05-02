package py.edu.facitec.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.edu.facitec.dao.ClienteDAO;
import py.edu.facitec.model.Cliente;

@Transactional //Manejara Datos el Controller
@Controller
public class ClienteController {
	
@Autowired //Inicializa el objeto dao
//a travez de la inyección de dependencia
	private ClienteDAO dao;
	
				//url ubicada en el action del formulario
	@RequestMapping("/clientes")
	
	//Mediante Spring recibimos el objeto cargado cliente
	public String registrar(Cliente cliente){
		
		System.out.println("Cliente: "+cliente);
		
		dao.guardar(cliente);
		
				//carpeta    pagina.html
		return "view/cliente/ok";
	}
}
