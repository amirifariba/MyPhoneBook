package Daoes;

import java.util.HashSet;
import java.util.Set;

import Entities.ContactEntity;
import Entities.Feature;
import Entities.RoleEntity;
import Entities.UserEntity;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ContactDao dao = new ContactDao();
		// dao.save(new

		UserDao dao = new UserDao();
	
	System.out.println(dao.validateUser("fariba", "1234").getRole().getRoleName());
		
		//System.out.println(	dao.validateUser("fariba", "123456"));

	}

}
