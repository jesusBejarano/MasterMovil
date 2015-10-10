package proveedor.pe.edu.upc.mastermovil.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import proveedor.pe.edu.upc.mastermovil.Model.Pedido;
import proveedor.pe.edu.upc.mastermovil.utils.HttpClientUtil;

/**
 * Created by jesus on 9/10/2015.
 */
public class PedidoTask extends AsyncTask<Void, Void, ArrayAdapter<String>>
{
    Context context;
    ProgressDialog pDialog;
    ListView listview;
    private Gson json = new Gson();
    private static String formatoJson;

    ArrayList<String> al=new ArrayList<String>();

    private List<Pedido> listPedido;

    public PedidoTask(Context context,ListView lv){
        this.context = context;
        this.listview=lv;
    }

    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();

        pDialog = new ProgressDialog(context);
        pDialog.setMessage("Cargando Lista");
        pDialog.setCancelable(true);
        pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pDialog.show();
    }


    @Override
    protected ArrayAdapter<String> doInBackground(Void... params) {
        // TODO Auto-generated method stub
        ArrayAdapter<String> adaptador=null;
        Gson pa=null;
        try {
            HttpClientUtil RestClient = new HttpClientUtil();
            String mensaje="";


            String result = RestClient.GET("pedidos/todos");
            //formatoJson = result;

            if(result != null || !result.isEmpty()){
                Type type = new TypeToken<List<Pedido>>(){}.getType();
                listPedido = json.fromJson(result, type);
               /* for (int i = 0; i < listPedido.size(); i++) {
                    Pedido vpedido = listPedido.get(i);
                    listNombres.add(nombreDistrito);
                }*/
                for( Pedido  p:listPedido)
                {
                    al.add(p.toString());
                }

        }
            adaptador = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, al);



        } catch (Exception e) {
            e.printStackTrace();
            Log.d("Error en Task Usuario :", e.getMessage());
        }
        return  adaptador;
    }

    @Override
    protected void onPostExecute(ArrayAdapter<String> result) {
        // TODO Auto-generated method stub
        super.onPostExecute(result);
        listview.setAdapter(result);
        pDialog.dismiss();
    }

}
