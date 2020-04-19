# ws-rest
Webservice REST - Serviço de gerenciamento de livros

Exemplos de operações:

``` terminal
curl -X GET -H "Accept: application/xml" http://localhost:8080/livros/1
```

``` terminal
curl -X POST -H "Content-type: application/xml" -H "Accept: application/xml" -d "<livro><titulo>Novo livro</titulo><assunto>Novo livro</assunto><autor>Novo livro</autor></livro>" http://localhost:8080/livros
```

``` terminal
curl -X PUT -H "Content-type: application/xml" -H "Accept: application/xml" -d "<livro><titulo>Titulo atualizado</titulo><assunto>Assunto atualizado</assunto><autor>Autor atualizado</autor></livro>" http://localhost:8080/livros/1
```

``` terminal
curl -X DELETE http://localhost:8080/livros/1
```
