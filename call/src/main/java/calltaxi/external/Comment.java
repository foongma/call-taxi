package calltaxi.external;

import java.util.Date;
import lombok.Data;

@Data
public class Comment {

    private Long id;
    private Long callId;
    private String comment;
}
