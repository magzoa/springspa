package py.edu.facitec.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Pedido {
	@Id
	@GeneratedValue
	private Long id;
	private Date fechaToma;
	private Date fechaEntrega;
	private double total;
	
	//Aplicación de asociación bidireccional
	//Relación de Muchos a Uno
	@ManyToOne
	private Cliente cliente;
	
	@ManyToOne
	private Usuario usuario;
	
	@OneToMany(mappedBy="pedido")
	private List<ItemPedido> itemPedidos;
	
	
	
	//GET Y SET
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFechaToma() {
		return fechaToma;
	}
	public void setFechaToma(Date fechaToma) {
		this.fechaToma = fechaToma;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	

}
