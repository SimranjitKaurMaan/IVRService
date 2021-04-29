package com.simran.models;

import java.util.List;

public class Level
{
    int id;
    List<Option> options;

    @Override
    public String toString() {
        return "Level{" +
                "id=" + id +
                ", options=" + options +
                '}';
    }


    public List<Option> getOptions() {
        return options;
    }


    public Level(int id, List<Option> options)
    {
        this.id = id;
        this.options = options;
    }

    public List<Option> addOption(Option option)
    {
        options.add(option);
        return options;
    }

    public int getId()
    {
        return this.id;
    }
}
