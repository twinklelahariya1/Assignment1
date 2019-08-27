package com.finalassignment.bookworm.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLibraryCardDto {

    private Long cardId;

    private UserDto user;

}
