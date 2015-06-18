package dao;

import java.util.ArrayList;

import dominio.Formulario;
import dominio.Inscricao;

/**
 * Created by One Does Not Simply on 13/06/2015.
 */
public interface daoInscricao {


    public void create(Formulario formulario);
    public void update(Inscricao inscricao);
    public void delete(int id);
    public int generateID();
    public void add(Inscricao inscricao);
    public Inscricao getInscricao();
    public Inscricao getInscricao(int id);
    public ArrayList<Inscricao> getAllInscricao();
}
