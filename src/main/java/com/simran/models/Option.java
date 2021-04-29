package com.simran.models;

public class Option
{
    int id;
    String label;
    ActionStatus actionStatus;

    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", actionStatus=" + actionStatus +
                '}';
    }


    public Option(int id,String label, ActionStatus actionStatus)
    {
        this.id = id;
        this.label = label;
        this.actionStatus = actionStatus;
    }

    public ActionStatus getActionStatus()
    {
        return this.actionStatus;
    }
}
