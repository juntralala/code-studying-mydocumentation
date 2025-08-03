package com.juntralala.entity;

import com.juntralala.eventlistener.UpdatedAtListener;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Calendar;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "categories")
@EntityListeners({
        UpdatedAtListener.class
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category implements UpdatedAtAware {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private String id;

    private String name;

    private String description;

    @Temporal(TemporalType.TIMESTAMP) // di spesikasi jpa 3.2 penggunaan Date, Calendar, annotasi Temporal, TemporalType dan MapKeyTemporal telah di deprecated
    @Column(name = "created_at")
    private Calendar createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
