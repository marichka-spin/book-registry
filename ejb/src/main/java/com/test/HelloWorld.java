package com.test;

import javax.ejb.Local;

@Local
public interface HelloWorld {

    String sayHello();
}
