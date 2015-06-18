package dominio;

/**
 * Created by One Does Not Simply on 13/06/2015.
 */
public interface InscricaoInterface {

    public void salvarInscricao(Formulario inscricao);
    public void deletarInscricao(Inscricao inscricao);
    public void editarInscricao(Inscricao inscricao);
    public boolean validarInscricao();
    public String gerarComprovante();


}
