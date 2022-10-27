
# 3.1 b)

## 1.

O novo repositório é instanciado adicionando a anotação @Autowired ao construtor de UserController. Isso significa que o valor do argumento do construtor UserRepository é passado automaticamente enquanto a instância da classe é criada. No Spring Boot o @Autowired atribui valores ao construtor. O repositório é injetado pelo Spring como argumento no construtor UserController.

## 2.

Os métodos invocados são o save(User user), findAll(), findById(long id); delete(User user). Estes métodos estão definidos na interface CrudRepository, sendo que "userRepository" dá extend a esta. Ao estender essa interface, o Spring Data JPA fornece implementações para os métodos CRUD do repositório.

## 3.

Os dados são armazenados em memória, sendo que não haverá persistência de dados no disco

## 4.

A regra é definida anotando uma restrição @NotBlank no valor email da entidade User.

# Review Questions

## A)

* O @Controller é uma especialização de @Component enquanto o @RestController é uma especialização de @Controller.

* O @Controller é uma anotação comum usada para marcar uma classe como Spring MVC Controller, enquanto o @RestController é usado para marcar uma classe como controlador RESTFul e o equivalente a @Controller e @ResponseBody combinados.

* O @RestController é relativamente recente relativamente ao @Controller que existe desde o início do Spring MVC.
A anotação @Controller indica que a classe é um “Controller” (dentro do contexto do padrão MVC ele é o ‘C’), enquanto a anotação @RestController indica que a classe é um controller em que os métodos @RequestMapping assumem a semântica @ResponseBody por padrão, ou seja, atendendo à API REST.

## B)

Diagramas na pasta atual

* Entities(Movie/Quote): Representam as entidades que estarão na base de dados. Cada entidade Quote tem uma referência para a entidade Movie respetiva.

* Controller(Controller): Representa a camada de controlo da aplicação.

* Services(MovieService/QuoteService): Classes que abstraem  do Controller o código necessário para a implementação das funções do mesmo.

* Repository(MovieRepository/QuoteRepository): Representa a camada de acesso à base de dados e estende a interface JpaRepository.

## C)

* @Table: é uma anotação que indica que a classe é uma entidade e que deve ser mapeada para uma tabela no banco de dados. O atributo name é opcional e indica o nome da tabela no banco de dados.

* @Column: é uma anotação que indica que o atributo é uma coluna no banco de dados. O atributo name é opcional e indica o nome da coluna no banco de dados.

* @Id: é uma anotação que indica que o atributo é uma chave primária no banco de dados.

## D)

A anotação @Autowired é usada para injetar automaticamente a dependência de um bean noutro bean. O Spring injeta automaticamente o objeto de dependência é marcado com a anotação @Autowired. O Spring usa o tipo do parâmetro para satisfazer a dependência. Se houver mais de um bean do mesmo tipo, o Spring  dará throw a uma exception, a menos que se use @Qualifier para remover a ambiguidade.

