package fr.flaforge.photographart.infrastructure.web

import fr.flaforge.photographart.domain.command.AddArtCommand
import fr.flaforge.photographart.domain.model.Art
import fr.flaforge.photographart.domain.model.Catalog
import fr.flaforge.photographart.infrastructure.repository.ArtRepository
import fr.flaforge.photographart.infrastructure.web.dto.ArtDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.security.PrivateKey
import javax.validation.ValidationException
import kotlin.NoSuchElementException

@Controller
@RequestMapping("arts")
class PhotographartController(
        private val catalog: Catalog,
        private val commandHandler: ArtCommandHandler,
        private val repository: ArtRepository
) {

    @PostMapping
    fun addArt(@RequestBody artDto: ArtDto): ResponseEntity<Long> {
        // map
        val art = Art(artDto.art, artDto.title, artDto.description)
        art.validate() // should be done at object creation
                .takeIf { v -> v }
                ?: throw ValidationException("Not a valid art")
        //create command
        val command = AddArtCommand(art, catalog)
        //execute command
        val id = commandHandler.createArt(command)
        // response
        return ResponseEntity.ok(id)
    }

    // update, remove etc

    @GetMapping("/{id}")
    fun getArt(@PathVariable id: String): ResponseEntity<ArtDto> {
        return ResponseEntity.ok(repository.findById(id.toLong()).get()
                .let { a -> ArtDto(a.art, a.title, a.description) })
    }

    // getAll, getByxx etc

    @ExceptionHandler(NoSuchElementException::class)
    fun noSuchArt(ex: NoSuchElementException): ResponseEntity<String> {
        return ResponseEntity("No such art", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ValidationException::class)
    fun noSuchArt(ex: ValidationException): ResponseEntity<String> {
        return ResponseEntity(ex.message, HttpStatus.BAD_REQUEST);
    }

}