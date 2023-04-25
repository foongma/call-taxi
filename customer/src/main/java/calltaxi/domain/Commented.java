package calltaxi.domain;

import calltaxi.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class Commented extends AbstractEvent {

    private Long id;
    private String userId;
    private String userlocation;
    private String destination;
    private String payType;
    private String comment;
}
