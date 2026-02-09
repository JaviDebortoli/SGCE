package SGCE.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id_course", "code"})
})
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private Long idCourse;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(nullable = false)
    private String description;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments = new ArrayList<>();

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Course other)) return false;
        return idCourse != null && idCourse.equals(other.idCourse);
    }

    @Override
    public int hashCode() { return getClass().hashCode(); }
}