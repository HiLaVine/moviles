fun main() {
    val arr1 = arrayOf("Hola", "Mundo", "Kotlin", "Array", "Example")
    val arr2 = arrayOf("test", "platano", "megatron", "array", "hola")

    // Convertir a mayúsculas e imprimir arr1
    val upperCaseArr1 = arr1.map { it.uppercase() }
    println("Arreglo 1 en mayúsculas: $upperCaseArr1")

    // Convertir a minúsculas e imprimir arr2
    val lowerCaseArr2 = arr2.map { it.lowercase() }
    println("Arreglo 2 en minúsculas: $lowerCaseArr2")

    // Verificar si las cadenas de un arreglo están en el otro
    upperCaseArr1.forEach { str1 ->
        if (lowerCaseArr2.any { str2 -> str1.lowercase() == str2 }) {
            println("La cadena $str1 del arreglo 1 está en el arreglo 2")
        }
    }
    lowerCaseArr2.forEach { str2 ->
        if (upperCaseArr1.any { str1 -> str2 == str1.lowercase() }) {
            println("La cadena $str2 del arreglo 2 está en el arreglo 1")
        }
    }

    // Contar y desplegar el número de vocales en cada cadena
    fun countVowels(word: String): Map<Char, Int> {
        val vowels = listOf('a', 'e', 'i', 'o', 'u')
        return word.lowercase().filter { it in vowels }.groupingBy { it }.eachCount()
    }

    arr1.forEach { word ->
        println("Vocales en '$word': ${countVowels(word)}")
    }
    arr2.forEach { word ->
        println("Vocales en '$word': ${countVowels(word)}")
    }
}
