package org.zerock.guestbook.dto;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
	
	private Long gno1;
	
	private String title1;
	
	private String content1;
	
	//private String writerEmail1;	//작성자의 이메일(id)
	
	private String writer1; //작성자의 이름 
	
	private LocalDateTime regDate1, modDate1;
	
	private int replyCount1; //해당 게시글의 댓글 수}
	
	public void changeTitle1(String title) {
		this.title1 = title1;
	}

	public void changeContent1(String content) {
		this.content1 = content1;
	}
}