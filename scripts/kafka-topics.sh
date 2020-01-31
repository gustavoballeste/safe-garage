# Zookeper start
echo '>>> STARTING ZOOKEEPER!'
$HOME/kafka/kafka_2.12-2.3.0/bin/zookeeper-server-start.sh \
$HOME/kafka/kafka_2.12-2.3.0/config/zookeeper.properties &


# Kafka Start
echo '>>> STARTING KAFKA!'
$HOME/kafka/kafka_2.12-2.3.0/bin/kafka-server-start.sh \
$HOME/kafka/kafka_2.12-2.3.0/config/server.properties &

# Kafka Topics
#
# Order sent topic, status pending
echo '>>> CREATING TOPIC: queue.safegarage.scheduling.order.pending'
$HOME/kafka_2.12-2.3.0/bin/kafka-topics.sh --create \
--bootstrap-server localhost:9092 \
--replication-factor 1 --partitions 1 \
--topic queue.safegarage.scheduling.order.pending&
echo '>>> TOPIC CREATED: queue.safegarage.scheduling.order.pending!'

# Order processed topic
echo '>>> CREATING TOPIC: queue.safegarage.scheduling.order.confirmed!'
$HOME/kafka_2.12-2.3.0/bin/kafka-topics.sh --create \
--bootstrap-server localhost:9092 \
--replication-factor 1 --partitions 1 \
--topic queue.safegarage.scheduling.order.confirmed &
echo '>>> TOPIC CREATED: queue.safegarage.scheduling.order.confirmed!'
