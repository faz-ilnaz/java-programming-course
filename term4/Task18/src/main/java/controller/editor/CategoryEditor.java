package controller.editor;

import model.Category;

import java.beans.PropertyEditorSupport;

public class CategoryEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) {
        setValue(new Category(Long.parseLong(text)));
    }

    @Override
    public String getAsText() {
        Category category = (Category) getValue();
        return (category != null)
                ? category.getId().toString()
                : null;
    }
}