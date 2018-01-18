package com.br.peralles.jira.jiradatamanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.atlassian.jira.rest.client.api.domain.Issue;

@SpringBootApplication
public class JiraDataManagementApplication implements CommandLineRunner {

	private final Logger log = LoggerFactory
			.getLogger(JiraDataManagementApplication.class);
	
	@Autowired
	private ZupJiraClient ZupJiraClient;

	public static void main(String args[]) {
		SpringApplication.run(JiraDataManagementApplication.class);
	}
	

	@Override
	public void run(String... args) throws Exception {
		log.info("Starting...");
		
		Issue jiraIssue = ZupJiraClient.getIssue("RDGOV-154");
		log.info(jiraIssue.getProject().getName());
		log.info(jiraIssue.getDescription());
	}

}
// https://spring.io/guides/gs/scheduling-tasks/