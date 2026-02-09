package SGCE.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "enrollments", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id_student", "id_course", "file_number"})
})
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_enrollment", nullable = false)
    private Long idEnrollment;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EnrollmentStatus status;

    @Column(nullable = false)
    private LocalDate date;

    @Column(name = "file_number", nullable = false, unique = true)
    private int fileNumber;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "id_student", nullable = false, unique = true)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_course", nullable = false, unique = true)
    private Course course;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Enrollment other)) return false;
        return idEnrollment != null && idEnrollment.equals(other.idEnrollment);
    }

    @Override
    public int hashCode() { return getClass().hashCode(); }
}
