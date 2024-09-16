package einstein.com.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Posts")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id") // Nome da coluna deve corresponder ao da tabela
    private UserEntity user;

    @Column(name = "data")
    private String data;

    @Column(name = "time")
    private Date time;

    public PostEntity() {}

    public PostEntity(UserEntity user, String data, Date time) {
        this.user = user;
        this.data = data;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id = " + id +
                ", user = \'" + user + "\'" +
                ", data = \'" + data + "\'" +
                ", time = \'" + time + "\'" +
                ",}";
    }
}