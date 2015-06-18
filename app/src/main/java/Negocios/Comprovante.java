package Negocios;

import dominio.Inscricao;

/**
 * Created by One Does Not Simply on 14/06/2015.
 */
public interface Comprovante {
    
    public String gerarComprovante(Inscricao inscricao);
}
