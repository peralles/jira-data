package com.br.peralles.jira.jiradatamanagement.rest.client;

import java.util.ArrayList;
import java.util.List;

public class IssueLista {

    private String expand;
    private String startAt;
    private String maxResults;
    private String total;
    private List<IssueNavigable> issues = new ArrayList<IssueNavigable>();

    public String getExpand() { return expand; }
    public void setExpand(String expand) {
        this.expand = expand;
    }

    public String getStartAt() {
        return startAt;
    }
    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public String getMaxResults() {
        return maxResults;
    }
    public void setMaxResults(String maxResults) {
        this.maxResults = maxResults;
    }

    public String getTotal() {
        return total;
    }
    public void setTotal(String total) {
        this.total = total;
    }

    public List<IssueNavigable> getIssues() {
        return issues;
    }

    public void setIssues2 (IssueNavigable issueNavigable)
    {
        this.issues.add(issueNavigable);
    }

    public IssueNavigable getIssue (int i){
        return issues.get(i);
    }
}
