package Service.Comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DTO.CommentDTO;
import Repository.Comment.ListRepository;

@Service
public class ListService {
	@Autowired
	private ListRepository listRepository;
	public void commentList(Model model) {
		List<CommentDTO> list = listRepository.list();
	
		model.addAttribute("lists" , list);
	
		
	}
}
