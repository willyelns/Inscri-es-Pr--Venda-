package Negocios;

import java.util.Random;

import dominio.Formulario;
import dominio.Inscricao;

/**
 * Created by One Does Not Simply on 14/06/2015.
 */
public class ComprovantePreVenda implements Comprovante{

    public ComprovantePreVenda(){

    }

    public String gerarComprovante(Inscricao inscricao){

        String comprovante = new Random().nextInt() + inscricao.getResposta().getPerguntas().getNumeroCompra()+ "";
        return comprovante;

    }
    public String geraComprovante(Formulario inscricao){
        int numero = new Random().nextInt(Integer.MAX_VALUE);
        String comprovante = numero + inscricao.getPerguntas().getNumeroCompra() + "";
        return "O n\u00famero do seu comprovante \u00e9: " + comprovante;
    }
}
