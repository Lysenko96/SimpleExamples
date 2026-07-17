KAFKA_CLUSTER_ID="$(bin/kafka-storage.sh random-uuid)"

bin/kafka-storage.sh format --standalone -t $KAFKA_CLUSTER_ID -c config/server.properties

bin/kafka-storage.sh format -t $KAFKA_CLUSTER_ID -c config/server-1.properties

bin/kafka-server-start.sh config/server.properties

sh kafka-topics.sh --describe --bootstrap-server localhost:9092

sh kafka-topics.sh --delete --topic __consumer_offsets --bootstrap-server localhost:9092

sh kafka-console-producer.sh --bootstrap-server localhost:9092 --topic transaction-created-events-topic

sh kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic transaction-created-events-topic --from-beginning --property "print.key=true"