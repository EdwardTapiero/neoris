# Neoris

Crear, Editar y eliminar movimientos, clientes y cuentras, adicionalmente obtener resportes por feechas

## ¿Cómo ejecutar?

Clona el repositorio o descarga el repositorio en formato ZIP

**local**

  1. Ingresa a la ruta `cd neoris` desde la consola
  2. Ejecuta el comando `mvn clean install`
  3. Ejecuta el comando `mvn spring-boot:run`
  4. Se ejecutará por defecto en [localhost:8080]()

**docker**

  1. Ingresa a la ruta `cd neoris` desde la consola
  2. Ejecuta el comando `mvn clean package`
  3. Ejecuta el comando `docker build -t neoris .`
  4. Ejecuta el comando `docker run -p 8080:8080 neoris`
  5. Se ejecutará por defecto en [localhost:8080]()
