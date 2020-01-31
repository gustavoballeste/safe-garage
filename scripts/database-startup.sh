# Bancos de dados que são utilizados pelos microserviços
#
# Customer Database - Postgres
docker run -d --name scheduler-db \
-e POSTGRES_PASSWORD=root \
-v $HOME/vol/db/postgres/scheduler/data:/var/db/postgres/scheduler/data \
-p 5432:5432 \
postgres:12.0

# Assistance Database - Postgres
docker run -d --name assistance-db \
-e POSTGRES_PASSWORD=root \
-v $HOME/vol/db/postgres/assistance/data:/var/db/postgres/assistance/data \
-p 5433:5432 \
postgres:12.0

# Scheduler Database - Postgres
docker run -d --name scheduler-db \
-e POSTGRES_PASSWORD=root \
-v $HOME/vol/db/postgres/scheduler/data:/var/db/postgres/scheduler/data \
-p 5434:5432 \
postgres:12.0
