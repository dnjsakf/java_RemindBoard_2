package my.remind.board2;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import my.remind.board2.dao.content.ContentDAO;
import my.remind.board2.vo.ContentVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ContentDAOTest {
	
	String namespace = "my.remind.board2.mapper.ContentMapper.";

	@Inject
	ContentDAO dao;
	
	@Test
	public void test() throws Exception {
		System.out.println("[ContentDAO] " + dao);
	}
	
	/*
	@Test 
	public void getAllContentCount() throws Exception {
		System.out.println("[getAllContnetCount] " + dao.getAllContentCount());
	}
	
	@Test
	public void getLastContentId() throws Exception {
		System.out.println("[getLastContentId]" + dao.getLastContentId());
	}
	
	@Test
	public void getContent() throws Exception {
		System.out.println("[getContent]" + dao.getContent(1).toString());
	}
	
	@Test
	public void getContents() throws Exception{
		ArrayList<ContentVO> contents = dao.getContents(1);
		int size = contents.size();
		for(int i = 0; i < size; i++) {
			System.out.println("[content] " + contents.get(i).getBoardNo() + " / " +contents.get(i).getBoardTitle() );
		}
	}
	
	@Test
	public void existNextPage() {
		System.out.println("[existNextPage] " + dao.existNextPage(3));
	}
	
	@Test
	public void existPrevPage() {
		System.out.println("[existPrevPage] " + dao.existPrevPage(11));
	}
	
	
	@Test
	public void updateContent() throws Exception {
		DateFormat df = DateFormat.getDateTimeInstance();
		ContentVO content = new ContentVO(
					3,
					"TEST-UPDATE",
					"admin",
					df.format(new Date()),
					"테스트 데이터 입니다.<br/>",
					1
				);
		dao.updateContent(content);
	}

	@Test
	public void visibleContent() throws Exception {
		dao.visibleContent(4, 0);
	}
	

	@Test
	public void insertContent() throws Exception {
		DateFormat df = DateFormat.getDateTimeInstance();
		
		int insertCount = 15;
		
		for(int i = 0 ; i < insertCount; i++) {
			int id = dao.getLastContentId() + 1;
			String title = "자동입력" + id;
			String writer = "admin";
			String date = df.format(new Date()).toString();
			String cnt = "테스트 데이터 입니다.<br/>";
			int available = 1;

			ContentVO content = new ContentVO(
						id,
						title,
						writer,
						date,
						cnt,
						available
					);
			dao.insertContent(content);
		}
	}
	
	*/
}
