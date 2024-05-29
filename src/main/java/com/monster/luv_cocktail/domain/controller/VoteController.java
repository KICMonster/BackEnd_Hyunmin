package com.monster.luv_cocktail.domain.controller;

import com.monster.luv_cocktail.domain.entity.Choice;
import com.monster.luv_cocktail.domain.entity.Vote;
import com.monster.luv_cocktail.domain.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/votes")
public class VoteController {

    @Autowired
    private VoteService voteService;

    // 모든 투표 항목
    @GetMapping
    public List<Vote> getAllVotes() {
        return voteService.findAllVotes();
    }

    // ID로 특정 투표 항목
    @GetMapping("/{id}")
    public Vote getVoteById(@PathVariable Long id) {
        return voteService.findVoteById(id);
    }

    // 투표 항목을 생성
    @PostMapping
    public Vote createVote(@RequestBody Vote vote) {
        return voteService.saveVote(vote);
    }

    // ID로 특정 투표 항목을 삭제
    @DeleteMapping("/{id}")
    public void deleteVote(@PathVariable Long id) {
        voteService.deleteVote(id);
    }

    // 특정 선택 항목에 추천 또는 비추천을 추가
    @PostMapping("/vote/{choiceId}")
    public Choice vote(@PathVariable Long choiceId, @RequestParam boolean isLike) {
        return voteService.vote(choiceId, isLike);
    }
}
