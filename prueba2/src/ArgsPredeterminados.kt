fun main() {
    println(obtenerDato(nom="Ana", edad = 20))
    println(obtenerDato(nom = "carlos ", edad = 21))
}

fun obtenerDato(nom:String = "Diego", edad:Int):Unit{
    return "Tu nombre es $nom \n tienes $edad años"
}
/*
fun obtenerDato*/