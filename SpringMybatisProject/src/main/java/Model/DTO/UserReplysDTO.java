package Model.DTO;

import java.io.Serializable;
import java.util.List;
@SuppressWarnings("serial")
public class UserReplysDTO implements Serializable{
	
	MemberDTO memberDTO;   //1
	List<ReplyDTO>  replies;    // n
	
	
	
	public MemberDTO getMemberDTO() {
		return memberDTO;
	}
	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}
	public List<ReplyDTO> getReplies() {
		return replies;
	}
	public void setRplies(List<ReplyDTO> replies) {
		this.replies = replies;
	}	
}
