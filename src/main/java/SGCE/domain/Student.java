package SGCE.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Entity
@Table(name = "students")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student", nullable = false)
    private Long idStudent;
    @Column(name = "student_name", nullable = false)
    private String studentName;
    @Column(unique = true, nullable = false)
    private String email;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enrollment> enrollments;

    public Student(String email, String studentName) {
        this.email = email;
        this.studentName = studentName;
        this.enrollments = new ArrayList<>();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Student other)) return false;
        return idStudent != null && idStudent.equals(other.idStudent);
    }

    @Override
    public int hashCode() { return getClass().hashCode(); }
}