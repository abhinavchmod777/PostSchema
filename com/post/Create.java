package com.post;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Create 
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

			DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
			
			Post post1 = new Post();
			post1.setCategory("Builder");
			post1.setDateOfEntry(df.parse("12/23/2017"));
			post1.setDescription("Contents of the post");
			post1.setSubject("Selling a 2bhk flat");
		
			Comment comment1 = new Comment();
			comment1.setDateOfEntry(df.parse("06/29/2017"));
			comment1.setDescription("Comment contentss");

			Comment comment2 = new Comment();
			comment2.setDateOfEntry(df.parse("05/23/2017"));
			comment2.setDescription("Comment contentss");

			Reply reply1 = new Reply();
			reply1.setDateOfEntry(df.parse("02/12/2017"));
			reply1.setDescription("Reply contents here");
			
			Reply reply2 = new Reply();
			reply2.setDateOfEntry(df.parse("04/12/2017"));
			reply2.setDescription("Reply contents here");
			
			Reply reply3 = new Reply();
			reply3.setDateOfEntry(df.parse("11/03/2017"));
			reply3.setDescription("Reply contents here");
			
			//--------------------mapping setting
			post1.getComments().add(comment1);
			post1.getComments().add(comment2);
			comment1.setPost(post1);
			comment2.setPost(post1);
			comment1.getReplies().add(reply1);
			comment2.getReplies().add(reply2);
			comment2.getReplies().add(reply3);
			reply1.setComment(comment1);
			reply2.setComment(comment2);
			reply3.setComment(comment2);
			
			//---------------------saving objects
			session.save(post1);
			session.save(comment2);
			session.save(comment1);
			session.save(reply1);
			session.save(reply2);
			session.save(reply3);
			transaction.commit();
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
