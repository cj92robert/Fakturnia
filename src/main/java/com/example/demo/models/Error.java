package com.example.demo.models;

import com.google.common.base.Objects;

public class Error {
    private String description;

    public Error() {
    }

    public Error(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Error error = (Error) o;
        return Objects.equal(description, error.description);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(description);
    }
}
