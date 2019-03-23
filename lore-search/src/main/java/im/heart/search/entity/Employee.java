package im.heart.search.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import javax.persistence.Id;
import java.math.BigInteger;

@Data
@Document(indexName = "company",type = "employee", shards = 1,replicas = 0, refreshInterval = "-1")
public class Employee {
    @Id
    private Long id;
    @Field
    private String firstName;
    @Field
    private String lastName;
    @Field
    private Integer age = 0;
    @Field
    private String about;

}
