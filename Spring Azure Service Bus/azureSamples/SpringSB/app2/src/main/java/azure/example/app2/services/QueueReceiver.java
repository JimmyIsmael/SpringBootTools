package azure.example.app2.services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TopicPublisher;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import azure.*;

@Service
public class QueueReceiver {

    private final Logger logger = LoggerFactory.getLogger(QueueReceiver.class);

    @Autowired
    private JmsTemplate jmsTemplate;


    @JmsListener(destination = "myqueue")
    public void onMessage(String message) {
        //logger.info("Received message from queue: {}", message);
        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(message);

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);

            // loop array
            JSONArray msg = (JSONArray) jsonObject.get("messages");
            Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //jmsTemplate.send("myqueue", (Session session) -> session.createTextMessage("pong"));

    }
}
