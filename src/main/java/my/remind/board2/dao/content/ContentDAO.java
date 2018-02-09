package my.remind.board2.dao.content;

import java.util.ArrayList;

import my.remind.board2.vo.ContentVO;

public interface ContentDAO {
	
	// Get Information
	public int getAllContentCount();		// 총 게시글 수
	public int getLastContentId();	// 마지막 게시글의 아이디를 가져옴, 게시글을 추가할 때 사용됨.
	public ContentVO getContent(int contentId );				// 특정 게시글 가져오기
	public ArrayList<ContentVO> getContents(int pageNumber);	// 게시글 목록 가져오기
	
	
	// Modify
	public void insertContent(ContentVO content);	// 게시글 등록
	public void updateContent(ContentVO content);	// 게시글 수정
	public void visibleContent(int contentId, int visibility);	// 게시글 숨기기/보이기
	public void deleteContent(int contentId);		// 게시글 삭제
	
	// Pagination
	public int existNextPage(int lastContentId);	// 다음 페이지가 존재하는지 확인
	public int existPrevPage(int firstContentId);	// 이전 페이지가 존재하는지 확인
	
}
