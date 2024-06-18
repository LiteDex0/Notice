package com.example.Noties.services;

import com.example.Noties.models.Notice;
import com.example.Noties.repositories.notiesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class NoticeService {
    private final notiesRepository notiesRepository;

    public List<Notice>listNoties(String title) {
        if (title != null) return notiesRepository.findByTitle(title);
        return notiesRepository.findAll();
    }

    public void savenotice(Notice notice) {
        log.info("Saving new {}", notice);
        notiesRepository.save(notice);
    }

    public void deleteNotice(Long id) {
        notiesRepository.deleteById(id);
    }

    public Notice getNoticeById(Long id) {
        return notiesRepository.findById(id).orElse(null);
    }
}
