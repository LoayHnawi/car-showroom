package cars.com.javainuse.controller;

import cars.home.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import cars.com.javainuse.service.RabbitMQSender;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/javainuse-rabbitmq/")
public class RabbitMQWebController {

    private static final Logger logger = Logger.getLogger(Controller.class.getName());
    @Autowired
    RabbitMQSender rabbitMQSender;

    @GetMapping(value = {"/MessageQueue"})
    public String newM(Model model) {
        Message message = new Message();
        model.addAttribute("message", message);
        return "MessageQueue";
    }

    @PostMapping(value = {"","/send","send"})
    public String saveM(@ModelAttribute("message") Message message)
    {
        rabbitMQSender.send(message);

        logger.log(Level.INFO,"Sent : "+ message.getText()+"  to the RabbitMQ JavaInUse Successfully");
        return "redirect:/javainuse-rabbitmq/MessageQueue";
    }
}



























/*package com.javainuse.controller;

import cars.home.Car;
import cars.home.Message;
import cars.home.Sell;
import com.javainuse.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/javainuse-rabbitmq/")
public class RabbitMQWebController {

    @Autowired
    RabbitMQSender rabbitMQSender;

        @GetMapping(value = "/producer")
    public String producer(@RequestParam("Email") String Email,@RequestParam("date") String date, @RequestParam("text") String text) {

        Message msg = new Message();

        msg.setEmail(Email);
        msg.setDate(date);
        msg.setText(text);

        rabbitMQSender.send(msg);

        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }




    @GetMapping(value = "/producer")
    public String producer(String date,String text,String Email) {

        Message msg=new Message();
        msg.setDate(date);
        msg.setText(text);
        msg.setEmail(Email);
        rabbitMQSender.send(msg);

        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }

    @GetMapping(value = {"/m"})
    public String newM(Model model) {
        Message message = new Message();
        model.addAttribute("message", message);
        return "MessageQueue";
    }


    @PostMapping(value = {"","/send","send"})
    public String saveM(@ModelAttribute("message") Message message)
    {
//        Message msg = new Message();
//        msg.setEmail(message.getEmail());
//        msg.setText(message.getText());
//        msg.setDate(message.getDate());

        rabbitMQSender.send(message);
        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }

}

*/