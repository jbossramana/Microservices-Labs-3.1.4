Run the below commands from kafka bin directory(C:\kafka_2.13-3.6.0\bin\windows)

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
"quantity":50
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
"item":"laptops",
"quantity":60,
"amount":30000,
"address":"chennai",
"paymentMode":"credit card"
}


To check the success/failure result, we need to access the database:
http://localhost:8080/h2-console
jdbc:h2:mem:ordersdb



