def call() {
    echo "printing out branch name ${env.BRANCH_NAME}"
    try {
        def jiraIssue = ( "${env.BRANCH_NAME}" =~ /\s*([A-Z]+-[0-9]+)/ )[0][0]
        echo "Jira isssue is ${jiraIssue}"
        return jiraIssue
    }
    catch(e) {
        throw Exception("Branch does not contain a reference to a ticket")
    }
    if (jiraIssue?.trim())
        return jiraIssue

}
