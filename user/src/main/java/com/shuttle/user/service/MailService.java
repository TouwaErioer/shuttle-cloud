package com.shuttle.user.service;

public interface MailService {

    void sendTokenMail(String to, String text, String subject);
}
