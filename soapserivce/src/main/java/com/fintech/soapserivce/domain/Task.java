package com.fintech.soapserivce.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Task")
@Table(name = "tasks")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int priority;

    @ManyToOne(fetch = FetchType.EAGER)
    private Person person;

    public enum PriorityLevels {
        URGENT(5, "Khẩn cấp", "table-danger"),
        HIGH(4, "Cao", "table-warning"),
        MEDIUM(3, "Trung bình", "table-success"),
        LOW(2, "Thấp", "table-info"),
        NO(1, "Không", "table-secondary");

        private int code;
        private String name;
        private String classBtrap;

        PriorityLevels(int code, String name, String classBtrap) {
            this.code = code;
            this.name = name;
            this.classBtrap = classBtrap;
        }

        public static PriorityLevels getPriorityByCode(int value) {
            for (PriorityLevels level : PriorityLevels.values()) {
                if (level.code == value) return level;
            }
            throw new IllegalArgumentException("Kiểu cấp bậc ưu tiên không tồn tại!");
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public String getClassBtrap() {
            return classBtrap;
        }
    }
}
