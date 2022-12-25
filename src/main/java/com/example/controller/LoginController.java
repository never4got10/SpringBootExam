package com.example.controller;

import com.example.domain.Member;
import com.example.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("member")
@Controller
public class LoginController {

    @Autowired
    MemberService memberService;

    @GetMapping("/login")
    public void loginView(){

    }

    @PostMapping("/login")
    public String login(Member member, Model model) {
        Member findMember = memberService.getMember(member);

        if(findMember != null && findMember.getPassword().equals(member.getPassword())) {
            model.addAttribute("member", findMember);
            return "forward:getBoardList";
        } else {
            return "redirect:login";
        }
    }
}
