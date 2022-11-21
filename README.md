Criado o aplicativo que utiliza a API do github para retornar os repositorio do topico Java

A partir de um repositorio é possivel ver os Pull Requests deste repositorio clicando no repositorio especifico.

Na lista de pull request ao clicar no item voce sera levado para a pagina do pull request.

Foi utilizado dagger2, MVVM, paging, FLOW, assim como retrofit para a chamada Rest e o Glide para renderizar as imagens existentes.

O objeto foi criado como Parcelable para poder ser enviado dentro do safeargs do nav_graph.

Nao foi criado os testes unitarios para o projeto.