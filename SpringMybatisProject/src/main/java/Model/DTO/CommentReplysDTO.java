package Model.DTO;

import java.io.Serializable;
import java.util.List;
@SuppressWarnings("serial")
public class CommentReplysDTO  implements Serializable {
	
	private CommentDTO commentDTO;
	private List<ReplyDTO> replyList;
	
	
public CommentDTO getCommentDTO() {
		return commentDTO;
	}
	public void setCommentDTO(CommentDTO commentDTO) {
		this.commentDTO = commentDTO;
	}
	public List<ReplyDTO> getReplyList() {
		return replyList;
	}
	public void setReplyList(List<ReplyDTO> replyList) {
		this.replyList = replyList;
	}

}
