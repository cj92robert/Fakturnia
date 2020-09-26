package com.example.demo.models;

import com.google.common.base.Objects;

public class ErrorResponse {
    private String description;

    public ErrorResponse() {
    }

    public ErrorResponse(String description) {
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
        ErrorResponse errorResponse = (ErrorResponse) o;
        return Objects.equal(description, errorResponse.description);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(description);
    }
}
