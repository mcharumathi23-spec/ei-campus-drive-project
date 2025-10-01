package StructuralPattern.Usecase2;

public class PriorityDecorator extends TaskDecorator {
    private String priority;

    public PriorityDecorator(ProjectComponent task, String priority) {
        super(task);
        this.priority = priority;
    }

    @Override
    public void display(int depth) {
        System.out.print("-".repeat(depth));
        System.out.println(" Task: " + task.name + " | Priority: " + priority);
    }
}
