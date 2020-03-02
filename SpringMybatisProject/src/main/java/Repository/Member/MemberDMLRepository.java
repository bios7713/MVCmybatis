package Repository.Member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import Model.DTO.MemberDTO;
import Model.DTO.UserPasswordChangeDTO;

@Repository
public class MemberDMLRepository extends AbstractRepository {
	private final String namespace = "mappers.memberDMLMapper";


	public Integer memberUpdate(MemberDTO DTO) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();

		String statement = namespace+".updateMember";  	
		Integer i = 0; 
		i = sqlSession.update(statement,DTO);
		try {
			sqlSession.commit();   
		}catch(Exception e) {
			e.printStackTrace();
			sqlSession.rollback();	
		}finally {			
			sqlSession.close();
		}
		return i;
	}

	public void memDel(MemberDTO DTO) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".deleteMember";

		sqlSession.delete(statement,DTO);
		try {
			sqlSession.commit();   
		

		}catch(Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		

		}finally {
			
			sqlSession.close();
		}


	}

	public void chanPw(UserPasswordChangeDTO DTO) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".userPwChange";
		sqlSession.update(statement,DTO);
		try {
			sqlSession.commit();   
		}catch(Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();			
		}
	}
}
