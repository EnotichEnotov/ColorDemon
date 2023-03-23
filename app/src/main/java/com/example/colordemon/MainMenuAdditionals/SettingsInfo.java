package com.example.colordemon.MainMenuAdditionals;

public class SettingsInfo {
    protected float volume;
    protected String language;

    public SettingsInfo(float volume, String language) {
        this.volume = volume;
        this.language = language;
    }

    public float getVolume() {
        return volume;
    }

    public String getLanguage() {
        return language;
    }
}
