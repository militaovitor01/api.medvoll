package med.voll.api.Doctor;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.Adress.Address;

@Table(name = "doctors")
@Entity(name = "Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String crm;
    private String telephone_number;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address adress;

    public Doctor(DoctorRegisterData data) {
        this.name = data.name();
        this.email = data.email();
        this.telephone_number = data.telephone_number();
        this.crm = data.crm();
        this.specialty = data.specialty();
        this.adress = new Address(data.address());
    }
}
