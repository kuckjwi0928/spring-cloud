dependencies {
  implementation("org.springframework.cloud:spring-cloud-starter-gateway")
  implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
  implementation("org.springframework.cloud:spring-cloud-sleuth-zipkin")
}

jib {
  to {
    image = "openjdk:11-slim-buster"
  }
}
