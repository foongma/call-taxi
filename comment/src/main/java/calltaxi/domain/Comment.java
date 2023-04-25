package calltaxi.domain;

import calltaxi.CommentApplication;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Comment_table")
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long callId;

    private String comment;

    @PostPersist
    public void onPostPersist() {}

    public static CommentRepository repository() {
        CommentRepository commentRepository = CommentApplication.applicationContext.getBean(
            CommentRepository.class
        );
        return commentRepository;
    }
}
