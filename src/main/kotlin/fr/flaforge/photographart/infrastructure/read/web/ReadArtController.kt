package fr.flaforge.photographart.infrastructure.read.web

import fr.flaforge.photographart.infrastructure.read.repository.ReadRepository
import fr.flaforge.photographart.infrastructure.write.dto.ArtDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping(value = ["arts"], method = [RequestMethod.GET])
class ReadArtController(private val repository: ReadRepository) {

    // cache, scaling etc

    @GetMapping("/{id}")
    fun getArt(@PathVariable id: String): ResponseEntity<ArtDto> {
        return ResponseEntity.ok(repository.findById(id.toLong()).get()
                .let { a -> ArtDto(a.art, a.title, a.description) })
    }

    // getAll, getByxx etc

}