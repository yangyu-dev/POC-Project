package com.rewards.handler;

import com.rewards.kafka.Sender;
import com.rewards.model.Customer;
import com.rewards.model.CustomerChangeEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class AfterSaveListener extends AbstractMongoEventListener<Customer> {

    @Value("${spring.kafka.topic.accounts-customer}")
    private String topic;

    private Sender sender;

    @Autowired
    public AfterSaveListener(Sender sender) {

        this.sender = sender;
    }

    @Override
    public void onAfterSave(AfterSaveEvent<Customer> event) {

        log.info("onAfterSave event='{}'", event);
        Customer customer = event.getSource();

        CustomerChangeEvent customerChangeEvent = new CustomerChangeEvent();
        customerChangeEvent.setId(customer.getId());
        customerChangeEvent.setName(customer.getName());
        customerChangeEvent.setContact(customer.getContact());
        customerChangeEvent.setAddresses(customer.getAddresses());

        sender.send(topic, customerChangeEvent);
    }
}