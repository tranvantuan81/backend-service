package vn.tuanjava.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.tuanjava.dto.request.UserRequestDTO;
import vn.tuanjava.dto.response.ResponseData;

import java.util.List;

@RestController
@RequestMapping("/user")
@Validated
@Slf4j
public class UserController {

    @PostMapping("/")
    public ResponseData<Integer> addUser(@Valid @RequestBody UserRequestDTO userDTO) {
        log.info("Request add user");
        return new ResponseData<>(HttpStatus.CREATED.value(), "User added successfully", 1);
    }

    @PutMapping("/{userId}")
    public ResponseData<?> updateUser(@PathVariable int userId, @Valid @RequestBody UserRequestDTO userDTO) {
        log.info("Request update userId={}", userId);
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "User updated successfully");
    }
    @PatchMapping("/{userId}")
    public ResponseData<?> changeStatus(@PathVariable int userId, @RequestParam(required = false) boolean status) {
        log.info("Request change user status, userId={}", userId);
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "User status changed");
    }

    @DeleteMapping("/{userId}")
    public ResponseData<?> deleteUser(@Min(1) @PathVariable int userId) {
        log.info("Request delete userId={}", userId);
        return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "User deleted");
    }

    @GetMapping("/{userId}")
    public ResponseData<UserRequestDTO> getUser(@PathVariable int userId) {
        log.info("Request get user detail by userId={}", userId);
        return new ResponseData<>(HttpStatus.OK.value(), "user", new UserRequestDTO("Tuan", "java", "0834995103", "tuanthuan8102@gmail.com"));
    }

    @GetMapping("/list")
    public ResponseData<List<UserRequestDTO>> getAllUser(@RequestParam(defaultValue = "0") int pageNo,
                                           @RequestParam(defaultValue = "10") int pageSize) {
        log.info("Request get all user list");
        return new ResponseData<>(HttpStatus.OK.value(), "users", List.of(new UserRequestDTO("Tuan", "java", "0834995103", "tuanthuan8102@gmail.com"),
                new UserRequestDTO("Tuan", "java", "0834995103", "tuanthuan8102@gmail.com")));
    }
}
