public enum Priority {
    LOW(1),
    MEDIUM(2),
    HIGH(3);

    private final int priorityNum;

    Priority(int priorityNum){
        this.priorityNum = priorityNum;
    }
    public int getPriorityNum(){
        return priorityNum;
    }
}
