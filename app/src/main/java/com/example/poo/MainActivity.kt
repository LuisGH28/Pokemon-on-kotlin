package com.example.poo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var jota: Person = Person(name = "Luis", passaport = "A456fFg73")
        var anonym: Person = Person()
        println(jota.alive)
        println(jota.name)
        println(jota.passaport)

        anonym.Person()
        anonym.name = "Pablo"
        println(anonym.alive)
        println(anonym.name)
        println(anonym.passaport)

        jota.die()
        println(jota.alive)

        var bicho: Pokemon = Pokemon()
        println(bicho.getName())
        println(bicho.getAttackPower())
        bicho.setLife(30f)
        println(bicho.getLife())
    }
}