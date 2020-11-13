package com.example.organizerapp.data.cards;

public class ActivityDataClass {
    public final static ActivityDataClass SINGLETON_ACTIVITY= new ActivityDataClass();
    private ActivityRepository activityRepository = new ActivityRepository();

    private ActivityDataClass() {
    }

    public ActivityRepository getActivityRepository() {
        return activityRepository;
    }


}
