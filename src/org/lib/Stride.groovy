package org.lib;

@Grab(group = 'org.codehaus.groovy.modules.http-builder', module = 'http-builder', version = '0.7.1')
import groovyx.net.http.RESTClient
import static groovyx.net.http.ContentType.*


class Stride {
    //site/{cloudId}/conversation/{conversationId}/message
    String sendSuccess(clientHostName, fullPath, authToken) {
        RESTClient client = new RESTClient(clientHostName)
        client.headers['Authorization'] = authToken
        client.ignoreSSLIssues()
        def response = client.post(path: fullPath, requestContentType: 'TEXT', body: "Building Code from: ")
        println response.data
        return response.data['cloudId']
    }
}

