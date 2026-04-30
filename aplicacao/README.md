## How to Run 

> Compilar o projeto
```
> ./mvnw package -DskipTests
```
> Buildar o container baixando e buildando as imagens
> Subir para testar

```
> docker-compose build
> docker-compose up -d
```
> ou para simplificar
```
> docker-compose up --build
```
## Desafio proposto
- /POST
- CREATED
- Location sendo a URI do item criado

- /GET 
- OK
- LIST Items

- /PUT
- No content 

- /DELETE
- No content

- Necessario implementar pelo menos uma verificação de segurança
