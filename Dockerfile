FROM openjdk:11
EXPOSE 8085
ADD target/TransactionsAPI-0.0.1-SNAPSHOT.jar TransactionsAPI.jar
ENTRYPOINT ["java", "-jar", "TransactionsAPI.jar"]