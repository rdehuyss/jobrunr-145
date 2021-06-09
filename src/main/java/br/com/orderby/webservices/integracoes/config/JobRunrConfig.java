package br.com.orderby.webservices.integracoes.config;

import org.jobrunr.configuration.JobRunr;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.server.BackgroundJobServerConfiguration;
import org.jobrunr.server.JobActivator;
import org.jobrunr.storage.InMemoryStorageProvider;
import org.jobrunr.storage.StorageProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

public class JobRunrConfig {

    @Bean
    public StorageProvider storageProvider() {
        return new InMemoryStorageProvider();
    }

    @Bean
    public JobActivator jobActivator(ApplicationContext applicationContext) {
        return applicationContext::getBean;
    }

    @Bean
    public BackgroundJobServerConfiguration confJobServer() {
        return BackgroundJobServerConfiguration
                .usingStandardBackgroundJobServerConfiguration()
                .andWorkerCount(4)
                .andDeleteSucceededJobsAfter(Duration.ofDays(1L))
                .andPermanentlyDeleteDeletedJobsAfter(Duration.ofDays(3L))
                .andPollIntervalInSeconds(20);
    }

    @Bean
    public JobScheduler initJobRunr(JobActivator activator, BackgroundJobServerConfiguration backgroundJobServerConfiguration, StorageProvider storageProvider) {
        return JobRunr.configure()
                .useStorageProvider(storageProvider)
                .useJobActivator(activator)
                .useBackgroundJobServer(backgroundJobServerConfiguration)
                .useJmxExtensions()
                .useDashboard(3685)
                .initialize();
    }


}