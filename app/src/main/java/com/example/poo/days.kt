package com.example.poo

enum class days (val laboral: Boolean, val jornada: Int) {
    LUNES(true, 8), MARTES (true, 8), MIERCOLES(true, 5),
    JUEVES(true, 8), VIERNES(true, 4), SABADOS(false, 0),
    DOMINGO(false, 0);

    fun saludo () : String{
        when(this){
            LUNES -> return "empezando con alegria!!!!"
            MARTES -> return "ya queda menos!!!"
            MIERCOLES -> return "sabias que los miercoles son los dias mas productivos?"
            JUEVES -> return "esta noche es juernes!"
            VIERNES -> return "hoy es viernes y el cuerpo lo sabe"
            else -> return "a quemas el findeeee!"
        }
    }

}