#!/bin/env groovy


def call(clientHostName,fullPath,authToken) {
    println "success"
    def stride = new org.lib.Stride()
    println stride.sendSuccess(clientHostName,fullPath,authToken)
}