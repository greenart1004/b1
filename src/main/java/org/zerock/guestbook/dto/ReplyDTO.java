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
public class ReplyDTO {
	
	private Long rno1;
	
	private String text1;
	
	private String replyer1;
	
	private LocalDateTime regDate1, modDate1;
	

//	public void changeTitle1(String title) {
//		this.title1 = title1;
//	}
//
//	public void changeContent1(String content) {
//		this.content1 = content1;
//	}
}