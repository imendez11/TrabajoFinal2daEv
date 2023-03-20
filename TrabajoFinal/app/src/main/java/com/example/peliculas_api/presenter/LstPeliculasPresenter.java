package com.example.peliculas_api.presenter;

import com.example.peliculas_api.entities.Index;
import com.example.peliculas_api.entities.Peliculas;
import com.example.peliculas_api.model.LstPeliculasModel;
import com.example.peliculas_api.view.LstPeliculasContract;

import java.util.ArrayList;

public class LstPeliculasPresenter implements LstPeliculasContract.Presenter {

    private  LstPeliculasContract.View view;
    private LstPeliculasModel lstPeliculasModel;

    public LstPeliculasPresenter(LstPeliculasContract.View view){
        this.view = view;
        this.lstPeliculasModel = new LstPeliculasModel();
    }

    @Override
    public void lstPeliculas(Index index) {
        lstPeliculasModel.lstPeliculasWS(null, new
                LstPeliculasContract.Model.OnLstPeliculasListener() {
                    @Override
                    public void onSuccess(ArrayList<Index> index) {
                        if (index != null && index.size() > 0){
                            view.successLstPeliculas(index);
                        }else{
                            view.failureLstPeliculas("Erro en lista de datos");
                        }
                    }

                    @Override
                    public void onFailure(String error) {
                       view.failureLstPeliculas(error);
                    }
                });
    }
}
