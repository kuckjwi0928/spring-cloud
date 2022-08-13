dependencies {
	implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-server")
}

jib {
	to {
		image = "openjdk:11-slim-buster"
	}
}
