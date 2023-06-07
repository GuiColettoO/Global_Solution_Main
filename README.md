# Global_Solution_Main
video do Pitch: https://www.youtube.com/watch?v=3qmXv0PjcGQ

#Iniciar Projeto
Dar run no arquivo Application.java
Localhost:8080

#BODY
http://localhost:8080/compradores
{
    "razaoSocial": "Ajuda",
    "nomeEmpresa": "Pesso", 
    "cnpj":"111131111-00011", 
    "telefone": "1511111111",
    "email": "juda@pesoas.com",
    "status": true
}

http://localhost:8080/vendedores
{
    "razaoSocial": "Ajuda",
    "nomeEmpresa": "Pesso", 
    "cnpj":"111131111-00011", 
    "telefone": "1511111111",
    "email": "juda@pesoas.com",
    "status": true
}

http://localhost:8080/estoque
{
    "Criação": "202337",
    "status": true, 
}

http://localhost:8080/notificacoes
{
    "notificacao": "2023418",
    "visualizacoes": 4, 
}

http://localhost:8080/produtos
{
    "nomeProduto": "Melancia",
    "nomeMarca": "Hortinha", 
    "tipo":"fruta", 
    "lote": "1",
    "dataValidade": 202578,
    "precoUnidade": 2.3,
    "quantidade": 9
}

http://localhost:8080/produtos
{
    "dataRerserva": "2023418",
    "nomeProduto": "Melancia",
    "preco": 8.98, 
    "quantidade": 9
    "valorTotal": 208.23
}
