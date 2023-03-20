package com.example.peliculas_api.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiPeliculas {

    public  static  final  String BASE_URL =
            "http://10.0.2.2:29901/NetBeansPeliculas/webresources/";

    private  static Retrofit retrofit = null;

    public static Retrofit getPeliculas() {
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
