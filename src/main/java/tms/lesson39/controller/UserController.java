package tms.lesson39.controller;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tms.lesson39.domain.Address;
import tms.lesson39.domain.User;
import tms.lesson39.repository.AddressRepository;
import tms.lesson39.repository.PhoneRepository;
import tms.lesson39.repository.UserRepository;

import java.util.List;

@Data
@RestController
@RequestMapping(path = "/user")
public class UserController {
    private final UserRepository userRepository;
    private final PhoneRepository phoneRepository;
    private final AddressRepository addressRepository;

    @PostMapping(path = "/add")
    public ResponseEntity<User> add(@RequestBody User user) {
        phoneRepository.saveAll(user.getPhone());
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }

    @GetMapping(path = "/getByLogin")
    public ResponseEntity<User> getUserByLogin(@RequestBody String login) {
        return new ResponseEntity<>(userRepository.findByLogin(login), HttpStatus.OK);
    }

    @GetMapping(path = "/getAllByName")
    public ResponseEntity<List<User>> getAllByName(@RequestBody String name) {
        return new ResponseEntity<>(userRepository.findAllByName(name), HttpStatus.OK);

    }

    @GetMapping(path = "/getAllByAddress")
    public ResponseEntity<User> getAllByAddress(@RequestBody String address) {
        return new ResponseEntity<>(userRepository.findAllByAddress(address), HttpStatus.OK);

    }

    @PostMapping(path = "/address")
    public ResponseEntity<Address> addAddress(@RequestBody Address address) {
        return new ResponseEntity<>(addressRepository.save(address), HttpStatus.CREATED);
    }
}
