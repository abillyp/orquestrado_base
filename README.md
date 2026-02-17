
# Saga Orchestration Microservices — Local Environment (Docker Desktop)

Este projeto implementa uma arquitetura de microserviços com **Saga Orchestration** usando:

-   Java 25
    
-   Spring Boot
    
-   Maven
    
-   Apache Kafka
    
-   MySQL
    
-   Docker Desktop
    
-   Docker Compose
    

Todo o ambiente roda **100% local**, sem Kubernetes.

----------

# Arquitetura

```
Docker Desktop
│
├── orchestrator-service (8085)
│        │
│        ├── envia eventos →
│        │
├── sale-service (8081)
├── inventory-service (8082)
├── payment-service (8083)
│
├── Kafka (9092)
│
└── MySQL (3306)

```

Fluxo:

```
Client → orchestrator-service
            ↓
         Kafka
     ↓       ↓
inventory   payment
     ↓       ↓
     ← status/eventos →
            ↓
       orchestrator

# Arquitetura Saga Orchestration

<p align="center">
  <img src="./docs/images/saga-orchestration.png" width="800" alt="Saga Orchestration Diagram"/>
</p>


----------

# Estrutura do projeto

```
my-orchestration/
│
├── docker-compose.yml
│
├── docker/
│   └── mysql/
│       └── init/
│           └── 01-init.sql
│
├── services/
│   ├── sale-service/
│   │   ├── Dockerfile
│   │   ├── pom.xml
│   │   └── src/
│   │
│   ├── inventory-service/
│   ├── payment-service/
│   └── orchestrator-service/
│
└── README.md

```

----------

# Pré-requisitos

Instalar:

-   Docker Desktop
    
-   Java 25 (opcional, apenas para rodar fora do Docker)
    
-   Maven (opcional)
    

Verificar Docker:

```bash
docker --version
docker compose version

```

----------

# Como iniciar o ambiente

Na raiz do projeto:

```bash
docker compose up -d --build

```

Isso irá subir:

-   MySQL
    
-   Kafka
    
-   Zookeeper
    
-   sale-service
    
-   inventory-service
    
-   payment-service
    
-   orchestrator-service
    

----------

# Verificar containers

```bash
docker compose ps

```

Exemplo:

```
NAME                     STATUS
db                       running
kafka                    running
sale-service             running
inventory-service        running
payment-service          running
orchestrator-service     running

```

----------

# Ver logs

Exemplo:

```bash
docker compose logs -f orchestrator-service

```

ou

```bash
docker compose logs -f payment-service

```

----------

# Parar o ambiente

```bash
docker compose down

```

Remover volumes também:

```bash
docker compose down -v

```

----------

# Banco de dados

Os bancos são criados automaticamente pelo script:

```
docker/mysql/init/01-init.sql

```

Bancos criados:

```
saga_sale
saga_inventory
saga_payment

```

Conectar manualmente:

```bash
docker exec -it <mysql-container> mysql -u root -p

```

Senha:

```
example

```

----------

# Portas dos serviços

Serviço

Porta

orchestrator-service

8085

sale-service

8081

inventory-service

8082

payment-service

8083

Kafka

9092

MySQL

3306

----------

# Acessar serviços

Exemplos:

```
http://localhost:8085
http://localhost:8081
http://localhost:8082
http://localhost:8083

```

----------

# Comunicação entre serviços

Dentro do Docker:

MySQL:

```
db:3306

```

Kafka:

```
kafka:29092

```

Nunca usar:

```
localhost

```

----------

# Build manual de um serviço

Exemplo:

```bash
cd services/payment-service

docker build -t payment-service .

```

----------

# Reiniciar um serviço

```bash
docker compose restart payment-service

```

----------

# Troubleshooting

## Serviço não sobe

Ver logs:

```bash
docker compose logs -f payment-service

```

----------

## MySQL não conecta

Verificar container:

```bash
docker compose ps

```

----------

## Kafka não conecta

Verificar:

```bash
docker compose logs kafka

```

----------

## Rebuild completo

```bash
docker compose down -v

docker compose up -d --build

```

----------

# Tecnologias utilizadas

-   Java 25
    
-   Spring Boot
    
-   Maven
    
-   Apache Kafka
    
-   MySQL 8
    
-   Docker
    
-   Docker Compose
    

----------

# Objetivo do projeto

Demonstrar uma arquitetura baseada em:

-   Saga Pattern
    
-   Event-driven architecture
    
-   Microservices
    
-   Orchestration-based Saga
    
-   Comunicação assíncrona com Kafka
    

----------

# Autor

Projeto de estudo e arquitetura de microserviços com Saga Orchestration.
