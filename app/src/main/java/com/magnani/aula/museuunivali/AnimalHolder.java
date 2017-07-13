package com.magnani.aula.museuunivali;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.magnani.aula.museuunivali.modelo.Animal;
import com.magnani.aula.museuunivali.modelo.AnimalDao;
import com.magnani.aula.museuunivali.modelo.InfoAnimal;
import com.magnani.aula.museuunivali.utils.RoundedImageView;
import com.magnani.aula.museuunivali.utils.VolleySingleton;

/**
 * Created by marcelo on 6/27/17.
 */

public class AnimalHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView tvNome;
    private TextView tvTipo;
    private RoundedImageView ivIcone;
    private ImageView ivImportante;
    private static String position;
    private final Context context;
    private Animal objAnimal;

    public AnimalHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        tvNome = (TextView) itemView.findViewById(R.id.tvNome);
        tvTipo = (TextView) itemView.findViewById(R.id.tvTipo);
        ivIcone = (RoundedImageView) itemView.findViewById(R.id.ivIcone);
        ivImportante = (ImageView) itemView.findViewById(R.id.ivImportante);
        itemView.setOnClickListener(this);

    }

    public void atualizaDadosGaveta(final Animal a){
        tvNome.setText( a.getNome() );
        tvTipo.setText( a.getNomeCientifico() );
        objAnimal = a;
//        position = String.valueOf(a.getId());
//        if(!a.isImportante()) {
//            ivImportante.setVisibility(View.INVISIBLE);
//        }else{
//            ivImportante.setVisibility(View.VISIBLE);
//        }

        String urlServidor = tvNome.getContext().getString(R.string.url_servidor);
        urlServidor += a.getFotografia();

        VolleySingleton.getInstance(tvNome.getContext()).getImageLoader().get(
                urlServidor,
                new ImageLoader.ImageListener() {
                    @Override
                    public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                        ivIcone.setImageBitmap( response.getBitmap() );
                    }
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("univali", "Falha imagem "+a.getFotografia());
                    }
                }
        );
    }

    @Override
    public void onClick(View v) {
        int pos= objAnimal.getId();
        Toast.makeText(context, String.valueOf(pos) , Toast.LENGTH_LONG).show();

        Intent intent = new Intent(context, InfoAnimal.class);
        intent.putExtra("position", String.valueOf(pos));
        context.startActivity(intent);
    }
}
