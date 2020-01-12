package fr.flaforge.photographart.infrastructure.repository

import fr.flaforge.photographart.domain.model.Art
import fr.flaforge.photographart.domain.model.Catalog
import org.springframework.stereotype.Repository

@Repository
class CatalogRepository(private val repository: ArtRepository): Catalog {

    // TODO add mapper

    override fun add(art: Art): Long {
        val entity = repository.save(ArtEntity(art = art.art, title = art.title, description = art.description))
        return entity.id!!
    }
}