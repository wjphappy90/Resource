package cn.itcast.es.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "itcast", type = "user", shards = 6, replicas = 1)
public class User {

    @Id
    private Long id;

    @Field(store = true)
    private String name;

    @Field
    private Integer age;

    @Field
    private String hobby;

}
