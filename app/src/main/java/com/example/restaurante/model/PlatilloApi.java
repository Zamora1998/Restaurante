package com.example.restaurante.model;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PlatilloApi {
    @GET("Platillos/ListarPlatillos")
    Call<List<Menu>> listarPlatillos();
}