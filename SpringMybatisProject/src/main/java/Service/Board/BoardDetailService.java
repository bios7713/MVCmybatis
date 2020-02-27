package Service.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


import Model.DTO.BoardDTO;
import Repository.Board.BoardDetailRepository;

@Service
public class BoardDetailService {
	
 @Autowired
 BoardDetailRepository boardDetailRepository;
	
	public void boardDetail(Integer boardNum, Model model) {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setBoardNum(boardNum);
		boardDTO = boardDetailRepository.selectBoardNum(boardNum);
		model.addAttribute("boards" , boardDTO);
		
	}
}
