package testJackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.IOException;

/**
 * 参考文章: https://blog.csdn.net/u011054333/article/details/80504154
 *
 * @Author: YuTengjing
 * @Date: 2019/1/7
 */
public class TestJackson {
    public static void main(String[] args) throws IOException {
        ObjectMapper JSON = new ObjectMapper();
        JSON.enable(SerializationFeature.INDENT_OUTPUT);
        CSDNResponse csdnResponse = new CSDNResponse(200, "baidu_zhannei_search_key_v1_all_all_cd4b478aeed6c1bc43c0b974024fc34f写入redis操作成功", null, false);
        String jsonStr = JSON.writeValueAsString(csdnResponse);
        System.out.println(jsonStr);
        System.out.println(JSON.readValue(jsonStr, CSDNResponse.class).getStatus());
    }


    @AllArgsConstructor
    @NoArgsConstructor
    private static class CSDNResponse {

        /**
         * status : 200
         * msg : baidu_zhannei_search_key_v1_all_all_cd4b478aeed6c1bc43c0b974024fc34f写入redis操作成功
         * content : null
         * error : false
         */

        @JsonProperty("code")
        private int status;
        private String msg;
        private Object content;
        private boolean error;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public Object getContent() {
            return content;
        }

        public void setContent(Object content) {
            this.content = content;
        }

        public boolean isError() {
            return error;
        }

        public void setError(boolean error) {
            this.error = error;
        }
    }
}


