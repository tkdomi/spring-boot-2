package pl.hqbusiness.springboot2.week6.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import pl.hqbusiness.springboot2.week6.model.Movie;

@Aspect
@Component
public class EmailAspect {

  private JavaMailSender javaMailSender;

  public EmailAspect(JavaMailSender javaMailSender) {
    this.javaMailSender = javaMailSender;
  }

  @After("@annotation(SendEmail)")
  private void sendEmail(JoinPoint joinPoint) {

    Movie movie = (Movie) joinPoint.getArgs()[0];

    SimpleMailMessage msg = new SimpleMailMessage();
    msg.setTo("_____@gmail.com");
    msg.setSubject("Email from Spring Boot - movie " + movie.getName() + " added");
    msg.setText("The movie has been successfully added.");

    javaMailSender.send(msg);
  }
}
