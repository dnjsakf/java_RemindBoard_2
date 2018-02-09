package my.remind.board2.dao.comment;

import java.util.ArrayList;

import my.remind.board2.vo.CommentVO;

public interface CommentDAO {
	// getComment
	// getComments
	
	// insertComment
	// updateComment
	// deleteComment
	
	// existNextComment
	// existPrevComment

	public CommentVO getComment(int contntId, int commentId);
	public ArrayList<CommentVO> getComments(int contentId, int page);
	public int insertComment(CommentVO comment);
	public int updateComment(CommentVO comment);
	public int deleteComment(int contentId, int commentId);
	public int existNextComment(int contentId, int commentId);
	public int existPrevComment(int contentId, int commentId);
}
