package edu.pro.springdemo6.model;
/*
  @author   george
  @project   spring-demo6
  @class  Hello
  @version  1.0.0 
  @since 02.03.22 - 21.38
*/

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Hello {
    @Id
    private String id;
    private String  from;
    private String  to;
    private String  text;

    public Hello() {
    }

    public Hello(String from, String to, String text) {
        this.from = from;
        this.to = to;
        this.text = text;
    }

    public Hello(String id, String from, String to, String text) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hello hello = (Hello) o;
        return getId().equals(hello.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
