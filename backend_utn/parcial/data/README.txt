-- LENGTH(text) Devuelve la longitud de una cadena de texto
SELECT j.titulo
FROM Juegos j
WHERE length(j.titulo) < 10

-- UPPER(text): Convierte todo el texto a mayúsculas
SELECT upper(j.titulo)
FROM Juegos j

-- LOWER(text): Convierte todo el texto a minúsculas
SELECT lower(j.titulo)
FROM Juegos j

-- SUBSTR(text, start, length): Devuelve una subcadena de text, comenzando desde la posición start y con una longitud de length
SELECT substr(j.titulo, 1, 10)
FROM Juegos j

-- REPLACE(text, search, replace): Reemplaza todas las ocurrencias de search por replace dentro de texto
SELECT replace(j.titulo, "Mario", "Luigi")
FROM Juegos j



==============================================================================

Guía Rápida de Streams en Java

Los Streams en Java permiten procesar colecciones de datos de manera funcional y fluida.

1. Crear un Stream
Para crear un stream, puedes utilizar los siguientes métodos:

// Usando una lista
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
Stream<Integer> stream = numbers.stream();

// Usando un array
int[] arr = {1, 2, 3, 4, 5};
IntStream stream = Arrays.stream(arr);


2. Operaciones Comunes de Streams
- filter(): Filtra elementos según una condición.
- map(): Transforma cada elemento del Stream.
- forEach(): Realiza una acción sobre cada elemento del Stream.


3. Función map()
La función map() se utiliza para transformar cada elemento de un Stream según una función proporcionada.

Sintaxis:
Stream<T> map(Function<? super T, ? extends R> mapper)

Ejemplo con map():

Supón que tienes una lista de enteros y deseas obtener una lista con el doble de cada número.

import java.util.*;
import java.util.stream.*;

public class MapExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Usando map() para duplicar los valores
        List<Integer> doubledNumbers = numbers.stream()
                                              .map(n -> n * 2)   // Map transforma cada número
                                              .collect(Collectors.toList());

        System.out.println(doubledNumbers);  // Salida: [2, 4, 6, 8, 10]
    }
}

Explicación:
- map(n -> n * 2): Esta operación toma cada número de la lista, lo multiplica por 2 y genera un nuevo Stream con los resultados transformados.


4. Ejemplos de Uso Común de Streams

Filtrar y Transformar:
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

// Filtrar nombres que empiezan con "A" y transformarlos a mayúsculas
List<String> filteredAndMappedNames = names.stream()
                                           .filter(name -> name.startsWith("A"))
                                           .map(String::toUpperCase)
                                           .collect(Collectors.toList());

System.out.println(filteredAndMappedNames);  // Salida: [ALICE]

Sumar Elementos:
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// Obtener la suma de todos los números
int sum = numbers.stream()
                 .mapToInt(Integer::intValue)
                 .sum();

System.out.println(sum);  // Salida: 15

Reducir una Colección:
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// Sumar todos los números usando reduce
int total = numbers.stream()
                   .reduce(0, Integer::sum);

System.out.println(total);  // Salida: 15


Resumen de Métodos Comunes
- map(): Transforma los elementos del Stream.
- filter(): Filtra elementos según una condición.
- collect(): Convierte el Stream de vuelta a una colección.
- forEach(): Aplica una acción a cada elemento del Stream.
- reduce(): Realiza una operación de reducción en los elementos del Stream.


Consejos
- Los Streams no modifican las colecciones originales, sino que crean nuevas colecciones.
- Puedes combinar varias operaciones de Stream de forma fluida, lo que hace que el código sea limpio y legible.

