package dao;

import java.util.ArrayList;

import dominio.Formulario;

/**
 * Created by One Does Not Simply on 13/06/2015.
 */
public class FormularioDAO implements daoFormulario {

    private static ArrayList<Formulario> formularios;


    public void create(){
    //DUVIDA SOBRE COMO CRIAR O FORMULARIO. SERIA AQUELE DINAMICAMENTE?

    }
    public void update(Formulario formulario){

        formularios.set(formulario.getId(),formulario);

    }
    public void delete(Formulario formulario){

        for(int i=0; i<formularios.size(); i++){
            if(formularios.get(i).equals(formulario.getId())){
                formularios.remove(i);
                break;
            }
        }

    }
    public Formulario getFormulario(){
        return formularios.get(formularios.size());
    }
    public Formulario getFormulario(int id){

        Formulario formulario = null;
        for(int i=0; i<formularios.size(); i++){
            if(formularios.get(i).equals(id)){
                formulario = formularios.get(i);
            }
        }
        return formulario;
    }
    public ArrayList<Formulario> getAllFormulario(){
        return formularios;
    }
}
