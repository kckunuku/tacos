package com.kckunuku.tacos.domain;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class Taco {
    @NotNull
    @Size(min = 3, message = "Name cannot be null and should be minimum three characters long")
    private String name;
    @Size(min = 1, message = "Should choose atleast one ingredient")
    private List<String> ingredients;
}
