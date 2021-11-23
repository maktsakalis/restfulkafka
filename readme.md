-- start the container - run postgres image
sudo docker run --name postgres-1 -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres:latest

-- open an interactive bash in running postgres container
sudo docker exec -it postgres-1 bash

-- connect to psql
psql -U postgres

-- create database
create database restfulkafka;