package Negocios;

import java.util.ArrayList;
import java.util.List;

import dao.InscricaoDAO;
import dominio.Formulario;
import dominio.Inscricao;


/**
 * Created by One Does Not Simply on 14/06/2015.
 */
public class BusinessInscricao {

    private static InscricaoDAO daoInscricao;


    public BusinessInscricao(){
        daoInscricao = new InscricaoDAO();
    }

    public static void update(Inscricao inscricao)
    {
        daoInscricao.update(inscricao);
    }

    public static void create(Formulario inscricao){

        daoInscricao.create(inscricao);
    }
    public static void create(Inscricao inscricao){

        daoInscricao.criar(inscricao);
    }
    public static void delete(int id){
        daoInscricao.delete(id);
    }

    public static Inscricao getInscricao(){
        return daoInscricao.getInscricao();
    }
    public static ArrayList<Inscricao> getListaInscricao(){
        return daoInscricao.getAllInscricao();
    }
}

