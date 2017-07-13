package com.magnani.aula.museuunivali.modelo;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by marcelo on 6/27/17.
 */

public class AnimalDao {

    private static ArrayList<Animal> listaAnimais;

    public static ArrayList<Animal> obterLista(){
        if(listaAnimais == null){
            listaAnimais = new ArrayList<>();
        }
        return listaAnimais;
    }

    public static  Animal getAnimalPeloId(int id){
        for (int i = 0; i < listaAnimais.size(); i++){
            Log.d("a", String.valueOf(listaAnimais.get(i).getId()));
            if(listaAnimais.get(i).getId() == id){
                return listaAnimais.get(i);
            }
        }
        return null;
    }
}
