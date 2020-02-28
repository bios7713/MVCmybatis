package Repository.Member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import Model.DTO.MemberDTO;
import Model.DTO.StartEndPageDTO;

@Repository
public class MemberListRepository extends AbstractRepository{
	SqlSession sqlSession =  getSqlSessionFactory().openSession();
	private final String namespace = "mappers.memberMapper";	
	public List<MemberDTO> selectList(int page, int limit , int limitPage){
		
		Long startRow = ((long)page -1) *10 +1;
		Long endRow = startRow + limit -1;
		

		
		
		String statement  = namespace + ".memberList";
		
		List<MemberDTO> L =
				  sqlSession.selectList(statement, new StartEndPageDTO(startRow,endRow));
		
		
		
		return L;
	}
	public Integer ListCount() {
		String statement  = namespace + ".memberCount";
		
			return sqlSession.selectOne(statement);
	}
	
	
	
}
