package br.com.orderby.webservices.integracoes.services;

import org.springframework.stereotype.Service;

@Service("cadastradorOperacoes")
public class CadastradorOperacoes implements ICadastradorOperacoes {

    @Override
    public void testeAgendamentoRotina(String a, String b) {
        System.out.println("teste da rotina agendada pelo JobRunr imprime:" + " param" + a + "param" + b);

    }
}