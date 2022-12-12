package org.example.entity;

import java.util.Objects;

public class Dodecrypt {

    public String status;

    public Dodecrypt(){

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dodecrypt dodecrypt = (Dodecrypt) o;
        return Objects.equals(status, dodecrypt.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }
}
