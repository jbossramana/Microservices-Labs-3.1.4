zookeeper start command:
zookeeper-server-start.bat ..\..\config\zookeeper.properties

kafka-server start command:
kafka-server-start.bat ..\..\config\server.properties

To create topics:
kafka-topics.bat  --bootstrap-server localhost:9092 --create --topic  new-orders --partitions 1 --replication-factor 1
kafka-topics.bat  --bootstrap-server localhost:9092 --create --topic  reversed-orders --partitions 1 --replication-factor 1
kafka-topics.bat  --bootstrap-server localhost:9092 --create --topic  new-payments --partitions 1 --replication-factor 1
kafka-topics.bat  --bootstrap-server localhost:9092 --create --topic  reversed-payments --partitions 1 --replication-factor 1
kafka-topics.bat  --bootstrap-server localhost:9092 --create --topic  new-inventory --partitions 1 --replication-factor 1
kafka-topics.bat  --bootstrap-server localhost:9092 --create --topic  reversed-inventory --partitions 1 --replication-factor 1



Success scenario:

post localhost:8082/inventory

{
"item":"books",
"quantity":200
}

post  localhost:8080/order

{
"item":"books",
"quantity":10,
"amount":1000,
"address":"chennai",
"paymentMode":"credit card"
}

Failure Scenario

post  localhost:8080/order

{
"item":"computer",
"quantity":10,
"amount":30000,
"address":"chennai",
"paymentMode":"credit card"
}



