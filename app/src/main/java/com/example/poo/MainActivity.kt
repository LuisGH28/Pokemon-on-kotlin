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
    private lateinit var earthPokemon: Earthpokemon

    object fernanda{
        var apodo = "fer"
        fun saludo(){"Hola me llaman $apodo"}
    }


    private fun String.noSpaces() : String{
        return this.replace(" ", "")
    }

    private fun IntArray.show(){
        print("[")
        for (i in this) print("$i ")
        println("]");
    }


    private fun calculadora( n1: Int, n2: Int, fn: (Int, Int)->Int) : Int{
        return fn(n1, n2)
    }

    private fun suma(x: Int, y: Int): Int{ return x+y}
    private fun resta(x: Int, y: Int): Int{ return x-y}
    private fun multiplicacion(x: Int, y: Int) = x*y
    private fun divide(x: Int, y: Int) =  x/y

    private fun inColombia(h: Float): Boolean{
        return h>=1.6f
    }

    private fun inSpain(h: Float): Boolean{
        return h>=1.65f
    }

    private fun Person.checkPolice(fn: (Float)->Boolean): Boolean {
        return fn(height)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        maincontext = this

        var usuario = "  soy   yo   "
        println("${usuario}  (${usuario.length})  - ${usuario.noSpaces()}  (${usuario.noSpaces().length})")


        var array1: Array<Int> = arrayOf(5, 3, 4, 7, 1)
        var array2 = IntArray(3)
        array2[0] = 10
        array2[1] = 20
        array2[2] = 30
        println("array 2:  "); array2.show();

        var array3: IntArray = intArrayOf(1, 2, 3, 4, 5)
        println("array 3:  "); array3.show();

        println("La suma de 80 y 20 es ${calculadora(80, 20, ::suma)}")
        println("La resta de 80 y 20 es ${calculadora(80, 20, ::resta)}")
        println("La multiplicacion de 80 y 20 es ${calculadora(80, 20, ::multiplicacion)}")
        println("La division de 80 y 20 es ${calculadora(80, 20, ::divide)}")




        var jota: Person = Person(name = "Luis", passaport = "A456fFg73", 1.62f)
        var anonym: Person = Person()
        println(jota.alive)
        println(jota.name)
        println(jota.passaport)
        if(jota.checkPolice(::inColombia)) println("{$jota.name} puede ser Policia en Colombia")
        if(jota.checkPolice(::inSpain)) println("{$jota.name} puede ser Policia en España")



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



        var sc = SubClasses()
        println(sc.presentar())

        var ani = SubClasses.Anidad()
        println(ani.presentar())

        var inn = SubClasses().Interna()
        println(inn.presentar())

        println(fernanda.saludo())
        fernanda.apodo = "SuperFer"
        println(fernanda.saludo())


        var sol: star = star("Sol", 696304f, "Via Lactea")
        println(sol)

        var betelqeuse : star = star("Betelqeuse", 617100000f, "Orion")
        betelqeuse.alive = false
        println(betelqeuse.alive)

        var nueva: star = star()
        println(nueva)


        var today: days = days.LUNES
        var week = days.values()
        for( i in week) println(i)

        println(days.valueOf("MIERCOLES"))
        println(today.name)
        println(today.ordinal)
        println(today.saludo())
        println(today.laboral)
        println(today.jornada)





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

    fun createNewEarthPokemon(v: View){
        var etEarthName = findViewById<EditText>(R.id.etEarthName)
        var etEarthAttackPower = findViewById<EditText>(R.id.etEarthAttackPower)
        var etEarthMaxDepth = findViewById<EditText>(R.id.etEarthMaxDepth)

        earthPokemon = Earthpokemon()

        if(!etEarthName.text.isNullOrEmpty() && !etEarthName.text.isNullOrEmpty())
            earthPokemon.Earthpokemon(etEarthName.text.toString(),
                etEarthAttackPower.text.toString().toFloat(),
                etEarthMaxDepth.text.toString().toInt())


        var ivEarthPokemon = findViewById<ImageView>(R.id.ivEarthPokemon)
        ivEarthPokemon.setImageResource(R.mipmap.earth)
        ivEarthPokemon.setBackgroundColor(ContextCompat.getColor(this,R.color.white))

        var tvEarthPokemon = findViewById<TextView>(R.id.tvEarthPokemon)
        loadDataPokemon(tvEarthPokemon, firePok)

    }

    fun cureEarthPokemon(v: View){
        earthPokemon.cure()
        var tvEarthPokemon = findViewById<TextView>(R.id.tvEarthPokemon)
        loadDataPokemon(tvEarthPokemon, firePok)
    }

    fun sayHiEarthPokemon(v: View){ earthPokemon.sayHi() }

    fun evolveEarthPokemon(v: View){
        var etEvolveEarthPokemon = findViewById<EditText>(R.id.etEvolveEarthPokemon)

        firePok.envolve(etEvolveEarthPokemon.text.toString())

        var ivEarthPokemon = findViewById<ImageView>(R.id.ivEarthPokemon)
        ivEarthPokemon.setImageResource(R.mipmap.earth_evolved)

        var tvEarthPokemon = findViewById<TextView>(R.id.tvEarthPokemon)
        loadDataPokemon(tvEarthPokemon, firePok)
    }

    fun sayBayEarthPokemon(v: View){
        earthPokemon.sayBay()
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