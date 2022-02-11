package com.example.poo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

   companion object{
       lateinit var maincontext: Context
   }

    private lateinit var pok: Pokemon
    private lateinit var  waterPok: Waterpokemon

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

        var pele: Athlete = Athlete(name = "Pele", passaport = "GDDG654HF65", sport = "Futbol")

        println(pele.alive)
        println(pele.name)
        println(pele.passaport)
        println(pele.sport)

        pele.die()
        println(pele.alive)

        var bicho: Pokemon = Pokemon()
        println(bicho.getName())
        println(bicho.getAttackPower())
        bicho.setLife(30f)
        println(bicho.getLife())

    }

    fun createNewPokemon(v: View){
        var etName = findViewById<EditText>(R.id.etName)
        var etAttackPower = findViewById<EditText>(R.id.etAttackPower)

        pok = Pokemon()

        if(!etName.text.isNullOrEmpty() && !etAttackPower.text.isNullOrEmpty())
            pok.Pokemon(etName.text.toString(), etAttackPower.text.toString().toFloat())


        var ivPokemon = findViewById<ImageView>(R.id.ivPokemon)
        ivPokemon.setImageResource(R.mipmap.pokemon)

        var tvPokemon = findViewById<TextView>(R.id.tvPokemon)
        loadDataPokemon(tvPokemon, pok)
    }

    fun createNewWaterPokemon(v: View){

        var etWaterName = findViewById<EditText>(R.id.etWaterName)
        var etWaterAttackPower = findViewById<EditText>(R.id.etWaterAttackPower)
        var etWaterMaxResistence = findViewById<EditText>(R.id.etWaterMaxResistence)

        waterPok = Waterpokemon()

        if(!etWaterName.text.isNullOrEmpty() && !etWaterAttackPower.text.isNullOrEmpty())
            waterPok.Waterpokemon(etWaterName.text.toString(),
                etWaterAttackPower.text.toString().toFloat(),
                etWaterMaxResistence.text.toString().toInt())

        var ivWaterPokemon = findViewById<ImageView>(R.id.ivWaterPokemon)
        ivWaterPokemon.setImageResource(R.mipmap.water)
        ivWaterPokemon.setBackgroundColor(ContextCompat.getColor(this,R.color.white))

        var tvWaterPokemon = findViewById<TextView>(R.id.tvWaterPokemon)
        loadDataPokemon(tvWaterPokemon, waterPok)
    }

    fun cureWaterPokemon(){
        waterPok.cure()
        var tvWaterPokemon = findViewById<TextView>(R.id.tvWaterPokemon)
        loadDataPokemon(tvWaterPokemon, waterPok)
    }

    fun sayHiWaterPokemon(v: View){ waterPok.sayHi() }

    fun envolveWaterPokemon(v: View){

        var etEnvolveWaterPokemon = findViewById<EditText>(R.id.etEnvolveWaterPokemon)

        waterPok.envolve(etEnvolveWaterPokemon.text.toString())

        var ivWaterPokemon = findViewById<ImageView>(R.id.ivWaterPokemon)
        ivWaterPokemon.setImageResource(R.mipmap.water_envolved)

        var tvWaterpokemon = findViewById<TextView>(R.id.tvWaterPokemon)
        loadDataPokemon(tvWaterpokemon, waterPok)
    }

    private fun loadDataPokemon(tv: TextView, p: Pokemon){
        var description: String = ""

        description += p.getName() + " ("
        description += "AP: " + p.getAttackPower().toInt()
        description += " - L: " + p.getLife().toInt() + ")"

        tv.text = description
    }



}