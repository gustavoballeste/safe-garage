# Bancos de dados que são utilizados pelos microserviços
#
# Assistance Database - Postgres
docker run -d --name assistance-postgres \
-e POSTGRES_PASSWORD=root \
-v $HOME/vol/db/postgres/assistance/data:/var/db/postgres/assistance/data \
-p 5432:5432 \
postgres:12.0
