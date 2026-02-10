package SGCE.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Entity
@Table(name = "students", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student", nullable = false)
    private Long idStudent;

    @Column(nullable = false, unique = true)
    private int dni;

    @Column(name = "student_name", nullable = false)
    private String studentName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments = new ArrayList<>();

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Student other)) return false;
        return idStudent != null && idStudent.equals(other.idStudent);
    }

    @Override
    public int hashCode() { return getClass().hashCode(); }
}