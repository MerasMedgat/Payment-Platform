package org.example.payment_platform.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.payment_platform.enums.EntryDirectionEnum;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name="entries")
@Getter
@NoArgsConstructor( access = AccessLevel.PROTECTED)
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY,optional = false)
    @JoinColumn(name="transaction_id",nullable=false)
    private LedgerTransaction transaction;

    @ManyToOne(fetch=FetchType.LAZY,optional = false)
    @JoinColumn(name="account_id",nullable=false)
    private Account account ;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private EntryDirectionEnum direction;

    @Column(nullable=false,precision=19,scale=4)
    private BigDecimal amount;

    public Entry(LedgerTransaction transaction, Account account,EntryDirectionEnum direction , BigDecimal amount){
        Objects.requireNonNull(direction,"direction");
        Objects.requireNonNull(amount,"amount");
        Objects.requireNonNull(transaction,"transaction_id");
        Objects.requireNonNull(account,"account_id");
        if(amount.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("amount must  be positive");
        }
        this.transaction = transaction;
        this.account = account;
        this.direction = direction;
        this.amount = amount;
    }

}
