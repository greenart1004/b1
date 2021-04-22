package org.zerock.guestbook.service;

import org.zerock.guestbook.dto.BoardDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Board2;
import org.zerock.guestbook.entity.Member1;



public interface BoardService {

	Long register(BoardDTO dto1);
	
	PageResultDTO<BoardDTO, Board2> getList(PageRequestDTO requestDTO);

	BoardDTO get(Long gno1);//
	
	void modify(BoardDTO boardDTO);//
	
    void removeWithReplies(Long gno1);
	

	
	///////////////////////////////////////////////
	 default Board2 dtoToEntity(BoardDTO dto1) {   // DTO - interface 에서 데이타를 받아서 바로 Entity 로변환하는부분 
		 Member1 member = Member1.builder().email1(dto1.getWriter1()).build();
 System.out.println(member);
		 Board2 entity1 = Board2.builder()
			.gno1(dto1.getGno1())
			.title1(dto1.getTitle1())
			.content1(dto1.getContent1())
			.writer1(member)
			.build();
	 return entity1;									
 }
 
//////////////////////////////////////////////////////////////////////////////////////
    default BoardDTO entityToDto(Board2  entity1){
    	BoardDTO dto1  = BoardDTO.builder()
	    			.gno1(entity1.getGno1())
	    			.title1(entity1.getTitle1())
	    			.content1(entity1.getContent1())
	    			.regDate1(entity1.getRegDate())
	    			.modDate1(entity1.getModDate())
	    			.build();
	    	return dto1;
    }
}
