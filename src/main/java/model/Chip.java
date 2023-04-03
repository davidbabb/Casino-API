package model;

public class Chip {

    private int chipId;
    private int chipValue;

    public Chip (int chipId, int chipValue) {
        this.chipId = chipId;
        this.chipValue = chipValue;
    }

    public int getChipValue() {
        return chipValue;
    }

    public void setChipValue(int chipValue) {
        this.chipValue = chipValue;
    }

    public int getChipId() {
        return chipId;
    }

    public void setChipId(int chipId) {
        this.chipId = chipId;
    }
}
