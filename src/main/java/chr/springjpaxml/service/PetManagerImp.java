package chr.springjpaxml.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import chr.springjpaxml.entities.Pet;
import chr.springjpaxml.repository.PetDao;

@Component
public class PetManagerImp implements PetManager {
	@Autowired
	private PetDao petdao;

	@Override
	public List<Pet> getPets() {
		// TODO Auto-generated method stub
		return petdao.getPets();
	}
	
	 
}
