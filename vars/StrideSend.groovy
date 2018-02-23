#!/bin/env groovy


def call(conversationId, messageIcon, message) {
    println "Request made to stride"

    def stride = new org.lib.Stride()
    if (messageIcon == "warning")
        stride.sendFailure(conversationId, message, "${env.STRIDE_TOKEN}", "${env.STRIDE_ORGID}")
    else if (messageIcon == "tip") {
        stride.sendSuccess(conversationId, message, "${env.STRIDE_TOKEN}", "${env.STRIDE_ORGID}")
    }
    else if( messageIcon == "info") {
        stride.sendInfo(conversationId, message, "${env.STRIDE_TOKEN}", "${env.STRIDE_ORGID}")
    }
}