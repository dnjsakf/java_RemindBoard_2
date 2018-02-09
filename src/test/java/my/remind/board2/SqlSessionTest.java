package my.remind.board2;

import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class SqlSessionTest {
	
	String namespace = "my.remind.board2.mapper.ContentMapper.";

	@Inject
	SqlSession sqlSession;
	
	@Test
	public void test() throws Exception {
		System.out.println("[sqlSession] " + sqlSession);
	}
	
	@Test
	public void getContent() throws Exception {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("boardNo", 1);
		System.out.println("[getContent] " + sqlSession.selectOne(namespace + "getContent", map));
	}
}
