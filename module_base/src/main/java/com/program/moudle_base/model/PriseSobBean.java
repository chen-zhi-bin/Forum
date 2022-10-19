package com.program.moudle_base.model;

public class PriseSobBean {
    private String label;
    private int value;
    private boolean isChecked;

    public PriseSobBean() {
    }

    public PriseSobBean(String label, int value, boolean isChecked) {
        this.label = label;
        this.value = value;
        this.isChecked = isChecked;
    }

    public PriseSobBean(String label, int value) {
        this.label = label;
        this.value = value;
        this.isChecked=false;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @Override
    public String toString() {
        return "PriseSobBean{" +
                "label='" + label + '\'' +
                ", value=" + value +
                ", isChecked=" + isChecked +
                '}';
    }
}
