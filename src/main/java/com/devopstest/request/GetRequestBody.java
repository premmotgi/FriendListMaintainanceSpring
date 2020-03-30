package com.devopstest.request;

public class GetRequestBody {

    long id;

    public long getId() {
        return id;
    }

    public GetRequestBody(long id) {
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GetRequestBody{" +
                "id=" + id +
                '}';
    }

    public GetRequestBody() {
    }
}
