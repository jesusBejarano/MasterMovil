package proveedor.pe.edu.upc.mastermovil.Model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Miguel Cardoso
 */
public class Producto implements Serializable {

    private int id_producto;
    private String nombre;
    private String descripcion;
    private Double precio;

    private List<DetallePedido> listDetallePedidos;
    
    private Familia Familia;

    public Producto() {
    }

    public int getId_producto() {
        return this.id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public List<DetallePedido> getListDetallePedidos() {
        return listDetallePedidos;
    }

    public void setListDetallePedidos(List<DetallePedido> listDetallePedidos) {
        this.listDetallePedidos = listDetallePedidos;
    }

    public Familia getFamilia() {
        return Familia;
    }

    public void setFamilia(Familia Familia) {
        this.Familia = Familia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    } 

}