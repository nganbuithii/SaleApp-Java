package com.btn.formatters;

import com.btn.pojo.Category;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CategoryFormatter implements Formatter<Category> {
    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        return null;
    }

    @Override
    public String print(Category object, Locale locale) {
        return null;
    }
}
