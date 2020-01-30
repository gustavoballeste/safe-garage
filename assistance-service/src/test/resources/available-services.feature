# language: pt
Funcionalidade: Serviços disponíveis
  Disponibiliza informações dos prestadores de serviços

  Esquema do Cenário: Cliente quer consultar os serviços disponíveis por "<categoria>"
    Dado Que cliente é um comprador
    Quando Pesquisa os serviços disponíveis por "<categoria>"
    Entao Devem ser consultados os serviços cadastrados
    E O status da resposta deve ser "200"
    E Retornar a lista de mecânicas disponíveis "<nome>"
    Exemplos:
      | categoria    | nome         |
      | <categoria>  | "mecanica 1" |
