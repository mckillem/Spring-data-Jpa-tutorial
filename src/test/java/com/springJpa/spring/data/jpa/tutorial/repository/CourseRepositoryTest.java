package com.springJpa.spring.data.jpa.tutorial.repository;

import com.springJpa.spring.data.jpa.tutorial.entity.Course;
import com.springJpa.spring.data.jpa.tutorial.entity.Student;
import com.springJpa.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

	@Autowired
	CourseRepository courseRepository;

	@Test
	public void printCourses() {
		List<Course> courses = courseRepository.findAll();
		System.out.println(courses);
	}

	@Test
	public void saveCourseWithTeacher() {

		Teacher teacher = Teacher
				.builder()
				.firstName("Hoko")
				.lastName("Koko")
				.build();

		Course course = Course
				.builder()
				.title("C++")
				.credit(23)
				.teacher(teacher)
				.build();

		courseRepository.save(course);
	}

	@Test
	public void findAllPagination() {
		Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
		Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

		List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();

		long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
		long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

		System.out.println("total elements: " + totalElements);
		System.out.println("total pages: " + totalPages);
		System.out.println(courses);
	}

	@Test
	public void findAllSorting() {

		Pageable sortByTitle = PageRequest.of(0 ,2, Sort.by("title"));
		Pageable sortByCreditDesc = PageRequest.of(0 ,2, Sort.by("credit").descending());
		Pageable sortByTitleAndCreditDesc = PageRequest.of(0 ,2, Sort.by("title").descending().and(Sort.by("credit")));

		List<Course> courses = courseRepository.findAll(sortByTitle).getContent();

		System.out.println(courses);
	}

	@Test
	public void printFindByTitleContaining() {

		Pageable firstPageTenRecords = PageRequest.of(0, 10);

		List<Course> courses = courseRepository.findByTitleContaining("C", firstPageTenRecords).getContent();

		System.out.println(courses);
	}

	@Test
	public void saveCourseWithStudentAndTeacher() {

		Teacher teacher = Teacher
				.builder()
				.firstName("Jeb")
				.lastName("Jebanec")
				.build();

		Student student = Student
				.builder()
				.firstName("Dick")
				.lastName("Cockson")
				.emailId("jebozmrd@vpici.je")
				.build();

		Course course = Course
				.builder()
				.title("Al")
				.credit(12)
				.teacher(teacher)
				.build();

		course.addStudents(student);

		courseRepository.save(course);
	}
}