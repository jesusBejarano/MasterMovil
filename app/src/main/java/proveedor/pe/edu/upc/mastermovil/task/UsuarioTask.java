package proveedor.pe.edu.upc.mastermovil.task;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;

import java.io.IOException;

import proveedor.pe.edu.upc.mastermovil.MainActivity;
import proveedor.pe.edu.upc.mastermovil.utils.HttpClientUtil;

/**
 * Created by lcardoso on 07/10/2015.
 */
public class    UsuarioTask extends AsyncTask<String,Void,String>
{
    private ProgressDialog progressDialog;
    private Context context;


    public UsuarioTask(Context context) {
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

            String result = RestClient.POST("usuarios/insertar",params[0]);

            if(result.equalsIgnoreCase("OK")){
                mensaje = "Gracias por Registrarse";
            }else{
                mensaje = "No se pudo Registrarse";
            }

        } catch (Exception e) {
            mensaje = "No se pudo Registrarse";
            e.printStackTrace();
            Log.d("Error en Task Usuario :", e.getMessage());
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
