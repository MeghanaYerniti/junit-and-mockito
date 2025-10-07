package org.example.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusinessTest {

    @Test
    void findTheGreatestFromAllData_basicScenario() {
        DataService dataServiceStub = new DataServiceStub1();
        Business business = new Business(dataServiceStub);
        int result = business.findTheGreatestFromAllData();
        assertEquals(25, result);
        assertEquals(25, business.findTheGreatestFromAllData());
    }

    @Test
    void findTheGreatestFromAllData_withOneValue() {
        DataService dataServiceStub = new DataServiceStub2();
        Business business = new Business(dataServiceStub);
        int result = business.findTheGreatestFromAllData();
        assertEquals(35, result);
    }

}

// creating stub - overriding actual method
// here method is actually not executed, but we just get the return value
class DataServiceStub1 implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{25, 15, 5};
    }

}


class DataServiceStub2 implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{35};
    }

}