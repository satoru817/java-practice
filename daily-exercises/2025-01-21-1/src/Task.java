//public class Task implements Comparable<Task>{
//    Integer id;
//    String title;
//    Priority priority;
//    boolean completed;
//
//    @Override
//    public int compareTo(Task t) {
//        if(t.priority.getValue() < this.priority.getValue()){
//            return 1;
//        }else if (t.priority.getValue() > this.priority.getValue()){
//            return -1;
//        }else if(this.id > t.id){
//            return 1;
//        }else if(t.id > this.id){
//            return -1;
//        }
//
//        return 0;
//    }
//}

//AIによる改善案
public class Task implements Comparable<Task>{
    private final Integer id;//finalに
    private final String title; //finalに
    private final Priority priority;//finalに

    private boolean completed;//ここはfinalにしない。（仕事が完了したら値が変わるから)

    public Task(Integer id,String title,Priority priority , boolean completed){
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.completed = completed;
    }

    //getterの追加
    public Integer getId(){return id;}
    public String getTitle(){ return title;}
    public Priority getPriority(){ return priority;}
    public boolean isCompleted(){ return completed;}


    public void setCompleted(boolean completed){
        this.completed = completed;
    }

    @Override
    public int compareTo(Task t){
        int priorityCompare = t.priority.getValue() - this.priority.getValue();
        if(priorityCompare != 0){
            return  priorityCompare;
        }

        return this.id.compareTo(t.id);
    }
}