//package com.example.journalApp;
//
//import com.example.journalApp.entity.User;
//import com.example.journalApp.repository.UserEntryRepo;
//import com.example.journalApp.service.CustomUserDetailService;
//import org.junit.jupiter.api.*;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.util.ArrayList;
//
//import static org.mockito.Mockito.*;
//
//public class CustomUserEntryTest {
//
//    @InjectMocks
//    private CustomUserDetailService userDetailsService;
//
//    @Mock
//    private UserEntryRepo userRepository;
//
//    @BeforeEach
//    void setUp(){
//        MockitoAnnotations.initMocks(this);
//    }
//
//
//
//    @Disabled
//    @Test
//    void loadUserByUsernameTest(){
//        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("Sam_123").password("asdfvbvncms").roles(new ArrayList<>()).build());
//        UserDetails user = userDetailsService.loadUserByUsername("Sam_123");
//        Assertions.assertNotNull(user);
//    }
//}
