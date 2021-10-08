package com.tiendavirtual.dto;

public class Producto {
	long codigo_producto;
	double ivacompra,precio_compra,precio_venta;
	String nitproveedor,nombre_producto;
	public Producto(long codigo_producto, double ivacompra,String nitproveedor, String nombre_producto, double precio_compra, double precio_venta) {
		super();
		this.codigo_producto = codigo_producto;
		this.ivacompra = ivacompra;
		this.precio_compra = precio_compra;
		this.precio_venta = precio_venta;
		this.nitproveedor = nitproveedor;
		this.nombre_producto = nombre_producto;
	}
	public long getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	public double getIvacompra() {
		return ivacompra;
	}
	public void setIvacompra(double ivacompra) {
		this.ivacompra = ivacompra;
	}
	public double getPrecio_compra() {
		return precio_compra;
	}
	public void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
	}
	public double getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}
	public String getNitproveedor() {
		return nitproveedor;
	}
	public void setNitproveedor(String nitproveedor) {
		this.nitproveedor = nitproveedor;
	}
	public String getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	@Override
	public String toString() {
		return "Producto [codigo_producto=" + codigo_producto + ", ivacompra=" + ivacompra + ", precio_compra="
				+ precio_compra + ", precio_venta=" + precio_venta + ", nitproveedor=" + nitproveedor
				+ ", nombre_producto=" + nombre_producto + "]";
	}
	
	
}
