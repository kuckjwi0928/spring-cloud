package com.kuckjwi.spring.cloud.gateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
open class GatewayApplication

fun main(args: Array<String>) {
  runApplication<GatewayApplication>(*args)
}
