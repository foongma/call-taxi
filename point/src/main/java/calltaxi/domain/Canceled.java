package calltaxi.domain;

import calltaxi.domain.*;
import calltaxi.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Canceled extends AbstractEvent {

    private Long id;
    private String userId;
    private String userlocation;
    private String destination;
    private String payType;
    private String comment;
}
