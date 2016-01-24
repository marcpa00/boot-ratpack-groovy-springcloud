package com.example

import groovy.util.logging.Slf4j
import ratpack.exec.Blocking
import ratpack.groovy.handling.GroovyContext
import ratpack.groovy.handling.GroovyHandler

import static ratpack.jackson.Jackson.json

@Slf4j
class MyHandler extends GroovyHandler {
    @Override
    protected void handle(GroovyContext context) {
        context.with {
            request.body.then { jsonBody ->
                Blocking.get {
                    log.info "* received json body : ${jsonBody.text}"
                    jsonBody.text
                }.then { String jsonBodyText ->
                    log.info "* in then block, var passed to closure (jsonBodyText) is : '${jsonBodyText}'"
                    render json([input: jsonBodyText])
                }
            }
        }
    }
}



