package com.btn.formatters;

import com.btn.pojo.Category;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CategoryFormatter implements Formatter<Category> {
    @Override
    public Category parse(String id, Locale locale) throws ParseException {
        Category c = new Category();
        c.setId(Integer.parseInt(id));
        return  c;
    }

    @Override
    public String print(Category cate, Locale locale) {
        return String.valueOf(cate.getId());
    }
}
