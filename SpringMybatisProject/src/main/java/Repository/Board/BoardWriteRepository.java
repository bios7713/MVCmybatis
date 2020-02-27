package Repository.Board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import Model.DTO.BoardDTO;


@Repository
public class BoardWriteRepository {
	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace= "boardMapper";
	public Integer insertBoard(BoardDTO dto) {
		String statement = namespace + ".boardInsert";
		
		//BoardDTO d = sqlSession.selectOne(statement,boardNum);
		//List<BoardDTO> aa = sqlSession.selectList(statement,null);
	 
       return sqlSession.insert(statement, dto);
	}

}
