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
* Trabalhando com Enums nas colunas [https://tomee.apache.org/examples-trunk/jpa-enumerated/](https://tomee.apache.org/examples-trunk/jpa-enumerated/)
* Transações Baeldung [https://www.baeldung.com/spring-transactional-propagation-isolation](https://www.baeldung.com/spring-transactional-propagation-isolation)
* Transações exemplo e explicação StackOverflow: [https://stackoverflow.com/questions/8490852/spring-transactional-isolation-propagation](https://stackoverflow.com/questions/8490852/spring-transactional-isolation-propagation)
