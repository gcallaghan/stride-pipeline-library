#!/bin/env groovy


def call(clientHostName,fullPath,authToken) {
    println "success"
    def stride = new org.lib.Stride()
    stride.sendSuccess(clientHostName,fullPath,authToken)
}