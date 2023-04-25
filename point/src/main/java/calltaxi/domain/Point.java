package calltaxi.domain;

import calltaxi.PointApplication;
import calltaxi.domain.Pointaccumulation;
import calltaxi.domain.Pointreduction;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Point_table")
@Data
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private Integer point;

    @PostPersist
    public void onPostPersist() {
        Pointaccumulation pointaccumulation = new Pointaccumulation(this);
        pointaccumulation.publishAfterCommit();

        Pointreduction pointreduction = new Pointreduction(this);
        pointreduction.publishAfterCommit();
    }

    public static PointRepository repository() {
        PointRepository pointRepository = PointApplication.applicationContext.getBean(
            PointRepository.class
        );
        return pointRepository;
    }

    public static void pointAccumulation(Paymented paymented) {
        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        */

        /** Example 2:  finding and process
        
        repository().findById(paymented.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);


         });
        */

    }

    public static void pointReduction(Canceled canceled) {
        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        */

        /** Example 2:  finding and process
        
        repository().findById(canceled.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);


         });
        */

    }
}
