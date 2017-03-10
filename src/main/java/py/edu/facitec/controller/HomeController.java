package py.edu.facitec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
				//responde a la raiz del proyecto
	@RequestMapping("/")
	public String home(){
		
		System.out.println("Cargando la pagina principal");
		
				//ubicamos el archivo dentro de la carpeta
				//ahora auto completa index.html
		return "view/templates/index";
	}
}
