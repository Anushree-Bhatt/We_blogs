package net.practice_mvc.WeBlogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class CommandRunner implements CommandLineRunner {
    @Autowired
    private Dummy_user dummy_user;

    @Override
    public void run(String... args) throws Exception {
        dummy_user.setId(100);
        dummy_user.setName("Mr. X");
        System.out.println(dummy_user);
    }
}