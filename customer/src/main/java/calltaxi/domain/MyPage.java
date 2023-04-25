package calltaxi.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MyPage_table")
@Data
public class MyPage {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long callId;
    private String userId;
    private String userLocation;
    private String destination;
    private String status;
    private String taxiNumber;
    private Integer point;
    private String comment;
    private Integer payment;
    private String payType;
}
