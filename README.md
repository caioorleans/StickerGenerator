# StickerGenerator

## Sobre o projeto:
Em março de 2023, a Alura realizou um evento no qual eles criaram um pequeno programa, em java, capaz de consumir uma api do IMDb e criar "figurinhas" com a imagem obtida.
Entretanto, fiquei um pouco decepcionado, uma vez que achei que eles ensinariam também como transformar esse pequeno programa em uma API.
Como esse não foi o caso, resolvi eu mesmo criar essa API.

## Mudanças feitas:
* Trocada a API utilizada por uma do Pokémon, uma vez que a do IMDb estava indisponível;
* Criado um controller, de forma que fosse possível receber requisições HTTP;
* Tratadas excessões deixadas de lado durante as aulas da Alura, de forma a retornar respostas mais amigáveis aos usuários;
* Modularizado o projeto, de forma que seja possível implementar de forma fácil a geração de figurinhas a partir de outras APIs de tercceiros;
* Tratar a resposta da API de acordo com a resposta recebida pela API de terceiros.

## Por fazer:
* Implementar uma pequena base de dados, de forma que seja possível reconhecer quando uma figurinha já tiver sido gerada previamente, de forma a evitar retrabalho e melhorar a performance;
* Implementar testes.
