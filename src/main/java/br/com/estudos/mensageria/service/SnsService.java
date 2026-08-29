package br.com.estudos.mensageria.service;

import br.com.estudos.mensageria.model.Mensagem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;

@Service
public class SnsService {
    private final SnsClient snsClient;
    private final String topicArn;

    public SnsService(SnsClient snsClient, @Value("${aws.sns.topicArn}") String topicArn){
        this.snsClient = snsClient;
        this.topicArn = topicArn;
    }

    public String sendNotification(Mensagem mensagem){
        PublishRequest publishRequest = PublishRequest.builder()
                .message(mensagem.mensagem())
                .subject(mensagem.assunto())
                .topicArn(topicArn)
                .build();
        return snsClient.publish(publishRequest).toString();
    }
}
