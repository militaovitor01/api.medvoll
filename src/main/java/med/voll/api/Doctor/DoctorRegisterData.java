package med.voll.api.Doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.Adress.AddressData;

public record DoctorRegisterData(
        @NotBlank
        String name,

        @NotBlank @Email
        String email,

        @NotBlank
        String telephone_number,

        @NotBlank @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        Specialty specialty,

        @NotNull @Valid
        AddressData address
){
}
