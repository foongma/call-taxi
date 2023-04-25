package calltaxi.domain;

import calltaxi.domain.*;
import calltaxi.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Pointreduction extends AbstractEvent {

    private Long id;
    private String userId;
    private Integer point;

    public Pointreduction(Point aggregate) {
        super(aggregate);
    }

    public Pointreduction() {
        super();
    }
}
