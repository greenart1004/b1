package org.zerock.guestbook.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.guestbook.dto.BoardDTO;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Guestbook2;

@SpringBootTest
public class GuestbookServiceTests {

	@Autowired
	GuestbookService service;
	

	@Test
	public void testRegister() {
		
		GuestbookDTO guestbookDTO = GuestbookDTO.builder()
			.title("Sample Title........")
			.content("Sample content........")
			.writer("user0..........")
			.build();
				
		System.out.println(service.register(guestbookDTO));
	}
////////////////////////////////////////////////////////////////////////////////	
	@Test
	public void testList(){            /////  DB에서 가져온 데이타 Entity 목록을  DTO로 변환하는 부분
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();   
		PageResultDTO<GuestbookDTO, Guestbook2> resultDTO = service.getList(pageRequestDTO);
		
		for (GuestbookDTO guestbookDTO : resultDTO.getDtoList()) {
			System.out.println(guestbookDTO);
		
//		System.out.println(resultDTO);
		
			}
		}
}

	
	
