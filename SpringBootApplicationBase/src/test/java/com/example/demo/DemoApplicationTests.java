package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

   @Autowired
   ApplicationContext ctx;

    @Autowired
    DemoApplication app;

    @Test(expected = Exception.class)
    public void testRun() throws Exception {
    	String[] args = {"--node.number=1"};
    	//DemoApplication.main(args);
    	app.run(new DefaultApplicationArguments(args));
    }

}

