//Funciones

/*fun main() {
	obtenDatos(); // En la funcion main llamamos a la funcion obtenDatos().
}
fun obtenDatos(){						//La función obtenDatos() solo imprime los datos, y no hace nada mas.
    print("Tu nombre es:Emmanuel");
    print("\nTienes 23 años");
}
*/

fun main(){
    val cad = obtenDatos(); // en la funcion main a la variable cad le asignamos el String que retorna la funcion obtenDatos y lo imprime
    print(cad);
}
fun obtenDatos(): String{ //La funcion obtenDatos, lo que hace es a dos variables asignar, el nombre y la edad y luego retorna un String con estos datos.
    val nombre = "Emmanuel"
    val edad = 23;
    return "Tu nombre es $nombre \n tienes $edad años"
}