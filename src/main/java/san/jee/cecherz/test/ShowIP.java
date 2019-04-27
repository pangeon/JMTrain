package san.jee.cecherz.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ShowIP {
    public static void main(String[] args) {
        InetAddress ip;
        try {

            ip = InetAddress.getLocalHost();
            System.out.println("Current IP address : " + ip.getHostAddress());

        } catch (UnknownHostException e) {

            e.printStackTrace();

        }

    }
}
