package san.jee.cecherz.service;

import org.junit.jupiter.api.Test;

public class ProfileServiceTest {

    ProfileService profileService = new ProfileService();

    /*
    +----+---------------+----------------------------------+
    | id | password      | md5pass
    +----+---------------+----------------------------------+
    |  1 | ąężźćłó       | 12c44a927ee9fc12f97ee80c55353780
    |  2 | Alfaromeo88a  | ef21dbe084b394c9a8cd1a65fd7e54ee
    |  3 | Zaradny33     | 36d9349a9c3b70184b209f3acf69ed03
    |  4 | adamos88      | 3bfa575c4e2bd3e3470defa718dca2ed
    |  5 | DaS3Ek#       | 7ffe7df02ac3ce14e7ad6c6048df1352
    |  6 | OleniuniaMoja | 6e1cb029e0e57561a190af445d8287f7
    |  7 | W44#00Abc     | 967133b87c245338e5652eae9e33e838
    |  8 | 123er         | cb860a88452cf25c1ca5b7e96d3a73bc
    |  9 | test123       | cc03e747a6afbbcbf8be7668acfebee5
    | 10 | test1234      | 16d7a4fca7442dda3ad93c9a726597e4
    | 11 | tester123     | 8e607a4752fa2e59413e5790536f2b42
    | 12 | Kowalski88a   | 4153abde79bd3ee860a2ec135eb9440d
    | 13 | Pangeon88a    | 8d280370a955cc53276ff4d6a409d9cc
    | 14 | Alfaromeo88ab | f5f8e86787337054f9790242cb13600a
    | 15 | Konopielka55  | d235db7676dadac6ddd219d6b9ed9cef
    | 16 | Warszawa15    | 32574a0397e51d66a65cba7f7d98e620
    +----+---------------+----------------------------------+
    UPDATE PROFILES SET password="12c44a927ee9fc12f97ee80c55353780" WHERE id=1;
    UPDATE PROFILES SET password="ef21dbe084b394c9a8cd1a65fd7e54ee" WHERE id=2;
    UPDATE PROFILES SET password="36d9349a9c3b70184b209f3acf69ed03" WHERE id=3;
    UPDATE PROFILES SET password="3bfa575c4e2bd3e3470defa718dca2ed" WHERE id=4;
    UPDATE PROFILES SET password="7ffe7df02ac3ce14e7ad6c6048df1352" WHERE id=5;
    UPDATE PROFILES SET password="6e1cb029e0e57561a190af445d8287f7" WHERE id=6;
    UPDATE PROFILES SET password="967133b87c245338e5652eae9e33e838" WHERE id=7;
    | id | email                          |
    +----+--------------------------------+
    |  1 | agnieszka.lasota2@vp.pl        |
    |  2 | kamil.cecherz@gmail.com        |
    |  3 | bed46@wp.pl                    |
    |  4 | wolnygosc@interia.pl           |
    |  5 | a.kowal16@tlen.pl              |
    |  6 | radekignasiak13@onet.pl        |
    |  7 | m.wlazlak@wsparciespoleczne.pl |
    |  8 | e.robert@tlen.pl               |
    |  9 | test@test.pl                   |
    | 10 | test@op.pl                     |
    | 11 | tester@op.pl                   |
    | 12 | adam.kowalski@op.pl            |
    | 13 | mariusz@op.pl                  |
    | 14 | kamil.c@tlen.pl                |
    | 15 | adam.mickiewicz@lektura.pl     |
    | 16 | adam.kos@tlen.pl
     */
    @Test
    void encryptPassTest() {
        String[] md5pass = new String[16];
        md5pass[0] = profileService.encryptPass("ąężźćłó");
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
