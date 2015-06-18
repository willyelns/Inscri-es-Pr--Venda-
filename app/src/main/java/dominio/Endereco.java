package dominio;

/**
 * Created by One Does Not Simply on 13/06/2015.
 */
import dominio.Endereco;


public class Endereco {

    private String rua;
    private String numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String estado;

    public Endereco(){
        rua = new String();
        numero = new String();
        bairro = new String();
        complemento = new String();
        cidade = new String();
        estado = new String();
     }
    public Endereco(String rua, String numero, String complemento, String bairro, String cidade, String estado){

        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }
}
