package com.springJpa.spring.data.jpa.tutorial.repository;

import com.springJpa.spring.data.jpa.tutorial.entity.Course;
import com.springJpa.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {

	@Autowired
	private TeacherRepository teacherRepository;

	@Test
	public void saveTeacher() {

		Course courseJava = Course
				.builder()
				.title("Java")
				.credit(20)
				.build();

		Course courseC = Course
				.builder()
				.title("C")
				.credit(20)
				.build();

		Teacher teacher = Teacher
				.builder()
				.firstName("Jan")
				.lastName("Janěk")
//				.courses(List.of(courseJava, courseC))
				.build();

		teacherRepository.save(teacher);
	}
}