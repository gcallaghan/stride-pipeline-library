def call() {
    def jiraIssue = ( "${env.BRANCH_NAME}" =~ /\s*([A-Z]+-[0-9]+)/ )
    echo "Jira isssue is ${jiraIssue}"
    env.JIRA_ISSUE = jiraIssue
    echo ""
    if (jiraIssue?.trim())
        return jiraIssue
    throw Exception("Branch does not contain a reference to a ticket")

}
