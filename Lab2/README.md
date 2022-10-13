

# Review Questions

## A)

Os "servlet container" tem como propósito gerir e executar servlets. São os servelet containers que chamam os métodos dos servelets e garante o fornecimento dos serviços que o servelet precisa durante a sua execução. Fornece ao servelet um acesso fácil às propriedades da chamada HTTP, aos seus cabeçalhos e parâmetros. Quando um servlet é chamado o servidor Web transfere a solicitação HTTP para o servlet container que por sua vez passa a solicitação para o servlet. 

## B)

O Spring Boot usa o padrão Model-View-Controller para servir conteúdo web. O padrão Model-View-Controller é um padrão de arquitetura de software que separa a aplicação em três componentes: modelo, visão e controlador.
O modelo é responsável pela lógica de negócio e pela manipulação dos dados.
A visão é responsável pela apresentação dos dados ao utilizador.
O controlador é responsável por receber as solicitações do utilizador e por decidir que modelo e visão devem ser usados para responder à solicitação. O controlador também pode receber dados do utilizador e passá-los para o modelo para que este possa atualizar os dados.

## C)

Os "starters" são dependências que permitem a integração de vários módulos do Spring Boot e facilitam a organização das dependências ficheiro. Por exemplo, se quisermos usar o Spring Web, podemos adicionar a dependência spring-boot-starter-web ao nosso projeto. Esta dependência adiciona automaticamente as dependências necessárias para usar o Spring Web, como o Spring MVC, Jackson, Tomcat, etc.

## D)

A anotação @SpringBootApplication inclui 3 anotações:
* @SpringBootConfiguration: é uma anotação que indica que a classe é uma fonte de definições de bean para o contexto de aplicação.
* @EnableAutoConfiguration: é uma anotação que indica que o Spring Boot deve tentar adivinhar e configurar automaticamente as configurações da aplicação com base nas dependências que adicionámos ao nosso projeto.
* @ComponentScan: é uma anotação que indica que o Spring deve procurar outros componentes, configurações e serviços no pacote atual, permitindo que ele encontre os controladores. 

## E)

1. Uma REST API deve aceitar e responder em JSON
	* JSON é um formato aberto e estandardizado para trasnferência de dados. É um formato de dados leve e fácil de ler e escrever. É independente de linguagem e pode ser usado em qualquer linguagem de programação. É um formato de dados que é fácil de usar e de ler para humanos e máquinas.
2. Não usar verbos nos URLS
	* Os verbos HTTP (GET, POST, PUT, DELETE, etc.) já indicam o que o cliente está a fazer. Não é necessário usar verbos nos URLs.<br>Boa prática:
		```
		POST: /articles/
		```
		Má prática:
		```
		POST: /articles/createNewArticle/
		```
3. Retornar os detalhes dos erros no corpo da resposta
	* Quando uma API retorna um erro, deve retornar os detalhes do erro no corpo da resposta. Isto permite que o cliente saiba o que aconteceu e como corrigir o erro. <br>Boa prática:
		```
		{
			"status": 400,
			"message": "The request could not be understood by the server due to malformed syntax.",
			"developerMessage": "org.springframework.web.bind.MissingServletRequestParameterException: Required String parameter 'name' is not present"
		}
		```
		Má prática:
		```
		{
			"status": 400,
			"message": "Bad Request"
		}
		```
4. Manter boas práticas de segurança
	* Uma API deve manter boas práticas de segurança. Por exemplo, deve usar HTTPS para proteger os dados transferidos entre o cliente e o servidor. Deve também usar autenticação e autorização para proteger os dados e os recursos da API. Deve também usar tokens de acesso para proteger as APIs de ataques de força bruta. Um utilizador não deve aceder a mais do que aquilo que pediu nem a mais do que aquilo que tem permissão para aceder.

5. Usar "nesting resources" para representar relacionamentos
	* Nesting resources é uma boa prática para organizar as URLs. Por exemplo, se quisermos obter os comentários de um artigo, podemos usar a seguinte URL:
		```
		GET: /articles/{articleId}/comments
		```
		Em vez de:
		```
		GET: /comments?articleId={articleId}
		```




