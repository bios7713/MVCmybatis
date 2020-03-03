package Service.Comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DTO.CommentDTO;
import Model.DTO.CommentReplysDTO;
import Model.DTO.MemberDTO;
import Repository.Comment.ListRepository;

@Service
public class UserService {
	@Autowired
	private ListRepository listRepository;
		public void user(Long commentNo,Model model) {
	 		MemberDTO dto =  listRepository.user(commentNo);                  //1:1
			CommentReplysDTO replies =  listRepository.replies(commentNo); // 1:n
		   model.addAttribute("users", dto );
		   model.addAttribute("replies" , replies);
		}
	


}
