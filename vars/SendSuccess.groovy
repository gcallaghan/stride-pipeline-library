#!/bin/env groovy


def call() {
    println "success"
    def stride = new Stride()
    println stride.sendSuccess()
//    return 0
}