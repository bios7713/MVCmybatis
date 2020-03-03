package Repository.Comment;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.DTO.CommentDTO;
import Model.DTO.ReplyDTO;

@Repository
public class InsertCommentRepository {
	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "Repository.Comment.CommentMapper";
	public void commentInsert(CommentDTO CDTO) {
		String statement = namespace+".insertComment";
		sqlSession.insert(statement,CDTO);
		
	}
	
	public void replyInsert(ReplyDTO RDTO) {
		String statement = namespace+".insertReply";
		sqlSession.insert(statement,RDTO);
		
	}

}
