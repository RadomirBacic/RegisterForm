package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.UserDetails;

public class RegisterDao {

	SessionFactory sf = HibernateUtil.createSessionFactory();
	


	public boolean saveUserDetailsInDataBase(UserDetails userDetails) {
		
		Session session = sf.openSession();
		
		session.beginTransaction();
			try {
				session.save(userDetails);
				
				session.getTransaction().commit();
				System.out.println("User details with name: " + userDetails.getFirstName() + " " + userDetails.getLastName() + "is saved in data base");
				return true;
			} catch (Exception e) {
				
				session.getTransaction().rollback();
				System.out.println("Error,user details with name: " + userDetails.getFirstName() + " " + userDetails.getLastName() + "is not saved in data base" );
				return false;
			}finally {
				session.close();
			}
		
	}
	
	

}
