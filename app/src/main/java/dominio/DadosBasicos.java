package dominio;

/*
 * Created by One Does Not Simply on 13/06/2015.
 */
public abstract class DadosBasicos {

    private String nome;
    private String sobrenome;
    private String email;
    private String rg;
    private String cpf;
    private String telefone;
    private Endereco endereco;

    public DadosBasicos(String nome, String sobrenome, String email, String rg, String cpf, String telefone, Endereco endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.rg = rg;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
