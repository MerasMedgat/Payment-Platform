package org.example.payment_platform.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.payment_platform.enums.AccountTypeEnum;
import org.example.payment_platform.enums.CurrencyEnum;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name="accounts")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountTypeEnum type;

    @JdbcTypeCode(SqlTypes.CHAR)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false,columnDefinition = "char(3)")
    private CurrencyEnum currency;

    @CreationTimestamp
    @Column(nullable=false,updatable=false)
    private Instant createdAt;

    public Account(AccountTypeEnum type,CurrencyEnum currency ) {
        Objects.requireNonNull(type, "type");
        Objects.requireNonNull(currency, "currency");
        this.type = type;
        this.currency= currency;
    }
}
