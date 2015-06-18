package Negocios;

import dominio.Inscricao;

/**
 * Created by One Does Not Simply on 14/06/2015.
 */
public class ValidadorPreVenda implements StrategyValidator{

    public boolean validarDados(Inscricao inscricao){

        boolean validado;

        if(inscricao.getId() > 0) {
            if (inscricao.getResposta().getPerguntas().getCpf() != null && inscricao.getResposta().getPerguntas().getCpf() != "") {
                if(inscricao.getResposta().getPerguntas().getEmail()!=null && inscricao.getResposta().getPerguntas().getEmail()!="") {
                    if (inscricao.getResposta().getPerguntas().getNumeroCartaoCredito() != null && inscricao.getResposta().getPerguntas().getNumeroCartaoCredito() != "") {
                        if (inscricao.getResposta().getPerguntas().getNumeroCompra() != null && inscricao.getResposta().getPerguntas().getNumeroCompra() != "") {
                            if (inscricao.getResposta().getPerguntas().getSenha() != null && inscricao.getResposta().getPerguntas().getSenha() != "") {
                                validado = true;
                            }
                        }
                    }
                }
            }
        }
        validado =  validarCartaoCredito(inscricao.getResposta().getPerguntas().getNumeroCartaoCredito());
        validado = validarSenhaCartao(inscricao.getResposta().getPerguntas().getSenha());
        return validado;
    }
    public boolean validarCartaoCredito(String cartao){
        boolean retorno;

        if(cartao.length() == 16){
            retorno = true;
        }else{
            retorno = false;
        }
        return retorno;
    }
    public boolean validarSenhaCartao(String senha){
        boolean retorno;
        if(senha.length() == 4 || senha.length() == 6){
            retorno = true;
        }else{
            retorno = false;
        }
        return retorno;
    }

    public boolean validarInscricao(Inscricao inscricao){
        return validarDados(inscricao);
    }
}
