package br.com.orderby.webservices.integracoes;

import br.com.orderby.webservices.integracoes.config.JobRunrConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(JobRunrConfig.class)
public class IntegracoesApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntegracoesApplication.class, args);
    }
}