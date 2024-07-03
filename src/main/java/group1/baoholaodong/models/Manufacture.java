package group1.baoholaodong.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Manufacture {
    int id;
    String name;
    String description;
    LocalDateTime createAt;
    LocalDateTime updateAt;
    byte status;
    byte prevStatus;
}
