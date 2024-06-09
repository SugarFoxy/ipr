package perf.api.user.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode()
@ToString
public class UserDto {
    private Long id;
    private String name;
    private String email;
}
