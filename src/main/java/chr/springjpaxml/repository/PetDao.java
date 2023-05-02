package chr.springjpaxml.repository;

import java.util.List;

import chr.springjpaxml.entities.Pet;

public interface PetDao {
	
	public List<Pet> getPets();
}
