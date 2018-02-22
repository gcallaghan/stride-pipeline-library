#!/bin/env groovy
@Grab(group = 'org.codehaus.groovy.modules.http-builder', module = 'http-builder', version = '0.7.1')

def call(clientHostName, authToken) {
    echo "success"
//    RESTClient client = new RESTClient(clientHostName)
//    String plainTextToken = "PasswordIsAuthToken:" + authToken
//    def authorizationToken = plainTextToken.bytes.encodeBase64()
//
//    client.headers['Authorization'] = 'Basic ' + authorizationToken
//
//    return 0
}