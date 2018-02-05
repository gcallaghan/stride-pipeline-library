def call() {
    def jiraIssue = ( ${env.branch} +~ /\s*([A-Z]+-[0-9]+)/ )
    if (jiraIssue?.trim())
        return jiraIssue
    throw Exception("Branch does not contain a reference to a ticket")

}
