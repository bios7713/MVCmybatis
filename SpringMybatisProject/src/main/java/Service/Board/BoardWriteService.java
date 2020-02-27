package Service.Board;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import Command.Board.BoardCommand;
import Controller.Encrypt;


import Model.DTO.BoardDTO;
import Repository.Board.BoardWriteRepository;

@Service
public class BoardWriteService {
	@Autowired
	BoardWriteRepository boardWriteRepository;
	
	public void insertBoard(BoardCommand boardCommand ,
			              HttpServletRequest request , HttpSession session) {		
		BoardDTO boardDTO = new BoardDTO();
		
		
		
		boardDTO.setUserId("101010");
		boardDTO.setBoardName(boardCommand.getBoardName());
		boardDTO.setBoardPass(Encrypt.getEncryption(boardCommand.getBoardPass()));
		boardDTO.setBoardSubject(boardCommand.getBoardSubject());
		boardDTO.setBoardContent(boardCommand.getBoardContent());
		boardDTO.setIpAddr(request.getRemoteAddr());
			
		boardWriteRepository.insertBoard(boardDTO);
		
		
	}
	
	

}
