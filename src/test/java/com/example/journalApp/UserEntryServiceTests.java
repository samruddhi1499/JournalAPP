//package com.example.journalApp;
//
//import com.example.journalApp.repository.UserEntryRepo;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//public class UserEntryServiceTests {
//
//    @Autowired
//    UserEntryRepo userEntryRepo;
//
//    @Disabled
//    @Test
//    public void testFindByUsername(){
//        assertNotNull(userEntryRepo.findByUserName("Sam_123"));
//    }
//
//    @ParameterizedTest
//    @CsvSource({
//            "1,1,2",
//            "2,10,12",
//            "3,3,10"
//    })
//    @Disabled
//    public void test(int a, int b, int expected){
//        assertEquals(expected, a, b);
//    }
//}
