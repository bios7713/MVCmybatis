package Service.Board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DTO.BoardDTO;
import Repository.Board.BoardListRepository;

@Service
public class BoardListService {
	@Autowired
	BoardListRepository boardListRepository;
	               
	public void boardList(Model model) {	
	
	
	    List<BoardDTO> boardDTO = boardListRepository.boardListSelect();

           System.out.println(boardDTO);
			
			model.addAttribute("boards",boardDTO );



		
		
	}




}
