package com.br.peralles.jira.jiradatamanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.br.peralles.jira.jiradatamanagement.rest.client.Quote;

@SpringBootApplication
public class JiraDataManagementApplication {
	
	private static final Logger log = LoggerFactory.getLogger(JiraDataManagementApplication.class);

	public static void main(String[] args) {
		//SpringApplication.run(JiraDataManagementApplication.class, args); //not using Spring boot
		
	    RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        log.info(quote.toString());
	}

}



//Example on
//https://spring.io/guides/gs/consuming-rest/

//About Rest Template
//http://www.baeldung.com/rest-template
