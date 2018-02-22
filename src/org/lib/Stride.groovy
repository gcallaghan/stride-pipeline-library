package org.lib;

@Grab(group = 'org.codehaus.groovy.modules.http-builder', module = 'http-builder', version = '0.7.1')
import groovyx.net.http.RESTClient
import static groovyx.net.http.ContentType.*


class Stride {

    String sendSuccess(clientHostName, fullPath, authToken) {
        RESTClient client = new RESTClient(clientHostName)
        client.headers['Authorization'] = authToken
        client.ignoreSSLIssues()
        response = client.get(path: fullPath)
        println response.data
        return response.data
    }
}

