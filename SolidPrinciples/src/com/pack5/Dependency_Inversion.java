package com.pack5;


interface MessageService
{
    void sendMessage(String message);
}


class EmailService implements MessageService 
{
    @Override
    public void sendMessage(String message) 
    {
        System.out.println("Email sent: " + message);
    }
}

class SMSService implements MessageService 
{
    @Override
    public void sendMessage(String message) 
    {
        System.out.println("SMS sent: " + message);
    }
}


class Notification 
{
    private MessageService messageService;

    public Notification(MessageService messageService) 
    {
        this.messageService = messageService;
    }

    public void notifyUser(String msg) 
    {
        messageService.sendMessage(msg);
    }
}
public class Dependency_Inversion 
{
	public static void main(String[] args) 
	{
        Notification emailNotification = new Notification(new EmailService());
        emailNotification.notifyUser("Welcome to Java SOLID!");

        Notification smsNotification = new Notification(new SMSService());
        smsNotification.notifyUser("Your OTP is 12345");
    }
}
