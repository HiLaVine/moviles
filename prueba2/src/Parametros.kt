//PARAMETROS
/*
fun main(){
   println(ObtenDatos("Mario")); //la función main imprime la cadena Mario y guarda en función ObtenDatos

}

fun ObtenDatos(nom:String):String{ //unicamente contamos con 1 parámetro que es nom = valor guardado anteriormente
    val edad =20;
    return "Tu nombre es $nom \n  Tienes $edad años"; //imprime

}
*/

fun main(){
   println(obtenDatos("Carlos", 21)); //la función main imprime la función obtenDatos, y le pasamos dos parametros

}

fun obtenDatos(nom:String, edad:Int): String{
    return "Tu nombre es : $nom \n Tienes $edad años;" //retorna la cadena
}

