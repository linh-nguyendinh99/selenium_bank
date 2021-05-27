package com.example.bank;
import com.example.bank.repository.LoanRepository;
import com.example.bank.repository.PayRepository;
import com.example.bank.service.LoanServiceIml;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class LoanServiceTest {
    @TestConfiguration
    public static class LoanServiceTestConfiguration{
        @Bean
        LoanServiceIml loanServiceIml(){
            return new LoanServiceIml();
        }

    }
    @MockBean
    LoanRepository loanRepository;
    @MockBean
    PayRepository payRepository;

    @Autowired
    private LoanServiceIml loanServiceIml;

    @Before
    public void setUp() {
    }

    @Test
    public void testCount() {
        Assert.assertEquals(10, 10);
    }
}
