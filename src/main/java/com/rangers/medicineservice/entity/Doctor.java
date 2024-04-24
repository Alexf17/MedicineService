package com.rangers.medicineservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rangers.medicineservice.entity.enums.Specialization;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "doctor")
@NoArgsConstructor
@Getter
@Setter
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "doctor_id")
    private UUID doctorId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "specialization")
    private Specialization specialization;

    @Column(name = "rating")
    private String rating;

    //Relationships
//    @ManyToOne(mappedBy = "shedule")
//    @JsonIgnore
//    private List<Shedule> sheduleList;
//test
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(doctorId, doctor.doctorId) && Objects.equals(firstName, doctor.firstName) && Objects.equals(lastName, doctor.lastName) && Objects.equals(specialization, doctor.specialization) && Objects.equals(rating, doctor.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorId, firstName, lastName, specialization, rating);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialization='" + specialization + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
