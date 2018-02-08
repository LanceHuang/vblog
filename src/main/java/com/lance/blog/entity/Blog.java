package com.lance.blog.entity;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    private Integer id;

    private String author;

    private Date createTime;

    private Date updateTime;

    private String content;
}