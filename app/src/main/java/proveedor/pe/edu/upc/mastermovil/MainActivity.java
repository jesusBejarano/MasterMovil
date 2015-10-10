package proveedor.pe.edu.upc.mastermovil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Objects;

import proveedor.pe.edu.upc.mastermovil.Model.Pedido;
import proveedor.pe.edu.upc.mastermovil.task.ActualizarPedidoTask;
import proveedor.pe.edu.upc.mastermovil.task.PedidoTask;

public class MainActivity extends AppCompatActivity {
    Pedido pedido;
    private ListView list;
    Gson gson;
    ArrayAdapter<String> adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView)findViewById(R.id.lista);
        PedidoTask nuevaTarea = new PedidoTask(MainActivity.this,list);
        nuevaTarea.execute();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Object listChoice = list.getItemAtPosition(position) ;
                // obtener el texto del item seleccionado
                String sTexto = listChoice.toString();
                // Texto que vamos a buscar
                String sTextoBuscado = "|";
                // obteninedo el numero entero
                sTexto = sTexto.substring(0,sTexto.indexOf(sTextoBuscado));

                pedido = new Pedido();
                pedido.setId_pedido(Integer.parseInt(sTexto));
                 gson = new Gson();
                String js = gson.toJson(pedido);

                String json = gson.toJson(pedido);
                Log.d("Json Cliente : ", json);

                new ActualizarPedidoTask(MainActivity.this).execute(json);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
