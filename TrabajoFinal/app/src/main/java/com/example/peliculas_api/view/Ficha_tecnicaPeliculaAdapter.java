package com.example.peliculas_api.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.peliculas_api.R;
import com.example.peliculas_api.entities.Peliculas;


import java.util.ArrayList;

public class Ficha_tecnicaPeliculaAdapter extends RecyclerView.Adapter<Ficha_tecnicaPeliculaAdapter.ViewHolder>{

    private ArrayList<Peliculas> datospeliculas;
    private Context context;

    public Ficha_tecnicaPeliculaAdapter(Context context){
        this.context = context;
        datospeliculas = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ficha_tecnica,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
         Peliculas pelicula = datospeliculas.get(position);
         holder.idTitulo.setText(pelicula.getNombre());
         holder.idTituloOriginal.setText(pelicula.getNombre());
         holder.idDireccion.setText(pelicula.getDirector());
         holder.idPais.setText(pelicula.getPais());
         holder.idAno.setText(pelicula.getAno());
         holder.idDuracion.setText(pelicula.getDuracion());
         holder.idGenero.setText(pelicula.getGenero());
         holder.idCalificacion.setText(pelicula.getClasificacion());
         holder.idReparto.setText(pelicula.getInterpretes());
         holder.idProductora.setText(pelicula.getDistribuidora());
         holder.idTrailer.setText(pelicula.getTrailer());
    }

    @Override
    public int getItemCount() {
        return datospeliculas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


       private TextView idTitulo;
       private TextView idTituloOriginal;
       private TextView idDireccion;
       private TextView idPais;
       private TextView idAno;
       private TextView idDuracion;
       private TextView idGenero;
       private TextView idCalificacion;
       private TextView idReparto;
       private TextView idProductora;
       private TextView idTrailer;

        public ViewHolder(View itemView) {
            super(itemView);
            idTitulo = itemView.findViewById(R.id.idTitulo);
            idDireccion = itemView.findViewById(R.id.idDireccion);
            idPais = itemView.findViewById(R.id.idPais);
            idAno = itemView.findViewById(R.id.idAno);
            idDuracion = itemView.findViewById(R.id.idDuracion);
            idGenero = itemView.findViewById(R.id.idGenero);
        }
    }
}
