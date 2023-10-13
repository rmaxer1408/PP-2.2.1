package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Infinity", 13)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("Jaguar", 7)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("Lamborghini", 23)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("Porsche", 53)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }

      String testModel = "Jaguar";
      int testSeries = 7;
      User user = userService.getUserByCar(testModel, testSeries);
      System.out.println("Car model: " + testModel);
      System.out.println("Car series: " + testSeries);
      System.out.println(user);

      context.close();
   }
}
