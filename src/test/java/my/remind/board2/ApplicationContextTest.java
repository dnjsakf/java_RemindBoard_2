package my.remind.board2;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ApplicationContextTest {

	@Inject
	ApplicationContext ctx;
	
	@Test
	public void test() throws Exception {
		System.out.println("[Applcation Context] " + ctx);
	}
	
}
