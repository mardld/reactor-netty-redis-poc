package mardld.reactornettyredispoc.web

import mardld.reactornettyredispoc.model.Note
import org.springframework.data.redis.core.ReactiveRedisOperations
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@RestController
@RequestMapping("/v1/notes")
class NotesController(
        val notesOps: ReactiveRedisOperations<String, Note>
) {

    @GetMapping
    fun findAll(): Flux<Note> =
            notesOps.keys("*")
                    .flatMap { notesOps.opsForValue()[it] }

    @PostMapping
    fun add(@RequestBody request: Mono<CreateNoteRequest>) =
            request
                    .map { Note(UUID.randomUUID(), it.value) }
                    .flatMap { notesOps.opsForValue().set(it.id.toString(), it).thenReturn(it) }
}

data class CreateNoteRequest(
        val value: String
)
