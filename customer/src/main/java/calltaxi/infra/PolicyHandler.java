package calltaxi.infra;

import calltaxi.config.kafka.KafkaProcessor;
import calltaxi.domain.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Accepted'"
    )
    public void wheneverAccepted_UserNotification(@Payload Accepted accepted) {
        Accepted event = accepted;
        System.out.println(
            "\n\n##### listener UserNotification : " + accepted + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Departured'"
    )
    public void wheneverDepartured_UserNotification(
        @Payload Departured departured
    ) {
        Departured event = departured;
        System.out.println(
            "\n\n##### listener UserNotification : " + departured + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Boardinged'"
    )
    public void wheneverBoardinged_UserNotification(
        @Payload Boardinged boardinged
    ) {
        Boardinged event = boardinged;
        System.out.println(
            "\n\n##### listener UserNotification : " + boardinged + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Arrivaled'"
    )
    public void wheneverArrivaled_UserNotification(
        @Payload Arrivaled arrivaled
    ) {
        Arrivaled event = arrivaled;
        System.out.println(
            "\n\n##### listener UserNotification : " + arrivaled + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Paymented'"
    )
    public void wheneverPaymented_UserNotification(
        @Payload Paymented paymented
    ) {
        Paymented event = paymented;
        System.out.println(
            "\n\n##### listener UserNotification : " + paymented + "\n\n"
        );
        // Sample Logic //

    }
}
