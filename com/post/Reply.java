package com.post;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reply 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="reply_id")
	private int replyId;
	@Column(name="date_of_entry")
	private Date dateOfEntry;
	private String Description;
	
	//manyToOne mapping to be established with userAccount
	
	@ManyToOne
	@JoinColumn(name="COMMENT_ID",nullable=true)
	private Comment comment;

	//------------------------------------Getters and Setters--------------------------------//
	
	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
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

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	//---------------------------------toString()-----------------------------//
	@Override
	public String toString() {
		return "Reply[" + replyId + "," + dateOfEntry + "," + Description + ",commentID=" + comment.getCommentId() + "]";
	}


}
