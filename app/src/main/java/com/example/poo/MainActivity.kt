package com.example.poo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
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
    private lateinit var firePok: Firepokemon

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/*
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

 */

        var btFight = findViewById<Button>(R.id.btFight)
        btFight.setOnClickListener {
            figth(waterPok, firePok)
        }
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
        var etWaterMaxResistance = findViewById<EditText>(R.id.etWaterMaxResistance)

        waterPok = Waterpokemon()

        if(!etWaterName.text.isNullOrEmpty() && !etWaterAttackPower.text.isNullOrEmpty())
            waterPok.Waterpokemon(etWaterName.text.toString(),
                etWaterAttackPower.text.toString().toFloat(),
                etWaterMaxResistance.text.toString().toInt())

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

    fun evolveWaterPokemon(v: View){

        var etEvolveWaterPokemon = findViewById<EditText>(R.id.etEvolveWaterPokemon)

        waterPok.envolve(etEvolveWaterPokemon.text.toString())

        var ivWaterPokemon = findViewById<ImageView>(R.id.ivWaterPokemon)
        ivWaterPokemon.setImageResource(R.mipmap.water_evolved)

        var tvWaterPokemon = findViewById<TextView>(R.id.tvWaterPokemon)
        loadDataPokemon(tvWaterPokemon, waterPok)
    }

    private fun loadDataPokemon(tv: TextView, p: Pokemon){
        var description: String = ""

        description += p.getName() + " ("
        description += "AP: " + p.getAttackPower().toInt()
        description += " - L: " + p.getLife().toInt() + ")"

        tv.text = description
    }

    fun createNewFirePokemon(v: View){
        var etFireName = findViewById<EditText>(R.id.etFireName)
        var etFireAttackPower = findViewById<EditText>(R.id.etFireAttackPower)
        var etFireBallTemperature = findViewById<EditText>(R.id.etFireBallTemperature)

        firePok = Firepokemon()

        if(!etFireName.text.isNullOrEmpty() && !etFireAttackPower.text.isNullOrEmpty())
            waterPok.Waterpokemon(etFireName.text.toString(),
                etFireAttackPower.text.toString().toFloat(),
                etFireBallTemperature.text.toString().toInt())


        var ivFirePokemon = findViewById<ImageView>(R.id.ivFirePokemon)
        ivFirePokemon.setImageResource(R.mipmap.fire)
        ivFirePokemon.setBackgroundColor(ContextCompat.getColor(this,R.color.white))

        var tvFirePokemon = findViewById<TextView>(R.id.tvFirePokemon)
        loadDataPokemon(tvFirePokemon, firePok)
    }

    fun cureFirePokemon(v: View){
        firePok.cure()
        var tvFirePokemon = findViewById<TextView>(R.id.tvFirePokemon)
        loadDataPokemon(tvFirePokemon, firePok)
    }

    fun sayHiFirePokemon(v: View){ firePok.sayHi() }

    fun evolveFirePokemon(v: View){
        var etEvolveFirePokemon = findViewById<EditText>(R.id.etEvolveFirePokemon)

        firePok.envolve(etEvolveFirePokemon.text.toString())

        var ivFirePokemon = findViewById<ImageView>(R.id.ivFirePokemon)
        ivFirePokemon.setImageResource(R.mipmap.fire_evolved)

        var tvFirePokemon = findViewById<TextView>(R.id.tvFirePokemon)
        loadDataPokemon(tvFirePokemon, firePok)
    }

    private fun figth(p1: Pokemon, p2: Pokemon){
        var emtLog = findViewById<EditText>(R.id.emtLog)
        emtLog.setText("")
        var text = ""

        text += "\n${p1.getName()} (${p1.getLife().toInt()}) Vs ${p2.getName()} (${p2.getLife().toInt()})"

        while(p1.getLife() > 0 && p2.getLife() > 0){

            text += "\n${p1.getName()} ataca!"
            p1.attack();
            p2.setLife(p2.setLife() + p1.getAttackPower())
            text += "\n${p1.getName()} (${p1.getLife().toInt()}) Vs ${p2.getName()} (${p2.getLife().toInt()})"
            if(p2.getLife() > 0){
                text += "\n${p2.getName()} ataca!!"
                p2.attack()
                p1.setLife(p1.setLife() - p2.getAttackPower())
                text += "\n${p1.getName()} (${p1.getLife().toInt()}) Vs ${p2.getName()} (${p2.getLife().toInt()})"
            }
        }

        if(p1.getLife() > 0) text += "\nEL CAMPEON ES ${p1.getName()}"
        else text += "\nEL CAMPEON ES ${p2.getName()}"

        emtLog.setText(text)

        var tvFirePokemon = findViewById<TextView>(R.id.tvFirePokemon)
        loadDataPokemon(tvFirePokemon, firePok)

        var tvWaterPokemon = findViewById<TextView>(R.id.tvWaterPokemon)
        loadDataPokemon(tvWaterPokemon, waterPok)
    }


}