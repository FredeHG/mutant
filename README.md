# Mutant Analyzer
![Build](https://github.com/FredeHG/mutant/workflows/build/badge.svg)

Servicio Rest para analizar si un adn en especifico es de un mutante o no.

---

## Guia
Este servicio cuenta con 2 Endpoints:

Uno para saber si un dna es de un mutante y otro para obtener las estadisticas de los dna consuntados

Para mas información visitar la documentación en [Swagger](http://mutantmeli-env.eba-vmskaduw.us-east-2.elasticbeanstalk.com/swagger-ui.html)

## Arquitectura

El servicio esta hosteado en AWS "elastic beanstalk" esta conectado con una base de datos mongodb atlas.
El proyecto cuenta con GitHub Actions para correr el set de test en los pedidos de Pull Request
y una vez en la rama main el servicio de pipelines de AWS toma el codigo para hacer el deploy en produccion automaticamente. 



