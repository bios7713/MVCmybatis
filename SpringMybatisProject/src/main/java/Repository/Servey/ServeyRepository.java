package Repository.Servey;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.DTO.QuestionOption;

@Repository
public class ServeyRepository {
	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "Repository.Mapper.Question";
	
	public List<QuestionOption> selectAll(){
		String statement = namespace+ ".selectAll";
		
		return sqlSession.selectList(statement);

	}
	
	
}
