package mardld.reactornettyredispoc

import mardld.reactornettyredispoc.model.Note
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface NotesRepository : CrudRepository<Note, UUID>
