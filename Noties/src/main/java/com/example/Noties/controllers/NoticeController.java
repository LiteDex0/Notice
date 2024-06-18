package com.example.Noties.controllers;

import com.example.Noties.models.Notice;
import com.example.Noties.services.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    @GetMapping("/notice")
    public String notice(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("notice", noticeService.listNoties(title));
        return "notice";
    }


    @PostMapping("/notice/create")
    public String createnotice(Notice notice) {
        noticeService.savenotice(notice);
        return "notice";
    }

    @PostMapping("/notice/delete/{id}")
    public String deletenotice(@PathVariable Long id) {
        noticeService.deleteNotice(id);
        return "notice";
    }
}