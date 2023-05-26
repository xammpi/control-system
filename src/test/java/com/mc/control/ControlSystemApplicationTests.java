package com.mc.control;

import com.mc.control.models.*;
import com.mc.control.services.DepartmentService;
import com.mc.control.services.ProblemAreaService;
import com.mc.control.services.ReporterService;
import com.mc.control.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
class ControlSystemApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private ReporterService reporterService;
    @Autowired
    private ProblemAreaService problemAreaService;
    @Autowired
    private DepartmentService departmentService;

    @Test
    void createUser() {
        User user = User.builder()
                .email("rekatun@icloud.com")
                .username("rekatun")
                .password("gtvdakl45gte")
                .active(true)
                //.roles(Collections.singleton(Role.ADMIN))
                .build();
        userService.save(user);
    }

    @Test
    void createReporter() {
        User user = userService.findByEmail("rekatun@icloud.com");
        Reporter reporter = Reporter.builder()
                .lastName("Culicov")
                .firstName("Maxim")
                .phone("079081187")
                .user(user)
                .build();
        reporterService.update(user.getId(), reporter);
    }

    @Test
    void getUser() {
        System.out.println(userService.findByEmail("rekatun@icloud.com"));
    }

    @Test
    void getReporter() {
        Reporter reporter = reporterService.findById(1l);
        System.out.println(reporter);
        System.out.println(reporter.getReporterProblemAreas());
    }


    @Test
    void deleteUser() {
        userService.deleteById(1L);
    }

    @Test
    void deleteReporter() {
        reporterService.deleteById(1L);
    }

    @Test
    void addProblemArea() {
        ProblemArea problemArea = ProblemArea.builder()
                .name("home")
                .problemAreaNumber(1)
                .build();
        problemAreaService.save(problemArea);
    }

    @Test
    void updateProblemArea() {
        ProblemArea problemArea = problemAreaService.findById(1L);
        Address address =Address.builder()
                .blockNumber(9)
                .streetName("Valea crucii")
                .city("Chisinau")
                .build();
        problemArea.setAddress(address);
        problemAreaService.update(problemArea.getId(), problemArea);
    }


    @Test
    void addDepartment() {
        Department department= Department.builder()
                .name("home")
                .build();
        departmentService.save(department);
    }

    @Test
    void addProblemAreaToReporter() {
        ProblemArea problemArea = problemAreaService.findById(1L);
        Reporter reporter = reporterService.findById(1L);
        reporter.setReporterProblemAreas(Set.of(problemArea));
        reporterService.update(reporter.getId(), reporter);
    }

    @Test
    void addDepartmentToReporter() {
        Department department = departmentService.findById(1L);
        Reporter reporter = reporterService.findById(1L);
        reporter.setReporterDepartments(Set.of(department));
        reporterService.update(reporter.getId(), reporter);
    }

}
