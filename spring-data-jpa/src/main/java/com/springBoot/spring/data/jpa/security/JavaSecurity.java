package com.springBoot.spring.data.jpa.security;

public class JavaSecurity {

  public void security(String item){


    var item1 = item;
    System.out.println("item1 = " + item1);
    String first = returnItem();
    String second = returnItem2();

  }

  public String returnItem(){

    System.out.println("Inside  " );

    String var="abacss";
    return var;
  }
  public String returnItem2(){

    System.out.println("Inside 2  " );

    String var="abacss";
    return var;
  }

}
