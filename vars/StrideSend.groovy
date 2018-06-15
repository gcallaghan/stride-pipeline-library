#!/bin/env groovy

import org.lib.Stride

@NonCPS
def call(String conversationId, String messageIcon, String message) {
    println("Request made to stride")
    def stride = new Stride()
    if (messageIcon == "warning")
        stride.sendFailure(conversationId, message, "${env.STRIDE_TOKEN}", "${env.STRIDE_ORGID}")
    else if (messageIcon == "tip")
        stride.sendSuccess(conversationId, message, "${env.STRIDE_TOKEN}", "${env.STRIDE_ORGID}")
    else if( messageIcon == "info")
        stride.sendInfo(conversationId, message, "${env.STRIDE_TOKEN}", "${env.STRIDE_ORGID}")

}
