package com.example.xml.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriesViewRootDto {
    @XmlElement
    private List<CategoryViewNameDto> categories;

    public CategoriesViewRootDto() {
    }

    public List<CategoryViewNameDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryViewNameDto> categories) {
        this.categories = categories;
    }
}
