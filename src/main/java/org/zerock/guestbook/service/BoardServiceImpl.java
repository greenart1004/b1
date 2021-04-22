package org.zerock.guestbook.service;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.guestbook.dto.BoardDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Board2;
import org.zerock.guestbook.entity.QBoard2;
import org.zerock.guestbook.entity.QMember1;
import org.zerock.guestbook.entity.Reply1;
import org.zerock.guestbook.repository.BoardRepository;
import org.zerock.guestbook.repository.ReplyRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl  implements BoardService  {

	private final BoardRepository repository;
	
	private final ReplyRepository replyRepository;
	
    @Override
    public Long register(BoardDTO dto1) {                      //// register()
    	log.info("DTO1------------------------");
    	log.info(dto1);
    	Board2 entity = dtoToEntity(dto1);
    	log.info(entity);                                      
    	repository.save(entity);
    	return entity.getGno1();    
    	}
/////////////////////////////////////////

    @Override
    public PageResultDTO<BoardDTO, Board2> getList(PageRequestDTO requestDTO) {  // getList()
    	Pageable pageable = requestDTO.getPageable(Sort.by("gno1").descending());
    	
    	BooleanBuilder booleanBuilder = getSearch(requestDTO);  // 검색조건처리
    	
    	Page<Board2> result = repository.findAll(booleanBuilder, pageable); // Querydsl 사용
    	
//    	Page<Board1> result = repository.findAll(pageable);
    	
    	Function<Board2, BoardDTO> fn = (entity -> entityToDto(entity));
    	
    	return new PageResultDTO<>(result, fn );   
	}
    
    
    //////////////////////////////////////// 
    @Override
    public BoardDTO get(Long gno1) {
    	
    	Optional<Board2> result = repository.findById(gno1);
    	
    	return result.isPresent() ? entityToDto(result.get()) : null;
    }
	//////////////////////////////  
    @Transactional
    @Override
    public void removeWithReplies(Long gno1) {

//        replyRepository.deleteByRno1(gno1);
       
	    repository.deleteById(gno1);
    }
    
    
    @Override
    public void modify(BoardDTO boardDTO) {
    	
    	Optional<Board2> result = repository.findById(boardDTO.getGno1());
    	
    	if(result.isPresent()) {
    		
    		Board2 entity = result.get();
    		
    		entity.changeTitle(boardDTO.getTitle1());
    		
    		entity.changeContent(boardDTO.getContent1());
    	
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
    	QBoard2 qBoard1 = QBoard2.board2;
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
