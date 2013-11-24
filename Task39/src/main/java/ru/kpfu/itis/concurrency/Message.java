package ru.kpfu.itis.concurrency;

public class Message {

    private String email;
    private String msg;

    public Message(String email, String str){
        this.email = email;
        this.msg=str;
    }

    public String getMsg() {
        return msg;
    }

    public String getEmail() {
        return email;
    }
}
