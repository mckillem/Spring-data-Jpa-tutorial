package com.springJpa.spring.data.jpa.tutorial.repository;

import com.springJpa.spring.data.jpa.tutorial.entity.Course;
import com.springJpa.spring.data.jpa.tutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

	@Autowired
	private CourseMaterialRepository courseMaterialRepository;

	@Test
	public void saveCourseMaterial() {

		Course course = Course
				.builder()
				.title("O hovně")
				.credit(45)
				.build();

		CourseMaterial courseMaterial = CourseMaterial
				.builder()
				.url("bbb.hovno.shit")
				.course(course)
				.build();

		courseMaterialRepository.save(courseMaterial);
	}

	@Test
	public void printAllCourseMaterial() {
		List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
		System.out.println(courseMaterials);
	}
}