package fr.flaforge.photographart.domain.command

import fr.flaforge.photographart.domain.model.AddedArt
import fr.flaforge.photographart.domain.model.Art
import fr.flaforge.photographart.domain.model.ArtCategory
import fr.flaforge.photographart.domain.model.Catalog

class AddArtCommand(private val art: Art, private val catalog: Catalog): Command<Long> {

    override fun execute(): Long {
        return catalog.add(AddedArt(art, findCategory()))
    }

    private fun findCategory(): ArtCategory { // compute some when write
        return ArtCategory.Astronomy
    }
}