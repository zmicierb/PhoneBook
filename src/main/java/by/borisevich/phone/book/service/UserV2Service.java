package by.borisevich.phone.book.service;

import by.borisevich.phone.book.controller.dto.UserDto;
import by.borisevich.phone.book.domain.UserV2;

import java.util.List;

/**
 * Created by BorisevichDA on 2016-04-22.
 */
public interface UserV2Service extends GenericService<UserV2, Long> {

    List<UserDto> find();

    List<UserDto> getByName(String name);

    UserDto getById(Long id);

    UserDto create(UserDto userDto);

    UserDto createOrUpdate(UserDto userDto);

    void delete(UserDto userDto);

}
