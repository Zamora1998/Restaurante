package com.example.restaurante;
import com.example.restaurante.model.ApiManager;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.example.restaurante.model.Menu;
import android.util.Log;
import java.util.List;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.restaurante.model.PlatilloAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PlatilloAdapter platilloAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiManager apiManager = new ApiManager();

        // Llamada al método obtenerPlatillos del ApiManager
        apiManager.obtenerPlatillos(new ApiManager.PlatillosCallback() {
            @Override
            public void onSuccess(List<Menu> platillos) {
                // Inicializar y establecer el adaptador con la lista de platillos ordenados
                platilloAdapter = new PlatilloAdapter(platillos);
                recyclerView.setAdapter(platilloAdapter);
            }

            @Override
            public void onError(String errorMessage) {
                // Manejar el error, por ejemplo, mostrar un Toast o loggear el mensaje
                Log.e("ApiManager", errorMessage);
            }
        });
        // Agregar FloatingActionButton
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> abrirEnlace("https://tiusr30pl.cuc-carrera-ti.ac.cr/Restaurante/Views/Categorias"));
    }
    private void abrirEnlace(String enlace) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(enlace));
        startActivity(intent);
    }
}
