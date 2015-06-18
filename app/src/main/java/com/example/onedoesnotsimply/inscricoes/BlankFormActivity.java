package com.example.onedoesnotsimply.inscricoes;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;


public class BlankFormActivity extends Activity {

    private LinearLayout layout;
    private AlertDialog dialog;
    private int campoId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank_form);
        layout = (LinearLayout) findViewById(R.id.InnerLayout);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setLogo(R.drawable.logo);
        actionBar.setTitle("New Form");
    }

    public void criarCampoNormal(String hint){
        EditText texto = new EditText(this);
        texto.setHint(hint);
        texto.setId(campoId++);
        texto.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(texto);
    }
    //Metodo para Criar campos com apenas números.
    public void criarCampoNumero(String hint){
        EditText numero = new EditText(this);
        numero.setInputType(InputType.TYPE_CLASS_NUMBER);
        numero.setId(campoId++);
        numero.setHint(hint);
        numero.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(numero);
    }

    public void exibirDialog(){
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_dialog,null);
        final Button confirmar = (Button) view.findViewById(R.id.btnConfirma);
        final Button cancelar = (Button) view.findViewById(R.id.btnCancel);
        final RadioButton tipoNumero = (RadioButton) view.findViewById(R.id.RadioNum);
        final RadioButton tipoNormal = (RadioButton) view.findViewById(R.id.RadioNumLetr);
        final EditText nomeCampo = (EditText) view.findViewById(R.id.EditNomeCampo);

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        confirmar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(nomeCampo.getText().toString() == null){
                    nomeCampo.setError("Por favor, digite um nome para o campo.");
                }
                if(tipoNumero.isChecked() == false && tipoNormal.isChecked() == false){
                    Toast.makeText(getApplicationContext(),"Por favor, escolha um tipo",Toast.LENGTH_LONG).show();
                }
                if(tipoNumero.isChecked() == true){
                    criarCampoNumero(nomeCampo.getText().toString());
                    dialog.dismiss();
                }
                if(tipoNormal.isChecked() == true){
                    criarCampoNormal(nomeCampo.getText().toString());
                    dialog.dismiss();
                }
            }
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Criando Novo Campo");
        builder.setView(view);
        dialog = builder.create();
        dialog.show();
    }
    public void salvarFormulario(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Salvar Formul\u00e1rio");
        builder.setMessage("Voc\u00ea deseja salvar o formul\u00e1rio?");
        /*builder.setPositiveButton("Confirmar", DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dial, int id){
                finish();
            }
        });*/
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_blank_form, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == android.R.id.home){
            Intent i = new Intent(this, InicioActivity.class);
            startActivity(i);
        }
        if (id == R.id.action_cancelar) {
            finish();
        }
        if(id == R.id.action_addCampo){
            exibirDialog();
        }
        if(id == R.id.action_salvar){
            //criarCampoNumero("Numero");
            // validarNovoCampo();
        }

        return super.onOptionsItemSelected(item);
    }
}