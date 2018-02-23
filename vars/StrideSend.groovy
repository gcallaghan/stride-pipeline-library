#!/bin/env groovy


def call(messageIcon, clientHostName, fullPath, authToken) {
    println "Request made to stride"
    def stride = new org.lib.Stride()
    if (messageIcon == "warning")
        stride.sendFailure(clientHostName, fullPath, authToken)
    else if (messageIcon == "tip") {
        stride.sendSuccess(clientHostName, fullPath, authToken)
    }
    else if( messageIcon == "info") {
        stride.sendInfo(clientHostName, fullPath, authToken)
    }

}