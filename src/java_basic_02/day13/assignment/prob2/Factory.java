package java_basic_02.day13.assignment.prob2;

public abstract class Factory {
    String name;
    int openHour;
    int closeHour;

    public Factory(String name, int openHour, int closeHour) {
        this.name = name;
        this.openHour = openHour;
        this.closeHour = closeHour;
    }

    String getFactoryName() {
        return name;
    }

    int getWorkingTime() {
        return closeHour - openHour;
    }

    abstract int makeProducts(char skill);
}
