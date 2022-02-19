package com.example.poo

open class Person (var name: String = "anonym", var passaport: String? = null) : Thanks(){
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
    fun die(){ alive = false }
}

class Athlete (name: String, passaport: String?, var sport: String): Person(name, passaport)