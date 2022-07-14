/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.utilerias;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Jorge Ortega
 */
public class EnviarMail {
    public void enviarCorreo(String destinatario ,String asunto, String mensaje){
        try {
            Properties p = new Properties();
            
            p.setProperty("mail.smpt.host", "smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.setProperty("mail.smpt.port", "587");
            p.setProperty("mail.smpt.user", "cuenta123basura123@gmail.com");
            p.setProperty("mail.smpt.auth", "true");
            p.setProperty("mail.smpt.clave", "zxcZXC890_");
//            System.out.println(p.getProperty("mail.smpt.user"));
//            System.out.println(p.getProperty("mail.smpt.clave"));
//            System.out.println(p.getProperty("mail.smpt.host"));
            Session s = Session.getDefaultInstance(p);
            MimeMessage elMensaje = new MimeMessage(s);
            elMensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            //copia del mensaje
            elMensaje.addRecipient(Message.RecipientType.TO, new InternetAddress("aladar2001@gmail.com"));
            elMensaje.setSubject(asunto);
            elMensaje.setText(mensaje);
                    
            Transport t= s.getTransport("smtp");
            t.connect(p.getProperty("mail.smpt.host"),p.getProperty("mail.smpt.user"),p.getProperty("mail.smpt.clave"));
            t.sendMessage(elMensaje, elMensaje.getAllRecipients());
            t.close();
            
            //myaccount.google.com/lesssecureapps
        } catch (AddressException ex) {
            Logger.getLogger(EnviarMail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EnviarMail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        EnviarMail email =new EnviarMail();
        String destinatario="joredorsi@gmail.com";
        String asunto="Registro Satisfactorio :)";
        String texto="Su asunto fue Satisfactorio :)";
        email.enviarCorreo(destinatario, asunto, texto);
    }
}
