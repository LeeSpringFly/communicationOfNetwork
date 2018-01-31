package com.lee.communicationofnetwork.service;

import com.lee.communicationofnetwork.CommunicationofnetworkApplication;
import com.lee.communicationofnetwork.entity.NetworkServerInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CommunicationofnetworkApplication.class)
public class CommunicationServiceTest {

    private static CommunicationService communicationService;

    @Autowired
    public void setCommunicationService(CommunicationService communicationService) {
        CommunicationServiceTest.communicationService = communicationService;
    }

    @Test
    public void test() throws Exception {

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    System.out.println(1);
                    Thread.sleep(5000);
                    System.out.println(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                communicationService.close();
            }
        }).start();

        communicationService.start(new NetworkServerInfo(1L, 8888));

    }

}
