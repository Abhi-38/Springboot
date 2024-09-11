package com.abhi.prj;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.abhi.prj.entity.User;
import com.abhi.prj.repository.UserRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)          //coz by default in spring jpa test we use in mem-database but here we want to use real database
@Rollback(false)                                            //coz we want to commit all transactions
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	
	public void testCreateUser() {
		User user = new User();
		user.setEmail("hitler@gmail.com");
		user.setPassword("queen@9238");
		user.setFirstName("Alexa");
		user.setLastName("Hitler");
		
		User savedUser = repo.save(user);
		
		User existUser = entityManager.find(User.class, savedUser.getId());
		
		assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
	}//testCreateUser
	
	@Test
	public void testFindUserByEmail() {
		String email = "misstina83@gmail.com";
		
		User user = repo.findByEmail(email);
		
		assertThat(user).isNotNull();
	}
}//UserRepositoryTests
