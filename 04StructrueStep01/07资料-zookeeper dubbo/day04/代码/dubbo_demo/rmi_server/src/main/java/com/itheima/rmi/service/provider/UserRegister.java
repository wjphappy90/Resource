package com.itheima.rmi.service.provider;

import com.itheima.rmi.service.UserService;
import com.itheima.rmi.service.impl.UserServiceImpl;

import javax.sound.midi.Soundbank;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.sql.SQLOutput;

public class UserRegister {


    public static void main(String[] args) {


        try {
            UserService userService = new UserServiceImpl();
            LocateRegistry.createRegistry(8888);
            //暴露服务
            Naming.bind("rmi://localhost:8888/UserService",userService);
            System.out.println("提供service服务......");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }



}
