package chr.springjpaxml.repository;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import chr.springjpaxml.entities.Pet;
@Repository(value = "petDao")
public class JpaPetDao implements PetDao {
	
	private EntityManager em =null;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
	        this.em = em;
	    }
	
	@Override
	@Transactional(readOnly = true)
    
	public List<Pet> getPets() {
		
	
		return em.createQuery("from Pet").getResultList();
	}

}
