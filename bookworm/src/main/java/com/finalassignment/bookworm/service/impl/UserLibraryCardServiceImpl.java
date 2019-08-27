package com.finalassignment.bookworm.service.impl;

import com.finalassignment.bookworm.dto.UserLibraryCardDto;
import com.finalassignment.bookworm.exception.UserLibraryCardNotFoundException;
import com.finalassignment.bookworm.exception.UserNotFoundException;
import com.finalassignment.bookworm.model.User;
import com.finalassignment.bookworm.model.UserLibraryCard;
import com.finalassignment.bookworm.repository.UserLibraryCardRepository;
import com.finalassignment.bookworm.service.UserLibraryCardService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static com.finalassignment.bookworm.util.DtoUtil.fromUserLibraryCard;
import static com.finalassignment.bookworm.util.DtoUtil.fromUserLibraryCardDto;


@Service
public class UserLibraryCardServiceImpl implements UserLibraryCardService {


    private final UserLibraryCardRepository userLibraryCardRepository;

    public UserLibraryCardServiceImpl(UserLibraryCardRepository userLibraryCardRepository) {
        this.userLibraryCardRepository = userLibraryCardRepository;
    }




    @Override
    public UserLibraryCardDto addLibraryCardEntry(UserLibraryCardDto userLibraryCardDto) {
        UserLibraryCard userLibraryCard = userLibraryCardRepository.save(fromUserLibraryCardDto(userLibraryCardDto));
        return userLibraryCardDto;
    }

    @Override
    public List<UserLibraryCardDto> getCardDetails() {
//        return userLibraryCardRepository.findAll();

        List<UserLibraryCard> userLibraryCards = userLibraryCardRepository.findAll();
        List<UserLibraryCardDto> userLibraryCardDtos = null;
        if (!CollectionUtils.isEmpty(userLibraryCards)) {
            userLibraryCardDtos = new ArrayList<>();
            for (UserLibraryCard userLibraryCard : userLibraryCards) {
                UserLibraryCardDto userLibraryCardDto = fromUserLibraryCard(userLibraryCard);
                userLibraryCardDtos.add(userLibraryCardDto);
            }
            return userLibraryCardDtos;
        }
        return null;
    }

    @Override
    public UserLibraryCardDto findById(Long cardId) {
//        return userLibraryCardRepository.findById(cardId).orElseThrow(()-> new UserNotFoundException(cardId));

        UserLibraryCard userLibraryCard = userLibraryCardRepository.findById(cardId).orElseThrow(() -> new UserLibraryCardNotFoundException(cardId));
        UserLibraryCardDto userLibraryCardDto = fromUserLibraryCard(userLibraryCard);
        return userLibraryCardDto;
    }
}
