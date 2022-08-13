package com.kuckjwi.spring.cloud.echo.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
open class EchoServerApplication

fun main(args: Array<String>) {
  runApplication<EchoServerApplication>(*args)
}
