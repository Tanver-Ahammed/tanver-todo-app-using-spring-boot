package org.dsi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TodoDTO {

    private Long id;

    private String title;

    private String details;

    private Date date;

    private String status;

    private Integer priority;

}
