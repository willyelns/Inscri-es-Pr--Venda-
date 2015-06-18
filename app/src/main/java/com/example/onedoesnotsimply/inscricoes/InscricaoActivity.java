package com.example.onedoesnotsimply.inscricoes;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

import Negocios.BusinessInscricao;
import Negocios.ComprovantePreVenda;
import dominio.Endereco;
import dominio.Formulario;
import dominio.Inscricao;


public class InscricaoActivity extends Activity {

    Formulario respostas;
    EditText nome;
    EditText sobrenome;
    EditText email;
    EditText rg;
    EditText cpf;
    EditText telefone;
    EditText rua;
    EditText numero;
    EditText bairro;
    EditText cidade;
    EditText estado;
    EditText complemento;
    EditText numCartaoCredito;
    EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscricao);

        nome = (EditText) findViewById(R.id.editNome);
        sobrenome = (EditText) findViewById(R.id.editSobrenome);
        email = (EditText) findViewById(R.id.editEmail);
        rg = (EditText) findViewById(R.id.editRg);
        cpf = (EditText) findViewById(R.id.editCpf);
        telefone = (EditText) findViewById(R.id.editTelefone);
        rua = (EditText) findViewById(R.id.EditRua);
        numero = (EditText) findViewById(R.id.EditNumero);
        bairro = (EditText) findViewById(R.id.EditBairro);
        cidade = (EditText) findViewById(R.id.EditCidade);
        estado = (EditText) findViewById(R.id.EditEstado);
        complemento = (EditText) findViewById(R.id.EditComplemento);
        numCartaoCredito = (EditText) findViewById(R.id.EditNumCartaoCredito);
        senha = (EditText) findViewById(R.id.EditSenhaCartao);
    }

    public boolean validarDados() {
        boolean retorno;
        boolean cartao,senhaCartao;
        if (nome.getText().toString().isEmpty()) {
            nome.setError("Preencha este Campo");
            retorno = false;
        } else {
            retorno = true;
        }
        if (sobrenome.getText().toString().isEmpty()) {
            sobrenome.setError("Preencha este Campo");
            retorno = false;
        } else {
            retorno = true;
        }
        if (email.getText().toString().isEmpty()) {
            email.setError("Preencha este Campo");
            retorno = false;
        } else {
            retorno = true;
        }
        if (rg.getText().toString().isEmpty()) {
            rg.setError("Preencha este Campo");
            retorno = false;
        } else {
            retorno = true;
        }
        if (cpf.getText().toString().isEmpty()) {
            cpf.setError("Preencha este Campo");
            retorno = false;
        } else {
            retorno = true;
        }
        if (telefone.getText().toString().isEmpty()) {
            telefone.setError("Preencha este Campo");
            retorno = false;
        } else {
            retorno = true;
        }
        if (rua.getText().toString().isEmpty()) {
            rua.setError("Preencha este Campo");
            retorno = false;
        } else {
            retorno = true;
        }
        if (bairro.getText().toString().isEmpty()) {
            bairro.setError("Preencha este Campo");
            retorno = false;
        } else {
            retorno = true;
        }
        if (complemento.getText().toString().isEmpty()) {
            complemento.setError("Preencha este Campo");
            retorno = false;
        } else {
            retorno = true;
        }
        if (numero.getText().toString().isEmpty()) {
            numero.setError("Preencha este Campo");
            retorno = false;
        } else {
            retorno = true;
        }
        if (cidade.getText().toString().isEmpty()) {
            cidade.setError("Preencha este Campo");
            retorno = false;
        } else {
            retorno = true;
        }
        if (estado.getText().toString().isEmpty()) {
            estado.setError("Preencha este Campo");
            retorno = false;
        } else {
            retorno = true;
        }
        if (numCartaoCredito.getText().toString().length() < 16) {
            numCartaoCredito.setError("O número do cartão precisa de 16 dígitos");
            retorno = false;
            cartao = false;
        } else {
            retorno = true;
            cartao = true;
        }
        if (senha.getText().toString().length() < 4) {
            senha.setError("A senha precisa de 4 digitos");
            retorno = false;
            senhaCartao = false;
        } else {
            retorno = true;
            senhaCartao = true;
        }
        if(cartao == true && senhaCartao == true){
            retorno = true;
        }else{
            retorno = false;
        }
        return retorno;
    }

    public void criaInscricao() {

        BusinessInscricao acessoDao = new BusinessInscricao();

        String nomeString = nome.getText().toString();
        String sobrenomeString = sobrenome.getText().toString();
        String emailString = email.getText().toString();
        String rgString = rg.getText().toString();
        String cpfString = cpf.getText().toString();
        Endereco endereco = new Endereco(rua.getText().toString(), numero.getText().toString(), complemento.getText().toString(), bairro.getText().toString(),
                cidade.getText().toString(), estado.getText().toString());
        int num = new Random().nextInt(Integer.MAX_VALUE) + 1;
        String numCompra = num + "";
        respostas = new Formulario(nomeString, sobrenomeString, emailString, rgString, cpfString, telefone.getText().toString(), endereco, numCartaoCredito.getText().toString()
                , senha.getText().toString(), numCompra);
        try {
            Inscricao insc = new Inscricao(respostas);
            acessoDao.create(insc);

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "O sistema n\u00e3o conseguiu salvar a Inscri\u00e7\u00e3o, tente novamente mais tarde.", Toast.LENGTH_SHORT);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inscricao, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_salvar) {
            //salva e volta ao menu.
            ComprovantePreVenda comprovantePreVenda = new ComprovantePreVenda();
            if(validarDados()){
                criaInscricao();
                Toast.makeText(getApplicationContext(), comprovantePreVenda.geraComprovante(respostas), Toast.LENGTH_LONG).show();
                finish();
            }else{
                Toast.makeText(getApplicationContext(), "N\u00e3o salvou! ", Toast.LENGTH_SHORT).show();
            }
        }
        if(id == R.id.action_cancelar){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
