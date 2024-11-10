#language:pt
@categoria
Funcionalidade: Consulta categoria
  Testes de Api de consulta de categoria de filmes

  Cenario: Realizar Consulta Categoria com Sucesso
    Dado que tenha realizado o login com dados validos
    E que tenha um payload valido da API de categoria
    Quando realizo uma requisicao do tipo GET de categoria
    Entao valido que recebo status 200 no response
    E valido que no campo "tipo[2]" possui o valor "Terror"

  Cenario: Realizar consulta categoria sem o token
    Quando realizo uma requisicao do tipo GET de categoria
    Entao valido que recebo status 403 no response
    E valido que no campo "message" possui o valor "Access Denied"

  Cenario: Realizar consulta categoria com o token invalido
    E que tenha um header com o campo "Authorization" com o valor "invalido"
    Quando realizo uma requisicao do tipo GET de categoria
    Entao valido que recebo status 403 no response
    E valido que no campo "message" possui o valor "Access Denied"

  Cenario: Realizar consulta categoria sem o token validando campos
    Quando realizo uma requisicao do tipo GET de categoria
    Entao valido que recebo status 403 no response
    E valido que no campo "error" possui o valor "Forbidden"
    E valido que no campo "message" possui o valor "Access Denied"
    E valido que no campo "path" possui o valor "/categorias"