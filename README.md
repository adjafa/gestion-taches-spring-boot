# Gestion de Tâches - Projet Rattrapage

## Présentation
Application backend de gestion de tâches (To-Do List) développée avec Spring Boot.

## Technologies
- Java 17
- Spring Boot 3.2
- Spring Data JPA
- MySQL
- Maven
- Lombok

## Architecture
Architecture en 3 couches respectant les principes SOLID :

## Patterns utilisés
- **DTO** (Data Transfer Object)
- **Dependency Injection**
- **Repository Pattern**
- **Mapper Pattern**

## Fonctionnalités
- ✅ Créer une tâche
- ✅ Lister toutes les tâches
- ✅ Modifier une tâche
- ✅ Supprimer une tâche
- ✅ Marquer une tâche comme terminée

## API Endpoints

| Méthode | URL | Description |
|---------|-----|-------------|
| POST | `/api/tasks` | Créer une tâche |
| GET | `/api/tasks` | Lister les tâches |
| GET | `/api/tasks/{id}` | Chercher par ID |
| PUT | `/api/tasks/{id}` | Modifier une tâche |
| DELETE | `/api/tasks/{id}` | Supprimer une tâche |
| PATCH | `/api/tasks/{id}/complete` | Marquer terminée |

## Auteur
- **Email** : adjafatou2912@gmail.com
- **Formation** : UFC/UNCHK - Architecture Logicielle
