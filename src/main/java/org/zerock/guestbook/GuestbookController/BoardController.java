package org.zerock.guestbook.GuestbookController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.guestbook.dto.BoardDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.service.BoardService;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/board/")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

///////////////////////////////////////////////////////////////////////////////////////////    
    
    
    @GetMapping("/list")
    public void list(@ModelAttribute("PageRequestDTO")PageRequestDTO pageRequestDTO, Model model){

        log.info("list............." + pageRequestDTO);

        model.addAttribute("result", boardService.getList(pageRequestDTO));
      
   //    return "board/list";

    }

    @PostMapping("/remove")
    public String remove(long gno1, RedirectAttributes redirectAttributes){


        log.info("gno1: " + gno1);

        boardService.removeWithReplies(gno1);

        redirectAttributes.addFlashAttribute("msg", gno1);

        return "redirect:/board/list";

    }

    @PostMapping("/modify")
    public String modify(BoardDTO boardDTO,
                         @ModelAttribute("requestDTO") PageRequestDTO requestDTO,
                         RedirectAttributes redirectAttributes){

        log.info("post modify.........................................");
        log.info("dto: " + boardDTO);

        boardService.modify(boardDTO);

        redirectAttributes.addAttribute("page",requestDTO.getPage());
        redirectAttributes.addAttribute("type",requestDTO.getType());
        redirectAttributes.addAttribute("keyword",requestDTO.getKeyword());

        redirectAttributes.addAttribute("gno1",boardDTO.getGno1());

        return "redirect:/board/read";
    }
    
    ////////////////////////////////////////////////////////////////////////////
    @GetMapping("/introduce1")
    public void introduce1(PageRequestDTO pageRequestDTO, Model model){

        log.info("list............." + pageRequestDTO);

        model.addAttribute("result", boardService.getList(pageRequestDTO));
    }

////////////////////////////////////////////////////////////////////////////
    @GetMapping("/introduce2")
    public void introduce2(PageRequestDTO pageRequestDTO, Model model){

        log.info("list............." + pageRequestDTO);

        model.addAttribute("result", boardService.getList(pageRequestDTO));
    }

////////////////////////////////////////////////////////////////////////////  
    @GetMapping("/introduce3")
    public void introduce3(PageRequestDTO pageRequestDTO, Model model){

        log.info("list............." + pageRequestDTO);

        model.addAttribute("result", boardService.getList(pageRequestDTO));
    }

////////////////////////////////////////////////////////////////////////////
    @GetMapping("/introduce4")
    public void introduce4(PageRequestDTO pageRequestDTO, Model model){

        log.info("list............." + pageRequestDTO);

        model.addAttribute("result", boardService.getList(pageRequestDTO));
    }

////////////////////////////////////////////////////////////////////////////
    @GetMapping("/introduce5")
    public void introduce5(PageRequestDTO pageRequestDTO, Model model){

        log.info("list............." + pageRequestDTO);

        model.addAttribute("result", boardService.getList(pageRequestDTO));
    }

////////////////////////////////////////////////////////////////////////////
    @GetMapping("/register")
    public String register(){
        log.info("regiser get...");
        return "/board/register";
    }

    @PostMapping("/register")
    public String registerPost(BoardDTO boardDTO, RedirectAttributes redirectAttributes){

        log.info("dto1..." + boardDTO);
        //새로 추가된 엔티티의 번호
        Long gno1 = boardService.register(boardDTO);

        log.info("gno1: " + gno1);

       redirectAttributes.addFlashAttribute("msg", gno1);

        return "redirect:/board/list";
    }

    @GetMapping({"/read", "/modify" })
    public void read(@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO, Long gno1, Model model){

        log.info("gno1: " + gno1);

        BoardDTO boardDTO = boardService.get(gno1);

        log.info(boardDTO);

        model.addAttribute("dto", boardDTO);

    }


}
	