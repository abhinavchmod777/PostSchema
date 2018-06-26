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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Comment 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="comment_id")
	private int commentId;
	@Column(name="date_of_entry")
	private Date dateOfEntry;
	private String Description;
	
	//manyToOne mapping to be established with userAccount
	
	@ManyToOne
	@JoinColumn(name="POST_ID",nullable=true)
	private Post post;
	
	@OneToMany(mappedBy="comment",cascade=CascadeType.ALL)
	private Set<Reply> replies = new HashSet<Reply>();

//-----------------------------getters and setters-------------------------------------//
	
	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public Date getDateOfEntry() {
		return dateOfEntry;
	}

	public void setDateOfEntry(Date dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Set<Reply> getReplies() {
		return replies;
	}

	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}

//------------------------------toString()-----------------------------------------//
	@Override
	public String toString() {
		List<Integer> rep = new ArrayList<Integer>();
		for(Reply r:replies)
			rep.add(r.getReplyId());
		return "Comment [" + commentId + ", " + dateOfEntry + ", " + Description
				+ ", postID=" + post.getPostId() + ", repliesIDs=" + rep + "]";
	}

	
}
