package RestClient;

import Entities.ContactEntity;
import Entities.Pojo;
import Entities.UserEntity;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContactClient con = new ContactClient();
		if (con.selectAll() == null) {
			return;
		}
		System.out.println(con.selectAll()[1].getContactName());
		System.out.println(con.selectAll().length);
		
		
		//UserClient con = new UserClient();
		//System.out.println(con.validateUser("fariba","1234"));
		//System.out.println(con.selectOne(46).getPassword());
		//con.Save(new UserEntity("shadi","67541234"));

		//con.Update(12, poj);
		 //ContactEntity contact = new ;
		// System.out.println("last name is "+ contact.getContactLastName());
		// Pojo poj = new ContactEntity("zahra", "amiri", "08634776600",
		// "09186245039", "f.amiri882@gmail.com");
		// con.validateUser(new UserEntity("fariba","67541234"));
		//System.out.println(con.selectOne(12).getUserName());
		//System.out.println("role is :"+con.validateUser("fariba","67541234").getRoleId());

	}

}
