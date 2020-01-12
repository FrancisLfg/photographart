package fr.flaforge.photographart.domain.model

interface Catalog {
    fun add(art: Art): Long
}