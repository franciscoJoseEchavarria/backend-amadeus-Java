# Reto Amadeus Backend
Este proyecto es una aplicación backend desarrollada con Spring Boot que proporciona varios endpoints para gestionar usuarios y consultas de usuarios. Tener en cuenta que este proyecto funciona con el siguiente frontend que fue diseñado en el framework ANGULAR, se deja el siguiente enlace para su visualizacion: https://github.com/franciscoJoseEchavarria/Front-amadeus-Angular

## Descarga el proyecto.
Crea una carpeta donde quieras guardar el proyecto. Abre el CMD y digita cd "Ruta de la carpeta", una vez lo tengas el cmd en la ruta del proyecto, utiliza el siguiente comando git clone https://github.com/franciscoJoseEchavarria/backend-amadeus-Java.git; abajo se deja la descripcion para el copy and page: 

```
cd "ruta de la carpeta"
```
```
git clone https://github.com/franciscoJoseEchavarria/backend-amadeus-Java.git
```
## Requisitos

- Java 17
- Gradle
- PostgreSQL

## Configuración de la Base de Datos

Para configurar la conexión a la base de datos, sigue estos pasos:

1. Crea una base de datos en PostgreSQL.
2. Configura las credenciales de la base de datos en el archivo `application.properties`.

### application.properties

para correr la aplicacion tenga en cuenta la configuracion de la BD, se debe colocar el nombre de la BD, el usuario y la contraseña para postgres se integre. Este proyecto esta corriendo en el puerto 8081

```
spring.application.name=reto3-back-amadeus

# Configuracion de la base de datos
# Colocar el nombre de la base de datos
spring.datasource.url=jdbc:postgresql://127.0.0.1:5432/reto-back-3
# Nombre de usuario para la base de datos
spring.datasource.username=postgres
# Contrasena para la base de datos
spring.datasource.password=nueva123

# Configuracion de Hibernate
# Dialecto de Hibernate para PostgreSQL
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
# Muestra las consultas SQL en la consola
spring.jpa.show-sql=true
# Configuracion de Hibernate para crear y eliminar las tablas en cada inicio
spring.jpa.hibernate.ddl-auto=create-drop

# Configuracion del servidor
# Puerto en el que la aplicacion se ejecutara
server.port=8081
```

### Ejecucion del proyecto

si estas en VSC, puedes arrancar el proyecto con este comando en la terminal. ten en cuenta que VSC al ejecutarlo en la clase "Reto3BackAmadeusApplication" crea aplicaciones adicionales, por lo es mejor que lo ejecutes con el comando que te dejo abajo. Solo debe pararte en la raíz del proyecto que en el caso mio es: **<u>"C:\Users\ROG STRIX\Desktop\Reto-back-francisco\backend-amadeus-Java/BACKEND-AMADEUS.JAVA"</u>** y ejecutar:
```
./gradlew bootRun
```
Si se encuentra directamente en Intelli J, puede correlo dirigiendote a la clase: "Reto3BackAmadeusApplication" y darle en Run Code o en llegado caso que no te corra, puedes ejecutar el siguiente comando en la terminal
```
./gradlew bootRun --stacktrace

```

### Endpoints

a continuacion se deja los endpoints que se utilizaron para la creacion de este proyecto, estos pueden directamente ser vistos en lo controladores. tener en cuenta que las variable con {} debe contener el nombre, correo o id de las busqueda

Users:
```
http://localhost:8081/api/user/list
http://localhost:8081/api/user/create
http://localhost:8081/api/user/getUserByName/{name}
http://localhost:8081/api/user/getUserByEmail/{email}
http://localhost:8081/api/user/getNameAndEmail/{name}/{email}
http://localhost:8081/api/user/getUserById/{id}
http://localhost:8081/api/user/delete/{id}
http://localhost:8081/api/user/createMultipleUsers
```

UsersQuery:
```
http://localhost:8081/api/userQueryController/list
http://localhost:8081/api/userQueryController/create
```

Destinos:
```
http://localhost:8081/api/destinos/create
http://localhost:8081/api/destinos/encontrar/{id}
```

DetallesDestinos:
```
http://localhost:8081/api/detallesdestinos/list
http://localhost:8081/api/detallesdestinos/search/{id}
http://localhost:8081/api/detallesdestinos/update/{id}
http://localhost:8081/api/detallesdestinos/delete/{id}
http://localhost:8081/api/detallesdestinos/deleteAll
```

# ENGLISH

# Reto Amadeus Backend
This project is a backend application developed with Spring Boot that provides various endpoints for managing users and user queries. Keep in mind that this project works with the following frontend, which was designed using the Angular framework. You can view it at the following link:
https://github.com/franciscoJoseEchavarria/Front-amadeus-Angular

## Download the Project
Create a folder where you want to store the project. Open the CMD and type:
```
cd "path to the folder"
```

## Requirements
- Java 17
- Gradle
- PostgreSQL

## Database Configuration

To configure the database connection, follow these steps:
1. Create a database in PostgreSQL.
2. Configure the database credentials in the `application.properties` file.

### application.properties
To run the application, you must configure the database. You must enter the database name, username, and password for PostgreSQL to integrate. This project is running on port 8081.

```
spring.application.name=reto3-back-amadeus

# Configuracion de la base de datos
# Colocar el nombre de la base de datos
spring.datasource.url=jdbc:postgresql://127.0.0.1:5432/reto-back-3
# Nombre de usuario para la base de datos
spring.datasource.username=postgres
# Contrasena para la base de datos
spring.datasource.password=nueva123

# Configuracion de Hibernate
# Dialecto de Hibernate para PostgreSQL
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
# Muestra las consultas SQL en la consola
spring.jpa.show-sql=true
# Configuracion de Hibernate para crear y eliminar las tablas en cada inicio
spring.jpa.hibernate.ddl-auto=create-drop

# Configuracion del servidor
# Puerto en el que la aplicacion se ejecutara
server.port=8081
```

### Running the Project
If you are using VSC, you can start the project with the following command in the terminal. Keep in mind that VSC, when running it in the class "Reto3BackAmadeusApplication," creates additional applications. Therefore, it is better to run it with the command below. You must be in the root of the project, which in my case is: **<u>"C:\Users\ROG STRIX\Desktop\Reto-back-francisco\backend-amadeus-Java/BACKEND-AMADEUS.JAVA"</u>** and run:
```
./gradlew bootRun
``` 
If you are using IntelliJ, you can run it by going to the class: "Reto3BackAmadeusApplication" and clicking on Run Code. If it does not run, you can run the following command in the terminal:
```
./gradlew bootRun --stacktrace
```
### Endpoints
Below are the endpoints used to create this project. These can be viewed directly in the controllers. Keep in mind that the variables with {} must contain the name, email, or id of the search.
Users:
```
http://localhost:8081/api/user/list
http://localhost:8081/api/user/create
http://localhost:8081/api/user/getUserByName/{name}
http://localhost:8081/api/user/getUserByEmail/{email}
http://localhost:8081/api/user/getNameAndEmail/{name}/{email}
http://localhost:8081/api/user/getUserById/{id}
http://localhost:8081/api/user/delete/{id}
http://localhost:8081/api/user/createMultipleUsers
```

UsersQuery:
```
http://localhost:8081/api/userQueryController/list
http://localhost:8081/api/userQueryController/create
```

Destinos:
```
http://localhost:8081/api/destinos/create
http://localhost:8081/api/destinos/encontrar/{id}
```

DetallesDestinos:
```
http://localhost:8081/api/detallesdestinos/list
http://localhost:8081/api/detallesdestinos/search/{id}
http://localhost:8081/api/detallesdestinos/update/{id}
http://localhost:8081/api/detallesdestinos/delete/{id}
http://localhost:8081/api/detallesdestinos/deleteAll
```