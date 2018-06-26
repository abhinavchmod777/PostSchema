package com.post;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Retrieve 
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

		//-----------------------obtaining all Post table records---------------------------//	
			Query query1 = session.createQuery("from Post");
			List<Post> posts = (List<Post>)query1.list();
			Iterator<Post> it = posts.iterator();
			while(it.hasNext())
			{
				Post post = it.next();
				System.out.println(post);
			}

		//------------------------obtaining all Author table records-------------------------//
			Query query2 = session.createQuery("from Comment");
			List<Comment> comments = (List<Comment>)query2.list();
			Iterator<Comment> it2 = comments.iterator();
			while(it2.hasNext())
			{
				Comment comment = it2.next();
				System.out.println(comment);
			}
		
		//--------------------obtaining all reply table records-----------------------------//
			Query query3 = session.createQuery("from Reply");
			List<Reply> replies = (List<Reply>)query3.list();
			Iterator<Reply> it3 = replies.iterator();
			while(it3.hasNext())
			{
				Reply reply = it3.next();
				System.out.println(reply);
			}

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
