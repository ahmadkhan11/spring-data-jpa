package com.springBoot.spring.data.jpa.entity;

import java.util.Map;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeDefinition;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.CreateTableRequest;
import software.amazon.awssdk.services.dynamodb.model.CreateTableResponse;
import software.amazon.awssdk.services.dynamodb.model.KeySchemaElement;
import software.amazon.awssdk.services.dynamodb.model.ProvisionedThroughput;
import software.amazon.awssdk.services.dynamodb.model.ScalarAttributeType;
import software.amazon.awssdk.regions.Region;

public class DynamoDBTableCreator {

  public static void main(String[] args) {
    DynamoDbClient dynamoDbClient = DynamoDbClient.builder()
        .region(Region.AP_SOUTH_1)
        .build();

    String tableName = "awsDb";
    String primaryKeyAttributeName = "id";

    createTable(dynamoDbClient, tableName, primaryKeyAttributeName);
  }

  public static void createTable(DynamoDbClient dynamoDbClient, String tableName, String primaryKeyAttributeName) {
    AttributeDefinition attributeDefinition = AttributeDefinition.builder()
        .attributeName(primaryKeyAttributeName)
        .attributeType(ScalarAttributeType.S)
        .build();

    KeySchemaElement keySchemaElement = KeySchemaElement.builder()
        .attributeName(primaryKeyAttributeName)
        .keyType("HASH")
        .build();

    ProvisionedThroughput provisionedThroughput = ProvisionedThroughput.builder()
        .readCapacityUnits(5L)
        .writeCapacityUnits(5L)
        .build();

    CreateTableRequest request = CreateTableRequest.builder()
        .tableName(tableName)
        .attributeDefinitions(attributeDefinition)
        .keySchema(keySchemaElement)
        .provisionedThroughput(provisionedThroughput)
        .build();

    CreateTableResponse response = dynamoDbClient.createTable(request);

    System.out.println("Table created: " + response.tableDescription().tableName());
  }

  public static DynamoDBTableCreator fromAttributeValueMap(Map<String, AttributeValue> item) {
    return null;
  }

  public Map<String, AttributeValue> toAttributeValueMap() {
    return null;
  }
}

