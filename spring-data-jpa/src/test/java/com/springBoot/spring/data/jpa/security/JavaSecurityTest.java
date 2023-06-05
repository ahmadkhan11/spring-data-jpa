package com.springBoot.spring.data.jpa.security;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class JavaSecurityTest {
  @InjectMocks
  JavaSecurity javaSecurity;

  @BeforeEach
  void setup() {
   // javaSecurity = spy(new JavaSecurity()); // Create a spy instance of JavaSecurity
  }

  @Test
  public void firstTest() {

    //JavaSecurity javaSecurity = new JavaSecurity();

    JavaSecurity javaSecuritySpy = Mockito.spy(javaSecurity);


    doReturn("fdfdf").when(javaSecuritySpy).returnItem();
    doReturn("fdfdf").when(javaSecuritySpy).returnItem2();

    javaSecuritySpy.security("item");

    // Add your assertions here
  }
}
