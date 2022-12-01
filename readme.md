
Requisitos tener instalado docker

Ejecutar este comando en la terminal

* docker run --name some-postgres -p 5432:5432 -e POSTGRES_PASSWORD=password -d postgres


primero ejecutar

* resources/create_database.sql


luego en la terminal dentro del folder del proyecto ejecutar.
* mvn install

y luego se podrá ejecutar