package observer;

public class Spectator implements Observer {

    private String name;
    private Observable sportsman;

    public Spectator(String name) {
        this.setName(name);
    }

    @Override
    public void update() {
    	
        if (sportsman == null) {
            System.out.println("No sportsman");
            return;
        }

        String exercise = sportsman.getUpdate();
        
    	System.out.println("Observer: " + this.getName() + " has been updated. Exercise: " + exercise);
    		
    
    }

    @Override
    public void setSportsman(Observable sportsman) {
        this.sportsman = sportsman;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
