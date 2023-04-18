package com.jdu.app04.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdu.app04.domain.BoardDTO;
import com.jdu.app04.repository.BoardDAO;

/*
 @Component
 1. rootcontext가서 스프링 컨테이너에 저장하지 말고
    BoardServiceImpl 클래스 타입의 객체를 만들어서 스프링 컨테이너에 저장하시오.(=@Component)
 2. <bean>태그나 @Configuration + @Bean 애너테이션을 대체하는 방식이다.
 3. Layer별 전용 @Component가 만들어져 있다.
 	1) 컨트롤러 	  : @Controller
 	2) 서비스 		  : @Service
 	3) 레파지토리영역 : @Repository
 	
 @Component(=Bean), 스프링 컨테이너의 만들어진 Bean이다, 이와같이 만들면 @configuration이나 @bean으로 사용할일이 없다 허나 한가지 단점이 @Autowired를 통해서 인식되려면 Component-Scan이 (같이)등록되어 있어야 한다.
	Component-Scan 등록하는법 
	1. <context:component-scan>이라는 태그쓰기 (servlet-context에 이미 되어있기 때문에 따로 설정해줄 필요가 없다, 심지어 경로까지 지가 아라서 등록되어있다.)
	2. @ComponentScan이라는 애너테이션 쓰기 	
 */

/*
@Component
1. BoardServiceImpl 클래스 타입의 객체를 만들어서 Spring Container에 저장한다.
2. <bean> 태그나 @Configuration + @Bean 애너테이션을 대체하는 방식이다.
3. Layer별 전용 @Component가 만들어져 있다.
	1) 컨트롤러   : @Controller
	2) 서비스     : @Service
	3) 레파지토리 : @Repository
*/

/*
단, @Component가 @Autowired를 통해서 인식되려면 Component-Scan이 등록되어 있어야 한다.
Component-Scan 등록 방법
방법1. <context:component-scan> - servlet-context.xml에 이미 등록되어 있다.
방법2. @ComponentScan
*/
	
	@Service
	public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardDTO> getBoardList() {
		return boardDAO.selectBoardList();
	}
	
	@Override
	public BoardDTO getBoardByNo(int board_no) {
		
		return boardDAO.selectBoardByNo(board_no);
	}
	
	@Override
	public int addBoard(BoardDTO board) {
		return boardDAO.insertBoard(board);
	}
	
	@Override
	public int modifyBoard(BoardDTO board) {
		return boardDAO.updateBoard(board);
	}
	
	@Override
	public int removeBoard(int board_no) {
		
		return boardDAO.deleteBoard(board_no);
	}
	
}
