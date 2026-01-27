package SGCE.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "courses")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private Long idCourse;
    @Column(name = "course_name", nullable = false)
    private String courseName;
    private String description;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enrollment> enrollments;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Course other)) return false;
        return idCourse != null && idCourse.equals(other.idCourse);
    }

    @Override
    public int hashCode() { return getClass().hashCode(); }
}