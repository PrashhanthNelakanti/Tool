package com.prashhanthN.ticketTool;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.prashhanthN.ticketTool.common.service.FileStorageProperties;

@SpringBootApplication
@EnableAsync
// @EnableScheduling@SpringBootApplication
@EnableConfigurationProperties({ FileStorageProperties.class })
public class TicketToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketToolApplication.class, args);
	}

	@Bean
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("GithubLookup-");
		executor.initialize();
		return executor;
	}

}
