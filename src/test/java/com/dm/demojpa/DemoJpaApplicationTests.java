package com.dm.demojpa;

import com.dm.demojpa.entity.Student;
import com.dm.demojpa.repository.StudentRepository;
import org.junit.jupiter.api.Test;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;


@SpringBootTest(
		classes = DemoJpaApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT

)
@TestPropertySource(locations = "classpath:application.properties")
class DemoJpaApplicationTests {




	@Test
	void contextLoads() {
	}

}
