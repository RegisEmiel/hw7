package ru.geekbrains.hw7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.hw7.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
