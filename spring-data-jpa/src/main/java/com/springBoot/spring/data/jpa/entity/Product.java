package com.springBoot.spring.data.jpa.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;

@DynamoDBTable(tableName = "product")
@Data
public class Product {

  @DynamoDBHashKey(attributeName = "id")
  @DynamoDBAutoGeneratedKey
  private String id ;

  @DynamoDBAttribute(attributeName = "name")
  private String productName ;

  @DynamoDBAttribute(attributeName = "category")
  private String category ;

  @DynamoDBAttribute(attributeName = "price")
  private float price ;

}
