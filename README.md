# Mutant Analyzer
![Build](https://github.com/FredeHG/mutant/workflows/build/badge.svg)
[![codecov](https://codecov.io/gh/FredeHG/mutant/branch/master/graph/badge.svg)](https://codecov.io/gh/FredeHG/mutant)

Servicio Rest para analizar si un ADN es de un mutante o no.

---

## Consideraciones

Solo son validas las letras [A, C, G, T]

Se toma como 2 cadenas de 4 letras consecutivas si una secuencia tiene AAAACCCC o AAAAAAAA

## Guia
Este servicio cuenta con 2 Endpoints:

Uno para saber si un dna es de un mutante y otro para obtener las estadisticas de los dna consuntados

Para averiguar si un DNA es de un mutante hay que enviar el DNA en formato Array de String

Para mas información visitar la documentación en [Swagger](http://mutantmeli-env.eba-vmskaduw.us-east-2.elasticbeanstalk.com/swagger-ui.html)


## Arquitectura

El servicio esta hosteado en AWS "elastic beanstalk" esta conectado con una base de datos mongodb atlas.
El proyecto cuenta con GitHub Actions para correr el set de test en los pedidos de Pull Request
y una vez en la rama main el servicio de pipelines de AWS toma el codigo para hacer el deploy en produccion automaticamente. 



