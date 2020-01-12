package fr.flaforge.photographart.infrastructure.web

import fr.flaforge.photographart.domain.command.AddArtCommand
import org.springframework.stereotype.Service

@Service
class ArtCommandHandler() {

    // TODO add event-driven

    fun createArt(command: AddArtCommand): Long {
        return command.execute()
    }
}