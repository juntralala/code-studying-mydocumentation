package enumConvertion;

public enum Level {
    STANDARD("Standard Edition"),
    PREMIUM("Premium Ediotion"),
    VIP("VIP Edition");

    private String description;

    Level(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
