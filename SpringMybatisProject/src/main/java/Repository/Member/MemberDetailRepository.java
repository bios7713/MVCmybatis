package Repository.Member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import Model.DTO.MemberDTO;

@Repository
public class MemberDetailRepository extends AbstractRepository{
	SqlSession sqlSession = getSqlSessionFactory().openSession();
	private final String namespace = "mappers.loginMapper";
	public MemberDTO selectByUserId(MemberDTO D) {
		
		String statement = namespace+".selectUser";
		
		
		return sqlSession.selectOne(statement,D);
		
	}
	
	


}
