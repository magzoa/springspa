package py.edu.facitec.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Departamento {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String descripcion;
	
	//Aplicación de asociacion bidireccional
			//nombre del objeto departamento en la clase Gerente mappedBy
			//Solo en una de las clases se utiliza la propiedad mappedBy
	@OneToOne(mappedBy="departamento")     //Relacion de Uno a Uno
	private Gerente gerente;
	
	
	@OneToMany(mappedBy="departamento")
	private List<Usuario> usuarios;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
