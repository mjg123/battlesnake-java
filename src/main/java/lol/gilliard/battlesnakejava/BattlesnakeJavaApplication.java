package lol.gilliard.battlesnakejava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BattlesnakeJavaApplication {

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.version"));

        SpringApplication.run(BattlesnakeJavaApplication.class, args);
    }

}
