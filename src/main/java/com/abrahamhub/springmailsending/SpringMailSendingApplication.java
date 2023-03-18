package com.abrahamhub.springmailsending;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class SpringMailSendingApplication {
    @Autowired
    private EmailSendService senderService;
    public static void main(String[] args) {
        SpringApplication.run(SpringMailSendingApplication.class, args);
    }
    @GetMapping("/json")
    public MyObject getMyObject() {
        MyObject myObject = new MyObject();
        myObject.img = "hola";
        return myObject;
    }
    @PostMapping (value = "/email")
    public void getEmail(@RequestBody requestData data) {
        sendMail(data.getEmail(), data.getName());
    }
    public void sendMail (String EmailV, String NameV ) {
        senderService.sendEmail(EmailV,"Hola "+NameV+" trabajemos juntos!!!👨🏻‍💻","Me presento soy Abraham Castañeda Quintero, un miembro proactivo de la humanidad y entusiasta de la tecnología con una vocación de servicio, además nunca parar de aprender.\uD83D\uDE80\uD83E\uDDE0\n" +
                "\n" +
                "Tengo una buena trayectoria en la rama de la informática y del desarrollo de software, desde los 15 años descubrí mi gusto y vocación por la misma.\n" +
                "\n" +
                "¿Quieres ver mi trabajo en GitHub? https://github.com/AbrahamHub \uD83D\uDE40\n" +
                "Vuelve a mi portafolio y descarga mi CV https://abraham.contact/ \uD83D\uDCC3\n" +
                "\n" +
                "Puedes responder a este correo y en poco tiempo contactaré contigo \uD83E\uDEE1");
    }
}
