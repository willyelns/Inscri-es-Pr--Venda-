package Negocios;

import dominio.Inscricao;

/**
 * Created by Will Xavier on 15/06/2015.
 */
public interface StrategyValidator {
    public boolean validarDados(Inscricao inscricao);
    public boolean validarInscricao(Inscricao inscricao);
}
