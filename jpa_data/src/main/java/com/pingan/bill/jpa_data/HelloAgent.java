package com.pingan.bill.jpa_data;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;

public class HelloAgent {
    public static void main(String[] args) throws InterruptedException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, MalformedObjectNameException {
        MBeanServer server= ManagementFactory.getPlatformMBeanServer();
        ObjectName helloName=new ObjectName("jmxBean:name=hello");
        server.registerMBean(new Hello(),helloName);
        TimeUnit.HOURS.sleep(1);
    }
}
