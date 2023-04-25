package calltaxi.domain;

import calltaxi.domain.*;
import calltaxi.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Boardinged extends AbstractEvent {

    private Long id;
    private Long callId;
    private String userlocation;
    private String destination;
    private String status;
    private String number;
    private String model;
    private String driverName;
    private String driverMobileNumber;
    private String paytype;
    private Integer payment;

    public Boardinged(Taxi aggregate) {
        super(aggregate);
    }

    public Boardinged() {
        super();
    }
}
