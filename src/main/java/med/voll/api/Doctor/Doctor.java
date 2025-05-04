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
    private Boolean active = false;
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
        this.active = true;
        this.telephone_number = data.telephone_number();
        this.crm = data.crm();
        this.specialty = data.specialty();
        this.adress = new Address(data.address());
    }

    public void updateData(DoctorUpdateList data) {
        if (data.name() != null){
            this.name = data.name();
        }

        if (data.telephone_number() != null){
            this.telephone_number = data.telephone_number();
        }

        if (data.address() != null){
            this.adress.updateAddressData(data.address());
        }
    }

    public void delete() {
        this.active = false;
    }

}
