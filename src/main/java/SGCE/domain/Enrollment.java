package SGCE.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "enrollments", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id_student", "id_course"})
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
    private EnrollmentStatus status;
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_student", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_course", nullable = false)
    private Course course;

    public Enrollment(EnrollmentStatus status, LocalDate date, Student student, Course course) {
        this.student = student;
        this.course = course;
        this.status = status;
        this.date = date;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Enrollment other)) return false;
        return idEnrollment != null && idEnrollment.equals(other.idEnrollment);
    }

    @Override
    public int hashCode() { return getClass().hashCode(); }
}
