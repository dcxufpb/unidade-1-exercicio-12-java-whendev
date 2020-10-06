package com.example.project;

public class Departamento {
    private String nome;
    private String sigla;
    private String localizacao;
    private Coordenador coordenador;

    public Departamento(String nome, String sigla, String localizacao, Coordenador coordenador) {
        this.nome = nome;
        this.sigla = sigla;
        this.localizacao = localizacao;
        this.coordenador = coordenador;
    }

    public static Boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public void validarCamposObrigatorio(){
        if (isNullOrEmpty(this.nome)){
            throw new RuntimeException("O campo nome do departamento é obrigatório");
        }

        if (isNullOrEmpty(this.sigla)){
            throw new RuntimeException("O campo sigla do departamento é obrigatório");
        }

        if (isNullOrEmpty(this.localizacao)) {
            throw new RuntimeException("O campo localizacao do departamento é obrigatório");
        }
    }

    public String dadosDepartamento(){
        validarCamposObrigatorio();
        String _TEXTO = "DEPARTAMENTO:\r\n";
        _TEXTO += String.format("%s\r\n",this.nome);
        _TEXTO += String.format("%s\r\n",this.sigla);
        _TEXTO += String.format("%s\r\n",this.localizacao);
        _TEXTO += String.format("COORDENADOR:\r\n%s",coordenador.dadosCoordenador());

        return _TEXTO;
    }
}
