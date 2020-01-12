package fr.flaforge.photographart.infrastructure.repository

import org.springframework.data.repository.CrudRepository

interface ArtRepository : CrudRepository<ArtEntity, Long>