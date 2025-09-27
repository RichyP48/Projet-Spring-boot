# Blog Management - Projet Spring Boot Moderne

Ce projet est une application de gestion de blog "ultra-moderne" développée avec Java Spring Boot. Il inclut un backend sécurisé, une API REST documentée avec Swagger, et un frontend dynamique et réactif utilisant Thymeleaf, TailwindCSS et Alpine.js.

## Technologies

- **Backend**: Java 17, Spring Boot 3.2.5, Spring Data JPA, Spring Security
- **Base de données**: PostgreSQL
- **Frontend**: Thymeleaf, TailwindCSS, Alpine.js
- **API Docs**: Springdoc OpenAPI (Swagger UI)
- **Build**: Maven

## Prérequis

- JDK 17 ou supérieur
- Maven 3.6+
- PostgreSQL

## 1. Configuration de la Base de Données

1.  Assurez-vous que PostgreSQL est installé et en cours d'exécution.
2.  Créez une base de données pour le projet.
    ```sql
    CREATE DATABASE blogdb;
    ```
3.  Mettez à jour les informations de connexion dans `src/main/resources/application.properties` avec vos propres identifiants.
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/blogdb
    spring.datasource.username=VOTRE_USER
    spring.datasource.password=VOTRE_MOT_DE_PASSE
    ```

## 2. Lancement du Projet

Ouvrez un terminal à la racine du projet et exécutez la commande Maven suivante :

```bash
# Sur Linux/macOS
./mvnw spring-boot:run

# Sur Windows
mvnw.cmd spring-boot:run