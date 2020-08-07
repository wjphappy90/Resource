package com.itheima.rmi.service.impl;

import com.itheima.rmi.service.UserService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UserServiceImpl extends UnicastRemoteObject implements UserService {

    public UserServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(String name) {
        return "hello"+name;
    }
}
