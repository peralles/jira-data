package com.br.peralles.jira.jiradatamanagement.rest.client;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class IssueService {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Issue issue) {
        entityManager.persist(issue);
        //return issue.getId();
    }
}
