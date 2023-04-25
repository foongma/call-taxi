package calltaxi.domain;

import calltaxi.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class Pointaccumulation extends AbstractEvent {

    private Long id;
    private String userId;
    private Integer point;
}
