package com.example.restaurante.model;
import android.util.Log;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiManager {
    private static final String BASE_URL = "https://tiusr30pl.cuc-carrera-ti.ac.cr/Rest/api/";

    private PlatilloApi platilloApi;

    public ApiManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        platilloApi = retrofit.create(PlatilloApi.class);
    }

    public interface PlatillosCallback {
        void onSuccess(List<Menu> platillos);

        void onError(String errorMessage);
    }

    public void obtenerPlatillos(final PlatillosCallback callback) {
        Call<List<Menu>> call = platilloApi.listarPlatillos();
        call.enqueue(new Callback<List<Menu>>() {
            @Override
            public void onResponse(Call<List<Menu>> call, Response<List<Menu>> response) {
                if (response.isSuccessful()) {
                    List<Menu> platillos = response.body();

                    // Ordenar los platillos por categoría
                    Collections.sort(platillos, new Comparator<Menu>() {
                        @Override
                        public int compare(Menu menu1, Menu menu2) {
                            // Comparar por nombre de categoría
                            return menu1.getCategoriaNombre().compareTo(menu2.getCategoriaNombre());
                        }
                    });

                    // Llamar al método onSuccess del callback con la lista de platillos ordenados
                    callback.onSuccess(platillos);
                } else {
                    // Llamar al método onError del callback con el mensaje de error
                    callback.onError("Código de error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Menu>> call, Throwable t) {
                // Llamar al método onError del callback con el mensaje de error
                callback.onError("Error al realizar la llamada a la API: " + t.getMessage());
            }
        });
    }

    private Map<String, List<Menu>> agruparPorCategoria(List<Menu> platillos) {
        Map<String, List<Menu>> platillosAgrupados = new HashMap<>();

        for (Menu platillo : platillos) {
            String categoria = platillo.getCategoriaNombre();
            if (!platillosAgrupados.containsKey(categoria)) {
                platillosAgrupados.put(categoria, new ArrayList<>());
            }
            platillosAgrupados.get(categoria).add(platillo);
        }

        return platillosAgrupados;
    }
}
