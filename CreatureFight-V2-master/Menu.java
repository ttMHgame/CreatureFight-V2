import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
     * Write a description of class Player here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    public class Menu extends Actor
    {
        private TextBox titleBar;
        private TextBox menuItems;
        private MenuCommands menuCommands;
        private Color mainFG;
        private Color mainBG;
        private Color secondFG;
        private Color secondBG;
        private int titleHeight;
        private int menuHeight;
        private int fontSize = 24;
        private boolean visible = false;
    
        /**
         * A default constructor for objects of class Menu
         * 
         * @param There are no parameters
         * @return An object of type Menu
         */
        public Menu() 
        {
            this("not initialized", "none", 24, Color.BLACK, Color.LIGHT_GRAY, Color.BLACK, Color.WHITE, null);
        }
        
        /**
         * A constructor for objects of class Menu
         * 
         * @param title is the text displayed in the main section of the menu
         * @param items is the text that is displayed in the submenu section of the menu
         * @param size is the text size that will be used to display the text from the menu
         * @param mfg is the main foreground color (or the text color for the main section) of the menu
         * @param mbg is the main background color (or the background color for the main section) of the menu
         * @param sfg is the submenu foreground color (or the text color for the submenu section) of the menu
         * @param sbg is the submenu background color (or the background color for the submenu section) of the menu
         * @param commands stores an object that deals with the functionality of the menu
         * @return An object of type Menu
         */
        public Menu(String title, String items, int size, Color mfg, Color mbg, Color sfg, Color sbg, MenuCommands commands)
        {
            mainFG = mfg;
            mainBG = mbg;
            secondFG = sfg;
            secondBG = sbg;
            fontSize = size;
            menuCommands = commands;
            titleBar = new TextBox(title, fontSize, true, mainFG, mainBG);
            menuItems = new TextBox(items, fontSize, true, secondFG, secondBG);
        }
    
        /**
         * addedToWorld is a method that is run when a new object of this class
         * is added to the world
         * 
         * @param w is the reference to the world it is added to
         * @return Nothing is returned
         */
        protected void addedToWorld(World w) 
        {
            w.addObject(titleBar, getX(), getY());
            titleHeight = titleBar.getImage().getHeight();
            menuHeight = menuItems.getImage().getHeight();
        }
    
        /**
         * Act - do whatever the Menu wants to do. This method is called whenever
         * the 'Act' or 'Run' button gets pressed in the environment.
         */
        public void act() 
        {
            // Add your action code here.
            handleMouse();
        }    
    
        /**
         * handleMouse handles mouse interactions that the user makes
         * with the menu
         * 
         * @param There are no parameters
         * @return Nothing is returned
         */
        private void handleMouse()
        {   
            int menuIndex;
            MouseInfo mi;
            
            //TODO (32): Declare a local CreatureWorld variable called world that is initialized to a reference to the CreatureWorld (remember this requires casting)
            
            CreatureWorld world = (CreatureWorld)getWorld();
            //TODO (33): Declare an local integer variable called distance that is not initialized
            int distance;
            
    
            //TODO (34): If the turn number is equal to one... (You'll need to use the getTurnNumber method of the world)
            if(world.getTurnNumber() == 1){
            
                //TODO (35): If the text of the titleBar equals (ignoring case) the word Fight...
                if(titleBar.getText().equalsIgnoreCase("Fight")){
                
                    //TODO (36): Initialize the distance variable to 35
                    distance = 35;
                //TODO (37): Otherwise...
            }else{
                    //TODO (38): Initialize the distance variable to 195
                    distance = 195;
                }
            } else{
            //TODO (39): Otherwise...
            
                //TODO (40): If the text of the titleBar equals (ignoring case) the word Fight...
                if( titleBar.getText().equalsIgnoreCase("Fight")) {
                
                    //TODO (41): Initialize the distance variable to 362
                    distance = 362;
                //TODO (42): Otherwise...
            }else{
                
                    //TODO (43): Initialize the distance variable to 195
                    distance = 195;
                }
    
            }
            if(Greenfoot.mouseClicked(titleBar) == true)
            {
                if(visible == false)
                {
                getWorld().addObject(menuItems, getX(), getY() + (titleHeight + menuHeight) / 2);
            }                           
            else 
            {
                getWorld().removeObject(menuItems);
            }
            
            visible = !visible;
        }

        if(Greenfoot.mouseClicked(menuItems) == true)
        {
            mi = Greenfoot.getMouseInfo();
            menuIndex = ((mi.getY() - menuItems.getY() + menuHeight / 2) - 1) / fontSize;
            visible = !visible;
            getWorld().removeObject(menuItems);
            
            //TODO (44): Access the execute method of the menuCommands variable using the menuIndex variable and getObjectsInRange( distance, Creature.class ).get(0) as the parameters for execute 
            menuCommands.execute(menuIndex, getObjectsInRange(distance,Creature.class).get(0));
        }    
    }   
}
