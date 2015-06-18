package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.onedoesnotsimply.inscricoes.R;

import java.util.List;

import dominio.Inscricao;

/**
 * Created by Will Xavier on 10/06/2015.
 */
public class ListaInscricoesAdapter extends ArrayAdapter<Inscricao> {

    public ListaInscricoesAdapter(Context context, int textViewResourceId, List<Inscricao> objects){
        super(context, textViewResourceId, objects);
    }
    public View getView(int position, View convertView, ViewGroup parent){
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.inscricao_template, null);
        }

        Inscricao item = getItem(position);
        if(item != null){
            TextView inscricaoText = (TextView) view.findViewById(R.id.TextInscricao);
            int pos = position + 1;
            inscricaoText.setText("Inscri\u00e7\u00e3o N#: " + pos);
            TextView nomeText = (TextView) view.findViewById(R.id.txtNome);
            nomeText.setText("Nome: " + item.getResposta().getPerguntas().getNome());
            TextView sobrenomeText =  (TextView) view.findViewById(R.id.txtSobrenome);
            sobrenomeText.setText("Sobrenome: " + item.getResposta().getPerguntas().getSobrenome());
        }

        return view;
    }
}

