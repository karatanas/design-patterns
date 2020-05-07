package command;

public class Exercise {

    private Boolean isUp;

    public String standUp() {
        setIsUp(true);
        return "Stand Up";
    }

    public String sitDown() {
        setIsUp(false);
        return "Sit Down";
    }

	public Boolean getIsUp() {
		return isUp;
	}

	public void setIsUp(Boolean isUp) {
		this.isUp = isUp;
	}
}
