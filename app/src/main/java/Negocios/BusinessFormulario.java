package Negocios;

import java.util.ArrayList;

import dao.FormularioDAO;
import dao.daoFormulario;
import dominio.Formulario;

/**
 * Created by One Does Not Simply on 14/06/2015.
 */
public class BusinessFormulario {

    private static FormularioDAO daoFormulario;

    public BusinessFormulario(){
        daoFormulario = new FormularioDAO();
    }

    public static void update(Formulario formulario)
    {
        daoFormulario.update(formulario);
    }

    public static void create(){
        //DUVIDA SOBRE COMO CRIAR O FORMULARIO. VAI SER AQUELE GERADO DINAMICAMENTE? NAO SEI.
        daoFormulario.create();
    }

    public static Formulario getInscricao(){
        return daoFormulario.getFormulario();
    }
    public static ArrayList<Formulario> getListaInscricao(){
        return daoFormulario.getAllFormulario();
    }
}
