package br.com.orderby.webservices.integracoes.controllers.internal;

import br.com.orderby.webservices.integracoes.services.ICadastradorOperacoes;
import org.jobrunr.scheduling.JobScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/teste")
public class TesteController {

    @Autowired
    private JobScheduler jobScheduler;

    @Autowired
    @Qualifier("cadastradorOperacoes")
    private ICadastradorOperacoes cadastradorOperacoes;

    @GetMapping("/online")
    public Object test() {
        jobScheduler.enqueue(() -> cadastradorOperacoes.testeAgendamentoRotina("1", "2"));
        return null;
    }
}