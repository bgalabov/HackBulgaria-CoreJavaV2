package com.hackbulgaria.corejava;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class EmailSender {
    
    private static final int PORT = 465;
    
    public static void SendEmail(String... args) throws EmailException, MalformedURLException {
        String[] emailSenderStrings = args[3].split("@");
        MultiPartEmail email = new MultiPartEmail();
        if(args.length<5) {
            System.out.println("Too few arguments.");
            return;
        }
        if(args.length == 6) {
            EmailAttachment attachment = new EmailAttachment();
            attachment.setURL(new URL(args[5]));
            email.attach(attachment);
        }
        email.addTo(args[0]);
        email.setSubject(args[1]);
        email.setMsg(args[2]);
        email.setFrom(args[3]);
        email.setHostName("smtp." +emailSenderStrings[1]);
        email.setSmtpPort(PORT);
        email.setSSLOnConnect(true);
        email.setAuthentication(args[3], args[4]);
        email.send();
        System.out.println("Email sent sucessfully.");
        
        
    }
    

    
    public static void main(String[] args) throws MalformedURLException, EmailException {
        EmailSender.SendEmail("test121212264@gmail.com", "This is subject", "Hello World!", "test121212264@gmail.com", "121212264", "file:\\C:\\Users\\Bobby\\Desktop\\ubavec.PNG");
    
    }
}
