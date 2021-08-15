package io.pragra.learning.spring_jpadoctorpatirnt.domain;
public enum StatusEnum {

    ORIGINAL("ORIGINAL"),RESCHEDULED("RESCHEDULE"),CANCEL("CANCEL");

    StatusEnum(String str) {
    }

    @Override
    public String toString() {
        return "StatusEnum{}";
    }
}
