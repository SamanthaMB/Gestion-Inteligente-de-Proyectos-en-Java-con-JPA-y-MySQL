# 🚀 Gestión de Recursos Humanos con JPA, MySQL y Eclipse

Aplicación Java para la gestión de empleados, departamentos y perfiles usando JPA para la persistencia con MySQL. Proyecto desarrollado en Eclipse, con conexión a base de datos MySQL ejecutándose en XAMPP.

---

## Descripción

Este proyecto implementa una aplicación para gestionar empleados, departamentos y perfiles. Se utilizan las siguientes tecnologías:

- **Java** con **JPA** para la capa de persistencia.
- **MySQL** como base de datos (conexión via JDBC).
- Base de datos gestionada en XAMPP.
- IDE: **Eclipse**.
- Sin uso de Maven; dependencias manejadas manualmente.
- Entidades con métodos personalizados (ej: cálculo de salario mensual, formato de género, nombre completo).
- DAO con métodos CRUD y consultas específicas (empleados por departamento, género, apellido, perfil, etc).

---

## Funcionalidades principales

- CRUD completo para las entidades Empleado, Departamento y Perfil.
- Consultas personalizadas para filtrar empleados por:
  - Departamento
  - Género
  - Apellido
  - Perfil
- Cálculo de salarios totales y por departamento.
- Clases de prueba para validar cada método y operación.

---

## Estructura del proyecto

- `modelo.entities` — Clases entidad JPA.
- `modelo.dao` — Interfaces y clases DAO para acceso a datos.
- `test.entities` — Tests unitarios de entidades.
- `test.dao` — Tests de operaciones DAO.

---

## Configuración de la Base de Datos

- MySQL corriendo en XAMPP (puerto 3306 por defecto).
- Base de datos y tablas creadas manualmente según el modelo provisto.
- Unidad de persistencia `A30_JPA_MYSQL_XAMPP` configurada para conexión y driver JDBC.
- Sin Maven, las dependencias se agregan manualmente en Eclipse.

---

## Cómo ejecutar

1. Levantar el servidor MySQL desde XAMPP.
2. Crear la base de datos y las tablas (según el script SQL proporcionado).
3. Importar y abrir el proyecto en Eclipse.
4. Ejecutar las clases de prueba en los paquetes `test.dao` o `test.entities` para validar la funcionalidad.

---

## Contacto

**Autor:** Samantha Mohedano Barrena 
**GitHub:** [https://github.com/SamanthaMB/Gestion-Inteligente-de-Proyectos-en-Java-con-JPA-y-MySQL](https://github.com/SamanthaMB/Gestion-Inteligente-de-Proyectos-en-Java-con-JPA-y-MySQL)

