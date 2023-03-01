package sn.isi.GEmploi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "appuser")
@Data
public class AppUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "firsname", length = 200)
    private String firsName;
    @Column (name = "lastname", length = 150)
    private String lastName;
    @Column (name = "email", length = 200, unique = true)
    private String email;
    @Column (name = "password", length = 200)
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    List<AppRoleEntity> roles = new ArrayList<AppRoleEntity>();
}
