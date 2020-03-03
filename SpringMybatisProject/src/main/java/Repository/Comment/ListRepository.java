package Repository.Comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.DTO.CommentDTO;
import Model.DTO.CommentReplysDTO;
import Model.DTO.MemberDTO;

@Repository
public class ListRepository {
	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "Repository.Mapper.CommentDynamicMapper";
	public  MemberDTO user(Long commentNo) {
		String statement = namespace+ ".commentAssociation";

			return sqlSession.selectOne(statement,commentNo);
		
	}	
	
	//1:n = collection;
	public CommentReplysDTO replies(Long commentNo) {
		String statement = namespace+ ".commentCollection";
		
		return sqlSession.selectOne(statement,commentNo);
		
	}
	//1:1 = assoi...
	public List<CommentDTO> list(){
		String statement = namespace+ ".commentList";
		
		return sqlSession.selectList(statement);
	}

}
