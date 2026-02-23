package SGCE.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
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

    @Column(name = "file_number", nullable = false, unique = true)
    private String fileNumber;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "id_student", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_course", nullable = false)
    private Course course;

    public void changeStatus(EnrollmentStatus newStatus) {
        if (!this.status.canTransitionTo(newStatus)) {
            throw new IllegalArgumentException(
                    "Invalid transition from " + status + " to " + newStatus
            );
        }

        this.status = newStatus;
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
