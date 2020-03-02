package Repository.Member;



import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import Model.DTO.MemberDTO;

@Repository
public class MemberJoinRepository extends AbstractRepository {
	private SqlSession sqlSession =  getSqlSessionFactory().openSession();
	private final String namespace = "mappers.memberMapper";	
	public Integer insertMember(MemberDTO D) {
		Integer i = null;
		String statement = namespace + ".insertMember";
	 	try {
	 			i = sqlSession.insert(statement, D);
	 			     sqlSession.commit();	 	
	 	}catch(Exception e) {
	 		e.printStackTrace();	 		
	 		sqlSession.rollback();
	 	}finally {
	 		sqlSession.close();
	 	}
	 		return i;
	 }	 

	
}
