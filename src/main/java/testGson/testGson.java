package testGson;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

/**
 * @Author: YuTengjing
 * @Date: 2019/1/7
 */
public class testGson {
    public static void main(String[] args) {
        Gson JSON = new Gson();
        System.out.println(JSON.toJson(new Student("YuTengjing", 21)));
        System.out.println(JSON.toJson(new int[]{1, 2, 3, 4, 5}));

        String jsonStr = "{ \"name\": \"LuoYaodong\", \"age\": 21}";
        System.out.println(JSON.fromJson(jsonStr, Student.class).getName());
        ResponseTranslation responseTranslation = JSON.fromJson("{\"code\":1,\"msg\":\"成功\",\"data\":[{\"id\":\"201626204040\",\"name\":\"ly\",\"sex\":false,\"birthday\":null,\"liveAddress\":null,\"receiveAddress\":null,\"industry\":null,\"college\":null,\"favourites\":null,\"collectionGoodIds\":null,\"boughtGoodIds\":null,\"selfGoodIds\":null,\"password\":\"5391848\"},{\"id\":\"201726204030\",\"name\":\"lyr\",\"sex\":false,\"birthday\":null,\"liveAddress\":null,\"receiveAddress\":null,\"industry\":null,\"college\":null,\"favourites\":null,\"collectionGoodIds\":null,\"boughtGoodIds\":null,\"selfGoodIds\":null,\"password\":\"3344\"},{\"id\":\"a\",\"name\":null,\"sex\":false,\"birthday\":null,\"liveAddress\":null,\"receiveAddress\":null,\"industry\":null,\"college\":null,\"favourites\":null,\"collectionGoodIds\":null,\"boughtGoodIds\":null,\"selfGoodIds\":null,\"password\":\"a\"},{\"id\":\"t\",\"name\":null,\"sex\":false,\"birthday\":null,\"liveAddress\":null,\"receiveAddress\":null,\"industry\":null,\"college\":null,\"favourites\":null,\"collectionGoodIds\":null,\"boughtGoodIds\":null,\"selfGoodIds\":null,\"password\":\"t\"}]}", ResponseTranslation.class);
        System.out.println(Arrays.toString(responseTranslation.getData()));
    }
}


@AllArgsConstructor
@Getter
class Student {
    private String name;
    private int age;
}


@ToString
@Getter
class ResponseTranslation {
    private int code;
    private String msg;
    private User[] data;

    @ToString
    private static class User {
        private String id;
        private String name;
        private boolean sex;
        private String birthday;
    }
}
