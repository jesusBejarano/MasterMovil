package proveedor.pe.edu.upc.mastermovil.task;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import proveedor.pe.edu.upc.mastermovil.MainActivity;
import proveedor.pe.edu.upc.mastermovil.utils.HttpClientUtil;

/**
 * Created by jesus on 9/10/2015.
 */
public class ActualizarPedidoTask extends AsyncTask<String,Void,String>

{
    private ProgressDialog progressDialog;
    private Context context;


    public ActualizarPedidoTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(
                context, "Por favor espere", "Procesando...");
    }


    @Override
    protected String doInBackground(String... params) {
        HttpClientUtil RestClient = new HttpClientUtil();
        String mensaje="";
        try {

            String result = RestClient.PUT("pedidos/actualizar",params[0]);

            if(result.equalsIgnoreCase("OK")){
                mensaje = "El Pedido se Encuentra Aprobado";
            }else{
                mensaje = "No se pudo Actualizar";
            }

        } catch (Exception e) {
            mensaje = "No se pudo Modificar";
            e.printStackTrace();
            Log.d("Error en Task Update :", e.getMessage());
        }

        return mensaje;
    }

    @Override
    protected void onPostExecute(String result) {
        progressDialog.dismiss();

        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle("Mensaje");
        dialog.setMessage(result);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(context, MainActivity.class);
                context.startActivity(i);
            }
        });
        dialog.show();

    }
}
