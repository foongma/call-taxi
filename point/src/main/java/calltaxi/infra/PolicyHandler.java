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

    @Autowired
    PointRepository pointRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Paymented'"
    )
    public void wheneverPaymented_PointAccumulation(
        @Payload Paymented paymented
    ) {
        Paymented event = paymented;
        System.out.println(
            "\n\n##### listener PointAccumulation : " + paymented + "\n\n"
        );

        // Sample Logic //
        Point.pointAccumulation(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Canceled'"
    )
    public void wheneverCanceled_PointReduction(@Payload Canceled canceled) {
        Canceled event = canceled;
        System.out.println(
            "\n\n##### listener PointReduction : " + canceled + "\n\n"
        );

        // Sample Logic //
        Point.pointReduction(event);
    }
}
