package com.gdu.movie;

import static org.junit.Assert.assertEquals;

import java.lang.System.Logger;
import java.util.List;
import java.util.Map;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdu.movie.domain.MovieDTO;
import com.gdu.movie.domain.QueryDTO;
import com.gdu.movie.service.MovieService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovieTestCase {
	
	@Autowired
	public MovieDTO movieDTO;
	
	@Test 
	public void 영화목록테스트() {
		List<MovieDTO> list = movieDTO.getNo()
		Logger.info(list.toString());  

		assertEquals(1,  list.size());
	}
}
