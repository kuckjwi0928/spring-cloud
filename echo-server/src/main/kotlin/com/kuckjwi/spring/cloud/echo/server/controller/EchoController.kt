package com.kuckjwi.spring.cloud.echo.server.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
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
    log.info("{}", request.contextPath)
    return "echo"
  }
}
