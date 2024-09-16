package edu.wsyu.entity.vo;

import edu.wsyu.entity.dto.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizerVO {
    private Long uid;
    private String name;
    private String username;
    private String avatar;
    private String address;
    private String descText;
    private List<String> role;
    private String token;

//    @JsonSerialize(using = LocalDateSerializer.class)
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
//    private LocalDate expire;


    public AuthorizerVO(User user, String token) {
        this.uid = user.getUid();
        this.name = user.getName();
        this.username = user.getUsername();
        this.avatar = user.getAvatar();
        this.address = user.getAddress();
        this.role = user.getRoles().stream().map(Role::getName).toList();
        this.token = token;
    }
}
