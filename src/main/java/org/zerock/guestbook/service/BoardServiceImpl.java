package org.zerock.guestbook.service;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zerock.guestbook.dto.BoardDTO;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Board1;
import org.zerock.guestbook.entity.Guestbook2;
import org.zerock.guestbook.entity.QBoard1;
import org.zerock.guestbook.entity.QMember1;
import org.zerock.guestbook.repository.BoardRepository;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl  implements BoardService  {

	private final BoardRepository repository;
	
    @Override
    public Long register(BoardDTO dto) {                      //// register()
    	log.info("DTO------------------------");
    	log.info(dto);
    	Board1 entity = dtoToEntity(dto);
    	log.info(entity);                                      
    	repository.save(entity);
    	return entity.getGno1();    
    	}
/////////////////////////////////////////

    @Override
    public PageResultDTO<BoardDTO, Board1> getList(PageRequestDTO requestDTO) {  // getList()
    	Pageable pageable = requestDTO.getPageable(Sort.by("gno1").descending());
    	
    	BooleanBuilder booleanBuilder = getSearch(requestDTO);  // 검색조건처리
    	
    	Page<Board1> result = repository.findAll(booleanBuilder, pageable); // Querydsl 사용
    	
//    	Page<Board1> result = repository.findAll(pageable);
    	
    	Function<Board1, BoardDTO> fn = (entity -> entityToDto(entity));
    	
    	return new PageResultDTO<>(result, fn );   
	}
    
    
    //////////////////////////////////////// 
    @Override
    public BoardDTO read(Long gno1) {
    	
    	Optional<Board1> result = repository.findById(gno1);
    	
    	return result.isPresent() ? entityToDto(result.get()) : null;
    }
	//////////////////////////////  
    @Override
    public void remove(Long gno1) {
    	
  	repository.deleteById(gno1);
    }
    
    
    @Override
    public void modify(BoardDTO dto) {
    	
    	Optional<Board1> result = repository.findById(dto.getGno1());
    	
    	if(result.isPresent()) {
    		
    		Board1 entity = result.get();
    		
    		entity.changeTitle(dto.getTitle1());
    		
    		entity.changeContent(dto.getContent1());
    	
    		repository.save(entity);    	
    	}
    }
    
	
	
	//////////////////////////////
	private BooleanBuilder getSearch(PageRequestDTO requestDTO) {
    	String type = requestDTO.getType();
    	   	
    	BooleanBuilder booleanBuilder = new BooleanBuilder();

    	if(type == null || type.trim().length() == 0) {    //검색 조건이 없는 경우
    		return booleanBuilder;
    	}
    	QMember1 qMember1 = QMember1.member1;
    	QBoard1 qBoard1 = QBoard1.board1;
    	String keyword = requestDTO.getKeyword();
    	BooleanExpression expression = qBoard1.gno1.gt(0L);       //gno > 0 조건만 생성
    	booleanBuilder.and(expression);

    	//검색조건을 작성하기
	    BooleanBuilder conditionBuilder = new BooleanBuilder();
	    
	    if(type.contains("t")) {
	    	conditionBuilder.or(qBoard1.title1.contains(keyword));
	    }
	    if(type.contains("c")) {
	    	conditionBuilder.or(qBoard1.content1.contains(keyword));
	    }
	    if(type.contains("w")) {
	    	conditionBuilder.or(qMember1.name1.contains(keyword));
	    }
	    //모든 조건 통합
		    booleanBuilder.and(conditionBuilder);
		    return booleanBuilder;
	  }


}
