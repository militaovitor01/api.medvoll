package med.voll.api.Doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.voll.api.Adress.AddressData;

public record DoctorUpdateList(
        @NotNull
        Long id,
        String name,
        String telephone_number,
        @Valid
        AddressData address
){
}
