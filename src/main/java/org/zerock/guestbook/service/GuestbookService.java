package org.zerock.guestbook.service;

import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Guestbook2;



public interface GuestbookService {  // 1. DTO //2.Service - interface //3.Service - 구현체(implement)
	
	Long register(GuestbookDTO dto);
	
	PageResultDTO<GuestbookDTO, Guestbook2> getList(PageRequestDTO requestDTO);
	
	GuestbookDTO read(Long gno);
	
	void modify(GuestbookDTO dto);
	
	void remove(Long gno);
		
	//////////////////////////////////////////////////////////////////////////////////////
	 default Guestbook2 dtoToEntity(GuestbookDTO dto) {   // DTO - interface 에서 데이타를 받아서 바로 Entity 로변환하는부분 
			 Guestbook2 entity = Guestbook2.builder()
				.gno(dto.getGno())
				.title(dto.getTitle())
				.content(dto.getContent())
				.writer(dto.getWriter())
				.build();
		 return entity;									
	 }
	 
	//////////////////////////////////////////////////////////////////////////////////////
	    default GuestbookDTO entityToDto(Guestbook2 entity){
		    	GuestbookDTO dto  = GuestbookDTO.builder()
		    			.gno(entity.getGno())
		    			.title(entity.getTitle())
		    			.content(entity.getContent())
		    			.writer(entity.getWriter())
		    			.regDate(entity.getRegDate())
		    			.modDate(entity.getModDate())
		    			.build();
		    	return dto;
	    }
}
