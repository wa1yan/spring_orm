package com.waiyanhtet.orm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.waiyanhtet.orm.config.StandaloneConfig;
import com.waiyanhtet.orm.entity.Course;
import com.waiyanhtet.orm.repo.CourseRepo;

@SpringJUnitConfig(classes = StandaloneConfig.class)
public class StandaloneJavaConfigTest {

	@Autowired
	private CourseRepo repo;
	
	@ParameterizedTest
	@CsvSource({
		"Java Basic, 4, 300000, 1"
	})
	void test(String name, int duration, int fees, int id) {
		var course = new Course(name, duration, fees);
		repo.create(course);
		
		assertEquals(id, course.getId());
	}
}
