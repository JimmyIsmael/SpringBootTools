/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package azure.example.app1.services;

import javax.annotation.PostConstruct;
import javax.jms.Session;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class QueuePublisher {
    
    private final Logger logger = LoggerFactory.getLogger(QueuePublisher.class);
    
    @Autowired
    private JmsTemplate jmsTemplate;

    public JSONObject setJSON(){
        JSONObject obj = new JSONObject();
        obj.put("name", "Jimmy");
        obj.put("age", new Integer(25));

        JSONArray list = new JSONArray();
        list.add("IT");
        list.add("Developer");
        list.add("Movies Fan");
        obj.put("messages", list);

        return obj;
    }

    @PostConstruct
    public void afterConstruct() {
        sendPing();
    }
 
    public void sendPing() {
        logger.info("Sending ping");
        //jmsTemplate.send("myqueue", (Session session) -> session.createTextMessage("ping"));
        jmsTemplate.send("myqueue", (Session session) -> session.createObjectMessage(setJSON().toJSONString()));
    }
}
