package com.magnani.aula.museuunivali;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.magnani.aula.museuunivali.modelo.Animal;
import com.magnani.aula.museuunivali.modelo.AnimalDao;

/**
 * Created by marcelo on 6/27/17.
 */

public class AnimalAdapter extends RecyclerView.Adapter {


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate( R.layout.item_lista, parent, false);
        AnimalHolder gaveta = new AnimalHolder(v);
        return gaveta;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AnimalHolder gaveta = (AnimalHolder) holder;
        gaveta.atualizaDadosGaveta( AnimalDao.obterLista().get(position) );
    }

    @Override
    public int getItemCount() {
        return AnimalDao.obterLista().size();
    }
}
