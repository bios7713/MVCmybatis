package Repository.Board;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import Model.DTO.BoardDTO;


@Repository
public class BoardDetailRepository {
	@Autowired
	SqlSession sqlSession;
	private final String namespace= "boardMapper";
	
	public BoardDTO selectBoardNum(Integer boardNum) {
		String statement = namespace + ".boardInsert";
		BoardDTO d = sqlSession.selectOne(statement,boardNum);
		
		return d;
		
		
	}

}
