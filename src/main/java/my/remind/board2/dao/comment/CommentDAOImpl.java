package my.remind.board2.dao.comment;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import my.remind.board2.vo.CommentVO;

@Repository
public class CommentDAOImpl implements CommentDAO{
	@Inject
	private SqlSession sqlSession;

	private static final String NAMESPACE = "my.remind.board2.mapper.CommentMapper.";
	
	// Pagination Variable
	private int viewCount = 3;
	
	@Override
	public CommentVO getComment(int contentId, int commentId) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("boardNo", contentId);
		map.put("no", commentId);
		return sqlSession.selectOne(NAMESPACE+"getComment", map);
	}
	
	@Override
	public ArrayList<CommentVO> getComments(int contentId, int page) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("boardNo", contentId);
		map.put("start", (page - 1) * this.viewCount );
		map.put("count", this.viewCount);
		return (ArrayList) sqlSession.selectList(NAMESPACE+"getComments", map);
	}

	@Override
	public int insertComment(CommentVO comment) {
		return sqlSession.insert(NAMESPACE+"insertComment", comment);
	}

	@Override
	public int updateComment(CommentVO comment) {
		return sqlSession.update(NAMESPACE+"updateComment", comment);
	}

	@Override
	public int deleteComment(int contentId, int commentId) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("boardNo", contentId);
		map.put("no", commentId);
		return sqlSession.delete(NAMESPACE+"deleteComment", map);
	}

	@Override
	public int existNextComment(int contentId, int commentId) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("boardNo", contentId);
		map.put("no", commentId);
		return sqlSession.selectOne(NAMESPACE+"existNextComment", map);
	}

	@Override
	public int existPrevComment(int contentId, int commentId) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("boardNo", contentId);
		map.put("no", commentId);
		return sqlSession.selectOne(NAMESPACE+"existPrevComment", map);
	}

}
