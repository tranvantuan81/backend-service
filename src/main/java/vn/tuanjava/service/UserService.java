package vn.tuanjava.service;

import vn.tuanjava.dto.request.UserRequestDTO;
import vn.tuanjava.dto.response.PageResponse;
import vn.tuanjava.dto.response.UserDetailResponse;
import vn.tuanjava.util.UserStatus;

import java.util.List;

public interface UserService {

    long saveUser(UserRequestDTO request);

    void updateUser(long userId, UserRequestDTO request);

    void changeStatus(long userId, UserStatus status);

    void deleteUser(long userId);

    UserDetailResponse getUser(long userId);

    PageResponse<?> getAllUsersWithSortBy(int pageNo, int pageSize, String sortBy);

    PageResponse<?> getAllUsersWithSortByMultipleColumns(int pageNo, int pageSize, String... sorts);
}
