package com.ohgiraffers.section01.manytoone;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "category_section01")
@Table(name = "tbl_category")
public class Category {

    @Id
    @Column(name = "category_code")
    private int categoryCode;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "ref_category_code")
    private Integer refCategoryCode;


}
