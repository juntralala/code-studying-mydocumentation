package mbx;

import java.lang.management.ManagementFactory;

public class OperatingSystemMXBeanApp {
    public static void main(String[] args) {
        var osMbx = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        System.out.println(osMbx.getArch());  // achitecture
        System.out.println(osMbx.getAvailableProcessors());
        System.out.println(osMbx.getCpuLoad());
        System.out.println(osMbx.getFreeMemorySize()); // memori fisik
        System.out.println(osMbx.getTotalMemorySize()); // memori fisik
        System.out.println(osMbx.getTotalSwapSpaceSize());
        System.out.println(osMbx.getFreeSwapSpaceSize());
    }
}
