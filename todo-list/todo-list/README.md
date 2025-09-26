# Projet-Spring-boot todo-list

# 📌 TodoApp - Gestion de tâches (Spring Boot + Thymeleaf + Swagger)

## 🚀 Description
Application web de gestion de tâches (**To-Do List**) développée avec :
- **Spring Boot**
- **Spring Security** (authentification `admin/admin123`)
- **Thymeleaf + TailwindCSS** (interface moderne)
- **Spring Data JPA + PostgreSQL**
- **Swagger / OpenAPI** pour la documentation interactive

---

## 🔑 Authentification
- URL de login : [http://localhost:8080/login](http://localhost:8080/login)
- Identifiants par défaut :
  - **Utilisateur** : `admin`
  - **Mot de passe** : `admin123`

---

## 🖥️ Interface Web
- **Page d’accueil** : `/tasks`
- **Créer une nouvelle tâche** : `/tasks/new`
- **Modifier une tâche** : `/tasks/{id}/edit`
- **Supprimer une tâche** : bouton corbeille sur la liste

Chaque tâche possède :
- **Titre**
- **Description**
- **Statut** : `A_FAIRE`, `EN_COURS`, `TERMINE`

---

## 📖 API REST (Swagger UI)
Accédez à la documentation interactive :
👉 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

### Endpoints principaux
- `GET /api/tasks` → Liste toutes les tâches
- `POST /api/tasks` → Créer une
