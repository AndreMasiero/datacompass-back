package com.datacompass.entity;

import com.datacompass.enums.ComponentType;
import com.datacompass.enums.InputType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;

    public Question() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "COMPONENT_TYPE")
    private ComponentType componentType;

    @Column(name = "INPUT_TYPE")
    private InputType inputType;

    @OneToMany(mappedBy = "question", targetEntity = AnswerOptions.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AnswerOptions> answerOptions = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ComponentType getComponentType() {
        return componentType;
    }

    public void setComponentType(ComponentType componentType) {
        this.componentType = componentType;
    }

    public InputType getInputType() {
        return inputType;
    }

    public void setInputType(InputType inputType) {
        this.inputType = inputType;
    }

    public List<AnswerOptions> getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(List<AnswerOptions> answerOptions) {
        this.answerOptions = answerOptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;

        Question question = (Question) o;

        if (id != null ? !id.equals(question.id) : question.id != null) return false;
        if (name != null ? !name.equals(question.name) : question.name != null) return false;
        if (componentType != null ? !componentType.equals(question.componentType) : question.componentType != null)
            return false;
        if (inputType != question.inputType) return false;
        return answerOptions != null ? answerOptions.equals(question.answerOptions) : question.answerOptions == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (componentType != null ? componentType.hashCode() : 0);
        result = 31 * result + (inputType != null ? inputType.hashCode() : 0);
        result = 31 * result + (answerOptions != null ? answerOptions.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", componentType=" + componentType +
                ", inputType=" + inputType +
                ", answerOptions=" + answerOptions +
                '}';
    }
}
