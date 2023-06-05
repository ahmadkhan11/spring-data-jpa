package com.springBoot.spring.data.jpa.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.springBoot.spring.data.jpa.repository")
public class DynamoDBConfig {

  @Value("dynamodb.eu-north-1.amazonaws.com")
  private String endpoint;
  @Value("${amazon.aws.accesskey}")
  private String accessKey;

  @Value("${amazon.aws.secretkey}")
  private String secretKey;

  @Value("${amazon.aws.region}")
  private String region;

//  @Bean
//  public DynamoDbClient dynamoDbClient() {
//    return DynamoDbClient.builder().region(Region.of(region)).credentialsProvider(
//        StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey))).build();
//  }

  @Bean
  public AmazonDynamoDB amazonDynamo0B() {
    return AmazonDynamoDBAsyncClientBuilder
        .standard()
        .withEndpointConfiguration(
            new EndpointConfiguration(endpoint,region)
        )
        .withCredentials( new AWSStaticCredentialsProvider(
            new BasicAWSCredentials(accessKey,secretKey)))
        .build();

  }
}
