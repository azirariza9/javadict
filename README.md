# JAVADICT

## WARNING

## **This Project is Work on Progress, Use it on Your Own Discretion !!!**

## DESCRIPTION 

Dictionary backend services made with java spring and postgresql 

## TECH STACK
- Java + Spring Boot + JDBC
- PostgreSQL
- Maven
- Postman (Testing and API Documentation)
- Docker/Podman (Container Management)

## HOW TO RUN
### Requirements
- podman/docker
- java jdk/jre 21

### 1. Clone project
```sh
git clone https://github.com/azirariza9/javadict &&
cd javadict
```
### 2. Start PostgreSQL 
```sh
docker compose -f postgresql.yaml up or podman compose -f postgresql.yaml up
```
### 3. Run Javadict
```sh
./mvnw springboot:run or .\mvnw.exe springboot:run 
```

## API DOCUMENT
- https://documenter.getpostman.com/view/44756624/2sB2x8EWJs

## FEATURES

- use kbbi v dataset to search word definition, support bulk search 
- Edit of local database for history of the word and the like, make your own dictionary
- Get random word of the day
- Save your favorite word/words 

## REFERENCES
- https://github.com/aryakdaniswara/kbbi-dataset-kbbi-v

## LICENSE
- [JAVADICT LICENSE](./LICENSE)
- [KBBI V DATASET LICENSE](./kbbiv-dataset/README.md)

