package com.kuckjwi.spring.cloud.gateway.filter

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.cloud.gateway.filter.GlobalFilter
import org.springframework.context.annotation.Configuration
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Configuration
open class LoggingGlobalFilter : GlobalFilter {
  private val log: Logger = LoggerFactory.getLogger(LoggingGlobalFilter::class.java)
  override fun filter(exchange: ServerWebExchange?, chain: GatewayFilterChain): Mono<Void> {
    log.info("{}", exchange?.request?.body)
    return chain.filter(exchange)
  }
}
