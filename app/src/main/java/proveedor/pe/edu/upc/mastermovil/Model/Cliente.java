package proveedor.pe.edu.upc.mastermovil.Model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Miguel Cardoso
 */
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id_cliente;
    private String apellidos;
    private String contrasena;
    private String direccion;
    private String correo;
    private String nombre;
    private String telefono;
    private String usuario;

    private Distrito Distrito;
    private List<Pedido> listPedidos;

    public Cliente() {
    }

    public int getId_cliente() {
        return this.id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Distrito getDistrito() {
        return this.Distrito;
    }

    public void setDistrito(Distrito Distrito) {
        this.Distrito = Distrito;
    }

    public List<Pedido> getListPedidos() {
        return listPedidos;
    }

    public void setListPedidos(List<Pedido> listPedidos) {
        this.listPedidos = listPedidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}