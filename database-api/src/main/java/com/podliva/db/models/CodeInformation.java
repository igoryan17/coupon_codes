package com.podliva.db.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = CodeInformation.COLLECTION_NAME)
public class CodeInformation {
    public static final String COLLECTION_NAME = "codes";
    @Id
    private String id;
    private String name;
    @Indexed
    private String code;

    public CodeInformation() {}

    public CodeInformation(String id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
