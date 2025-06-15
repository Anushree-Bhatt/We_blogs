package net.practice_mvc.WeBlogs;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Component
public class Dummy_user {
    private String name;
    private Integer id;

}
