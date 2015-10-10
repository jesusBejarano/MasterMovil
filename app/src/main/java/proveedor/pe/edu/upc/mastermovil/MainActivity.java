package proveedor.pe.edu.upc.mastermovil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import proveedor.pe.edu.upc.mastermovil.task.PedidoTask;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    ArrayAdapter<String> adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView)findViewById(R.id.lista);
        PedidoTask nuevaTarea = new PedidoTask(MainActivity.this,list);
        nuevaTarea.execute();

        // ArrayList<String> arreglocadenas=new ArrayList<>();
        //arreglocadenas.add("luis");
        //arreglocadenas.add("jesus");
        //new PedidoTask(MainActivity.this,lista).execute(json);

        //Inicializar el adaptador con la fuente de datos
        //adaptador = new TareaArrayAdapter<Pedido>(this, DataSourse.Pedidos);
        //adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arreglocadenas);
        //lista.setAdapter(adaptador);
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