package com.example.project;

public class Coordenador {
    private String nome;
    private String cpf;
    private int idade;

    public Coordenador(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public static Boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public void validarCamposObrigatorio(){
        if (isNullOrEmpty(this.getNome())){
            throw new RuntimeException("O campo nome do coordenador é obrigatório");
        }

        if (isNullOrEmpty(this.getCpf())){
            throw new RuntimeException("O campo cpf do coordenador é obrigatório");
        }
    }

    public String dadosCoordenador(){
        validarCamposObrigatorio();
        String _TEXTO = "";
        _TEXTO += String.format("%s\r\n",getNome());
        _TEXTO += String.format("%s\r\n",getCpf());
        _TEXTO += String.format("%d\r\n",getIdade());

        return _TEXTO;
    }
}
