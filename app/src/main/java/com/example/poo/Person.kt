package com.example.poo

class Person (var name: String = "anonym", var passaport: String? = null) {
    /*
    *
    * Aqui van los atributos y los metodos de nuestro objeto
    *
    * */

    var alive: Boolean = true

    fun Person(){
        name = "Juan"
        passaport = "HFO454HDOD02"
    }
    fun die(){
        alive = false
    }
}