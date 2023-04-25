package calltaxi.infra;

import calltaxi.config.kafka.KafkaProcessor;
import calltaxi.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class MyPageViewHandler {

    @Autowired
    private MyPageRepository myPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCalled_then_CREATE_1(@Payload Called called) {
        try {
            if (!called.validate()) return;

            // view 객체 생성
            MyPage myPage = new MyPage();
            // view 객체에 이벤트의 Value 를 set 함
            myPage.setCallId(called.getId());
            myPage.setUserId(called.getUserId());
            myPage.setUserLocation(called.getUserlocation());
            myPage.setDestination(called.getDestination());
            myPage.setStatus("호출");
            myPage.setPayType(called.getPayType());
            // view 레파지 토리에 save
            myPageRepository.save(myPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenAccepted_then_UPDATE_1(@Payload Accepted accepted) {
        try {
            if (!accepted.validate()) return;
            // view 객체 조회

            List<MyPage> myPageList = myPageRepository.findByCallId(
                accepted.getCallId()
            );
            for (MyPage myPage : myPageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setTaxiNumber(accepted.getNumber());
                myPage.setStatus(accepted.getStatus());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDepartured_then_UPDATE_2(@Payload Departured departured) {
        try {
            if (!departured.validate()) return;
            // view 객체 조회

            List<MyPage> myPageList = myPageRepository.findByCallId(
                departured.getCallId()
            );
            for (MyPage myPage : myPageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setStatus(departured.getStatus());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBoardinged_then_UPDATE_3(@Payload Boardinged boardinged) {
        try {
            if (!boardinged.validate()) return;
            // view 객체 조회

            List<MyPage> myPageList = myPageRepository.findByCallId(
                boardinged.getCallId()
            );
            for (MyPage myPage : myPageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setStatus(boardinged.getStatus());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenArrivaled_then_UPDATE_4(@Payload Arrivaled arrivaled) {
        try {
            if (!arrivaled.validate()) return;
            // view 객체 조회

            List<MyPage> myPageList = myPageRepository.findByCallId(
                arrivaled.getCallId()
            );
            for (MyPage myPage : myPageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setStatus(arrivaled.getStatus());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymented_then_UPDATE_5(@Payload Paymented paymented) {
        try {
            if (!paymented.validate()) return;
            // view 객체 조회

            List<MyPage> myPageList = myPageRepository.findByCallId(
                paymented.getCallId()
            );
            for (MyPage myPage : myPageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setPayment(paymented.getPayment());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPointaccumulation_then_UPDATE_6(
        @Payload Pointaccumulation pointaccumulation
    ) {
        try {
            if (!pointaccumulation.validate()) return;
            // view 객체 조회

            List<MyPage> myPageList = myPageRepository.findByUserId(
                pointaccumulation.getUserId()
            );
            for (MyPage myPage : myPageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setPoint(pointaccumulation.getPoint());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCommented_then_UPDATE_7(@Payload Commented commented) {
        try {
            if (!commented.validate()) return;
            // view 객체 조회

            List<MyPage> myPageList = myPageRepository.findByCallId(
                commented.getId()
            );
            for (MyPage myPage : myPageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setComment(commented.getComment());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
