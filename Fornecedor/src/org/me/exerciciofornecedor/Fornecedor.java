package org.me.exerciciofornecedor;
public class Fornecedor {
    private int ID;
    private String nome, cnpj, email, endereco, cidade, estado, telefone;
    public Fornecedor(){
    }
    public Fornecedor (int id, String nome, String cnpj, String email, String endereco, String cidade, String estado, String telefone){
        setID(id);
        setNome(nome);
        setCnpj(cnpj);
        setEmail(email);
        setEndereco(endereco);
        setCidade(cidade);
        setEstado(estado);
        setTelefone(telefone);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}

