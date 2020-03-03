package Model.DTO;

import java.io.Serializable;
import java.sql.Timestamp;

@SuppressWarnings("serial")
public class CommentDTO implements Serializable{


	private Long commentNo;
	private String cuserId;
	private Timestamp regDate;
	private String commentContent;
	private String commentSubject;
	
	public CommentDTO() {}
	public CommentDTO(Long commentNo, String cuserId, Timestamp regDate, String commentContent, String commentSubject) {

		this.commentNo = commentNo;
		this.cuserId = cuserId;
		this.regDate = regDate;
		this.commentContent = commentContent;
		this.commentSubject = commentSubject;
	}

	public Long getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(Long commentNo) {
		this.commentNo = commentNo;
	}

	public String getCuserId() {
		return cuserId;
	}

	public void setCuserId(String cuserId) {
		this.cuserId = cuserId;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentSubject() {
		return commentSubject;
	}

	public void setCommentSubject(String commentSubject) {
		this.commentSubject = commentSubject;
	}


}
