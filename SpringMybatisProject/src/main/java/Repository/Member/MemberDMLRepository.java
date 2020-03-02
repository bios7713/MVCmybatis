package Repository.Member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import Model.DTO.MemberDTO;

@Repository
public class MemberDMLRepository extends AbstractRepository {
    private SqlSession sqlSession = getSqlSessionFactory().openSession();
    private final String namespace = "mappers.memberDMLMapper";
    public Integer memberUpdate(MemberDTO D) {
    	String statement = namespace+".updateMember";
    	
    	Integer i = null;
    	try {
    		 i = sqlSession.update(statement,D);
    					sqlSession.commit();
    	}catch(Exception e) {
    		e.printStackTrace();
    		sqlSession.rollback();
   		
    	}
        	return i;
    }
    
    
	
}
