package com.rangers.medicineservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "prescriptions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "prescription_id")
    private UUID prescriptionId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "exp_date")
    private LocalDate expDate;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id")
    private Doctor doctor;

    //    to do!!!
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "medicines_prescriptions",
            joinColumns = @JoinColumn(name = "medicine_id"),
            inverseJoinColumns = @JoinColumn(name = "prescription_id"))
    private List<Medicine> medicines;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prescription prescription = (Prescription) o;
        return isActive == prescription.isActive && Objects.equals(prescriptionId, prescription.prescriptionId) && Objects.equals(quantity, prescription.quantity) && Objects.equals(expDate, prescription.expDate) && Objects.equals(createdAt, prescription.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prescriptionId, quantity, expDate, createdAt, isActive);
    }

    @Override
    public String toString() {
        return "Recept{" +
                "receptId=" + prescriptionId +
                ", quantity=" + quantity +
                ", expDate=" + expDate +
                ", createdAt=" + createdAt +
                ", isActive=" + isActive +
                ", doctor=" + doctor +
                ", madicine=" + medicines +
                ", user=" + user +
                '}';
    }
}
