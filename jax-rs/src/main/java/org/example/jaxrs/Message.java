package org.example.jaxrs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {

    private String message;
    private static Text text;


    {
        text = new Text("Hello World");
        message = calc("message", text.getText());
    }

    public static void main(String[] args) {
        System.out.println(new Message());
    }

    public Message() {
    }

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    static String calc(String a, String b) {
        return a += b;
    }


    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", text=" + text +
                '}';
    }
}

class Text {
    private String text;

    public Text() {
    }

    public Text(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}