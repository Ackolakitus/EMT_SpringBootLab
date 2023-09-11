package mk.ukim.finki.emt.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class LabEMTApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabEMTApplication.class,args);
    }

}
