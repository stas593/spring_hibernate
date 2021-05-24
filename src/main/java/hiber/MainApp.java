package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("BMW", 111);
      Car car2 = new Car("BMW", 222);
      Car car3 = new Car("LADA", 333);
      Car car4 = new Car("VW", 444);
      Car car5 = new Car("AUDI", 555);

      User newUser = new User("Artem", "Oleynikov", "artem322@mail.ru");
      newUser.setCar(car1);
      System.out.println(newUser.getCar().getId());
      userService.add(newUser);
      newUser = new User("Andrey", "Stelmakh", "And@mail.ru");
      newUser.setCar(car2);
      System.out.println(newUser.getCar().getId());
      userService.add(newUser);
      newUser = new User("Stas", "Loparev", "stas593@mail.ru");
      newUser.setCar(car3);
      System.out.println(newUser.getCar().getId());
      userService.add(newUser);
      newUser = new User("Nikita", "Loparev", "Nikita@mail.ru");
      newUser.setCar(car4);
      System.out.println(newUser.getCar().getId());
      userService.add(newUser);
      newUser = new User("Liza", "Prokhorova", "proh322@mail.ru");
      newUser.setCar(car5);
      System.out.println(newUser.getCar().getId());
      userService.add(newUser);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getCar().getModel() + " " + user.getCar().getSeries());
         System.out.println();
      }
      User user1 = userService.getUserOnModel("VW", 444);
         System.out.println(user1.toString());
         System.out.println("Id = "+ user1.getId());
         System.out.println("First Name = " +user1.getFirstName());
         System.out.println("Last Name = "+ user1.getLastName());
         System.out.println("Email = "+ user1.getEmail());
         System.out.println("Car = " + user1.getCar().getModel() + " " + user1.getCar().getSeries());
         System.out.println();
      context.close();
   }
}
