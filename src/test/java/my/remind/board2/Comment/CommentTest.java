package my.remind.board2.Comment;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.inject.Inject;

import org.apache.log4j.helpers.DateTimeDateFormat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import my.remind.board2.dao.comment.CommentDAO;
import my.remind.board2.vo.CommentVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CommentTest {

	@Inject
	CommentDAO dao;
	
	@Test
	public void test() throws Exception {
		System.out.println("[CommentDAO] " + dao);
	}

	/*
	@Test
	public void getComment() throws Exception {
		System.out.println("[comment] " + dao.getComment(1, 2));
	}

	@Test
	public void getComments() throws Exception {
		ArrayList<CommentVO> comments = dao.getComments(1, 1);
		for(int i = 0; i < comments.size(); i++) {
			System.out.println( comments.get(i) );
		}
	}

	@Test
	public void insertComment() throws Exception {
		DateFormat df = DateFormat.getDateTimeInstance();
		CommentVO comment = new CommentVO(
					"허돌프",
					df.format(new Date()),
					"1234",
					"Insert Test",
					2
				);
		System.out.println("[insert] " + dao.insertComment(comment));
	}
	*/
	@Test
	public void insertCommentMulti() throws Exception {
		for(int i = 0 ; i < 15; i++) {
			DateFormat df = DateFormat.getDateTimeInstance();
			CommentVO comment = new CommentVO(
						"허돌프",
						df.format(new Date()),
						"1234",
						"Mutl-Insert Test",
						3
					);
			System.out.println("[insert] " + dao.insertComment(comment));
		}
	}
	/*
	@Test
	public void updateComment() throws Exception {
		DateFormat df = DateFormat.getDateTimeInstance();
		
		CommentVO comment = dao.getComment(1, 1);
		System.out.println("[before]"+comment);
		if( comment.getPassword().equals("1234") ) {
			System.out.println("[matched]");
			comment.setDate(df.format(new Date()));
			comment.setComment("Update Test");
		} else {
			System.out.println("[no matched]");
		}
		System.out.println("[after]"+comment);
		
		dao.updateComment(comment);
	}
	*/
	
	/*
	@Test
	public void deleteComment() throws Exception {
		CommentVO comment = dao.getComment(1, 2);
		String password = "1234";
		if( comment.getPassword().equals(password)) {
			System.out.println("[matched]");
			dao.deleteComment(comment.getBoardNo(), comment.getNo());
		} else {
			System.out.println("[no matched]");
		}
	}
	*/
	
	@Test
	public void existComment() throws Exception {
		int boardNo = 3;
		int page = 2;
		int viewCount = 5;
		
		ArrayList<CommentVO> comments = dao.getComments(boardNo, page);
		
		int firstId = comments.get(0).getNo();
		int lastId = comments.get( comments.size()-1 ).getNo();
		
		int existNextComment = dao.existNextComment(boardNo, lastId);
		int existPrevComment = dao.existPrevComment(boardNo, firstId);
		
		int nextComments = Integer.valueOf( existNextComment / viewCount );
		int prevComments = Integer.valueOf( existPrevComment / viewCount );
		
		if( existNextComment % viewCount != 0 ) { nextComments += 1; }
		if( existPrevComment % viewCount != 0 ) { prevComments += 1; }
		
		System.out.println("[contents] " + comments.size() );
		System.out.println("[NextComment] " + lastId + " / " + existNextComment + " / " + nextComments);
		System.out.println("[PrevComment] " + firstId + " / " + existPrevComment + " / " + prevComments);
	}
}
