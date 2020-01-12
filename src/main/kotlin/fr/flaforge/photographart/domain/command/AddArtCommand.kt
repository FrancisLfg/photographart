package fr.flaforge.photographart.domain.command

import fr.flaforge.photographart.domain.model.Art
import fr.flaforge.photographart.domain.model.Catalog

class AddArtCommand(private val art: Art, private val catalog: Catalog): Command<Long> {

    override fun execute(): Long {
        return catalog.add(art)
    }
}