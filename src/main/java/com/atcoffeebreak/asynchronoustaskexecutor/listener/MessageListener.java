package com.atcoffeebreak.asynchronoustaskexecutor.listener;

import com.atcoffeebreak.asynchronoustaskexecutor.pojo.Email;
import com.atcoffeebreak.asynchronoustaskexecutor.pojo.Invoice;
import com.github.sonus21.rqueue.annotation.RqueueListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageListener {

    @RqueueListener(value = "${email.queue.name}")
    public void sendEmail(Email email) {
        log.info("Email {}", email);
    }

    @RqueueListener(delayedQueue = "true", value = "${invoice.queue.name}")
    public void generateInvoice(Invoice invoice) {
        log.info("Invoice {}", invoice);
    }
}