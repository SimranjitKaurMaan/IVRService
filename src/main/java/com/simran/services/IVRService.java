package com.simran.services;

import com.simran.exceptions.IVREndedException;
import com.simran.exceptions.NoSuchLevelExistsException;
import com.simran.models.ActionStatus;
import com.simran.models.IVRStatus;
import com.simran.models.Level;
import com.simran.models.Option;

import java.util.List;

public class IVRService
{
    List<Level> levels;
    IVRStatus ivrStatus;

    public IVRService(List<Level> levels)
    {
        this.levels = levels;
        this.ivrStatus = IVRStatus.in_progress;
    }

  private Level getLevel(int levelId)
  {
      if(levelId>levels.size())
          throw new NoSuchLevelExistsException();

      return levels.get(levelId);
  }

  public List<Option> getOptions(int levelId)
  {
      if(this.ivrStatus==IVRStatus.ended)
      {
          throw new IVREndedException();
      }
          if(levelId>levels.size())
            throw new NoSuchLevelExistsException();

      return levels.get(levelId).getOptions();
  }

  public  Level chooseOption(int levelId, Option option)
    {
        if(this.ivrStatus==IVRStatus.ended)
        {
            throw new IVREndedException();
        }

        ActionStatus actionStatus = option.getActionStatus();
        Level nextLevel = null;
        switch(actionStatus)
        {
            case next_level: nextLevel =  getLevel(levelId++); break;
            case prev_level: nextLevel = getLevel(levelId--); break;
            case main_level: nextLevel =  getLevel(0); break;
            case exit: disconnectIVR();break;
            default: break;
        }

        return nextLevel;
    }

    private void disconnectIVR()
    {
        this.ivrStatus = IVRStatus.ended;
    }

}
