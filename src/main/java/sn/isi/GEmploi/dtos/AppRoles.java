package sn.isi.GEmploi.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data

public class AppRoles  {
    private int id;
    @NotNull(message = "name is required ")
    private String name;
}
