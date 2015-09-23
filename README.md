# jersey-restful-server
RESTful Web Service Server com Jersey.

Exemplos de operações:

``` terminal
curl -X GET -H "Accept: application/json" http://localhost:8080/jersey-restful-server/modelos
```

``` terminal
curl -X POST -H "Content-type: application/json" -H "Accept: application/json" -d '[{"id": "5", "atributo": "Atributo 5"}]' http://localhost:8080/jersey-restful-server/modelos
```

``` terminal
curl -X PUT -H "Content-type: application/json" -H "Accept: application/json" -d '{"id": "1", "atributo": "Atributo 1000"}' http://localhost:8080/jersey-restful-server/modelos/1
```

``` terminal
curl -X DELETE http://localhost:8080/jersey-restful-server/modelos
```
