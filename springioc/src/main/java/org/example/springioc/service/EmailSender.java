package org.example.springioc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
@Scope("prototype")
public class EmailSender {

    //@Autowired
//    private AdvanceSender advanceSender;
    @Autowired
    @Qualifier("advanceSender")
    private Sender sender;
   private List<Sender> senders = Collections.list(Collections.emptyEnumeration());
  //private List<Sender> senders = new ArrayList<>();

    //@Autowired
//    public EmailSender(
//            @Autowired  AdvanceSender advanceSender, @Autowired BasicSender basicSender
//            //AdvanceSender advanceSender, BasicSender basicSender
//    ) {
////        this.advanceSender = advanceSender;
////        this.basicSender = basicSender;
//        this.senders = new ArrayList<>(Arrays.asList(advanceSender, basicSender));
//    }

    // priority @Autowired Setter -> Constructor -> Field
    // but if used @Primary in Constructor and @Qualifier in field worked FIELD @Autowired

    @Autowired
    public EmailSender(Sender sender) {
        this.sender = sender;
    }

    //@Autowired
    public void setBasicSender(Sender sender) { // work without @Qualifier by bean name ("basicSender")
    //public void setBasicSender(Sender basicSender) { // work without @Qualifier by bean name ("basicSender")
   // public void setBasicSender(@Qualifier("advanceSender") Sender sender) { // if have @Primary worked @Qualifier have more priority
    //public void setBasicSender(Sender sender) { // work because @Primary
        this.sender = sender;
        senders.add(sender);
    }

//    public List<Sender> getSenders() {
//        return senders;
//    }

    public void sendEmail(){
        senders.add(sender);
        for (Sender s : senders) {
            s.send();
        }
    }

    @Override
    public String toString() {
        return "EmailSender{" +
//                "advanceSender=" + advanceSender +
//                ", basicSender=" + basicSender +
                ", senders=" + senders+
                '}';
    }
}
