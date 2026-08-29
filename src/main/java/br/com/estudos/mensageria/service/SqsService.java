package br.com.estudos.mensageria.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.DeleteMessageRequest;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SqsService {

    @Value("${aws.region-name}")
    private String region;
    public List<String> lendoMensagem(String urlQueue){
        log.info("Iniciando processo de consumo de mensagens");

        List<String> mensagens = new ArrayList<>();

        List<Message> messages = new ArrayList<>();

        SqsClient sqsClient = SqsClient.builder().region(Region.of(region))
                                                .build();

            ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder()
                    .queueUrl(urlQueue)
                    .maxNumberOfMessages(5)
                    .waitTimeSeconds(5)
                    .build();

            messages = sqsClient.receiveMessage(receiveMessageRequest).messages();

            for (Message message : messages) {
                log.info("Lendo mensagem");

                // Processa o conteúdo da mensagem
                System.out.println("Mensagem Recebida: "  + message.body());

                mensagens.add(message.body());

                //Apaga a mensagem na fila após o processamento
                DeleteMessageRequest deleteMessageRequest = DeleteMessageRequest.builder()
                                                                .queueUrl(urlQueue)
                                                                .receiptHandle(message.receiptHandle())
                                                                .build();

                sqsClient.deleteMessage(deleteMessageRequest);

                System.out.println("Mensagem Deletada");
            }
        return mensagens;
    }
}
