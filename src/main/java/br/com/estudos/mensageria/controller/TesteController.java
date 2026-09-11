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
    @GetMapping("/t3")
    public ResponseEntity<?> teste03(){
        return ResponseEntity.ok("Teste 03");
    }
    @GetMapping("/t4")
    public ResponseEntity<?> teste04(){
        return ResponseEntity.ok("Teste 04");
    }
    @GetMapping("/t5")
    public ResponseEntity<?> teste05(){
        return ResponseEntity.ok("Teste 05");
    }
}
