package chr.springjpaxml.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import chr.springjpaxml.entities.User;
@Repository(value = "UserDao")
public class UserDaoImp implements UserDao{

	private EntityManager em = null;
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
	        this.em = em;
	    }
	@Override
	@Transactional
	public List<User> getByUsername(String username) {
		System.out.print("username: "+ username);
		List<User> users = em.createQuery("from User", User.class)
				.getResultList();
		System.out.println(users.get(0).getUsername());
		return users;
		/*return   em.createQuery("from User WHERE username = :username", User.class)
				.setParameter("username", username)
				.getResultList();*/
		
		
	}

}
