package med.voll.api.Doctor;

public record DoctorDataList(
        Long id,
        String name,
        String email,
        String crm,
        Specialty specialty
){
    public DoctorDataList(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}
