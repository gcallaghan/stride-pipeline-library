#!/bin/env groovy


def call() {
    println "success"
    def stride = new org.lib.Stride()
    println stride.sendSuccess()
//    return 0
}