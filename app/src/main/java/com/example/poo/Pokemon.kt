package com.example.poo

import android.widget.Toast

open class Pokemon (protected var name: String = "Pok",
               protected var attackPower: Float = 30f,
               protected var life: Float = 100f){

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

    fun sayHi(){ Toast.makeText(maincontext, "Hola!!! soy $name", Toast.LEGIN_LONG).show()}

    fun cure(){ this.life = 100f}

    fun envolve(n: String){
        this.name = n
        this.attackPower *= 1.20f
        this.sayHi()
    }

    //fun attack(){ Toast.makeText(maincontext, "Al ataqueeee", Toast.LENGTH_LONG).show() }
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

      //  override fun attack(){ Toast.makeText(maincontext, "Ataque con chorro", Toast.LENGTH_LONG).show()}
    }