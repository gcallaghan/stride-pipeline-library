package org.lib;

@Grab(group = 'org.codehaus.groovy.modules.http-builder', module = 'http-builder', version = '0.7.1')
import groovyx.net.http.RESTClient
import static groovyx.net.http.ContentType.*
import groovy.json.JsonSlurper

class Stride {
    String sendSuccess(clientHostName, fullPath, authToken) {

        def requestBody = [
                version: 1,
                type   : "doc",
                content: [
                        [
                                type   : "panel",
                                attrs  : [panelType: "warning"
                                ],
                                content: [
                                        [
                                                type   : "paragraph",
                                                content: [
                                                        [
                                                                type: "text",
                                                                text: "Build Fail"
                                                        ]
                                                ]
                                        ]

                                ]
                        ],


                ]
        ]
        RESTClient client = new RESTClient(clientHostName)
        client.headers['Authorization'] = authToken
        client.ignoreSSLIssues()
        def response = client.post(path: fullPath, requestContentType: "application/json", body: requestBody)
        println response.data
        return response.data['cloudId']
    }
}

