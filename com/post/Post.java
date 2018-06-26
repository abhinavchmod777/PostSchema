package com.post;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Post 
{
	@Id
	@Column(name="post_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int postId;
	@Column(name="date_of_entry")
	private Date dateOfEntry;
	private String category;
	private String subject;
	private String description;

// MantToOne mapping to be established with the userAccount
	
	@OneToMany(mappedBy="post",cascade=CascadeType.ALL)
	private Set<Comment> comments = new HashSet<Comment>();

//-------------------------------------Getters And Setters---------------------------------------//
	public int getPostId() {
		return postId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public Date getDateOfEntry() {
		return dateOfEntry;
	}

	public void setDateOfEntry(Date dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		List<Integer> com = new ArrayList<Integer>();
		for(Comment r:comments)
			com.add(r.getCommentId());
		
		return "Post [" + postId + ", " + dateOfEntry + ", " + category + ", "+ subject + ", CommentIDs=" + com + "]";
	}
	
	
}
