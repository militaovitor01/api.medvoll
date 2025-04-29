package med.voll.api.Adress;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressData(
        @NotBlank
        String street,

        @NotBlank
        String neighborhood,

        @NotBlank @Pattern(regexp = "\\d{8}")
        String postal_code,

        @NotBlank
        String city,

        @NotBlank
        String state,

        String number,
        String complement
){
}
