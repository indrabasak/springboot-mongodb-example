package com.basaki.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * {@code Book} represents a book entity.
 * <p/>
 *
 * @author Indra Basak
 * @since 11/23/17
 */
@Document(collection = "Books")
@Data
@NoArgsConstructor
@ApiModel(value = "Book")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book implements Serializable {

    @ApiModelProperty(value = "identity of a book")
    @Id
    private UUID id;

    @ApiModelProperty(value = "book title")
    private String title;

    @ApiModelProperty(value = "book author")
    private String author;
}