package ru.rudolf.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import ru.rudolf.spring.demo.dao.UserDAO;
import ru.rudolf.spring.demo.dao.impl.HibernateUserDAO;
import ru.rudolf.spring.demo.model.User;

public class Main {

    public static void main (String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext ("context.xml");
        UserDAO userDAO = context.getBean ("HibernateUserDAO", HibernateUserDAO.class);

        String[] command = { "" };
        try (BufferedReader reader =
                     new BufferedReader (new InputStreamReader (System.in))) {

            while (!command[0].equals ("exit")) {
                switch (command[0]) {
                    case "add":
                        if (command.length == 4) {
                            userDAO.add (new User (command[1], command[2], command[3]));
                        }
                        break;
                    case "get":
                        if (userDAO.getOne (command[1]) != null)
                            System.out.println (userDAO.getOne (command[1]));
                        else System.out.println ("User not found");
                        break;
                    case "print":
                        List< User > users = userDAO.getAll ();
                        if (!users.isEmpty ()) {
                            for (User user : users) {
                                System.out.println (user.toString ());
                            }
                        } else
                            System.out.println ("Empty");
                        break;
                }
                command = reader.readLine ().split (" ");
            }
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}
