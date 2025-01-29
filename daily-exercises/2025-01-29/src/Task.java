public class Task {
    private final int id;
    private String title;
    private boolean completed;

    private Task(Builder builder){
        if(!StringUtil.isValidText(builder.title)){
            throw new IllegalArgumentException("タイトルが不正です");
        }
        this.id = builder.id;
        this.title = builder.title;
        this.completed = builder.completed;
    }

    public boolean hasSameId(Task task){
        return id == task.id;
    }

    public boolean isCompleted(){
        return completed;
    }

    public int getId(){
        return id;
    }

    public void toggleStatus(){
        completed = !completed;
    }

    public static class Builder{
        private int id;
        private String title;
        private boolean completed = false;

        public Builder(int id,String title){
            if(!StringUtil.isValidText(title)){
                throw new IllegalArgumentException("タイトルが不正です");
            }
            this.id = id;
            this.title = title;
        }

        public Builder title(String title){
            if(!StringUtil.isValidText(title)){
                throw new IllegalArgumentException("タイトルが不正です");
            }
            this.title = title;
            return this;
        }

        public Builder completed(boolean completed){
            this.completed = completed;
            return this;
        }

        public Task build(){
            return new Task(this);
        }
    }

    @Override
    public String toString(){
        return String.format(
                "Task:{ID:%s, TITLE:%s, COMPLETED:%s}",
                id,
                title,
                completed
        );
    }
}
