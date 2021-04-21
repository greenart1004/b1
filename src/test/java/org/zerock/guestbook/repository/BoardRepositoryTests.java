package org.zerock.guestbook.repository;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.guestbook.entity.Board2;
import org.zerock.guestbook.entity.Member1;


@SpringBootTest
public class BoardRepositoryTests {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Test
	public void insertDummies() {
		IntStream.rangeClosed(1,20).forEach(i -> {
			Member1 member1 = Member1.builder().email1("user"+i +"@aaa.com").build();
			Board2 board1 = Board2.builder()
					.title1("Title..."+i)
					.content1("Content...." + i)
					.writer1(member1)
					.build();
			System.out.println(boardRepository.save(board1));
			});
		}
	
//	@Test
//	public void testRead1() {
//		
//		Optional<Board1> result = boardRepository.findById(100L); //데이터베이스에 존재하는 번호
//		
//		Board1 board1 = result.get();
//		
//		System.out.println(board1);
//		System.out.println(board1.getWriter());
//		}
//	

	
	}
