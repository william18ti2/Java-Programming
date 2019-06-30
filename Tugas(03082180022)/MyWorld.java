import greenfoot.*; 
public class MyWorld extends World
{
    private int pause=0;

    public MyWorld()
    {    
        super(600, 400, 1,false); 
        
        addObject(new Timer(),130,50);
        addObject(new Player(),100,200);
    }
    public void act()
    {
        if(pause>0)pause--;
        else pause=20;
        if(pause==1){
            int py=Greenfoot.getRandomNumber(getHeight());
            addObject(new Enemy(-(2+Greenfoot.getRandomNumber(3))),getWidth()+200,py);
        }
    }
}
