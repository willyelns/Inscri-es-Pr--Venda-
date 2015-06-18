package dominio;

import Negocios.BusinessInscricao;
import Negocios.ComprovantePreVenda;
import Negocios.StrategyValidator;
import Negocios.ValidadorPreVenda;

/**
 * Created by One Does Not Simply on 14/06/2015.
 */
public class Inscricao implements InscricaoInterface {

    private ComprovantePreVenda comprovante;
    private ValidadorPreVenda validador;
        private Formulario resposta;
        private int id;

        public Inscricao(Formulario inscricao){
            resposta = inscricao;

        }

    public void salvarInscricao(Formulario inscricao){

        BusinessInscricao.create(inscricao);

    }
    public void deletarInscricao(Inscricao inscricao){

        BusinessInscricao.delete(inscricao.getId());

    }
    public void editarInscricao(Inscricao inscricao){
        BusinessInscricao.update(inscricao);
    }
    public String gerarComprovante(){

        return comprovante.gerarComprovante(this);
    }

    public boolean validarInscricao(){
     return validador.validarInscricao(this);
    }

    public Formulario getResposta() {
        return resposta;
    }

    public void setResposta(Formulario resposta) {
        this.resposta = resposta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
