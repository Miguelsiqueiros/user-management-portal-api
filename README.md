# Users API

API written in java using the spring framework that creates, deletes, updates and gets users

## Run project in docker container

```bash
docker build -t users-api .
docker run --rm -p 8080:8080 -it users-api
```

## API URL

https://user-portal-management-api.herokuapp.com/api/

## Healthcheck URL

https://user-portal-management-api.herokuapp.com/actuator/health

## Swagger page

https://user-portal-management-api.herokuapp.com/swagger-ui.html
