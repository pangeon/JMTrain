package san.jee.cecherz.service;

import org.junit.jupiter.api.Test;

public class ProfileServiceTest {

    ProfileService profileService = new ProfileService();

    @Test
    void encryptPassTest() {
        String[] md5pass = new String[16];
        md5pass[0] = profileService.encryptPass("laska37");
        md5pass[1] = profileService.encryptPass("Alfaromeo88a");
        md5pass[2] = profileService.encryptPass("Zaradny33");
        md5pass[3] = profileService.encryptPass("adamos88");
        md5pass[4] = profileService.encryptPass("DaS3Ek#");
        md5pass[5] = profileService.encryptPass("OleniuniaMoja");
        md5pass[6] = profileService.encryptPass("W44#00Abc");
        md5pass[7] = profileService.encryptPass("123er");
        md5pass[8] = profileService.encryptPass("test123");
        md5pass[9] = profileService.encryptPass("test1234");
        md5pass[10] = profileService.encryptPass("tester123");
        md5pass[11] = profileService.encryptPass("Kowalski88a");
        md5pass[12] = profileService.encryptPass("Pangeon88a");
        md5pass[13] = profileService.encryptPass("Alfaromeo88ab");
        md5pass[14] = profileService.encryptPass("Konopielka55");
        md5pass[15] = profileService.encryptPass("Warszawa15");
        for (int i = 0; i < md5pass.length; i++) {
            System.out.println("i:  " + i + " pass:  "  + md5pass[i]);

        }

    }
}
