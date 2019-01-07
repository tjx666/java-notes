package tetsRetrofit;

import lombok.ToString;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @Author: YuTengjing
 * @Date: 2019/1/7
 */
public class TestRetrofit {
    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Requests requests = retrofit.create(Requests.class);
//        Call<ResponseBody> getAllUsersCall = requests.getAllUsers();
//        getAllUsersCall.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                System.out.println("call " + call);
//                System.out.println("response " + response.toString());
//                System.out.println("isSuccessful: " + response.isSuccessful());
//                System.out.println("code: " + response.code());
//                System.out.println("message: " + response.message());
//                System.out.println("headers: " + response.headers());
//                System.out.println("body: " + response.body());
//                System.out.println("raw " + response.raw());
//                System.out.println("errorBody: " + response.errorBody());
//
//                try {
//                    if (response.body() != null) {
//                        System.out.println("body.string: " + response.body().string());
//                        System.out.println("body.contentType: " + response.body().contentType());
//                        System.out.println("body.contentLength: " + response.body().contentLength());
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                System.out.println("请求失败");
//                System.exit(1);
//            }
//        });

        Call<ResponseTranslation> call = requests.getUserById("t");
        call.enqueue(new Callback<ResponseTranslation>() {
            @Override
            public void onResponse(Call<ResponseTranslation> call, Response<ResponseTranslation> response) {
                System.out.println(response.body());
                System.exit(0);
            }

            @Override
            public void onFailure(Call<ResponseTranslation> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}


interface Requests {
    @GET("users")
    Call<ResponseBody> getAllUsers();

    @GET("users/{id}")
    Call<ResponseTranslation> getUserById(@Path("id") String id);
}


@ToString
class ResponseTranslation {
    /**
     * code : 1
     * msg : 成功
     * data : {"id":"t","name":null,"sex":false,"birthday":null,"liveAddress":null,"receiveAddress":null,"industry":null,"college":null,"favourites":null,"collectionGoodIds":null,"boughtGoodIds":null,"selfGoodIds":null,"password":"t"}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : t
         * name : null
         * sex : false
         * birthday : null
         * liveAddress : null
         * receiveAddress : null
         * industry : null
         * college : null
         * favourites : null
         * collectionGoodIds : null
         * boughtGoodIds : null
         * selfGoodIds : null
         * password : t
         */

        private String id;
        private Object name;
        private boolean sex;
        private Object birthday;
        private Object liveAddress;
        private Object receiveAddress;
        private Object industry;
        private Object college;
        private Object favourites;
        private Object collectionGoodIds;
        private Object boughtGoodIds;
        private Object selfGoodIds;
        private String password;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object getName() {
            return name;
        }

        public void setName(Object name) {
            this.name = name;
        }

        public boolean isSex() {
            return sex;
        }

        public void setSex(boolean sex) {
            this.sex = sex;
        }

        public Object getBirthday() {
            return birthday;
        }

        public void setBirthday(Object birthday) {
            this.birthday = birthday;
        }

        public Object getLiveAddress() {
            return liveAddress;
        }

        public void setLiveAddress(Object liveAddress) {
            this.liveAddress = liveAddress;
        }

        public Object getReceiveAddress() {
            return receiveAddress;
        }

        public void setReceiveAddress(Object receiveAddress) {
            this.receiveAddress = receiveAddress;
        }

        public Object getIndustry() {
            return industry;
        }

        public void setIndustry(Object industry) {
            this.industry = industry;
        }

        public Object getCollege() {
            return college;
        }

        public void setCollege(Object college) {
            this.college = college;
        }

        public Object getFavourites() {
            return favourites;
        }

        public void setFavourites(Object favourites) {
            this.favourites = favourites;
        }

        public Object getCollectionGoodIds() {
            return collectionGoodIds;
        }

        public void setCollectionGoodIds(Object collectionGoodIds) {
            this.collectionGoodIds = collectionGoodIds;
        }

        public Object getBoughtGoodIds() {
            return boughtGoodIds;
        }

        public void setBoughtGoodIds(Object boughtGoodIds) {
            this.boughtGoodIds = boughtGoodIds;
        }

        public Object getSelfGoodIds() {
            return selfGoodIds;
        }

        public void setSelfGoodIds(Object selfGoodIds) {
            this.selfGoodIds = selfGoodIds;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}



