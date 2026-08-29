package br.com.estudos.mensageria.controller;

import br.com.estudos.mensageria.service.SqsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/consome")
public class ConsumerController {
    @Value("${aws.region-name}")
    private String regiao;
    @Value("${aws.user-name}")
    private String usuario;

    @Autowired
    private SqsService sqsService;

    @GetMapping("/fila/{nomeFila}")
    public ResponseEntity<List<String>> consomeMensagem(@PathVariable String nomeFila){
        String URL_QUEUE = "https://sqs."+regiao+".amazonaws.com/"+usuario+"/"+ nomeFila;
        return ResponseEntity.ok(sqsService.lendoMensagem(URL_QUEUE));
    }
}
