package com.post;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Delete 
{
	public static void main(String[] args) 
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(Post.class).addAnnotatedClass(Comment.class).addAnnotatedClass(Reply.class);
		SessionFactory sessionFactory = con.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try
		{
			transaction=session.beginTransaction();

			//-----------------------deleting reply object---------------------------//	
			session.delete(session.get(Reply.class, 2));
			System.out.println("1st done");

			//------------------------deleting post object-------------------------//
			session.delete(session.get(Post.class, 1));
			System.out.println("2nd done");
		}
		catch(Exception e)
		{
			transaction.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
			sessionFactory.close();
		}

	}

}
