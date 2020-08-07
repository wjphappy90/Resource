package com.itheima.rmi.client;

import com.itheima.rmi.service.UserService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientDemo {

    public static void main(String[] args) {
        try {

            //远程获取服务
            UserService us = (UserService)Naming.lookup("rmi://localhost:8888/UserService");

            //调用服务
            System.out.println(us.sayHello("传智播客"));

        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
