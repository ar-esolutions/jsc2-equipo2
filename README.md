# Esolutions
## Java Starters Challenge - "_Have a_ nice day Hotel"
**_Have a_ nice day Hotel** es un prestigioso hotel que acaba de inaugurarse.

Lanzó una campaña publicitaria en la que se jacta de tener una capacidad _infinita_ para albergar húespedes.  
En la planta baja se encuentra el lobby del hotel, junto a un restaurante dirigido por un chef con 4 estrellas Michelin.

### Requerimiento 1
La apertura del hotel fue un éxito, y en un sólo día, el hotel recibió a 50.000 húespedes.

Para mantener un orden, el conserje confeccionó un complejo sistema de asignación de habitaciones. Decidió que cada húesped debe alojarse en la primer habitación libre del piso más bajo que cumpla alguna de estas reglas:

1) El 1er huésped debe alojarse en la habitación 1 del piso 1.
2) La sumatoria del número del último húesped alojado en el piso y el número del nuevo húesped es un cuadrado perfecto, es decir, su raíz cuadrada da como resultado un número entero (si el nuevo húesped es el número 5, y el alojado en la última habitación de ese piso, es el número 4, entonces n+m(9) es un cuadrado perfecto).
3) El piso está vacío.

> Sólo puede haber un huésped por habitación.

 > 1 <= piso <= 350  
 > 1 <= habitación <= 350
 
 > En caso de que la habitación consultada no esté ocupada, el sistema debe retornar guest=_null_.

El conserje debe poder buscar en su sistema el número de húesped dado un _número de piso_ y _número de habitación_.

#### Ejemplo
* El primer húesped se aloja en la habitación 1 del 1er piso.
* El huésped número 2 no puede alojarse en la habitación 2 del piso 1 ya que  1 + 2 = 3 no es un cuadrado perfecto, por lo que se le asigna la habitación 1 en el piso 2, que está vacío.
* El húesped número 3, se aloja en la habitación 2 del piso 1 ya que 1 + 3 = 4 es un cuadrado perfecto.
* El huésped número 4, no puede alojarse en el piso 1, ya que 3 + 4 = 7, y no es un cuadrado perfecto. Tampoco puede alojarse en el piso 2, ya que 2 + 4 = 6, no es un cuadrado perfecto. En consecuencia, el huésped 4 se aloja en la habitación 1 del piso 3 porque éste está vacío. 

#### Endpoint GET /floors/{floor}/rooms/{room}
##### Response
 ````json
 {
     "guest": 423
 }
 ````
 
### Requerimiento 2
Con el objetivo de aumentar las ventas, el director del hotel, va a lanzar una nueva campaña para que los huéspedes puedan realizar una reserva mediante la página web del hotel.

Para realizar la reserva, el cliente debe seleccionar _la fecha de entrada_, _la de salida_ y _el número_ de habitación.

Según las fechas de entrada y salida y tipo de habitación (_Estandar_ o _Suite_) el director definió los siguientes precios:

| Tipo/Fecha    | Lun-Jue   | Vie-Dom   |
| ---           | ---       | ---       |
| **Estandar**  | $150,99   | $191,99   |
| **Suite**     | $187,99   | $202,99   |

> En caso de que la habitación esté ocupada, la reserva no se podrá realizar.

> No se debe aplicar ningún redondeo al resultado del monto final.

#### Ejemplo
_Entrada_: 03/10/2018  
_Salida_: 19/10/2018  
_Número de piso_: 1  
_Número de habitación_: 5

Como todavía no hay ninguna reserva, sabemos que la habitación 5 del piso 1 esta libre.

Días Lun-Jue: 03/10, 04/10, 08/10, 09/10, 10/10, 11/10, 15/10, 16/10, 17/10, 18/10  
Días Vie-Dom: 05/10, 06/10, 07/10, 12/10, 13/10, 14/10  

```
Lun-Jue: 10d * $150,99 = $1.509,90
Vie-Dom: 6d * $191,99 = $1.151,94
Total: $2661,84
```

#### Endpoint POST /floors/{floor}/rooms/{room}/book
##### Request
````json
{
  "check-in": "2018-10-03",
  "check-out": "2018-10-19"
}
````
##### Response
````json
{
  "booked": true,
  "price": 2661.84
}
````

### Requerimiento 3
El hotel cuenta con un excelente servicio de internet, y para evitar congestiones, cada habitación cuenta con su propia red WiFi.

El técnico del hotel ha desarrollado un ingenioso sistema para definir el nombre de red de cada habitación. Para obtener el nombre correcto, 
a partir de la **concatenación** de las representaciones binarias del número de piso y el numero de habitación, se debe identificar la secuencia más larga de ceros que comienza y termina con un 1.
Así, el nombre de la red se define como **HAND-P-H-C**, dónde:
 * P = Número de piso
 * H = Número de habitación
 * C = La cantidad de ceros en la secuencia más larga obtenida.

> De no haber ninguna secuencia del tipo, el nombre de red se compone como **HAND-P-H**

> Tanto para  el número de piso como el de habitación, se consideran los numeros enteros sin ceros por delante (Ejemplo: Habitacion 01, piso 05 no son valores correctos)

#### Ejemplo 1
Dado el piso **216** y la habitación **5**, obtenemos la combinación binaria **11011000** para el piso y **1001** para la habitación. Luego de concatenar obtenemos **110110001001**.  
Dentro de esta cadena, obtenemos las secuencias **_101_**, **_10001_**, **_1001_**.  
Dado que la secuencia más larga continene 3 ceros, el nombre de red será **_HAND-216-5-3_**.

#### Ejemplo 2
Dado el piso **7** y la habitación **6**, obtenemos la combinación binaria **111** para el piso y **110** para la habitación. Luego de concatenar obtenemos **111110**.  
Dentro de la misma, no existen secuencias válidas, por lo que el nombre de red será **_HAND-7-6_**.

Se solicita desarrollar la lógica asociada a la definición del nombre de red.

#### Endpoint GET /floors/{floor}/rooms/{room}/wifi/ssid
##### Response
````json
{
  "ssid": "HAND-216-5"
}
````

### Requerimiento 4
Tal como lo hizo para el nombre de red, el técnico también definió un sistema para el armado de la contraseña.
Partiendo de la letra **J**, la secuencia que describe la complejidad de la contraseña puede generarse aplicando N veces el siguiente conjunto de reglas en forma simultanea:
* Reemplazar cada ocurrencia de la letra **J** por **JA**
* Reemplazar cada ocurrencia de la letra **A** por **VA**
* Reemplazar cada ocurrencia de la letra **V** por **VJ**

**N** se obtiene de la sumatoria del número de piso y habitación.

Una vez obtenida la secuencia, la contraseña se compondrá como "PASS-P-H-C" dónde:
* P = Número de piso
* H = Número de habitación
* C = La cantidad de veces que la palabra "JAVA" aparece sobre la secuencia.
 
> Tanto para  el número de piso como de habitación, se concidera los numeros enteros sin ceros por delante (Ejemplo: Habitacion 01, piso 05 no son valores correctos)
 
Se solicita desarrollar la lógica asociada a la definición de la contraseña de red.

#### Ejemplo 1
Dado el piso **1** y la habitación **2**, obtenemos **N=3**.
La secuencia entonces será:

| Iteración | Salida |
| :---: | :---------: |
| 0 | J |
| 1 | JA |
| 2 | JAVA |
| 3 | **JAVA**VJVA |

Dado que hay una sola ocurrencia de la palabra JAVA, la contraseña de red será **_PASS-1-2-1_**.
 
 #### Ejemplo 2
Dado el piso **4** y la habitación **2**, obtenemos **N=6**.
 La secuencia entonces será:
    
| Iteración | Salida |
| :---: | :---------: |
| 0 | J |
| 1 | JA |
| 2 | JAVA |
| 3 | JAVAVJVA |
| 4 | JAVAVJVAVJJAVJVA |
| 5 | JAVAVJVAVJJAVJVAVJJAJAVAVJJAVJVA |
| 6 | **JAVA**VJVAVJJAVJVAVJJA**JAVA**VJJAVJVAVJJA**JAVAJAVA**VJVAVJJA**JAVA**VJJAVJVA |

Dado que existen 5 ocurrencias de la palabra JAVA, la contraseña de red será **_PASS-4-2-5_**.
  
##### Endpoint _GET_ /floors/{floor}/rooms/{room}/wifi/password
 ````json
{
  "password": "PASS-4-2-5"
}
 ````

### Requerimiento 5
Como parte de una estrategia publicitaria, el hotel planea sacar una promoción en la cual bonifique en la primer reserva, el 50% de su tarifa a los huespedes cuyo apellido se encuentre repetido en la lista de huéspedes del hotel.

Se solicita identificar todos los apellidos repetidos, ordenados alfabéticamente.

#### Ejemplo 1
Dado el siguiente listado de huéspedes:

1. **Alvarez**, Joseph
2. **Paredes**, Jorge
3. Romario, Luis
4. **Alvarez** , Marcos
5. Michellin, Agustin
6. **Alvarez**, Nicolas
7. **Paredes**, Nicolas

_Huespedes repetidos:_ ["Alvarez", "Paredes"]

#### Endpoint GET /guests/last-name/repeated
````json
{
  "last-names": ["Alvarez", "Paredes"]
}
````

