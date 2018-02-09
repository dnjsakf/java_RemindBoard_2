package my.remind.board2.dao.content;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import my.remind.board2.vo.ContentVO;


@Repository
public class ContentDAOImpl implements ContentDAO{
	/**
	 * Injections
	 */
	@Inject
	private SqlSession sqlSession;
	
	/**
	 * Variables
	 */
	private static final String NAMESPACE = "";
	private int viewCount = 10;
	

	@Override
	public int getAllContentCount() {
		return sqlSession.selectOne(NAMESPACE+"getAllContentCount");
	}
	
	@Override
	public ContentVO getContent(int contentId) {
		return sqlSession.selectOne(NAMESPACE+"getContent", contentId);
	}

	@Override
	public int getLastContentId() {
		return sqlSession.selectOne(NAMESPACE+"getLastContentId");
	}

	@Override
	public ArrayList<ContentVO> getContents(int pageNumber) {
		int firstNo = ( pageNumber - 1 ) * this.viewCount;

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("firstNo", firstNo);
		map.put("viewCount", this.viewCount);
		
		return (ArrayList) sqlSession.selectList(NAMESPACE+"getContents", map);
		
	}

	@Override
	public void insertContent(ContentVO content) {
		System.out.println("[insert-content] " + content);
		int result = sqlSession.insert(NAMESPACE+"insertContent", content);
		System.out.println("[insert - "+ (result > 0 ? "success" : "failure") +"]");
	}

	@Override
	public void updateContent(ContentVO content) {
		int result = sqlSession.update(NAMESPACE+"updateContent", content);
		System.out.println("[update - "+ (result > 0 ? "success" : "failure") +"]");
	}
	@Override
	public void deleteContent(int contentId) {
//		HashMap<String, Integer> map = new HashMap<String, Integer>();
//		map.put("contentId", contentId);
		int result = sqlSession.delete(NAMESPACE+"updateContent", contentId);
		System.out.println("[update - "+ (result > 0 ? "success" : "failure") +"]");
		
	}

	@Override
	public void visibleContent(int contentId, int visibility) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("contentId", contentId);
		map.put("visibility", visibility);
		
		int result = sqlSession.update(NAMESPACE+"visibleContent", map);
		System.out.println("[visible - "+ (result > 0 ? "success" : "failure") +"]");
	}

	@Override
	public int existNextPage(int lastContentId) {
		int result = sqlSession.selectOne(NAMESPACE+"existNextPage", lastContentId);
		System.out.println("[ExistNextPage] " + result);
		return result;
	}

	@Override
	public int existPrevPage(int firstContentId) {
		int result = sqlSession.selectOne(NAMESPACE+"existPrevPage", firstContentId);
		System.out.println("[ExistPrevPage] " + result);
		return result;
	}


}
