package com.example.arrestmanagement.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.sql.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity

@Table(name = "ident_doc")
public class IdentDoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Min(1)
    @Max(2)
    @Column(name = "type")
    private int type;


    @Column(name = "number_series")
    private String numberSeries;


    @Column(name = "issue_date")
    private Date issueDate;


}
