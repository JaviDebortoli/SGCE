# 📘 SGCE - Sistema de Gestión de Cursos y Estudiantes

SGCE (*Sistema de Gestión de Cursos y Estudiantes*) es una aplicación web desarrollada con **Spring Boot** cuyo objetivo principal es administrar estudiantes, cursos e inscripciones dentro de un entorno académico.

Este proyecto fue realizado con fines **educativos**, como práctica integral para aprender el ecosistema de Spring y el desarrollo de aplicaciones web con arquitectura en capas.

---

## 🎯 Objetivo del proyecto

El propósito de SGCE es servir como un proyecto de aprendizaje para:

- Comprender el framework **Spring Boot**
- Aplicar el patrón de arquitectura en capas
- Utilizar **Spring MVC** con vistas Thymeleaf
- Implementar persistencia con **Spring Data JPA + Hibernate**
- Integrar una base de datos relacional con **MySQL**
- Trabajar con DTOs y separación de responsabilidades
- Practicar buenas prácticas de diseño y estructura en proyectos Java

---

## 🧩 Funcionalidades principales

El sistema permite:

### 👨‍🎓 Gestión de Estudiantes
- Registrar estudiantes
- Listar estudiantes disponibles

### 📚 Gestión de Cursos
- Registrar cursos
- Listar cursos existentes

### 🧾 Gestión de Inscripciones (Enrollments)
- Inscribir estudiantes en cursos mediante IDs
- Visualizar inscripciones realizadas
- Manejar estado de inscripción (ACTIVE / CANCELLED)

---

## 🏗️ Arquitectura del sistema

El proyecto sigue una arquitectura clásica en capas:

- **Domain**: entidades JPA (`Student`, `Course`, `Enrollment`)
- **Repository**: acceso a datos con Spring Data JPA
- **Service**: lógica de negocio y orquestación
- **DTO**: objetos de transferencia entre capas
- **Controller**: controladores MVC que gestionan rutas y vistas
- **Templates**: vistas HTML renderizadas con Thymeleaf

---

## 🗃️ Modelo de dominio

El sistema está basado en tres entidades principales:

- **Student**: representa un estudiante
- **Course**: representa un curso
- **Enrollment**: representa una inscripción (relación entre Student y Course)

Enrollment actúa como entidad intermedia, permitiendo almacenar atributos adicionales como:

- fecha de inscripción
- estado de inscripción

---

## 🖥️ Interfaz Web

La aplicación utiliza **Thymeleaf** como motor de templates para generar vistas dinámicas.

Incluye:

- Home principal para navegación
- Vistas separadas para Students, Courses y Enrollments
- Fragmentos reutilizables (`head`)
- Estilos modernos con TailwindCSS

---

## ⚙️ Tecnologías utilizadas

- **Java 25**
- **Spring Boot**
- **Spring MVC**
- **Spring Data JPA**
- **Hibernate**
- **MySQL**
- **Thymeleaf**
- **Lombok**
- **TailwindCSS (CDN)**
- **Maven**

---

## 🚀 Ejecución del proyecto

### Clonar el repositorio
```bash
git clone https://github.com/JaviDebortoli/SGCE.git
cd SGCE
```

### Crear una base de datos:
CREATE DATABASE sgce_db;

### Editar el archivo application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/sgce_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.open-in-view=false

### Ejecutar la aplicación
mvn spring-boot:run

### Accede desde el navegador
http://localhost:8080/

✍️ Autor

Proyecto desarrollado por Javier M. Debórtoli como práctica de aprendizaje en Spring Boot y desarrollo backend en Java.
