package com.gdu.app07.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gdu.app07.domain.BoardDTO;

@Repository		// SpringContainer에 넣는 애너테이션
public class BoardDAO {
	
	@Autowired	// bean을 불러오는 애너테이션
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String NS = "mybatis.mapper.board.";  // name-space 값을 변수로 잡아주고 
	
	public List<BoardDTO> selectBoardList() {	// 매개변수를 받는 게 없기 때문에 주는 것도 없다 ()
		return sqlSessionTemplate.selectList(NS + "selectBoardList"); // 변수로 잡은 NS 값을 넣어준다. 
	
	}
	
	public BoardDTO selectBoardByNo(int boardNo) { // 1
		return sqlSessionTemplate.selectOne(NS + "selectBoardByNo", boardNo); // 2
	}

	public int insertBoard(BoardDTO board) {
		return sqlSessionTemplate.insert(NS + "insertBoard", board);
	}
	
	public int updateBoard(BoardDTO boardNo) {
		return sqlSessionTemplate.update(NS + "updateBoard", boardNo);
	}
	
	public int deleteBoard(int boardNo) {
		return sqlSessionTemplate.delete(NS + "deleteBoard", boardNo);
	}
}
