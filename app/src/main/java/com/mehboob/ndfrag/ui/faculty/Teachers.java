package com.mehboob.ndfrag.ui.faculty;

public class Teachers {

    String image,name,email,post ,key;

    public Teachers() {
    }

    public Teachers(String image, String name, String email, String post, String key) {
        this.image = image;
        this.name = name;
        this.email = email;
        this.post = post;
        this.key = key;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
