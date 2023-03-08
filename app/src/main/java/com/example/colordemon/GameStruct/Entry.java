package com.example.colordemon.GameStruct;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
public class Entry {
    private boolean liked=false;
    private String author;
    private int authorArtid;
    private int memeid;
    private int likes;
    private int comments;
    private int views;

    private String char_story;
    public Entry(String author, int authorArtid, int memeid, String char_story){
        likes=0;
        comments=0;
        views=0;
        this.author=author;
        this.authorArtid=authorArtid;
        this.memeid=memeid;
        this.char_story = char_story;
    }

    public int getMemeid() {
        return memeid;
    }

    public int getAuthorArtid() {
        return authorArtid;
    }

    public String getAuthor() {
        return author;
    }

    public void setLiked() {
        liked = !liked;
    }
    public boolean getLiked(){
        return liked;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getLikes() {
        return likes;
    }

    public String getChar_story(){return char_story;}
}