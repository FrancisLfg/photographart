package fr.flaforge.photographart.infrastructure.write.repository

import fr.flaforge.photographart.domain.model.AddedArt
import fr.flaforge.photographart.domain.model.Art
import fr.flaforge.photographart.domain.model.ArtCategory
import fr.flaforge.photographart.domain.model.Catalog
import fr.flaforge.photographart.infrastructure.read.repository.ReadRepository
import org.springframework.stereotype.Repository

@Repository
class WriteRepository(private val repository: ReadRepository): Catalog {

    // TODO add mapper

    override fun add(art: Art): Long {
        val entity = repository.save(ArtEntity(
                art = art.art,
                title = art.title,
                description = art.description,
                category = ArtCategory.Unknown.toString()))
        return entity.id!!
    }

    override fun add(art: AddedArt): Long {
        val entity = repository.save(ArtEntity(
                art = art.art.art,
                title = art.art.title,
                description = art.art.description,
                category = art.artCategory.toString()))
        return entity.id!!
    }
}