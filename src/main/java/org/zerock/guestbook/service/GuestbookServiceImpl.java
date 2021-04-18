package org.zerock.guestbook.service;

import java.util.Optional;
//import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Guestbook2;
import org.zerock.guestbook.entity.QGuestbook2;
import org.zerock.guestbook.repository.GuestbookRepository1;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
@RequiredArgsConstructor
public class GuestbookServiceImpl implements GuestbookService {     //DTO => implements

	
	private final GuestbookRepository1 repository;
	
    @Override
    public Long register(GuestbookDTO dto) {                      //// register()
    	log.info("DTO------------------------");
    	log.info(dto);
    	Guestbook2 entity = dtoToEntity(dto);
    	log.info(entity);                                      
    	repository.save(entity);
    	return entity.getGno();    
    	}
    

    @Override
    public PageResultDTO<GuestbookDTO, Guestbook2> getList(PageRequestDTO requestDTO) {  // getList()
    	Pageable pageable = requestDTO.getPageable(Sort.by("gno").descending());
    	
    	BooleanBuilder booleanBuilder = getSearch(requestDTO);  // 검색조건처리
    	
    	Page<Guestbook2> result = repository.findAll(booleanBuilder, pageable); // Querydsl 사용
    	
//    	Page<Guestbook2> result = repository.findAll(pageable);
    	
    	Function<Guestbook2, GuestbookDTO> fn = (entity -> entityToDto(entity));
    	
    	return new PageResultDTO<>(result, fn );   
	}
    
    @Override
    public GuestbookDTO read(Long gno) {
    	
    	Optional<Guestbook2> result = repository.findById(gno);
    	
    	return result.isPresent() ? entityToDto(result.get()) : null;
    }

    
    @Override
    public void remove(Long gno) {
    	
  	repository.deleteById(gno);
    }
    
    
    @Override
    public void modify(GuestbookDTO dto) {
    	
    	Optional<Guestbook2> result = repository.findById(dto.getGno());
    	
    	if(result.isPresent()) {
    		
    		Guestbook2 entity = result.get();
    		
    		entity.changeTitle(dto.getTitle());
    		
    		entity.changeContent(dto.getContent());
    	
    		repository.save(entity);    	
    	}
    }
    
    
    private BooleanBuilder getSearch(PageRequestDTO requestDTO) {
    	String type = requestDTO.getType();
    	   	
    	BooleanBuilder booleanBuilder = new BooleanBuilder();

    	if(type == null || type.trim().length() == 0) {    //검색 조건이 없는 경우
    		return booleanBuilder;
    	}

    	QGuestbook2 qGuestbook =QGuestbook2.guestbook2;
    	String keyword = requestDTO.getKeyword();
    	BooleanExpression expression = qGuestbook.gno.gt(0L);       //gno > 0 조건만 생성
    	booleanBuilder.and(expression);

    	//검색조건을 작성하기
	    BooleanBuilder conditionBuilder = new BooleanBuilder();
	    
	    if(type.contains("t")) {
	    	conditionBuilder.or(qGuestbook.title.contains(keyword));
	    }
	    if(type.contains("c")) {
	    	conditionBuilder.or(qGuestbook.content.contains(keyword));
	    }
	    if(type.contains("w")) {
	    	conditionBuilder.or(qGuestbook.writer.contains(keyword));
	    }
	    
	    //모든 조건 통합
		    booleanBuilder.and(conditionBuilder);
		    return booleanBuilder;
	  }
    
    
}  


