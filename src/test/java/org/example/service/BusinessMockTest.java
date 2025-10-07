package org.example.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BusinessMockTest {

    @Mock
    private DataService dataServiceMock;
    // Class or interface have to be implemented in the future.

    @InjectMocks
    private Business business;
    // Class in which test method is present

    @Test
    void findTheGreatestFromAllData_basicScenario() {
        // returning 2 values - here last value is sent if we call multiple times
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{25, 15, 5}).thenReturn(new int[]{8,2});
        assertEquals(25, business.findTheGreatestFromAllData());
        assertEquals(8, business.findTheGreatestFromAllData());
    }

    @Test
    void findTheGreatestFromAllData_OneValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{35});
        assertEquals(35, business.findTheGreatestFromAllData());
    }

    @Test
    void findTheGreatestFromAllData_EmptyArray() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(Integer.MIN_VALUE, business.findTheGreatestFromAllData());
    }

    @Test
    void findTheGreatestFromAllData_EmptyArrayException() {
        //throwing exception
        when(dataServiceMock.retrieveAllData()).thenThrow(new RuntimeException("Array is empty"));
        assertThrows(RuntimeException.class, () -> business.findTheGreatestFromAllData());
    }

    @Test
    void findTheGreatestFromAllData_OneValueBDDStyle() {
        // Behavior-Driven Development - given().willReturn()
        given(dataServiceMock.retrieveAllData()).willReturn(new int[]{35});
        assertEquals(35, business.findTheGreatestFromAllData());
    }

    @Test
    void verifyingFindTheGreatestFromAllData_OneValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{25, 15, 5}).thenReturn(new int[]{8,2});
        business.findTheGreatestFromAllData();
        // Used to check weather method is called and how many times and what are arguments.
        verify(dataServiceMock).retrieveAllData();
    }

}
