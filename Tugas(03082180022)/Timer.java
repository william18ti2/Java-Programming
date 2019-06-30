import greenfoot.*;
public class Timer extends Actor
{
    private int time= 60;
    private int count = 65;
    private boolean counter(){
            if(count>0)
            {
                count--;
            }
            return count==0;
    }

   private void display()
    {
        setImage(new GreenfootImage("TIME LEFT TO WIN: " + time, 30, Color.WHITE, Color.BLACK));
    }
    public void setTime()
    {
        time = 60;
    }
    public void isTimeUp(){
        time = 0;
    }
    public void act() 
        {
        if (time==0)
        {
         Greenfoot.stop();
        }
        if(counter())
        {
            time--;
            count=65;
        }
        display();
    }    
}
