package dao;

import java.util.ArrayList;

import dominio.Formulario;

/**
 * Created by One Does Not Simply on 13/06/2015.
 */
public interface daoFormulario {
    public interface daoFormulariopPreVenda {

        public void create();
        public void update(Formulario formulario);
        public void delete(Formulario formulario);
        public Formulario getFormulario();
        public Formulario getFormulario(int id);
        public ArrayList<Formulario> getAllFormulario();

    }
}
