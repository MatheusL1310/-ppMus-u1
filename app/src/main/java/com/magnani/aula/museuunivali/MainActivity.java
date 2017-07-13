package com.magnani.aula.museuunivali;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.magnani.aula.museuunivali.modelo.Animal;
import com.magnani.aula.museuunivali.modelo.AnimalDao;
import com.magnani.aula.museuunivali.utils.IntentIntegrator;
import com.magnani.aula.museuunivali.utils.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private ListaFragment listaFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buscarDados();

        FragmentTransaction transacao = getSupportFragmentManager().beginTransaction();
        listaFragment = new ListaFragment();
        transacao.add(R.id.flFragmento1, listaFragment);
        transacao.commit();
    }

    private void buscarDados(){
        String urlServidor = getString(R.string.url_servidor);
        urlServidor += "dados.json";
        JsonArrayRequest jar = new JsonArrayRequest(
                Request.Method.GET,
                urlServidor,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for(int i = 0; i < response.length(); i++){
                                JSONObject daVez = response.getJSONObject(i);
                                Animal animaDaVez = new Animal(daVez);
                                AnimalDao.obterLista().add(animaDaVez);
                            }
                            listaFragment.atualizaDadosRecyclerView();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Erro", Toast.LENGTH_LONG).show();
                    }
                }
        );
        VolleySingleton.getInstance(this).getRequestQueue().add(jar);
    }
}
