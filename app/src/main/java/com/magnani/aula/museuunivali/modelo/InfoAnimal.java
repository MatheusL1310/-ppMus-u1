package com.magnani.aula.museuunivali.modelo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.magnani.aula.museuunivali.R;
import com.magnani.aula.museuunivali.modelo.Animal;
import com.magnani.aula.museuunivali.modelo.AnimalDao;
import com.magnani.aula.museuunivali.utils.VolleySingleton;

import org.w3c.dom.Text;

public class InfoAnimal extends AppCompatActivity {

    private TextView tvNome;
    private TextView tvNomeCientifico;
    private TextView tvPeso;
    private TextView tvComprimento;
    private TextView tvHabitat;
    private TextView tvAlimentacao;
    private TextView tvTempoDeVida;
    private TextView tvTempoDeExistencia;
    private TextView tvGestacao;
    private TextView tvCuriosidades;
    private ImageView ivFoto;
    private String position;
    private LinearLayout lInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_animal);

        tvNome = (TextView) findViewById(R.id.tvNome);
        tvNomeCientifico = (TextView) findViewById(R.id.tvNomeCientifico);
        tvPeso = (TextView) findViewById(R.id.tvPeso);
        tvComprimento = (TextView) findViewById(R.id.tvComprimento);
        tvHabitat = (TextView) findViewById(R.id.tvHabitat);
        tvAlimentacao = (TextView) findViewById(R.id.tvAlimentacao);
        ivFoto = (ImageView) findViewById(R.id.ivFoto);
        tvTempoDeVida = (TextView) findViewById(R.id.tvTempoDeVida);
        tvTempoDeExistencia = (TextView) findViewById(R.id.tvTempoDeExistencia);
        tvGestacao = (TextView) findViewById(R.id.tvGestacao);
        tvCuriosidades = (TextView) findViewById(R.id.tvCuriosidades);
        lInfo = (LinearLayout) findViewById(R.id.lInfo);
        position = getIntent().getStringExtra("position");
        preencheCampos(position);

    }

    public void preencheCampos(String position){
        Animal a = AnimalDao.obterLista().get(Integer.parseInt(position));
        tvNome.setText(a.getNome());
        tvNomeCientifico.setText(a.getNomeCientifico());
        tvPeso.setText(a.getPeso());
        tvComprimento.setText(a.getComprimento());
        tvHabitat.setText(a.getHabitat());
        tvAlimentacao.setText(a.getAlimentacao());
        tvTempoDeVida.setText(a.getTempoDeVida());
        tvTempoDeExistencia.setText(a.getTempoDeExistencia());
        tvGestacao.setText(a.getGestacao());
        tvCuriosidades.setText(a.getCuriosidades());

        String urlServidor = tvNome.getContext().getString(R.string.url_servidor);
        urlServidor += a.getFotografia();

        VolleySingleton.getInstance(tvNome.getContext()).getImageLoader().get(
                urlServidor,
                new ImageLoader.ImageListener() {
                    @Override
                    public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                        ivFoto.setImageBitmap( response.getBitmap() );
                    }

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("univali", "Falha imagem ");
                    }
                }
        );
    }

    public void onClickAbreInfo(View V){

        if(lInfo.getVisibility() == View.GONE){

            findViewById(R.id.lInfo).setVisibility(View.VISIBLE);;

        }else {

            findViewById(R.id.lInfo).setVisibility(View.GONE);;

        }


    }


}
