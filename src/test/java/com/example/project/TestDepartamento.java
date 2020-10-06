package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestDepartamento {

    private String BREAK = System.lineSeparator();

    private String TEXTO_ESPERADO_DEPARTAMENTO_COMPLETO = "DEPARTAMENTO:"+ BREAK +"NOME 1" + BREAK + "SIGLA 1"
            + BREAK + "LOCALIZAÇÃO 1" + BREAK
            + "COORDENADOR:" + BREAK + "NOME" + BREAK + "703.917.760-96" + BREAK + "21" + BREAK;

    @Test
    public void lojaCompleta() {
        Coordenador coordenador = new Coordenador("NOME","703.917.760-96", 21);
        Departamento departamento = new Departamento("NOME 1","SIGLA 1", "LOCALIZAÇÃO 1",coordenador);
        rodarTestarRetorno(TEXTO_ESPERADO_DEPARTAMENTO_COMPLETO, departamento);
    }

    @Test
    public void validarNomeDepartamentoObrigatorio() {
        Coordenador coordenador = new Coordenador("NOME","703.917.760-96", 21);

        Departamento departamentoVazio = new Departamento("","SIGLA 1", "LOCALIZAÇÃO 1",coordenador);
        verificarCampoObrigatorio("O campo nome do departamento é obrigatório", departamentoVazio);

        Departamento departamentoNulo = new Departamento(null,"SIGLA 1", "LOCALIZAÇÃO 1",coordenador);
        verificarCampoObrigatorio("O campo nome do departamento é obrigatório", departamentoNulo);
    }

    @Test
    public void validarSiglaDepartamentoObrigatorio() {
        Coordenador coordenador = new Coordenador("NOME","703.917.760-96", 21);

        Departamento departamentoVazio = new Departamento("NOME 1","", "LOCALIZAÇÃO 1",coordenador);
        verificarCampoObrigatorio("O campo sigla do departamento é obrigatório", departamentoVazio);

        Departamento departamentoNulo = new Departamento("NOME 1",null, "LOCALIZAÇÃO 1",coordenador);
        verificarCampoObrigatorio("O campo sigla do departamento é obrigatório", departamentoNulo);
    }

    @Test
    public void validarLocalizacaoDepartamentoObrigatorio() {
        Coordenador coordenador = new Coordenador("NOME","703.917.760-96", 21);

        Departamento departamentoVazio = new Departamento("NOME 1","SIGLA 1", "",coordenador);
        verificarCampoObrigatorio("O campo localizacao do departamento é obrigatório", departamentoVazio);

        Departamento departamentoNulo = new Departamento("NOME 1","SIGLA 1", null,coordenador);
        verificarCampoObrigatorio("O campo localizacao do departamento é obrigatório", departamentoNulo);
    }


    @Test
    public void validarNomeCoordenadorObrigatorio() {
        Coordenador coordenadorVazio = new Coordenador("","703.917.760-96", 21);

        Departamento departamentoVazio = new Departamento("NOME 1","SIGLA 1", "LOCALIZAÇÃO 1",coordenadorVazio);
        verificarCampoObrigatorio("O campo nome do coordenador é obrigatório", departamentoVazio);

        Coordenador coordenadorNulo = new Coordenador(null,"703.917.760-96", 21);
        Departamento departamentoNulo = new Departamento("NOME 1","SIGLA 1", "LOCALIZAÇÃO 1",coordenadorNulo);
        verificarCampoObrigatorio("O campo nome do coordenador é obrigatório", departamentoNulo);
    }

    @Test
    public void validarCpfCoordenadorObrigatorio() {
        Coordenador coordenadorVazio = new Coordenador("NOME","", 21);

        Departamento departamentoVazio = new Departamento("NOME 1","SIGLA 1", "LOCALIZAÇÃO 1",coordenadorVazio);
        verificarCampoObrigatorio("O campo cpf do coordenador é obrigatório", departamentoVazio);

        Coordenador coordenadorNulo = new Coordenador("NOME",null, 21);
        Departamento departamentoNulo = new Departamento("NOME 1","SIGLA 1", "LOCALIZAÇÃO 1",coordenadorNulo);
        verificarCampoObrigatorio("O campo cpf do coordenador é obrigatório", departamentoNulo);
    }


    private void rodarTestarRetorno(String expected, Departamento departamento) {

        // action
        String retorno = departamento.dadosDepartamento();

        // assertion
        assertEquals(expected, retorno);
    }

    private void verificarCampoObrigatorio(String mensagemEsperada, Departamento departamento) {
        try {
            departamento.dadosDepartamento();
        } catch (RuntimeException e) {
            assertEquals(mensagemEsperada, e.getMessage());
        }
    }
}
