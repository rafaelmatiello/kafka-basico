## 1) iniciar o kafka

Iniciar 

```
docker-compose up -d 
```
Parar

```
docker-compose down
```

## 2) kafdrop - interface visual

```
http://localhost:19000
```

## 3) Enviar uma mensagem

```
post http://localhost:8080/producer
{
    "message": "Mensagem 1"
}
```