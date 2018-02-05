package com.br.peralles.jira.jiradatamanagement;

import com.br.peralles.jira.jiradatamanagement.rest.client.*;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@EnableJpaRepositories("com.br.peralles.jira.jiradatamanagement.rest.client")
@EntityScan("com.br.peralles.jira.jiradatamanagement.rest.client")
public class JiraDataManagementApplication {

	private static final String username = "rodrigo.pecanha@zup.com.br";
	private static final String password = "488/corrida";
	private static final Logger log = LoggerFactory.getLogger(JiraDataManagementApplication.class);

	public static void main(String[] args) {

		Issue issueTeste = new Issue();
		issueTeste.setId(1);
		issueTeste.setKey_jira("ABC-1");
		issueTeste.setStatus("open");

		IssueService issueService = new IssueService();
		issueService.insert(issueTeste);

		IssueNavigable issueNavigable = new IssueNavigable();

		String urlProjeto = "https://zupjira.atlassian.net/rest/api/2/project";
		String urlIssues = "https://zupjira.atlassian.net/rest/api/2/search?jql=project=ILBE&maxResults=1&fields=navigable";
		String urlChangeLog;

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders = createHeadersWithAuthentication();
		HttpEntity<?> requestEntity = new HttpEntity(httpHeaders);

		ResponseEntity<IssueLista> issueListaGet = restTemplate.exchange(urlIssues, HttpMethod.GET, requestEntity, IssueLista.class);

		IssueLista issueLista = issueListaGet.getBody();

		List<IssueNavigable> listIssues = issueLista.getIssues();

		IssueNavigable issue;
		IssueChangeLog issueChangeLog;

		List<Value> listValue;
		List<Item> listItem;

		Value value;
		Item item;

		for (int counter = 0; counter < listIssues.size(); counter++) {
			issue = issueLista.getIssue(counter);
			urlChangeLog = "https://zupjira.atlassian.net/rest/api/2/issue/" + issue.getKey() + "/changelog";

			ResponseEntity<IssueChangeLog> issueChangeLogGet = restTemplate.exchange(urlChangeLog, HttpMethod.GET, requestEntity, IssueChangeLog.class);
			issueChangeLog = issueChangeLogGet.getBody();

			listValue = issueChangeLog.getValues();

			for(int counterValue = 0; counterValue < listValue.size(); counterValue++){

				value = listValue.get(counterValue);
				listItem = value.getItems();

				for(int counterItem = 0; counterItem < listItem.size(); counterItem++){

					item = listItem.get(counterItem);

					if(item.getField().equals("status"))
					{
						System.out.println(issue.getKey() + " - " + issueChangeLog.getTotal().toString() + " - " + value.getId().toString() + " - " + item.getField());
					}
				}
			}
		}
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