package org.lib;

@Grab(group = 'org.codehaus.groovy.modules.http-builder', module = 'http-builder', version = '0.7.1')
import groovyx.net.http.RESTClient
import static groovyx.net.http.ContentType.*

class Stride {
    String strideHostname = 'https://api.atlassian.com'
    def paneltype = [
            FAIL : "warning",
            INFO : "info",
            SUCCESS :  "tip"
    ]
    def requestBody = [
            version: 1,
            type   : "doc",
            content: [
                    [
                            type   : "panel",
                            attrs  : [panelType: null
                            ],
                            content: [
                                    [
                                            type   : "paragraph",
                                            content: [
                                                    [
                                                            type: "text",
                                                            text: null
                                                    ]
                                            ]
                                    ]

                            ]
                    ],
            ]
    ]
    String sendSuccess(conversationId, message, strideToken, orgId) {
        requestBody.content[0].content[0].content[0].text = message
        requestBody.content[0].attrs.panelType = paneltype.SUCCESS
        RESTClient client = new RESTClient(strideHostname)
        client.headers['Authorization'] = strideToken
        client.ignoreSSLIssues()
        def response = client.post(path: getConversationPath(orgId,conversationId), requestContentType: "application/json", body: requestBody)
        println response.data
        return response.data['cloudId']
    }
    String sendFailure(conversationId, message, strideToken, orgId) {
        requestBody.content[0].content[0].content[0].text = message
        requestBody.content[0].attrs.panelType = paneltype.FAIL
        RESTClient client = new RESTClient(strideHostname)
        client.headers['Authorization'] = strideToken
        client.ignoreSSLIssues()
        def response = client.post(path: getConversationPath(orgId,conversationId), requestContentType: "application/json", body: requestBody)
        println response.data
    }
    String sendInfo(conversationId, message, strideToken, orgId) {
        requestBody.content[0].content[0].content[0].text = message
        requestBody.content[0].attrs.panelType = paneltype.INFO
        RESTClient client = new RESTClient(strideHostname)
        client.headers['Authorization'] = strideToken
        client.ignoreSSLIssues()
        def response = client.post(path: getConversationPath(orgId,conversationId), requestContentType: "application/json", body: requestBody)
        println response.data
    }

    def getConversationPath(orgId,conversationId) {
        return "/site/${orgId}/conversation/${conversationId}/message"
    }
}

