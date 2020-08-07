package com.itheima.rmi.service;

import java.rmi.Remote;

public interface UserService extends Remote {

    String sayHello(String name);

}
