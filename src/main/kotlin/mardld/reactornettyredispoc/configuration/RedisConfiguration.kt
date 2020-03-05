package mardld.reactornettyredispoc.configuration

import mardld.reactornettyredispoc.model.Note
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory
import org.springframework.data.redis.core.ReactiveRedisOperations
import org.springframework.data.redis.core.ReactiveRedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.serializer.StringRedisSerializer


@Configuration
class RedisConfiguration {

    @Bean
    fun noteOperations(factory: ReactiveRedisConnectionFactory): ReactiveRedisOperations<String, Note> {
        val serializer = Jackson2JsonRedisSerializer(Note::class.java)
        val builder = RedisSerializationContext.newSerializationContext<String, Note>(StringRedisSerializer())
        val context = builder.value(serializer).build()
        return ReactiveRedisTemplate(factory, context)
    }
}