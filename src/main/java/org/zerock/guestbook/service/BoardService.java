package org.zerock.guestbook.service;

import org.zerock.guestbook.dto.BoardDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Board1;
import org.zerock.guestbook.entity.Member1;



public interface BoardService {

	Long register(BoardDTO dto);
	
	PageResultDTO<BoardDTO, Board1> getList(PageRequestDTO requestDTO);
	
	BoardDTO read(Long gno1);
	
	void modify(BoardDTO dto);
	
	void remove(Long gno1);
	
	
	
	///////////////////////////////////////////////
	 default Board1 dtoToEntity(BoardDTO dto) {   // DTO - interface 에서 데이타를 받아서 바로 Entity 로변환하는부분 
		 Member1 member = Member1.builder().email1(dto.getWriterEmail1()).build();
		 
		 Board1 entity = Board1.builder()
			.gno1(dto.getGno1())
			.title1(dto.getTitle1())
			.content1(dto.getContent1())
			.writer1(member)
			.build();
	 return entity;									
 }
 
//////////////////////////////////////////////////////////////////////////////////////
    default BoardDTO entityToDto(Board1  entity){
    	BoardDTO dto  = BoardDTO.builder()
	    			.gno1(entity.getGno1())
	    			.title1(entity.getTitle1())
	    			.content1(entity.getContent1())
	    			.regDate1(entity.getRegDate())
	    			.modDate1(entity.getModDate())
	    			.build();
	    	return dto;
    }
}
