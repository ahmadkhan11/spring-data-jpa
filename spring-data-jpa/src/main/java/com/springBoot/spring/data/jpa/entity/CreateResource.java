package com.springBoot.spring.data.jpa.entity;


import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

@Data
@Builder
public class CreateResource {

  private static  String DB_URL ;
  private static  String DB_USER ;
  private static  String DB_PASSWORD ;

  public Map<String, AttributeValue> toAttributeValueMap() {
    return null;
  }
}
