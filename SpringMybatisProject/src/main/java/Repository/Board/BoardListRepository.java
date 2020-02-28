package Repository.Board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.DTO.BoardDTO;

@Repository
public class BoardListRepository {
	@Autowired
	private SqlSession sqlSession;

	private final String namespace= "mappers.boardList";
	public List<BoardDTO> boardListSelect() {
		String statement = namespace+".listBoard";
		
			List<BoardDTO> lists =	sqlSession.selectList(statement,null);

		return lists;
	}

}
