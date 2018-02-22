package org.lib;

@Grab(group = 'org.codehaus.groovy.modules.http-builder', module = 'http-builder', version = '0.7.1')
import groovyx.net.http.RESTClient
import static groovyx.net.http.ContentType.*


class Stride {

    String sendSuccess(clientHostName,fullPath,authToken) {

        RESTClient client = new RESTClient(clientHostName)
        String plainTextToken = "PasswordIsAuthToken:" + authToken
        def authorizationToken = plainTextToken.bytes.encodeBase64()
        client.headers['Authorization'] = 'Bearer ' + authorizationToken
        response = client.get(path: fullPath)
        return response.data
    }
}

