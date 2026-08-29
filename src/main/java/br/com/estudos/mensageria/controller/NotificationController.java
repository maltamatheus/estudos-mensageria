package br.com.estudos.mensageria.controller;

import br.com.estudos.mensageria.model.Mensagem;
import br.com.estudos.mensageria.service.SnsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifica")
@AllArgsConstructor
public class NotificationController {

    private SnsService service;

    @PostMapping("/envia-msg")
    public ResponseEntity<String> enviaInfo(@RequestBody Mensagem msg){
        return ResponseEntity.ok(service.sendNotification(msg));
    }
}
