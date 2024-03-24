package com.santechture;

public class Alert {
    private String severity;
    private String objectType;
    private String objectID;
    private String packageName;
    private String shortMessage;
    private String longMessage;

    public Alert() {
    }

    public Alert(String severity, String objectType, String objectID, String packageName, String shortMessage, String longMessage) {
        this.severity = severity;
        this.objectType = objectType;
        this.objectID = objectID;
        this.packageName = packageName;
        this.shortMessage = shortMessage;
        this.longMessage = longMessage;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getObjectID() {
        return objectID;
    }

    public void setObjectID(String objectID) {
        this.objectID = objectID;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getShortMessage() {
        return shortMessage;
    }

    public void setShortMessage(String shortMessage) {
        this.shortMessage = shortMessage;
    }

    public String getLongMessage() {
        return longMessage;
    }

    public void setLongMessage(String longMessage) {
        this.longMessage = longMessage;
    }
}
