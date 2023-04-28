package com.vulnerable.application.controller;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vulnerable.application.model.Developer;
import com.vulnerable.application.model.GenericUser;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class MyController {

    private ObjectMapper objectMapper;

    @PostConstruct
    public void initialize() {
        objectMapper = new ObjectMapper();
        objectMapper.enableDefaultTyping();
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public void redirectToUserInfo(HttpServletResponse response) throws IOException {
        response.sendRedirect("/userinfo");
    }

    @RequestMapping(path = "/userinfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public GenericUser getUserInfo(HttpServletResponse response,
            @CookieValue(name = "user", required = false) String user)
            throws IOException, ClassNotFoundException {
        GenericUser obj;
        if (user == null) {
            FileInputStream fileIn = new FileInputStream("serialized");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            obj = (GenericUser) in.readObject();
            in.close();
            fileIn.close();
            Cookie cookie = new Cookie("user",
                    Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get("serialized"))));
            response.addCookie(cookie);
        } else {
            byte[] decoded = Base64.getDecoder().decode(user);
            InputStream stream = new ByteArrayInputStream(decoded);
            ObjectInputStream in = new ObjectInputStream(stream);
            obj = (GenericUser) in.readObject();
        }
        String flag = obj.isIsAdmin() ? System.getenv("EASYFLAG") : "None :(";
        obj.setFlag(flag);
        return obj;
    }

    @RequestMapping(path = "/userinfo-json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public GenericUser getUserInfo2(@CookieValue(name = "user", required = false) String userjson)
            throws JsonParseException, JsonMappingException, IOException {
        byte[] decoded = Base64.getDecoder().decode(userjson);
        String decodedString = new String(decoded);
        Developer obj = objectMapper.readValue(
                decodedString,
                Developer.class);
        return obj;
    }
}
