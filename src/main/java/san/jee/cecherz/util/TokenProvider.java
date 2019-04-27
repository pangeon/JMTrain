package san.jee.cecherz.util;

import java.security.SecureRandom;

public class TokenProvider {
    private String token;
    {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        token = bytes.toString().substring(3, 11);
    }
    public String getToken() {
        return token;
    }
    public static void main(String[] args) {
        System.out.println(new TokenProvider().getToken());
    }

}
