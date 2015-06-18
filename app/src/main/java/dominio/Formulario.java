package dominio;

/**
 * Created by One Does Not Simply on 14/06/2015.
 */
public class Formulario {

    private PreVenda perguntas;
    private int id;

    public Formulario(String nome, String sobrenome, String email, String rg, String cpf, String telefone,
                      Endereco endereco, String numeroCartaoCredito, String senha, String numeroCompra){

        perguntas = new PreVenda(nome, sobrenome, email, rg,cpf, telefone, endereco, numeroCartaoCredito, senha, numeroCompra);
    }

    public PreVenda getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(PreVenda perguntas) {
        this.perguntas = perguntas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
