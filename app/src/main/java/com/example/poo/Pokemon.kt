package com.example.poo

import android.widget.Toast
import com.example.poo.MainActivity.Companion.maincontext

open class Pokemon (protected var name: String = "Pok",
               protected var attackPower: Float = 30f,
               protected var life: Float = 100f) : Thanks(){

    fun Pokemon (n: String, aP: Float){
        this.name = n
        this.attackPower = aP
        this.life = 100f
        this.sayHi()
    }

    internal fun getName(): String{ return this.name }
    internal  fun getAttackPower(): Float{ return this.attackPower }
    internal fun getLife(): Float { return this.life }
    internal fun setLife(l: Float) {  this.life = l}

    fun sayHi(){ Toast.makeText(maincontext, "Hola!!! soy $name", Toast.LENGTH_LONG).show()}

    fun cure(){
        this.life = 100f
        this.thanksCure()
    }

    fun envolve(n: String){
        this.name = n
        this.attackPower *= 1.20f
        this.sayHi()
    }

    open fun attack(){ Toast.makeText(maincontext, "Al ataqueeee", Toast.LENGTH_LONG).show() }
}

class Waterpokemon(n: String = "Pok", aP: Float = 30f, l: Float = 100f)
    : Pokemon(n, aP, l){

        private var maxResistance: Int = 500
        private var submergedTime: Int = 0

        //public var life: Float = 100f //Sin metodo get, el propio error rojo lo indica

        fun Waterpokemon(n: String, aP: Float, mR: Int){
            this.name = n
            this.attackPower = aP
            this.life = 100f
            this.maxResistance = mR
            this.sayHi()
        }

        fun breathe(){ this.submergedTime = 0}
        fun immerse(){ this.submergedTime++ }

        override fun attack(){ Toast.makeText(maincontext, "Ataque con chorro!!", Toast.LENGTH_LONG).show() }
}

class Firepokemon(n: String = "Pok", aP: Float = 30f, l: Float = 100f)
    : Pokemon(n, aP, l){
        private var ballTemperature: Int = 90
        //public var life: Float = 100f //Sin metodo get, el propio error en rojo lo indica

        fun Firepokemon(n: String, aP: Float, bT: Int){
            this.name = n
            this.attackPower = aP
            this.life = 100f
            this.ballTemperature = bT
            this.sayHi()
        }

        override fun attack(){

            super.attack()
            Toast.makeText(maincontext, "Ataque con fuego!!", Toast.LENGTH_LONG).show()
        }
    }

class Earthpokemon(n: String = "Pok", aP: Float = 30f, l: Float = 100f)
    : Pokemon(n, aP, l), SayBay{
        private var depth: Int = 150

        //public var life: Float = 100f // SIN METODO GET, EL PROPIO ERROR EN ROJO LO INDICA

        fun Earthpokemon(n: String, aP: Float, d: Int){
            this.name = n
            this.attackPower = aP
            this.life = 100f
            this.depth = d
            this.sayHi()
        }

        fun digTunnel(){
            Toast.makeText(maincontext, "Cabare un tunel de ${this.depth}m de profundidad", Toast.LENGTH_LONG).show()
        }

        override fun attack() { Toast.makeText(maincontext, "Ataque con piedras", Toast.LENGTH_LONG).show() }
    }

abstract class Thanks(){
    fun thanksCure(){ Toast.makeText(maincontext, "Gracias por curarme! ", Toast.LENGTH_LONG).show() }
}

interface SayBay{
    fun sayBay(){ Toast.makeText(maincontext, "ByeBye!", Toast.LENGTH_LONG).show() }
}