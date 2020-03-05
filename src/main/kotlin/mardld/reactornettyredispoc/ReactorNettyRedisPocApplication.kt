package mardld.reactornettyredispoc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux

@SpringBootApplication
@EnableWebFlux
class ReactorNettyRedisPocApplication

fun main(args: Array<String>) {
	runApplication<ReactorNettyRedisPocApplication>(*args)
}
