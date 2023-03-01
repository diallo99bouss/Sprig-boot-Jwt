package sn.isi.GEmploi.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "approle")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false, length = 200, unique = true)
    private String name;
    @ManyToMany(mappedBy = "roles")
    List<AppUserEntity> users = new ArrayList<AppUserEntity>();
}
