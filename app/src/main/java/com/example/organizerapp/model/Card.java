package com.example.organizerapp.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;

public class Card {
    private String startAt;
    private String endAt;
    private String text;

    public Card(String startAt, String endAt, String text) {
        this.startAt = startAt;
        this.endAt = endAt;
        this.text = text;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Card{" +
                "stardAt='" + startAt + '\'' +
                ", endAt='" + endAt + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(startAt, card.startAt) &&
                Objects.equals(endAt, card.endAt) &&
                Objects.equals(text, card.text);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(startAt, endAt, text);
    }
}
