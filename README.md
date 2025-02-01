# APIBlog
Prueba APIBlogs para Banco Bisa 
# Estrategia
La solución implementada utiliza un conjunto de tecnologías y frameworks modernos que siguen las mejores prácticas de desarrollo de software. Spring Boot y Spring Data JPA proporcionaron una base sólida para construir el microservicio. El manejo de excepciones globales y la serialización/deserialización con Jackson aseguraron una API RESTful robusta y fácil de usar. Finalmente, los principios SOLID guiaron el diseño del código para garantizar que sea mantenible, escalable y de alta calidad.

# Tecnología y frameworks
Java (openjdk 21.0.5), intellij IDEA 2024.3.2.2

1. Spring Boot
Descripción: Spring Boot es un framework de desarrollo basado en Spring que simplifica la creación de aplicaciones Java, especialmente microservicios.
Proporcionó una configuración automática y un servidor embebido (Tomcat), lo que facilitó la puesta en marcha del proyecto.

2. Spring Data JPA
Descripción: Spring Data JPA es una capa de abstracción sobre JPA (Java Persistence API) que simplifica el acceso a bases de datos relacionales.
Proporcionó repositorios (Repository) para realizar operaciones CRUD sin necesidad de escribir consultas SQL manuales.

3. Bean Validation (Jakarta Validation)
Descripción: Bean Validation es una especificación para validar datos en aplicaciones Java.
Las validaciones se integraron automáticamente con Spring Boot, lo que permitió devolver errores claros al cliente.

4. Lombok
Descripción: Lombok es una biblioteca que reduce el código boilerplate en Java mediante anotaciones.
Se utilizó para generar automáticamente getters, setters, constructores y métodos como toString, equals y hashCode en las entidades.

5. H2 Database
Descripción: H2 es una base de datos en memoria ligera y rápida, ideal para pruebas y desarrollo.
Se utilizó como base de datos embebida durante el desarrollo y las pruebas.
Permitió probar la persistencia de datos sin necesidad de configurar una base de datos externa.

6. Spring MVC (Controladores REST)
Descripción: Spring MVC es un framework para construir aplicaciones web y APIs RESTful.

7. Manejo de Excepciones Globales
Descripción: Spring Boot permite manejar excepciones de manera global mediante @ControllerAdvice.
Se implementó un manejador de excepciones global (GlobalExceptionHandler) para capturar errores de validación y devolver respuestas claras en formato JSON.

11. Principios SOLID
Descripción: SOLID es un conjunto de principios de diseño orientado a objetos que promueven la creación de software mantenible y escalable.

# Operaciones:
 Crear Autor

Endpoint: POST /autores

Content-Type: application/json

Request body:
```json
{
    "nombres": "Juan",
    "apPaterno": "Pérez",
    "apMaterno": "Gómez",
    "fechaNacimiento": "1990-01-01",
    "paisResidencia": "México",
    "correo": "juan.perez@example.com"
}
```
 Crear Blog

Endpoint: POST /blogs?autorId={autorId}

Content-Type: application/json

Request body:
```json
{
    "informacion": "Informacion",
    "titulo": "Mi primer blog",
    "tema": "Los blogs",
    "periodicidad": "SEMANAL",
    "aceptaCometar": "SI",
    "contenido": [
        {
            "tipo": "text",
            "valor": "Este es el contenido de mi primer blog."
        },
        {
            "tipo": "image",
            "valor": "https://example.com/image.jpg"
        }
    ]
}
```
 Añadir comentarios a un blog

Endpoint: POST /blogs/{blogId}/comentarios

Content-Type: application/json

Request body:
```json
{
    "nombreCompleto": "Pablo Pachi Conde",
    "paisResidencia": "Bolivia",
    "correo": "pablo.pachi@example.com",
    "comentario": "regular",
    "puntuacion": 5
}
```
 Actualizar blog

Endpoint: PUT /blogs/{blogId}

Content-Type: application/json

Request body:
```json
{
    "informacion": "Informacion",
    "titulo": "Mi primer blog",
    "tema": "Los blogs",
    "periodicidad": "SEMANAL",
    "aceptaCometar": "NO"
}
```
 Consultar blog

Endpoint: GET /blogs

Endpoint: GET /blogs/{blogId}

Endpoint: GET /blogs/{blogId}/comentarios/puntuacion



