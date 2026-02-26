## How to Run 

> Compilar o projeto
```
> ./mvnw package -DskipTests
```
> Buildar o container baixando e buildando as imagens
```
> docker-compose build
```
> Subir para testar
```
> docker-compose up -d
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
