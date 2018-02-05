def call() {
    def gitLog = sh (
        script: 'git log -1',
        returnStdout: true
        ).trim()
        def result = (gitLog =~ /\s*([A-Z]+-[0-9]+)/)
        try {
            def jiraIssue = (result[0][0]).trim()
            return jiraIssue
            } catch (Exception ex) {
                return null
            }
      }
