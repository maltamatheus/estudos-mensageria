package br.com.estudos.mensageria.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testes")
public class TesteController {

    @GetMapping("/t1")
    public ResponseEntity<?> teste01(){
        return ResponseEntity.ok("Teste 01");
    }
    @GetMapping("/t2")
    public ResponseEntity<?> teste02(){
        return ResponseEntity.ok("Teste 02");
    }
}
