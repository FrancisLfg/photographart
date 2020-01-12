package fr.flaforge.photographart.domain.command

interface Command<T> {
    fun execute(): T
}