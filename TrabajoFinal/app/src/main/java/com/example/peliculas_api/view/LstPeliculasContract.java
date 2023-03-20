package com.example.peliculas_api.view;

import com.example.peliculas_api.entities.Index;
import com.example.peliculas_api.entities.Peliculas;

import java.util.ArrayList;

public interface LstPeliculasContract {
    public  interface  View{
        void successLstPeliculas(ArrayList<Index> lstIndex);
        void failureLstPeliculas(String err);
    }
    public interface  Presenter{
        void lstPeliculas(Index index);
    }
    public interface  Model{
        interface  OnLstPeliculasListener{
            void  onSuccess(ArrayList<Index> index);
            void  onFailure(String error);
        }
        void lstPeliculasWS(Index index, OnLstPeliculasListener onLstPeliculasListener);

    }
}
