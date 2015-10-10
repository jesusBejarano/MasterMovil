package proveedor.pe.edu.upc.mastermovil.DAO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

import proveedor.pe.edu.upc.mastermovil.Model.Pedido;

/**
 * Created by jesus on 9/10/2015.
 */
public class DaoPedido {
    public DaoPedido() {
    }

    public ArrayList<String> ObtenerPedidos(String v_jSONObject) throws JSONException {
        ArrayList<String> al=new ArrayList<String>();
        JSONArray jsonArray = new JSONArray(v_jSONObject);
        ArrayList<Pedido> list = new ArrayList<Pedido>();
        for (int i=0; i<jsonArray.length(); i++) {
            list.add((Pedido)jsonArray.get(i));
        }
        for( Pedido  p:list)
        {
           al.add(p.toString());
        }
        return al;
    }
}
