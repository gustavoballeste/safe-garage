# Bancos de dados que são utilizados pelos microserviços
#
# Assistance Database - Postgres
docker run -d --name assiastance-postgres \
-e POSTGRES_PASSWORD=root \
-v $HOME/vol/db/postgres/assiastance/data:/var/db/postgres/assiastance/data \
-p 5432:5432 \
postgres:12.0
