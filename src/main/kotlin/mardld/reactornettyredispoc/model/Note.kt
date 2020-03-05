package mardld.reactornettyredispoc.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.redis.core.RedisHash
import java.io.Serializable
import java.util.*

@RedisHash("Note")
data class Note @JsonCreator constructor(
        @JsonProperty("id")
        val id: UUID,
        @JsonProperty("value")
        val value: String
) : Serializable
