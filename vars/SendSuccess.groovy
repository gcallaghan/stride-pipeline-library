#!/bin/env groovy


def call() {
    println "success"
    def stride = new org.lib.Stride()
    println stride.sendSuccess()
//    RESTClient client = new RESTClient(clientHostName)
//    String plainTextToken = "PasswordIsAuthToken:" + authToken
//    def authorizationToken = plainTextToken.bytes.encodeBase64()
//
//    client.headers['Authorization'] = 'Basic ' + authorizationToken
//
//    return 0
}