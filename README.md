# Spring Boot Restful Web Api

Esse repositório contém um exemplo de implementação de API Rest usando Spring Boot.

## Requerimentos

* Java 11, usei o openjdk
* Maven para gestão de dependências, usei a versão 3.8.4

## Rodando

Após clonar o projeto execute o comando `mvn clean install` para instalar as dependências localmente. E execute o comando `mvn spring-boot:run` para executar o projeto.

```bash
# instalando dependências
mvn clean install
# rodando o projeto localmente
mvn spring-boot:run
```

## Estrutura de pastas

A estrutura de pastas é a sugerida pela ferramenta de bootstrap de projeto [https://start.spring.io/](https://start.spring.io/).

## Ferramentas úteis

* Postman para testar a API [https://www.postman.com/downloads/](https://www.postman.com/downloads/)

## Referências

Essa seção documenta alguns dos materiais usados para a contrução da aplicação (código fonte).

* Tutorial "Construindo serviços Rest com Spring" [https://spring.io/guides/tutorials/rest/](https://spring.io/guides/tutorials/rest/)
* YouTube: Spring Boot Restful Web Services CRUD Example [https://www.youtube.com/watch?v=YYwFhclOlqs](https://www.youtube.com/watch?v=YYwFhclOlqs)
* Como configurar relacionamentos entre entidades: [https://www.baeldung.com/spring-data-rest-relationships](https://www.baeldung.com/spring-data-rest-relationships)
* Mais material de relacionamento: [https://developer.jboss.org/docs/DOC-55914](https://developer.jboss.org/docs/DOC-55914)
* Trabalhando com Enums nas colunas [https://tomee.apache.org/examples-trunk/jpa-enumerated/](https://tomee.apache.org/examples-trunk/jpa-enumerated/)
* Transações Baeldung [https://www.baeldung.com/spring-transactional-propagation-isolation](https://www.baeldung.com/spring-transactional-propagation-isolation)
* Transações exemplo e explicação StackOverflow: [https://stackoverflow.com/questions/8490852/spring-transactional-isolation-propagation](https://stackoverflow.com/questions/8490852/spring-transactional-isolation-propagation)
* Manipulando dados com JPA: [https://spring.io/guides/gs/accessing-data-jpa/](https://spring.io/guides/gs/accessing-data-jpa/)
* Trabalhando com Loggers: [https://www.baeldung.com/spring-boot-logging](https://www.baeldung.com/spring-boot-logging)
* Paginação, ordenação: [https://www.baeldung.com/spring-data-jpa-pagination-sorting](https://www.baeldung.com/spring-data-jpa-pagination-sorting)
* FindAllBy algum campo exemplo: [https://stackoverflow.com/questions/18987292/spring-crudrepository-findbyinventoryidslistlong-inventoryidlist-equivalen](https://stackoverflow.com/questions/18987292/spring-crudrepository-findbyinventoryidslistlong-inventoryidlist-equivalen)
* QueryString parametros e opcionais: [https://stackoverflow.com/questions/32201441/how-do-i-retrieve-query-parameters-in-a-spring-boot-controller](https://stackoverflow.com/questions/32201441/how-do-i-retrieve-query-parameters-in-a-spring-boot-controller)
* Repository palavras-chave: [https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords)
* Serialização JSON de objetos com relação: [https://www.baeldung.com/jackson-bidirectional-relationships-and-infinite-recursion](https://www.baeldung.com/jackson-bidirectional-relationships-and-infinite-recursion)
