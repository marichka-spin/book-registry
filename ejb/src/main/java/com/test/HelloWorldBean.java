package com.test;

import javax.ejb.Stateless;

@Stateless
public class HelloWorldBean implements HelloWorld {

    public HelloWorldBean() {
    }

    @Override
    public String sayHello() {
        return "Hello, World!";
    }

}
