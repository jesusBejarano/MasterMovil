package proveedor.pe.edu.upc.mastermovil.Model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jesus on 8/10/2015.
 */
public class Distrito implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id_distrito;
    private String nombre;

    private List<Sucursal> listSucursal2;
    private List<Pedido> listPedidos;
    private List<Sucursal> listSucursal;

    public Distrito() {
    }

    public int getId_distrito() {
        return this.id_distrito;
    }

    public void setId_distrito(int id_distrito) {
        this.id_distrito = id_distrito;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Sucursal> getListSucursal2() {
        return listSucursal2;
    }

    public void setListSucursal2(List<Sucursal> listSucursal2) {
        this.listSucursal2 = listSucursal2;
    }

    public List<Pedido> getListPedidos() {
        return listPedidos;
    }

    public void setListPedidos(List<Pedido> listPedidos) {
        this.listPedidos = listPedidos;
    }

    public List<Sucursal> getListSucursal() {
        return listSucursal;
    }

    public void setListSucursal(List<Sucursal> listSucursal) {
        this.listSucursal = listSucursal;
    }

}
