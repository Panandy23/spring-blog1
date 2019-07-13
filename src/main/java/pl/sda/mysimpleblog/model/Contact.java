package pl.sda.mysimpleblog.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "wpisz imię")
    private String name;
    @Email (message = "błędny email")
    @NotBlank (message = "wpisz coś")
    private String email;
    private String phone;
    @NotBlank (message = "wpisz wiadomość")
    @Type(type = "text")
    private String message;
    private LocalDateTime date_added = LocalDateTime.now();
    private boolean status = false;
}
