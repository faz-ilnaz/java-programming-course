package controller.editor;

import model.Employee;

import java.beans.PropertyEditorSupport;

public class EmployeeEditor extends PropertyEditorSupport {
    @Override
    public String getAsText() {
        Employee employee = (Employee) getValue();
        return (employee != null)
                ? employee.getId().toString()
                : null;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new Employee(Long.parseLong(text)));
    }


}
