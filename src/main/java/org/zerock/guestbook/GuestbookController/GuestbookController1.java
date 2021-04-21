package org.zerock.guestbook.GuestbookController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.service.GuestbookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;



@RequestMapping("guestbook")
@Controller
@Log4j2
@RequiredArgsConstructor
public class GuestbookController1 {
	
	private final GuestbookService service;     // service   <====  @RequiredArgsConstructor   ?????    
	
	
//	@GetMapping("/")
//	public String list() {
//		log.info("list.............................");
//
//		return "/index"; // templates 바로 아래에 있는 주소
//	}

	
//    @GetMapping("/list")
//    public String list(@ModelAttribute("PageRequestDTO") PageRequestDTO pageRequestDTO, Model model){
//    	log.info("list............." + pageRequestDTO);
//    	model.addAttribute("result", service.getList(pageRequestDTO));
//    return "guestbook/list"; // templates 바로 아래에 있는 주소
//    }
//		
//    
//    @GetMapping("/register")
//    public void register(){
//    	log.info("regiser get...");
//    	}
//    
//  //===============================================================================================
//
//    @GetMapping({"/read", "/modify"})
//    public void read(long gno, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model){
//    	log.info("gno : " + gno);
//    	GuestbookDTO dto = service.read(gno);
//    	model.addAttribute("dto", dto);
//	} 
//    
////=================================re==============================================================
//      
//    @PostMapping("/register")
//    public RedirectView registerPost(GuestbookDTO dto, RedirectAttributes redirectAttributes){
//    	log.info("dto..." + dto);    //새로 추가된 엔티티의 번호
//    	Long gno = service.register(dto);
//    	redirectAttributes.addFlashAttribute("msg", gno);
//    	
//    return  new RedirectView("/guestbook/list");              
//    }
//    
//    @PostMapping("/modify")
//    public RedirectView modify(GuestbookDTO dto, 
//    		@ModelAttribute("requestDTO") PageRequestDTO requestDTO,
//    		RedirectAttributes redirectAttributes){
//
//    	log.info("post modify.............");
//    	log.info("dto..............." + dto);  
//    	
//    	service.modify(dto);
//    	
//    	redirectAttributes.addAttribute("page", requestDTO.getPage());
//        redirectAttributes.addAttribute("type",requestDTO.getType());
//        redirectAttributes.addAttribute("keyword",requestDTO.getKeyword());
//    	
//    	
//    	redirectAttributes.addAttribute("gno", dto.getGno());
//    
//        return  new RedirectView("/guestbook/read");              
//        }
//    
//    @PostMapping("/remove")
//    public RedirectView remove(long gno, RedirectAttributes redirectAttributes){
//    
//    	log.info("gno..." + gno);    //새로 추가된 엔티티의 번호
//    		
//    	service.remove(gno);
//    	
//    	redirectAttributes.addFlashAttribute("msg", gno);
//    	
//    return new RedirectView("/guestbook/list");              
//    }
//    
    
}