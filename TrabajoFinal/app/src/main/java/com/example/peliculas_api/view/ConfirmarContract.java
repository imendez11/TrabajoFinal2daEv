package com.example.peliculas_api.view;

import com.example.peliculas_api.entities.Index;

import java.util.ArrayList;

public interface ConfirmarContract {
    public  interface  View{
        void successConfirmarCompra(ArrayList<Index> lstIndex);
        void failureLstConfirmarCompra(String err);
    }
    public interface  Presenter{
        void ConfirmarCompra(Index index);
    }
    public interface  Model{
        interface  OnConfirmarCompraListener{
            void  onSuccess(ArrayList<Index> index);
            void  onFailure(String error);
        }
        void ConfirmarCompraWS(Index index, LstPeliculasContract.Model.OnLstPeliculasListener onLstPeliculasListener);

    }
}
