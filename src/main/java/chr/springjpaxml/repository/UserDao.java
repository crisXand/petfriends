package chr.springjpaxml.repository;

import java.util.List;

import chr.springjpaxml.entities.User;

public interface UserDao {
	public List<User> getByUsername(String username);
}
