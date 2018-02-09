package my.remind.board2.dao.content;

import java.util.ArrayList;

import my.remind.board2.vo.ContentVO;

public interface ContentDAO {
	
	// Get Information
	public int getAllContentCount();		// �� �Խñ� ��
	public int getLastContentId();	// ������ �Խñ��� ���̵� ������, �Խñ��� �߰��� �� ����.
	public ContentVO getContent(int contentId );				// Ư�� �Խñ� ��������
	public ArrayList<ContentVO> getContents(int pageNumber);	// �Խñ� ��� ��������
	
	
	// Modify
	public void insertContent(ContentVO content);	// �Խñ� ���
	public void updateContent(ContentVO content);	// �Խñ� ����
	public void visibleContent(int contentId, int visibility);	// �Խñ� �����/���̱�
	public void deleteContent(int contentId);		// �Խñ� ����
	
	// Pagination
	public int existNextPage(int lastContentId);	// ���� �������� �����ϴ��� Ȯ��
	public int existPrevPage(int firstContentId);	// ���� �������� �����ϴ��� Ȯ��
	
}
