package py.edu.facitec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//Anotaciones @
@Entity //Indicamos que se tratara de una tabla
public class Cliente {
	
	@Id //Indicamos que se trata de la clave primaria
	@GeneratedValue //Genera automaticamente el codigo
	private Integer id;
	private String nombre;
	private String correo;
	
	public Cliente() {
	
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", correo=" + correo + "]";
	}
	
	
	

}
