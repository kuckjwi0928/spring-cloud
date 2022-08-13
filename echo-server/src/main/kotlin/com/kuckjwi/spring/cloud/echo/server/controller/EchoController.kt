package com.kuckjwi.spring.cloud.echo.server.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cloud.sleuth.Tracer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/echo")
class EchoController {
  private val log: Logger = LoggerFactory.getLogger(EchoController::class.java)

  @GetMapping
  fun echo(request: HttpServletRequest): String {
    // B3 propagation check
    log.info("x-b3-traceid: {}", request.getHeader("x-b3-traceid"))
    log.info("x-b3-parentspanid:: {}", request.getHeader("x-b3-parentspanid"))
    log.info("x-b3-spanid: {}", request.getHeader("x-b3-spanid"))
    return "echo"
  }
}
