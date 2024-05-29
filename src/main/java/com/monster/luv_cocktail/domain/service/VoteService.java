package com.monster.luv_cocktail.domain.service;

import com.monster.luv_cocktail.domain.entity.Choice;
import com.monster.luv_cocktail.domain.entity.Vote;
import com.monster.luv_cocktail.domain.repository.ChoiceRepository;
import com.monster.luv_cocktail.domain.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private ChoiceRepository choiceRepository;

    // 모든 투표 항목
    public List<Vote> findAllVotes() {
        return voteRepository.findAll();
    }

    // ID로 특정 투표 항목
    public Vote findVoteById(Long id) {
        return voteRepository.findById(id).orElse(null);
    }

    // 투표 항목을 저장
    public Vote saveVote(Vote vote) {
        return voteRepository.save(vote);
    }

    // ID로 특정 투표 항목을 삭제
    public void deleteVote(Long id) {
        voteRepository.deleteById(id);
    }

    // 특정 선택 항목에 추천 또는 비추천을 추가
    public Choice vote(Long choiceId, boolean isLike) {
        Choice choice = choiceRepository.findById(choiceId).orElseThrow(() -> new RuntimeException("Choice not found"));
        if (isLike) {
            choice.setLikeCount(choice.getLikeCount() + 1);
        } else {
            choice.setDislikeCount(choice.getDislikeCount() + 1);
        }
        return choiceRepository.save(choice);
    }
}
