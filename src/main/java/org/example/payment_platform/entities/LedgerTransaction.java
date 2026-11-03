package org.example.payment_platform.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name="transactions")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LedgerTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String description;

    @CreationTimestamp
    @Column(nullable=false,updatable=false)
    private Instant createdAt;

    public LedgerTransaction(String description){
        Objects.requireNonNull(description,"description");
        if(description.isBlank()){
            throw new IllegalArgumentException("description must not be blank");
        }
        this.description = description;
    }
}
