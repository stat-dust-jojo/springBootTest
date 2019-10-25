package com.xidian.controller;

import com.xidian.DTO.AccessTokenDTO;
import com.xidian.DTO.GitHubUser;
import com.xidian.provder.ProverByOKhttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class GetCode {
    @Autowired
    ProverByOKhttp proverByOKhttp;
    @GetMapping("/callback")
    public String getcode(@RequestParam(name="code")String code,
                          @RequestParam(name="state")String state){

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("84316e9595129d6e1ccb");
        accessTokenDTO.setClient_secret("e38a81908d0c9e6e0cbd3083ea84bbf908a43186");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDTO.setState(state);
        String s = proverByOKhttp.getcode(accessTokenDTO);
        GitHubUser gitHubUser = proverByOKhttp.getUser(s);
        System.out.println("this is get code and " +gitHubUser);

        return "index";
    }
}
