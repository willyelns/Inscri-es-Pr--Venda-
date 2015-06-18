package com.example.onedoesnotsimply.inscricoes;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import Adapter.ListaInscricoesAdapter;
import Negocios.BusinessInscricao;
import dominio.Inscricao;


public class ListaInscricoesActivity extends Activity {
    ListView listView;
    ListaInscricoesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
        List<Inscricao> inscricoes =  BusinessInscricao.getListaInscricao();
            if(inscricoes == null){
                Toast.makeText(getApplicationContext(), "Atividade Inesperada, volte em alguns minutos", Toast.LENGTH_SHORT);
            }

        setContentView(R.layout.activity_lista_inscricoes);


            listView = (ListView) findViewById(R.id.listInscricoes);
            adapter = new ListaInscricoesAdapter(this, R.layout.inscricao_template, inscricoes);

            listView.setAdapter(adapter);
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "Atividade Inesperada, volte em alguns minutos", Toast.LENGTH_SHORT);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inicio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
