package Service.Comment;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.DTO.AuthInfo;
import Model.DTO.CommentDTO;
import Model.DTO.ReplyDTO;
import Repository.Comment.InsertCommentRepository;

@Service
public class InsertService {
	@Autowired
	InsertCommentRepository insertCommentRepository;
		
	public void commentInsert(String commentSubject,String commentContent,HttpSession session) {
		String userId= ((AuthInfo)session.getAttribute("authInfo")).getId();
		
		CommentDTO  CDTO = new CommentDTO(null,userId,null,
																		commentContent,commentSubject);
		insertCommentRepository.commentInsert(CDTO);
	}
	
	public void replyInsert(String cuserId, Long commentNo, String replyContent,HttpSession session) {
		ReplyDTO reDTO = new ReplyDTO();
		reDTO.setCommentNo(commentNo);
		reDTO.setCuserId(cuserId);
		reDTO.setReplyContent(replyContent);
		String ruserId = ((AuthInfo)session.getAttribute("authInfo")).getId();
		reDTO.setRuserId(ruserId);
		
		insertCommentRepository.replyInsert(reDTO);
	
	}

}
