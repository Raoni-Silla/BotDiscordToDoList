package br.com.raoni.BotDiscordToDoList.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private boolean completed;

    @Column(name = "UserId", nullable = false)
    private String discordUserId;

}
