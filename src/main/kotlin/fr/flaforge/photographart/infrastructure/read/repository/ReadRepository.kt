package fr.flaforge.photographart.infrastructure.read.repository

import fr.flaforge.photographart.infrastructure.write.repository.ArtEntity
import org.springframework.data.repository.CrudRepository

interface ReadRepository : CrudRepository<ArtEntity, Long>