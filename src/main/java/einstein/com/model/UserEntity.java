package einstein.com.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    public UserEntity() {}

    UserEntity(String name , String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String toString() {
        return name;
    }
}

