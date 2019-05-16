package san.test.cecherz.util;

import org.junit.jupiter.api.Test;
import san.jee.cecherz.util.TokenProvider;

import static org.junit.jupiter.api.Assertions.*;

class TokenProviderTest {

    TokenProvider tp = new TokenProvider();

    @Test
    void getSameToken() {
        System.out.println(tp.getToken() + " is the same as " + tp.getToken());
        assertEquals(tp.getToken(), tp.getToken());
    }
    @Test
    void getDifferentToken() {
        System.out.println(tp.getToken() + " is not the same as " + new TokenProvider().getToken());
        assertNotEquals(tp.getToken(), new TokenProvider().getToken());
    }
    @Test
    void getLengthToken() {
        System.out.println("token length is: " + tp.getToken().length());
        assertEquals(tp.getToken().length(), 7);
    }
}


