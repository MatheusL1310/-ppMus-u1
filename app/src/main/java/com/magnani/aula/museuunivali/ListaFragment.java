package com.magnani.aula.museuunivali;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.magnani.aula.museuunivali.modelo.Animal;
import com.magnani.aula.museuunivali.modelo.AnimalDao;
import com.magnani.aula.museuunivali.utils.IntentIntegrator;
import com.magnani.aula.museuunivali.utils.IntentResult;

/**
 * Created by marcelo on 6/27/17.
 */

public class ListaFragment extends Fragment {

    private AnimalAdapter adaptador;
    private RecyclerView rvLista;
    private Button btBuscar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lista, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        btBuscar = (Button) view.findViewById(R.id.btBuscar);
        btBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(ListaFragment.this);
                integrator.initiateScan();
            }
        });
        rvLista = (RecyclerView) view.findViewById(R.id.rvLista);
        adaptador = new AnimalAdapter();
        rvLista.setAdapter(adaptador);
        rvLista.setLayoutManager(new LinearLayoutManager(this.getContext()));
        atualizaDadosRecyclerView();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null) {
            try{
                Log.d(toString(), scanResult.getContents());
                int id = Integer.parseInt(scanResult.getContents());
                Animal animalEncontrado = AnimalDao.getAnimalPeloId(id);
                if(animalEncontrado == null){
                    throw new Exception("Nenhum animal com este id");
                }
                Toast.makeText(this.getContext(), "Animal encontrado: "+animalEncontrado.getNome(), Toast.LENGTH_LONG).show();
            }catch (Exception e){
                Toast.makeText(this.getContext(), "Nenhum animal encontrado", Toast.LENGTH_LONG).show();
            }
        }
        // else continue with any other code you need in the method
    }

    public void atualizaDadosRecyclerView(){
        if(adaptador != null) {
            rvLista.getAdapter().notifyDataSetChanged();
        }
    }



}
