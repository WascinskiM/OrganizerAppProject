package com.example.organizerapp.data.cards;


public enum ActivityData {
    SINGLETON_ACTIVITY;

    private ActivityRepository activityRepository=  new ActivityRepository();


    public ActivityRepository getActivityRepository() {
        return activityRepository;
    }
}
