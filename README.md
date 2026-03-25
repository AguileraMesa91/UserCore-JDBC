# UserCore-JDBC

[English](#english) | [Español](#español)

---

## English

**UserCore-JDBC** is a backend project developed in pure Java using JDBC, focused on clean data access
and execution time logging for analysis purposes.

### Project Goals
- Manage user data through JDBC
- Log execution times of operations
- Apply clean architecture principles
- Serve as a base backend project for data-oriented roles

### Technologies
- Java
- JDBC
- Maven
- Relational Database MySQL

### Project Structure
```
src/main/java/io/github/aguileramesa91/usercore
├── config    # Database configuration
├── dao       # Data Access Object layer
├── model     # Domain entities
├── service   # Business logic layer
└── util      # Time logging and utilities
```

### Key Features
- **Data Validation:** Centralized logic in the Service layer to ensure data integrity (email formats, age constraints).
- **Dual Logging:** Performance metrics (execution time) and error tracking are recorded both in the console and a persistent `.txt` file.
- **DAO Pattern:** Clear separation between business logic and database access.

### Setup
1. **Database:** Execute the SQL script located in `src/main/resources/sql/script.sql` to create the schema and tables.
2. **Configuration:** Update your credentials (host, user, password) in `DatabaseConfig.java`.
3. **Execution:** Run the `Main.java` class to access the interactive control panel.

### Prerequisites
- Java JDK 21 or higher.
- Maven 3.6+.
- MySQL Server.

# Español

**UserCore-JDBC** es un proyecto de backend desarrollado en Java puro utilizando JDBC, enfocado en un acceso a datos limpio y en el registro de tiempos de ejecución para fines de análisis.

### Objetivos del Proyecto
- Gestionar datos de usuarios a través de JDBC.
- Registrar los tiempos de ejecución de las operaciones.
- Aplicar principios de arquitectura limpia.
- Servir como proyecto base de backend para roles orientados a datos.

### Tecnologías
- Java
- JDBC
- Maven
- Base de datos relacional MySQL

### Estructura del Proyecto
```
src/main/java/io/github/aguileramesa91/usercore
├── config    # Configuración de conexión
├── dao       # Lógica de acceso a datos
├── model     # Entidades de dominio
├── service   # Lógica de negocio
└── util      # Utilidades y registro de tiempos
```

### Características Clave
- **Validación de Datos:** Lógica centralizada en la capa de Servicio para asegurar la integridad de los datos (formatos de email, restricciones de edad).
- **Registro Dual (Logging):** Las métricas de rendimiento y el rastreo de errores se registran tanto en consola como en un archivo persistente `.txt`.
- **Patrón DAO:** Separación clara entre la lógica de negocio y el acceso a la base de datos.

### Configuración
1. **Base de Datos:** Ejecuta el script SQL ubicado en `src/main/resources/sql/script.sql` para crear el esquema y las tablas.
2. **Configuración:** Actualiza tus credenciales (host, usuario, contraseña) en `DatabaseConfig.java`.
3. **Ejecución:** Inicia la clase `Main.java` para acceder al panel de control interactivo.

### Requisitos
- Java JDK 21 o superior.
- Maven 3.6+.
- Servidor MySQL.

## 📊 Execution Log Examples / Ejemplos de Logs de Ejecución

```text
[2026-03-24 10:15:30] OPERATION: GetAllUsers | DURATION: 12 ms
[2026-03-24 10:16:05] ERROR in AddUser | MESSAGE: Validation Error: invalid email format.
[2026-03-24 10:18:12] OPERATION: FindUserByID | DURATION: 5 ms
[2026-03-24 10:20:45] ERROR in UpdateUser | MESSAGE: Validation Error: User with ID 99 not found.
```
