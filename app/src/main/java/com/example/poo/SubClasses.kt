package com.example.poo

class SubClasses {

    private var name = "Padre"
    fun presentar(): String { return this.name }

    class Anidad{
        private val nameAnidad = "Anidada"
        fun presentar(): String { return this.nameAnidad }
    }

    inner class Interna{
        private val nameInternal = "Interna"
        fun presentar(): String { return "Hola, soy ${this.nameInternal}, hija de ${name} "}
    }
}