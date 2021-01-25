package com.kckunuku.tacos.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date createdAt;
    @NotNull
    @Size(min = 3, message = "Name cannot be null and should be minimum three characters long")
    private String name;

    @ManyToMany(targetEntity = Ingredient.class)
    @Size(min = 1, message = "Should choose atleast one ingredient")
    private List<Ingredient> ingredients;

    @PrePersist
    void createdAt () {
        this.createdAt = new Date();
    }
}
