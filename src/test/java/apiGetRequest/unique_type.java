package apiGetRequest;


import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.*;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

public class unique_type {
    /*@BeforeClass
    public void beforeClass() {
        baseURI = ConfigurationReader.get("BaseURL");
     */
    @Test
    public void test01() {

        String userName = "leomessi";

        Response response = given()
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:105.0) Gecko/20100101 Firefox/105.0")
                .header("Accept", "*/*")
                .header("Accept-Language", "en-US,en;q=0.5")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("X-CSRFToken", "ZQLYizxX3JMGhPzXkmU4qTIbzhwonDBQ")
                .header("X-Instagram-AJAX", "1006309799")
                .header("X-IG-App-ID", "936619743392459")
                .header("X-ASBD-ID", "198387")
                .header("X-IG-WWW-Claim", "hmac.AR383-y43FSIeWCE5AxtQJcr164RzfY3CFpwVmq_x5RP6EpY")
                .header("Origin", "https://www.instagram.com")
                .header("Alt-Used", "i.instagram.com")
                .header("Connection", "keep-alive")
                .header("Referer", "https://www.instagram.com/")
                .header("Cookie", "mid=YjXZYAALAAFVLSQbnwWT9QWSsyWO; ig_did=AAFA6DAF-864F-4692-9E12-C767942970E4; ig_nrcb=1; csrftoken=ZQLYizxX3JMGhPzXkmU4qTIbzhwonDBQ; ds_user_id=48886629394; shbid=5903\\05448886629394\\0541696028189:01f77980840a6c2acdbaa79eec0b20f0f0671a089e5b987915a7d83c0532c1ed47054fe6; shbts=1664492189\\05448886629394\\0541696028189:01f7796a768427dbcd304098909483ccea8292f37b19740ec6e8065c17f2b2884f083972; datr=JSmXYifOKqR4aXC9KXwdPhhn; sessionid=48886629394%3AHW7pfYYdSYcpvj%3A15%3AAYc-clLvcBCg8d6RWp4W_ZB79MNbDQnC1cJhEVPVE2c; rur=RVA\\05448886629394\\0541696270005:01f7b115351c9e89e44ddf28bba004e18c664429ceddf038ed16333142d32a170406dc28")
                .header("Sec-Fetch-Dest", "empty")
                .header("Sec-Fetch-Mode", "cors")
                .header("ccc", "same-site")
                .header("DNT", "1")
                .header("Sec-GPC", "1")
                .header("TE", "trailers")
                .get("https://i.instagram.com/api/v1/users/web_profile_info/?username=" + userName);
        assertEquals(response.statusCode(), 200);

        JsonPath webProfileInfo = response.jsonPath();
        String Id = webProfileInfo.getString("data.user.id");
        int Follow = webProfileInfo.getInt("data.user.edge_follow.count");
        long Followers = webProfileInfo.getLong("data.user.edge_followed_by.count");
        boolean Private = webProfileInfo.getBoolean("data.user.is_private");

        System.out.println("Id = " + Id);
        System.out.println("Followers = " + Followers);
        System.out.println("Follow = " + Follow);
        System.out.println("Private = " + Private);

        if (!Private) {
            //get follow
            String followingUsers = "";
            String followerUsers = "";
            int counter = 50;
            int followCount = Follow / 50;
            int followMod = Follow % 50;
            int followIder = 0;
            for (int i = 0; i < followCount; i++) {
                followIder = counter * i;
                Response following = given()
                        .header("Connection", "keep-alive")
                        .header("authority", "i.instagram.com")
                        .header("accept", "*/*")
                        .header("accept-language", "tr-TR,tr;q=0.9,en-US;q=0.8,en;q=0.7")
                        .header("cookie", "mid=YsLPVQALAAEsiADDXeLzte2DU34P; ig_did=1A5F4D98-D7FE-4E1D-A970-BA4A3418C04C; ig_nrcb=1; shbid=\"5903\\05448886629394\\0541696247592:01f7db8ab85997fb7c89e359a390e713b56d9cb15c365e5f92ac2d8ebe159621515c4f82\"; shbts=\"1664711592\\05448886629394\\0541696247592:01f7666d59f8968f51463d7232a906a20dd4fab2485824af22477799004d7ceb731040e4\"; datr=qHs5Y0NVYCymQNab0shVonK0; csrftoken=PTGBNzgePeG2tj7JSop4kxrAaMy2NNsF; ds_user_id=48886629394; sessionid=48886629394%3AdLr5wjGxJSYPIN%3A11%3AAYcUdetsZBuw1wWSbACYd9GVnk3zrQPuXohzEzRWcQ; rur=\"RVA\\05448886629394\\0541696313797:01f7cfedac827375a72c19d724843891e65984aa5e1515a9185e9a4724106717c606991f\"")
                        .header("origin", "https://www.instagram.com")
                        .header("referer", "https://www.instagram.com/")
                        .header("sec-ch-ua", "\"Chromium\";v=\"106\", \"Google Chrome\";v=\"106\", \"Not;A=Brand\";v=\"99\"")
                        .header("sec-ch-ua-mobile", "?0")
                        .header("sec-ch-ua-platform", "\"Windows\"")
                        .header("sec-fetch-dest", "empty")
                        .header("sec-fetch-mode", "cors")
                        .header("sec-fetch-site", "same-site")
                        .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36")
                        .header("x-asbd-id", "198387")
                        .header("x-csrftoken", "PTGBNzgePeG2tj7JSop4kxrAaMy2NNsF")
                        .header("x-ig-app-id", "936619743392459")
                        .header("x-ig-www-claim", "hmac.AR383-y43FSIeWCE5AxtQJcr164RzfY3CFpwVmq_x5RP6LNx")
                        .header("x-instagram-ajax", "1006310196")
                        .get("https://i.instagram.com/api/v1/friendships/" + Id + "/following/?count=50&max_id=" + followIder);
                JsonPath friendshipsFollowing = following.jsonPath();
                followingUsers = followingUsers + friendshipsFollowing.getString("users.username");
            }
            System.out.println("followIder = " + followIder);
            if (followMod != 0) {
                Response following = given()
                        .header("Connection", "keep-alive")
                        .header("authority", "i.instagram.com")
                        .header("accept", "*/*")
                        .header("accept-language", "tr-TR,tr;q=0.9,en-US;q=0.8,en;q=0.7")
                        .header("cookie", "mid=YsLPVQALAAEsiADDXeLzte2DU34P; ig_did=1A5F4D98-D7FE-4E1D-A970-BA4A3418C04C; ig_nrcb=1; shbid=\"5903\\05448886629394\\0541696247592:01f7db8ab85997fb7c89e359a390e713b56d9cb15c365e5f92ac2d8ebe159621515c4f82\"; shbts=\"1664711592\\05448886629394\\0541696247592:01f7666d59f8968f51463d7232a906a20dd4fab2485824af22477799004d7ceb731040e4\"; datr=qHs5Y0NVYCymQNab0shVonK0; csrftoken=PTGBNzgePeG2tj7JSop4kxrAaMy2NNsF; ds_user_id=48886629394; sessionid=48886629394%3AdLr5wjGxJSYPIN%3A11%3AAYcUdetsZBuw1wWSbACYd9GVnk3zrQPuXohzEzRWcQ; rur=\"RVA\\05448886629394\\0541696313797:01f7cfedac827375a72c19d724843891e65984aa5e1515a9185e9a4724106717c606991f\"")
                        .header("origin", "https://www.instagram.com")
                        .header("referer", "https://www.instagram.com/")
                        .header("sec-ch-ua", "\"Chromium\";v=\"106\", \"Google Chrome\";v=\"106\", \"Not;A=Brand\";v=\"99\"")
                        .header("sec-ch-ua-mobile", "?0")
                        .header("sec-ch-ua-platform", "\"Windows\"")
                        .header("sec-fetch-dest", "empty")
                        .header("sec-fetch-mode", "cors")
                        .header("sec-fetch-site", "same-site")
                        .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36")
                        .header("x-asbd-id", "198387")
                        .header("x-csrftoken", "PTGBNzgePeG2tj7JSop4kxrAaMy2NNsF")
                        .header("x-ig-app-id", "936619743392459")
                        .header("x-ig-www-claim", "hmac.AR383-y43FSIeWCE5AxtQJcr164RzfY3CFpwVmq_x5RP6LNx")
                        .header("x-instagram-ajax", "1006310196")
                        .get("https://i.instagram.com/api/v1/friendships/" + Id + "/following/?count=" + followMod + "&max_id=" + (Follow - followMod));
                JsonPath friendshipsFollowing = following.jsonPath();
                followingUsers = followingUsers + friendshipsFollowing.getString("users.username");
            }
        }
    }

    String babacik = "ahmet, hasan, daşşak";
    String annecik = "yarrak , ahmet, sne";


}












