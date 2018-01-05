package com.br.peralles.jira.jiradatamanagement;

import com.br.peralles.jira.jiradatamanagement.rest.client.IssueLista;
import com.br.peralles.jira.jiradatamanagement.rest.client.IssueNavigable;
import com.br.peralles.jira.jiradatamanagement.rest.client.Quote;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;


@SpringBootApplication
public class JiraDataManagementApplication {

	private static final String username = "rodrigo.pecanha@zup.com.br";
	private static final String password = "488/corrida";
	private static final Logger log = LoggerFactory.getLogger(JiraDataManagementApplication.class);

	public static void main(String[] args) {
		//SpringApplication.run(JiraDataManagementApplication.class, args); //not using Spring boot

		IssueNavigable issueNavigable = new IssueNavigable();

		String urlProjeto = "https://zupjira.atlassian.net/rest/api/2/project";
		String urlIssues = "https://zupjira.atlassian.net/rest/api/2/search?jql=project=ILBE&maxResults=10&fields=navigable";

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders httpHeaders = new HttpHeaders();

		httpHeaders = createHeadersWithAuthentication();

		HttpEntity<?> requestEntity = new HttpEntity(httpHeaders);

		ResponseEntity<IssueLista> issueListaGet = restTemplate.exchange(urlIssues, HttpMethod.GET, requestEntity, IssueLista.class);

		IssueLista issueLista = new IssueLista();
		issueLista = issueListaGet.getBody();


		/*
			ObjectMapper mapper = new ObjectMapper();
			String json;
			json = projetos.getBody();

			Map<Object, Object> map = new HashMap<Object, Object>();
			map = mapper.readValue(json, new TypeReference<Map<Object, Object>>(){});
			System.out.println(map);

			Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		*/
	}

	static private HttpHeaders createHeadersWithAuthentication() {
		String plainCreds = username + ":" + password;
		byte[] base64CredsBytes = Base64.encodeBase64(
				plainCreds.getBytes(Charset.forName("US-ASCII")) );
		String base64Creds = new String(base64CredsBytes);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);

		return headers;
	}

}