package com.springJpa.spring.data.jpa.tutorial.repository;

import com.springJpa.spring.data.jpa.tutorial.entity.Guardian;
import com.springJpa.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void saveStudent() {
		Student student = Student
				.builder()
				.emailId("student@email.com")
				.firstName("Šprt")
				.lastName("Šprtovič")
//				.guardianName("Foster")
//				.guardianEmail("blb@blb.com")
//				.guardianMobile("123456789")
				.build();

		studentRepository.save(student);
	}

	@Test
	public void saveStudentWithGuardian() {

		Guardian guardian = Guardian
				.builder()
				.name("Foster")
				.email("blb@blb.com")
				.mobile("123456789")
				.build();

		Student student = Student
				.builder()
				.emailId("studenten@email.com")
				.firstName("Šprtič")
				.lastName("Šprtovičovksij")
				.guardian(guardian)
				.build();

		studentRepository.save(student);
	}

	@Test
	public void printAllStudent() {
		List<Student> studentsList = studentRepository.findAll();
		System.out.println("studentlist = " + studentsList);
	}

	@Test
	public void printStudentByFirstName() {
		List<Student> students = studentRepository.findByFirstName("Šprtič");
		System.out.println("students = " + students);
	}

	@Test
	public void printStudentByFirstNameContaining() {
		List<Student> students = studentRepository.findByFirstNameContaining("sp");
		System.out.println("students = " + students);
	}

	@Test
	public void printStudentBasedOnGuardianName() {
		List<Student> students = studentRepository.findByGuardianName("Foster");
		System.out.println("students = " + students);
	}

	@Test
	public void printGetStudentByEmailAddress() {
		Student student = studentRepository.getStudentByEmailAddress("student@email.com");
		System.out.println(student);
	}

	@Test
	public void printGetStudentFirstNameByEmailAddress() {
		String firstName = studentRepository.getStudentFirstNAmeByEmailAddress("student@email.com");
		System.out.println(firstName);
	}

	@Test
	public void printGetStudentByEmailAddressNative() {
		Student student = studentRepository.getStudentByEmailAddressNative("student@email.com");
		System.out.println(student);
	}

	@Test
	public void printGetStudentByEmailAddressNativeNamedParam() {
		Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("student@email.com");
		System.out.println(student);
	}

	@Test
	public void updateStudentNameByEmailIdTest() {
		studentRepository.updateStudentNameByEmailId("Změněn", "student@email.com");
	}
}