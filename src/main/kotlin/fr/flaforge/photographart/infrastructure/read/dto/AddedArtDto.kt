package fr.flaforge.photographart.infrastructure.read.dto

import fr.flaforge.photographart.domain.model.Art

data class AddedArtDto(
        val art: Art,
        val category: String
)