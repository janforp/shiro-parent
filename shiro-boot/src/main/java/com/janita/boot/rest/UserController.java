package com.janita.boot.rest;

import com.janita.boot.model.Permission;
import com.janita.boot.model.Role;
import com.janita.boot.model.User;
import com.janita.boot.repository.PermissionRepository;
import com.janita.boot.repository.RoleRepository;
import com.janita.boot.repository.UserRepository;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * TODO add description
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger log = LoggerFactory.
            getLogger(UserController.class);

    @Autowired
    private DefaultPasswordService passwordService;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private PermissionRepository permissionRepo;

    @RequestMapping(value = "/auth", method = POST)
    public void authenticate(@RequestParam("email") String email, @RequestParam("password") String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(email, password);
        final Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        // set attribute that will allow session querying
        subject.getSession().setAttribute("email", token.getUsername());
    }

    @RequestMapping(method = GET)
    @RequiresAuthentication
    @RequiresRoles("ADMIN")
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @RequestMapping(value = "do_something", method = GET)
    @RequiresAuthentication
    @RequiresRoles("DO_SOMETHING")
    public List<User> dontHavePermission() {
        return userRepo.findAll();
    }

    @RequestMapping(method = PUT)
    public void initScenario() {
        log.info("Initializing scenario..");
        // clean-up users, roles and permissions
        userRepo.deleteAll();
        roleRepo.deleteAll();
        permissionRepo.deleteAll();
        // define permissions
        final Permission p1 = new Permission();
        p1.setName("VIEW_ALL_USERS");
        permissionRepo.save(p1);
        final Permission p2 = new Permission();
        p2.setName("DO_SOMETHING");
        permissionRepo.save(p2);
        // define roles
        final Role roleAdmin = new Role();
        roleAdmin.setName("ADMIN");
        roleAdmin.getPermissions().add(p1);
        roleRepo.save(roleAdmin);
        // define user
        final User user = new User();
        user.setActive(true);
        user.setCreated(System.currentTimeMillis());
        user.setEmail("pjpires@gmail.com");
        user.setName("Paulo Pires");
        user.setPassword(passwordService.encryptPassword("123qwe"));
        user.getRoles().add(roleAdmin);
        userRepo.save(user);
        log.info("Scenario initiated.");
    }

}
