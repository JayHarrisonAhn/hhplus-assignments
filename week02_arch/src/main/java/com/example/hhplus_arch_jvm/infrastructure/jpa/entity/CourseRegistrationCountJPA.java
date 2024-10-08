package com.example.hhplus_arch_jvm.infrastructure.jpa.entity;

import com.example.hhplus_arch_jvm.application.domain.CourseInfo;
import com.example.hhplus_arch_jvm.application.domain.CourseRegistrationCount;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class CourseRegistrationCountJPA {

    @Id
    private Long courseId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseId")
    private CourseInfoJPA course;

    private Integer count;

    private Integer max;

    public CourseRegistrationCount toDomain() {
        return CourseRegistrationCount.builder()
                .courseId(courseId)
                .count(count)
                .max(max)
                .build();
    }

    static public CourseRegistrationCountJPA fromDomain(CourseRegistrationCount domain) {
        CourseRegistrationCountJPA courseRegistrationCount = new CourseRegistrationCountJPA();
        courseRegistrationCount.setCourseId(domain.getCourseId());
        courseRegistrationCount.setCount(domain.getCount());
        courseRegistrationCount.setMax(domain.getMax());
        return courseRegistrationCount;
    }
}
