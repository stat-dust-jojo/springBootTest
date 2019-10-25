package com.xidian.provder;

import com.alibaba.fastjson.JSON;
import com.xidian.DTO.AccessTokenDTO;
import com.xidian.DTO.GitHubUser;

import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ProverByOKhttp {

    /**
     * 得到accounttoken的body部分进而从中得到code进行返回
     * @param accessTokenDTO
     * @return
     */
    public String getcode(AccessTokenDTO accessTokenDTO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body    = RequestBody.create(mediaType,JSON.toJSONString(accessTokenDTO));
        Request     request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String s =  response.body().string();
            String accessToken = s.split("&")[0].split("=")[1];
            return accessToken;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public GitHubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            //用json的工具将字符串变为对象
            GitHubUser gitHubUser = (GitHubUser) JSON.parseObject(string, GitHubUser.class);
            System.out.println("this is prove different between String and product sting:"+string+"  object"+gitHubUser+"  object.name"+gitHubUser.getName());
            return gitHubUser;


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}

