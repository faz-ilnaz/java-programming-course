package controller.api;

import model.User;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.UserRepository;
import viewobject.UserVO;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private UserRepository userRepository;

    @Autowired
    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<UserVO> find(@PathVariable Long id){
        User user = userRepository.findOne(id);
        if (user == null) {
            return new ResponseEntity<UserVO>(HttpStatus.NOT_FOUND);
        }
        UserVO result = new DozerBeanMapper().map(user, UserVO.class);
        return new ResponseEntity<UserVO>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public UserVO create(@RequestBody User user){
        return new DozerBeanMapper().map(userRepository.save(user), UserVO.class);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public UserVO update(@PathVariable Long id, @RequestBody User user){
        return new DozerBeanMapper().map(userRepository.save(user), UserVO.class);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        userRepository.delete(id);
    }


}
