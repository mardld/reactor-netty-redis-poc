package mardld.reactornettyredispoc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReactorNettyRedisPocApplication

fun main(args: Array<String>) {
	runApplication<ReactorNettyRedisPocApplication>(*args)
}
