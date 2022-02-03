package com.java.JUnit5.extensions;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;


/*
@ExtendWith(FindSlowTestExtension.class)
*/
public class ExtensionTests {

    @RegisterExtension
    static FindSlowTestExtension findSlowTestExtension =
            new FindSlowTestExtension(1000L);

    @Test
    @Disabled
    void extensionTest() throws InterruptedException {
        Thread.sleep(1005);
        System.out.println("Extensions!");
    }

}
