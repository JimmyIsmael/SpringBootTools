package azure.example.app2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
@ComponentScan({"azure.example.common","azure.example.app2"})
public class Receiver {

    public static void main(String[] args) {
        SpringApplication.run(Receiver.class, args);
    }
    
}
