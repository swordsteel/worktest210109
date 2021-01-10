package com.example.demo.customers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.ZonedDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

    @InjectMocks
    private CustomerServiceImpl service;

    @Test
    public void sortDueTimeOldToNewWithStream() {
        // given
        var customerA = Customer.builder()
                .id(1)
                .name("A")
                .jointime(ZonedDateTime.parse("2015-12-03T03:31:31-08:00"))
                .duetime(ZonedDateTime.parse("2015-01-17T15:36:04-08:00"))
                .build();
        var customerB = Customer.builder()
                .id(2)
                .name("B")
                .jointime(ZonedDateTime.parse("2014-01-25T20:41:25-08:00"))
                .duetime(ZonedDateTime.parse("2015-07-11T07:26:09-07:00"))
                .build();
        var customerC = Customer.builder()
                .id(3)
                .name("C")
                .jointime(ZonedDateTime.parse("2015-11-25T18:49:32-08:00"))
                .duetime(ZonedDateTime.parse("2014-03-02T09:13:25-08:00"))
                .build();
        var customers = List.of(customerA, customerB, customerC);

        // when
        var response = service.sortDueTimeOldToNewWithStream(customers);

        // then
        assertThat(response.get(0)).isEqualTo(customerC);
        assertThat(response.get(1)).isEqualTo(customerA);
        assertThat(response.get(2)).isEqualTo(customerB);
    }

}