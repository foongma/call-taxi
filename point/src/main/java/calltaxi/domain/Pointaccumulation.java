package calltaxi.domain;

import calltaxi.domain.*;
import calltaxi.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Pointaccumulation extends AbstractEvent {

    private Long id;
    private String userId;
    private Integer point;

    public Pointaccumulation(Point aggregate) {
        super(aggregate);
    }

    public Pointaccumulation() {
        super();
    }
}
