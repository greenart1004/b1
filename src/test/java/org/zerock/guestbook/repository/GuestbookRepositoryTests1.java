package org.zerock.guestbook.repository;



import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.zerock.guestbook.entity.Guestbook2;
import org.zerock.guestbook.entity.QGuestbook2;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

@SpringBootTest
public class GuestbookRepositoryTests1 {
	
	@Autowired
	private GuestbookRepository1 guestbookRepository;
	
	@Test
	public void inserDummies() {
		IntStream.rangeClosed(1, 300).forEach(i -> {
			Guestbook2 guestbook2 = Guestbook2.builder()
					.title("title....." + i)
					.content("content...." + i)
					.writer("user....." + (i%10))
					.build();
			System.out.println(guestbookRepository.save(guestbook2));
		});
	}
	
	@Test
	public void updateTest() {
		Optional<Guestbook2> result =
				guestbookRepository.findById(300L);  // 존재하는 번호로 테스트, findById 는 항상 데이타가 Optional
		if(result.isPresent()) {
			Guestbook2 guestbook2 = result.get();
			guestbook2.changeTitle("Changed Title...");
			guestbook2.changeContent("Changed Content...");
			guestbookRepository.save(guestbook2);			
		}
	}
	
	@Test
	public void testQuery1() {
		Pageable pageable = PageRequest.of(0, 10, Sort.by("gno").descending());
	
		// find <----- JpaRepository      ++++    Querydsl ---> QuerydslPredicateExecutor
		QGuestbook2 qGuestbook2 = QGuestbook2.guestbook2;
		
		BooleanBuilder builder = new BooleanBuilder();  
		
		BooleanExpression expression = qGuestbook2.title.contains("1");  ///검색조건 : 타이틀에서 1을 포함하는 guestbook를 나타냄
		
		builder.and(expression);
		
		Page<Guestbook2> result = guestbookRepository.findAll(builder, pageable);
	
		result.forEach(guestbook2 -> {
			System.out.println(guestbook2);
		});
	}
	
	@Test
	public void testQuery2() {
		Pageable pageable = PageRequest.of(0, 10, Sort.by("gno").descending());
	
		QGuestbook2 qGuestbook2 = QGuestbook2.guestbook2;
		
		BooleanBuilder builder = new BooleanBuilder();  
		
		BooleanExpression expression = qGuestbook2.title.contains("1");  /////검색조건1////////
		BooleanExpression exAll = expression.or(qGuestbook2.content.contains("1"));  //////검색조건2//////
			
		builder.and(exAll);
		builder.and(qGuestbook2.gno.gt(0L));     /////검색조건3//////
		
		Page<Guestbook2> result = guestbookRepository.findAll(builder, pageable);
	
		result.forEach(guestbook2 -> {
			System.out.println(guestbook2);
		});
	}
	
}
