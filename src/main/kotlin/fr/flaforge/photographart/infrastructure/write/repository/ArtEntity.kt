package fr.flaforge.photographart.infrastructure.write.repository

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class ArtEntity(
        @Id @GeneratedValue var id: Long? = null,
        @Column(nullable = false) val art: String,
        @Column(nullable = false) val title: String,
        @Column val description: String,
        @Column val category: String
)