KAFKA_CLUSTER_ID="$(bin/kafka-storage.sh random-uuid)"

bin/kafka-storage.sh format --standalone -t $KAFKA_CLUSTER_ID -c config/server.properties

bin/kafka-storage.sh format -t mChjqPH0SgiwUBRqnUziMw -c config/server-1.properties

bin/kafka-server-start.sh config/server.properties

sh kafka-topics.sh --describe --bootstrap-server localhost:9092

./kafka-topics.sh --delete --topic __consumer_offsets --bootstrap-server localhost:9092

sh kafka-console-producer.sh --bootstrap-server localhost:9092 --topic transaction-created-events-topic

sh kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic transaction-created-events-topic --from-beginning --property "print.key=true"

sh kafka-console-producer.sh --bootstrap-server localhost:9092 --topic transaction-created-events-topic --reader-property "parse.key=true" --reader-property "key.separator=:"

sh kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic transaction-created-events-topic-dlt --property "parse.key=true"