package dao;

import android.util.Log;

import java.util.ArrayList;

import dominio.Formulario;
import dominio.Inscricao;


/**
 * Created by One Does Not Simply on 13/06/2015.
 */
public class InscricaoDAO implements daoInscricao {

    private static ArrayList<Inscricao> inscricoes = new ArrayList<>();

    public InscricaoDAO(){
    }
    public void create(Formulario inscricao){
        Inscricao insc = new Inscricao(inscricao);
        insc.setId(generateID());

        inscricoes.add(insc);
        Log.i("Salvou", "Dao");
    }
    public void criar(Inscricao inscricao){
        inscricoes.add(inscricao);
    }
    public void update(Inscricao inscricao){

        inscricoes.set(inscricao.getId(), inscricao);

    }
    public void delete(int id){

        for(int i=0; i<inscricoes.size(); i++){
            if(inscricoes.get(i).equals(id)){
                inscricoes.remove(i);
                break;
            }
        }
    }

    public void add(Inscricao inscricao){
        inscricoes.add(inscricao);
    }

    public int generateID(){ //gera o id

        //Pega o a o id da última inscrição adicionada e soma 1
        int i = inscricoes.size();
        int id = inscricoes.get(i).getId() + 1;

        return id;
    }
    public Inscricao getInscricao(){
        return inscricoes.get(inscricoes.size()); // retorna a última inscricao na lista
    }
    public Inscricao getInscricao(int id){

        Inscricao inscricao = null;
        for(int i=0; i<inscricoes.size(); i++){
            if(inscricoes.get(i).equals(id)){
                inscricao = inscricoes.get(i);
            }
        }
        return inscricao;
    }
    public ArrayList<Inscricao> getAllInscricao(){
        return inscricoes;
    }
}
