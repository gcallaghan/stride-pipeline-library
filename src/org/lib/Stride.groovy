package org.lib;

@Grab(group = 'org.codehaus.groovy.modules.http-builder', module = 'http-builder', version = '0.7.1')
import groovyx.net.http.RESTClient
import static groovyx.net.http.ContentType.*
import groovy.json.JsonSlurper

class Stride {
    //site/{cloudId}/conversation/{conversationId}/message
    String sendSuccess(clientHostName, fullPath, authToken) {

        def textBody = """
                         {
              "type": "text",
              "text": "Hello world",
              "marks": [
                {
                  "type": "textColor",
                  "attrs": {
                    "color": "#97a0af"
                  }
                }
              ]
            }
        """

        def inputJson = new JsonSlurper().parseText(textBody)
        RESTClient client = new RESTClient(clientHostName)
        client.headers['Authorization'] = authToken
        client.ignoreSSLIssues()
        def body = "<h1 style='font-color: red;'>THIS IS RED</h1>"
        def response = client.post(path: fullPath, requestContentType: JSON, body: inputJson)
        println response.data
        return response.data['cloudId']
    }
}

