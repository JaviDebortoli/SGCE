# 📘 SGCE - Sistema de Gestión de Cursos y Estudiantes

SGCE (*Sistema de Gestión de Cursos y Estudiantes*) es una aplicación web desarrollada con **Spring Boot** cuyo objetivo principal es administrar estudiantes, cursos e inscripciones dentro de un entorno académico.

Este proyecto fue realizado con fines **educativos**, como práctica integral para aprender el ecosistema de Spring y el desarrollo de aplicaciones web con arquitectura en capas.

---

## 🎯 Objetivo del proyecto

El propósito de SGCE es servir como un proyecto de aprendizaje para:

- Aprender Spring Boot desde cero
- Aplicar arquitectura en capas
- Comprender el uso correcto de DTOs
- Trabajar con JPA / Hibernate
- Implementar Thymeleaf para vistas dinámicas
- Aplicar borrado lógico, auditoría y validaciones
- Simular un sistema real de gestión académica

---

## 🧩 Funcionalidades principales

El sistema permite:

### 👨‍🎓 Gestión de Estudiantes
- Crear estudiantes
- Listar solo estudiantes activos
- Editar nombre y email
- Mostrar DNI como campo de solo lectura
- Borrado lógico (activar / desactivar)
- Validaciones con DTOs
- Confirmaciones visuales antes de guardar cambios

### 📚 Gestión de Cursos
- Crear cursos
- Listar cursos activos
- Eliminar cursos (borrado lógico)
- Código de curso único
- Confirmación visual antes de eliminar

### 🧾 Gestión de Inscripciones (Enrollments)
- Crear inscripciones asociando estudiante y curso
- Uso de fileNumber como identificador de inscripción
- Estados de inscripción: ACTIVE/FINISHED/CANCELLED
- Visualización de estado con badges de colores dinámicos
- Listado de enrollments activos
- Recuperación de los últimos enrollments modificados
- Auditoría automática (createdAt, updatedAt)

---

## 🗃️ Base de Datos
- MySQL
- Claves primarias autogeneradas
- Constraints de unicidad (email, dni, code, file_number)
- Relaciones:
  - Student ↔ Enrollment
  -  Course ↔ Enrollment
- Borrado lógico sin eliminar registros físicos

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

## ⚙️ Tecnologías utilizadas

- **Java 25**
- **Spring Boot**
- **Spring MVC**
- **Spring Data JPA**
- **Spring Transaction Management**
- **JPA Auditing**
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
