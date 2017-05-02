package py.edu.facitec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemPedido {
	
	@Id
	@GeneratedValue //Generación automatica de id
	private Integer id;
	private int cantidadProducto;
	private double subTotal;
	
	
	@ManyToOne
	private Pedido pedido;
	
	
	@ManyToOne
	private Producto producto;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public int getCantidadProducto() {
		return cantidadProducto;
	}


	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}


	public double getSubTotal() {
		return subTotal;
	}


	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	@Override
	public String toString() {
		return "ItemPedido [id=" + id + ", cantidadProducto=" + cantidadProducto + ", subTotal=" + subTotal
				+ ", pedido=" + pedido + ", producto=" + producto + "]";
	}
	
	
	
	

}
