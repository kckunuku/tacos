package com.kckunuku.tacos.domain;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

@Data
public class Order {
    @NotBlank(message = "name cannot be left blank")
    private String name;
    @NotBlank(message = "street cannot be left blank")
    private String street;
    @NotBlank(message = "city cannot be left blank")
    private String city;
    @NotBlank(message = "state cannot be left blank")
    private String state;
    @NotBlank(message = "zip canot be left blank")
    private String zip;
    @CreditCardNumber(message = "Invalid credit card number")
    private String ccNumber;
    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="Must be formatted MM/YY")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "Not a valid CVV")
    private String ccVV;
}
